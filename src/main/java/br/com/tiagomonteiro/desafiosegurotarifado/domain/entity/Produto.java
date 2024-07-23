package br.com.tiagomonteiro.desafiosegurotarifado.domain.entity;

/**
 * Entidade de domínio para o produto
 * @param id Identificador único com formato UUID
 * @param nome
 * @param categoria
 * @param precoBase Preço sem tarifa calculada
 * @param precoTarifado Preço com tarifa calculada
 */
public record Produto(
        String id,
        String nome,
        String categoria,
        Double precoBase,
        Double precoTarifado) {
}
