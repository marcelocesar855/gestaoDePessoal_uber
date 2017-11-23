package Controller;

import Model.Corrida;

public class CorridaDAO {
	public static void montaCorrida (String destino) {
		// aqui seria resgatado o id do cliente
		long simulacao = 1;
		// aqui seria encontrado o motorista atraves da geolocalizacao
		long simulacao1 = 1;
		Corrida corrida = new Corrida(simulacao, simulacao1, destino);
		CorridaRN.gravaCorrida(corrida);
	}
}
