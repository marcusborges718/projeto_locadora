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
public abstract class  Veiculo {
    
    //Constante
    public static final String COR_PRETO = "PRETO";
    public static final String COR_BRANCO = "BRANCO";
    public static final String COR_PRATA = "PRATA";
    
    public static final String MARCA_FIAT ="FIAT";
    public static final String MARCA_RENAULT = "RENAULT";
    public static final String MARCA_HYUNDAI = "HYUNDAI";
            
    public static final String MODELO_FIAT_ARGO = "ARGO";
    public static final String MODELO_FIAT_TORO = "TORO";
    public static final String MODELO_RENAULT_KWID = "KWID";
    public static final String MODELO_RENAULT_KANGOO = "KANGOO";
    public static final String MODELO_HYUNDAI_CRETA = "CRETA";
    public static final String MODELO_HYUNDAI_HB20 = "HB20";
    
    public static final String TIPO_HATCH = "HATCH";
    public static final String TIPO_CAMIONETE = "CAMIONETE";
    public static final String TIPO_UTILITARIO = "UTILITÁRIO";
    public static final String TIPO_SUV = "SUV";
    
    public static final String COMBUSTIVEL_FLEX = "FLEX";
    public static final String COMBUSTIVEL_ELETRICO = "ELÉTRICO";
    public static final String COMBUSTIVEL_GASOLINA = "GASOLINA";
    public static final String COMBUSTIVEL_ETANOL = "ETANOL";
    public static final String COMBUSTIVEL_DIESEL = "DIESEL";
    
    
    
    
    
    
     
    
    //Atributos
    protected String tipo;
    protected String cor;
    protected String modelo;
    protected String marca;
    protected String motor;
    protected String placa;
    protected URL foto;
    protected String combustivel;
    
    //Metodos

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public URL getFoto() {
        return foto;
    }

    public void setFoto(URL foto) {
        this.foto = foto;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    
    
}
