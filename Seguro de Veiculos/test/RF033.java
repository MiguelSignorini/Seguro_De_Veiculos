import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 *
 * @author MiguelSignorini
 */

public class RF033 {
    
    @Test
    public void RF033() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Apolice()
                .cpf("123ABC456")
                .dataInicioVigencia(LocalDate.now().minusDays(5)) // data retroativa
                .build();

        });   
    }
}

