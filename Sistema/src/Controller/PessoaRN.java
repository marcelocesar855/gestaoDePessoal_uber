package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Pessoa;

public class PessoaRN {
	public static int gravaPessoa(Pessoa pessoa) {

        int rs;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "INSERT INTO pessoa (nome, cpf, email, senha, telefone) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, pessoa.getNome());
            pst.setLong(2, pessoa.getCpf());
            pst.setString(3, pessoa.getEmail());
            pst.setString(4, pessoa.getSenha());
            pst.setLong(5, pessoa.getTelefone());
            
            rs = pst.executeUpdate();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static int updatePessoa(Pessoa pessoa) {

        int ret = 0;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "UPDATE pessoa SET nome = ?, cpf = ?, telefone = ? WHERE pessoaID = ?");
            pst.setString(1, pessoa.getNome());
            pst.setLong(2, pessoa.getCpf());
            pst.setLong(3, pessoa.getTelefone());
            pst.setLong(4, pessoa.getIdPessoa());
            
            ret = pst.executeUpdate();
            
            return ret;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static int deletaPessoa(long id) {

        int ret;
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "DELETE FROM pessoa WHERE pessoaID = ?");
            pst.setLong(1, id);
            
            ret = pst.executeUpdate();
            
            return 1;
        } 
        catch (SQLException e) {
            return -1;
        }
    }
	public static Pessoa readPessoa (long id) {
		ResultSet rs;
		Pessoa p1 = new Pessoa();
		
        try {
            Connection cn = GerenteDeConexao.criaConexao();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM pessoa WHERE pessoaID = ?");
            pst.setLong(1, id);
            
            rs = pst.executeQuery();
            
            p1.setIdPessoa(rs.getLong("pessoaID"));
            p1.setCpf(rs.getLong("cpf"));
            p1.setNome(rs.getString("nome"));
            p1.setEmail(rs.getString("email"));
            p1.setTelefone(rs.getLong("telefone"));
            
            
        } 
        catch (SQLException e) {
        	System.out.println("Erro de SQL: " + e.getMessage());
        }
        return p1;
	}
	public static List<Pessoa> lePessoas() {
		List<Pessoa> pessoas = null;
        try {
           Connection cn = GerenteDeConexao.criaConexao();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery( "SELECT * FROM pessoa");
            pessoas = new ArrayList<Pessoa>();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getLong("pessoaID"));
                pessoa.setCpf(rs.getLong("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setTelefone(rs.getLong("telefone"));
                
                pessoas.add(pessoa);
                 
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return pessoas;
	}
}
