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
public class Cliente extends Pessoa{
    
    //Atributo
    private String telefone;
    private String endereco;
    
    //Metodo

    public Cliente(String nome, Date dataNascimento, String cpf, String sexo,
            String telefone, String endereco) {
        //Atributos dessa clase
        this.telefone = telefone;
        this.endereco = endereco;
        //Atributos herdados da classe pai
        super.cpf = cpf;
        super.dataNascimento = dataNascimento;
        super.nome = nome;
        super.sexo = sexo;
    }

    public Cliente() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    

    


    
    
}
