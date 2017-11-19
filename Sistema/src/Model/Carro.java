package Model;
//classe carro
public class Carro {
	private long idCarro;
	private String placa;
	private String cor;
	private String modelo;
	private String marca;
//construtor padrao da classe carro
	public Carro () {
	}
//sobrecarga do construtor da classe carro
	public Carro(String placa, String cor, String modelo, String marca) {
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
		this.marca = marca;
	}
//metodos getters e setters da classe carro
	public String getPlaca() {
		return placa;
	}
	public long getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(long idCarro) {
		this.idCarro = idCarro;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}