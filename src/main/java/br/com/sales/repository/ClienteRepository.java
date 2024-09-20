package br.com.sales.repository;

import br.com.sales.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

    // select c from Cliente c where c.nome like : nome (query) methods
    List<ClienteModel> findByNomeLike(String nome);  // declaration

    List<ClienteModel> findByNomeOrId(String nome, UUID id);

    boolean existsByNome(String nome);

}
