package projetobruno.strategy;

public class CalculadoraSeguroContexto {
    private projetobruno.strategy.CalculoSeguroStrategy estrategia;

    public void setEstrategia(projetobruno.strategy.CalculoSeguroStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double executarCalculo(double valorBase, int quantidadeVeiculos, int idadeCondutor) {
        if (this.estrategia == null) {
            throw new IllegalStateException("Nenhuma estratégia de cálculo foi definida.");
        }
        return this.estrategia.calcular(valorBase, quantidadeVeiculos, idadeCondutor);
    }
}