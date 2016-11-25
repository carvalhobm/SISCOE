package br.ufg.inf.siscoe.integracao.dao.implementacao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufg.inf.siscoe.comum.constante.BaseDadosConstante;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.dao.AvaliacaoDAO;
import br.ufg.inf.siscoe.integracao.dao.AvaliacaoUsuarioDAO;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;

/**
 * <p>
 * AvaliacaoDAOImplementacao.
 * </p>
 * <p>
 * Descrição: Implementação da interface {@link AvaliacaoUsuarioDAO}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class AvaliacaoDAOImplementacao extends DAOImpl<Avaliacao> implements AvaliacaoDAO {

    @PersistenceContext(unitName = BaseDadosConstante.PERSISTENCE_UNIT)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.dao.AvaliacaoDAO#removerTodos(java.util.Collection)
     */
    @Override
    public String removerTodos(Collection<Avaliacao> entidades) {
        final StringBuilder sbHql = new StringBuilder();

        if (!UtilObjeto.isVazio(entidades)) {

            sbHql.append(" DELETE FROM ").append(Avaliacao.class.getName());
            sbHql.append(" WHERE nuAvaliacao IN ( :idsAvaliacao )");

            final Query query = this.getEntityManager().createQuery(sbHql.toString());

            final Collection<Integer> listaId = new ArrayList<Integer>();

            for (final Avaliacao avaliacao : entidades) {
                listaId.add(avaliacao.getNuAvaliacao());
            }

            query.setParameter("idsAvaliacao", listaId);

            query.executeUpdate();
        }

        return "MA002";
    }
}
