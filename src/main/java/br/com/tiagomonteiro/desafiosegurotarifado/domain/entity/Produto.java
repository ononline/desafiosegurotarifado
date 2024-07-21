package br.com.tiagomonteiro.desafiosegurotarifado.domain.entity;

public record Produto(
        String id,
        String nome,
        String categoria,
        Double preco_base,
        Double preco_tarifado) {
}
