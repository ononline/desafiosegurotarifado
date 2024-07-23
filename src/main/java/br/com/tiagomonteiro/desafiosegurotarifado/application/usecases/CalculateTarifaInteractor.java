package br.com.tiagomonteiro.desafiosegurotarifado.application.usecases;

import br.com.tiagomonteiro.desafiosegurotarifado.application.factories.CategoriaStrategyFactory;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria.CategoriaStrategy;

/**
 * Responsável por abstrair a execução do cálculo de tarifas conforme a categoria do produto
 */
public class CalculateTarifaInteractor {
    private CategoriaStrategy categoriaStrategy;
    private final CategoriaStrategyFactory categoriaStrategyFactory;
    
    public CalculateTarifaInteractor(CategoriaStrategyFactory categoriaStrategyFactory) {
        this.categoriaStrategyFactory = categoriaStrategyFactory;
    }
    
    public void setStrategy(String categoria) throws IllegalArgumentException {
        this.categoriaStrategy = categoriaStrategyFactory.getStrategy(categoria);
    }
    
    public double calcularTarifas(double precoBase){
        return categoriaStrategy.calcularTarifas(precoBase);
    }
}
