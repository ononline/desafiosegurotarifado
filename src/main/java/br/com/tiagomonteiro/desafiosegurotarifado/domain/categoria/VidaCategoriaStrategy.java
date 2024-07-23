package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

/**
 * Implementação da estratégia de cálculo de tarifas para categoria "VIDA"
 */
public class VidaCategoriaStrategy implements CategoriaStrategy{
    @Override
    public double calcularTarifas(double precoBase) {
        double iof = 0.01;
        double pis = 0.022;
        return precoBase + (precoBase * iof) + (precoBase * pis);
    }
}
