package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author eduardo
 */
public class GerenteDeConexao {

    public static Connection testaConexao() throws SQLException {
        Connection cn = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Driver carregado!!!");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/pessoal",
                    "root", null);
            System.out.println("Conex√£o efetuada com sucesso!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver nao encontrado");
        }
        return cn;
    }
    
    public static Connection criaConexao() throws SQLException {
        Connection cn = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/pessoal",
                    "root", null);
        } catch (ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "Erro ao tentar estabelecer conex„o com o banco.");
        }
        return cn;
    }
}