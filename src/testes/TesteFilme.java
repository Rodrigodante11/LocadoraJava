/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidades.Categoria;
import entidades.Filme;
import javax.swing.JOptionPane;
import persistencia.FilmeDAO;

/**
 *
 * @author rodri
 */
public class TesteFilme {
    public static void main(String[] args) {
        /*Categoria categoria = new Categoria();
        categoria.setId(2); //categoria comedia
        
        Filme filme= new Filme(categoria);
        filme.setTitulo("Bad Boys");
        filme.setDuracao(90);
        filme.setPreco(2.50);
        filme.setNumeroDias(5);
        filme.setDescricao("Filme Policial");
        filme.setDiretor("teste filmeDAO");
        
        if(FilmeDAO.inserir(filme)){
            JOptionPane.showMessageDialog(null, "Filme inserido com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao inserir Filme ");
        }*/
        System.out.println(FilmeDAO.listar());
    }
}
