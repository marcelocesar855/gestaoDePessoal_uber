package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Carro;

public class CarroRN {
	public static int gravaCarro(Carro carro) {

        ResultSet ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "INSERT INTO carro (placa, cor, modelo, marca) VALUES (?, ?, ?, ?)");
            pst.setString(1, carro.getPlaca());
            pst.setString(2, carro.getCor());
            pst.setString(3, carro.getModelo());
            pst.setString(4, carro.getMarca());
            
            ret = pst.executeQuery();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static int updateCarro(Carro carro) {

        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "UPDATE carro SET cor = ? WHERE placa = ?");
            pst.setString(1, carro.getCor());
            pst.setString(2, carro.getPlaca());
            
            ret = pst.executeUpdate();
            
            return ret;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static int deletaCarro(Carro carro) {

        ResultSet ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "DELETE FROM carro WHERE placa = ?");
            pst.setString(1, carro.getPlaca());
            
            ret = pst.executeQuery();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
}
