package br.ufg.inf.siscoe.comum.calculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.cheffo.jeplite.JEP;
import org.cheffo.jeplite.ParseException;

import br.ufg.inf.siscoe.comum.util.LogUtil;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;
import br.ufg.inf.siscoe.integracao.entidade.AvaliacaoUsuario;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;

/**
 * <p>
 * AvaliadorExpressao.
 * </p>
 * <p>
 * Descrição: Classe responsável por realizar os cálculos.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class AvaliadorExpressao {

    /**
     *
     * Método responsável por localizar as variaveis existentes na formula.
     *
     * @param formula
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    public List<String> localizarVariaveis(final String formula) {

        final List<String> listaVariaveis = new ArrayList<String>();

        for (final String variavel : Arrays.asList(formula.replace("(", "").replace(")", "").split("([*/+-])"))) {
            if (!NumberUtils.isNumber(variavel)) {
                listaVariaveis.add(variavel);
            }
        }

        return listaVariaveis;
    }

    /**
     *
     * Método responsável por simular o calculo de uma formula.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @param formula
     *            String
     * @return Double
     * @author Bruno Martins de Carvalho
     */
    public Double simularFormula(final UsuarioDisciplina usuarioDisciplina, final String formula) {

        final JEP jep = new JEP();

        Double resultado = Double.valueOf(0);

        for (final AvaliacaoUsuario avaliacao : usuarioDisciplina.getListaAvaliacaoUsuario()) {
            Double vrAvaliacao = Double.valueOf(0);

            if (UtilObjeto.isReferencia(avaliacao.getVrAvaliacao())) {
                vrAvaliacao = avaliacao.getVrAvaliacao();
            }
            jep.addVariable(avaliacao.getAvaliacao().getNoAvaliacao().toUpperCase(), vrAvaliacao);
        }

        jep.parseExpression(formula.toUpperCase());

        try {
            resultado = jep.getValue();
        } catch (final ParseException e) {
            LogUtil.error(e.getMessage());
        }

        return resultado;
    }

    /**
     *
     * Método responsável por simular o calculo de uma formula.
     *
     * @param listaAvaliacao
     *            valor a ser atribuido
     * @param formula
     *            valor a ser atribuido
     * @return Double.
     * @author Bruno Martins de Carvalho
     */
    public Double simularFormula(final Collection<Avaliacao> listaAvaliacao, final String formula) {

        final JEP jep = new JEP();

        Double resultado = Double.valueOf(0);

        for (final Avaliacao avaliacao : listaAvaliacao) {
            jep.addVariable(avaliacao.getNoAvaliacao(), avaliacao.getVrAvaliacao());
        }

        jep.parseExpression(formula);

        try {
            resultado = jep.getValue();
        } catch (final ParseException e) {
            LogUtil.error(e.getMessage());
        }

        return resultado;
    }

    /**
     *
     * Método responsável por simular o calculo de uma formula.
     *
     * @param disciplina
     *            valor a ser atribuido
     * @return Double.
     * @author Bruno Martins de Carvalho
     */
    public Double simularFormula(final Disciplina disciplina) {

        final JEP jep = new JEP();

        Double resultado = Double.valueOf(0);

        for (final Avaliacao avaliacao : disciplina.getListaAvaliacao()) {
            jep.addVariable(avaliacao.getNoAvaliacao(), avaliacao.getVrAvaliacao());
        }

        jep.parseExpression(disciplina.getFmMediaFinal());

        try {
            resultado = jep.getValue();
        } catch (final ParseException e) {
            LogUtil.error(e.getMessage());
        }

        return resultado;
    }

}
