
package persistencia;


import entidades.Categoria;
import entidades.Jogo;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


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
    public static ArrayList<Jogo> listar(){
        ArrayList<Jogo> listaJogos = new ArrayList<Jogo>();
        try {
            Connection conexao= Conexao.getConexao();
            String sql ="SELECT * FROM jogo";
            Statement st= conexao.createStatement();
            ResultSet res= st.executeQuery(sql);
            while(res.next()){
                Categoria c = new Categoria();
                c.setNome(res.getString("categoria"));
                
                Jogo j=new Jogo(c); //Associa a categoria ao jogo
                j.setDescricao(res.getString("descricao"));
                j.setId(res.getInt("id"));
                j.setPreco(res.getDouble("preco"));
                j.setNumeroDias(res.getInt("numeroDias"));
                j.setMemoria(res.getInt("memoria"));
                j.setTipo(res.getString("tipo"));
                j.setTitulo(res.getString("titulo"));
                listaJogos.add(j);
            }
        res.close();
        st.close();
        } catch (Exception e) {
            System.out.println();
        }
        finally{
            return listaJogos;
        }
        
    }
}
