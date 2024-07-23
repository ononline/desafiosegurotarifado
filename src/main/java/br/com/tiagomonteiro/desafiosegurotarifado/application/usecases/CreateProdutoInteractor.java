package br.com.tiagomonteiro.desafiosegurotarifado.application.usecases;

import br.com.tiagomonteiro.desafiosegurotarifado.application.gateways.ProdutoGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;

/**
 * Responsável por realizar a ligação entre ProdutoGateway e o Controller, para criação de novo Produto na base de dados
 */
public class CreateProdutoInteractor {
    
    private final ProdutoGateway produtoGateway;
    
    public CreateProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }
    
    public Produto createProduto(Produto produto){
        return produtoGateway.createProduto(produto);
    }
}
