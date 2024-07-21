package br.com.tiagomonteiro.desafiosegurotarifado.application.gateways;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;

public interface ProdutoGateway {
    Produto createProduto(Produto produto);
}
