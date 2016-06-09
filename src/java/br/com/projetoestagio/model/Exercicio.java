/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

/**
 *
 * @author Grazy Martins
 */
public class Exercicio {
    
    private Integer idExercicio;
    private String nomeExercicio;
    private String tipoExercicio;
    private String frequenciaExercicio;
    private Double totalHorasExercicio;
    private String intensidadeExercicio;
    private String statusExercicio;
    private Integer sincronizaExercicio;
    private Avaliacao avaliacao;

    public Exercicio() {
    }

    public Exercicio(Integer idExercicio, String nomeExercicio, String tipoExercicio, String frequenciaExercicio, Double totalHorasExercicio, String intensidadeExercicio, String statusExercicio, Integer sincronizaExercicio, Avaliacao avaliacao) {
        this.idExercicio = idExercicio;
        this.nomeExercicio = nomeExercicio;
        this.tipoExercicio = tipoExercicio;
        this.frequenciaExercicio = frequenciaExercicio;
        this.totalHorasExercicio = totalHorasExercicio;
        this.intensidadeExercicio = intensidadeExercicio;
        this.statusExercicio = statusExercicio;
        this.sincronizaExercicio = sincronizaExercicio;
        this.avaliacao = avaliacao;
    }

    /**
     * @return the idExercicio
     */
    public Integer getIdExercicio() {
        return idExercicio;
    }

    /**
     * @param idExercicio the idExercicio to set
     */
    public void setIdExercicio(Integer idExercicio) {
        this.idExercicio = idExercicio;
    }

    /**
     * @return the nomeExercicio
     */
    public String getNomeExercicio() {
        return nomeExercicio;
    }

    /**
     * @param nomeExercicio the nomeExercicio to set
     */
    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    /**
     * @return the tipoExercicio
     */
    public String getTipoExercicio() {
        return tipoExercicio;
    }

    /**
     * @param tipoExercicio the tipoExercicio to set
     */
    public void setTipoExercicio(String tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    /**
     * @return the frequenciaExercicio
     */
    public String getFrequenciaExercicio() {
        return frequenciaExercicio;
    }

    /**
     * @param frequenciaExercicio the frequenciaExercicio to set
     */
    public void setFrequenciaExercicio(String frequenciaExercicio) {
        this.frequenciaExercicio = frequenciaExercicio;
    }

    /**
     * @return the totalHorasExercicio
     */
    public Double getTotalHorasExercicio() {
        return totalHorasExercicio;
    }

    /**
     * @param totalHorasExercicio the totalHorasExercicio to set
     */
    public void setTotalHorasExercicio(Double totalHorasExercicio) {
        this.totalHorasExercicio = totalHorasExercicio;
    }

    /**
     * @return the intensidadeExercicio
     */
    public String getIntensidadeExercicio() {
        return intensidadeExercicio;
    }

    /**
     * @param intensidadeExercicio the intensidadeExercicio to set
     */
    public void setIntensidadeExercicio(String intensidadeExercicio) {
        this.intensidadeExercicio = intensidadeExercicio;
    }

    /**
     * @return the statusExercicio
     */
    public String getStatusExercicio() {
        return statusExercicio;
    }

    /**
     * @param statusExercicio the statusExercicio to set
     */
    public void setStatusExercicio(String statusExercicio) {
        this.statusExercicio = statusExercicio;
    }

    /**
     * @return the sincronizaExercicio
     */
    public Integer getSincronizaExercicio() {
        return sincronizaExercicio;
    }

    /**
     * @param sincronizaExercicio the sincronizaExercicio to set
     */
    public void setSincronizaExercicio(Integer sincronizaExercicio) {
        this.sincronizaExercicio = sincronizaExercicio;
    }

    /**
     * @return the avaliacao
     */
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public void setIdAvaliacao(Integer idAvaliacao) {
    }
}
