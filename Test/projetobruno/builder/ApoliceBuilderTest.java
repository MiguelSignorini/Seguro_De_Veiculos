package projetobruno.builder;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários do padrão Builder — {@link Apolice}.
 *
 * <p>Cobre RF031 (cenário válido) e RF032 (cenário alternativo).</p>
 *
 * @author Ruan Alves 
 * @version 1.0
 */
public class ApoliceBuilderTest {

    // ════════════════════════════════════════════════════════════
    //  RF031 — CENÁRIO VÁLIDO
    //  Criar apólice completa com TODAS as assistências
    // ════════════════════════════════════════════════════════════

    /**
     * RF031 — Builder deve criar apólice com todos os campos
     * preenchidos e todas as assistências ativas.
     */
    @Test
    public void rf031_deveCriarApoliceCompletaComTodasAssistencias() {

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
     * RF032 — Builder deve criar apólice apenas com cobertura básica,
     * sem nenhum serviço opcional, e todos os booleans devem ser false.
     */
    @Test
    public void rf032_deveCriarApoliceBasicaSemNenhumaAssistencia() {

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
}