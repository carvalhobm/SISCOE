package br.ufg.inf.siscoe.comum.util;

import br.ufg.inf.siscoe.comum.constante.Constante;

/**
 * <p>
 * UtilArray.
 * </p>
 * <p>
 * Descrição: Classe utilitária para arrays.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public final class UtilArray {

    /**
     * Construtor.
     */
    private UtilArray() {
    }

    /**
     * Retorna true se o tipo do objeto for um array.
     *
     * @param tipo
     *            tipo do objeto.
     * @return true se o tipo do objeto for um array.
     */
    public static boolean isArray(Object tipo) {
        boolean res = false;

        if (UtilObjeto.isReferencia(tipo)) {
            final Class<?> classe = UtilObjeto.getClasse(tipo);
            res = classe.isArray();
        }
        return res;
    }

    /**
     * Retorna a string representativa do array. Exemplo: se for enviado
     * java.lang.Integer será retornado java.lang.Integer[].
     *
     * @param tipo
     *            Tipo do array.
     * @return String representativa de array.
     */
    public static String getString(Class<?> tipo) {
        String res = null;

        if (isArray(tipo)) {
            tipo = getTipoDoArray(tipo);
            res = tipo.getName();
            res += Constante.getSufixoArray();
        }

        return res;
    }

    /**
     * Retorna true se o array estiver vazio.
     *
     * @param array
     *            Array validado
     * @return true se o array estiver vazio.
     */
    public static boolean isVazio(Object[] array) {
        return (UtilObjeto.isReferencia(array) && array.length == 0);
    }

    /**
     * Retorna o tipo do array. Ex: se o tipo for java.lang.Integer[] será
     * retornado java.lang.Integer.
     *
     * @param tipo
     *            Array
     * @return tipo do array
     *
     */
    public static Class<?> getTipoDoArray(Class<?> tipo) {
        Class<?> res = null;

        if (UtilObjeto.isReferencia(tipo)) {
            res = tipo.getComponentType();
            while (isArray(res)) {
                res = res.getComponentType();
            }
        }

        return res;
    }

    /**
     * Retorna o elemento do índice solicitado.
     *
     * @param <T>
     *            Tipo do objeto contido no array.
     * @param array
     *            Array
     * @param indice
     *            índice
     * @return elemento do índice solicitado.
     *
     */
    public static <T> T getElementoDoIndice(T[] array, int indice) {
        T resultado = null;

        if (!isVazio(array) && indice >= 0 && indice < array.length) {
            resultado = array[indice];
        }
        return resultado;
    }

    /**
     * Retorna o Tamanho do array.
     *
     * @param <T>
     *            Tipo do objeto que comp�e o array.
     * @param array
     *            Array
     * @return Tamanho do array.
     *
     */
    public static <T> int getTamanho(T[] array) {
        return (UtilObjeto.isReferencia(array) ? array.length : 0);
    }

    /**
     * Retorna true se o tipo do array for um byte.
     *
     * @param array
     *            Array validado
     * @return true se o tipo do array for um byte.
     *
     */
    public static boolean isTipoArrayByte(Object array) {
        boolean res = false;

        if (isArray(array)) {
            Class<?> tipo = UtilObjeto.getClasse(array);
            tipo = getTipoDoArray(tipo);
            res = (tipo.isAssignableFrom(Byte.class) || tipo.isAssignableFrom(byte.class));
        }
        return res;
    }
}