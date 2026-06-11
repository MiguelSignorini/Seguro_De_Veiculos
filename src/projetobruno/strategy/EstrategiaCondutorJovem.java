package projetobruno.strategy;

public class EstrategiaCondutorJovem implements projetobruno.strategy.CalculoSeguroStrategy {
    @Override
    public double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor) {
        double taxaAgravada = 1.30;
        return valorBase * quantidadeVeiculos * taxaAgravada;
    }
}