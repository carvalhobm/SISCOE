package br.ufg.inf.siscoe.apresentacao.visao;

import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardModel;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;

/**
 * .
 * <p>
 * DashboardVisao.
 * </p>
 * <p>
 * Descrição: Visao para entidade Usuario no dashBoard.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */

public class DashboardVisao extends ManutencaoVisao<Usuario> {

    private static final long serialVersionUID = -6069373399203351643L;

    private transient DashboardModel model;

    /**
     * ..
     *
     * @return the model
     */
    public DashboardModel getModel() {
        if (!UtilObjeto.isReferencia(this.model)) {
            this.model = new DefaultDashboardModel();
        }
        return this.model;
    }

    /**
     * ..
     *
     * @param model
     *            the model to set
     */
    public void setModel(DashboardModel model) {
        this.model = model;
    }

}
