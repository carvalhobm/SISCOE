package br.ufg.inf.siscoe.negocio.servico.implementacao;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.ufg.inf.siscoe.comum.enums.RoleEnum;
import br.ufg.inf.siscoe.comum.util.UtilObjeto;
import br.ufg.inf.siscoe.integracao.dao.UsuarioDAO;
import br.ufg.inf.siscoe.integracao.entidade.Role;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;
import br.ufg.inf.siscoe.negocio.servico.RoleService;
import br.ufg.inf.siscoe.negocio.servico.UsuarioDisciplinaServico;
import br.ufg.inf.siscoe.negocio.servico.UsuarioServico;

/**
 * <p>
 * UsuarioServicoImplementacao.
 * </p>
 * <p>
 * Descrição: Implementacao da interface UsuarioServico.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
@Stateless
public class UsuarioServicoImplementacao extends ServicoAbstratoImpl<Usuario, UsuarioDAO> implements UsuarioServico {

    private static final long serialVersionUID = -8859117560887268394L;

    @Inject
    private UsuarioDAO dao;

    @Inject
    private RoleService roleService;

    @Inject
    private UsuarioDisciplinaServico usuarioDisciplinaServico;

    @Override
    public UsuarioDAO getDao() {
        return this.dao;
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#existeUsuarioCadastrado(br.ufg.inf.siscoe.integracao.entidade.Usuario)
     */
    @Override
    public Boolean existeUsuarioCadastrado(final Usuario usuario) {
        final Usuario usuarioCadastrado = this.getDao().obterUsuarioByUsername(usuario.getUsername());

        return UtilObjeto.isReferencia(usuarioCadastrado);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#obterUsuarioByUsername(java.lang.String)
     */
    @Override
    public Usuario obterUsuarioByUsername(final String username) {
        return this.getDao().obterUsuarioByUsername(username);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#listarByFiltro(br.ufg.inf.siscoe.integracao.entidade.Usuario)
     */
    @Override
    public Collection<Usuario> listarByFiltro(final Usuario filtro) {
        return this.getDao().listarbyFiltro(filtro);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#listarCredenciais()
     */
    @Override
    public Collection<Role> listarCredenciais() {
        return this.roleService.listar();
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#inicializarUsuario(br.ufg.inf.siscoe.integracao.entidade.Usuario)
     */
    @Override
    public Usuario inicializarUsuario(final Usuario usuario) {
        return this.getDao().inicialiarUsuario(usuario);
    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#registrarFaltaUsuarioDisciplina(br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina)
     */
    @Override
    public void registrarFaltaUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina) {
        this.usuarioDisciplinaServico.registrarFaltaUsuarioDisciplina(usuarioDisciplina);

    }

    /**
     * @see br.ufg.inf.siscoe.negocio.servico.UsuarioServico#salvarUsuario(br.ufg.inf.siscoe.integracao.entidade.Usuario)
     */
    @Override
    public Usuario salvarUsuario(Usuario entidade) {

        final Role roleAcesso = new Role(RoleEnum.ACESSO.getNuRole());

        entidade.setListaRole(new ArrayList<Role>());
        entidade.getListaRole().add(roleAcesso);

        entidade.setIcPermitido(false);

        this.getDao().salvar(entidade);

        entidade.adicionarMensagem("MA002");

        return entidade;
    }

}
