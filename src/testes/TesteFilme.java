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
        filme.setTitulo("Bad Boys2");
        filme.setDuracao(90);
        filme.setPreco(2.50);
        filme.setNumeroDias(5);
        filme.setDescricao("Filme Policial2");
        filme.setDiretor("Diretor Bad");
       
        
        if(FilmeDAO.inserir(filme)){
            JOptionPane.showMessageDialog(null, "Filme inserido com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao inserir Filme ");
        }
        
        filme.setId(5);
        if(FilmeDAO.alterar(filme)){
            JOptionPane.showMessageDialog(null, "Filme alterado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao alteradar Filme ");
        }*/
         if(FilmeDAO.excluir(3)){
            JOptionPane.showMessageDialog(null, "Filme alterado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao alteradar Filme ");
        }
        System.out.println(FilmeDAO.listar());
    }
}
