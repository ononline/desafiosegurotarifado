package br.com.tiagomonteiro.desafiosegurotarifado.application.usecases;

import br.com.tiagomonteiro.desafiosegurotarifado.application.factories.CategoriaStrategyFactory;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria.CategoriaStrategy;

public class CalculateTarifaInteractor {
    private CategoriaStrategy categoriaStrategy;
    private final CategoriaStrategyFactory categoriaStrategyFactory;
    
    public CalculateTarifaInteractor(CategoriaStrategyFactory categoriaStrategyFactory) {
        this.categoriaStrategyFactory = categoriaStrategyFactory;
    }
    
    public void setStrategy(String categoria) throws IllegalAccessException {
        this.categoriaStrategy = categoriaStrategyFactory.getStrategy(categoria);
    }
    
    public double calcularTarifas(double precoBase){
        return categoriaStrategy.calcularTarifas(precoBase);
    }
}
