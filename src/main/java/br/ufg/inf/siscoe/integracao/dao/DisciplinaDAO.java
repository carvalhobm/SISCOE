package br.ufg.inf.siscoe.integracao.dao;

import java.util.Collection;

import br.ufg.inf.siscoe.integracao.entidade.Disciplina;

/**
 * <p>
 * DisciplinaDAO.
 * </p>
 * <p>
 * Descrição: Interface de integração do bean {@link Disciplina}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface DisciplinaDAO extends DAO<Disciplina> {

    /**
     *
     * Método responsável por listar Disciplinas de acordo com o filtro
     * informado.
     *
     * @param filtro
     *            valor a ser atribuido
     * @return Collection
     * @author Bruno Martins de Carvalho
     */
    Collection<Disciplina> listarbyFiltro(Disciplina filtro);

}
