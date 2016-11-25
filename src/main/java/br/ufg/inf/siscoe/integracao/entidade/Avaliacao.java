package br.ufg.inf.siscoe.integracao.entidade;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>
 * Avaliacao.
 * </p>
 * <p>
 * Descrição: Entidade Avaliacao
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Entity(name = "tb_avaliacao")
public class Avaliacao extends Entidade {

    @Id
    @Column(name = "nu_avaliacao")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nuAvaliacao;

    @Column(name = "no_avaliacao")
    private String noAvaliacao;

    @Column(name = "de_avaliacao")
    private String deAvaliacao;

    @ManyToOne
    @JoinColumn(name = "nu_disciplina")
    private Disciplina disciplina;

    @Column(name = "ic_ativo")
    private boolean icAtivo;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "avaliacao", targetEntity = AvaliacaoUsuario.class, cascade = CascadeType.ALL)
    private Collection<AvaliacaoUsuario> listaAvaliacaoUsuario;

    @Transient
    private Double vrAvaliacao;

    /**
     * Atributo serialVersionUID.
     */
    private static final long serialVersionUID = -1571615742571130092L;

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getIdentificador()
     */
    @Override
    public Serializable getIdentificador() {
        return this.nuAvaliacao;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getChavePrimaria()
     */
    @Override
    public String getChavePrimaria() {
        return this.nuAvaliacao.toString();
    }

    /**
     * Retorna o valor do nuAvaliacao.
     *
     * @return the nuAvaliacao
     */
    public Integer getNuAvaliacao() {
        return this.nuAvaliacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param nuAvaliacao
     *            the nuAvaliacao to set
     */
    public void setNuAvaliacao(Integer nuAvaliacao) {
        this.nuAvaliacao = nuAvaliacao;
    }

    /**
     * Retorna o valor do noAvaliacao.
     *
     * @return the noAvaliacao
     */
    public String getNoAvaliacao() {
        return this.noAvaliacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param noAvaliacao
     *            the noAvaliacao to set
     */
    public void setNoAvaliacao(String noAvaliacao) {
        this.noAvaliacao = noAvaliacao;
    }

    /**
     * Retorna o valor do deAvaliacao.
     *
     * @return the deAvaliacao
     */
    public String getDeAvaliacao() {
        return this.deAvaliacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param deAvaliacao
     *            the deAvaliacao to set
     */
    public void setDeAvaliacao(String deAvaliacao) {
        this.deAvaliacao = deAvaliacao;
    }

    /**
     * Retorna o valor do disciplina.
     *
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param disciplina
     *            the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Retorna o valor do icAtivo.
     *
     * @return the icAtivo
     */
    public boolean isIcAtivo() {
        return this.icAtivo;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param icAtivo
     *            the icAtivo to set
     */
    public void setIcAtivo(boolean icAtivo) {
        this.icAtivo = icAtivo;
    }

    /**
     * Retorna o valor do listaAvaliacaoUsuario.
     *
     * @return the listaAvaliacaoUsuario
     */
    public Collection<AvaliacaoUsuario> getListaAvaliacaoUsuario() {
        return this.listaAvaliacaoUsuario;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaAvaliacaoUsuario
     *            the listaAvaliacaoUsuario to set
     */
    public void setListaAvaliacaoUsuario(Collection<AvaliacaoUsuario> listaAvaliacaoUsuario) {
        this.listaAvaliacaoUsuario = listaAvaliacaoUsuario;
    }

    /**
     * Retorna o valor do vrAvaliacao.
     *
     * @return the vrAvaliacao
     */
    public Double getVrAvaliacao() {
        return this.vrAvaliacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param vrAvaliacao
     *            the vrAvaliacao to set
     */
    public void setVrAvaliacao(Double vrAvaliacao) {
        this.vrAvaliacao = vrAvaliacao;
    }

}
