
package persistencia;


import entidades.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class JogoDao {
    public static boolean inserir(Jogo jogo){
        try {
            Connection conexao=Conexao.getConexao();
            String sql= "INSERT INTO jogo (titulo, descricao, preco, numeroDias, "
                    + "categoria, memoria, tipo) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement ps=conexao.prepareStatement(sql);
            ps.setString(1, jogo.getTitulo());
            ps.setString(2, jogo.getDescricao());
            ps.setDouble(3, jogo.getPreco());
            ps.setInt(4, jogo.getNumeroDias());
            ps.setString(5,jogo.getCategoria().getNome());
            ps.setInt(6, jogo.getMemoria());
            ps.setString(7, jogo.getTipo());
            int resultado=ps.executeUpdate();
            ps.close();
            return resultado >0;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean alterar(Jogo jogo){
        try {
            Connection conexao=Conexao.getConexao();
            String sql= "UPDATE jogo SET "
                    +"titulo=?, descricao=?, preco=?, numeroDias=?, "
                    + "categoria=?, memoria=?, tipo= ? "
                    +"WHERE id= ?";
            
            PreparedStatement ps=conexao.prepareStatement(sql);
            ps.setString(1, jogo.getTitulo());
            ps.setString(2, jogo.getDescricao());
            ps.setDouble(3, jogo.getPreco());
            ps.setInt(4, jogo.getNumeroDias());
            ps.setString(5,jogo.getCategoria().getNome());
            ps.setInt(6, jogo.getMemoria());
            ps.setString(7, jogo.getTipo());
            ps.setInt(8, jogo.getId());
            int resultado=ps.executeUpdate();
            ps.close();
            return resultado >0;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean excluir(int id){
       
        try{
            Connection conexao=Conexao.getConexao();
            String sql= "DELETE FROM jogo WHERE id= ?";
            PreparedStatement ps=conexao.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado=ps.executeUpdate();
            ps.close();
            return resultado >0;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}
