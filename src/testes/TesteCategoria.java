
package testes;

import entidades.Categoria;
import persistencia.CategoriaDAO;


public class TesteCategoria {
    public static void main(String[] args) {
        Categoria categoria=new Categoria();
        categoria.setNome("Comedia");
        categoria.setTipo('F'); //F-filme J-Jogo
        categoria.setId(1);
        
        //CategoriaDAO.inserir(categoria);
        //CategoriaDAO.alterar(categoria);
        //CategoriaDAO.excluir(1);
        System.out.println(CategoriaDAO.listar());
    }
}
