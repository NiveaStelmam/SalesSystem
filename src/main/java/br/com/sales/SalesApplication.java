package br.com.sales;

import br.com.sales.domain.ClienteModel;
import br.com.sales.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner commandLineRunner (@Autowired ClienteRepository clienteRepository){
        return args -> {
            ClienteModel c = new ClienteModel (null, "UserTest");
            clienteRepository.save(c);
        };
    }



    public static void main(String[] args){
        SpringApplication.run(SalesApplication.class, args);
    }
}
