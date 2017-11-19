package Controller;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Motorista;
import Model.Pessoa;

public class MotoristaDAO {
	public static void cadastrarMotorista() throws IOException {
		String nome = JOptionPane.showInputDialog("Qual seu nome?");
		String cpf = JOptionPane.showInputDialog("Qual seu CPF?");
		long cpfLong = Long.parseLong(cpf);
		String telefone = JOptionPane.showInputDialog("Qual seu numero para contato?");
		long telefoneLong = Long.parseLong(telefone);
		String email = JOptionPane.showInputDialog("Qual seu email?");
		String senha = JOptionPane.showInputDialog("Defina uma senha");
		String cnh = JOptionPane.showInputDialog("Qual a categoria da sua CNH?");
		String numeroCnh = JOptionPane.showInputDialog("Qual o numero de sua CNH?");
		int cnhInt = Integer.parseInt(numeroCnh);
		Motorista m1 = new Motorista(cpfLong, nome, email, senha, telefoneLong, cnh, cnhInt);
		int sql = MotoristaRN.gravaMotorista(m1);
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar cadastro.");
		}
	}
	public static void alterarMotorista() throws IOException {
		String nome = JOptionPane.showInputDialog("Novo nome: ");
		String cpf = JOptionPane.showInputDialog("Novo CPF: ");
		long cpfLong = Long.parseLong(cpf);
		String telefone = JOptionPane.showInputDialog("Novo telefone: ");
		long telefoneLong = Long.parseLong(telefone);
		String email = JOptionPane.showInputDialog("Email do cadastro que deseja alterar: ");
		Pessoa p1 = new Pessoa (cpfLong, nome, email, null, telefoneLong);
		int sql = PessoaRN.updatePessoa(p1);
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Alteracao realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar alteração.");
		}
	}
	public static void excluirMotorista() throws IOException {
		String numeroCnh = JOptionPane.showInputDialog("CNH do motorista que deseja excluir: ");
		int numeroCnhInt = Integer.parseInt(numeroCnh);
		Motorista m1 = MotoristaDAO.resgataDados(numeroCnhInt);
		int sql = MotoristaRN.deletaMotorista(m1.getIdMotorista());
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar exclusao.");
		}
	}
	public static Motorista leMotorista (long id) {
		Motorista m1 = MotoristaRN.readMotorista(id);
		return m1;
		
	}
	public static Motorista resgataDados (long numeroCnh) {
		List<Motorista> motoristas = null;
		motoristas = MotoristaRN.leMotoristas();
		Motorista m1 = new Motorista();
		for (int i = 0; i < motoristas.size(); i++) {
			if (motoristas.get(i).getNumeroCNH() == numeroCnh) {
				m1.setIdPessoa(motoristas.get(i).getIdPessoa());
				m1.setIdMotorista(motoristas.get(i).getIdMotorista());
				m1.setCpf(motoristas.get(i).getCpf());
				m1.setNome(motoristas.get(i).getNome());
				m1.setEmail(motoristas.get(i).getEmail());
				m1.setSenha(motoristas.get(i).getSenha());
				m1.setTelefone(motoristas.get(i).getTelefone());
				m1.setCategoriaCNH(motoristas.get(i).getCategoriaCNH());
				m1.setNumeroCNH(motoristas.get(i).getNumeroCNH());
			}
		}
		return m1;
	}
}
