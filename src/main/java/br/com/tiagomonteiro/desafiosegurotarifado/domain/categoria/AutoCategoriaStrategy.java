package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

/**
 * Implementação da estratégia de cálculo de tarifas para categoria "AUTO"
 */
public class AutoCategoriaStrategy implements CategoriaStrategy{
    
    @Override
    public double calcularTarifas(double precoBase) {
        double iof = 0.055;
        double pis = 0.04;
        double cofins = 0.01;
        return precoBase + (precoBase * iof) + (precoBase * pis) + (precoBase * cofins);
    }
}
