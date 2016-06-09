/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

/**
 *
 * @author Grazy
 */
public class AvaliacaoPatologia {
    
    private Integer id_avaliacao_patologia;
    private String status_avaliacao_patologia;
    private Avaliacao avaliacao;
    private Patologia patologia;

    public Integer getId_avaliacao_patologia() {
        return id_avaliacao_patologia;
    }

    public void setId_avaliacao_patologia(Integer id_avaliacao_patologia) {
        this.id_avaliacao_patologia = id_avaliacao_patologia;
    }

    public String getStatus_avaliacao_patologia() {
        return status_avaliacao_patologia;
    }

    public void setStatus_avaliacao_patologia(String status_avaliacao_patologia) {
        this.status_avaliacao_patologia = status_avaliacao_patologia;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Patologia getPatologia() {
        return patologia;
    }

    public void setPatologia(Patologia patologia) {
        this.patologia = patologia;
    }
    
    
    
}    