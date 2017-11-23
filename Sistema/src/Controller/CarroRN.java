package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Carro;


public class CarroRN {
	public static int gravaCarro(Carro carro) {

        int ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "INSERT INTO carro (placa, cor, modelo, marca) VALUES (?, ?, ?, ?)");
            pst.setString(1, carro.getPlaca());
            pst.setString(2, carro.getCor());
            pst.setString(3, carro.getModelo());
            pst.setString(4, carro.getMarca());
            
            ret = pst.executeUpdate();
            
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
                    "UPDATE carro SET cor = ? WHERE carroID = ?");
            pst.setString(1, carro.getCor());
            pst.setLong(2, carro.getIdCarro());
            
            ret = pst.executeUpdate();
            
            return ret;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static int deletaCarro(long id) {

        int ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "DELETE FROM carro WHERE carroID = ?");
            pst.setLong(1, id);
            
            ret = pst.executeUpdate();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static Carro readCarro (long id) {
		ResultSet rs;
		Carro c1 = new Carro();
		
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM carro WHERE carroID = ?");
            pst.setLong(1, id);
            
            rs = pst.executeQuery();
            
            c1.setIdCarro(rs.getLong("carroID"));
            c1.setCor(rs.getString("cor"));
            c1.setMarca(rs.getString("marca"));
            c1.setPlaca(rs.getString("placa"));
            c1.setModelo(rs.getString("modelo"));
            
        } 
        catch (SQLException e) {
        	System.out.println("Erro de SQL: " + e.getMessage());
        }
        return c1;
	}
	public static List<Carro> leCarros() {
		List<Carro> carros = null;
        try {
           Connection cn = GerenteDeConexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery( "SELECT * FROM carro");
            carros = new ArrayList<Carro>();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setIdCarro(rs.getLong("carroID"));
                carro.setCor(rs.getString("cor"));
                carro.setMarca(rs.getString("marca"));
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                
                carros.add(carro);
                 
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return carros;
	}
}
