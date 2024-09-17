package br.com.sales.models;

public class ClienteModel {

    private Integer id;
    private String nome;

    public ClienteModel(){}
    public ClienteModel(String nome){
        this.nome = nome;
    }

    public ClienteModel(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() { return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
