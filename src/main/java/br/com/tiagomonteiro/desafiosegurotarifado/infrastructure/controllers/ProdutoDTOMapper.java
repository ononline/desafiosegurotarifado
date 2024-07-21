package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;

public class ProdutoDTOMapper {
    CreateProdutoResponse toResponse(Produto produto){
        return new CreateProdutoResponse(
                produto.id(),
                produto.nome(),
                produto.categoria(),
                produto.preco_base(),
                produto.preco_tarifado()
        );
    }
    
    Produto toProduto(CreateProdutoRequest request){
        return new Produto(
                null,
                request.nome(),
                request.categoria(),
                request.preco_base(),
                null
        );
    }
}
