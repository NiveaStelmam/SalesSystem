package br.com.sales.repository;

import br.com.sales.domain.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

    @Query( value = "select * from tb_cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<ClienteModel> findByName(@Param("nome") String nome);  // declaration


    @Query(value = "delete from tb_cliente c where c.nome =:nome ", nativeQuery = true)
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query("select c from ClienteModel c left join fetch c.pedidos where c.id = :id")
    ClienteModel findClienteFetchPedidos(@Param("id") UUID id);




}
