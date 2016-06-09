/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

import java.util.Date;

/**
 *
 * @author Leticia
 */
public class Cardapio {
    private Integer idCardapio;
    private String tipoCardapio;
    private String nomeCardapio;
    private Date dataInicioCardapio;
    private Date dataFinalCardapio;
    private String observacaoCardapio;
    private String statusCardapio;
    private String intervaloCardapio;
    private Paciente paciente;

    public Cardapio() {
    }

    public Cardapio(Integer idCardapio, String tipoCardapio, String nomeCardapio, Date dataInicioCardapio, Date dataFinalCardapio, String observacaoCardapio, String statusCardapio, String intervaloCardapio, Paciente paciente) {
        this.idCardapio = idCardapio;
        this.tipoCardapio = tipoCardapio;
        this.nomeCardapio = nomeCardapio;
        this.dataInicioCardapio = dataInicioCardapio;
        this.dataFinalCardapio = dataFinalCardapio;
        this.observacaoCardapio = observacaoCardapio;
        this.statusCardapio = statusCardapio;
        this.intervaloCardapio = intervaloCardapio;
        this.paciente = paciente;
    }

    /**
     * @return the idCardapio
     */
    public Integer getIdCardapio() {
        return idCardapio;
    }

    /**
     * @param idCardapio the idCardapio to set
     */
    public void setIdCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    /**
     * @return the tipoCardapio
     */
    public String getTipoCardapio() {
        return tipoCardapio;
    }

    /**
     * @param tipoCardapio the tipoCardapio to set
     */
    public void setTipoCardapio(String tipoCardapio) {
        this.tipoCardapio = tipoCardapio;
    }

    /**
     * @return the nomeCardapio
     */
    public String getNomeCardapio() {
        return nomeCardapio;
    }

    /**
     * @param nomeCardapio the nomeCardapio to set
     */
    public void setNomeCardapio(String nomeCardapio) {
        this.nomeCardapio = nomeCardapio;
    }

    /**
     * @return the dataInicioCardapio
     */
    public Date getDataInicioCardapio() {
        return dataInicioCardapio;
    }

    /**
     * @param dataInicioCardapio the dataInicioCardapio to set
     */
    public void setDataInicioCardapio(Date dataInicioCardapio) {
        this.dataInicioCardapio = dataInicioCardapio;
    }

    /**
     * @return the dataFinalCardapio
     */
    public Date getDataFinalCardapio() {
        return dataFinalCardapio;
    }

    /**
     * @param dataFinalCardapio the dataFinalCardapio to set
     */
    public void setDataFinalCardapio(Date dataFinalCardapio) {
        this.dataFinalCardapio = dataFinalCardapio;
    }

    /**
     * @return the observacaoCardapio
     */
    public String getObservacaoCardapio() {
        return observacaoCardapio;
    }

    /**
     * @param observacaoCardapio the observacaoCardapio to set
     */
    public void setObservacaoCardapio(String observacaoCardapio) {
        this.observacaoCardapio = observacaoCardapio;
    }

    /**
     * @return the statusCardapio
     */
    public String getStatusCardapio() {
        return statusCardapio;
    }

    /**
     * @param statusCardapio the statusCardapio to set
     */
    public void setStatusCardapio(String statusCardapio) {
        this.statusCardapio = statusCardapio;
    }

    /**
     * @return the intervaloCardapio
     */
    public String getIntervaloCardapio() {
        return intervaloCardapio;
    }

    /**
     * @param intervaloCardapio the intervaloCardapio to set
     */
    public void setIntervaloCardapio(String intervaloCardapio) {
        this.intervaloCardapio = intervaloCardapio;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    
 
    
    
    
    
    
}
