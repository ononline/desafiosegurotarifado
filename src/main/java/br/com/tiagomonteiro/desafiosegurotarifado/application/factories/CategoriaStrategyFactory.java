package br.com.tiagomonteiro.desafiosegurotarifado.application.factories;

import br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria.*;

/**
 * Responsável por instanciar e gerir as instâncias das Strategies de cálculo de tarifas
 */
public class CategoriaStrategyFactory {
    
    private final VidaCategoriaStrategy vidaCategoriaStrategy;
    private final AutoCategoriaStrategy autoCategoriaStrategy;
    private final ViagemCategoriaStrategy viagemCategoriaStrategy;
    private final ResidencialCategoriaStrategy residencialCategoriaStrategy;
    private final PatrimonialCategoriaStrategy patrimonialCategoriaStrategy;
    
    public CategoriaStrategyFactory() {
        this.vidaCategoriaStrategy = new VidaCategoriaStrategy();
        this.autoCategoriaStrategy = new AutoCategoriaStrategy();
        this.viagemCategoriaStrategy = new ViagemCategoriaStrategy();
        this.residencialCategoriaStrategy = new ResidencialCategoriaStrategy();
        this.patrimonialCategoriaStrategy = new PatrimonialCategoriaStrategy();
    }
    
    public CategoriaStrategy getStrategy(String categoria) throws IllegalArgumentException {
        if("VIDA".equals(categoria))
            return vidaCategoriaStrategy;
        if("AUTO".equals(categoria))
            return autoCategoriaStrategy;
        if("VIAGEM".equals(categoria))
            return viagemCategoriaStrategy;
        if("RESIDENCIAL".equals(categoria))
            return residencialCategoriaStrategy;
        if("PATRIMONIAL".equals(categoria))
            return patrimonialCategoriaStrategy;
        
        throw new IllegalArgumentException("Categoria do produto inválida");
    }
}
