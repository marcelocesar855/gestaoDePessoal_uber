package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Corrida;

public class CorridaRN {
	public static int gravaCorrida(Corrida corrida) {

        ResultSet ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "INSERT INTO corrida (destino, id_pessoa, id_motorista) VALUES (?, ?, ?)");
            pst.setString(1, corrida.getDestino());
            pst.setLong(2, corrida.getIdPassageiro());
            pst.setLong(3, corrida.getIdMotorista());
            
            ret = pst.executeQuery();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
}
