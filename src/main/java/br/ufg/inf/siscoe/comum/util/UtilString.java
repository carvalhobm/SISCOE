package br.ufg.inf.siscoe.comum.util;

public final class UtilString {

    /** Atributo VAZIO. */
    private static final String VAZIO = "";

    /**
     * Construtor.
     */
    private UtilString() {
    }

    /**
     * Retorna true se a string estiver vazia.
     *
     * @param string
     *            String
     * @return true se a string estiver vazia
     *
     */
    public static boolean isVazio(final String string) {
        return (!UtilObjeto.isReferencia(string) || string.trim().equals(UtilString.VAZIO));
    }

    /**
     * Retorna true se alguma string tiver vazia.
     *
     * @param string1
     *            String
     * @param string2
     *            String
     * @return true se alguma string tiver vazia.
     *
     */
    public static boolean isVazio(final String string1, final String string2) {
        return (UtilString.isVazio(string1) || UtilString.isVazio(string2));
    }

    /**
     * Retorna true se alguma string tiver vazia.
     *
     * @param string1
     *            String
     * @param string2
     *            String
     * @param string3
     *            String
     * @return true se alguma string tiver vazia.
     *
     */
    public static boolean isVazio(final String string1, final String string2, final String string3) {
        return (UtilString.isVazio(string1, string2) || UtilString.isVazio(string3));
    }

    /**
     * Retorna true se alguma string tiver vazia.
     *
     * @param strings
     *            Strings
     * @return true se alguma string tiver vazia.
     *
     */
    public static boolean isVazioTodos(final String... strings) {
        boolean res = true;

        if (UtilObjeto.isReferencia(strings)) {
            res = false;
            for (int idx = 0; idx < strings.length && (res == false); idx++) {
                res = UtilString.isVazio(strings[idx]);
            }
        }
        return res;
    }

    /**
     * Retorna true se as duas strings forem iguais (ignorando
     * maiúscula/minúscula).
     *
     * @param string0
     *            String validada
     * @param string1
     *            String validada
     * @return booleano
     *
     */
    public static boolean isStringsIguaisIgnoreCase(final String string0, final String string1) {
        boolean resultado = false;

        if (!UtilString.isVazio(string0, string1)) {
            resultado = string0.equalsIgnoreCase(string1);
        }
        return resultado;
    }
}