package br.ufg.inf.siscoe.integracao.dao;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;

import br.ufg.inf.siscoe.integracao.entidade.Entidade;

public interface DAO<E extends Entidade> {

    /**
     * <p>
     * M�todo respons�vel por obter uma entidade utilizando sua chave primaria.
     * </p>
     *
     * @param chavePrimaria
     *            valor a ser atribuido
     * @return <code>E</code>
     */
    E obter(Serializable chavePrimaria);

    /**
     * <p>
     * M�todo Respons�vel por obter entidades utilizando os ids passados via
     * par�metro.
     * </p>
     *
     * @param listaCP
     *            valor a ser atribuido
     * @return <code>Collection<></code>
     */
    Collection<E> obter(Collection<Serializable> listaCP);

    /**
     * <p>
     * M�todo Respons�vel por realizar a inclus�o de uma entidade.
     * </p>
     *
     * @param entidade
     *            valor a ser atribuido
     * @return <code>Serializable</code>
     */
    Serializable inserir(E entidade);

    /**
     * <p>
     * M�todo respons�vel por alterar uma entidade de acordo com os estados da
     * entidade passada por par�metro.
     * </p>
     *
     * @param entidade
     *            valor a ser atribuido
     */
    void alterar(E entidade);

    /**
     * <p>
     * M�todo respons�vel por alterar os dados de uma entidade ou incluir caso
     * essa entidade n�o possua um identificador.
     * </p>
     *
     * @param entidade
     *            valor a ser atribuido
     */
    void salvar(E entidade);

    /**
     * <p>
     * M�todo respons�vel por salvar uma Collection de objetos.
     * <p>
     *
     * @param listaEntidade
     *            valor a ser atribuido
     */
    void salvar(final Collection<E> listaEntidade);

    /**
     * <p>
     * M�todo respons�vel por remover uma entidade.
     * </p>
     *
     * @param entidade
     *            valor a ser atribuido
     */
    void remover(E entidade);

    /**
     * <p>
     * M�todo respons�vel por remover uma entidade utilizando a sua chave
     * prim�ria.
     * </p>
     *
     * @param id
     *            valor a ser atribuido
     */
    void remover(Serializable id);

    /**
     * <p>
     * M�todo respons�vel por remover todos as entidades contidas na cole��o
     * passada por par�metro.
     * </p>
     *
     * @param listaEntidades
     *            valor a ser atribuido
     */
    void remover(Collection<E> listaEntidades);

    /**
     * <p>
     * M�todo respons�vel por remover entidades utilizando os ids passados por
     * par�metro.
     * </p>
     *
     * @param listaIds
     *            valor a ser atribuido
     */
    void removerPorIds(Collection<Serializable> listaIds);

    /**
     * <p>
     * M�todo respons�vel por flush na base de dados.
     * <p>
     *
     */
    void flushNaBaseDados();

    /**
     * M�todo respons�vel por dar flush e clear na transa��o.
     *
     */
    void flushEClear();

    /**
     * <p>
     * M�todo Respons�vel por listar entidades sem utilizar pagina��o por
     * demanda.
     * </p>
     *
     * @return <code>Collection<></code>
     */
    Collection<E> listar();

    /**
     * <p>
     * M�todo Respons�vel por listar entidades utilizando pagina��o por demanda.
     * </p>
     *
     * @param inicioConsulta
     *            valor a ser atribuido
     * @param finalConsulta
     *            valor a ser atribuido
     * @return <code>Collection<></code>
     */
    Collection<E> listar(final int inicioConsulta, final int finalConsulta);

    /**
     * <p>
     * M�todo Respons�vel por listar entidades utilizando pagina��o por demanda.
     * </p>
     *
     * @param criteria
     *            valor a ser atribuido
     * @param inicioConsulta
     *            valor a ser atribuido
     * @param finalConsulta
     *            valor a ser atribuido
     * @return <code>Collection<></code>
     */
    Collection<E> listar(final Criteria criteria, final int inicioConsulta, final int finalConsulta);

}
