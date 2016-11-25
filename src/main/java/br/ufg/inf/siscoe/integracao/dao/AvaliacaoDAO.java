package br.ufg.inf.siscoe.integracao.dao;

import java.util.Collection;

import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;

/**
 * <p>
 * AvaliacaoDAO.
 * </p>
 * <p>
 * Descrição: Interface de integração do bean {@link Avaliacao}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface AvaliacaoDAO extends DAO<Avaliacao> {

    /**
     *
     * Método responsável por remover a lista de avaliação.
     *
     * @param entidades
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    String removerTodos(Collection<Avaliacao> entidades);

}
