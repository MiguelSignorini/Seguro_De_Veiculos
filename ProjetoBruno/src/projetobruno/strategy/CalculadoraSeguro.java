// Author: Jonata
package projetobruno.strategy;

/**
 * Classe de contexto do padrão Strategy.
 * Responsável por delegar o cálculo do prêmio à estratégia configurada.
 */
public class CalculadoraSeguro {

    // Estratégia de cálculo atualmente configurada
    private CalculoStrategy strategy;

    // Define/altera a estratégia de cálculo a ser utilizada
    public void setStrategy(CalculoStrategy strategy) {
        this.strategy = strategy;
    }

    // Calcula o prêmio do seguro utilizando a estratégia definida
    public double calcularPremio(double valorBase) {

        // Garante que uma estratégia foi definida antes do cálculo
        if (strategy == null) {
            throw new IllegalStateException("Nenhuma estratégia definida.");
        }

        // Delega o cálculo para a estratégia configurada
        return strategy.calcular(valorBase);
    }
}
