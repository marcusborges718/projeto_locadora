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
public class Reserva {
    //Atributos
    
    private Carro carro;
    private Cliente cliente;
    private Pagamento pagamento;
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private Date dataHoraReserva;
    
    //Metodos 

    public Reserva(Carro carro, Cliente cliente, Pagamento pagamento, Date dataHoraInicio, Date dataHoraFim, Date dataHoraReserva) {
        this.carro = carro;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.dataHoraReserva = dataHoraReserva;
    }

    public Reserva() {
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Date getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(Date dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }
    
    
    
}
