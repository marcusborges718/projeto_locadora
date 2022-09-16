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
    //Atributos
    private double valorDiaria;
    private double valorcalcao;
    private boolean ar;
          /**
     * Para kilometragem livre adotar valor zero.
     */
    private float km;
  
    
    //Metodos
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
