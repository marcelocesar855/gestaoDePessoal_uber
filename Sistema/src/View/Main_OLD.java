package View;

import Model.Carro;
import Model.Corrida;
import Model.Motorista;
import Model.Pessoa;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main_OLD {
//arreylist para registro de objetos do tipo Pessoa
	public static ArrayList<Pessoa> registroPessoa = new ArrayList<Pessoa>();
//arraylist para registro de objetos do tipo Motorista
	public static ArrayList<Motorista> registroMotorista = new ArrayList<Motorista>();
//arraylist para registro de objetos do tipo Carro
	public static ArrayList<Carro> registroCarro = new ArrayList<Carro>();
//arraylist para registro de objetos do tipo Corrida
	public static ArrayList<Corrida> registroCorrida = new ArrayList<Corrida>();

	public static void main(String[] args) {
//array do tipo objeto para JOptionPane com lista de opcoes
		Object[] opcoes = {"Passageiro","Motorista"};
		Object resposta;
//JOptionPane para identificação do cliente
		resposta = JOptionPane.showInputDialog(null,"Quem e voce?","Identificacao",
		JOptionPane.PLAIN_MESSAGE,null,opcoes,null);
//if para identificação do cliente como passageiro
		if (resposta == "Passageiro") {
			JOptionPane.showMessageDialog(null, "Ola passageiro!\n"
			+ "Vamos cadastra-lo ao sistema para com que voce possa solicitar seu motorista!");
//metodo para cadastro de passageiro
			cp();
//menu principal passageiro
			while (true){
				String menu;
				menu = JOptionPane.showInputDialog(null,"O que deseja fazer?\n"
				+ "1 - Cadastrar novo passageiro\n"
				+ "2 - Alterar cadastro\n"
				+ "3 - Consultar cadastro\n"
				+ "4 - Excluir cadastro\n"
				+ "5 - Solicitar corrida\n"
				+ "0 - Sair");
				int respostaMenu = Integer.parseInt(menu);
				switch (respostaMenu) {
//caso que chama metodo para cadastro de pessoas
					case 1 : cp();break;
//caso que chama metodo para alteração de cadastro
					case 2 : ap();break;
//caso que chama metodo para visualização de cadastro
					case 3 : sp();break;
//caso que chama metodo para exclusao de cadastro
					case 4 : ep();break;
//caso que chama metodo para solicitacao de corrida
					case 5 : int definir = JOptionPane.showConfirmDialog(null, "Quer definir a localização de embarque manualmente?");
//if que chama sobrecarga de metodo para solicitacao de corrida
						if (definir == 0){
                                                    String localizacao = JOptionPane.showInputDialog(null, "Insira seu endereço:");
                                                    Pessoa p3 = new Pessoa();
                                                    p3.solicitarCorrida(localizacao);
                                                }
//else que chama metodo para solicitacao de corrida
                                                else{
                                                    Pessoa p2 = new Pessoa();
                                                    p2.solicitarCorrida();
                                                };
//caso que encerra o menu
					case 0 : System.exit(0);
					default : JOptionPane.showMessageDialog(null, "Comando desconhecido!");
				}
			}
		}
//if para identificacao do cliente como motorista
		if (resposta == "Motorista") {
			JOptionPane.showMessageDialog(null, "Ola motorista!\n"
			+ "Vamos cadastra-lo ao sistema para com que voce possa realizar suas corridas!");
//metodo para cadastro de motorista
			cm();
//menu principal do motorista
			while (true){
				String menu;
				menu = JOptionPane.showInputDialog(null,"O que deseja fazer?\n"
				+ "1 - Cadastrar novo motorista\n"
				+ "2 - Alterar cadastro\n"
				+ "3 - Consultar cadastro\n"
				+ "4 - Excluir cadastro\n"
				+ "5 - Cadastrar novo carro\n"
				+ "6 - Alterar cor de carro\n"
				+ "7 - Excluir carro\n"
				+ "8 - Consultar cadastro de carro\n"
				+ "0 - Sair");
				int respostaMenu = Integer.parseInt(menu);
				switch (respostaMenu) {
//caso que chama metodo para cadastro de motorista
					case 1 : cm();break;
//caso que chama metodo para alteracao de cadastro
					case 2 : am();break;
//caso que chama metodo para visualizacao de cadastro
					case 3 : sm();break;
//caso que chama metodo para esclusao de cadastro
					case 4 : em();break;
//caso que chama metodo para cadastro de carro
					case 5 : cc();break;
//caso que chama metodo para alteracao de cadastro de carro
					case 6 : ac();break;
//caso que chama metodo para esclusao de cadastro de carro
					case 7 : ec();break;
//caso que chama metodo para visualizacao de cadastro
					case 8 : sc();break;
// caso para sair do menu
					case 0 : System.exit(0);
					default : JOptionPane.showMessageDialog(null, "Comando desconhecido!");
				}
			}
		}
//else para sair do menu
		else {
			System.exit(0);
		}
	}
//metodo para cadastro de pessoa
	public static void cp() {
		String nome = JOptionPane.showInputDialog("Qual seu nome?");
		String cpf = JOptionPane.showInputDialog("Qual seu CPF?");
		int cpfInt = Integer.parseInt(cpf);
		String telefone = JOptionPane.showInputDialog("Qual seu numero para contato?");
		int telefoneInt = Integer.parseInt(telefone);
		String email = JOptionPane.showInputDialog("Qual seu email?");
		String senha = JOptionPane.showInputDialog("Defina uma senha");
		Pessoa p1 = new Pessoa(cpfInt, nome, email, senha, telefoneInt);
		registroPessoa.add(p1);
		JOptionPane.showMessageDialog(null, "O codigo do seu cadastro e: " + registroPessoa.indexOf(p1));
	}
//metodo para visualizacao de cadastro de pessoa
	public static void sp() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do cadastro que deseja consultar");
		int cdgInt = Integer.parseInt(cdg);
	       if (registroPessoa.size()-1 >=cdgInt && cdgInt >=0){
	    	   JOptionPane.showMessageDialog(null,"Nome: " + registroPessoa.get(cdgInt).getNome()+ "\n"
	    		+ "CPF: " + registroPessoa.get(cdgInt).getCpf() + "\n"
	    		+ "Telefone: " + registroPessoa.get(cdgInt).getTelefone() + "\n"
	    		+ "Email: " + registroPessoa.get(cdgInt).getEmail());
	       }
	       else{
           		JOptionPane.showMessageDialog(null, "Cadastro inexistente!");
           }
	}
//metodo para exclusao de pessoa
	public static void ep() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o ccdigo do cadastro que deseja apagar", "Apagar", JOptionPane.PLAIN_MESSAGE);
		int cdgInt = Integer.parseInt(cdg);
        if (registroPessoa.size()-1 >=cdgInt && cdgInt >=0){
            registroPessoa.remove(cdgInt);
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso!");
        }
        else{
            	JOptionPane.showMessageDialog(null, "Cadastro inexistente!");
            }
	}
//metodo para alteracao de cadastro de pessoa
	public static void ap() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o ccdigo do cadastro que deseja alterar");
		int cdgInt = Integer.parseInt(cdg);
		if (registroPessoa.size()-1 >=cdgInt && cdgInt >=0){
			String nome = JOptionPane.showInputDialog("Novo nome: ");
			registroPessoa.get(cdgInt).setNome(nome);
			String cpf = JOptionPane.showInputDialog("Novo CPF: ");
			int cpfInt = Integer.parseInt(cpf);
			registroPessoa.get(cdgInt).setCpf(cpfInt);
			String telefone = JOptionPane.showInputDialog("Novo telefone: ");
			int telefoneInt = Integer.parseInt(telefone);
			registroPessoa.get(cdgInt).setTelefone(telefoneInt);
		}
		else{
        	JOptionPane.showMessageDialog(null, "Cadastro inexistente!");
        }
	}
//metodo para cadastro de motorista
	public static void cm () {
		String nome = JOptionPane.showInputDialog("Qual seu nome?");
		String cpf = JOptionPane.showInputDialog("Qual seu CPF?");
		int cpfInt = Integer.parseInt(cpf);
		String telefone = JOptionPane.showInputDialog("Qual seu numero para contato?");
		int telefoneInt = Integer.parseInt(telefone);
		String email = JOptionPane.showInputDialog("Qual seu email?");
		String senha = JOptionPane.showInputDialog("Defina uma senha");
		String cnh = JOptionPane.showInputDialog("Qual a categoria da sua CNH?");
		String numeroCnh = JOptionPane.showInputDialog("Qual o numero de sua CNH?");
		int cnhInt = Integer.parseInt(numeroCnh);
		Motorista m1 = new Motorista(cpfInt, nome, email, senha, telefoneInt, cnh, cnhInt);
		registroMotorista.add(m1);
		JOptionPane.showMessageDialog(null, "O codigo do seu cadastro e: " + registroMotorista.indexOf(m1));
	}
//metodo para alteracao de cadastro
	public static void am() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do cadastro que deseja alterar");
		int cdgInt = Integer.parseInt(cdg);
		if (registroMotorista.size()-1 >=cdgInt && cdgInt >=0){
			String nome = JOptionPane.showInputDialog("Novo nome: ");
			registroMotorista.get(cdgInt).setNome(nome);
			String cpf = JOptionPane.showInputDialog("Novo CPF: ");
			int cpfInt = Integer.parseInt(cpf);
			registroMotorista.get(cdgInt).setCpf(cpfInt);
			String telefone = JOptionPane.showInputDialog("Novo telefone: ");
			int telefoneInt = Integer.parseInt(telefone);
			registroMotorista.get(cdgInt).setTelefone(telefoneInt);
		}
		else{
        	JOptionPane.showMessageDialog(null, "Cadastro inexistente!");
        }
	}
//metodo para visualizacao de cadastro de motorista
	public static void sm() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do cadastro que deseja consultar");
		int cdgInt = Integer.parseInt(cdg);
	       if (registroMotorista.size()-1 >=cdgInt && cdgInt >=0){
	    	   JOptionPane.showMessageDialog(null,"Nome: " + registroMotorista.get(cdgInt).getNome()+ "\n"
	    		+ "CPF: " + registroMotorista.get(cdgInt).getCpf() + "\n"
	    		+ "Telefone: " + registroMotorista.get(cdgInt).getTelefone() + "\n"
	    		+ "Email: " + registroMotorista.get(cdgInt).getEmail() + "\n"
	    		+ "Categoria CNH: " + registroMotorista.get(cdgInt).getCategoriaCNH() + "\n"
	    		+ "Numero CNH: " + registroMotorista.get(cdgInt).getNumeroCNH());
	       }
	       else{
           		JOptionPane.showMessageDialog(null, "Cadastro inexistente!");
           }
	}
//metodo para exclusao de motorista
	public static void em() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do cadastro que deseja apagar", "Apagar", JOptionPane.PLAIN_MESSAGE);
		int cdgInt = Integer.parseInt(cdg);
        if (registroMotorista.size()-1 >=cdgInt && cdgInt >=0){
            registroMotorista.remove(cdgInt);
            JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso!");
        }
        else{
            	JOptionPane.showMessageDialog(null, "Cadastro inexistente!");
            }
	}
// metodo para cadastro de carro
	public static void cc() {
		String placa = JOptionPane.showInputDialog("Qual a placa do seu carro?");
		String cor = JOptionPane.showInputDialog("Qual a cor do carro?");
		String modelo = JOptionPane.showInputDialog("Qual o modelo?");
		String marca = JOptionPane.showInputDialog("Qual a marca");
		Carro c1 = new Carro(placa, cor, modelo, marca);
		registroCarro.add(c1);
		JOptionPane.showMessageDialog(null, "O codigo do seu cadastro e: " + registroCarro.indexOf(c1));
	}
// metodo para alteracao de cadastro de carro
	public static void ac() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do carro que deseja alterar a cor");
		int cdgInt = Integer.parseInt(cdg);
		if (registroCarro.size()-1 >=cdgInt && cdgInt >=0){
			String cor = JOptionPane.showInputDialog("Nova cor: ");
			registroCarro.get(cdgInt).setCor(cor);
		}
		else{
        	JOptionPane.showMessageDialog(null, "Carro inexistente!");
        }
	}
//metodo para exclusao de carro
	public static void ec() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do carro que deseja apagar", "Apagar", JOptionPane.PLAIN_MESSAGE);
		int cdgInt = Integer.parseInt(cdg);
        if (registroCarro.size()-1 >=cdgInt && cdgInt >=0){
            registroCarro.remove(cdgInt);
            JOptionPane.showMessageDialog(null, "Carro apagado com sucesso!");
        }
        else{
            	JOptionPane.showMessageDialog(null, "Carro inexistente!");
            }
	}
//metodo para visualizacao de cadastro de carro
	public static void sc() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do carro que deseja consultar");
		int cdgInt = Integer.parseInt(cdg);
	       if (registroCarro.size()-1 >=cdgInt && cdgInt >=0){
	    	   JOptionPane.showMessageDialog(null,"Placa: " + registroCarro.get(cdgInt).getPlaca()+ "\n"
	    		+ "Cor: " + registroCarro.get(cdgInt).getCor() + "\n"
	    		+ "Modelo: " + registroCarro.get(cdgInt).getModelo() + "\n"
	    		+ "Marca: " + registroCarro.get(cdgInt).getMarca());
	       }
	       else{
           		JOptionPane.showMessageDialog(null, "Carro inexistente!");
           }
	}
}