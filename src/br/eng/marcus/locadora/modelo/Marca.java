package br.eng.marcus.locadora.modelo;

public class Marca {

    private Integer id;

    private String nome;

    private String logo;

    public Marca(Integer id, String nome, String logo) {
        this.id = id;
        this.nome = nome;
        this.logo = logo;
    }

    public Marca() {

    }

    @Override
    public String toString() {
        return id + ";" + nome.trim() + ";" + logo.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
