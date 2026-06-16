package projetobruno.strategy;

/**
 * Estratégia de cálculo voltada para frotas comerciais (Requisito RF040).
 * Aplica descontos progressivos baseados na quantidade de veículos.
 */
public class EstrategiaFrotaComercial implements CalculoSeguroStrategy {

    /**
     * Calcula o seguro aplicando desconto de 10% para frotas a partir de 5 veículos
     * ou 5% para frotas menores.
     * * @param valorBase Valor base por veículo.
     * @param quantidadeVeiculos Total de veículos da frota.
     * @param idadeCondutor Idade do condutor (não impacta nesta estratégia).
     * @return Valor total da frota com o desconto aplicado.
     */
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