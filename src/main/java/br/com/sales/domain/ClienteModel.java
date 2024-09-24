package br.com.sales.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_cliente")

public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nome")
    @NotBlank(message = "O campo 'nome' não pode estar em branco ou vazio")
    @Size( min = 3, max = 50)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY) // não traz todos os pedidos do cliente
    private Set<PedidoModel> pedidos = new HashSet<>(); // set or List

    // ---------------------------------------------

    public ClienteModel(UUID id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public ClienteModel(String nome){
        this.nome = nome;
    }

}
