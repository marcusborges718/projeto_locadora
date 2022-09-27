/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.eng.marcus.locadora.tela.admin;

import br.eng.marcus.locadora.modelo.Marca;
import br.eng.marcus.locadora.servico.MarcaServico;
import br.eng.marcus.locadora.servico.Servico;
import br.eng.marcus.locadora.tela.render.DesignTabelaImagemColuna;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcus Borges
 */
public class FormCadastroMarcas extends javax.swing.JInternalFrame {

    private Servico<Marca> marcaServico;
    
    private Marca marcaSelecionada;
    
    private List<Marca> marcas;
    
    /**
     * Creates new form FromCadastroMarcas
     */
    public FormCadastroMarcas() {
        initComponents();
        
        iniciaTela();
        
        try{
            this.marcaServico = new MarcaServico();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
                            e.getMessage(), "Erro ao conectar no banco de dados!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    /**
     * Inicia a tela
     */
    private void iniciaTela(){
        //Desabilita botões não usados no inicio
        this.jButtonBuscaLogo.setEnabled(false);
        this.jButtonSalvar.setEnabled(false);
        this.jTextFieldLogo.setEnabled(false);
        this.jTextFieldNome.setEnabled(true);
        this.jTextFieldID.setEnabled(false);
        this.jButtonCancelar.setEnabled(false);
        this.jButtonEditar.setEnabled(false);
        this.jButtonExcluir.setEnabled(false);
        
        //Libera botões a serem usados
        this.jButtonCadastrar.setEnabled(true);
        this.jButtonPesquisar.setEnabled(true);
        
        //Limpa campos
        this.jLabelLogo.setIcon(null);
        this.jTextFieldLogo.setText("");
        this.jTextFieldNome.setText("");
        this.jTextFieldID.setText("");
        
        //Limpa marcas
        this.marcaSelecionada = new Marca();      
        this.marcas = new ArrayList<>();
        atualizaListaMarcas();
    }
    
    private void mostraMarcaSelecionada(){
        this.jTextFieldID.setText(String.valueOf(this.marcaSelecionada.getId()));
        this.jTextFieldNome.setText(this.marcaSelecionada.getNome());
        this.jTextFieldLogo.setText(this.marcaSelecionada.getLogo());
        ImageIcon urlImagem = new ImageIcon(new ImageIcon(this.marcaSelecionada.getLogo()).getImage()
                                .getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        this.jLabelLogo.setIcon(urlImagem);
    }
    
    private void atualizaListaMarcas(){        
        DefaultTableModel model =  (DefaultTableModel) jTableMarcas.getModel();

        //Limpa a tabela 
        model.setNumRows(0);

        for(Marca marca : this.marcas){
            Object[] saida = new Object[4];

            saida[0] = marca.getId();
            saida[1] = marca.getNome();
            saida[2] = marca.getLogo();
            saida[3] = new ImageIcon(marca.getLogo());

            //Incluir nova linha na Tabela
            model.addRow(saida);
        }
        
        jTableMarcas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableMarcas.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableMarcas.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableMarcas.getColumnModel().getColumn(2).setPreferredWidth(370);
        jTableMarcas.getColumnModel().getColumn(3).setPreferredWidth(90);
        
        jTableMarcas.getColumnModel().getColumn(3).setCellRenderer(new DesignTabelaImagemColuna());
    }
    
    /**
     * Libera os botões usados no cadastro e bloqueia os desnecessários
     */
    private void modoCadastro(){
        //Desabilita botões não usados no inicio
        this.jButtonBuscaLogo.setEnabled(true);
        this.jButtonSalvar.setEnabled(true);
        this.jTextFieldLogo.setEnabled(true);
        this.jTextFieldNome.setEnabled(true);
        this.jButtonCancelar.setEnabled(true);
        this.jTextFieldID.setEnabled(false);
        
        //Libera botões a serem usados
        this.jButtonCadastrar.setEnabled(false);
        this.jButtonPesquisar.setEnabled(false);
        this.jButtonEditar.setEnabled(false);
        this.jButtonExcluir.setEnabled(false);
        
        this.marcaSelecionada = new Marca();
        this.jLabelLogo.setIcon(null);
        this.jTextFieldID.setText("");
        this.jTextFieldNome.setText("");
        this.jTextFieldLogo.setText("");
    }
    
    /**
     * Libera os botões usados no editar cadastro e bloqueia os desnecessários
     */
    private void modoEditar(){
        this.jButtonCadastrar.setEnabled(false);
        this.jButtonEditar.setEnabled(false);
        this.jButtonPesquisar.setEnabled(false);
        this.jButtonCancelar.setEnabled(true);
        this.jButtonSalvar.setEnabled(true);
        this.jButtonBuscaLogo.setEnabled(true);
        this.jTextFieldLogo.setEnabled(true);
        this.jTextFieldNome.setEnabled(true);
    }
    
    /**
     * Libera os botões usados para visualizar cadastro existente e bloqueia os desnecessários
     */
    private void modoVizualizar(){
        int row = jTableMarcas.getSelectedRow();
        this.marcaSelecionada = this.marcas.get(row);
        mostraMarcaSelecionada();
        
        this.jButtonEditar.setEnabled(true);
        this.jButtonExcluir.setEnabled(true);
        this.jButtonCadastrar.setEnabled(true);
        this.jButtonPesquisar.setEnabled(true);
        this.jButtonCancelar.setEnabled(true);
        this.jButtonSalvar.setEnabled(false);
        this.jButtonBuscaLogo.setEnabled(false);
        this.jTextFieldLogo.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUrl = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMarcas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonBuscaLogo = new javax.swing.JButton();
        jTextFieldLogo = new javax.swing.JTextField();
        jLabelLogo = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel2.setText("IDENTIFICADOR");

        jTextFieldIdentificador.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel3.setText("DESCRIÇÃO");

        jTextFieldDescricao.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel4.setText("URL");

        jTextFieldUrl.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jTextFieldUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUrlActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("BUSCAR");

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");

        setTitle("Cadastro de marcas");

        jTableMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "URL Logo", "Logo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableMarcas.setRowHeight(60);
        jTableMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMarcasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMarcas);

        jLabel1.setText("ID:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Logo:");

        jTextFieldID.setEditable(false);

        jButtonBuscaLogo.setText("...");
        jButtonBuscaLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaLogoActionPerformed(evt);
            }
        });

        jTextFieldLogo.setEditable(false);

        jLabelLogo.setBorder(javax.swing.BorderFactory.createTitledBorder("Logo"));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldID))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNome))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldLogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscaLogo)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscaLogo)))
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        setBounds(0, 0, 621, 446);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUrlActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonBuscaLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaLogoActionPerformed
        JFileChooser fc = new JFileChooser(System.getProperty("user.home"));
        
        FileFilter filter = new FileNameExtensionFilter("Arquivo de imagem", ImageIO.getReaderFileSuffixes());

        fc.setFileFilter(filter);
        
        int res = fc.showOpenDialog(null);
        
        try {
            if (res == JFileChooser.APPROVE_OPTION) {
                
                //Mostra caminho
                File file = fc.getSelectedFile();
                this.jTextFieldLogo.setText(file.getAbsolutePath());
                
                //VIzualiza imagem
                
                ImageIcon urlImagem = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
                this.jLabelLogo.setIcon(urlImagem);
                
            } // Oops!
            else {
                JOptionPane.showMessageDialog(null,
                        "Selecione uma imagem válida!", "Operação cancelada",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception iOException) {
            JOptionPane.showMessageDialog(this,
                        "Selecione uma imagem válida!", "Operação cancelada",
                        JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscaLogoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try{
            this.marcaSelecionada.setNome(jTextFieldNome.getText());
            this.marcaSelecionada.setLogo(jTextFieldLogo.getText());
            
            if(this.marcaSelecionada.getId() == null){
                this.marcaServico.inserir(this.marcaSelecionada);
            }else{
                this.marcaServico.atualizar(this.marcaSelecionada);
            }
            
            JOptionPane.showMessageDialog(this,
                    "Dados gravados com sucesso!", "Salvo!", JOptionPane.INFORMATION_MESSAGE);
            
            iniciaTela();
            jButtonPesquisar.doClick();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
                    e.getMessage(), "Erro ao salvar dados!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        modoCadastro();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        iniciaTela();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        try {
            this.marcas = this.marcaServico.buscar(jTextFieldNome.getText());
            atualizaListaMarcas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        ex.getMessage(), "Erro ao efetuar a pesquisa!",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMarcasMouseClicked
        modoVizualizar();
    }//GEN-LAST:event_jTableMarcasMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        modoEditar();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            this.marcaServico.excluir(this.marcaSelecionada.getId());
            
            JOptionPane.showMessageDialog(this,
                        "Item excluído com sucesso!", "Excluído!",
                        JOptionPane.INFORMATION_MESSAGE);
            
            iniciaTela();
            jButtonBuscar.doClick();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                        ex.getMessage(), "Erro ao efetuar a pesquisa!",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscaLogo;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMarcas;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldLogo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldUrl;
    // End of variables declaration//GEN-END:variables
}
