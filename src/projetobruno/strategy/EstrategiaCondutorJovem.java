package projetobruno.strategy;

public class EstrategiaCondutorJovem implements projetobruno.strategy.CalculoSeguroStrategy {
    @Override
    public double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor) {
        // Elevação proporcional da taxa devido ao risco estatístico (Adicional de 30% para jovens)
        double taxaAgravada = 1.30;
        return valorBase * quantidadeVeiculos * taxaAgravada;
    }
}