package br.ufg.inf.siscoe.negocio.servico.implementacao;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufg.inf.siscoe.integracao.dao.RoleDAO;
import br.ufg.inf.siscoe.integracao.entidade.Role;
import br.ufg.inf.siscoe.negocio.servico.RoleService;

@Stateless
public class RoleServicoImplementacao extends ServicoAbstratoImpl<Role, RoleDAO> implements RoleService {

    private static final long serialVersionUID = -8859117560887268394L;

    @Inject
    private RoleDAO dao;

    @Override
    public RoleDAO getDao() {
        return this.dao;
    }

}
