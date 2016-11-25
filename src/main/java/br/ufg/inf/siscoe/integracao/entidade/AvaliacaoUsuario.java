package br.ufg.inf.siscoe.integracao.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * <p>
 * AvaliacaoUsuario.
 * </p>
 * <p>
 * Descrição: Entidade AvaliacaoUsuario.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Entity(name = "tb_avaliacao_usuario")
public class AvaliacaoUsuario extends Entidade {

    private static final long serialVersionUID = -1053899523503424665L;

    @Id
    @Column(name = "nu_avaliacao_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nuAvaliacaoUsuario;

    @ManyToOne
    @JoinColumn(name = "nu_usuario_disciplina")
    private UsuarioDisciplina usuarioDisciplina;

    @ManyToOne
    @JoinColumn(name = "nu_avaliacao")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "nu_disciplina")
    private Disciplina disciplina;

    @Column(name = "vr_avaliacao")
    private Double vrAvaliacao;

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getIdentificador()
     */
    @Override
    public Serializable getIdentificador() {
        return this.nuAvaliacaoUsuario;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getChavePrimaria()
     */
    @Override
    public String getChavePrimaria() {
        return this.nuAvaliacaoUsuario.toString();
    }

    /**
     * Retorna o valor do nuAvaliacaoUsuario.
     *
     * @return the nuAvaliacaoUsuario
     */
    public Integer getNuAvaliacaoUsuario() {
        return this.nuAvaliacaoUsuario;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param nuAvaliacaoUsuario
     *            the nuAvaliacaoUsuario to set
     */
    public void setNuAvaliacaoUsuario(Integer nuAvaliacaoUsuario) {
        this.nuAvaliacaoUsuario = nuAvaliacaoUsuario;
    }

    /**
     * Retorna o valor do usuarioDisciplina.
     *
     * @return the usuarioDisciplina
     */
    public UsuarioDisciplina getUsuarioDisciplina() {
        return this.usuarioDisciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param usuarioDisciplina
     *            the usuarioDisciplina to set
     */
    public void setUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina) {
        this.usuarioDisciplina = usuarioDisciplina;
    }

    /**
     * Retorna o valor do avaliacao.
     *
     * @return the avaliacao
     */
    public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param avaliacao
     *            the avaliacao to set
     */
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
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

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.avaliacao == null) ? 0 : this.avaliacao.hashCode());
        result = prime * result + ((this.disciplina == null) ? 0 : this.disciplina.hashCode());
        result = prime * result + ((this.usuarioDisciplina == null) ? 0 : this.usuarioDisciplina.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final AvaliacaoUsuario other = (AvaliacaoUsuario) obj;
        if (this.avaliacao == null) {
            if (other.avaliacao != null) {
                return false;
            }
        } else if (!this.avaliacao.equals(other.avaliacao)) {
            return false;
        }
        if (this.disciplina == null) {
            if (other.disciplina != null) {
                return false;
            }
        } else if (!this.disciplina.equals(other.disciplina)) {
            return false;
        }
        if (this.usuarioDisciplina == null) {
            if (other.usuarioDisciplina != null) {
                return false;
            }
        } else if (!this.usuarioDisciplina.equals(other.usuarioDisciplina)) {
            return false;
        }
        return true;
    }

}
