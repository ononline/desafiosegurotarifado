package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;

/**
 * Classe de serviço responsável por transformar objetos entre a entidade de domínio e a resposta do endpoint
 */
public class ProdutoDTOMapper {
    CreateProdutoResponse toResponse(Produto produto){
        return new CreateProdutoResponse(
                produto.id(),
                produto.nome(),
                produto.categoria(),
                produto.precoBase(),
                produto.precoTarifado()
        );
    }
    
    Produto toProduto(CreateProdutoRequest request, double precoTarifado){
        return new Produto(
                null,
                request.nome(),
                request.categoria(),
                request.preco_base(),
                precoTarifado
        );
    }
}
