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

    private static final String LAYOUT = "<html><body>"
                + "<table style=\"border-bottom:2px solid gray;\">"
                    + "<tr>"
                        + "<td style=\"width:200px;\">"
                            + "<p><b>Tipo:</b> #TIPO</p>"
                            + "<br>"
                            + "<p><b>Marca:</b> #MARCA - #MODELO</p>"
                            + "<p><b>Motor:</b> #MOTOR</p>"
                            + "<p><b>Combustível:</b> #COMBUSTIVEL</p>"
                            + "<p><b>Km:</b> #KM</p>"
                            + "<br>"
                            + "<p><b>Placa:</b> #PLACA</p>"
                            + "<p><b>Cor:</b> #COR</p>"
                        + "</td>"
                        + "<td><span>&nbsp;</span></td>"
                    + "</tr>"
                + "</table>" 
            + "</body></html>";

    public DesignListaCarros() {
        setContentType("text/html");
        setEditable(false);
    }
    
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Carro> list, Carro carro, int index, boolean isSelected, boolean cellHasFocus) {
        
        //Formatar kilometragem
        String km = carro.getKm() == .0 ? "Livre" : String.format("%.2f km", carro.getKm());
        
        //Aplica as propriedades do carro a ser axibido no texto/modelo
        String conteudo = LAYOUT.replace("#MARCA", carro.getMarca())
                                .replace("#MODELO", carro.getModelo())
                                .replace("#COR", carro.getCor())
                                .replace("#TIPO", carro.getTipo())
                                .replace("#PLACA", carro.getPlaca())
                                .replace("#MOTOR", carro.getMotor())
                                .replace("#KM", km)
                                .replace("#COMBUSTIVEL", carro.getCombustivel());
        
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
