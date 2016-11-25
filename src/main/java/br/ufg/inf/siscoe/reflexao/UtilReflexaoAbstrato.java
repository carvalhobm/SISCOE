package br.ufg.inf.siscoe.reflexao;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.comum.util.UtilString;

/**
 * Classe abstrata que prova recursos aos utilitários da reflexão.
 */
public abstract class UtilReflexaoAbstrato {

    /**
     * @param strings
     *            Strings que serão verificadas.
     * @return true se a string for vazia.
     * @see UtilString#isVazioTodos(String[])
     */
    protected static boolean isVazio(String... strings) {
        return UtilString.isVazioTodos(strings);
    }

    /**
     * @param objetos
     *            Objetos que serão validados.
     * @return true se o objeto tiver refer�ncia.
     * @see UtilObjeto#isReferenciaTodos(Object[])
     */
    protected static boolean isReferencia(Object... objetos) {
        return UtilObjeto.isReferenciaTodos(objetos);
    }
}
