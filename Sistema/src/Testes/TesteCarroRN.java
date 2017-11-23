package Testes;

import java.io.IOException;
import java.sql.SQLException;

import Controller.CarroDAO;
import Controller.CarroRN;
import Model.Carro;

public class TesteCarroRN {

	 public static void main(String[] args) throws SQLException, IOException{
	    	Carro c1 = new Carro("jjg-3322","preto","versa", "hyundai");
	    	CarroRN.gravaCarro(c1);
	    	c1 = CarroDAO.resgataDados(c1.getPlaca());
	    	c1.setCor("azul");
	    	CarroRN.updateCarro(c1);
	    	CarroRN.readCarro(c1.getIdCarro());
	    	CarroRN.deletaCarro(c1.getIdCarro());
	    	CarroRN.leCarros();
	    }

}
