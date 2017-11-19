package Model;

import View.Main_OLD;
import javax.swing.JOptionPane;
//classe pai pessoa
public class Pessoa {
	protected long idPessoa;
	protected long cpf;
	protected String nome;
	protected String email;
	protected String senha;
	protected long telefone;
	protected String localizacao;
//construtor padrao classe pessoa
	public Pessoa () {
	}
//sobrecarga do construtor da classe pessoa
	public Pessoa(long cpf, String nome, String email, String senha, long telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}
//metodos setters e getters da classe pessoa
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
//metodo para solicitar uma corrida
	public void solicitarCorrida() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do seu cadastro");
		int cdgInt = Integer.parseInt(cdg);
//		Corrida c1 = new Corrida(Main.registroPessoa.get(cdgInt), null);
//		Main.registroCorrida.add(c1);
		JOptionPane.showMessageDialog(null, "Aguarde seu motorista...");
	}
//sobrecarga do metodo para solicitar uma corrida
        public void solicitarCorrida(String localizacao) {
		String cdg = JOptionPane.showInputDialog(null, "Insira o codigo do seu cadastro");
		int cdgInt = Integer.parseInt(cdg);
                Main_OLD.registroPessoa.get(cdgInt).setLocalizacao(localizacao);
//		Corrida c1 = new Corrida(Main.registroPessoa.get(cdgInt), null);
//		Main.registroCorrida.add(c1);
		JOptionPane.showMessageDialog(null, "Aguarde seu motorista...");
	}
//metodo para cacelar uma corrida
	public void cancelarCorrida() {
	}
}