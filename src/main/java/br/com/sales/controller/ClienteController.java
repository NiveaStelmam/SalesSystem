package br.com.sales.controller;

import br.com.sales.domain.ClienteModel;
import br.com.sales.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;

    }


    @GetMapping("/listar-por-id/{id}")
    @ResponseBody // converts the method return into a JSON type object
    public ResponseEntity getClienteById(@PathVariable UUID id){
        System.out.println("AQUIIII");
        Optional<ClienteModel> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/cadastrar")
    @ResponseBody
    public ResponseEntity save(@RequestBody ClienteModel cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable UUID id){
        Optional<ClienteModel> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/atualizar/{id}")
    @ResponseBody
    public ResponseEntity update( @PathVariable UUID id,
                                  @RequestBody ClienteModel cliente ){
        return clienteRepository
                .findById(id)
                .map( clienteExistente -> { // se o optional estiver populado, o map é executado
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

//    ------ Outra forma ------------
//    @PutMapping("/atualizar/{id}")
//    @ResponseBody
//    public ResponseEntity update(@PathVariable UUID id, @RequestBody ClienteModel cliente) {
//        return clienteRepository.findById(id).map(clienteExistente -> {
//            BeanUtils.copyProperties(cliente, clienteExistente, "id");
//            clienteRepository.save(clienteExistente);
//            return ResponseEntity.noContent().build();
//        }).orElseGet(() -> ResponseEntity.notFound().build());
//    }

}

