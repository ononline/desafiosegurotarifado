package br.com.tiagomonteiro.desafiosegurotarifado.application;

import br.com.tiagomonteiro.desafiosegurotarifado.application.factories.CategoriaStrategyFactory;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoriaStrategyFactoryTest {
    
    @Test
    public void testRetornoDeStrategiesCorreta(){
        CategoriaStrategyFactory factory = new CategoriaStrategyFactory();
        
        assertInstanceOf(VidaCategoriaStrategy.class, factory.getStrategy("VIDA"));
        assertInstanceOf(AutoCategoriaStrategy.class, factory.getStrategy("AUTO"));
        assertInstanceOf(ViagemCategoriaStrategy.class, factory.getStrategy("VIAGEM"));
        assertInstanceOf(ResidencialCategoriaStrategy.class, factory.getStrategy("RESIDENCIAL"));
        assertInstanceOf(PatrimonialCategoriaStrategy.class, factory.getStrategy("PATRIMONIAL"));
        assertThrows(IllegalArgumentException.class, () -> factory.getStrategy("OUTRO"));
        
    }
}
