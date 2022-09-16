/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eng.marcus.locadora.tela.render;

import br.eng.marcus.locadora.modelo.Carro;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Marcus Borges
 */
public class DesignListaCarros extends JTextPane implements ListCellRenderer<Carro>{

    public DesignListaCarros() {
        setContentType("text/html");
        setEditable(false);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Carro> list, Carro carro, int index, boolean isSelected, boolean cellHasFocus) {
        
        //Aplica as propriedades do carro a ser axibido no texto/modelo
        String conteudo = carro.obterLayout(carro);
        
        //Exibe o modelo
        setText(conteudo);
        
        //Carrega a foto do veículo
        if(carro.getFoto()!=null){
            JLabel foto = new JLabel("");
            
            foto.setIcon(new ImageIcon(carro.getFoto()));
            
            insertComponent(foto);
        }
        
        //Marca a cor de fundo no item selecionado na lista
        if(isSelected){
            setBackground(Color.ORANGE);
            setForeground(Color.WHITE);
        }else{
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        
        return this;
    }
    
    
}
