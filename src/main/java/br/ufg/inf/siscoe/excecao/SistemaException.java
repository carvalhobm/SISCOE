package br.ufg.inf.siscoe.excecao;

/**
 * <p>
 * SistemaException.
 * </p>
 * <p>
 * Descrição: Exceção de sistema.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class SistemaException extends RuntimeException {

    private static final long serialVersionUID = 1466143062284777365L;

    /**
     * Cria o objeto.
     */
    public SistemaException() {
        // Construtor.
    }

    /**
     * Cria o objeto e atribui a mensagem da exce��o.
     *
     * @param mensagem
     *            Mensagem da exce��o
     */
    public SistemaException(String mensagem) {
        super(mensagem);
    }

    /**
     * Cria o objeto e atribui a mensagem e a causa da exce��o.
     *
     * @param mensagem
     *            Mensagem da exce��o
     * @param causa
     *            Causa da exce��o
     */
    public SistemaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    /**
     * Cria o objeto e atribui a causa da exce��o.
     *
     * @param causa
     *            Causa da exce��o
     */
    public SistemaException(Throwable causa) {
        super(causa);
    }
}
