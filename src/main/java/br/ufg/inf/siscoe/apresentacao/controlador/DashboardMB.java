package br.ufg.inf.siscoe.apresentacao.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import br.ufg.inf.siscoe.apresentacao.visao.DashboardVisao;
import br.ufg.inf.siscoe.comum.util.UsuarioUtil;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;
import br.ufg.inf.siscoe.negocio.servico.UsuarioServico;

/**
 * <p>
 * DashboardMB.
 * </p>
 * <p>
 * Descrição: ManagedBean para entidade Usuario na tela inicial.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@SessionScoped
@ManagedBean
public class DashboardMB extends ManutencaoBean<Usuario> {

    private static final long serialVersionUID = -9146607373227600433L;

    public static final String NOME_MANAGED_BEAN = "dashboardMB";
    public static final String EL_MANAGED_BEAN = "#{dashboardMB}";

    private static final String DASHBOARD_DISCENTE = "dashboardDiscente";

    private static final String FALTA_REGISTRADA_COM_SUCESSO = "MA005";

    private static final String PAGINA_INICIAL = "/paginas/index.xhtml?faces-redirect=true";

    private DashboardVisao visao;

    @Inject
    private UsuarioServico servico;

    @PostConstruct
    public void init() {

        this.iniciar();
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#iniciar()
     */
    @Override
    public String iniciar() {

        this.getVisao().setModel(new DefaultDashboardModel());

        final Usuario usuario = this.servico.obterUsuarioByUsername(UsuarioUtil.getUserLogado().getUsername());

        this.getVisao().setEntidade(usuario);

        final DashboardColumn coluna1 = new DefaultDashboardColumn();
        final DashboardColumn coluna2 = new DefaultDashboardColumn();
        final DashboardColumn coluna3 = new DefaultDashboardColumn();
        final DashboardColumn coluna4 = new DefaultDashboardColumn();
        final DashboardColumn coluna5 = new DefaultDashboardColumn();

        int indexColuna = 1;

        for (final UsuarioDisciplina usuarioDisciplina : usuario.getListaUsuarioDisciplina()) {

            if (indexColuna == 1) {
                coluna1.addWidget(usuarioDisciplina.getDisciplina().getNoDisciplinaFormatado());
            } else if (indexColuna == 2) {
                coluna2.addWidget(usuarioDisciplina.getDisciplina().getNoDisciplinaFormatado());
            } else if (indexColuna == 3) {
                coluna3.addWidget(usuarioDisciplina.getDisciplina().getNoDisciplinaFormatado());
            } else if (indexColuna == 4) {
                coluna4.addWidget(usuarioDisciplina.getDisciplina().getNoDisciplinaFormatado());
            } else {
                coluna5.addWidget(usuarioDisciplina.getDisciplina().getNoDisciplinaFormatado());
                indexColuna = 0;
            }
            indexColuna++;
        }

        this.getVisao().getModel().addColumn(coluna1);
        this.getVisao().getModel().addColumn(coluna2);
        this.getVisao().getModel().addColumn(coluna3);
        this.getVisao().getModel().addColumn(coluna4);
        this.getVisao().getModel().addColumn(coluna5);

        return DashboardMB.PAGINA_INICIAL;
    }

    /**
     *
     * Método responsável por registrar falta pelo aluno.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public void registrarFalta(final UsuarioDisciplina usuarioDisciplina) {

        this.servico.registrarFaltaUsuarioDisciplina(usuarioDisciplina);

        super.adicionaMensagemDeSucesso(DashboardMB.FALTA_REGISTRADA_COM_SUCESSO);
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getPrefixoCasoDeUso()
     */
    @Override
    protected String getPrefixoCasoDeUso() {
        return DashboardMB.DASHBOARD_DISCENTE;
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getService()
     */
    @SuppressWarnings("unchecked")
    @Override
    public UsuarioServico getService() {
        return this.servico;
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getVisao()
     */
    @Override
    public DashboardVisao getVisao() {
        if (!UtilObjeto.isReferencia(this.visao)) {
            this.visao = new DashboardVisao();
        }
        return this.visao;
    }

}
