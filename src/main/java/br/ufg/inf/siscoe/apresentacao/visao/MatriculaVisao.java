package br.ufg.inf.siscoe.apresentacao.visao;

import java.util.Arrays;
import java.util.Collection;

import br.ufg.inf.siscoe.comum.enums.CargaHorariaEnum;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;

/**
 * <p>
 * MatriculaVisao.
 * </p>
 * <p>
 * Descrição: Visao para entidade Disciplina na tela de matricula.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class MatriculaVisao extends ManutencaoVisao<Disciplina> {

    private static final long serialVersionUID = 5667233021237886929L;

    private Disciplina filtro;

    private Collection<Disciplina> listaDisciplina;
    private Collection<CargaHorariaEnum> listaHoraria;

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
     * @return the listaDisciplina
     */
    public Collection<Disciplina> getListaDisciplina() {
        return this.listaDisciplina;
    }

    /**
     * Get/Set.
     *
     * @param listaDisciplina
     *            the listaDisciplina to set
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

}
