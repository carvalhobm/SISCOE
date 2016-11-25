package br.ufg.inf.siscoe.comum.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * <p>
 * UsuarioUtil.
 * </p>
 * <p>
 * Descrição: Classe utilitaria para Usuario.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public class UsuarioUtil {

    /**
     * Obtem usuario lugado.
     *
     * @return the usuarioLogado
     */
    public static User getUserLogado() {

        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
