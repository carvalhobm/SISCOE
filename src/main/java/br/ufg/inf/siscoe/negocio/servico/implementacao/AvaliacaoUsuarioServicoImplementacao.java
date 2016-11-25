package br.ufg.inf.siscoe.negocio.servico.implementacao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufg.inf.siscoe.integracao.dao.AvaliacaoUsuarioDAO;
import br.ufg.inf.siscoe.integracao.entidade.AvaliacaoUsuario;
import br.ufg.inf.siscoe.negocio.servico.AvaliacaoUsuarioServico;

/**
 * <p>
 * AvaliacaoUsuarioServicoImplementacao.
 * </p>
 * <p>
 * Descrição: Implementação da entidade {@link AvaliacaoUsuario}
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class AvaliacaoUsuarioServicoImplementacao extends ServicoAbstratoImpl<AvaliacaoUsuario, AvaliacaoUsuarioDAO>
        implements AvaliacaoUsuarioServico {

    private static final long serialVersionUID = -8859117560887268394L;

    @Inject
    private AvaliacaoUsuarioDAO dao;

    @Override
    public AvaliacaoUsuarioDAO getDao() {
        return this.dao;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.implementacao.ServicoAbstratoImpl#removerTodos(java.util.Collection)
     */
    @Override
    public String removerTodos(Collection<AvaliacaoUsuario> entidades) {
        return this.getDao().removerTodos(entidades);
    }
}