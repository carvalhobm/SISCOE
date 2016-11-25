package br.ufg.inf.siscoe.comum.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import br.ufg.inf.siscoe.excecao.SistemaException;

/**
 * <p>
 * MensagensUtil.
 * </p>
 * <p>
 * Descrição: Classe utilitária para mensagens do primefaces.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class MensagensUtil {
    public static final FacesMessage.Severity MSG_TIPO_AVISO = FacesMessage.SEVERITY_WARN;
    public static final FacesMessage.Severity MSG_TIPO_ERRO = FacesMessage.SEVERITY_ERROR;
    public static final FacesMessage.Severity MSG_TIPO_FATAL = FacesMessage.SEVERITY_FATAL;
    public static final FacesMessage.Severity MSG_TIPO_INFORMACAO = FacesMessage.SEVERITY_INFO;

    private List<String> mensagens;
    private Properties properties;

    /**
     * Construtor.
     *
     * @param classe
     *            valor a ser atribuido
     * @param nomeArquivo
     *            valor a ser atribuido
     */
    public MensagensUtil(Class<?> classe, String nomeArquivo) {
        if (UtilObjeto.isReferencia(classe) && UtilObjeto.isReferencia(nomeArquivo) && !UtilString.isVazio(nomeArquivo)) {
            this.properties = new Properties();
            try {
                this.properties.load(classe.getClassLoader().getResourceAsStream(nomeArquivo));
            } catch (final IOException e) {
                LogUtil.error(e.getMessage());
            }
        } else {
            throw new NullPointerException("Erro ao inicializar componente de internacionaliza��o.");
        }
    }

    /**
     *
     * Construtor.
     *
     */
    public MensagensUtil() {
    }

    /**
     * Metodo indica se existem mensagens adicionadas a serem apresentadas para
     * o usuario.
     *
     * @return true|false
     *
     */
    public boolean isMensagens() {
        return this.mensagens != null && this.mensagens.isEmpty() ? true : false;
    }

    /**
     * Retorna uma mensagem de um ResourceBundle configurado.
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     * @return a mensagem com os argumentos inseridos
     *
     */
    public static String getMensagem(String resourceBundleVar, String chave, String... argumentos) {

        final ResourceBundle rb = ResourceBundleUtil.getResourceBundle(resourceBundleVar);

        if (rb == null) {
            throw new SistemaException("ResourceBundle n�o encontrado: '" + resourceBundleVar + "'");
        }

        String mensagem;
        try {
            mensagem = rb.getString(chave);
            if (mensagem == null) {
                return chave;
            }
        } catch (final Exception e) {
            throw new SistemaException("texto para a chave '" + chave + "' n�o encontrada no resource bundle '" + resourceBundleVar + "'", e);
        }

        if (argumentos == null || argumentos.length == 0) {
            return mensagem;
        }

        final String[] argumentosRecuperados = new String[argumentos.length];
        for (int i = 0; i < argumentos.length; i++) {
            try {
                final String valor = rb.getString(argumentos[i]);
                argumentosRecuperados[i] = valor != null && valor.trim().length() > 0 ? valor : argumentos[i];
            } catch (final Exception e) {
                LogUtil.error(e.getMessage());
                argumentosRecuperados[i] = argumentos[i];
                continue;
            }
        }

        final MessageFormat mf = new MessageFormat(mensagem);
        return mf.format(argumentosRecuperados, new StringBuffer(), null).toString();
    }

    /**
     * Dada uma mensagem (String) e sua severity, verifica se ela j� foi
     * inclu�da na fila de mensagens do JSF.
     *
     * @param severity
     *            a severity
     * @param textoMensagem
     *            a mensagem.
     * @return true caso j� exista na fila de mensagens do JSF.
     *
     */
    private static boolean mensagemExisteNaFila(Severity severity, String textoMensagem) {
        if (severity == null || textoMensagem == null) {
            throw new IllegalArgumentException("Severity e texto da mensagem n�o podem ser nulos.");
        }
        final Iterator<FacesMessage> mensagens = FacesContext.getCurrentInstance().getMessages();
        boolean jaIncluida = false;
        while (mensagens.hasNext()) {
            final FacesMessage mensagemAtual = mensagens.next();
            if (severity.equals(mensagemAtual.getSeverity()) && textoMensagem.equals(mensagemAtual.getSummary())) {
                jaIncluida = true;
                break;
            }
        }
        return jaIncluida;
    }

    /**
     * Adicionar mensagem ao contexto JSF.
     *
     * @param severity
     *            valor a ser atribuido
     * @param msgFormatada
     *            valor a ser atribuido
     *
     */
    public static void adicionarMensagem(Severity severity, String msgFormatada) {
        // s� adiciona mensagem na fila do JSF caso ela j� n�o tenha sido
        // inclu�da.
        if (!mensagemExisteNaFila(severity, msgFormatada)) {
            final FacesMessage facesMessage = new FacesMessage(severity, msgFormatada, msgFormatada);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        }
    }

    /**
     * Adiciona no JSF uma mensagem definindo sua gravidade.
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param severity
     *            a gravidade da mensagem (erro, alerta, informa��o etc.)
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     *
     */
    public static void adicionaMensagem(String resourceBundleVar, Severity severity, String chave, String... argumentos) {
        String msgFormatada;

        try {
            msgFormatada = getMensagem(resourceBundleVar, chave, argumentos);
        } catch (final Exception e) {
            LogUtil.warn("Erro localizando mensagem do Resource Bundle '" + resourceBundleVar + "', chave '" + chave + "'.");
            msgFormatada = chave;
        }

        adicionarMensagem(severity, msgFormatada);
    }

    /**
     *
     * M�todo respons�vel por limpar as mensagens.
     *
     * @throws Exception
     *
     */
    public void clearMensagens() {
        if (this.mensagens != null) {
            this.mensagens.clear();
        }
    }

    /**
     * Adiciona no JSF uma mensagem de sucesso.
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     *
     */
    public static void adicionaMensagemDeSucesso(String resourceBundleVar, String chave, String... argumentos) {
        adicionaMensagem(resourceBundleVar, MensagensUtil.MSG_TIPO_INFORMACAO, chave, argumentos);
    }

    /**
     * Adiciona no JSF uma mensagem informativa.
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     *
     */
    public static void adicionaMensagemInformativa(String resourceBundleVar, String chave, String... argumentos) {
        adicionaMensagem(resourceBundleVar, MensagensUtil.MSG_TIPO_INFORMACAO, chave, argumentos);
    }

    /**
     * Adiciona no JSF uma mensagem de alerta.
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     *
     */
    public static void adicionaMensagemDeAlerta(String resourceBundleVar, String chave, String... argumentos) {
        adicionaMensagem(resourceBundleVar, MensagensUtil.MSG_TIPO_AVISO, chave, argumentos);
    }

    /**
     * Adiciona no JSF uma mensagem de erro.
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     *
     */
    public static void adicionaMensagemDeErro(String resourceBundleVar, String chave, String... argumentos) {
        adicionaMensagem(resourceBundleVar, MensagensUtil.MSG_TIPO_ERRO, chave, argumentos);
    }

    /**
     * Adiciona no JSF uma mensagem de erro fatal (de sistema).
     *
     * @param resourceBundleVar
     *            o nome do resource bundle configurado
     * @param chave
     *            a chave da mensagem no resource bundle
     * @param argumentos
     *            os argumentos para formar a mensagem, se houver
     *
     */
    public static void adicionaMensagemDeErroDeSistema(String resourceBundleVar, String chave, String... argumentos) {
        adicionaMensagem(resourceBundleVar, MensagensUtil.MSG_TIPO_FATAL, chave, argumentos);
    }
}
