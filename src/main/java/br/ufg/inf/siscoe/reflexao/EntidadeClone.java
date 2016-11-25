package br.ufg.inf.siscoe.reflexao;

import java.lang.reflect.Field;

/**
 * <p>
 * EntidadeClone.
 * </p>
 * <p>
 * Descrição: Classe EntidadeClone.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class EntidadeClone {

    /**
     *
     * Metodo responsável por copiar os atributos de um Objeto A para um Objeto
     * B por reflexão.
     *
     * @param objetoDestino
     *            valor a ser atribuido
     * @param objetoOrigem
     *            valor a ser atribuido
     * @throws IllegalArgumentException
     *             excecao
     * @throws IllegalAccessException
     *             excecao
     * @author Bruno Martins de Carvalho
     */
    public static void copiarAtributosDePara(Object objetoDestino, Object objetoOrigem) throws IllegalArgumentException, IllegalAccessException {

        final Field[] camposPrimeiraClasse = objetoDestino.getClass().getDeclaredFields();
        final Field[] camposSegundaClasse = objetoOrigem.getClass().getDeclaredFields();

        for (final Field campoCorrentePrimeiraClasse : camposPrimeiraClasse) {
            for (final Field campoCorrenteSegundaClasse : camposSegundaClasse) {
                final String nomePrimeiroCampo = campoCorrentePrimeiraClasse.getName();
                final String nomeSegundoCampo = campoCorrenteSegundaClasse.getName();

                if (nomePrimeiroCampo.equals(nomeSegundoCampo)) {
                    campoCorrentePrimeiraClasse.setAccessible(true);
                    campoCorrenteSegundaClasse.setAccessible(true);

                    campoCorrentePrimeiraClasse.set(objetoDestino, campoCorrenteSegundaClasse.get(objetoOrigem));
                }
            }
        }
    }
}
