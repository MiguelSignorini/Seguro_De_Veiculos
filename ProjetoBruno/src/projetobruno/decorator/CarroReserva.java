package projetobruno.decorator;

/**
 * Decorador que adiciona Carro Reserva.
 *
 * RF035 - Adição de cobertura opcional.
 * RF036 - Impede duplicidade da cobertura.
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public class CarroReserva extends SeguroDecorator {

    private static final double VALOR = 120.00;
    private static final String TAG = "Carro Reserva";

    public CarroReserva(Seguro seguro) {
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