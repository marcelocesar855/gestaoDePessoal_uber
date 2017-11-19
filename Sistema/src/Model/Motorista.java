package Model;

import javax.swing.JOptionPane;

//classe filha motorista

public class Motorista extends Pessoa {
	private long idMotorista;
	private String categoriaCNH;
	private long numeroCNH;
	private float classificacao;
//construtor padrao motorista
	public Motorista() {
	}
//sobrecarga construtor motorista
 	public Motorista(long cpf, String nome, String email, String senha, long telefone, String categoriaCNH, int numeroCNH) {
        super(cpf, nome, email, senha, telefone);
		this.categoriaCNH = categoriaCNH;
		this.numeroCNH = numeroCNH;
	}
//metodos setters e getters
	public long getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(long idMotorista) {
		this.idMotorista = idMotorista;
	}
	public String getCategoriaCNH() {
		return categoriaCNH;
	}
	public void setCategoriaCNH(String categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}
	public long getNumeroCNH() {
		return numeroCNH;
	}
	public void setNumeroCNH(long numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
	public float getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(float classificacao) {
		this.classificacao = classificacao;
	}
//metodo para o motorista aceitar uma corrida solicitada
public void aceitarCorrida() {
		String cdg = JOptionPane.showInputDialog(null, "Insira o código do seu cadastro");
		int cdgInt = Integer.parseInt(cdg);
//		Main.registroCorrida.get(cdgInt).setInfoMotorista(Main.registroMotorista.get(cdgInt));
		JOptionPane.showMessageDialog(null, "Vá buscar seu cliente!");
	}
//metodo para recusar uma solicitacao de corrida
	public void recusarCorrida() {
	}
}