package br.com.sales.controller;

import br.com.sales.domain.ClienteModel;
import br.com.sales.domain.ProdutoModel;
import br.com.sales.repository.ClienteRepository;
import br.com.sales.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController (ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel save(@RequestBody ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

}
