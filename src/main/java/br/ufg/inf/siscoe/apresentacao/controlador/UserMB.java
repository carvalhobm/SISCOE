package br.ufg.inf.siscoe.apresentacao.controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.ufg.inf.siscoe.apresentacao.visao.ManutencaoVisao;
import br.ufg.inf.siscoe.comum.util.UsuarioUtil;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.negocio.servico.UsuarioServico;

@SessionScoped
@ManagedBean
public class UserMB extends ManutencaoBean<Usuario> {

    private static final long serialVersionUID = 4390334299817901639L;

    public static final String NOME_MANAGED_BEAN = "userMB";
    public static final String EL_MANAGED_BEAN = "#{userMB}";

    private Usuario usuarioLogado;

    @Inject
    private UsuarioServico servico;

    /**
     *
     * Método responsável por Ser executado ao realizar login.
     *
     * @author Bruno Martins de Carvalho
     */
    @PostConstruct
    public void init() {

        this.usuarioLogado = this.servico.obterUsuarioByUsername(UsuarioUtil.getUserLogado().getUsername());

    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.controlador.AbstractBean#getPrefixoCasoDeUso()
     */
    @Override
    protected String getPrefixoCasoDeUso() {
        return null;
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
    public ManutencaoVisao<Usuario> getVisao() {
        return null;
    }

    /**
     * Get.
     * 
     * @return the usuarioLogado
     */
    public Usuario getUsuarioLogado() {
        if (!UtilObjeto.isReferencia(this.usuarioLogado)) {
            this.usuarioLogado = new Usuario();
        }
        return this.usuarioLogado;
    }

    /**
     * Set.
     * 
     * @param usuarioLogado
     *            the usuarioLogado to set
     */
    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

}