package br.com.sales.repository;

import br.com.sales.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
}
