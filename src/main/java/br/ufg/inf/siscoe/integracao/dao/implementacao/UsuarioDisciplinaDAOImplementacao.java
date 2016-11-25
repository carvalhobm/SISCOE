package br.ufg.inf.siscoe.integracao.dao.implementacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufg.inf.siscoe.comum.constante.BaseDadosConstante;
import br.ufg.inf.siscoe.integracao.dao.UsuarioDisciplinaDAO;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;

/**
 * <p>
 * UsuarioDisciplinaDAOImplementacao.
 * </p>
 * <p>
 * Descrição: Implementacao da interface {@link UsuarioDisciplinaDAO}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class UsuarioDisciplinaDAOImplementacao extends DAOImpl<UsuarioDisciplina> implements UsuarioDisciplinaDAO {

    @PersistenceContext(unitName = BaseDadosConstante.PERSISTENCE_UNIT)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
