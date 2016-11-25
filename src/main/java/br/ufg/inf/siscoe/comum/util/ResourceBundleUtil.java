package br.ufg.inf.siscoe.comum.util;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class ResourceBundleUtil {
    private static ResourceBundle resourceBundle;

    /**
     * Retorna um resource bundle definido no descritor de configura��es do
     * JavaServer Faces.
     *
     * @param nomeVar
     *            o nome da vari�vel configurado para o resource bundle
     * @return o ResourceBundle
     */
    public static ResourceBundle getResourceBundle(String nomeVar) {

        final FacesContext context = FacesContext.getCurrentInstance();
        resourceBundle = context.getApplication().getResourceBundle(context, nomeVar);

        return resourceBundle;
    }

    /**
     * Altera��o necess�ria para informar quando o resourcebundle vem de uma
     * fonte diferente.
     *
     * @param resourceBundle
     *            valor a ser atribuido
     */
    public static void setResourceBundle(final ResourceBundle resourceBundle) {
        ResourceBundleUtil.resourceBundle = resourceBundle;
    }
}
