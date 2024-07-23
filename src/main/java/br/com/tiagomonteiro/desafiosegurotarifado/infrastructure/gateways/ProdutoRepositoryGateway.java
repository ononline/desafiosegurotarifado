package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways;

import br.com.tiagomonteiro.desafiosegurotarifado.application.gateways.ProdutoGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoEntity;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoRepository;

/**
 * Implementação de serviço responsável por coordenar as transformações e persistência do produto
 */
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
        produtoRepository.findByNome(produtoEntity.getNome()).ifPresent(produtoEntity1 -> produtoEntity.setId(produtoEntity1.getId()));
        ProdutoEntity savedObj = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toDomainObj(savedObj);
    }
}