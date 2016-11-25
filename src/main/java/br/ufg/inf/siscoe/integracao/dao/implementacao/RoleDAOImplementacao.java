package br.ufg.inf.siscoe.integracao.dao.implementacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufg.inf.siscoe.comum.constante.BaseDadosConstante;
import br.ufg.inf.siscoe.integracao.dao.RoleDAO;
import br.ufg.inf.siscoe.integracao.entidade.Role;

/**
 * <p>
 * RoleDAOImplementacao.
 * </p>
 * <p>
 * Descrição: Implementacao da interface {@link RoleDAOImplementacao}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class RoleDAOImplementacao extends DAOImpl<Role> implements RoleDAO {

    @PersistenceContext(unitName = BaseDadosConstante.PERSISTENCE_UNIT)
    private EntityManager em;

    /**
     * @see br.ufg.inf.siscoe.integracao.dao.implementacao.DAOImpl#getEntityManager()
     */
    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

}
