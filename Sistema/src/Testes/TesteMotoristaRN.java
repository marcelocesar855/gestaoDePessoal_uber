package Testes;


import java.io.IOException;
import java.sql.SQLException;

import Controller.MotoristaDAO;
import Controller.MotoristaRN;
import Controller.PessoaRN;
import Model.Motorista;

public class TesteMotoristaRN {

    public static void main(String[] args) throws SQLException, IOException{
    	Motorista m1 = new Motorista(777555333, "Robson", "robson@teste", "robsonocara", 88556699, "B", 57863944);
//    	MotoristaRN.gravaMotorista(m1);
    	m1 = MotoristaDAO.resgataDados(m1.getNumeroCNH());
//    	MotoristaRN.readMotorista(m1.getIdMotorista());
//    	MotoristaRN.deletaMotorista(m1.getIdMotorista());
//    	MotoristaRN.leMotoristas();
    }
}