package projetobruno.strategy;

public interface CalculoSeguroStrategy {
    // Método padrão que todas as estratégias de cálculo terão que seguir
    double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor);
}