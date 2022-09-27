/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eng.marcus.locadora.tela.render;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Marcus Borges
 */
public class DesignTabelaImagemColuna extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        setText("");
        
        setIcon(
            new ImageIcon(
                new ImageIcon(value.toString())
                    .getImage()
                    .getScaledInstance(60, 50, Image.SCALE_DEFAULT)
            )
        );
        
        return this;
    }
    
}
