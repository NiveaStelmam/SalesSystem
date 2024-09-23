package br.com.sales.repository;

import br.com.sales.domain.ClienteModel;
import br.com.sales.domain.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {

    Set<PedidoModel> findByCliente(ClienteModel cliente);
}
