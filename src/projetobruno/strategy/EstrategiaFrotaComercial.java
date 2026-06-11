package projetobruno.strategy;

public class EstrategiaFrotaComercial implements projetobruno.strategy.CalculoSeguroStrategy {
    @Override
    public double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor) {

        double valorTotal = valorBase * quantidadeVeiculos;


        if (quantidadeVeiculos >= 5) {
            valorTotal = valorTotal * 0.90;
        } else if (quantidadeVeiculos > 1) {
            valorTotal = valorTotal * 0.95;
        }

        return valorTotal;
    }
}