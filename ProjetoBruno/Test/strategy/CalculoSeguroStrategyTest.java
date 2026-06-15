package projetobruno.strategy;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculoSeguroStrategyTest {

    @Test
    public void testRF040_ExecutarCalculoEmpresarialFrotaComDesconto() {
        CalculadoraSeguroContexto contexto = new CalculadoraSeguroContexto();
        double valorBasePorVeiculo = 1000.0;
        int quantidadeFrota = 5;
        int idadeCondutor = 40;

        contexto.setEstrategia(new EstrategiaFrotaComercial());
        double resultadoObtido = contexto.executarCalculo(valorBasePorVeiculo, quantidadeFrota, idadeCondutor);

        double resultadoEsperado = 4500.0;
        assertEquals(resultadoEsperado, resultadoObtido, 0.001);
    }

    @Test
    public void testRF041_ExecutarCalculoCondutorJovemComRiscoAgravado() {
        CalculadoraSeguroContexto contexto = new CalculadoraSeguroContexto();
        double valorBaseVeiculo = 1000.0;
        int quantidadeVeiculos = 1;
        int idadeCondutorJovem = 22;

        contexto.setEstrategia(new EstrategiaCondutorJovem());
        double resultadoObtido = contexto.executarCalculo(valorBaseVeiculo, quantidadeVeiculos, idadeCondutorJovem);

        double resultadoEsperado = 1300.0;
        assertEquals(resultadoEsperado, resultadoObtido, 0.001);
    }
}