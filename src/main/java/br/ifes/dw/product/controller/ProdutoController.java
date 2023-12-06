package br.ifes.dw.product.controller;

// ProdutoController
import br.ifes.dw.product.application.AppProduto;
import br.ifes.dw.product.dto.ProdutoInputDTO;
import br.ifes.dw.product.exception.IdInvalidoException;
import br.ifes.dw.product.exception.NotFoundException;
import br.ifes.dw.product.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private AppProduto appProduto;

    @GetMapping("/")
    public List<ProdutoModel> getAll() {
        List<ProdutoModel> produtos = appProduto.getAll();
        // Adicione um log para depuração
        System.out.println("Lista de produtos obtida com sucesso: " + produtos);
        return produtos;
    }


    @PostMapping("/")
    public List<ProdutoModel> createProdutos(@RequestBody List<ProdutoInputDTO> produtos) {
        System.out.println("Recebendo solicitação POST com dados: " + produtos);
        List<ProdutoModel> produtosCriados = new ArrayList<>();

        for (ProdutoInputDTO produto : produtos) {
            ProdutoModel produtoCriado = appProduto.create(produto);
            produtosCriados.add(produtoCriado);
        }

        return produtosCriados;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){appProduto.delete(id);}

    @GetMapping("/{id}")
    public ProdutoModel getById(@PathVariable long id) {
        try {
            return appProduto.getById(id);
        } catch (IdInvalidoException e) {
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
