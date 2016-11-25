package br.ufg.inf.siscoe.apresentacao.controlador;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.ufg.inf.siscoe.apresentacao.visao.DisciplinaVisao;
import br.ufg.inf.siscoe.comum.calculo.AvaliadorExpressao;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;
import br.ufg.inf.siscoe.negocio.servico.DisciplinaServico;

/**
 * <p>
 * DisciplinaMB.
 * </p>
 * <p>
 * Descrição: ManagedBean para entidade {@link Disciplina}.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@SessionScoped
@ManagedBean
public class DisciplinaMB extends ManutencaoBean<Disciplina> {

    private static final String NOTAS_SALVAS_COM_SUCESSO = "MA003";
    private static final String VARIAVEL_JA_EXISTE = "MA004";

    private static final long serialVersionUID = 4390334299817901639L;

    public static final String NOME_MANAGED_BEAN = "disciplinaMB";
    public static final String EL_MANAGED_BEAN = "#{disciplinaMB}";

    private static final String CADASTRO_USUARIO = "cadastroDisciplina";

    @Inject
    private DisciplinaServico servico;

    private DisciplinaVisao visao;

    /**
     *
     * Método responsável por ser executado ao iniciar o sistema.
     *
     * @author Bruno Martins de Carvalho
     */
    @PostConstruct
    public void init() {
        this.getVisao().setEntidade(new Disciplina());
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#carregar()
     */
    @Override
    protected void carregar() {

        this.getVisao().setFiltro(new Disciplina());
        this.getVisao().setListaDisciplina(this.servico.listarByFiltro(new Disciplina()));
        this.getVisao().setListaAvaliacaoRemover(new ArrayList<Avaliacao>());

        this.getTelaConsulta();
    }

    /**
     *
     * Método responsável por filtrar as disciplinas.
     *
     * @author Bruno Martins de Carvalho
     */
    public void filtrarDisciplina() {

        this.getVisao().setListaDisciplina(this.servico.listarByFiltro(this.getVisao().getFiltro()));
    }

    /**
     *
     * Método responsável por incluir uma nova disciplina.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String incluirNovaDisciplina() {

        this.getVisao().setEdicao(Boolean.FALSE);
        this.getVisao().setDetalhe(Boolean.FALSE);
        this.getVisao().setEntidade(new Disciplina());
        this.getVisao().setAvaliacao(new Avaliacao());

        this.getVisao().getEntidade().setIcAtivo(Boolean.TRUE);
        this.getVisao().getEntidade().setListaAvaliacao(new ArrayList<Avaliacao>());

        return this.getTelaInclusao();
    }

    /**
     *
     * Método responsável por salvar a discplina.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String salvarDisciplina() {

        final DisciplinaVisao visao = this.getVisao();

        String paginaRetorno = "";

        if (this.servico.validarDisciplina(visao.getEntidade())) {
            final Disciplina disciplina = this.servico.salvarDisciplina(visao.getEntidade());

            if (disciplina.hasMensagens()) {
                super.adicionaListaMensagemDeErro(disciplina.getMensagens());
            } else {
                this.servico.removerAvaliacao(visao.getListaAvaliacaoRemover());

                paginaRetorno = this.iniciar();
            }

        } else {
            super.adicionaListaMensagemDeErro(visao.getEntidade().getMensagens());
        }

        return paginaRetorno;
    }

    /**
     *
     * Método responsável por salvar a edição da disciplina.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String editarDisciplina(final Disciplina disciplina) {

        this.getVisao().setEdicao(Boolean.TRUE);
        this.getVisao().setDetalhe(Boolean.FALSE);
        this.getVisao().setEntidade(disciplina);

        return this.getTelaInclusao();
    }

    /**
     *
     * Método responsável por detalhar a disciplina.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String detalharDisciplina(final Disciplina disciplina) {

        this.getVisao().setEdicao(Boolean.FALSE);
        this.getVisao().setDetalhe(Boolean.TRUE);
        this.getVisao().setEntidade(disciplina);

        return this.getTelaInclusao();
    }

    /**
     *
     * Método responsável por incluir uma avaliacao a disciplina.
     *
     * @author Bruno Martins de Carvalho
     */
    public void incluirAvaliacaoDisciplina() {

        final DisciplinaVisao visao = this.getVisao();

        boolean variavelExiste = Boolean.FALSE;

        for (final Avaliacao avaliacao : visao.getEntidade().getListaAvaliacao()) {
            if (visao.getAvaliacao().getNoAvaliacao().equals(avaliacao.getNoAvaliacao())) {
                variavelExiste = Boolean.TRUE;
                break;
            }
        }

        if (!variavelExiste) {
            visao.getAvaliacao().setDisciplina(visao.getEntidade());
            visao.getEntidade().getListaAvaliacao().add(UtilObjeto.clone(visao.getAvaliacao()));
            visao.setAvaliacao(new Avaliacao());
        } else {
            super.adicionaMensagemDeErro(DisciplinaMB.VARIAVEL_JA_EXISTE);
        }

    }

    /**
     *
     * Método responsável por remover uma avaliação da disciplina.
     *
     * @param avaliacao
     *            valor a ser atribuido.
     * @author Bruno Martins de Carvalho
     */
    public void removerAvaliacaoDisciplina(final Avaliacao avaliacao) {

        Avaliacao avaliacaoRemover = new Avaliacao();

        for (final Avaliacao aval : this.getVisao().getEntidade().getListaAvaliacao()) {
            if (aval.getNoAvaliacao().equals(avaliacao.getNoAvaliacao())) {
                avaliacaoRemover = aval;
            }
        }

        this.getVisao().getListaAvaliacaoRemover().add(avaliacaoRemover);
        this.getVisao().getEntidade().getListaAvaliacao().remove(avaliacaoRemover);

        super.adicionaMensagemDeSucesso("Avaliação removida.");
    }

    /**
     *
     * Método responsável por abrir o modal de simulação da media final.
     *
     * @author Bruno Martins de Carvalho
     */
    public void abrirModalSimulacao() {

        this.getVisao().setListaAvaliacaoSimulacao(new ArrayList<Avaliacao>());
        this.getVisao().setResultadoSimulacao(null);

        final AvaliadorExpressao aval = new AvaliadorExpressao();

        for (final String noAvaliacao : aval.localizarVariaveis(this.getVisao().getEntidade().getFmMediaFinal())) {
            final Avaliacao avaliacao = new Avaliacao();
            avaliacao.setNoAvaliacao(noAvaliacao);
            this.getVisao().getListaAvaliacaoSimulacao().add(avaliacao);
        }

        RequestContext.getCurrentInstance().execute("PF('modalSimularFormulaWV').show();");
    }

    /**
     *
     * Método responsável por abrir a tela de administração da disciplina.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public String administrarDisciplina(final Disciplina disciplina) {

        this.getVisao().setEntidade(disciplina);

        return super.getTelaRelatorio();
    }

    /**
     *
     * Método responsável por preparar os objetos para abrir o modal de cadastro
     * de notas.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public void abrirCadastrarNotas(final UsuarioDisciplina usuarioDisciplina) {

        this.getVisao().setUsuarioDisciplina(usuarioDisciplina);
    }

    /**
     *
     * Método responsável por salvar as notas do aluno.
     *
     * @author Bruno Martins de Carvalho
     */
    public void salvarNotas() {

        this.servico.salvarNotas(this.getVisao().getUsuarioDisciplina());

        super.adicionaMensagemDeSucesso(DisciplinaMB.NOTAS_SALVAS_COM_SUCESSO);
    }

    /**
     *
     * Método responsável por simular o calculo.
     *
     * @author Bruno Martins de Carvalho
     */
    public void simularCalculo() {
        this.getVisao().setResultadoSimulacao(
                this.servico.calcularFormula(this.getVisao().getListaAvaliacaoSimulacao(), this.getVisao().getEntidade().getFmMediaFinal()));
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getPrefixoCasoDeUso()
     */
    @Override
    protected String getPrefixoCasoDeUso() {
        return CADASTRO_USUARIO;
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getService()
     */
    @Override
    @SuppressWarnings("unchecked")
    public DisciplinaServico getService() {
        return this.servico;
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getVisao()
     */
    @Override
    public DisciplinaVisao getVisao() {
        if (!UtilObjeto.isReferencia(this.visao)) {
            this.visao = new DisciplinaVisao();
        }
        return this.visao;
    }

}
