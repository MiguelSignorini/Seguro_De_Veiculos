package projetobruno.strategy;

public class CondutorExperienteStrategy implements CalculoStrategy {

    @Override
    public double calcular(double valorBase) {

        return valorBase * 0.80; // desconto de 20%
    }
}