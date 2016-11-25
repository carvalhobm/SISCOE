package br.ufg.inf.siscoe.apresentacao.visao;

import java.util.ArrayList;
import java.util.Collection;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Role;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;

/**
 * <p>
 * CadastroVisao.
 * </p>
 * <p>
 * Descrição: Visao para entidade usuario.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class CadastroVisao extends ManutencaoVisao<Usuario> {

    private static final long serialVersionUID = 6573853182097920066L;

    private Usuario entidade;

    private Usuario filtro;

    private String mensagemSucesso;

    private boolean edicao;

    private Collection<Usuario> listaUsuario;

    private Collection<Role> listaCredencial;

    /**
     * @see br.ufg.inf.siscoe.apresentacao.visao.ManutencaoVisao#getEntidade()
     */
    @Override
    public Usuario getEntidade() {
        if (!UtilObjeto.isReferencia(this.entidade)) {
            this.entidade = new Usuario();
        }
        return this.entidade;
    }

    /**
     * @see br.ufg.inf.siscoe.apresentacao.visao.ManutencaoVisao#setEntidade(br.ufg.inf.siscoe.integracao.entidade.Entidade)
     */
    @Override
    public void setEntidade(Usuario entidade) {
        this.entidade = entidade;
    }

    /**
     * Get/Set.
     *
     * @return the mensagemSucesso
     */
    public String getMensagemSucesso() {
        return this.mensagemSucesso;
    }

    /**
     * Get/Set.
     *
     * @param mensagemSucesso
     *            the mensagemSucesso to set
     */
    public void setMensagemSucesso(String mensagemSucesso) {
        this.mensagemSucesso = mensagemSucesso;
    }

    /**
     * Get/Set.
     *
     * @return the listaUsuario
     */
    public Collection<Usuario> getListaUsuario() {
        if (!UtilObjeto.isReferencia(this.listaUsuario)) {
            this.listaUsuario = new ArrayList<Usuario>();
        }
        return this.listaUsuario;
    }

    /**
     * Get/Set.
     *
     * @param listaUsuario
     *            the listaUsuario to set
     */
    public void setListaUsuario(Collection<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    /**
     * Get/Set.
     *
     * @return the filtro
     */
    public Usuario getFiltro() {
        if (!UtilObjeto.isReferencia(this.filtro)) {
            this.filtro = new Usuario();
        }
        return this.filtro;
    }

    /**
     * Get/Set.
     *
     * @param filtro
     *            the filtro to set
     */
    public void setFiltro(Usuario filtro) {
        this.filtro = filtro;
    }

    /**
     * Get/Set.
     *
     * @return the listaCredencial
     */
    public Collection<Role> getListaCredencial() {
        return this.listaCredencial;
    }

    /**
     * Get/Set.
     *
     * @param listaCredencial
     *            the listaCredencial to set
     */
    public void setListaCredencial(Collection<Role> listaCredencial) {
        this.listaCredencial = listaCredencial;
    }

    /**
     * Get/Set.
     *
     * @return the edicao
     */
    public boolean isEdicao() {
        return this.edicao;
    }

    /**
     * Get/Set.
     *
     * @param edicao
     *            the edicao to set
     */
    public void setEdicao(boolean edicao) {
        this.edicao = edicao;
    }

}
