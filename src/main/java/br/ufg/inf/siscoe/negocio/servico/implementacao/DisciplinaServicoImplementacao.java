package br.ufg.inf.siscoe.negocio.servico.implementacao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufg.inf.siscoe.comum.calculo.AvaliadorExpressao;
import br.ufg.inf.siscoe.comum.util.UsuarioUtil;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.dao.DisciplinaDAO;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;
import br.ufg.inf.siscoe.integracao.entidade.AvaliacaoUsuario;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;
import br.ufg.inf.siscoe.negocio.servico.AvaliacaoServico;
import br.ufg.inf.siscoe.negocio.servico.AvaliacaoUsuarioServico;
import br.ufg.inf.siscoe.negocio.servico.DisciplinaServico;
import br.ufg.inf.siscoe.negocio.servico.UsuarioDisciplinaServico;
import br.ufg.inf.siscoe.negocio.servico.UsuarioServico;

/**
 * <p>
 * DisciplinaServicoImplementacao.
 * </p>
 * <p>
 * Descrição: Implementação da entidade {@link DisciplinaServico}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class DisciplinaServicoImplementacao extends ServicoAbstratoImpl<Disciplina, DisciplinaDAO> implements DisciplinaServico {

    private static final long serialVersionUID = -8859117560887268394L;

    private static final String NENHUMA_AVALIACAO = "MA007";

    private static final String CAMPO_OBRIGATORIO = "MA006";

    @Inject
    private DisciplinaDAO dao;

    @Inject
    private UsuarioDisciplinaServico usuarioDisciplinaServico;

    @Inject
    private UsuarioServico usuarioServico;

    @Inject
    private AvaliacaoUsuarioServico avaliacaoUsuarioServico;

    @Inject
    private AvaliacaoServico avaliacaoServico;

    @Override
    public DisciplinaDAO getDao() {
        return this.dao;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#listarByFiltro(br.ufg.inf.siscoe.integracao.entidade.Disciplina)
     */
    @Override
    public Collection<Disciplina> listarByFiltro(final Disciplina filtro) {
        final Collection<Disciplina> listaDisciplina = this.getDao().listarbyFiltro(filtro);

        final Usuario usuario = this.usuarioServico.obterUsuarioByUsername(UsuarioUtil.getUserLogado().getUsername());

        for (final Disciplina disciplina : listaDisciplina) {
            for (final UsuarioDisciplina usuarioDisciplina : usuario.getListaUsuarioDisciplina()) {
                if (disciplina.getNuDisciplina().equals(usuarioDisciplina.getDisciplina().getNuDisciplina())) {
                    disciplina.setUsuarioMatriculado(true);
                    break;
                } else {
                    disciplina.setUsuarioMatriculado(false);
                }
            }
        }

        return listaDisciplina;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#calcularFormula(br.ufg.inf.siscoe.integracao.entidade.Disciplina)
     */
    @Override
    public Double calcularFormula(final Disciplina disciplina) {

        final AvaliadorExpressao avaliador = new AvaliadorExpressao();

        return avaliador.simularFormula(disciplina);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#calcularFormula(java.util.Collection,
     *      java.lang.String)
     */
    @Override
    public Double calcularFormula(final Collection<Avaliacao> listaAvaliacao, final String formula) {

        final AvaliadorExpressao avaliador = new AvaliadorExpressao();

        return avaliador.simularFormula(listaAvaliacao, formula);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#salvarUsuarioDisciplina(br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina)
     */
    @Override
    public void salvarUsuarioDisciplina(final UsuarioDisciplina usuarioDisciplina) {
        this.usuarioDisciplinaServico.salvar(usuarioDisciplina);

    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#salvarNotas(br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina)
     */
    @Override
    public void salvarNotas(final UsuarioDisciplina usuarioDisciplina) {
        this.usuarioDisciplinaServico.salvarNotas(usuarioDisciplina);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#validarDisciplina(br.ufg.inf.siscoe.integracao.entidade.Disciplina)
     */
    @Override
    public boolean validarDisciplina(final Disciplina entidade) {

        entidade.limparMensagens();

        boolean entidadeValida = Boolean.TRUE;

        if (UtilObjeto.isReferencia(entidade)) {
            if (!UtilObjeto.isReferencia(entidade.getNoDisciplina()) || entidade.getNoDisciplina().isEmpty()) {
                entidadeValida = Boolean.FALSE;
                entidade.adicionarMensagem(DisciplinaServicoImplementacao.CAMPO_OBRIGATORIO, "Disciplina");
            }

            if (!UtilObjeto.isReferencia(entidade.getNuCargaHoraria()) || entidade.getNuCargaHoraria() == 0) {
                entidadeValida = Boolean.FALSE;
                entidade.adicionarMensagem(DisciplinaServicoImplementacao.CAMPO_OBRIGATORIO, "Carga Horária");
            }

            if (!UtilObjeto.isReferencia(entidade.getNuHoraAula()) || entidade.getNuHoraAula() == 0) {
                entidadeValida = Boolean.FALSE;
                entidade.adicionarMensagem(DisciplinaServicoImplementacao.CAMPO_OBRIGATORIO, "Hora/Aula");
            }

            if (!UtilObjeto.isReferencia(entidade.getFmMediaFinal()) || entidade.getFmMediaFinal().isEmpty()) {
                entidadeValida = Boolean.FALSE;
                entidade.adicionarMensagem(DisciplinaServicoImplementacao.CAMPO_OBRIGATORIO, "Cálculo média final");
            }

            if (!UtilObjeto.isReferencia(entidade.getListaAvaliacao()) || entidade.getListaAvaliacao().isEmpty()) {
                entidadeValida = Boolean.FALSE;
                entidade.adicionarMensagem(NENHUMA_AVALIACAO);
            }
        } else {
            entidadeValida = Boolean.FALSE;
        }

        return entidadeValida;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#realizarMatricula(br.ufg.inf.siscoe.integracao.entidade.Usuario,
     *      br.ufg.inf.siscoe.integracao.entidade.Disciplina)
     */
    @Override
    public void realizarMatricula(final Usuario usuario, final Disciplina disciplina) {

        final UsuarioDisciplina usuarioDisciplina = new UsuarioDisciplina();

        usuarioDisciplina.setUsuario(usuario);
        usuarioDisciplina.setDisciplina(disciplina);
        usuarioDisciplina.setQtFaltas(0);

        usuarioDisciplina.setListaAvaliacaoUsuario(new ArrayList<AvaliacaoUsuario>());

        this.criarAvaliacoesUsuario(disciplina, usuarioDisciplina);

        this.usuarioDisciplinaServico.salvar(usuarioDisciplina);

    }

    /**
     *
     * Método responsável por criar as avaliações por usuario.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    private void criarAvaliacoesUsuario(final Disciplina disciplina, final UsuarioDisciplina usuarioDisciplina) {
        for (final Avaliacao avaliacao : disciplina.getListaAvaliacao()) {
            final AvaliacaoUsuario avaliacaoUsuario = new AvaliacaoUsuario();
            avaliacaoUsuario.setAvaliacao(avaliacao);
            avaliacaoUsuario.setDisciplina(disciplina);
            avaliacaoUsuario.setUsuarioDisciplina(usuarioDisciplina);
            if (!usuarioDisciplina.getListaAvaliacaoUsuario().contains(avaliacaoUsuario)) {
                usuarioDisciplina.getListaAvaliacaoUsuario().add(avaliacaoUsuario);
            }
        }
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#salvarDisciplina(br.ufg.inf.siscoe.integracao.entidade.Disciplina)
     */
    @Override
    public Disciplina salvarDisciplina(final Disciplina disciplina) {

        final AvaliadorExpressao avaliadorExpressao = new AvaliadorExpressao();

        disciplina.limparMensagens();

        final Collection<AvaliacaoUsuario> avaliacoesRemover = new ArrayList<AvaliacaoUsuario>();

        if (UtilObjeto.isReferencia(disciplina.getListaAvaliacaoUsuario())) {
            for (final AvaliacaoUsuario avaliacaoUsuario : disciplina.getListaAvaliacaoUsuario()) {
                for (final Avaliacao avaliacao : disciplina.getListaAvaliacao()) {
                    if (avaliacaoUsuario.getAvaliacao().getNuAvaliacao().equals(avaliacao.getNuAvaliacao())) {
                        avaliacoesRemover.remove(avaliacaoUsuario);
                        break;
                    } else {
                        if (!avaliacoesRemover.contains(avaliacaoUsuario)) {
                            avaliacoesRemover.add(avaliacaoUsuario);
                        }
                    }
                }

            }
        }

        disciplina.getListaAvaliacaoUsuario().removeAll(avaliacoesRemover);

        for (final UsuarioDisciplina usu : disciplina.getListaUsuarioDisciplina()) {
            usu.getListaAvaliacaoUsuario().removeAll(avaliacoesRemover);
            this.criarAvaliacoesUsuario(disciplina, usu);
        }

        for (final UsuarioDisciplina usu : disciplina.getListaUsuarioDisciplina()) {
            usu.setVrMediaFinal(avaliadorExpressao.simularFormula(usu, usu.getDisciplina().getFmMediaFinal()));
        }

        boolean formulaValida = Boolean.TRUE;

        for (final String noAvaliacao : avaliadorExpressao.localizarVariaveis(disciplina.getFmMediaFinal())) {
            for (final Avaliacao avaliacao : disciplina.getListaAvaliacao()) {
                if (avaliacao.getNoAvaliacao().equalsIgnoreCase(noAvaliacao)) {
                    formulaValida = Boolean.TRUE;
                    break;
                } else {
                    formulaValida = Boolean.FALSE;
                }
            }
        }

        if (formulaValida) {

            this.getDao().salvar(disciplina);

            this.avaliacaoUsuarioServico.removerTodos(avaliacoesRemover);

            this.avaliacaoUsuarioServico.flushEClear();
        } else {
            disciplina.adicionarMensagem("Existem avaliações na média final não incluídas para a disciplina.");
        }

        return disciplina;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.DisciplinaServico#removerAvaliacao(java.util.Collection)
     */
    @Override
    public void removerAvaliacao(Collection<Avaliacao> listaAvaliacaoRemover) {
        this.avaliacaoServico.removerTodos(listaAvaliacaoRemover);
    }
}
