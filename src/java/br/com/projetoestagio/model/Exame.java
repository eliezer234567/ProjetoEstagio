/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

import java.util.Date;

/**
 *
 * @author Eliezer
 */
public class Exame {
    private Integer idExame;
    private String nomeExame;
    private String imagemExame;
    private Date dataExame;
    private String statusExame;
    private Consulta consulta;
    private String sincronizaExame;       

    public Exame() {
    }

    public Exame(Integer idExame, String nomeExame, String imagemExame, Date dataExame, String statusExame, Consulta consulta, String sincronizaExame) {
        this.idExame = idExame;
        this.nomeExame = nomeExame;
        this.imagemExame = imagemExame;
        this.dataExame = dataExame;
        this.statusExame = statusExame;
        this.consulta = consulta;
        this.sincronizaExame = sincronizaExame;
    }

    /**
     * @return the idExame
     */
    public Integer getIdExame() {
        return idExame;
    }

    /**
     * @param idExame the idExame to set
     */
    public void setIdExame(Integer idExame) {
        this.idExame = idExame;
    }

    /**
     * @return the nomeExame
     */
    public String getNomeExame() {
        return nomeExame;
    }

    /**
     * @param nomeExame the nomeExame to set
     */
    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    /**
     * @return the imagemExame
     */
    public String getImagemExame() {
        return imagemExame;
    }

    /**
     * @param imagemExame the imagemExame to set
     */
    public void setImagemExame(String imagemExame) {
        this.imagemExame = imagemExame;
    }

    /**
     * @return the dataExame
     */
    public Date getDataExame() {
        return dataExame;
    }

    /**
     * @param dataExame the dataExame to set
     */
    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    /**
     * @return the statusExame
     */
    public String getStatusExame() {
        return statusExame;
    }

    /**
     * @param statusExame the statusExame to set
     */
    public void setStatusExame(String statusExame) {
        this.statusExame = statusExame;
    }

    /**
     * @return the consulta
     */
    public Consulta getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @return the sincronizaExame
     */
    public String getSincronizaExame() {
        return sincronizaExame;
    }

    /**
     * @param sincronizaExame the sincronizaExame to set
     */
    public void setSincronizaExame(String sincronizaExame) {
        this.sincronizaExame = sincronizaExame;
    }
    
    
}
