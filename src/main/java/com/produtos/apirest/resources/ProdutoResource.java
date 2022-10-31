package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return (produtoRepository.findAll());
    }

    @GetMapping("/produtos/{id}")
    public Produto listaProdutosUnico(@PathVariable(value = "id") long id) {
        return (produtoRepository.findById(id));
    }

    @PostMapping("/produto")
    public Produto savaProduto(@RequestBody Produto produto) {
        return (produtoRepository.save(produto));
    }

    @DeleteMapping("/produto")
    public void deltaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    public Produto atalizaProduto(@RequestBody Produto produto) {
        return (produtoRepository.save(produto));
    }

}
