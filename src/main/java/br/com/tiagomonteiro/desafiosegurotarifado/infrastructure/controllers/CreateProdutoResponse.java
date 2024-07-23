package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

/**
 * Entidade de infraestrutura responsável pela resposta de criação de produto
 * @param id
 * @param nome
 * @param categoria
 * @param preco_base
 * @param preco_tarifado
 */
public record CreateProdutoResponse(
        String id,
        String nome,
        String categoria,
        Double preco_base,
        Double preco_tarifado
) {
}
