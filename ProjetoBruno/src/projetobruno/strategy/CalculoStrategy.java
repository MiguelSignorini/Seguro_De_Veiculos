package projetobruno.strategy;

/**
 * Interface Strategy que define o contrato para os diferentes
 * algoritmos de cálculo de prêmio do seguro.
 */
public interface CalculoStrategy {

    // Calcula o valor final do prêmio com base no valor base fornecido
    double calcular(double valorBase);
}