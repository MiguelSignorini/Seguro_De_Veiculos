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
    /**
 * Testes unitários do padrão Strategy.
 *S
 * RF042 - Condutor Experiente
 * RF043 - Veículo Esportivo
 *
 * @author Jonata Vendola
 * @version 1.0
 */
    // ════════════════════════════════════════════════════════════
    // RF042 — CENÁRIO ALTERNATIVO
    // Cliente experiente recebe bônus
    // ════════════════════════════════════════════════════════════

    @Test
    public void rf042_deveAplicarBonusCondutorExperiente() {

        // Arrange
        CalculadoraSeguro calculadora = new CalculadoraSeguro();

        calculadora.setStrategy(
                new CondutorExperienteStrategy()
        );

        double premioBase = 2000.00;

        // Act
        double premioFinal =
                calculadora.calcularPremio(premioBase);

        // Assert
        assertEquals(
                1600.00,
                premioFinal,
                0.01
        );
    }

    // ════════════════════════════════════════════════════════════
    // RF043 — CENÁRIO ALTERNATIVO
    // Veículo esportivo possui risco maior
    // ════════════════════════════════════════════════════════════

    @Test
    public void rf043_deveAplicarAcrescimoVeiculoEsportivo() {

        // Arrange
        CalculadoraSeguro calculadora = new CalculadoraSeguro();

        calculadora.setStrategy(
                new VeiculoEsportivoStrategy()
        );

        double premioBase = 2000.00;

        // Act
        double premioFinal =
                calculadora.calcularPremio(premioBase);

        // Assert
        assertEquals(
                2600.00,
                premioFinal,
                0.01
        );
    }

    // ════════════════════════════════════════════════════════════
    // RF044 — CENÁRIO DE EXCESSÃO
    // trata falha ao selecionar estratégia
    // ════════════════════════════════════════════════════════════

    @Test
public void rf044_deveImpedirExecucaoSemEstrategiaDefinida() {

    CalculadoraSeguroContexto contexto =
            new CalculadoraSeguroContexto();

    try {

        contexto.executarCalculo(
                1000.0,
                1,
                30
        );

        fail("Era esperada uma IllegalStateException.");

    } catch (IllegalStateException e) {

        assertEquals(
                "Nenhuma estratégia de cálculo foi definida.",
                e.getMessage()
        );
    }
}

// =====================================================
// RF045 — CENÁRIO DE EXCEÇÃO
// idade inválida deve ser rejeitada
// =====================================================

@Test
public void rf045_deveRejeitarIdadeNegativa() {

    CalculadoraSeguroContexto contexto =
            new CalculadoraSeguroContexto();

    contexto.setEstrategia(
            new EstrategiaCondutorJovem()
    );

    try {

        contexto.executarCalculo(
                1000.0,
                1,
                -5
        );

        fail("Era esperada uma IllegalArgumentException.");

    } catch (IllegalArgumentException e) {

        assertNotNull(e);
    }
}
 // RF038 — CENÁRIO VÁLIDO
    // Executar cálculo básico de risco
    // =====================================================
    @Test
    public void testRF038_ExecutarCalculoBasicoDeRisco() {
        CalculadoraSeguroContexto contexto = new CalculadoraSeguroContexto();
        double valorBaseVeiculo = 1000.0;
        int quantidadeVeiculos = 1;
        int idadeCondutorRegular = 35; // Cliente regular fora da faixa de risco jovem

        // Utiliza a interface/estratégia base como stub para o cálculo padrão linear
        contexto.setEstrategia(new CalculoSeguroStrategy() {
            @Override
            public double calcular(double valorBase, int qtd, int idade) {
                return valorBase * qtd; // Simulação da equação linear padrão
            }
        });

        double resultadoObtido = contexto.executarCalculo(valorBaseVeiculo, quantidadeVeiculos, idadeCondutorRegular);
        double resultadoEsperado = 1000.0; // Valor de tabela normal sem acréscimos

        assertEquals(resultadoEsperado, resultadoObtido, 0.001);
    }

    // =====================================================
    // RF039 — CENÁRIO VÁLIDO
    // Executar cálculo premium de risco
    // =====================================================
    @Test
    public void testRF039_ExecutarCalculoPremiumDeRisco() {
        CalculadoraSeguroContexto contexto = new CalculadoraSeguroContexto();
        double valorBaseVeiculo = 2000.0;
        int quantidadeVeiculos = 1;
        int idadeCondutorPremium = 50;

        // Injeta uma simulação (stub) da estratégia Premium com margens reduzidas de fidelidade
        contexto.setEstrategia(new CalculoSeguroStrategy() {
            @Override
            public double calcular(double valorBase, int qtd, int idade) {
                return (valorBase * qtd) * 0.90; // Aplica 10% de desconto de fidelidade premium
            }
        });

        double resultadoObtido = contexto.executarCalculo(valorBaseVeiculo, quantidadeVeiculos, idadeCondutorPremium);
        double resultadoEsperado = 1800.0; // 2000.0 com 10% de desconto premium

        assertEquals(resultadoEsperado, resultadoObtido, 0.001);
    }
}
