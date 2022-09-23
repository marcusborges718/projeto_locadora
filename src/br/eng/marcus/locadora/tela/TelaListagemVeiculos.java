/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.eng.marcus.locadora.tela;

import br.eng.marcus.locadora.modelo.Carro;
import br.eng.marcus.locadora.modelo.Cliente;
import br.eng.marcus.locadora.modelo.Pessoa;
import br.eng.marcus.locadora.modelo.Reserva;
import br.eng.marcus.locadora.modelo.Veiculo;
import br.eng.marcus.locadora.tela.render.DesignListaCarros;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcus Borges
 */
public class TelaListagemVeiculos extends javax.swing.JFrame {

    private DefaultListModel<Carro> catalogo = new DefaultListModel<>();
    
    private Reserva reserva = new Reserva();
    
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaListagemVeiculos() {
        initComponents();
        montaCatalogo();   
       
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCarros = new javax.swing.JList();
        jButtonListaCarro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelContent.setBackground(new java.awt.Color(254, 108, 45));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Escolha seu carro");

        jListCarros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListCarros.setCellRenderer(new DesignListaCarros()
        );
        jScrollPane1.setViewportView(jListCarros);

        jButtonListaCarro.setBackground(new java.awt.Color(0, 0, 0));
        jButtonListaCarro.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonListaCarro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListaCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/icon/icons8-arrow-50.png"))); // NOI18N
        jButtonListaCarro.setText("Avançar");
        jButtonListaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaCarroActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagens/icon/apoio.png"))); // NOI18N

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jButtonListaCarro)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
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

    private void jButtonListaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaCarroActionPerformed
        
        if(this.jListCarros.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(this, "Nenhum veiculo selecionado. \n"
                    + "Por favor escolha seu veiculo antes de avançar!");
            return;
        }
        
        Carro carro = (Carro) this.jListCarros.getSelectedValue();
        
        //implementa tratamento p ver se não é nulo, se for nulo é pq usuario n selecionou item, ai da msg
        
        this.reserva.setCarro(carro);
        
        //criou onjeto da interface grafica 
        TelaEscolhaPeriodo telaEscolhaPeriodo = new TelaEscolhaPeriodo(this.reserva);
        //exibir 
        telaEscolhaPeriodo.show(true);
        
        dispose();
        
    }//GEN-LAST:event_jButtonListaCarroActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaListagemVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaListagemVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaListagemVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaListagemVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaListagemVeiculos().setVisible(true);
//            }
//        });
//    }
   
    //criando os objetos com as suas propriedades 
    public void montaCatalogo(){
        Carro carro1 = new Carro();
        carro1.setAr(true);
        carro1.setCor(Veiculo.COR_PRETO);
        carro1.setKm(200);
        carro1.setMarca(Veiculo.MARCA_FIAT);
        carro1.setModelo(Veiculo.MODELO_FIAT_ARGO);
        carro1.setMotor("1.0");
        carro1.setPlaca("BRA-0001");
        carro1.setTipo(Veiculo.TIPO_HATCH);
        carro1.setValorDiaria(100.00);
        carro1.setValorcalcao(700.00);
        carro1.setCombustivel(Veiculo.COMBUSTIVEL_FLEX);
        carro1.setFoto(getClass().getResource("/resources/imagens/carros/argoPreto2.png"));
        
        Carro carro2 = new Carro();
        carro2.setAr(true);
        carro2.setCor(Veiculo.COR_PRETO);
        carro2.setKm(0);
        carro2.setMarca(Veiculo.MARCA_FIAT);
        carro2.setModelo(Veiculo.MODELO_FIAT_TORO);
        carro2.setMotor("2.0");
        carro2.setPlaca("PRQ-1098");
        carro2.setTipo(Veiculo.TIPO_CAMIONETE);
        carro2.setValorDiaria(160.00);
        carro2.setValorcalcao(1000.00);
        carro2.setCombustivel(Veiculo.COMBUSTIVEL_DIESEL);
        carro2.setFoto(getClass().getResource("/resources/imagens/carros/toroPreta2.png"));
        
        
        Carro carro3 = new Carro();
        carro3.setAr(true);
        carro3.setCor(Carro.COR_BRANCO);
        carro3.setKm(0);
        carro3.setMarca(Veiculo.MARCA_RENAULT);
        carro3.setModelo(Veiculo.MODELO_RENAULT_KWID);
        carro3.setMotor("1.0");
        carro3.setPlaca("PRQ-0001");
        carro3.setTipo(Veiculo.TIPO_HATCH);
        carro3.setValorDiaria(200.00);
        carro3.setValorcalcao(700.00);
        carro3.setCombustivel(Veiculo.COMBUSTIVEL_ELETRICO);
        carro3.setFoto(getClass().getResource("/resources/imagens/carros/kwid2.png"));
        
        Carro carro4 = new Carro();
        carro4.setAr(true);
        carro4.setCor(Veiculo.COR_BRANCO);
        carro4.setKm(150);
        carro4.setMarca(Veiculo.MARCA_RENAULT);
        carro4.setModelo(Veiculo.MODELO_RENAULT_KANGOO);
        carro4.setMotor("1.6");
        carro4.setPlaca("PRQ-0061");
        carro4.setTipo(Veiculo.TIPO_UTILITARIO);
        carro4.setValorDiaria(140.00);
        carro4.setValorcalcao(1000.00);
        carro4.setCombustivel(Veiculo.COMBUSTIVEL_GASOLINA);
        carro4.setFoto(getClass().getResource("/resources/imagens/carros/kangooBranco.png"));
        
        Carro carro5 = new Carro();
        carro5.setAr(true);
        carro5.setCor(Veiculo.COR_PRATA);
        carro5.setKm(0);
        carro5.setMarca(Veiculo.MARCA_HYUNDAI);
        carro5.setModelo(Veiculo.MODELO_HYUNDAI_CRETA);
        carro5.setMotor("1.6");
        carro5.setPlaca("PRQ-0098");
        carro5.setTipo(Veiculo.TIPO_SUV);
        carro5.setValorDiaria(140.00);
        carro5.setValorcalcao(1000.00);
        carro5.setCombustivel(Veiculo.COMBUSTIVEL_FLEX);
        carro5.setFoto(getClass().getResource("/resources/imagens/carros/cretaPrata2.png"));
        
        Carro carro6 = new Carro();
        carro6.setAr(true);
        carro6.setCor(Veiculo.COR_PRATA);
        carro6.setKm(0);
        carro6.setMarca(Veiculo.MARCA_HYUNDAI);
        carro6.setModelo(Veiculo.MODELO_HYUNDAI_HB20);
        carro6.setMotor("1.0 TURBO");
        carro6.setPlaca("PRQ-0098");
        carro6.setTipo(Veiculo.TIPO_HATCH);
        carro6.setValorDiaria(120.00);
        carro6.setValorcalcao(1000.00);
        carro6.setCombustivel(Veiculo.COMBUSTIVEL_FLEX);
        carro6.setFoto(getClass().getResource("/resources/imagens/carros/hb20Prata2.png"));
        
        //Agregando os bjetos em uma lista, 
        this.catalogo = new DefaultListModel<Carro>();
        this.catalogo.addElement(carro1);
        this.catalogo.addElement(carro2);
        this.catalogo.addElement(carro3);
        this.catalogo.addElement(carro4);
        this.catalogo.addElement(carro5);
        this.catalogo.addElement(carro6);
        
        
        this.jListCarros.setCellRenderer(new DesignListaCarros());
        this.jListCarros.setModel(this.catalogo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonListaCarro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListCarros;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}