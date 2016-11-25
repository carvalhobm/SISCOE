package br.ufg.inf.siscoe.negocio.servico.implementacao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.dao.DAO;
import br.ufg.inf.siscoe.integracao.entidade.Entidade;
import br.ufg.inf.siscoe.negocio.servico.Servico;

public abstract class ServicoAbstratoImpl<E extends Entidade, D extends DAO<E>> implements Servico<E, D> {

    private static final long serialVersionUID = -5919648416323244024L;

    private static final String MENSAGEM_SUCESSO = "Sucesso!";

    private static final String BR = "BR";

    private static final String PT = "pt";

    private String varResourceBundle = "mensagem_pt_BR";

    private ResourceBundle resourceBundle;

    private Locale locale;

    /**
     * Retorna a inst�ncia do DAO que manipula a entidade.
     *
     * @return o DAO que manipula a entidade
     */
    public abstract D getDao();

    /**
     * M�todo respons�vel por.
     *
     *
     *
     * @return <code>ResourceBundle</code>
     */
    public ResourceBundle getMessage() {

        try {

            if (!UtilObjeto.isReferencia(this.locale)) {

                this.locale = new Locale(PT, BR);
            }

            if (!UtilObjeto.isReferencia(this.resourceBundle)) {

                this.resourceBundle = ResourceBundle.getBundle(this.varResourceBundle, this.locale);
            }

        } catch (final Exception e) {

            this.resourceBundle = null;
        }

        return this.resourceBundle;
    }

    /**
     * Insere em banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a persistir
     * @return a chave da mensagem de sucesso da opera��o
     *
     */
    @Override
    public String inserir(E entidade) {
        this.getDao().inserir(entidade);
        return ServicoAbstratoImpl.MENSAGEM_SUCESSO;
    }

    /**
     * Insere em banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a alterar
     * @return a chave da mensagem de sucesso da opera��o
     *
     */
    @Override
    public String alterar(E entidade) {
        this.getDao().alterar(entidade);
        return ServicoAbstratoImpl.MENSAGEM_SUCESSO;
    }

    /**
     * Insere ou altera em banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a inserir ou alterar
     * @return a chave da mensagem de sucesso da opera��o
     *
     */
    @Override
    public String salvar(E entidade) {
        this.getDao().salvar(entidade);
        return ServicoAbstratoImpl.MENSAGEM_SUCESSO;
    }

    /**
     * Exclui do banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a inserir ou alterar
     * @return a chave da mensagem de sucesso da opera��o
     *
     */
    @Override
    public String remover(E entidade) {
        this.getDao().remover(entidade);
        return ServicoAbstratoImpl.MENSAGEM_SUCESSO;
    }

    /**
     * Exclui em banco de dados as inst�ncias da entidade.
     *
     * @param entidades
     *            a entidades a inserir ou alterar
     * @return a chave da mensagem de sucesso da opera��o
     *
     */
    @Override
    public String removerTodos(Collection<E> entidades) {
        this.getDao().remover(entidades);
        return ServicoAbstratoImpl.MENSAGEM_SUCESSO;
    }

    /**
     * Exclui em banco de dados entidades que t�m os IDS passados como
     * par�metro.
     *
     * @param ids
     *            ids de entidades a remover
     * @return a chave da mensagem de sucesso para a opera��o
     *
     */
    @Override
    public String removerTodosPorId(Collection<Serializable> ids) {
        this.getDao().removerPorIds(ids);
        return ServicoAbstratoImpl.MENSAGEM_SUCESSO;
    }

    /**
     * Consulta todas as entidades vindas do banco de dados.
     *
     * @return a cole��o de entidades encontradas
     *
     */
    @Override
    public Collection<E> listar() {
        return this.getDao().listar();
    }

    /**
     * Consulta entidade pelo seu identificador.
     *
     * @return a entidade encontrada pelo ID
     *
     */
    @Override
    public E obter(Serializable id) {
        return this.getDao().obter(id);
    }

    /**
     * Consulta entidades pelos seus identificadores.
     *
     * @return as entidades encontradas pelos IDs
     *
     */
    @Override
    public Collection<E> obter(Collection<Serializable> ids) {
        return this.getDao().obter(ids);
    }

    /**
     * Recupera o valor do atributo varResourceBundle.
     *
     * @return O valor do atributo varResourceBundle.
     */
    public String getVarResourceBundle() {
        return this.varResourceBundle;
    }

    /**
     * Define o valor do atributo varResourceBundle.
     *
     * @param varResourceBundle
     *            valor a ser atribuido
     */
    public void setVarResourceBundle(String varResourceBundle) {
        this.varResourceBundle = varResourceBundle;
    }

    @Override
    public void flushEClear() {
        this.getDao().flushEClear();
    }
}
