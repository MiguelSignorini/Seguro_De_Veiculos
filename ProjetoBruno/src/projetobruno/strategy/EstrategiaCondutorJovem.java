package projetobruno.strategy;

/**
 * Estratégia de cálculo para condutores considerados jovens (Requisito RF041).
 * Aplica uma taxa de agravo devido ao perfil de risco.
 */
public class EstrategiaCondutorJovem implements CalculoSeguroStrategy {

    /**
     * Calcula o seguro adicionando uma taxa de risco de 30% sobre o valor base.
     * * @param valorBase Valor base do seguro.
     * @param quantidadeVeiculos Quantidade de veículos.
     * @param idadeCondutor Idade do condutor jovem.
     * @return Valor do seguro com o acréscimo de risco.
     */
    @Override
    public double calcular(double valorBase, int quantidadeVeiculos, int idadeCondutor) {
        double taxaAgravada = 1.30;
        return valorBase * quantidadeVeiculos * taxaAgravada;
    }
}