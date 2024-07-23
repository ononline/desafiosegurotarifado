package br.com.tiagomonteiro.desafiosegurotarifado.application.gateways;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;

/**
 * Contrato sobre como a camada de infrastructure deve tratar os Produtos
 */
public interface ProdutoGateway {
    Produto createProduto(Produto produto);
}
