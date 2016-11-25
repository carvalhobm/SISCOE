package br.ufg.inf.siscoe.integracao.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>
 * Usuario.
 * </p>
 * <p>
 * Descrição: Entidade Usuario.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Entity(name = "tb_usuario")
public class Usuario extends Entidade {

    private static final long serialVersionUID = -2145505279735748008L;

    @Id
    @Column(name = "id_usuario", columnDefinition = "serial", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "no_usuario", insertable = true, unique = true)
    private String noUsuario;

    @Column(name = "no_sobrenome_usuario", insertable = true, unique = true)
    private String noSobrenomeUsuario;

    @Column(name = "no_email", insertable = true, unique = true)
    private String noEmail;

    @Column(name = "username", insertable = true, unique = true)
    private String username;

    @Column(name = "password", insertable = true)
    private String password;

    @Column(name = "ic_permitido", insertable = true)
    private boolean icPermitido;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_roles_usuario", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = { @JoinColumn(name = "id_role") })
    private List<Role> listaRole;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuario", targetEntity = UsuarioDisciplina.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuarioDisciplina> listaUsuarioDisciplina;

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getIdentificador()
     */
    @Override
    public Serializable getIdentificador() {
        return this.idUsuario;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.entidade.Entidade#getChavePrimaria()
     */
    @Override
    public String getChavePrimaria() {
        return "idUsuario";
    }

    /**
     * Retorna o valor do idUsuario.
     *
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param idUsuario
     *            the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Retorna o valor do noUsuario.
     *
     * @return the noUsuario
     */
    public String getNoUsuario() {
        return this.noUsuario;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param noUsuario
     *            the noUsuario to set
     */
    public void setNoUsuario(String noUsuario) {
        this.noUsuario = noUsuario;
    }

    /**
     * Retorna o valor do noSobrenomeUsuario.
     *
     * @return the noSobrenomeUsuario
     */
    public String getNoSobrenomeUsuario() {
        return this.noSobrenomeUsuario;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param noSobrenomeUsuario
     *            the noSobrenomeUsuario to set
     */
    public void setNoSobrenomeUsuario(String noSobrenomeUsuario) {
        this.noSobrenomeUsuario = noSobrenomeUsuario;
    }

    /**
     * Retorna o valor do noEmail.
     *
     * @return the noEmail
     */
    public String getNoEmail() {
        return this.noEmail;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param noEmail
     *            the noEmail to set
     */
    public void setNoEmail(String noEmail) {
        this.noEmail = noEmail;
    }

    /**
     * Retorna o valor do username.
     *
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retorna o valor do password.
     *
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna o valor do icPermitido.
     *
     * @return the icPermitido
     */
    public boolean isIcPermitido() {
        return this.icPermitido;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param icPermitido
     *            the icPermitido to set
     */
    public void setIcPermitido(boolean icPermitido) {
        this.icPermitido = icPermitido;
    }

    /**
     * Retorna o valor do listaRole.
     *
     * @return the listaRole
     */
    public List<Role> getListaRole() {
        return this.listaRole;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaRole
     *            the listaRole to set
     */
    public void setListaRole(List<Role> listaRole) {
        this.listaRole = listaRole;
    }

    /**
     * Retorna o valor do listaUsuarioDisciplina.
     *
     * @return the listaUsuarioDisciplina
     */
    public List<UsuarioDisciplina> getListaUsuarioDisciplina() {
        return this.listaUsuarioDisciplina;
    }

    /**
     * Atribui o valor ao campo.
     *
     * @param listaUsuarioDisciplina
     *            the listaUsuarioDisciplina to set
     */
    public void setListaUsuarioDisciplina(List<UsuarioDisciplina> listaUsuarioDisciplina) {
        this.listaUsuarioDisciplina = listaUsuarioDisciplina;
    }

}
