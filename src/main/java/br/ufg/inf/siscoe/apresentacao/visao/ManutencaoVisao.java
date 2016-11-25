package br.ufg.inf.siscoe.apresentacao.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import br.ufg.inf.siscoe.excecao.SistemaException;
import br.ufg.inf.siscoe.integracao.entidade.Entidade;

public abstract class ManutencaoVisao<E extends Entidade> implements Serializable {
    private static final long serialVersionUID = -4770636767742987507L;
    private E entidade;
    private Collection<E> lista;

    /**
     * Construtor.
     */
    public ManutencaoVisao() {
    }

    /**
     * <p>
     * M�todo respons�vel por retornar o valor do atributo entidade.
     * <p>
     *
     * @return <code>E</code>
     *
     */
    public E getEntidade() {
        if (this.entidade == null) {
            Class<E> tipo = null;
            try {
                tipo = this.getTipoDaEntidade();
                this.entidade = tipo.newInstance();
            } catch (final IllegalAccessException e) {
                throw new SistemaException("Problema acessando tipo da classe " + this + ".", e);
            } catch (final InstantiationException e) {
                throw new SistemaException("Problema instanciando tipo " + tipo + ".", e);
            }
        }
        return this.entidade;
    }

    /**
     * Retorna o tipo gen�rico do ManutencaoVisao.
     *
     * @return Class<>
     *
     */
    @SuppressWarnings("unchecked")
    private Class<E> getTipoDaEntidade() {
        return (Class<E>) this.getEntidade().getClass();
    }

    /**
     * Get/Set.
     *
     * @param entidade
     *            atribui um valor ao atributo entidade
     */
    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    /**
     * Get/Set.
     *
     * @return O valor do atributo lista
     */
    public Collection<E> getLista() {
        if (this.lista == null) {
            this.lista = new ArrayList<E>();
        }
        return this.lista;
    }

    /**
     * Get/Set.
     *
     * @param lista
     *            atribui um valor ao atributo lista
     */
    public void setLista(Collection<E> lista) {
        this.lista = lista;
    }
}
