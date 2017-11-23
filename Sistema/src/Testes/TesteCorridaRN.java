package Testes;

import Controller.CorridaRN;
import Model.Corrida;

public class TesteCorridaRN {

	public static void main(String[] args) {
		Corrida corrida = new Corrida(1, 1, "Praça do Buriti");
		CorridaRN.gravaCorrida(corrida);
	}

}
