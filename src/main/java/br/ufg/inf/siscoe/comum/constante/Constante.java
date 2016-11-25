package br.ufg.inf.siscoe.comum.constante;

import java.util.Locale;

public final class Constante {

    /**
     * Construtor.
     */
    private Constante() {
    }

    /**
     * Retorna Locale pt-BR.
     *
     * @return Locale pt-BR
     */
    public static Locale getLocaleBrasil() {
        return new Locale("pt", "BR");
    }

    /**
     * Retorna prefixo de string que representa um array. <br>
     * Ex: java.lang.String[]
     *
     * @return []
     */
    public static String getSufixoArray() {
        return "[]";
    }

}