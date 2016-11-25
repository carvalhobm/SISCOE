package br.ufg.inf.siscoe.negocio.servico.implementacao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufg.inf.siscoe.integracao.dao.AvaliacaoDAO;
import br.ufg.inf.siscoe.integracao.entidade.Avaliacao;
import br.ufg.inf.siscoe.negocio.servico.AvaliacaoServico;

/**
 * <p>
 * AvaliacaoServicoImplementacao.
 * </p>
 * <p>
 * Descrição: Implementação da entidade {@link Avaliacao}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class AvaliacaoServicoImplementacao extends ServicoAbstratoImpl<Avaliacao, AvaliacaoDAO> implements AvaliacaoServico {

    private static final long serialVersionUID = -8859117560887268394L;

    @Inject
    private AvaliacaoDAO dao;

    @Override
    public AvaliacaoDAO getDao() {
        return this.dao;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.implementacao.ServicoAbstratoImpl#removerTodos(java.util.Collection)
     */
    @Override
    public String removerTodos(Collection<Avaliacao> entidades) {
        return this.getDao().removerTodos(entidades);
    }
}