package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

public class ResidencialCategoriaStrategy implements CategoriaStrategy{
    @Override
    public double calcularTarifas(double precoBase) {
        double iof = 0.04;
        double cofins = 0.03;
        return precoBase + (precoBase * iof) + (precoBase * cofins);
    }
}
