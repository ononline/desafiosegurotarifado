package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways;

import br.com.tiagomonteiro.desafiosegurotarifado.application.gateways.ProdutoGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoEntity;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoRepository;

public class ProdutoRepositoryGateway implements ProdutoGateway {
    
    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;
    
    public ProdutoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoEntityMapper = produtoEntityMapper;
    }
    
    
    @Override
    public Produto createProduto(Produto produtoDomainObj) {
        ProdutoEntity produtoEntity = produtoEntityMapper.toEntity(produtoDomainObj);
        ProdutoEntity savedObj = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toDomainObj(savedObj);
    }
}
