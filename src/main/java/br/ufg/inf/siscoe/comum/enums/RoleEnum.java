package br.ufg.inf.siscoe.comum.enums;

/**
 * <p>
 * RoleEnum.
 * </p>
 * <p>
 * Descrição: Enum credenciais.
 * </p>
 *
 * @author Bruno Martins de Carvalho
 */
public enum RoleEnum {

    ACESSO(1, "ROLE_ACESSO"), ADMIN(2, "ROLE_ADMIN"), DISCENTE(3, "ROLE_DISCENTE"), DOCENTE(4, "ROLE_DOCENTE");

    private RoleEnum(Integer nuRole, String noRole) {
        this.nuRole = nuRole;
        this.noRole = noRole;
    }

    private Integer nuRole;

    private String noRole;

    /**
     * Retorna o valor do nuRole.
     *
     * @return the nuRole
     */
    public Integer getNuRole() {
        return this.nuRole;
    }

    /**
     * Retorna o valor do noRole.
     *
     * @return the noRole
     */
    public String getNoRole() {
        return this.noRole;
    }

}
