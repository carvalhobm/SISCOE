package br.ufg.inf.siscoe.comum.to;

import java.util.Arrays;

public class MensagemTO {

    // Chave da mensagem que ser� mostrada para usu�rio ou chave da mensagem do
    // arquivo properties
    private String chaveMensagem;
    // Argumentos da mensagem, podendo ser o valor direto ou chave de um arquivo
    // properties
    private String[] argumentos;
    // Atributo que recebe o foco.
    private String atributoFoco;
    // ID do elemento HTML na tela para o qual � direcionada a mensagem
    private String idElementoHTML;
    // valida��o serviu para verificar campo obrigat�rio?
    private boolean campoObrigatorio;

    /**
     * Cria a exce��o somente com mensagem.
     *
     * @param chaveMensagem
     *            - Id da mensagem.
     */
    public MensagemTO(final String chaveMensagem) {
        this.chaveMensagem = chaveMensagem;
    }

    /**
     * Cria a exce��o para uma mensagem e adiciona os argumentos de argumento na
     * mensagem
     *
     * @param chaveMensagem
     *            - Define qual o id da mensagem que ser� apresentada.
     * @param argumentos
     *            - Define o nome dos argumentos que receber�o a mensagem.
     */
    public MensagemTO(final String chaveMensagem, final String... argumentos) {
        this(chaveMensagem);
        this.argumentos = argumentos;
    }

    /**
     * Retornar o id da mensagem a ser apresentada.
     *
     * @return Descri��o de identifica��o da mensagem a ser apresentada
     */
    public String getChaveMensagem() {
        return this.chaveMensagem;
    }

    /**
     * Define o id da mensagem.
     *
     * @param chaveMensagem
     *            descri��o da identifica��o da mensagem
     */
    public void setChaveMensagem(final String chaveMensagem) {
        this.chaveMensagem = chaveMensagem;
    }

    /**
     * Retorna os argumentos que ser�o validados.
     *
     * @return os argumentos que ser�o validados
     */
    public String[] getArgumentos() {
        return this.argumentos;
    }

    /**
     * Retorna os argumentos de mensagem.
     *
     * @param argumentos
     *            Descri��o dos argumentos da mensagem
     */
    public void setArgumentos(final String[] argumentos) {
        this.argumentos = argumentos;
    }

    /**
     * Retorna o atributo que recebe o foco.
     *
     * @return atributo
     */
    public String getAtributoFoco() {
        return this.atributoFoco;
    }

    /**
     * Atribui o atributo que recebe o foco.
     *
     * @param atributoFoco
     *            valor a ser atribuido
     */
    public void setAtributoFoco(final String atributoFoco) {
        this.atributoFoco = atributoFoco;
    }

    /**
     * Retorna o valor do atributo idElementoHTML.
     *
     * @return idElementoHTML
     */
    public String getIdElementoHTML() {
        return this.idElementoHTML;
    }

    /**
     * Define o valor do atributo idElementoHTML.
     *
     * @param idElementoHTML
     *            valor a ser atribu�do
     */
    public void setIdElementoHTML(String idElementoHTML) {
        this.idElementoHTML = idElementoHTML;
    }

    /**
     * Retorna o valor do atributo campoObrigatorio.
     *
     * @return campoObrigatorio
     */
    public boolean isCampoObrigatorio() {
        return this.campoObrigatorio;
    }

    /**
     * Define o valor do atributo campoObrigatorio.
     *
     * @param campoObrigatorio
     *            valor a ser atribu�do
     */
    public void setCampoObrigatorio(boolean campoObrigatorio) {
        this.campoObrigatorio = campoObrigatorio;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.argumentos);
        result = prime * result + ((this.atributoFoco == null) ? 0 : this.atributoFoco.hashCode());
        result = prime * result + (this.campoObrigatorio ? 1231 : 1237);
        result = prime * result + ((this.chaveMensagem == null) ? 0 : this.chaveMensagem.hashCode());
        result = prime * result + ((this.idElementoHTML == null) ? 0 : this.idElementoHTML.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final MensagemTO other = (MensagemTO) obj;
        if (!Arrays.equals(this.argumentos, other.argumentos)) {
            return false;
        }
        if (this.atributoFoco == null) {
            if (other.atributoFoco != null) {
                return false;
            }
        } else if (!this.atributoFoco.equals(other.atributoFoco)) {
            return false;
        }
        if (this.campoObrigatorio != other.campoObrigatorio) {
            return false;
        }
        if (this.chaveMensagem == null) {
            if (other.chaveMensagem != null) {
                return false;
            }
        } else if (!this.chaveMensagem.equals(other.chaveMensagem)) {
            return false;
        }
        if (this.idElementoHTML == null) {
            if (other.idElementoHTML != null) {
                return false;
            }
        } else if (!this.idElementoHTML.equals(other.idElementoHTML)) {
            return false;
        }
        return true;
    }
}
