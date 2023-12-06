package br.ifes.dw.product.exception;

/**
 * Exceção lançada quando um ID inválido é detectado.
 */
public class IdInvalidoException extends Exception {

    /**
     * Construtor padrão.
     */
    public IdInvalidoException() {
        super("O ID fornecido é inválido.");
    }

    /**
     * Construtor com mensagem personalizada.
     *
     * @param mensagem Mensagem personalizada para a exceção.
     */
    public IdInvalidoException(String mensagem) {
        super(mensagem);
    }
}
