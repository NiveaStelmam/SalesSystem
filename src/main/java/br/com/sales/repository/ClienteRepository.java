package br.com.sales.repository;

import br.com.sales.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    // select c from Cliente c where c.nome like : nome (query)
    List<ClienteModel> findByNomeLike(String nome);  // declaração

    List<ClienteModel> findByNomeOrId(String nome, Integer id);

    boolean existsByNome(String nome);

}
