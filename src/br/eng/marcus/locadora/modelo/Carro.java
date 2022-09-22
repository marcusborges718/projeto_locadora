/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eng.marcus.locadora.modelo;

import java.net.URL;

/**
 *
 * @author Marcus Borges
 */
public class Carro extends Veiculo{
    /*
    Criação de atributos
    */
    private double valorDiaria;
    private double valorcalcao;
    private boolean ar;
          /**
     * Para kilometragem livre adotar valor zero.
     */
    private float km;
  
    
    //Metodos sobre carga de construtores, mesmo 
    public Carro(String tipo, String cor, String modelo, String marca, double valorDiaria, 
            float km, String motor, boolean ar, double valorcalcao, String placa, URL foto) {
        //atributos dessa classe
        this.valorDiaria = valorDiaria;
        this.valorcalcao = valorcalcao;
        this.ar = ar;
        this.km = km;
         
         //atributos herdados
        super.tipo = tipo;
        super.cor = cor;
        super.modelo = modelo;
        super.marca = marca;
        super.motor = motor;
        super.placa = placa;
        super.foto = foto;
    }

    public Carro() {
        
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Exemplo de sobrecarga de método
    //As duas funções abaixo possuem o mesmo nome e tipo de retorno, porém retornam dados diferentes e possuem 
    //parâmetros diferentes
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Retorna somente o modelo do layout html
     * @return 
     */
    public String obterLayout(){
        return "<html><body>"
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
    }
    
    /**
     * Retorna o modelo do layout html ja formatado com os dados do veículo
     * @param carro
     * @return 
     */
    public String obterLayout(Carro carro){
       String layout = obterLayout();
       
       String km = carro.getKm() == .0 ? "Livre" : String.format("%.2f km", carro.getKm());
       
       String conteudo = layout.replace("#MARCA", carro.getMarca())
                                .replace("#MODELO", carro.getModelo())
                                .replace("#COR", carro.getCor())
                                .replace("#TIPO", carro.getTipo())
                                .replace("#PLACA", carro.getPlaca())
                                .replace("#MOTOR", carro.getMotor())
                                .replace("#KM", km)
                                .replace("#COMBUSTIVEL", carro.getCombustivel());
       
       return conteudo;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public boolean isAr() {
        return ar;
    }

    public void setAr(boolean ar) {
        this.ar = ar;
    }

    public double getValorcalcao() {
        return valorcalcao;
    }

    public void setValorcalcao(double valorcalcao) {
        this.valorcalcao = valorcalcao;
    }
    
    
}
