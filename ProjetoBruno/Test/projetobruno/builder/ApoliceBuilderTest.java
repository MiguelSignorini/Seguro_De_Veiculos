package projetobruno.builder;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários do padrão Builder — {@link Apolice}.
 *
 * <p>Cobre RF006 - Geração de Apólices.</p>
 *
 * @author Ruan Alves
 * @version 1.0
 */
public class ApoliceBuilderTest {

    // ════════════════════════════════════════════════════════════
    // RF006 — CENÁRIO VÁLIDO
    // Gerar apólice completa com todas as assistências
    // ════════════════════════════════════════════════════════════

    /**
     * RF006 — Deve gerar apólice completa.
     */
    @Test
    public void rf06_deveCriarApoliceCompletaComTodasAssistencias() {

        // Arrange
        Apolice apolice = new Apolice.ApoliceBuilder()
                .nomeCliente("João da Silva")
                .cpf("123.456.789-09")
                .placa("ABC-1234")
                .dataVigencia("2099-12-31")
                .assistencia24h(true)
                .carroReserva(true)
                .coberturaVidros(true)
                .build();

        // Assert
        assertNotNull("Apólice não deveria ser nula", apolice);
        assertEquals("João da Silva", apolice.getNomeCliente());
        assertEquals("123.456.789-09", apolice.getCpf());
        assertEquals("ABC-1234",       apolice.getPlaca());
        assertEquals("2099-12-31",     apolice.getDataVigencia());
        assertTrue("Assistência 24h deveria estar ativa",    apolice.isAssistencia24h());
        assertTrue("Carro reserva deveria estar ativo",      apolice.isCarroReserva());
        assertTrue("Cobertura de vidros deveria estar ativa",apolice.isCoberturaVidros());
    }

    // ════════════════════════════════════════════════════════════
    //  RF032 — CENÁRIO ALTERNATIVO
    //  Criar apólice enxuta SEM nenhuma assistência
    // ════════════════════════════════════════════════════════════

    /**
     *  — Builder deve criar apólice apenas com cobertura básica,
     * sem nenhum serviço opcional, e todos os booleans devem ser false.
     */
    @Test
    public void rf06_deveCriarApoliceBasicaSemNenhumaAssistencia() {

        // Arrange — opcionais NÃO são chamados
        Apolice apolice = new Apolice.ApoliceBuilder()
                .nomeCliente("Maria Oliveira")
                .cpf("987.654.321-00")
                .placa("XYZ-9876")
                .dataVigencia("2099-06-01")
                .build();

        // Assert — objeto criado com sucesso
        assertNotNull("Apólice básica não deveria ser nula", apolice);
        assertEquals("Maria Oliveira", apolice.getNomeCliente());
        assertEquals("XYZ-9876",       apolice.getPlaca());

        // Assert — nenhuma assistência contratada
        assertFalse("Assistência 24h deveria estar inativa",    apolice.isAssistencia24h());
        assertFalse("Carro reserva deveria estar inativo",      apolice.isCarroReserva());
        assertFalse("Cobertura de vidros deveria estar inativa",apolice.isCoberturaVidros());
    }
    // ════════════════════════════════════════════════════════════
    // RF006 — CENÁRIO DE EXCEÇÃO
    // Dados inválidos não devem gerar apólice
    // ════════════════════════════════════════════════════════════

    /**
     * RF006 — Deve lançar exceção para CPF inválido.
     */
    @Test(expected = IllegalArgumentException.class)
    public void rf06_deveLancarExcecaoComCpfInvalido() {
        new Apolice.ApoliceBuilder()
                .nomeCliente("Teste")
                .cpf("123ABC456")
                .placa("ABC-1234")
                .dataVigencia("2099-12-31")
                .build();
        }
}
