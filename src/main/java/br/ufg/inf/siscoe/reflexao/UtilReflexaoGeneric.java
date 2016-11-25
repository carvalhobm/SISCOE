package br.ufg.inf.siscoe.reflexao;

/**
 * Classe responsável pela manipulação de generics de classe ou método.
 */
public class UtilReflexaoGeneric extends UtilReflexaoAbstrato {

    private static GenericEngine genericEngine;

    /**
     * Retorna a primeira classe generic do objeto em questão.
     *
     * @param <T>
     *            Tipo do objeto passado por parâmetro.
     * @param objeto
     *            Objeto passado por parâmetro.
     * @return Retorna o tipo de generics do objeto.
     */
    public static <T extends Object> Class<?> getClasseDoTipo(T objeto) {
        return getGenericEngine().getClasseDoTipo(objeto);
    }

    /**
     *  Get.
     * @return genericEngine
     */
    private static GenericEngine getGenericEngine() {
        if (!isReferencia(genericEngine)) {
            genericEngine = new GenericEngine();
        }
        return genericEngine;
    }
}
