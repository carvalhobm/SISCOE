package br.ufg.inf.siscoe.reflexao;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.comum.util.UtilString;

/**
 * Classe que representa a engine da reflexão.
 */
public abstract class EngineAbstrato {

    /**
     * @param strings
     *            Strings que ser�o verificadas.
     * @return true se a string for vazia.
     * @see UtilString#isVazioTodos(String[])
     */
    protected boolean isVazio(String... strings) {
        return UtilString.isVazioTodos(strings);
    }

    /**
     * @param objetos
     *            Objetos que ser�o validados.
     * @return true se o objeto tiver refer�ncia.
     * @see UtilObjeto#isReferenciaTodos(Object[])
     */
    protected boolean isReferencia(Object... objetos) {
        return UtilObjeto.isReferenciaTodos(objetos);
    }

}