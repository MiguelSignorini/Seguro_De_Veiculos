// Author: Jonata
package projetobruno.strategy;

/**
 * Estratégia concreta aplicada a veículos esportivos.
 * Aplica um acréscimo no valor do prêmio devido ao maior risco.
 */
public class VeiculoEsportivoStrategy implements CalculoStrategy {

    @Override
    public double calcular(double valorBase) {

        // Aplica acréscimo de 30% sobre o valor base
        return valorBase * 1.30; // acréscimo de 30%
    }
}
