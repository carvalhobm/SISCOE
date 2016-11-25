package br.ufg.inf.siscoe.integracao.dao.implementacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.dao.DAO;
import br.ufg.inf.siscoe.integracao.entidade.Entidade;
import br.ufg.inf.siscoe.reflexao.UtilReflexaoGeneric;

public abstract class DAOImpl<T extends Entidade> implements DAO<T> {
    @SuppressWarnings("unchecked")
    @Override
    public T obter(final Serializable chavePrimaria) {
        if (UtilObjeto.isReferencia(chavePrimaria)) {
            return this.getHibernateSession().get(this.getTipoEntidadePersistente(), chavePrimaria);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<T> obter(final Collection<Serializable> listaCP) {
        if (UtilObjeto.isReferencia(listaCP) && !UtilObjeto.isVazio(listaCP)) {
            final Criteria criteria = this.criarNovoCriterio();
            criteria.add(Restrictions.in(this.getEntidade().getChavePrimaria(), listaCP));
            return criteria.list();
        }
        return new ArrayList<T>();
    }

    @Override
    public Serializable inserir(final T entidade) {
        return this.getHibernateSession().save(entidade);
    }

    @Override
    public void alterar(final T entidade) {
        this.getHibernateSession().update(entidade);
    }

    @Override
    public void salvar(final T entidade) {
        if (UtilObjeto.isReferencia(entidade)) {
            if (UtilObjeto.isReferencia(entidade.getIdentificador())) {
                this.getHibernateSession().merge(entidade);
            } else {
                this.getHibernateSession().persist(entidade);
            }
        }
    }

    @Override
    public void salvar(final Collection<T> listaEntidade) {
        for (final T novo : listaEntidade) {
            this.salvar(novo);
        }
    }

    @Override
    public void remover(final T entidade) {
        this.getHibernateSession().delete(this.getEntityManager().merge(entidade));
        this.getHibernateSession().flush();
    }

    @Override
    public void remover(final Serializable id) {
        if (UtilObjeto.isReferencia(id)) {
            final T entidade = this.obter(id);
            if (UtilObjeto.isReferencia(entidade)) {
                this.remover(entidade);
            }
        }
    }

    @Override
    public void remover(final Collection<T> listaEntidades) {
        if (UtilObjeto.isReferencia(listaEntidades)) {
            for (final T entidade : listaEntidades) {
                this.remover(entidade);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void removerPorIds(final Collection<Serializable> listaIds) {
        final Criteria criteria = this.criarNovoCriterio();
        criteria.add(Restrictions.in(this.getEntidade().getChavePrimaria(), listaIds));
        final Collection<T> resultado = criteria.list();
        if (!UtilObjeto.isVazio(resultado)) {
            for (final T entidade : resultado) {
                this.remover(entidade);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<T> listar() {
        return this.criarNovoCriterio().list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<T> listar(final int inicioConsulta, final int finalConsulta) {
        final Criteria criteria = this.criarNovoCriterio();
        this.definirLimitesConsulta(criteria, inicioConsulta, finalConsulta);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<T> listar(final Criteria criteria, final int inicioConsulta, final int finalConsulta) {
        this.definirLimitesConsulta(criteria, inicioConsulta, finalConsulta);
        return criteria.list();
    }

    protected final Boolean isPersistente(final T entidade) {
        return (this.getHibernateSession().contains(entidade));
    }

    @SuppressWarnings("unchecked")
    protected final Class<T> getTipoEntidadePersistente() {
        return (Class<T>) UtilReflexaoGeneric.getClasseDoTipo(this);
    }

    protected final T getEntidade() {
        try {
            return this.getTipoEntidadePersistente().newInstance();
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected abstract EntityManager getEntityManager();

    protected final Session getHibernateSession() {
        return (Session) this.getEntityManager().getDelegate();
    }

    @SuppressWarnings("deprecation")
    protected final Criteria criarNovoCriterio() {
        return this.getHibernateSession().createCriteria(this.getTipoEntidadePersistente());
    }

    @SuppressWarnings("deprecation")
    protected final <E extends Entidade> Criteria criarNovoCriterio(final Class<E> entidade) {
        return this.getHibernateSession().createCriteria(entidade);
    }

    protected final void definirLimitesConsulta(final Criteria criteria, final int inicioConsulta, final int finalConsulta) {
        if (UtilObjeto.isReferencia(criteria)) {
            criteria.setFirstResult(inicioConsulta);
            criteria.setMaxResults(finalConsulta);
        }
    }

    protected Integer getQuantidadeRegistros(final Criteria criteria, final String atributo) {
        if (UtilObjeto.isReferencia(criteria)) {
            try {
                criteria.setProjection(Projections.projectionList().add(Projections.count(atributo)));
                final Long quantidade = (Long) criteria.uniqueResult();
                return quantidade != null ? new Integer(quantidade.intValue()) : 0;
            } catch (final Exception ex) {
                System.out.println("Erro na contagem de registros");
                ex.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public void flushNaBaseDados() {
        this.getHibernateSession().flush();
        this.getHibernateSession().beginTransaction().commit();
    }

    @Override
    public void flushEClear() {
        this.getHibernateSession().flush();
        this.getHibernateSession().clear();
    }

}
