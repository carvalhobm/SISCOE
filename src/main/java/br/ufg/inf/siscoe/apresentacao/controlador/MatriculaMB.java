package br.ufg.inf.siscoe.apresentacao.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.ufg.inf.siscoe.apresentacao.visao.MatriculaVisao;
import br.ufg.inf.siscoe.comum.util.UsuarioUtil;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.negocio.servico.DisciplinaServico;
import br.ufg.inf.siscoe.negocio.servico.UsuarioServico;

/**
 * <p>
 * MatriculaMB.
 * </p>
 * <p>
 * Descrição: Controlador para a tela de matricula.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@SessionScoped
@ManagedBean
public class MatriculaMB extends ManutencaoBean<Disciplina> {

    private static final long serialVersionUID = 8375734340761187891L;

    public static final String NOME_MANAGED_BEAN = "matriculaMB";
    public static final String EL_MANAGED_BEAN = "#{matriculaMB}";

    private static final String MATRICULA_DISCIPLINA = "matriculaDisciplina";

    private static final String MATRICULA_REALIZADA_COM_SUCESSO = "MA008";

    @Inject
    private DisciplinaServico servico;

    @Inject
    private UsuarioServico usuarioServico;

    private MatriculaVisao visao;

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#iniciar()
     */
    @Override
    public String iniciar() {

        this.getVisao().setFiltro(new Disciplina());
        this.getVisao().getFiltro().setIcAtivo(Boolean.TRUE);
        this.getVisao().setListaDisciplina(this.servico.listarByFiltro(this.getVisao().getFiltro()));

        return super.getTelaConsulta();
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
     * Método responsável por realizar matricula na disciplina.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public void matricular(final Disciplina disciplina) {

        final Usuario usuario = this.usuarioServico.obterUsuarioByUsername(UsuarioUtil.getUserLogado().getUsername());

        this.servico.realizarMatricula(usuario, disciplina);
        
        this.filtrarDisciplina();

        super.adicionaMensagemDeSucesso(MatriculaMB.MATRICULA_REALIZADA_COM_SUCESSO);
    }

    /**
     *
     * Método responsável por realizar matricula via tela de detalhe.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String matricularViaDetalhe(final Disciplina disciplina) {
        this.matricular(disciplina);

        return this.iniciar();
    }

    /**
     *
     * Método responsável por abrir a tela de detalhe da disciplina.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String abrirTelaDetalhe(final Disciplina disciplina) {

        this.getVisao().setEntidade(disciplina);

        return super.getTelaDetalhe();
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getPrefixoCasoDeUso()
     */
    @Override
    protected String getPrefixoCasoDeUso() {
        return MatriculaMB.MATRICULA_DISCIPLINA;
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
    public MatriculaVisao getVisao() {
        if (!UtilObjeto.isReferencia(this.visao)) {
            this.visao = new MatriculaVisao();
        }
        return this.visao;
    }

}
