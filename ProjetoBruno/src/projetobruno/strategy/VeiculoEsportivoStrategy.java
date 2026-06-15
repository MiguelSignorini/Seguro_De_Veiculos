package projetobruno.strategy;

public class VeiculoEsportivoStrategy implements CalculoStrategy {

    @Override
    public double calcular(double valorBase) {

        return valorBase * 1.30; // acréscimo de 30%
    }
}