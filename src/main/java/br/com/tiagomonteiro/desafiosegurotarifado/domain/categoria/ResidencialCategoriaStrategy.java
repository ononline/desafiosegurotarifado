package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

/**
 * Implementação da estratégia de cálculo de tarifas para categoria "RESIDENCIAL"
 */
public class ResidencialCategoriaStrategy implements CategoriaStrategy{
    @Override
    public double calcularTarifas(double precoBase) {
        double iof = 0.04;
        double cofins = 0.03;
        return precoBase + (precoBase * iof) + (precoBase * cofins);
    }
}
