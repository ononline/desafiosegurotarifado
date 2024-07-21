package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

public class VidaCategoriaStrategy implements CategoriaStrategy{
    @Override
    public double calcularTarifas(double precoBase) {
        double iof = 0.01;
        double pis = 0.022;
        return precoBase + (precoBase * iof) + (precoBase * pis);
    }
}
