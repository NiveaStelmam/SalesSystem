package br.com.sales.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "nome")
    @NotBlank(message = "O campo 'nome' não pode estar em branco ou vazio")
    @Size( min = 3, max = 50)
    private String nome;

    @OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY) // não traz todos os pedidos do cliente
    private Set<PedidoModel> pedidos; // set or List

    // ---------------------------------------------

    public ClienteModel(String nome){
        this.nome = nome;
    }
}
