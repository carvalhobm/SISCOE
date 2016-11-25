package br.ufg.inf.siscoe.comum.enums;

public enum CargaHorariaEnum {

    CARGA_32(32, "32 horas"), CARGA_64(64, "64 horas"), CARGA_128(128, "128 horas");

    private CargaHorariaEnum(Integer nuRole, String noRole) {
        this.qtCargaHoraria = nuRole;
        this.noCargaHoraria = noRole;
    }

    private Integer qtCargaHoraria;

    private String noCargaHoraria;

    /**
     * Get/Set.
     *
     * @return the qtCargaHoraria
     */
    public Integer getQtCargaHoraria() {
        return this.qtCargaHoraria;
    }

    /**
     * Get/Set.
     *
     * @return the noCargaHoraria
     */
    public String getNoCargaHoraria() {
        return this.noCargaHoraria;
    }
}
