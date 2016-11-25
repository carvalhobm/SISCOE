package br.ufg.inf.siscoe.comum.util;

import java.io.Reader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * UtilObjeto.
 * </p>
 * <p>
 * Descrição: Classe utilitaria UtilObjeto.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class UtilObjeto {

    /**
     * Construtor.
     */
    private UtilObjeto() {
    }

    /**
     * Retorna a classe do objeto.
     *
     * @param <T>
     *            Tipo do objeto da classe.
     * @param objeto
     *            Objeto
     * @return Classe
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClasse(final T objeto) {
        Class<T> classe = null;

        if (UtilObjeto.isReferencia(objeto)) {
            if (UtilObjeto.isClasse(objeto)) {
                classe = (Class<T>) objeto;
            } else {
                classe = (Class<T>) objeto.getClass();
            }
        }
        return classe;
    }

    /**
     * Retorna o primeiro objeto com referência do array de objetos.
     *
     * @param <T>
     *            Tipo de objeto contido no array.
     * @param objetos
     *            Array de objetos.
     * @return primeiro objeto com referência do array de objetos.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getObjetoComReferencia(final T... objetos) {
        T resultado = null;
        if (UtilObjeto.isReferencia(objetos)) {
            for (int indice = 0; indice < objetos.length && !UtilObjeto.isReferencia(resultado); indice++) {
                resultado = objetos[indice];
            }
        }
        return resultado;
    }

    /**
     * Retorna true se o objeto é uma referência.
     *
     * @param objeto
     *            Objeto
     * @return true se o objeto é uma referência.
     */
    public static boolean isReferencia(final Object objeto) {
        return (objeto != null);
    }

    /**
     * Retorna true se o objeto é uma referência.
     *
     * @param objeto1
     *            Objeto
     * @param objeto2
     *            Objeto
     * @return true se o objeto é uma referência.
     */
    public static boolean isReferencia(final Object objeto1, final Object objeto2) {
        return (UtilObjeto.isReferencia(objeto1) && UtilObjeto.isReferencia(objeto2));
    }

    /**
     * Retorna true se o objeto é uma referência.
     *
     * @param objeto1
     *            Objeto
     * @param objeto2
     *            Objeto
     * @param objeto3
     *            Objeto
     * @return true se o objeto é uma referência.
     */
    public static boolean isReferencia(final Object objeto1, final Object objeto2, final Object objeto3) {
        return (UtilObjeto.isReferencia(objeto1, objeto2) && UtilObjeto.isReferencia(objeto3));
    }

    /**
     * <p>
     * Método responsável por verificar se o objeto informado não é nulo e caso
     * seja um numero, verifica se é maior que zero.
     * <p>
     *
     * @param numero
     *            valor a ser atribuido
     * @return boolean
     */
    public static boolean isReferenciaNumeroPositivo(final Object numero) {
        boolean numeroPositivo = true;

        if (!UtilObjeto.isReferencia(numero)) {
            numeroPositivo = false;
        }
        if (numeroPositivo && UtilObjeto.isBigDecimal(numero) && ((BigDecimal) numero).compareTo(BigDecimal.ZERO) == 0) {
            numeroPositivo = false;
        }
        if (numeroPositivo && UtilObjeto.isLong(numero) && ((Long) numero) == 0) {
            numeroPositivo = false;
        }
        if (numeroPositivo && UtilObjeto.isDouble(numero) && ((Double) numero) == 0) {
            numeroPositivo = false;
        }
        if (numeroPositivo && UtilObjeto.isFloat(numero) && ((Float) numero) == 0) {
            numeroPositivo = false;
        }
        if (numeroPositivo && UtilObjeto.isInteger(numero) && ((Integer) numero) == 0) {
            numeroPositivo = false;
        }

        return numeroPositivo;
    }

    /**
     * Retorna true se a coleção estiver vazia.
     *
     * @param colecao
     *            Collection
     * @return true se a coleção estiver vazia.
     */
    public static boolean isVazio(final Collection<?> colecao) {
        return (UtilObjeto.getTamanho(colecao) == 0);
    }

    /**
     * Retorna o tamanho da coleção.
     *
     * @param colecao
     *            Coleção
     * @return tamanho da coleção
     */
    public static int getTamanho(final Collection<?> colecao) {
        int resultado = 0;
        if (UtilObjeto.isReferencia(colecao)) {
            resultado = colecao.size();
        }
        return resultado;
    }

    /**
     * Retorna true se o objeto é uma referência.
     *
     * @param objetos
     *            Objetos
     * @return true se o objeto é uma referência.
     */
    public static boolean isReferenciaTodos(final Object... objetos) {
        boolean res = false;

        if (UtilObjeto.isReferencia(objetos)) {
            res = true;
            for (int idx = 0; idx < objetos.length && (res == true); idx++) {
                res = UtilObjeto.isReferencia(objetos[idx]);
            }
        }
        return res;
    }

    /**
     * Retorna true se o tipo for uma coleção.
     *
     * @param objeto
     *            objeto que será validado.
     * @return true se o tipo for uma coleção.
     */
    public static boolean isColecao(final Object objeto) {
        return (objeto instanceof Collection);
    }

    /**
     * Retorna true se o tipo for uma coleção.
     *
     * @param classe
     *            Classe que ser� validada.
     * @return true se o tipo for uma coleção.
     */
    public static boolean isColecao(final Class<?> classe) {
        final Class<?> colecao = Collection.class;
        return (UtilObjeto.isReferencia(classe) && colecao.isAssignableFrom(classe));
    }

    /**
     * Retorna true se o tipo for um Comparable.
     *
     * @param objeto
     *            Objeto que será validado.
     * @return true se o tipo for um Comparable.
     */
    public static boolean isComparable(final Object objeto) {
        return (objeto instanceof Comparable<?>);
    }

    /**
     * Retorna true se o tipo for um Comparable.
     *
     * @param classe
     *            Classe que será validada.
     * @return true se o tipo for um Comparable.
     */
    public static boolean isComparable(final Class<?> classe) {
        final Class<?> colecao = Comparable.class;
        return (UtilObjeto.isReferencia(classe) && colecao.isAssignableFrom(classe));
    }

    /**
     * Retorna true se o tipo for um mapa.
     *
     * @param objeto
     *            objeto que será validado.
     * @return true se o tipo for um mapa.
     */
    public static boolean isMapa(final Object objeto) {
        return (objeto instanceof Map);
    }

    /**
     * Retorna true se o tipo for um mapa.
     *
     * @param classe
     *            Classe que será validada.
     * @return true se o tipo for um mapa.
     */
    public static boolean isMapa(final Class<?> classe) {
        final Class<?> mapa = Map.class;
        return (UtilObjeto.isReferencia(classe) && mapa.isAssignableFrom(classe));
    }

    /**
     * Retorna true se o objeto for uma classe.
     *
     * @param objeto
     *            Objeto validado.
     * @return true se o objeto for uma classe.
     */
    public static boolean isClasse(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Class));
    }

    /**
     * Retorna true se o objeto for um integer.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um integer
     */
    public static boolean isInteger(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Integer));
    }

    /**
     * Retorna true se o objeto for um long.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um long
     */
    public static boolean isLong(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Long));
    }

    /**
     * Retorna true se o objeto for um Boolean.
     *
     * @param objeto
     *            Objeto validados
     * @return true se o objeto for um Boolean
     */
    public static boolean isBoolean(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Boolean));
    }

    /**
     * Retorna true se o objeto for um Byte.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Byte
     */
    public static boolean isByte(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Byte));
    }

    /**
     * Retorna true se o objeto for um Short.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Short
     */
    public static boolean isShort(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Short));
    }

    /**
     * Retorna true se o objeto for um Character.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Character
     */
    public static boolean isCharacter(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Character));
    }

    /**
     * Retorna true se o objeto for um Float.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Float
     */
    public static boolean isFloat(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Float));
    }

    /**
     * Retorna true se o objeto for um Double.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Double
     */
    public static boolean isDouble(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Double));
    }

    /**
     * Retorna true se o objeto for um String.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um String
     */
    public static boolean isString(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof String));
    }

    /**
     * Retorna true se o objeto for um Date.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Date
     */
    public static boolean isDate(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Date));
    }

    /**
     * Retorna true se o objeto for um java.sql.Date.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um java.sql.Date
     */
    public static boolean isSqlDate(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof java.sql.Date));
    }

    /**
     * Retorna true se o objeto for um Time.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Time
     */
    public static boolean isTime(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Time));
    }

    /**
     * Retorna true se o objeto for um Timestamp.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Timestamp
     */
    public static boolean isTimestamp(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Timestamp));
    }

    /**
     * Retorna true se o objeto for um Reader.
     *
     * @param objeto
     *            Objeto validado
     * @return true se o objeto for um Reader
     */
    public static boolean isReader(final Object objeto) {
        return (UtilObjeto.isReferencia(objeto) && (objeto instanceof Reader));
    }

    /**
     * Retorna true se o objeto for um big decimal
     *
     * @param objeto
     *            Objeto validado.
     * @return true se o objeto for um big decimal
     */
    public static boolean isBigDecimal(final Object objeto) {
        return (objeto instanceof BigDecimal);
    }

    /**
     * Retorna true se o objeto for do tipo informado.
     *
     * @param objeto
     *            Objeto validado.
     * @param tipo
     *            Tipo desejado
     * @return true se o objeto for do tipo informado.
     */
    public static boolean isObjetoDoTipo(final Object objeto, final Class<?> tipo) {
        boolean res = false;

        if (UtilObjeto.isReferencia(objeto, tipo)) {
            final Class<?> classe = UtilObjeto.getClasse(objeto);
            res = tipo.isAssignableFrom(classe);
        }
        return res;
    }

    /**
     * Esse método usa generics e reflection para clonar um objeto. OBS: não
     * clona um objeto dentro de outro objeto, para isso deve chamar o método
     * para cada objeto filho.
     *
     * @param objeto
     *            valor a ser atribuido
     * @return clone do objeto
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T clone(final T objeto) {
        if (UtilObjeto.isReferencia(objeto)) {
            T clone = null;

            try {
                // instanciando o objeto clone de acordo com o objeto passado
                // por parâmetro
                clone = (T) objeto.getClass().newInstance();
            } catch (final InstantiationException e) {
                e.printStackTrace();
            } catch (final IllegalAccessException e) {
                e.printStackTrace();
            }

            // Obter o tipo de classe atual, quando acabar, passar para a super
            // classe, até chegar em Object.
            for (Class obj = objeto.getClass(); !obj.equals(Object.class); obj = obj.getSuperclass()) {
                // Percorrer campo por campo da classe...
                for (final Field field : obj.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        // Copiar campo atual
                        field.set(clone, field.get(objeto));
                    } catch (final Throwable t) {
                        LogUtil.error(t.getMessage());
                    }
                }
            }
            return clone;
        }
        return null;
    }
}
