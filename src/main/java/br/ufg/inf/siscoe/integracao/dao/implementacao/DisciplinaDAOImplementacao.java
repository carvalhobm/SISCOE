package br.ufg.inf.siscoe.integracao.dao.implementacao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.ufg.inf.siscoe.comum.constante.BaseDadosConstante;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.comum.util.UtilString;
import br.ufg.inf.siscoe.integracao.dao.DisciplinaDAO;
import br.ufg.inf.siscoe.integracao.entidade.Disciplina;

/**
 * <p>
 * DisciplinaDAOImplementacao.
 * </p>
 * <p>
 * Descrição: Implementação da interface {@link DisciplinaDAO}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class DisciplinaDAOImplementacao extends DAOImpl<Disciplina> implements DisciplinaDAO {

    @PersistenceContext(unitName = BaseDadosConstante.PERSISTENCE_UNIT)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.dao.DisciplinaDAO#listarbyFiltro(br.ufg.inf.siscoe.integracao.entidade.Disciplina)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Disciplina> listarbyFiltro(final Disciplina filtro) {
        final Criteria criteria = super.criarNovoCriterio();

        if (!UtilString.isVazio(filtro.getNoDisciplina())) {
            criteria.add(Restrictions.ilike("noDisciplina", filtro.getNoDisciplina().trim(), MatchMode.ANYWHERE));
        }

        if (UtilObjeto.isReferencia(filtro.isIcAtivo()) && filtro.isIcAtivo()) {
            criteria.add(Restrictions.eq("icAtivo", filtro.isIcAtivo()));
        }

        if (UtilObjeto.isReferencia(filtro.getNuCargaHoraria()) && filtro.getNuCargaHoraria() > 0) {
            criteria.add(Restrictions.eq("nuCargaHoraria", filtro.getNuCargaHoraria()));
        }

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        return criteria.list();
    }

}
