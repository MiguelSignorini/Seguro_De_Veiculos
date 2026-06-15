package projetobruno.strategy;

public class CalculadoraSeguro {

    private CalculoStrategy strategy;

    public void setStrategy(CalculoStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcularPremio(double valorBase) {

        if (strategy == null) {
            throw new IllegalStateException("Nenhuma estratégia definida.");
        }

        return strategy.calcular(valorBase);
    }
} 