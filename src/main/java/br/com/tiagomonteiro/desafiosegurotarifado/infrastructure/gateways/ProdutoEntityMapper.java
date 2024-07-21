package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoEntity;

public class ProdutoEntityMapper {
    ProdutoEntity toEntity(Produto produtoDomainObj){
        return new ProdutoEntity(
                produtoDomainObj.id(),
                produtoDomainObj.nome(),
                produtoDomainObj.categoria(),
                produtoDomainObj.preco_base(),
                produtoDomainObj.preco_tarifado()
        );
    }
    
    Produto toDomainObj(ProdutoEntity produtoEntity){
        return new Produto(
                produtoEntity.id(),
                produtoEntity.nome(),
                produtoEntity.categoria(),
                produtoEntity.preco_base(),
                produtoEntity.preco_tarifado()
        );
    }
}
