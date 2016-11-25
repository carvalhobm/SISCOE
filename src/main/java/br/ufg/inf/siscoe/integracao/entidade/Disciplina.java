package br.ufg.inf.siscoe.integracao.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;

/**
 * <p>
 * Disciplina.
 * </p>
 * <p>
 * Descrição: Entidade Disciplina.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Entity(name = "tb_disciplina")
public class Disciplina extends Entidade {

    private static final long serialVersionUID = 5324766014196425550L;

    @Id
    @Column(name = "nu_disciplina")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nuDisciplina;

    @Column(name = "no_disciplina")
    private String noDisciplina;

    @Column(name = "nu_carga_horaria")
    private Integer nuCargaHoraria;

    @Column(name = "nu_hora_aula")
    private Integer nuHoraAula;

    @Column(name = "fm_media_final")
    private String fmMediaFinal;

    @Column(name = "ic_ativo")
    private boolean icAtivo;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "disciplina", targetEntity = Avaliacao.class, cascade = CascadeType.ALL)
    private Collection<Avaliacao> listaAvaliacao;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "disciplina", targetEntity = AvaliacaoUsuario.class, cascade = CascadeType.ALL)
    private Collection<AvaliacaoUsuario> listaAvaliacaoUsuario;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "disciplina", targetEntity = UsuarioDisciplina.class, cascade = CascadeType.ALL)
    private Collection<UsuarioDisciplina> listaUsuarioDisciplina;

    @Transient
    private String noDisciplinaFormatado;

    @Transient
    private boolean usuarioMatriculado;

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getIdentificador()
     */
    @Override
    public Serializable getIdentificador() {
        return this.nuDisciplina;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getChavePrimaria()
     */
    @Override
    public String getChavePrimaria() {
        return this.nuDisciplina.toString();
    }

    /**
     *
     * Método responsável por formatar o nome da disciplina pra ser utilizado
     * como id.
     *
     * @return String
     * @author Bruno Martins de Carvalho
     */
    public String getNoDisciplinaFormatado() {
        return this.noDisciplina.trim().replace(" ", "");
    }

    /**
     *
     * Atribui o valor ao campo.
     *
     * @param noDisciplinaFormatado
     *            the noDisciplinaFormatado to set
     */
    public void setNoDisciplinaFormatado(String noDisciplinaFormatado) {
        this.noDisciplinaFormatado = noDisciplinaFormatado;
    }

    /**
     * Retorna o valor do nuDisciplina.
     *
     * @return the nuDisciplina
     */
    public Integer getNuDisciplina() {
        return this.nuDisciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param nuDisciplina
     *            the nuDisciplina to set
     */
    public void setNuDisciplina(Integer nuDisciplina) {
        this.nuDisciplina = nuDisciplina;
    }

    /**
     * Retorna o valor do noDisciplina.
     *
     * @return the noDisciplina
     */
    public String getNoDisciplina() {
        return this.noDisciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param noDisciplina
     *            the noDisciplina to set
     */
    public void setNoDisciplina(String noDisciplina) {
        this.noDisciplina = noDisciplina;
    }

    /**
     * Retorna o valor do nuCargaHoraria.
     *
     * @return the nuCargaHoraria
     */
    public Integer getNuCargaHoraria() {
        return this.nuCargaHoraria;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param nuCargaHoraria
     *            the nuCargaHoraria to set
     */
    public void setNuCargaHoraria(Integer nuCargaHoraria) {
        this.nuCargaHoraria = nuCargaHoraria;
    }

    /**
     * Retorna o valor do nuHoraAula.
     *
     * @return the nuHoraAula
     */
    public Integer getNuHoraAula() {
        return this.nuHoraAula;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param nuHoraAula
     *            the nuHoraAula to set
     */
    public void setNuHoraAula(Integer nuHoraAula) {
        this.nuHoraAula = nuHoraAula;
    }

    /**
     * Retorna o valor do fmMediaFinal.
     *
     * @return the fmMediaFinal
     */
    public String getFmMediaFinal() {
        return this.fmMediaFinal;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param fmMediaFinal
     *            the fmMediaFinal to set
     */
    public void setFmMediaFinal(String fmMediaFinal) {
        this.fmMediaFinal = fmMediaFinal;
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
     * Retorna o valor do listaAvaliacao.
     *
     * @return the listaAvaliacao
     */
    public Collection<Avaliacao> getListaAvaliacao() {
        return this.listaAvaliacao;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaAvaliacao
     *            the listaAvaliacao to set
     */
    public void setListaAvaliacao(Collection<Avaliacao> listaAvaliacao) {
        this.listaAvaliacao = listaAvaliacao;
    }

    /**
     * Retorna o valor do listaAvaliacaoUsuario.
     *
     * @return the listaAvaliacaoUsuario
     */
    public Collection<AvaliacaoUsuario> getListaAvaliacaoUsuario() {
        if (!UtilObjeto.isReferencia(this.listaAvaliacaoUsuario)) {
            this.listaAvaliacaoUsuario = new ArrayList<AvaliacaoUsuario>();
        }
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
     * Retorna o valor do listaUsuarioDisciplina.
     *
     * @return the listaUsuarioDisciplina
     */
    public Collection<UsuarioDisciplina> getListaUsuarioDisciplina() {
        if (!UtilObjeto.isReferencia(this.listaUsuarioDisciplina)) {
            this.listaUsuarioDisciplina = new ArrayList<UsuarioDisciplina>();
        }
        return this.listaUsuarioDisciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaUsuarioDisciplina
     *            the listaUsuarioDisciplina to set
     */
    public void setListaUsuarioDisciplina(Collection<UsuarioDisciplina> listaUsuarioDisciplina) {
        this.listaUsuarioDisciplina = listaUsuarioDisciplina;
    }

    /**
     * Retorna o valor do usuarioMatriculado.
     *
     * @return the usuarioMatriculado
     */
    public boolean isUsuarioMatriculado() {
        return this.usuarioMatriculado;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param usuarioMatriculado
     *            the usuarioMatriculado to set
     */
    public void setUsuarioMatriculado(boolean usuarioMatriculado) {
        this.usuarioMatriculado = usuarioMatriculado;
    }
}
