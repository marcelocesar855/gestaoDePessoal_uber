package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Motorista;
import Model.Pessoa;

public class MotoristaRN {
	public static int gravaMotorista(Motorista motorista) {

        int ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "INSERT INTO pessoa (nome, cpf, email, senha, telefone) VALUES (?, ?, ?, ?, ?);");
            pst.setString(1, motorista.getNome());
            pst.setLong(2, motorista.getCpf());
            pst.setString(3, motorista.getEmail());
            pst.setString(4, motorista.getSenha());
            pst.setLong(5, motorista.getTelefone());
            
            ret = pst.executeUpdate();
            
            Pessoa p1 = new Pessoa();
            p1 = PessoaDAO.resgataDados(motorista.getEmail());
            
            pst = cn.prepareStatement(
            		"INSERT INTO motorista (categoria_cnh, numero_cnh, id_pessoa) VALUES (?, ?, ?);");
            pst.setString(1, motorista.getCategoriaCNH());
            pst.setLong(2, motorista.getNumeroCNH());
            pst.setLong(3, p1.getIdPessoa());
            
            ret = pst.executeUpdate();
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static int deletaMotorista(long id) {

		int ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "DELETE FROM motorista WHERE motoristaID = ?");
            pst.setLong(1, id);
            
            ret = pst.executeUpdate();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static Motorista readMotorista (long id) {
		ResultSet rs;
		Motorista m1 = new Motorista();
		
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM motorista WHERE motoristaID = ?");
            pst.setLong(1, id);
            
            rs = pst.executeQuery();
            
            m1.setIdMotorista(rs.getLong("motoristaID"));
            m1.setCategoriaCNH(rs.getString("categoria_cnh"));
            m1.setNumeroCNH(rs.getInt("numero_cnh"));
            m1.setClassificacao(rs.getFloat("classificacao"));
            m1.setIdPessoa(rs.getLong("id_pessoa"));
            
            pst = cn.prepareStatement(
                    "SELECT * FROM pessoa WHERE pessoaID = ?");
            pst.setLong(1, m1.getIdPessoa());
            
            rs = pst.executeQuery();
            
            m1.setIdPessoa(rs.getLong("pessoaID"));
            m1.setCpf(rs.getLong("cpf"));
            m1.setNome(rs.getString("nome"));
            m1.setEmail(rs.getString("email"));
            m1.setTelefone(rs.getLong("telefone"));
        } 
        catch (SQLException e) {
        	System.out.println("Erro de SQL: " + e.getMessage());
        }
        return m1;
	}
	public static List<Motorista> leMotoristas() {
		List<Motorista> motoristas = null;
        try {
           Connection cn = GerenteDeConexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery( "SELECT * FROM motorista");
            motoristas = new ArrayList<Motorista>();
            while (rs.next()) {
                Motorista motorista = new Motorista();
                motorista.setIdMotorista(rs.getLong("motoristaID"));
                motorista.setCategoriaCNH(rs.getString("categoria_cnh"));
                motorista.setNumeroCNH(rs.getLong("numero_cnh"));
                motorista.setClassificacao(rs.getFloat("classificacao"));
                motorista.setIdPessoa(rs.getLong("id_pessoa"));

                motoristas.add(motorista);  
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return motoristas;
	}
}
