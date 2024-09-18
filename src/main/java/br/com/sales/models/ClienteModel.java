package br.com.sales.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "tb_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @NotBlank(message = "O campo 'nome' não pode estar em branco ou vazio")
    @Size( min = 3, max = 50)
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
