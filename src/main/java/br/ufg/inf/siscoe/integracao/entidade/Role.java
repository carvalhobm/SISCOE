package br.ufg.inf.siscoe.integracao.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "tb_role")
public class Role extends Entidade {

    private static final long serialVersionUID = 5324766014196425550L;

    @Id
    @Column(name = "id_role")
    private Integer nuRole;

    @Column(name = "no_role")
    private String noRole;

    @ManyToMany(mappedBy = "listaRole")
    private List<Usuario> listaUsuario;

    public Role() {
    }

    public Role(final Integer nuRole) {
        this.nuRole = nuRole;
    }

    @Override
    public Serializable getIdentificador() {
        return this.nuRole;
    }

    @Override
    public String getChavePrimaria() {
        return "nuRole";
    }

    public Integer getNuRole() {
        return this.nuRole;
    }

    public void setNuRole(Integer nuRole) {
        this.nuRole = nuRole;
    }

    public String getNoRole() {
        return this.noRole;
    }

    public void setNoRole(String noRole) {
        this.noRole = noRole;
    }

    public List<Usuario> getListaUsuario() {
        return this.listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}
