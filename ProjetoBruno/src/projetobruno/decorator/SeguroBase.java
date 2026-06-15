package projetobruno.decorator;

/**
 * Implementação do seguro básico.
 *
 * RF034 - Seguro sem opcionais.
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public class SeguroBase implements Seguro {

    private static final double PRECO_BASE = 500.00;

    @Override
    public double getPreco() {
        return PRECO_BASE;
    }

    @Override
    public String getDescricao() {
        return "Seguro Básico";
    }
}