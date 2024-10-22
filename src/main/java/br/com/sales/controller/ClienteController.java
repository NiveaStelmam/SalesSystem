package br.com.sales.controller;

import br.com.sales.domain.ClienteModel;
import br.com.sales.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;

    }

    @GetMapping("/listar-por-id/{id}")
    public ClienteModel getClienteById(@PathVariable UUID id){
       return clienteRepository
               .findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel save(@RequestBody ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable UUID id){
        clienteRepository
                .findById(id)
                .map( clienteModel -> {
                    clienteRepository.delete(clienteModel);
                    return clienteModel;

                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));


    }

    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable UUID id,
                                  @RequestBody ClienteModel cliente ){
        clienteRepository
                .findById(id)
                .map( clienteExistente -> { // se o optional estiver populado, o map é executado
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping("/listar-todos")
    public List<ClienteModel> findByParameter(ClienteModel filter){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase() // considera valores de strings maiusculas/minusculas
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return clienteRepository.findAll(example);

    }

//    ------ Outra forma ------------
//    @PutMapping("/atualizar/{id}")
//    public ResponseEntity update(@PathVariable UUID id, @RequestBody ClienteModel cliente) {
//        return clienteRepository.findById(id).map(clienteExistente -> {
//            BeanUtils.copyProperties(cliente, clienteExistente, "id");
//            clienteRepository.save(clienteExistente);
//            return ResponseEntity.noContent().build();
//        }).orElseGet(() -> ResponseEntity.notFound().build());
//    }

}

