package br.ufg.inf.siscoe.reflexao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import br.ufg.inf.siscoe.comum.util.UtilArray;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;

public class GenericEngine extends EngineAbstrato {

    /**
     * Retorna a primeira classe generic do objeto em questão.
     *
     * @param <T>
     *            Tipo do objeto passado por parâmetro.
     * @param objeto
     *            Objeto passado por parâmetro.
     * @return Retorna o tipo de generics do objeto.
     */
    public <T extends Object> Class<?> getClasseDoTipo(T objeto) {
        Class<?> resultado = null;
        if (this.isReferencia(objeto)) {
            resultado = (Class<?>) this.getTipo(objeto, 0);
        }
        return resultado;
    }

    /**
     * Retorna as classes generics do objeto em questão.
     *
     * @param <T>
     *            Tipo do objeto passado por parâmetro.
     * @param objeto
     *            Objeto passado por parâmetro.
     * @return Retorna o array de tipos de generics do objeto.
     */
    public <T extends Object> Type[] getTipos(T objeto) {
        Type[] resultado = null;
        if (this.isReferencia(objeto)) {
            final ParameterizedType tipo = this.getParameterizedType(objeto);
            resultado = tipo.getActualTypeArguments();
        }
        return resultado;
    }

    /**
     * Retorna a classe generic do objeto em quest�o.
     *
     * @param <T>
     *            Tipo do objeto passado por par�metro.
     * @param objeto
     *            Objeto passado por par�metro.
     * @param indice
     *            �ndice do tipo do generic que deseja retornar.
     * @return Retorna o tipo de generics do objeto.
     */
    public <T extends Object> Type getTipo(T objeto, int indice) {
        Type resultado = null;
        if (this.isReferencia(objeto)) {
            final Type[] tipos = this.getTipos(objeto);
            resultado = UtilArray.getElementoDoIndice(tipos, indice);
        }
        return resultado;
    }

    /**
     * Retorna a primeira classe generic do objeto em questão.
     *
     * @param <T>
     *            Tipo do objeto passado por parâmetro.
     * @param objeto
     *            Objeto passado por parâmetro.
     * @return Retorna o tipo de generics do objeto.
     */
    public <T extends Object> Type getTipo(T objeto) {
        Type resultado = null;
        if (this.isReferencia(objeto)) {
            resultado = this.getTipo(objeto, 0);
        }
        return resultado;
    }

    /**
     * Retorna a parametrização do objeto.
     *
     * @param <T>
     *            Tipo do objeto passado por parâmetro.
     * @param objeto
     *            Objeto passado por parâmetro.
     * @return parametrização do objeto.
     */
    protected <T extends Object> ParameterizedType getParameterizedType(T objeto) {
        ParameterizedType resultado = null;

        if (this.isReferencia(objeto)) {
            final Class<T> classe = UtilObjeto.getClasse(objeto);
            resultado = (ParameterizedType) classe.getGenericSuperclass();
        }
        return resultado;
    }
}
