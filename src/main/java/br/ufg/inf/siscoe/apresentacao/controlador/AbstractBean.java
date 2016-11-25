package br.ufg.inf.siscoe.apresentacao.controlador;

import java.util.List;

import br.ufg.inf.siscoe.apresentacao.visao.ManutencaoVisao;
import br.ufg.inf.siscoe.comum.to.MensagemTO;
import br.ufg.inf.siscoe.comum.util.MensagensUtil;
import br.ufg.inf.siscoe.integracao.dao.DAO;
import br.ufg.inf.siscoe.integracao.entidade.Entidade;
import br.ufg.inf.siscoe.negocio.servico.Servico;

public abstract class AbstractBean<E extends Entidade> {

    protected static String MESMA_TELA = "";
    protected static String NOME_DIRETORIO_PAGINAS = "/paginas/";
    protected static String SUFIXO_TELA_CONSULTA = "/consulta.xhtml?faces-redirect=true";
    protected static String SUFIXO_TELA_DETALHE = "/detalhe.xhtml?faces-redirect=true";
    protected static String SUFIXO_TELA_INCLUSAO = "/inclusao.xhtml?faces-redirect=true";
    protected static String SUFIXO_TELA_EDICAO = "/edicao.xhtml?faces-redirect=true";
    protected static String SUFIXO_TELA_RELATORIO = "/relatorio.xhtml?faces-redirect=true";

    protected static String VAR_RESOURCE_BUNDLE_PADRAO = "msg";

    /**
     * Retorna o nome da vari�vel correspondente ao resource bundle utilizado no
     * projeto. Classes base do projeto devem implementar este m�todo retornando
     * o nome da vari�vel definida no faces-config.xml que referencia o
     * resource-bundle carregado para o projeto.
     *
     * @return o nome da vari�vel que referencia o resource bundle do projeto
     */
    protected String getNomeVarResourceBundle() {
        return VAR_RESOURCE_BUNDLE_PADRAO;
    }

    /**
     * Retorna o prefixo do caso de uso para formar o nome l�gico das telas. A
     * sugest�o � que seja usado o nome do caso de uso em camelCase. Por
     * exemplo: 'manterContrato', 'manterServico'. Consequentemente o nome
     * l�gico que ser� formado ser�, por exemplo,
     * 'manterContrato/consulta.xhtml' ou 'selecionarCidade/detalhe.xhtml'.<br>
     * <b>Casos de uso que estendem esta classe devem sobrescrever este m�todo
     * para manter o padr�o.</b>
     *
     * @return o prefixo padr�o para formar o nome l�gico das p�ginas.
     */
    protected abstract String getPrefixoCasoDeUso();

    /**
     * Retorna nome l�gico padr�o para tela de consulta.
     *
     * @return o nome l�gico da tela de consulta
     */
    public String getTelaConsulta() {
        return NOME_DIRETORIO_PAGINAS + this.getPrefixoCasoDeUso() + SUFIXO_TELA_CONSULTA;
    }

    /**
     * Retorna nome l�gico padr�o para tela de detalhe.
     *
     * @return o nome l�gico da tela de detalhe
     */
    public String getTelaDetalhe() {
        return NOME_DIRETORIO_PAGINAS + this.getPrefixoCasoDeUso() + SUFIXO_TELA_DETALHE;
    }

    /**
     * Retorna nome l�gico padr�o para tela de inclus�o.
     *
     * @return o nome l�gico da tela de inclus�o
     */
    public String getTelaInclusao() {
        return NOME_DIRETORIO_PAGINAS + this.getPrefixoCasoDeUso() + SUFIXO_TELA_INCLUSAO;
    }

    /**
     * Retorna nome l�gico padr�o para tela de altera��o.
     *
     * @return o nome l�gico da tela de altera��o
     */
    public String getTelaEdicao() {
        return NOME_DIRETORIO_PAGINAS + this.getPrefixoCasoDeUso() + SUFIXO_TELA_EDICAO;
    }

    /**
     * Retorna nome l�gico padr�o para tela de relat�rio.
     *
     * @return o nome l�gico da tela de relat�rio
     */
    public String getTelaRelatorio() {
        return NOME_DIRETORIO_PAGINAS + this.getPrefixoCasoDeUso() + SUFIXO_TELA_RELATORIO;
    }

    /**
     * M�todo padr�o para abrir a tela inicial do caso de uso.
     *
     * @return nome l�gico da p�gina que ser� chamada ap�s execu��o da opera��o.
     */
    public String iniciar() {
        this.carregar();
        return this.getTelaConsulta();
    }

    /**
     * Classes que estendem AbstractBean devem estender este m�todo, que ser�
     * chamado na implementa��o padr�o do inciar() antes de chamar a p�gina
     * inicial do caso de uso.
     *
     */
    protected void carregar() {
        // implementa��o padr�o n�o faz nada
    }

    /**
     * Adiciona no JSF uma mensagem de sucesso.
     *
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     */
    protected void adicionaMensagemDeSucesso(String chave, String... argumentos) {
        MensagensUtil.adicionaMensagemDeSucesso(this.getNomeVarResourceBundle(), chave, argumentos);
    }

    /**
     * Adiciona no JSF uma lista de mensagens de sucesso.
     *
     * @param listaMensagemTO
     *            valor a ser atribuido
     */
    protected void adicionaListaMensagemDeSucesso(final List<MensagemTO> listaMensagemTO) {
        for (final MensagemTO mensagem : listaMensagemTO) {
            MensagensUtil.adicionaMensagemDeSucesso(this.getNomeVarResourceBundle(), mensagem.getChaveMensagem(), mensagem.getArgumentos());
        }
    }

    /**
     * Adiciona no JSF uma mensagem informativa.
     *
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     */
    protected void adicionaMensagemInformativa(String chave, String... argumentos) {
        MensagensUtil.adicionaMensagemInformativa(this.getNomeVarResourceBundle(), chave, argumentos);
    }

    /**
     * Adiciona no JSF uma lista de mensagens informativa.
     *
     * @param listaMensagemTO
     *            valor a ser atribuido
     */
    protected void adicionaListaMensagemInformativa(final List<MensagemTO> listaMensagemTO) {
        for (final MensagemTO mensagem : listaMensagemTO) {
            MensagensUtil.adicionaMensagemInformativa(this.getNomeVarResourceBundle(), mensagem.getChaveMensagem(), mensagem.getArgumentos());
        }
    }

    /**
     * Adiciona no JSF uma mensagem de alerta.
     *
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     */
    protected void adicionaMensagemDeAlerta(String chave, String... argumentos) {
        MensagensUtil.adicionaMensagemDeAlerta(this.getNomeVarResourceBundle(), chave, argumentos);
    }

    /**
     * Adiciona no JSF uma lista de mensagens de alerta.
     *
     *
     * @param listaMensagemTO
     *            valor a ser atribuido
     */
    protected void adicionaListaMensagemDeAlerta(final List<MensagemTO> listaMensagemTO) {
        for (final MensagemTO mensagem : listaMensagemTO) {
            MensagensUtil.adicionaMensagemDeAlerta(this.getNomeVarResourceBundle(), mensagem.getChaveMensagem(), mensagem.getArgumentos());
        }
    }

    /**
     * Adiciona no JSF uma mensagem de erro.
     *
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     */
    protected void adicionaMensagemDeErro(String chave, String... argumentos) {
        MensagensUtil.adicionaMensagemDeErro(this.getNomeVarResourceBundle(), chave, argumentos);
    }

    /**
     * Adiciona no JSF uma lista de mensagens de erro.
     *
     * @param listaMensagemTO
     *            valor a ser atribuido
     */
    protected void adicionaListaMensagemDeErro(final List<MensagemTO> listaMensagemTO) {
        for (final MensagemTO mensagem : listaMensagemTO) {
            MensagensUtil.adicionaMensagemDeErro(this.getNomeVarResourceBundle(), mensagem.getChaveMensagem(), mensagem.getArgumentos());
        }
    }

    /**
     * Adiciona no JSF uma mensagem de erro fatal (de sistema).
     *
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     */
    protected void adicionaMensagemDeErroDeSistema(String chave, String... argumentos) {
        MensagensUtil.adicionaMensagemDeErroDeSistema(this.getNomeVarResourceBundle(), chave, argumentos);
    }

    /**
     * Adiciona no JSF uma lista de mensagens de erro fatal (de sistema).
     *
     * @param listaMensagemTO
     *            valor a ser atribuido
     */
    protected void adicionaMensagemDeErroDeSistema(final List<MensagemTO> listaMensagemTO) {
        for (final MensagemTO mensagem : listaMensagemTO) {
            MensagensUtil.adicionaMensagemDeErroDeSistema(this.getNomeVarResourceBundle(), mensagem.getChaveMensagem(), mensagem.getArgumentos());
        }
    }

    /**
     * Retorna o service correspondente � manuten��o da entidade E.
     *
     * @return o service
     */
    public abstract <S extends Servico<E, DAO<E>>> S getService();

    /**
     * Retorna a vis�o deste caso de uso.
     *
     * @return a vis�o
     */
    public abstract ManutencaoVisao<E> getVisao();

}
