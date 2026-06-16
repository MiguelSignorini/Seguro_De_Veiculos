package projetobruno.strategy;

/**
 * Interface que define o contrato para as estratégias de cálculo de seguro.
 * Atende ao padrão de projeto GoF Strategy.
 */
public interface CalculoSeguroStrategy {

    /**
     * Realiza o cálculo do valor do seguro com base nos parâmetros fornecidos.
     * * @param valorBase Valor inicial de referência para o seguro.
     * @param quantidadeVeiculos Número de veículos incluídos na apólice.
     * @param idadeCondutor Idade do condutor principal do veículo.
     * @return O valor final calculado do seguro.
     */
    double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor);
}