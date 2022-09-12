/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eng.marcus.locadora.tela.render;

import br.eng.marcus.locadora.modelo.Carro;
import java.awt.Component;
import java.util.List;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Marcus Borges
 */
public class DesignListaCarros extends JTextPane implements ListCellRenderer<Carro>{

    private static final String LAYOUT = "";
    
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Carro> list, Carro value, int index, boolean isSelected, boolean cellHasFocus) {
        
        return null;
        
        
    }
    

    
    
}
