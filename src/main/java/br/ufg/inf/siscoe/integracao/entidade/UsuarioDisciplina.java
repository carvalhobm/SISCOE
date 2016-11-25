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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>
 * UsuarioDiscplina.
 * </p>
 * <p>
 * Descrição: Entidade UsuarioDisciplina
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Entity(name = "tb_usuario_disciplina")
public class UsuarioDisciplina extends Entidade {

    private static final long serialVersionUID = 7201754778545066400L;

    @Id
    @Column(name = "nu_usuario_disciplina")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nuUsuarioDisciplina;

    @ManyToOne
    @JoinColumn(name = "nu_disciplina")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "nu_usuario")
    private Usuario usuario;

    @Column(name = "qt_faltas")
    private Integer qtFaltas;

    @Column(name = "vr_media_final")
    private Double vrMediaFinal;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuarioDisciplina", targetEntity = AvaliacaoUsuario.class, cascade = CascadeType.ALL)
    private Collection<AvaliacaoUsuario> listaAvaliacaoUsuario;

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getIdentificador()
     */
    @Override
    public Serializable getIdentificador() {
        return this.nuUsuarioDisciplina;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getChavePrimaria()
     */
    @Override
    public String getChavePrimaria() {
        return "nuUsuarioDisciplina";
    }

    /**
     * Retorna o valor do nuUsuarioDisciplina.
     *
     * @return the nuUsuarioDisciplina
     */
    public Integer getNuUsuarioDisciplina() {
        return this.nuUsuarioDisciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param nuUsuarioDisciplina
     *            the nuUsuarioDisciplina to set
     */
    public void setNuUsuarioDisciplina(Integer nuUsuarioDisciplina) {
        this.nuUsuarioDisciplina = nuUsuarioDisciplina;
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
     * Retorna o valor do usuario.
     *
     * @return the usuario
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param usuario
     *            the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna o valor do qtFaltas.
     *
     * @return the qtFaltas
     */
    public Integer getQtFaltas() {
        return this.qtFaltas;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param qtFaltas
     *            the qtFaltas to set
     */
    public void setQtFaltas(Integer qtFaltas) {
        this.qtFaltas = qtFaltas;
    }

    /**
     * Retorna o valor do vrMediaFinal.
     *
     * @return the vrMediaFinal
     */
    public Double getVrMediaFinal() {
        return this.vrMediaFinal;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param vrMediaFinal
     *            the vrMediaFinal to set
     */
    public void setVrMediaFinal(Double vrMediaFinal) {
        this.vrMediaFinal = vrMediaFinal;
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

}
