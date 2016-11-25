package br.ufg.inf.siscoe.integracao.dao.implementacao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufg.inf.siscoe.comum.constante.BaseDadosConstante;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.dao.AvaliacaoUsuarioDAO;
import br.ufg.inf.siscoe.integracao.entidade.AvaliacaoUsuario;

/**
 * <p>
 * AvaliacaoUsuarioDAOImplementacao.
 * </p>
 * <p>
 * Descrição: Implementação da interface {@link AvaliacaoUsuarioDAO}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class AvaliacaoUsuarioDAOImplementacao extends DAOImpl<AvaliacaoUsuario> implements AvaliacaoUsuarioDAO {

    @PersistenceContext(unitName = BaseDadosConstante.PERSISTENCE_UNIT)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.dao.AvaliacaoUsuarioDAO#removerTodos(java.util.Collection)
     */
    @Override
    public String removerTodos(Collection<AvaliacaoUsuario> entidades) {
        final StringBuilder sbHql = new StringBuilder();

        if (!UtilObjeto.isVazio(entidades)) {

            sbHql.append(" DELETE FROM ").append(AvaliacaoUsuario.class.getName());
            sbHql.append(" WHERE nuAvaliacaoUsuario IN ( :idsAvaliacao )");

            final Query query = this.getEntityManager().createQuery(sbHql.toString());

            final Collection<Integer> listaId = new ArrayList<Integer>();

            for (final AvaliacaoUsuario avaliacao : entidades) {
                listaId.add(avaliacao.getNuAvaliacaoUsuario());
            }

            query.setParameter("idsAvaliacao", listaId);

            query.executeUpdate();

            this.em.flush();
        }

        return "MA002";
    }
}
