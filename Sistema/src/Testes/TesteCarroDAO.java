package Testes;

import java.io.IOException;

import Controller.CarroDAO;

public class TesteCarroDAO {

	public static void main(String[] args) {
		try {
			CarroDAO.cadastrarCarro();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
