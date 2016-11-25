package br.ufg.inf.siscoe.integracao.dao;

import java.util.Collection;

import br.ufg.inf.siscoe.integracao.entidade.Usuario;

/**
 * <p>
 * UsuarioDAO.
 * </p>
 * <p>
 * Descrição: DAO para entidade Usuario
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public interface UsuarioDAO extends DAO<Usuario> {

    /**
     *
     * Método responsável por obter um usuario por username.
     *
     * @param usuario
     *            valor a ser atribuido
     * @return Usuario
     * @author Bruno Martins de Carvalho
     */
    Usuario obterUsuarioByUsername(String usuario);

    /**
     *
     * Método responsável por listar usuarios de acordo com o filtro informado.
     *
     * @param filtro
     *            valor a ser atribuido
     * @return Collection<>
     * @author Bruno Martins de Carvalho
     */
    Collection<Usuario> listarbyFiltro(Usuario filtro);

    /**
     *
     * Método responsável por inicializar a lista de credenciais do usuario.
     *
     * @param usuario
     *            valor a ser atribuido
     * @return Usuario
     * @author Bruno Martins de Carvalho
     */
    Usuario inicialiarUsuario(Usuario usuario);

}
