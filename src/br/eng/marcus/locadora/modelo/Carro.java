/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eng.marcus.locadora.modelo;

/**
 *
 * @author Marcus Borges
 */
public class Carro {
    
    //Contantes, o uso de "static final" serve para declar valores pre-definidos
    //Sem precisar chamar pelo "NEW"
    public static final String MARCA_HYUNDAI = "HYUNDAI";
    public static final String MARCA_FIAT = "FIAT";
    public static final String MARCA_RENAULT = "RENAULT";
    public static final String COR_BRANCO = "BRANCO";
    public static final String COR_PRATA = "PRATA";
    public static final String COR_PRETO = "PRETO";
    
    public static final String MODELO_HYUNDAI_HB20 = "HB20";
    public static final String MODELO_HYUNDAI_CRETA = "CRETA";
    public static final String MODELO_FIAT_ARGO = "ARGO";
    public static final String MODELO_FIAT_TORO = "TORO";
    public static final String MODELO_RENAULT_KWID = "KWID";
    public static final String MODELO_RENAULT_KANGOO = "KANGOO";
    
    public static final String TIPO_HATCH = "HATCH";
    public static final String TIPO_ULTILITARIO = "UTILITÁRIO";
    public static final String TIPO_CAMIONETE = "CAMIONETE";
    public static final String TIPO_SUV = "SUV";
    
    //Atributos
    
    private String tipo;
    private String cor;
    private String modelo;
    private String marca;
    private double valorDiaria;
    /**
     * Para kilometragem livre adotar valor zero.
     */
    private float km; 
    private String motor;
    private boolean ar;
    private double valorcalcao;
    private String placa;
    private String foto;
    
    //Metodos

    public Carro(String tipo, String cor, String modelo, String marca, double valorDiaria, float km, String motor, boolean ar, double valorcalcao, String placa, String foto) {
        this.tipo = tipo;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.valorDiaria = valorDiaria;
        this.km = km;
        this.motor = motor;
        this.ar = ar;
        this.valorcalcao = valorcalcao;
        this.placa = placa;
        this.foto = foto;
    }

    public Carro() {
    }

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

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
