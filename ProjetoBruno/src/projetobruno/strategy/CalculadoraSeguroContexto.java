package projetobruno.strategy;

/**
 * Classe de contexto que gerencia e executa a estratégia de cálculo selecionada.
 * Permite a troca dinâmica do algoritmo de cálculo em tempo de execução.
 */
public class CalculadoraSeguroContexto {
    private CalculoSeguroStrategy estrategia;

    /**
     * Define ou altera a estratégia de cálculo atual.
     * * @param estrategia Objeto que implementa a interface CalculoSeguroStrategy.
     */
    public void setEstrategia(CalculoSeguroStrategy estrategia) {
        this.estrategia = estrategia;
    }

    /**
     * Executa o cálculo delegando a responsabilidade para a estratégia ativa.
     * * @param valorBase Valor base do seguro.
     * @param quantidadeVeiculos Quantidade de veículos.
     * @param idadeCondutor Idade do condutor.
     * @throws IllegalStateException Caso nenhuma estratégia tenha sido definida antes da execução.
     * @return O valor final calculado pela estratégia escolhida.
     */
    public double executarCalculo(double valorBase, int quantidadeVeiculos, int idadeCondutor) {

        if (this.estrategia == null) {
            throw new IllegalStateException("Nenhuma estratégia de cálculo foi definida.");
        }

        // Valida idade informada pelo condutor
        if (idadeCondutor < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }

        return this.estrategia.calcular(
                valorBase,
                quantidadeVeiculos,
                idadeCondutor
        );
    }
}