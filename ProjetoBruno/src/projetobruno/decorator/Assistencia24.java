package projetobruno.decorator;

/**
 * Decorador que adiciona Assistência 24h.
 *
 * RF035 - Adição de cobertura opcional.
 * RF036 - Impede duplicidade da cobertura.
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public class Assistencia24 extends SeguroDecorator {

    private static final double VALOR = 80.00;
    private static final String TAG = "Assistência 24h";

    public Assistencia24(Seguro seguro) {
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