package projetobruno.decorator;

/**
 * Interface base do padrão Decorator.
 * Representa qualquer tipo de seguro.
 *
 * @author Miguel Signorini
 * @version 1.0
 */
public interface Seguro {

    /**
     * Retorna o preço total do seguro.
     *
     * @return valor do seguro
     */
    double getPreco();

    /**
     * Retorna a descrição do seguro.
     *
     * @return descrição das coberturas
     */
    String getDescricao();
}