package br.com.sales.repository;

import br.com.sales.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    List<ClienteModel> findByNomeLike(String nome);

    boolean existsByNome(String nome);

}
