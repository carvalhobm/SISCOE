package br.ufg.inf.siscoe.apresentacao.visao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import br.ufg.inf.siscoe.comum.enums.CargaHorariaEnum;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;

/**
 * Get/Set.
 * <p>
 * DisciplinaVisao.
 * </p>
 * <p>
 * Descrição: Visao para entidade {@link Disciplina}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class DisciplinaVisao extends ManutencaoVisao<Disciplina> {

    private static final long serialVersionUID = 6573853182097920066L;

    private Disciplina filtro;

    private Avaliacao avaliacao;

    private UsuarioDisciplina usuarioDisciplina;

    private Collection<Disciplina> listaDisciplina;

    private Collection<CargaHorariaEnum> listaHoraria;

    private Collection<Avaliacao> listaAvaliacaoSimulacao;

    private Collection<Avaliacao> listaAvaliacaoRemover;

    private Double resultadoSimulacao;

    private boolean edicao;
    private boolean detalhe;

    /**
     * Get/Set.
     *
     * @return the filtro
     */
    public Disciplina getFiltro() {
        return this.filtro;
    }

    /**
     * Get/Set.
     *
     * @param filtro
     *            the filtro to set
     */
    public void setFiltro(Disciplina filtro) {
        this.filtro = filtro;
    }

    /**
     * Get/Set.
     *
     * @return the listaDiscplina
     */
    public Collection<Disciplina> getListaDisciplina() {
        return this.listaDisciplina;
    }

    /**
     * Get/Set.
     *
     * @param listaDisciplina
     *            the listaDiscplina to set
     */
    public void setListaDisciplina(Collection<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }

    /**
     * Get/Set.
     *
     * @return the listaHoraria
     */
    public Collection<CargaHorariaEnum> getListaHoraria() {
        if (!UtilObjeto.isReferencia(this.listaHoraria)) {
            this.listaHoraria = Arrays.asList(CargaHorariaEnum.values());
        }
        return this.listaHoraria;
    }

    /**
     * Get/Set.
     *
     * @param listaHoraria
     *            the listaHoraria to set
     */
    public void setListaHoraria(Collection<CargaHorariaEnum> listaHoraria) {
        this.listaHoraria = listaHoraria;
    }

    /**
     * Get/Set.
     *
     * @return the edicao
     */
    public boolean isEdicao() {
        return this.edicao;
    }

    /**
     * Get/Set.
     *
     * @param edicao
     *            the edicao to set
     */
    public void setEdicao(boolean edicao) {
        this.edicao = edicao;
    }

    /**
     * Get/Set.
     *
     * @return the detalhe
     */
    public boolean isDetalhe() {
        return this.detalhe;
    }

    /**
     * Get/Set.
     *
     * @param detalhe
     *            the detalhe to set
     */
    public void setDetalhe(boolean detalhe) {
        this.detalhe = detalhe;
    }

    /**
     * Get/Set.
     *
     * @return the avaliacao
     */
    public Avaliacao getAvaliacao() {
        if (!UtilObjeto.isReferencia(this.avaliacao)) {
            this.avaliacao = new Avaliacao();
        }
        return this.avaliacao;
    }

    /**
     * Get/Set.
     *
     * @param avaliacao
     *            the avaliacao to set
     */
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * Get/Set.
     *
     * @return the listaAvaliacaoSimulacao
     */
    public Collection<Avaliacao> getListaAvaliacaoSimulacao() {
        if (!UtilObjeto.isReferencia(this.listaAvaliacaoSimulacao)) {
            this.listaAvaliacaoSimulacao = new ArrayList<Avaliacao>();
        }
        return this.listaAvaliacaoSimulacao;
    }

    /**
     * Get/Set.
     *
     * @param listaAvaliacaoSimulacao
     *            the listaAvaliacaoSimulacao to set
     */
    public void setListaAvaliacaoSimulacao(Collection<Avaliacao> listaAvaliacaoSimulacao) {
        this.listaAvaliacaoSimulacao = listaAvaliacaoSimulacao;
    }

    /**
     * Get/Set.
     *
     * @return the resultadoSimulacao
     */
    public Double getResultadoSimulacao() {
        return this.resultadoSimulacao;
    }

    /**
     * Get/Set.
     *
     * @param resultadoSimulacao
     *            the resultadoSimulacao to set
     */
    public void setResultadoSimulacao(Double resultadoSimulacao) {
        this.resultadoSimulacao = resultadoSimulacao;
    }

    /**
     * Get/Set.
     *
     * @return the usuarioDisciplina
     */
    public UsuarioDisciplina getUsuarioDisciplina() {
        return this.usuarioDisciplina;
    }

    /**
     * Get/Set.
     *
     * @param usuarioDisciplina
     *            the usuarioDisciplina to set
     */
    public void setUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina) {
        this.usuarioDisciplina = usuarioDisciplina;
    }

    /**
     * Retorna o valor do listaAvaliacaoRemover.
     *
     * @return the listaAvaliacaoRemover
     */
    public Collection<Avaliacao> getListaAvaliacaoRemover() {
        if (!UtilObjeto.isReferencia(this.listaAvaliacaoRemover)) {
            this.listaAvaliacaoRemover = new ArrayList<Avaliacao>();
        }
        return this.listaAvaliacaoRemover;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaAvaliacaoRemover
     *            the listaAvaliacaoRemover to set
     */
    public void setListaAvaliacaoRemover(Collection<Avaliacao> listaAvaliacaoRemover) {
        this.listaAvaliacaoRemover = listaAvaliacaoRemover;
    }

}
