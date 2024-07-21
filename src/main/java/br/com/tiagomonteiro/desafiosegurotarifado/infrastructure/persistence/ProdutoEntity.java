package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence;

import org.springframework.data.annotation.Id;

public record ProdutoEntity(
        @Id
        String id,
        String nome,
        String categoria,
        Double preco_base,
        Double preco_tarifado
) {
}
