package br.com.tiagomonteiro.desafiosegurotarifado.domain.categoria;

/**
 * Abstração para as Strategies de cálculo de tarifas
 */
public interface CategoriaStrategy {
    double calcularTarifas(double precoBase);
}
