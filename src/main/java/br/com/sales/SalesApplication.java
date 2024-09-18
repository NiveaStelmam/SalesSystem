package br.com.sales;

import br.com.sales.models.ClienteModel;
import br.com.sales.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
        return args -> {
            System.out.println("Salvando clientes");
            clienteRepository.save(new ClienteModel("User1"));
            clienteRepository.save(new ClienteModel("User1"));

            boolean existe = clienteRepository.existsByNome("User1");
            System.out.println("existe um cliente com o nome User1? " + existe);


        };
    }

    public static void main(String[] args){
        SpringApplication.run(SalesApplication.class, args);
    }
}
