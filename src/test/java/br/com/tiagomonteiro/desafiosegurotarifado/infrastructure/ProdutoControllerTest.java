package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure;

import br.com.tiagomonteiro.desafiosegurotarifado.application.factories.CategoriaStrategyFactory;
import br.com.tiagomonteiro.desafiosegurotarifado.application.gateways.ProdutoGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CalculateTarifaInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CreateProdutoInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers.CreateProdutoRequest;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers.CreateProdutoResponse;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers.ProdutoController;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers.ProdutoDTOMapper;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways.ProdutoEntityMapper;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.gateways.ProdutoRepositoryGateway;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoEntity;
import br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProdutoControllerTest {
    
    private ProdutoController produtoController;
    
    @Mock
    private ProdutoRepository produtoRepository;
    
    public void configurarTeste(){
        ProdutoEntityMapper produtoEntityMapper = new ProdutoEntityMapper();
        ProdutoGateway produtoGateway = new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
        CreateProdutoInteractor createProdutoInteractor = new CreateProdutoInteractor(produtoGateway);
        ProdutoDTOMapper dtoMapper = new ProdutoDTOMapper();
        CategoriaStrategyFactory categoriaFactory = new CategoriaStrategyFactory();
        CalculateTarifaInteractor calculateTarifa = new CalculateTarifaInteractor(categoriaFactory);
        this.produtoController = new ProdutoController(createProdutoInteractor, dtoMapper, calculateTarifa);
    }
    
    @ParameterizedTest
    @MethodSource("categoriaAndResultadoProvider")
    public void testCreateProdutoSucesso(String categoria, double resultado) throws Exception{
        configurarTeste();
        
        CreateProdutoRequest request = new CreateProdutoRequest("Teste", categoria, 100.00);
        when(produtoRepository.save(any(ProdutoEntity.class))).thenAnswer(a -> a.getArguments()[0]);
        when(produtoRepository.findByNome(any(String.class))).thenAnswer(a -> Optional.of(new ProdutoEntity(UUID.randomUUID(),"","",0.0,0.0)));
        
        CreateProdutoResponse response = produtoController.create(request);
        
        assertEquals(categoria, response.categoria());
        assertEquals(resultado, response.preco_tarifado());
    }
    
    static Stream<Arguments> categoriaAndResultadoProvider() {
        return Stream.of(
                arguments("VIDA", 103.20),
                arguments("AUTO", 110.50),
                arguments("VIAGEM", 107.00),
                arguments("RESIDENCIAL", 107.00),
                arguments("PATRIMONIAL", 108.00)
        );
    }
    
    @Test
    public void testCreateProdutoInvalido(){
        configurarTeste();
        
        CreateProdutoRequest request = new CreateProdutoRequest("Teste", "OUTROS", 100.00);
        when(produtoRepository.save(any(ProdutoEntity.class))).thenAnswer(a -> a.getArguments()[0]);
        when(produtoRepository.findByNome(any(String.class))).thenAnswer(a -> Optional.of(new ProdutoEntity(UUID.randomUUID(),"","",0.0,0.0)));
        
        assertThrows(IllegalArgumentException.class, () -> produtoController.create(request));
    }
}
