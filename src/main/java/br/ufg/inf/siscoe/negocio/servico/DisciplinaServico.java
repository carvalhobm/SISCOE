package br.ufg.inf.siscoe.negocio.servico;

import java.util.Collection;

import br.ufg.inf.siscoe.integracao.dao.DisciplinaDAO;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;

/**
 * <p>
 * DisciplinaServico.
 * </p>
 * <p>
 * Descrição: Interface de serviço para a entidade {@link Disciplina}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface DisciplinaServico extends Servico<Disciplina, DisciplinaDAO> {

    /**
     *
     * Método responsável por listar os Disciplinas utilizando filtros.
     *
     * @param filtro
     *            valor a ser atribuido
     * @return Collection<>
     * @author Bruno Martins de Carvalho
     */
    Collection<Disciplina> listarByFiltro(Disciplina filtro);

    /**
     *
     * Método responsável por calcular o resultado da formula de media final da
     * disciplina.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @return Double
     * @author Bruno Martins de Carvalho
     */
    Double calcularFormula(Disciplina disciplina);

    /**
     *
     * Método responsável por simular o resultado da formula de media final da
     * disciplina.
     *
     * @param listaAvaliacao
     *            valor a ser atribuido
     * @param formula
     *            valor a ser atribuido
     * @return Double
     * @author Bruno Martins de Carvalho
     */
    Double calcularFormula(Collection<Avaliacao> listaAvaliacao, String formula);

    /**
     *
     * Método responsável por salvar um usuarioDisciplina.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void salvarUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina);

    /**
     *
     * Método responsável por salvar as notas do usuario.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void salvarNotas(UsuarioDisciplina usuarioDisciplina);

    /**
     *
     * Método responsável por validar se os campos necessários da disciplina
     * foram preenchidos.
     *
     * @param entidade
     *            valor a ser atribuido
     * @return boolean
     * @author Bruno Martins de Carvalho
     */
    boolean validarDisciplina(Disciplina entidade);

    /**
     *
     * Método responsável por realizar a matricula do usuario na disciplina.
     *
     * @param usuario
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void realizarMatricula(Usuario usuario, Disciplina disciplina);

    /**
     *
     * Método responsável por salvar uma disciplina.
     *
     * @param entidade
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     * @return Disciplina
     */
    Disciplina salvarDisciplina(Disciplina entidade);

    /**
     *
     * Método responsável por remover as avalições removidas pelo usuario.
     *
     * @param listaAvaliacaoRemover
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void removerAvaliacao(Collection<Avaliacao> listaAvaliacaoRemover);

}
