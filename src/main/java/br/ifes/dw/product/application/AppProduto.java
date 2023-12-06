package br.ifes.dw.product.application;

import br.ifes.dw.product.dto.ProdutoInputDTO;
import br.ifes.dw.product.exception.IdInvalidoException;
import br.ifes.dw.product.exception.NotFoundException;
import br.ifes.dw.product.model.ProdutoModel;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppProduto {

    private final List<ProdutoModel> produtos = new ArrayList<>();
    private AtomicLong lastId = new AtomicLong(0);


    public List<ProdutoModel> getAll() {
        return produtos;
    }

    public ProdutoModel create(ProdutoInputDTO produtoInputDTO) {
        long newId = lastId.incrementAndGet();
        ProdutoModel produto = new ProdutoModel();
        produto.setId(newId);
        produto.setNome(produtoInputDTO.getNome());
        produto.setPreco(produtoInputDTO.getPreco());
        produtos.add(produto);

        return produto;
    }

    public void delete(long id) {
        this.produtos.removeIf(produtoModel -> produtoModel.getId() == id);
    }

    public ProdutoModel getById(long id) throws NotFoundException, IdInvalidoException {
        if (id <= 0) {
            throw new IdInvalidoException();
        }
        for (ProdutoModel produto : this.produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        throw new NotFoundException();
    }
}
