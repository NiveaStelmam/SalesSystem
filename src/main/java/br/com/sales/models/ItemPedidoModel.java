package br.com.sales.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_itemPedido")
public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoModel pedido;
    
    @ManyToOne
    @JoinColumn(name = "produto_ID")
    private ProdutoModel produto;
    private Integer quantidade;

}
