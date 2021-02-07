
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static Connection getConexao(){
        try{
            Connection conexao=DriverManager.getConnection("jdbc:mysql://localhost/java2", "root", "");
            return conexao;
        }catch(SQLException e){
            return null;
        }
    }
}
