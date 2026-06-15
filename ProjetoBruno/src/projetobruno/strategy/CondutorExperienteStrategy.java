// Author: Jonata
package projetobruno.strategy;

/**
 * Estratégia concreta aplicada a condutores experientes.
 * Concede um desconto no valor do prêmio.
 */
public class CondutorExperienteStrategy implements CalculoStrategy {

    @Override
    public double calcular(double valorBase) {

        // Aplica desconto de 20% sobre o valor base
        return valorBase * 0.80; // desconto de 20%
    }
}
