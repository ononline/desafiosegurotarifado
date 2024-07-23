package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

/**
 * Entidade de comunicação responsável por receber os dados de criação de produto
 * @param nome
 * @param categoria
 * @param preco_base
 */
public record CreateProdutoRequest(
        String nome,
        String categoria,
        Double preco_base
) {
}
