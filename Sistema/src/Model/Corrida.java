package Model;
//classe corrida
public class Corrida {
	private String destino;
	private long idPassageiro;
	private long idMotorista;
//contrutor padrao da classe carro
	public Corrida() {
	}
//sobrecarga do contrutor da classe carro
	public Corrida(long idPassageiro, long idMotorista, String destino) {
		this.idPassageiro = idPassageiro;
		this.idMotorista = idMotorista;
		this.destino = destino;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public long getIdPassageiro() {
		return idPassageiro;
	}
	public void setIdPassageiro(long idPassageiro) {
		this.idPassageiro = idPassageiro;
	}
	public long getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(long idMotorista) {
		this.idMotorista = idMotorista;
	}
}