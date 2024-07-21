package br.com.tiagomonteiro.desafiosegurotarifado.main;

import br.com.tiagomonteiro.desafiosegurotarifado.application.factories.CategoriaStrategyFactory;
import br.com.tiagomonteiro.desafiosegurotarifado.application.gateways.ProdutoGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CalculateTarifaInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CreateProdutoInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers.ProdutoDTOMapper;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways.ProdutoEntityMapper;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways.ProdutoRepositoryGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {
    
    @Bean
    CreateProdutoInteractor createProdutoInteractor(ProdutoGateway produtoGateway){
        return new CreateProdutoInteractor(produtoGateway);
    }
    
    @Bean
    CalculateTarifaInteractor calculateTarifaInteractor(){
        return new CalculateTarifaInteractor(new CategoriaStrategyFactory());
    }
    
    @Bean
    ProdutoGateway produtoGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper){
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
    }
    
    @Bean
    ProdutoEntityMapper produtoEntityMapper(){
        return new ProdutoEntityMapper();
    }
    
    @Bean
    ProdutoDTOMapper produtoDTOMapper(){
        return new ProdutoDTOMapper();
    }
}
