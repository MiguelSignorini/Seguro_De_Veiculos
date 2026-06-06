package seguro.de.veiculos;

import java.util.Collections;
import java.util.List;

public class ApoliceInvalidaException extends Exception {

    private final List<String> erros;

    public ApoliceInvalidaException(String mensagem, List<String> erros) {
        super(mensagem);
        this.erros = Collections.unmodifiableList(erros);
    }

    public List<String> getErros() {
        return erros;
    }
}