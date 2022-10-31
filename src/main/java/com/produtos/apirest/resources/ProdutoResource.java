package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value="Retorna uma lista de Produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return (produtoRepository.findAll());
    }

    @ApiOperation(value="Retorna um produto unico")
    @GetMapping("/produtos/{id}")
    public Produto listaProdutosUnico(@PathVariable(value = "id") long id) {
        return (produtoRepository.findById(id));
    }

    @ApiOperation(value="Salvar um produto")
    @PostMapping("/produto")
    public Produto savaProduto(@RequestBody Produto produto) {
        return (produtoRepository.save(produto));
    }

    @ApiOperation(value="Deleta um produto")
    @DeleteMapping("/produto")
    public void deltaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @ApiOperation(value="Atualiza um produto")
    @PutMapping("/produto")
    public Produto atalizaProduto(@RequestBody Produto produto) {
        return (produtoRepository.save(produto));
    }

}
