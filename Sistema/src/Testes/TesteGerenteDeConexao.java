
package Testes;

import java.sql.SQLException;
import Controller.GerenteDeConexao;


public class TesteGerenteDeConexao {

    public static void main(String[] args) throws SQLException{

        System.out.println(GerenteDeConexao.testaConexao());
    }

}