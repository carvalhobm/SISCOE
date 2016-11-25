package br.ufg.inf.siscoe.comum.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import br.ufg.inf.siscoe.integracao.dao.RoleDAO;
import br.ufg.inf.siscoe.integracao.entidade.Role;

/**
 * <p>
 * RoleConverter.
 * </p>
 * <p>
 * Descrição: Converter Role.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@ManagedBean(name = "roleConverter")
public class RoleConverter implements Converter {

    @Inject
    private RoleDAO roleDAO;

    /**
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.String)
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.roleDAO.obter(Integer.valueOf(value));
    }

    /**
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Role) value).getIdentificador().toString();
    }
}