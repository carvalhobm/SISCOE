package br.ufg.inf.siscoe.integracao.dao;

import java.util.Collection;

import br.ufg.inf.siscoe.integracao.entidade.AvaliacaoUsuario;

/**
 * <p>
 * AvaliacaoUsuarioDAO.
 * </p>
 * <p>
 * Descrição: Interface de integração do bean {@link AvaliacaoUsuario}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface AvaliacaoUsuarioDAO extends DAO<AvaliacaoUsuario> {

    /**
     *
     * Método responsável por remover todos.
     *
     * @param entidades
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    String removerTodos(Collection<AvaliacaoUsuario> entidades);

}
