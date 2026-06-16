package projetobruno.decorator;

/**
 * Decorador abstrato para adicionar coberturas
 * dinamicamente ao seguro.
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public abstract class SeguroDecorator implements Seguro {

    protected Seguro seguro;

    /**
     * Construtor do decorador.
     *
     * @param seguro seguro a ser decorado
     */
    public SeguroDecorator(Seguro seguro) {
        this.seguro = seguro;
    }

    @Override
    public double getPreco() {
        return seguro.getPreco();
    }

    @Override
    public String getDescricao() {
        return seguro.getDescricao();
    }
}