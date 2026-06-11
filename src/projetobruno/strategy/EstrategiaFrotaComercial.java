package projetobruno.strategy;

public class EstrategiaFrotaComercial implements projetobruno.strategy.CalculoSeguroStrategy {
    @Override
    public double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor) {
        // Multiplica o valor base pela quantidade de veículos da frota
        double valorTotal = valorBase * quantidadeVeiculos;

        // Aplicação automática do desconto progressivo por quantidade exigido pelo professor
        if (quantidadeVeiculos >= 5) {
            valorTotal = valorTotal * 0.90; // 10% de desconto para frotas grandes
        } else if (quantidadeVeiculos > 1) {
            valorTotal = valorTotal * 0.95; // 5% de desconto para frotas pequenas
        }

        return valorTotal;
    }
}