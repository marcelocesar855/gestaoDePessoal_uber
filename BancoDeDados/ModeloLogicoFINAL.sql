create database if not exists pessoal;
use pessoal;

/* TABLEAS */
create table if not exists imagem (
id_img bigint not null auto_increment primary key,
nome varchar (50),
dados longblob 
);

create table if not exists pessoa (
pessoaID bigint not null AUTO_INCREMENT primary key,
nome varchar(45)  not null,
cpf bigint(11) not null UNIQUE,
email  varchar(45) not null unique,
senha varchar (20)  not null,
telefone bigint (14) not null,
localizacao varchar(45));


create table if not exists carro (
carroID bigint not null AUTO_INCREMENT primary key,
placa varchar(8) not null unique,
cor varchar (15) not null,
modelo varchar(20) not null,
marca varchar (20) not null
);

create table if not exists motorista (
motoristaID bigint not null AUTO_INCREMENT primary key,
categoria_cnh varchar (1) not null,
numero_cnh bigint (11) not null unique,
classificacao float (5) not null default 5,
id_pessoa bigint not null,
id_carro bigint,
foreign key (id_carro) references carro (carroID)
on delete cascade
on update cascade,
foreign key (id_pessoa) references pessoa (pessoaID)
on delete cascade
on update cascade
)ENGINE=INNODB;

create table if not exists corrida (
corridaID bigint not null AUTO_INCREMENT primary key,
destino varchar (45) not null,
id_motorista bigint not null,
id_pessoa bigint not null,
foreign key (id_pessoa) references pessoa (pessoaID)
on delete cascade
on update cascade,
foreign key (id_motorista) references motorista (motoristaID)
on delete cascade
on update cascade
)ENGINE=INNODB;

create table log_motorista(
id_motorista int auto_increment primary key not null,
old_categoria_cnh varchar (1),
new_categoria_cnh varchar (1) default null,
old_cor varchar(15),
new_cor varchar(15) default null,
old_senha varchar (20),
new_senha varchar (20) default null,
acao varchar (45),
usuario varchar(45),
hora timestamp);

/* VIEWS */

create view VW_info_motorista (nome,telefone,classificacao,placa,cor,modelo,marca) as 
select nome,telefone,classificacao,placa,cor,modelo,marca 
from motorista as m inner join carro as c on m.id_carro = c.carroID inner join pessoa as p on p.pessoaID = m.id_pessoa
where m.motoristaID = 1; 

create view VW_info_pessoa (nome,telefone,localizacao) as
select nome,telefone,localizacao
from pessoa as p 	
where p.pessoaID =1;

create view VW_info_corrida (destino) as
select destino
from corrida as c
where c.corridaID = 1;

create view VW_alta_classificacao as
select classificacao,motoristaID,nome,email
from motorista as m inner join pessoa as p on m.motoristaID = p.pessoaID
where classificacao >= 4.5;

create view VW_baixa_classificacao as
select classificacao,motoristaID,nome,email
from motorista as m inner join pessoa as p on m.motoristaID = p.pessoaID
where classificacao <= 1.5;

create view VW_corrida_detalhada as
select destino,nome,corridaID,motoristaID
from motorista as m inner join pessoa as p on motoristaID = pessoaID inner join corrida as c on c.id_motorista = m.motoristaID;

/*TRIGGER QUE REFERENCIAM TABELA LOG */

DELIMITER $$
create trigger TR_log_motorista after update on motorista
for each row 
BEGIN
insert into log_motorista (old_categoria_cnh,new_categoria_cnh,acao,usuario,hora)
values (old.categoria_cnh,new.categoria_cnh,'update', user(),now());
end $$

DELIMITER $$
create trigger TR_senha after update on pessoa  
for each row
BEGIN
insert into log_motorista (old_senha,new_senha,acao,usuario,hora)
values (old.senha,new.senha,'update',user(),now());
end $$
 
DELIMITER &&
create trigger TR_cor after update on carro
for each row
BEGIN
insert into log_motorista (old_cor,new_cor,acao,usuario,hora)
values (old.cor,new.cor,'update',user(),now());
end &&


/* STORED PROCEDURES */
DELIMITER $$
CREATE PROCEDURE PD_inserir_motorista (in nomeIN varchar(45), in cpfIN bigint, in emailIN varchar(45),
in senhaIN varchar(20), in telefoneIN  bigint, in categoria_cnhIN varchar(1), in numero_cnhIN bigint)
begin
insert into pessoa (nome, cpf, email, senha, telefone) values (nomeIN, cpfIN, emailIN, senhaIN, telefoneIN);
insert into motorista (categoria_cnh, numero_cnh, id_pessoa) values (categoria_cnhIN, numero_cnhIN, pessoa.pessoaID);
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE PD_consultar_motorista ()
begin
select * from VW_info_motorista;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE PD_inserir_carro (in placaIN varchar(8), in corIN varchar(15), in modeloIN varchar(20), in marca varchar(20))
begin
insert into carro (placa, cor, modelo, marca) values (placaIN, corIN, modeloIN, marcaIN);
end $$
DELIMITER ;

/*INDEX CRIADOS PARA MELHORAR AS CONSULTAS MAIS DECORRENTES DO BANCO*/

/*index necessario para apresentacao das informacoes de contato do passageiro para o motorista contactar o mesmo*/
create index idx_consulta_contatos_pessoa
on pessoa (nome, email, telefone);
/*index necessario para apresentacao das informacoes de registros legais do motorista*/
create index idx_consulta_motorista
on motorista (categoria_cnh, numero_cnh);
/*index necessario para apresentacao de informacoes sobre o carro do motorista para identificacao pelo passageiro na hora do embarque*/
create index idx_consulta_carro
on carro (placa, modelo, marca);

/* BLOBS CRIADOS NA TABELA IMAGM */
insert into imagem (nome,dados) 
values ('bojack', LOAD_FILE("‪E:\Downloads\wallup-312234.jpg"));	

insert into imagem (nome,dados) 
values ('bojack2', LOAD_FILE("E:\Downloads\Captura de Tela (111).png"));

insert into imagem (nome,dados) 
values ('bojack3', LOAD_FILE("E:\Downloads\Captura de Tela (122).png"));

select dados INTO OUTFILE "E:\Downloads\wallup-312234.jpg"
from imagem
where id_img = 1; 

select dados INTO OUTFILE "E:\Downloads\Captura de Tela (111).png"
from imagem
where id_img = 2; 

select dados INTO OUTFILE "E:\Downloads\Captura de Tela (122).png"
from imagem
where id_img = 3; 

/*INSERTS ADICIONADOS NO BANCO*/
insert into carro (placa,cor,modelo,marca)
values('pao-0123','azul','gol','volkwager');

insert into carro (placa,cor,modelo,marca)
values('ppo-8838','prata','uno','fiat');

insert into carro (placa,cor,modelo,marca)
values('jjk-6138','vermelho','polo','volkswagen');

insert into pessoa (nome,cpf,email,senha, telefone)
values('Saitama',12345678954,'saitama@hotmail.com',123456, 64646464);

insert into pessoa (nome,cpf,email,senha,telefone)
values('Genos',12345678963,'genos@hotmail.com',15468723,655654654);

insert into pessoa (nome,cpf,email,senha,telefone)
values('Masamune',12456874512,'masamune@hotmail.com',15478723,25266216);

insert into pessoa (nome,cpf,email,senha,telefone)
values ('Marcos',11111111111,'marcos@hotmail.com',1234787,88888888);

insert into pessoa (nome,cpf,email,senha,telefone)
values ('roberval',45156554778,'robervalmaravilha@hotmail.com',66613,99999999);

insert into pessoa (nome,cpf,email,senha,telefone)
values('ricardo',22225252525,'ricardolopes@hotmail.com',6669542,7777777777);

insert into motorista(categoria_cnh,numero_cnh,classificacao,id_pessoa,id_carro)
values('c','12345678945','4.5',1,1);

insert into motorista(categoria_cnh,numero_cnh,classificacao,id_pessoa,id_carro)
values('c','12345698745','4',2,2);

insert into motorista (categoria_cnh,numero_cnh,classificacao,id_pessoa,id_carro)
values('c','92345698745','5',3,3);

insert into corrida (destino, id_motorista,id_pessoa)
values('Taguatinga shopping',1,4);

insert into corrida (destino, id_motorista,id_pessoa)
values('Park shopping',2,5);

insert into corrida (destino, id_motorista,id_pessoa)
values('Tagua Parque',3,6);



/* UPDATES */

update motorista
set categoria_cnh = 'b'
where motoristaID = 2;

update motorista 
set categoria_cnh = 'b'
where motoristaID = 1;

update carro 
set cor = 'preto'
where carroID = 1;

update motorista 
set classificacao = 1.2
where motoristaID = 2;

update carro
set placa = 'gol-1000'
where carroID = 2;

update pessoa
set cpf = 85642365874
where cpf = 12345678954;


/*DELETES*/
delete from motorista 
where motoristaID = 1 ;

delete from carro
where carroID = 2;

delete from pessoa
where pessoaID = 3;


/*SELECTS*/
select placa, cor, modelo, marca 
from carro as c join motorista as m on m.id_carro = c.carroID 
where m.motoristaID = 2;

select cpf,nome from pessoa as p left join motorista as m on m.id_pessoa = p.pessoaID
where m.classificacao = 5;

select nome from pessoa as p join motorista as m on p.pessoaID = m.id_pessoa
where m.categoria_cnh = 'b'
order by nome asc;










