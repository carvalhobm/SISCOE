package br.ufg.inf.siscoe.integracao.dao.implementacao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.ufg.inf.siscoe.comum.constante.BaseDadosConstante;
import br.ufg.inf.siscoe.comum.util.UtilString;
import br.ufg.inf.siscoe.integracao.dao.UsuarioDAO;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;

/**
 * <p>
 * UsuarioDAOImplementacao.
 * </p>
 * <p>
 * Descrição: Implementacao da interface {@link UsuarioDAO}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class UsuarioDAOImplementacao extends DAOImpl<Usuario> implements UsuarioDAO {

    @PersistenceContext(unitName = BaseDadosConstante.PERSISTENCE_UNIT)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     *
     * @see br.ufg.inf.siscoe.integracao.dao.UsuarioDAO#obterUsuarioByUsername(br.ufg
     *      .inf.siscoe.integracao.entidade.Usuario)
     */
    @Override
    public Usuario obterUsuarioByUsername(final String username) {

        final Criteria criteria = super.criarNovoCriterio(Usuario.class);

        criteria.add(Restrictions.eq("username", username));

        criteria.setMaxResults(1);

        return (Usuario) criteria.uniqueResult();
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.dao.UsuarioDAO#listarbyFiltro(br.ufg.inf.siscoe.integracao.entidade.Usuario)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Usuario> listarbyFiltro(Usuario filtro) {
        final Criteria criteria = super.criarNovoCriterio(Usuario.class);

        if (!UtilString.isVazio(filtro.getUsername())) {
            criteria.add(Restrictions.ilike("username", filtro.getUsername().trim(), MatchMode.ANYWHERE));
        }

        if (!UtilString.isVazio(filtro.getNoUsuario())) {
            criteria.add(Restrictions.ilike("noUsuario", filtro.getNoUsuario().trim(), MatchMode.ANYWHERE));
        }

        if (!UtilString.isVazio(filtro.getNoEmail())) {
            criteria.add(Restrictions.ilike("noEmail", filtro.getNoEmail().trim(), MatchMode.ANYWHERE));
        }

        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        return criteria.list();
    }

    /**
     * @see br.ufg.inf.siscoe.integracao.dao.UsuarioDAO#inicialiarUsuario(br.ufg.inf.siscoe.integracao.entidade.Usuario)
     */
    @Override
    public Usuario inicialiarUsuario(final Usuario usuario) {

        final Criteria criteria = super.criarNovoCriterio(Usuario.class);

        criteria.add(Restrictions.eq("idUsuario", usuario.getIdUsuario()));

        final Usuario user = (Usuario) criteria.uniqueResult();

        Hibernate.initialize(user.getListaRole());

        return user;
    }

}
