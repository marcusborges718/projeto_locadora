/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eng.marcus.locadora.modelo;

import java.util.Date;

/**
 *
 * @author Marcus Borges
 */
public class Pagamento {
    //ConStante
    public static final String METODO_PIX = "PIX";
    public static final String METODO_DINHEIRO = "DINHEIRO";
    public static final String METODO_CARTAO_DEBITO = "DEBITO";
    public static final String METODO_CARTAO_CREDITO = "CREDITO";
    
    //Atributos
    private double valor;
    private Date dataPagamento;
    private String tipoPagamento;
    
    //Metodos

    public Pagamento(double valor, Date dataPagamento, String tipoPagamento) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    public Pagamento() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    
    
    
}
