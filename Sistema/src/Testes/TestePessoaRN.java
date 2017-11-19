package Testes;

import java.io.IOException;
import java.sql.SQLException;
import Controller.PessoaDAO;
import Controller.PessoaRN;
import Model.Pessoa;

public class TestePessoaRN {

    public static void main(String[] args) throws SQLException, IOException{
    	Pessoa p1 = new Pessoa(000666777444,"Joselito","joselito@teste", "senhadojoselito", 88775533);
    	PessoaRN.gravaPessoa(p1);
    	p1 = PessoaDAO.resgataDados(p1.getEmail());
    	p1.setTelefone(555555555);
    	PessoaRN.updatePessoa(p1);
    	PessoaRN.readPessoa(p1.getIdPessoa());
    	PessoaRN.deletaPessoa(p1.getIdPessoa());
    	PessoaRN.lePessoas();
    }
}