package br.ufg.inf.siscoe.integracao.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.siscoe.comum.to.MensagemTO;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;

public abstract class Entidade implements Serializable {

    private transient List<MensagemTO> mensagens;

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -6900727406762813460L;

    public abstract Serializable getIdentificador();

    public abstract String getChavePrimaria();

    /**
     *
     * Método responsável por verificar se entidades sao iguais pelo id.
     *
     * @param entidade
     *            valor a ser atribuido
     * @return boolean
     * @author Bruno Martins de Carvalho
     */
    public final boolean equalsPorId(final Entidade entidade) {
        if (UtilObjeto.isReferencia(entidade)
                && (UtilObjeto.isReferencia(entidade.getIdentificador()) && UtilObjeto.isReferencia(this.getIdentificador()))) {
            return entidade.getIdentificador().equals(this.getIdentificador());
        }
        return false;
    }

    @Override
    public boolean equals(final Object arg0) {
        return this.equalsPorId((Entidade) arg0);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getIdentificador() == null) ? 0 : this.getIdentificador().hashCode());
        return result;
    }

    /**
     * <p>
     * M�todo respons�vel por obter lista de mensagens.
     * </p>
     *
     * @return mensagens
     */
    public List<MensagemTO> getMensagens() {
        if (this.mensagens == null) {
            this.mensagens = new ArrayList<MensagemTO>();
        }
        return this.mensagens;
    }

    /**
     * <p>
     * Atribui uma lista de MensagemTO ao atributo mensagens.
     * </p>
     *
     * @param mensagens
     *            valor a ser atribuido
     */
    public void setMensagens(final ArrayList<MensagemTO> mensagens) {
        this.mensagens = mensagens;
    }

    /**
     * <p>
     * Verfica se existe mensagens.
     * </p>
     *
     * @return boolean
     */
    public boolean hasMensagens() {
        return !this.getMensagens().isEmpty();
    }

    /**
     * <p>
     * Limpa lista de mensagens.
     * </p>
     *
     *
     */
    public void limparMensagens() {
        this.getMensagens().clear();
    }

    /**
     * Adiciona uma {@link MensagemTO} a lista de mensagens.
     *
     * @param chaveMensagem
     *            valor a ser atribuido
     */
    public void adicionarMensagem(final String chaveMensagem) {
        this.getMensagens().add(new MensagemTO(chaveMensagem));
    }

    /**
     * Adiciona uma {@link MensagemTO} a lista de mensagens.
     *
     * @param chaveMensagem
     *            valor a ser atribuido
     * @param argumentos
     *            valor a ser atribuido
     */
    public void adicionarMensagem(final String chaveMensagem, final String... argumentos) {
        this.getMensagens().add(new MensagemTO(chaveMensagem, argumentos));
    }

}
