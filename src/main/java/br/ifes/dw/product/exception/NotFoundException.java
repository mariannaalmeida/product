package br.ifes.dw.product.exception;

/**
 * Exceção lançada quando um recurso não é encontrado.
 */
public class NotFoundException extends Exception {

    /**
     * Construtor padrão.
     */
    public NotFoundException() {
        super("Recurso não encontrado.");
    }

    /**
     * Construtor com mensagem personalizada.
     *
     * @param mensagem Mensagem personalizada para a exceção.
     */
    public NotFoundException(String mensagem) {
        super(mensagem);
    }
}
