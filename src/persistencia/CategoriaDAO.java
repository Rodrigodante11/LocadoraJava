
package persistencia;

import entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CategoriaDAO {
    public static boolean inserir(Categoria categoria)
    {
        try{
          Connection conexao=Conexao.getConexao();
          String sql="INSERT INTO categoria (nome,tipo) "
                  + "VALUES (?,?)";
          
          PreparedStatement comando=conexao.prepareStatement(sql);
          comando.setString(1,categoria.getNome());
          comando.setString(2,String.valueOf(categoria.getTipo()));//convertendo tipo char para String
          comando.execute();
          comando.close();
          return true;  
        }catch(Exception e){
            return false;
        }
    }
    
    public static boolean alterar(Categoria categoria)
    {
        try {
            Connection con=Conexao.getConexao();
            String sql="UPDATE categoria SET "
                    +"nome = ?, "
                    + "tipo = ? "
                    + "WHERE id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2,String.valueOf(categoria.getTipo()));
            comando.setInt(3, categoria.getId());
            int nrLinhas=comando.executeUpdate();
            comando.close();
            
            return nrLinhas>0;
        } catch (Exception e) {
            return false;
        }
    }
        

    public static boolean excluir(int id)
    {
            try {
                Connection con=Conexao.getConexao();
                String sql= "DELETE FROM categoria WHERE id= ?";
                
                 PreparedStatement comando=con.prepareStatement(sql);
                 comando.setInt(1,id);
                 int nrLinhas=comando.executeUpdate();
                 comando.close();
                 return nrLinhas>0;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    
    public static List<Categoria> listar(){
        List<Categoria> categorias =new ArrayList<Categoria>();
        try{
            
            Connection conexao= Conexao.getConexao();
            String sql= "SELECT * FROM categoria";

            Statement comando=conexao.createStatement();
            ResultSet resultado=comando.executeQuery(sql);
            while(resultado.next()){
                Categoria c= new Categoria();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setTipo(resultado.getString("tipo").charAt(0));
                categorias.add(c);
            }
            resultado.close();
            comando.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return categorias;
       
    }
    public static List<Categoria> listarPorTipo(char tipo){
        List<Categoria> categorias =new ArrayList<Categoria>();
        try{
            
            Connection conexao= Conexao.getConexao();
            String sql= "SELECT * FROM categoria WHERE tipo = ? ";

            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setString(1,String.valueOf(tipo));
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Categoria c= new Categoria();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                //c.setTipo(resultado.getString("tipo").charAt(0));
                c.setTipo(tipo);
                categorias.add(c);
            }
            resultado.close();
            comando.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return categorias;
       
    }
    
}
    



