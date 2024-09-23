package br.com.sales;

import br.com.sales.domain.ClienteModel;
import br.com.sales.domain.PedidoModel;
import br.com.sales.repository.ClienteRepository;
import br.com.sales.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository, PedidoRepository pedidoRepository){
        return args -> {
            System.out.println("Salvando clientes");
            ClienteModel user = new ClienteModel("User");
            clienteRepository.save(user);

            PedidoModel p = new PedidoModel();
            p.setCliente(user);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidoRepository.save(p);

//            ClienteModel cliente = clienteRepository.findClienteFetchPedidos(user.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

           pedidoRepository.findByCliente(user).forEach(System.out::println);

        };
    }

    public static void main(String[] args){
        SpringApplication.run(SalesApplication.class, args);
    }
}
