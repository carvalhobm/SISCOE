package br.ufg.inf.siscoe.apresentacao.controlador;

import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufg.inf.siscoe.integracao.entidade.Entidade;

public abstract class ManutencaoBean<E extends Entidade> extends AbstractBean<E> implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -6434118688354179376L;

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(ManutencaoBean.class.getName());

    private transient HttpSession httpSession = null;

    /**
     * <p>
     * M�todo respons�vel por salvar a entidade persistente.
     * </p>
     *
     * @param entidade
     *            valor a ser atribuido.
     * @return String com a mensagem de sucesso
     *
     */
    public String salvar(final E entidade) {
        super.adicionaMensagemDeSucesso(this.getService().salvar(entidade));
        return AbstractBean.MESMA_TELA;
    }

    /**
     * <p>
     * M�todo respons�vel por inserir em banco de dados inst�ncia de entidade.
     * </p>
     *
     * @param entidade
     *            valor a ser atribuido
     *
     */
    public String inserir(final E entidade) {
        super.adicionaMensagemDeSucesso(this.getService().inserir(entidade));
        return AbstractBean.MESMA_TELA;
    }

    /**
     * <p>
     * M�todo respons�vel por alterar em banco de dados inst�ncia de entidade.
     * <p>
     *
     * @param entidade
     *            valor a ser atribuido
     *
     */
    public String alterar(final E entidade) {
        super.adicionaMensagemDeSucesso(this.getService().alterar(entidade));
        return AbstractBean.MESMA_TELA;
    }

    /**
     * <p>
     * M�todo respons�vel por excluir do banco de dados inst�ncia de entidade.
     * <p>
     *
     * @param entidade
     *            valor a ser atribuido
     *
     */
    public String remover(final E entidade) {
        super.adicionaMensagemDeSucesso(this.getService().remover(entidade));
        return AbstractBean.MESMA_TELA;
    }

    /**
     * <p>
     * M�todo respons�vel por excluir em banco de dados as inst�ncias das
     * entidades.
     * <p>
     *
     * @param listaEntidade
     *            valor a ser atribuido
     *
     */
    public String removerTodos(final Collection<E> listaEntidade) {
        super.adicionaMensagemDeSucesso(this.getService().removerTodos(listaEntidade));
        return AbstractBean.MESMA_TELA;
    }

    /**
     * <p>
     * M�todo respons�vel por exclui em banco de dados entidades que t�m os IDS
     * passados como par�metro.
     * <p>
     *
     * @param ids
     *            valor a ser atribuido
     *
     */
    protected String removerTodosPorId(final Collection<Serializable> ids) {
        super.adicionaMensagemDeSucesso(this.getService().removerTodosPorId(ids));
        return AbstractBean.MESMA_TELA;
    }

    /**
     * <p>
     * M�todo respons�vel por listar todas as entidades que est�o na base de
     * dados.
     * <p>
     *
     * @return Collection<>
     *
     */
    protected Collection<E> listar() {
        return this.getService().listar();
    }

    /**
     * <p>
     * M�todo respons�vel por obter a entidade do id passado como par�metro.
     * <p>
     *
     * @param id
     *            valor a ser atribuido
     * @return E entidade do id passado como par�metro
     *
     */
    protected E obter(final Serializable id) {
        return this.getService().obter(id);
    }

    /**
     * <p>
     * M�todo respons�vel por obter a sess�o http.
     * </p>
     *
     * @return HttpSession
     */
    protected HttpSession getSession() {
        return this.getRequest().getSession();
    }

    /**
     * <p>
     * M�todo respons�vel por obter a resposta de um requisi��o http.
     * </p>
     *
     * @return HttpServletResponse
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) this.getExternalContext().getResponse();
    }

    /**
     * <p>
     * M�todo respons�vel por obter o contexto externo.
     * </p>
     *
     * @return ExternalContext
     */
    protected ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    /**
     * <p>
     * M�todo respons�vel por obter a requisi��o http.
     * </p>
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) this.getExternalContext().getRequest();
    }

    /**
     * <p>
     * M�todo respons�vel por obter httpSession.
     * <p>
     *
     * @return HttpSession
     *
     */
    public HttpSession getHttpSession() {
        if (FacesContext.getCurrentInstance() != null) {
            this.httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        }
        return this.httpSession;
    }

    /**
     * Exibe as mensagens contidas na lista de mensagem.
     *
     *
     * @param entidade
     *            valor a ser atribuido
     */
    protected void enviarMensagensErro(final E entidade) {
        this.adicionaListaMensagemDeErro(entidade.getMensagens());
    }

}
