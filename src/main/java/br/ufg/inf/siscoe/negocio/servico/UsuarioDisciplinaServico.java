package br.ufg.inf.siscoe.negocio.servico;

import br.ufg.inf.siscoe.integracao.dao.UsuarioDisciplinaDAO;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;

/**
 * <p>
 * UsuarioDisciplinaServico.
 * </p>
 * <p>
 * Descrição: Interface de servico para entidade UsuarioDisciplina
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface UsuarioDisciplinaServico extends Servico<UsuarioDisciplina, UsuarioDisciplinaDAO> {

    /**
     *
     * Método responsável por registrar falta ao aluno.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void registrarFaltaUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina);

    /**
     *
     * Método responsável por salvar as notas do usuario.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void salvarNotas(UsuarioDisciplina usuarioDisciplina);

}
