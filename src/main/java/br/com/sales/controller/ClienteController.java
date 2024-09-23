package br.com.sales.controller;

import br.com.sales.domain.ClienteModel;
import br.com.sales.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody // converts the method return into a JSON type object
    public ResponseEntity getClienteById(@PathVariable UUID id){
        Optional<ClienteModel> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

}
