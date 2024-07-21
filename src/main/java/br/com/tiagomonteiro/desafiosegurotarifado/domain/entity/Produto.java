package br.com.tiagomonteiro.desafiosegurotarifado.domain.entity;

public record Produto(
        String id,
        String nome,
        String categoria,
        Double precoBase,
        Double precoTarifado) {
}
