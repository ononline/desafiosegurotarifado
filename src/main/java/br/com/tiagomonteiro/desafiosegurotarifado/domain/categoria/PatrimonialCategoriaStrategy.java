package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

/**
 * Implementação da estratégia de cálculo de tarifas para categoria "PATRIMONIAL"
 */
public class PatrimonialCategoriaStrategy implements CategoriaStrategy{
    @Override
    public double calcularTarifas(double precoBase) {
        double iof = 0.05;
        double pis = 0.03;
        return precoBase + (precoBase * iof) + (precoBase * pis);
    }
}
