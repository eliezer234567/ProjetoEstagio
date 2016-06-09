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
public class MedicamentoSuplemento {
    
    private Integer idMedicamentoSuplemento;
    private String nomeMedicamentoSuplemento;
    private String tipoMedicamentoSuplemento;
    private Integer sincronizaMedicamentoSuplemento;
    private String statusMedicamentoSuplemento;

    public MedicamentoSuplemento() {
    }

    public MedicamentoSuplemento(Integer idMedicamentoSuplemento, String nomeMedicamentoSuplemento, String tipoMedicamentoSuplemento, Integer sincronizaMedicamentoSuplemento, String statusMedicamentoSuplemento) {
        this.idMedicamentoSuplemento = idMedicamentoSuplemento;
        this.nomeMedicamentoSuplemento = nomeMedicamentoSuplemento;
        this.tipoMedicamentoSuplemento = tipoMedicamentoSuplemento;
        this.sincronizaMedicamentoSuplemento = sincronizaMedicamentoSuplemento;
        this.statusMedicamentoSuplemento = statusMedicamentoSuplemento;
    }

    /**
     * @return the idMedicamentoSuplemento
     */
    public Integer getIdMedicamentoSuplemento() {
        return idMedicamentoSuplemento;
    }

    /**
     * @param idMedicamentoSuplemento the idMedicamentoSuplemento to set
     */
    public void setIdMedicamentoSuplemento(Integer idMedicamentoSuplemento) {
        this.idMedicamentoSuplemento = idMedicamentoSuplemento;
    }

    /**
     * @return the nomeMedicamentoSuplemento
     */
    public String getNomeMedicamentoSuplemento() {
        return nomeMedicamentoSuplemento;
    }

    /**
     * @param nomeMedicamentoSuplemento the nomeMedicamentoSuplemento to set
     */
    public void setNomeMedicamentoSuplemento(String nomeMedicamentoSuplemento) {
        this.nomeMedicamentoSuplemento = nomeMedicamentoSuplemento;
    }

    /**
     * @return the tipoMedicamentoSuplemento
     */
    public String getTipoMedicamentoSuplemento() {
        return tipoMedicamentoSuplemento;
    }

    /**
     * @param tipoMedicamentoSuplemento the tipoMedicamentoSuplemento to set
     */
    public void setTipoMedicamentoSuplemento(String tipoMedicamentoSuplemento) {
        this.tipoMedicamentoSuplemento = tipoMedicamentoSuplemento;
    }

    /**
     * @return the sincronizaMedicamentoSuplemento
     */
    public Integer getSincronizaMedicamentoSuplemento() {
        return sincronizaMedicamentoSuplemento;
    }

    /**
     * @param sincronizaMedicamentoSuplemento the sincronizaMedicamentoSuplemento to set
     */
    public void setSincronizaMedicamentoSuplemento(Integer sincronizaMedicamentoSuplemento) {
        this.sincronizaMedicamentoSuplemento = sincronizaMedicamentoSuplemento;
    }

    /**
     * @return the statusMedicamentoSuplemento
     */
    public String getStatusMedicamentoSuplemento() {
        return statusMedicamentoSuplemento;
    }

    /**
     * @param statusMedicamentoSuplemento the statusMedicamentoSuplemento to set
     */
    public void setStatusMedicamentoSuplemento(String statusMedicamentoSuplemento) {
        this.statusMedicamentoSuplemento = statusMedicamentoSuplemento;
    }
    
}
