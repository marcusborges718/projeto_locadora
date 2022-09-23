/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.eng.marcus.locadora.tela;

import br.eng.marcus.locadora.modelo.Carro;
import br.eng.marcus.locadora.modelo.Reserva;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Marcus Borges
 */
public class TelaEscolhaPeriodo extends javax.swing.JFrame {
    //para transportar tela por tela 
    private Reserva reserva = null;
    
    /**
     * Creates new form TelaEscolhaPeriodo
     */                         //colocar o parametro de reseva
    public TelaEscolhaPeriodo(Reserva reserva) {
       // estou recebendo a reserva da primeira e armazenado nesta.
        this.reserva = reserva;
        initComponents();
        mostrarVeiculoSelecionado();
    }
    
    //criar uma função exibir o veiculo que foi selecionado na tela anterior,
    private void mostrarVeiculoSelecionado(){
        //TODO: implemrtar tratamento de exceção aqui para validar se foi recebido a reserva com o veículo preenchido
        if(this.reserva==null) {System.exit(1);}
         
        Carro carro = this.reserva.getCarro();
        
        //Aplica as propriedades do carro a ser axibido no texto/modelo
        String conteudo = carro.obterLayout(carro);
         
        jTextPaneVeiculoSelecionado.setContentType("text/html");
        jTextPaneVeiculoSelecionado.setEditable(false);
        jTextPaneVeiculoSelecionado.setText(conteudo);
        
        //Carrega a foto do veículo
        if(carro.getFoto()!=null){
            JLabel foto = new JLabel("");
            
            foto.setIcon(new ImageIcon(carro.getFoto()));
            
           jTextPaneVeiculoSelecionado.insertComponent(foto);
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonVoltarParaListaCarro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneVeiculoSelecionado = new javax.swing.JTextPane();
        jButtonAvançarDoPeriodo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserDevolucao = new com.toedter.calendar.JDateChooser();
        jDateChooserRetirada = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelContent.setBackground(new java.awt.Color(254, 108, 45));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informe o Período");

        jButtonVoltarParaListaCarro.setBackground(new java.awt.Color(0, 0, 0));
        jButtonVoltarParaListaCarro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonVoltarParaListaCarro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltarParaListaCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/icon/arrow-left.png"))); // NOI18N
        jButtonVoltarParaListaCarro.setText("Voltar");
        jButtonVoltarParaListaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarParaListaCarroActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/icon/apoio.png"))); // NOI18N

        jScrollPane1.setViewportView(jTextPaneVeiculoSelecionado);

        jButtonAvançarDoPeriodo.setBackground(new java.awt.Color(0, 0, 0));
        jButtonAvançarDoPeriodo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonAvançarDoPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAvançarDoPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/icon/icons8-arrow-50.png"))); // NOI18N
        jButtonAvançarDoPeriodo.setText("Avançar");
        jButtonAvançarDoPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAvançarDoPeriodoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("DATA DA RETIRADA: ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setText("DATA DA DEVOLUÇÃO:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("HORARIO DE RETIRADA E DEVOLUÇÃO SERÁ REALIZADO NOS SEQUINTES HORÁRIOS:\nSEGUNDA A SEXTA DAS 08:00 ATE 18:00\nSÁBADO,DOMINGO E FERIADOS DAS 08:00 ÀS 12:00\nLOCAL: AEROPORTO SANTA GENOVEVA\n");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                        .addComponent(jButtonVoltarParaListaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonAvançarDoPeriodo)
                        .addGap(27, 27, 27))
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserRetirada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(128, 128, 128)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltarParaListaCarro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAvançarDoPeriodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarParaListaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarParaListaCarroActionPerformed
        
          //criou onjeto da interface grafica 
        TelaListagemVeiculos telaPrincipal = new TelaListagemVeiculos();
        //exibir 
        telaPrincipal.show(true);
        
        dispose();
        
    }//GEN-LAST:event_jButtonVoltarParaListaCarroActionPerformed

    private void jButtonAvançarDoPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAvançarDoPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAvançarDoPeriodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEscolhaPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEscolhaPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEscolhaPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEscolhaPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEscolhaPeriodo(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAvançarDoPeriodo;
    private javax.swing.JButton jButtonVoltarParaListaCarro;
    private com.toedter.calendar.JDateChooser jDateChooserDevolucao;
    private com.toedter.calendar.JDateChooser jDateChooserRetirada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPaneVeiculoSelecionado;
    // End of variables declaration//GEN-END:variables
}
