package br.com.sales.repository;

import br.com.sales.domain.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemPedidoRepository extends JpaRepository <ItemPedidoModel, UUID> {
}
