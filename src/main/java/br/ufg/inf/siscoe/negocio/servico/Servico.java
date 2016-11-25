package br.ufg.inf.siscoe.negocio.servico;

import java.io.Serializable;
import java.util.Collection;

import br.ufg.inf.siscoe.integracao.dao.DAO;
import br.ufg.inf.siscoe.integracao.entidade.Entidade;

public interface Servico<E extends Entidade, D extends DAO<E>> extends Serializable {

    /**
     * Insere em banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a persistir
     * @return a chave da mensagem de sucesso para a opera��o
     */
    String inserir(E entidade);

    /**
     * Insere em banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a alterar
     * @return a chave da mensagem de sucesso para a opera��o
     */
    String alterar(E entidade);

    /**
     * Insere ou altera em banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a inserir ou alterar
     * @return a chave da mensagem de sucesso para a opera��o
     */
    String salvar(E entidade);

    /**
     * Exclui de banco de dados inst�ncia de entidade.
     *
     * @param entidade
     *            a entidade a inserir ou alterar
     * @return a chave da mensagem de sucesso para a opera��o
     */
    String remover(E entidade);

    /**
     * Exclui em banco de dados as inst�ncias da entidade.
     *
     * @param entidades
     *            a entidades a excluir
     * @return a chave da mensagem de sucesso para a opera��o
     */
    String removerTodos(Collection<E> entidades);

    /**
     * Exclui em banco de dados entidades que t�m os IDS passados como
     * par�metro.
     *
     * @param ids
     *            ids de entidades a remover
     * @return a chave da mensagem de sucesso para a opera��o
     */
    String removerTodosPorId(Collection<Serializable> ids);

    /**
     * Consulta todas as entidades vindas do banco de dados.
     *
     * @return a cole��o de entidades encontradas
     */
    Collection<E> listar();

    /**
     * Consulta entidade pelo seu identificador.
     *
     * @param id
     *            o identificador
     * @return a entidade encontrada pelo ID
     */
    E obter(Serializable id);

    /**
     * Consulta entidades pelos seus identificadores.
     *
     * @param ids
     *            os identificadores
     * @return a cole��o de entidades
     */
    Collection<E> obter(Collection<Serializable> ids);

    void flushEClear();
}
