/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entidades.Jogo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.JogoDAO;


/**
 *
 * @author rodri
 */
public class TelaListaJogo extends javax.swing.JFrame {
    private List<Jogo>listaJogos;
    /**
     * Creates new form TelaListaJogo
     */
    public TelaListaJogo() {
        initComponents();
        listarJogos();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabJogos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tabJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Categoria", "Preço", "Nº Dias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabJogos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap(368, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        new TelaCadastroJogo(this).setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha= tabJogos.getSelectedRow();// se o usuario seleciono uma linha para alterar
        if(linha==-1){
            JOptionPane.showMessageDialog(this, "Selecione um jogo para alterar");
        }else{
            TelaCadastroJogo cadastro=new TelaCadastroJogo(this);
            cadastro.setJogo(listaJogos.get(linha));//Pega o jogo selecionado e envia pra tela de cadastro
            cadastro.setVisible(true);
                    
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha=tabJogos.getSelectedRow();
        if(linha ==-1){
            JOptionPane.showMessageDialog(this, "Selecione um jogo para excluir!");
        }else{
            Jogo jogo=listaJogos.get(linha);//pegando o jogo selecionado pelo usuario
            String mensagem = "Deseja realmente excluir o jogo "+jogo.getTitulo() + "?";
            int opcao=JOptionPane.showConfirmDialog(this, mensagem,"Confirme a exclusão",
                    JOptionPane.YES_NO_OPTION);//mostrar botãoSIM e Não
            if(opcao==JOptionPane.YES_OPTION){
               if( JogoDAO.excluir(jogo.getId())){
                   JOptionPane.showMessageDialog(this, "Jogo Excluido com sucesso");
                   listarJogos();
               }else{
                   JOptionPane.showMessageDialog(this, "Erro ao excluir jogo!");
               }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    public void listarJogos(){
        listaJogos=JogoDAO.listar();
        DefaultTableModel modelo=(DefaultTableModel) tabJogos.getModel();
        modelo.setRowCount(0);//Limpar os itens da tabela;
        for(Jogo j:listaJogos){
            Object[] linha={
                j.getTitulo(),
                j.getCategoria().getNome(),
                j.getPreco(),
                j.getNumeroDias()
            };
            modelo.addRow(linha);
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabJogos;
    // End of variables declaration//GEN-END:variables
}
