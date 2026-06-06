import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import seguro.de.veiculos.Apolice;
import seguro.de.veiculos.ApoliceInvalidaException;

public class RF033 {

    @Test(expected = ApoliceInvalidaException.class)
    public void testVigenciaRetroativaLancaExcecao() throws ApoliceInvalidaException {
        System.out.println("TESTE 1: Vigência retroativa deve lançar exceção...");
        new Apolice.Builder()
                .cpfSegurado("123.456.789-09")
                .nomeSegurado("Maria Souza")
                .vigenciaInicio(LocalDate.of(2020, 1, 1))
                .vigenciaFim(LocalDate.of(2021, 1, 1))
                .valorCobertura(50000.00)
                .build();
    }

    @Test(expected = ApoliceInvalidaException.class)
    public void testCpfCorrompidoLancaExcecao() throws ApoliceInvalidaException {
        System.out.println("TESTE 2: CPF corrompido deve lançar exceção...");
        new Apolice.Builder()
                .cpfSegurado("9X2.A56.7B9-0Z")
                .nomeSegurado("João Pereira")
                .vigenciaInicio(LocalDate.now().plusDays(1))
                .vigenciaFim(LocalDate.now().plusYears(1))
                .valorCobertura(100000.00)
                .build();
    }

    @Test
    public void testExcecaoContemErros() {
        System.out.println("TESTE 3: Exceção deve conter lista de erros...");
        try {
            new Apolice.Builder()
                    .cpfSegurado("INVALIDO")
                    .nomeSegurado("Ana Lima")
                    .vigenciaInicio(LocalDate.now().plusDays(1))
                    .vigenciaFim(LocalDate.now().plusYears(1))
                    .valorCobertura(75000.00)
                    .build();
            fail("Deveria ter lancado ApoliceInvalidaException");
        } catch (ApoliceInvalidaException e) {
            System.out.println("  Erros encontrados: " + e.getErros());
            assertFalse(e.getErros().isEmpty());
        }
    }

    @Test
    public void testDadosValidosCriaApolice() throws ApoliceInvalidaException {
        System.out.println("TESTE 4: Dados válidos devem criar apólice com sucesso...");
        Apolice apolice = new Apolice.Builder()
                .cpfSegurado("987.654.321-00")
                .nomeSegurado("Carlos Melo")
                .vigenciaInicio(LocalDate.now().plusDays(5))
                .vigenciaFim(LocalDate.now().plusYears(1))
                .valorCobertura(75000.00)
                .build();
        assertNotNull(apolice);
        System.out.println("  Apólice criada: " + apolice.getNomeSegurado() + " - CPF: " + apolice.getCpfSegurado());
    }
}