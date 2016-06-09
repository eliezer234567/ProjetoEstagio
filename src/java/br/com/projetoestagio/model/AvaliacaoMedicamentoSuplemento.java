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
public class AvaliacaoMedicamentoSuplemento {
    
    private Integer id_avaliacao_medicamento_suplemento;
    private String dose_avaliacao_medicamento_suplemento;
    private String frequencia_avaliacao_medicamento_suplemento;
    private String status_avaliacao_medicamento_suplemento;
    private Avaliacao avaliacao;
    private MedicamentoSuplemento medicamentoSuplemento;

    /**
     * @return the id_avaliacao_medicamento_suplemento
     */
    public Integer getId_avaliacao_medicamento_suplemento() {
        return id_avaliacao_medicamento_suplemento;
    }

    /**
     * @param id_avaliacao_medicamento_suplemento the id_avaliacao_medicamento_suplemento to set
     */
    public void setId_avaliacao_medicamento_suplemento(Integer id_avaliacao_medicamento_suplemento) {
        this.id_avaliacao_medicamento_suplemento = id_avaliacao_medicamento_suplemento;
    }

    /**
     * @return the dose_avaliacao_medicamento_suplemento
     */
    public String getDose_avaliacao_medicamento_suplemento() {
        return dose_avaliacao_medicamento_suplemento;
    }

    /**
     * @param dose_avaliacao_medicamento_suplemento the dose_avaliacao_medicamento_suplemento to set
     */
    public void setDose_avaliacao_medicamento_suplemento(String dose_avaliacao_medicamento_suplemento) {
        this.dose_avaliacao_medicamento_suplemento = dose_avaliacao_medicamento_suplemento;
    }

    /**
     * @return the frequencia_avaliacao_medicamento_suplemento
     */
    public String getFrequencia_avaliacao_medicamento_suplemento() {
        return frequencia_avaliacao_medicamento_suplemento;
    }

    /**
     * @param frequencia_avaliacao_medicamento_suplemento the frequencia_avaliacao_medicamento_suplemento to set
     */
    public void setFrequencia_avaliacao_medicamento_suplemento(String frequencia_avaliacao_medicamento_suplemento) {
        this.frequencia_avaliacao_medicamento_suplemento = frequencia_avaliacao_medicamento_suplemento;
    }

    /**
     * @return the status_avaliacao_medicamento_suplemento
     */
    public String getStatus_avaliacao_medicamento_suplemento() {
        return status_avaliacao_medicamento_suplemento;
    }

    /**
     * @param status_avaliacao_medicamento_suplemento the status_avaliacao_medicamento_suplemento to set
     */
    public void setStatus_avaliacao_medicamento_suplemento(String status_avaliacao_medicamento_suplemento) {
        this.status_avaliacao_medicamento_suplemento = status_avaliacao_medicamento_suplemento;
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

    /**
     * @return the medicamentoSuplemento
     */
    public MedicamentoSuplemento getMedicamentoSuplemento() {
        return medicamentoSuplemento;
    }

    /**
     * @param medicamentoSuplemento the medicamentoSuplemento to set
     */
    public void setMedicamentoSuplemento(MedicamentoSuplemento medicamentoSuplemento) {
        this.medicamentoSuplemento = medicamentoSuplemento;
    }
    
    
    
}
