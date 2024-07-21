package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

public record CreateProdutoRequest(
        String nome,
        String categoria,
        Double preco_base
) {
}
