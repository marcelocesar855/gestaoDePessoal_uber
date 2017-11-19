package Controller;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Pessoa;

public class PessoaDAO {
	public static void cadastrarPessoa(Pessoa p1) throws IOException {
		int sql = PessoaRN.gravaPessoa(p1);
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar cadastro.");
		}
	}
	
	public static void alterarPessoa(Pessoa p1) throws IOException {
				int sql = PessoaRN.updatePessoa(p1);
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Alteracao realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar alteração.");
		}
	}
	
	public static void excluirPessoa(Pessoa pessoa) throws IOException {
		int sql = PessoaRN.deletaPessoa(pessoa.getIdPessoa());
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar exclusao.");
		}
	}
	public static Pessoa lePessoa (long id) {
		Pessoa p1 = PessoaRN.readPessoa(id);
		return p1;
	}
	public static Pessoa resgataDados (String email) {
		List<Pessoa> pessoas = null;
		pessoas = PessoaRN.lePessoas();
		Pessoa p1 = new Pessoa();
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getEmail().equals(email)) {
				p1.setIdPessoa(pessoas.get(i).getIdPessoa());
				p1.setCpf(pessoas.get(i).getCpf());
				p1.setNome(pessoas.get(i).getNome());
				p1.setEmail(pessoas.get(i).getEmail());
				p1.setSenha(pessoas.get(i).getSenha());
				p1.setTelefone(pessoas.get(i).getTelefone());

			}
		}
		return p1;
	}
}

