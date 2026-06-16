package projetobruno.decorator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários do padrão Decorator — Seguro Veicular.
 *
 * RF034 (cenário válido)
 * RF035 (cenário alternativo)
 * RF036 (cenário de exceção)
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public class SeguroTest {

    /**
     * RF034 — Seguro base deve retornar o valor padrão
     * sem nenhuma cobertura adicional.
     */
    @Test
    public void rf034_seguroBase() {

        Seguro seguro = new SeguroBase();

        assertEquals(
                "Preço base deveria ser 500.00",
                500.00,
                seguro.getPreco(),
                0.001
        );

        assertEquals(
                "Seguro Básico",
                seguro.getDescricao()
        );

        assertFalse(
                "Descrição não deveria conter opcionais",
                seguro.getDescricao().contains("+")
        );
    }

    /**
     * RF035 — Sistema deve aceitar empilhamento
     * de coberturas opcionais.
     */
    @Test
    public void rf035_coberturaEmpilhada() {

        Seguro seguro = new SeguroBase();

        seguro = new Assistencia24(seguro);
        seguro = new CarroReserva(seguro);
        seguro = new CoberturaVidros(seguro);

        assertEquals(
                "Preço total deveria ser 760.00",
                760.00,
                seguro.getPreco(),
                0.001
        );

        assertTrue(
                "Descrição deveria conter Assistência 24h",
                seguro.getDescricao().contains("Assistência 24h")
        );

        assertTrue(
                "Descrição deveria conter Carro Reserva",
                seguro.getDescricao().contains("Carro Reserva")
        );

        assertTrue(
                "Descrição deveria conter Cobertura de Vidros",
                seguro.getDescricao().contains("Cobertura de Vidros")
        );
    }

    /**
     * RF036 — Sistema deve impedir a adição
     * duplicada da mesma cobertura.
     */
    @Test
    public void rf036_coberturaDuplicada() {

        Seguro seguro = new SeguroBase();

        seguro = new Assistencia24(seguro);

        double precoAntes = seguro.getPreco();
        String descricaoAntes = seguro.getDescricao();

        try {

            seguro = new Assistencia24(seguro);

            fail(
                "Deveria ter lançado IllegalStateException por cobertura duplicada."
            );

        } catch (IllegalStateException e) {

            assertTrue(
                    "Mensagem deveria indicar conflito",
                    e.getMessage().contains("Conflito")
            );
        }

        assertEquals(
                precoAntes,
                seguro.getPreco(),
                0.001
        );

        assertEquals(
                descricaoAntes,
                seguro.getDescricao()
        );
    }
     @Test
    public void testRF037_VerificarSomaCorretaMultiplasCoberturas() {
        // Cenário Válido usando as classes exatas do grupo:
        Seguro seguroBase = new SeguroBase(); 
        
        // Empilhando as coberturas exatamente com os nomes criados pelo grupo
        Seguro seguroComAssistencia = new Assistencia24(seguroBase); 
        Seguro seguroComCarroReserva = new CarroReserva(seguroComAssistencia); 
        Seguro seguroCompleto = new CoberturaVidros(seguroComCarroReserva); 
        
        // Dispara a precificação usando o método do padrão Decorator
        double valorTotalObtido = seguroCompleto.calcularPreco();
        double valorEsperado = 1400.00; // Ajuste para o valor que a soma deles deve dar
        
        // Valida se a soma bate centavo por centavo
        assertEquals(valorEsperado, valorTotalObtido, 0.001);
    }

}
