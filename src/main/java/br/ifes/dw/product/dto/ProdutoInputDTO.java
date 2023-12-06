package br.ifes.dw.product.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProdutoInputDTO {
    @NotBlank
    private String nome;

    @NotNull
    private double preco;
}
