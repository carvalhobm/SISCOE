package br.ufg.inf.siscoe.apresentacao.controlador;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.ufg.inf.siscoe.apresentacao.visao.CadastroVisao;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Role;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.negocio.servico.UsuarioServico;

/**
 * <p>
 * CadastroMB.
 * </p>
 * <p>
 * Descrição: ManagedBean para entidade Usuario.
 * </p>
 *
 * @author nomeDoAutor
 */
@SessionScoped
@ManagedBean
public class CadastroMB extends ManutencaoBean<Usuario> {

    private static final long serialVersionUID = 4390334299817901639L;

    public static final String NOME_MANAGED_BEAN = "cadastroMB";
    public static final String EL_MANAGED_BEAN = "#{cadastroMB}";

    private static final String CADASTRO_USUARIO = "cadastroUsuario";

    @Inject
    private UsuarioServico servico;

    private CadastroVisao visao;

    /**
     *
     * Método responsável por ser executado no login do usuario.
     *
     * @author Bruno Martins de Carvalho
     */
    @PostConstruct
    public void init() {
        this.getVisao().setMensagemSucesso(null);
        this.getVisao().setEntidade(new Usuario());
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#carregar()
     */
    @Override
    protected void carregar() {

        this.getVisao().setFiltro(new Usuario());
        this.getVisao().setListaUsuario(this.servico.listarByFiltro(new Usuario()));
        this.getVisao().setListaCredencial(this.servico.listarCredenciais());

        this.getTelaInclusao();
    }

    /**
     *
     * Método responsável por salvar um usuario.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String salvarUsuario() {

        if (!this.servico.existeUsuarioCadastrado(this.getVisao().getEntidade())) {
            final Usuario usuario = this.servico.salvarUsuario(this.getVisao().getEntidade());

            super.adicionaListaMensagemDeSucesso(usuario.getMensagens());

            return "/paginas/index.xhtml?faces-redirect=true";
        } else {
            super.adicionaMensagemDeErro("Username já cadastrado.");
        }

        return "";
    }

    /**
     *
     * Método responsável por salvar um usuario na area interna do sistema.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String salvarUsuarioInterno() {
        final CadastroVisao visao = this.getVisao();

        if (visao.isEdicao()) {
            this.servico.alterar(visao.getEntidade());

            super.adicionaMensagemDeSucesso("MA002");

            return this.iniciar();
        } else if (!this.servico.existeUsuarioCadastrado(this.getVisao().getEntidade())) {

            this.servico.salvar(visao.getEntidade());

            super.adicionaMensagemDeSucesso("MA002");

            return this.iniciar();
        } else {
            super.adicionaMensagemDeErro("uc_cadastro_usuario_ja_cadastrado");
        }

        return "";
    }

    /**
     *
     * Método responsável por filtrar a lista de usuarios.
     *
     * @author Bruno Martins de Carvalho
     */
    public void filtrarUsuario() {

        this.getVisao().setListaUsuario(this.servico.listarByFiltro(this.getVisao().getFiltro()));

    }

    /**
     *
     * Método responsável por limpar a mensagem na area externa do sistma.
     *
     * @author Bruno Martins de Carvalho
     */
    public void limparMensagem() {
        this.getVisao().setMensagemSucesso(null);
    }

    /**
     *
     * Método responsável por abrir a area externa de inclusao de usuario.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String getTelaInclusaoExterna() {

        this.getVisao().setEntidade(new Usuario());

        return "/" + this.getPrefixoCasoDeUso() + SUFIXO_TELA_INCLUSAO;
    }

    /**
     *
     * Método responsável por incluir um novo usuario.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String incluirNovoUsuario() {

        this.getVisao().setEdicao(false);
        this.getVisao().setEntidade(new Usuario());

        return super.getTelaInclusao();
    }

    /**
     *
     * Método responsável por abrir a tela de edicao de usuario.
     *
     * @param usuario
     *            valor a ser atribuido
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String editarUsuario(final Usuario usuario) {

        this.getVisao().setEdicao(true);
        this.getVisao().setEntidade(this.servico.inicializarUsuario(usuario));

        return super.getTelaInclusao();
    }

    /**
     *
     * Método responsável por remover a autorização de acesso do usuario.
     *
     * @param usuario
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public void desautorizarUsuario(final Usuario usuario) {

        usuario.setIcPermitido(Boolean.FALSE);
        usuario.setListaRole(new ArrayList<Role>());

        this.servico.salvar(usuario);

        super.adicionaMensagemDeSucesso("Ação realizada com sucesso!");

    }

    /**
     *
     * Método responsável por autorizar o acesso do usuario.
     *
     * @param usuario
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public void autorizarUsuario(final Usuario usuario) {

        usuario.setIcPermitido(Boolean.TRUE);
        usuario.setListaRole(new ArrayList<Role>());

        this.servico.salvar(usuario);

        super.adicionaMensagemDeSucesso("Ação realizada com sucesso!");

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
    public UsuarioServico getService() {
        return this.servico;
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getVisao()
     */
    @Override
    public CadastroVisao getVisao() {
        if (!UtilObjeto.isReferencia(this.visao)) {
            this.visao = new CadastroVisao();
        }
        return this.visao;
    }

}
