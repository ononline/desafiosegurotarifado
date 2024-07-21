package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoEntity;

public class ProdutoEntityMapper {
    ProdutoEntity toEntity(Produto produtoDomainObj){
        return new ProdutoEntity(
                null,
                produtoDomainObj.nome(),
                produtoDomainObj.categoria(),
                produtoDomainObj.precoBase(),
                produtoDomainObj.precoTarifado()
        );
    }
    
    Produto toDomainObj(ProdutoEntity produtoEntity){
        return new Produto(
                produtoEntity.getId().toString(),
                produtoEntity.getNome(),
                produtoEntity.getCategoria(),
                produtoEntity.getPreco_base(),
                produtoEntity.getPreco_tarifado()
        );
    }
}
