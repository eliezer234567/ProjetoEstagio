/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

/**
 *
 * @author princesinha
 */
public class Patologia {
    

    private Integer idPatologia; 
    private String nomePatologia; 
    private String descricaoPatologia;  
    private String historicofamiliaPatologia;
    private String statusPatologia; 

    public Patologia() {
    }

    public Patologia(Integer idPatologia, String nomePatologia, String descricaoPatologia, String historicofamiliaPatologia, String statusPatologia) {
        this.idPatologia = idPatologia;
        this.nomePatologia = nomePatologia;
        this.descricaoPatologia = descricaoPatologia;
        this.historicofamiliaPatologia = historicofamiliaPatologia;
        this.statusPatologia = statusPatologia;
    }

    public Integer getIdPatologia() {
        return idPatologia;
    }

    public void setIdPatologia(Integer idPatologia) {
        this.idPatologia = idPatologia;
    }

    public String getNomePatologia() {
        return nomePatologia;
    }

    public void setNomePatologia(String nomePatologia) {
        this.nomePatologia = nomePatologia;
    }

    public String getDescricaoPatologia() {
        return descricaoPatologia;
    }

    public void setDescricaoPatologia(String descricaoPatologia) {
        this.descricaoPatologia = descricaoPatologia;
    }

    public String getHistoricofamiliaPatologia() {
        return historicofamiliaPatologia;
    }

    public void setHistoricofamiliaPatologia(String historicofamiliaPatologia) {
        this.historicofamiliaPatologia = historicofamiliaPatologia;
    }

    public String getStatusPatologia() {
        return statusPatologia;
    }

    public void setStatusPatologia(String statusPatologia) {
        this.statusPatologia = statusPatologia;
    }

}