package br.com.tiagomonteiro.desafiosegurotarifado.application;

import br.com.tiagomonteiro.desafiosegurotarifado.application.factories.CategoriaStrategyFactory;
import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CalculateTarifaInteractor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class CalculateTarifaInteractorTest {
    
    @ParameterizedTest
    @MethodSource("categoriaAndResultadoProvider")
    public void testCalculaTarifa(String categoria, double resultado) throws Exception{
        CalculateTarifaInteractor calculateTarifa = new CalculateTarifaInteractor(new CategoriaStrategyFactory());
        
        calculateTarifa.setStrategy(categoria);
        
        assertEquals(resultado, calculateTarifa.calcularTarifas(100.00));
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
}
