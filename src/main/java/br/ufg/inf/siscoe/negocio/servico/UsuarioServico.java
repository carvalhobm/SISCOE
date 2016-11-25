package br.ufg.inf.siscoe.negocio.servico;

import java.util.Collection;

import br.ufg.inf.siscoe.integracao.dao.UsuarioDAO;
import br.ufg.inf.siscoe.integracao.entidade.Role;
import br.ufg.inf.siscoe.integracao.entidade.Usuario;
import br.ufg.inf.siscoe.integracao.entidade.UsuarioDisciplina;

/**
 * <p>
 * UsuarioServico.
 * </p>
 * <p>
 * Descrição: Servico para entidade Usuario.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface UsuarioServico extends Servico<Usuario, UsuarioDAO> {

    /**
     *
     * Método responsável por verificar se já existe um usuário com o username
     * cadastrado.
     *
     * @param usuario
     *            valor a ser atribuido
     * @return Boolean
     * @author Bruno Martins de Carvalho
     */
    Boolean existeUsuarioCadastrado(Usuario usuario);

    /**
     *
     * Método responsável por listar os usuarios utilizando filtros.
     *
     * @param filtro
     *            valor a ser atribuido
     * @return Collection<>
     * @author Bruno Martins de Carvalho
     */
    Collection<Usuario> listarByFiltro(Usuario filtro);

    /**
     *
     * Método responsável por listar as credenciais disponiveis no sistema.
     *
     * @return Collection<>
     * @author Bruno Martins de Carvalho
     */
    Collection<Role> listarCredenciais();

    /**
     *
     * Método responsável por inicializar a lista de credenciais do usuario.
     *
     * @param usuario
     *            valor a ser atribuido
     * @return Usuario
     * @author Bruno Martins de Carvalho
     */
    Usuario inicializarUsuario(Usuario usuario);

    /**
     *
     * Método responsável por obter um usuario por username.
     *
     * @param username
     *            valor a ser atribuido
     * @return Usuario
     * @author Bruno Martins de Carvalho
     */
    Usuario obterUsuarioByUsername(String username);

    /**
     *
     * Método responsável por registrar falta ao aluno.
     *
     * @param usuarioDisciplina
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    void registrarFaltaUsuarioDisciplina(UsuarioDisciplina usuarioDisciplina);

    /**
     *
     * Método responsável por salvar usuario.
     *
     * @param entidade
     *            valor a ser atribuido
     * @author Bruno Martins de Carvalho
     */
    Usuario salvarUsuario(Usuario entidade);

}
