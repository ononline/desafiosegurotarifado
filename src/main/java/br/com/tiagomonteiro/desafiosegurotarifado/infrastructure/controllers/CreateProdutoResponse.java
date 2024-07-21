package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

public record CreateProdutoResponse(
        String id,
        String nome,
        String categoria,
        Double preco_base,
        Double preco_tarifado
) {
}
