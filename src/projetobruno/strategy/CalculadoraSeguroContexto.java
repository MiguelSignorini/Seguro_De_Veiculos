package projetobruno.strategy;

public class CalculadoraSeguroContexto {
    private projetobruno.strategy.CalculoSeguroStrategy estrategia;

    // Método que permite alterar o motor de cálculo dinamicamente dependendo do cenário
    public void setEstrategia(projetobruno.strategy.CalculoSeguroStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double executarCalculo(double valorBase, int quantidadeVeiculos, int idadeCondutor) {
        // Validação de segurança caso o sistema tente calcular sem definir uma estratégia antes
        if (this.estrategia == null) {
            throw new IllegalStateException("Nenhuma estratégia de cálculo foi definida.");
        }
        return this.estrategia.calcular(valorBase, quantidadeVeiculos, idadeCondutor);
    }
}