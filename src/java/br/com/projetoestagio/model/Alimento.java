/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

/**
 *
 * @author Leticia
 */
public class Alimento {

    private Integer idAlimento;
    private String nomeTabelaNutricionalAlimento;
    private String nomeAlimento;
    private String tipoAlimento;
    private String especieAlimento;
    private String statusAlimento;
    private Double proteinaAlimento;
    private Double lipideoAlimento;
    private Double carboidratoAlimento;
    private Double fibraAlimentarAlimento;
    private String caminhoImagemAlimento;

    public Alimento() {
    }

    public Alimento(Integer idAlimento, String nomeTabelaNutricionalAlimento, String nomeAlimento, String tipoAlimento, String especieAlimento, String statusAlimento, Double proteinaAlimento, Double lipideoAlimento, Double carboidratoAlimento, Double fibraAlimentarAlimento, String caminhoImagemAlimento) {
        this.idAlimento = idAlimento;
        this.nomeTabelaNutricionalAlimento = nomeTabelaNutricionalAlimento;
        this.nomeAlimento = nomeAlimento;
        this.tipoAlimento = tipoAlimento;
        this.especieAlimento = especieAlimento;
        this.statusAlimento = statusAlimento;
        this.proteinaAlimento = proteinaAlimento;
        this.lipideoAlimento = lipideoAlimento;
        this.carboidratoAlimento = carboidratoAlimento;
        this.fibraAlimentarAlimento = fibraAlimentarAlimento;
        this.caminhoImagemAlimento = caminhoImagemAlimento;
    }

    /**
     * @return the idAlimento
     */
    public Integer getIdAlimento() {
        return idAlimento;
    }

    /**
     * @param idAlimento the idAlimento to set
     */
    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    /**
     * @return the nomeTabelaNutricionalAlimento
     */
    public String getNomeTabelaNutricionalAlimento() {
        return nomeTabelaNutricionalAlimento;
    }

    /**
     * @param nomeTabelaNutricionalAlimento the nomeTabelaNutricionalAlimento to set
     */
    public void setNomeTabelaNutricionalAlimento(String nomeTabelaNutricionalAlimento) {
        this.nomeTabelaNutricionalAlimento = nomeTabelaNutricionalAlimento;
    }

    /**
     * @return the nomeAlimento
     */
    public String getNomeAlimento() {
        return nomeAlimento;
    }

    /**
     * @param nomeAlimento the nomeAlimento to set
     */
    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    /**
     * @return the tipoAlimento
     */
    public String getTipoAlimento() {
        return tipoAlimento;
    }

    /**
     * @param tipoAlimento the tipoAlimento to set
     */
    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    /**
     * @return the especieAlimento
     */
    public String getEspecieAlimento() {
        return especieAlimento;
    }

    /**
     * @param especieAlimento the especieAlimento to set
     */
    public void setEspecieAlimento(String especieAlimento) {
        this.especieAlimento = especieAlimento;
    }

    /**
     * @return the statusAlimento
     */
    public String getStatusAlimento() {
        return statusAlimento;
    }

    /**
     * @param statusAlimento the statusAlimento to set
     */
    public void setStatusAlimento(String statusAlimento) {
        this.statusAlimento = statusAlimento;
    }

    /**
     * @return the proteinaAlimento
     */
    public Double getProteinaAlimento() {
        return proteinaAlimento;
    }

    /**
     * @param proteinaAlimento the proteinaAlimento to set
     */
    public void setProteinaAlimento(Double proteinaAlimento) {
        this.proteinaAlimento = proteinaAlimento;
    }

    /**
     * @return the lipideoAlimento
     */
    public Double getLipideoAlimento() {
        return lipideoAlimento;
    }

    /**
     * @param lipideoAlimento the lipideoAlimento to set
     */
    public void setLipideoAlimento(Double lipideoAlimento) {
        this.lipideoAlimento = lipideoAlimento;
    }

    /**
     * @return the carboidratoAlimento
     */
    public Double getCarboidratoAlimento() {
        return carboidratoAlimento;
    }

    /**
     * @param carboidratoAlimento the carboidratoAlimento to set
     */
    public void setCarboidratoAlimento(Double carboidratoAlimento) {
        this.carboidratoAlimento = carboidratoAlimento;
    }

    /**
     * @return the fibraAlimentarAlimento
     */
    public Double getFibraAlimentarAlimento() {
        return fibraAlimentarAlimento;
    }

    /**
     * @param fibraAlimentarAlimento the fibraAlimentarAlimento to set
     */
    public void setFibraAlimentarAlimento(Double fibraAlimentarAlimento) {
        this.fibraAlimentarAlimento = fibraAlimentarAlimento;
    }

    /**
     * @return the caminhoImagemAlimento
     */
    public String getCaminhoImagemAlimento() {
        return caminhoImagemAlimento;
    }

    /**
     * @param caminhoImagemAlimento the caminhoImagemAlimento to set
     */
    public void setCaminhoImagemAlimento(String caminhoImagemAlimento) {
        this.caminhoImagemAlimento = caminhoImagemAlimento;
    }
    
    

    

}
