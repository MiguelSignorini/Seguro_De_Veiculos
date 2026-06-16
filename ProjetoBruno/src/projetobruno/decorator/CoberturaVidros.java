package projetobruno.decorator;

/**
 * Decorador que adiciona Cobertura de Vidros.
 *
 * RF011 - Adição de cobertura opcional.
 * RF011 - Impede duplicidade da cobertura.
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public class CoberturaVidros extends SeguroDecorator {

    private static final double VALOR = 60.00;
    private static final String TAG = "Cobertura de Vidros";

    public CoberturaVidros(Seguro seguro) {
        super(seguro);

        if (seguro.getDescricao().contains(TAG)) {
            throw new IllegalStateException(
                "Conflito: '" + TAG + "' já adicionado."
            );
        }
    }

    @Override
    public double getPreco() {
        return super.getPreco() + VALOR;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + " + TAG;
    }
}