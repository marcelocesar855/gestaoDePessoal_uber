package Controller;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Carro;


public class CarroDAO {
	public static void cadastrarCarro() throws IOException {
		String placa = JOptionPane.showInputDialog("Qual a placa do seu carro?");
		String cor = JOptionPane.showInputDialog("Qual a cor do carro?");
		String modelo = JOptionPane.showInputDialog("Qual o modelo?");
		String marca = JOptionPane.showInputDialog("Qual a marca");
		Carro c1 = new Carro(placa, cor, modelo, marca);
		int sql = CarroRN.gravaCarro(c1);
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar cadastro.");
		}
	}
	/*Criar interface e melhorar*/
	public static void alterarCarro() throws IOException {
		String cor = JOptionPane.showInputDialog("Nova cor: ");
		String placa = JOptionPane.showInputDialog("Placa do carro que deseja alterar");
		Carro c1 = new Carro(placa, cor, null, null);
		int sql = CarroRN.updateCarro(c1);
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Alteracao realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar alteração");
		}
	}
	public static void excluirCarro(Carro carro) throws IOException {
		int sql = CarroRN.deletaCarro(carro.getIdCarro());
		if (sql > 0) {
			JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erro ao relizar exclusao");
		}
	}
	public static Carro leCarro (long id) {
		Carro c1 = CarroRN.readCarro(id);
		return c1;
	}
	public static Carro resgataDados (String placa) {
		List<Carro> carros = null;
		carros = CarroRN.leCarros();
		Carro c1 = new Carro();
		for (int i = 0; i < carros.size(); i++) {
			if (carros.get(i).getPlaca() == placa) {
				c1.setCor(carros.get(i).getCor());
				c1.setIdCarro(carros.get(i).getIdCarro());
				c1.setMarca(carros.get(i).getMarca());
				c1.setModelo(carros.get(i).getModelo());
				c1.setPlaca(carros.get(i).getPlaca());
				break;
			}
		}
		return c1;
	}
}