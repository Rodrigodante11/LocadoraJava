
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
    private static final String URL="jdbc:mysql://localhost/java2";
    private static final String USER="root";
    private static final String PASS="";
    public static Connection getConexao(){
        try{
            Connection C=DriverManager.getConnection(URL, USER, PASS);
            return C;
        }catch(Exception e){
            return null;
        }
    }
}
