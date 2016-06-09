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
public class EvolucaoPaciente {
    private Integer idEvolucaoPaciente;
    private Double pesoEvolucaoPaciente;
    private Double alturaEvolucaoPaciente;
    private Double circunPunhoEvolucaoPaciente;
    private Double circunCinturaEvolucaoPaciente;
    private Double circunQuadrilEvolucaoPaciente;
    private Double dobrasCutaneasEvolucaoPaciente;
    private Consulta consulta;

    public EvolucaoPaciente() {
    }

    public EvolucaoPaciente(Integer idEvolucaoPaciente, Double pesoEvolucaoPaciente, Double alturaEvolucaoPaciente, Double circunPunhoEvolucaoPaciente, Double circunCinturaEvolucaoPaciente, Double circunQuadrilEvolucaoPaciente, Double dobrasCutaneasEvolucaoPaciente, Consulta consulta) {
        this.idEvolucaoPaciente = idEvolucaoPaciente;
        this.pesoEvolucaoPaciente = pesoEvolucaoPaciente;
        this.alturaEvolucaoPaciente = alturaEvolucaoPaciente;
        this.circunPunhoEvolucaoPaciente = circunPunhoEvolucaoPaciente;
        this.circunCinturaEvolucaoPaciente = circunCinturaEvolucaoPaciente;
        this.circunQuadrilEvolucaoPaciente = circunQuadrilEvolucaoPaciente;
        this.dobrasCutaneasEvolucaoPaciente = dobrasCutaneasEvolucaoPaciente;
        this.consulta = consulta;
    }

    /**
     * @return the idEvolucaoPaciente
     */
    public Integer getIdEvolucaoPaciente() {
        return idEvolucaoPaciente;
    }

    /**
     * @param idEvolucaoPaciente the idEvolucaoPaciente to set
     */
    public void setIdEvolucaoPaciente(Integer idEvolucaoPaciente) {
        this.idEvolucaoPaciente = idEvolucaoPaciente;
    }

    /**
     * @return the pesoEvolucaoPaciente
     */
    public Double getPesoEvolucaoPaciente() {
        return pesoEvolucaoPaciente;
    }

    /**
     * @param pesoEvolucaoPaciente the pesoEvolucaoPaciente to set
     */
    public void setPesoEvolucaoPaciente(Double pesoEvolucaoPaciente) {
        this.pesoEvolucaoPaciente = pesoEvolucaoPaciente;
    }

    /**
     * @return the alturaEvolucaoPaciente
     */
    public Double getAlturaEvolucaoPaciente() {
        return alturaEvolucaoPaciente;
    }

    /**
     * @param alturaEvolucaoPaciente the alturaEvolucaoPaciente to set
     */
    public void setAlturaEvolucaoPaciente(Double alturaEvolucaoPaciente) {
        this.alturaEvolucaoPaciente = alturaEvolucaoPaciente;
    }

    /**
     * @return the circunPunhoEvolucaoPaciente
     */
    public Double getCircunPunhoEvolucaoPaciente() {
        return circunPunhoEvolucaoPaciente;
    }

    /**
     * @param circunPunhoEvolucaoPaciente the circunPunhoEvolucaoPaciente to set
     */
    public void setCircunPunhoEvolucaoPaciente(Double circunPunhoEvolucaoPaciente) {
        this.circunPunhoEvolucaoPaciente = circunPunhoEvolucaoPaciente;
    }

    /**
     * @return the circunCinturaEvolucaoPaciente
     */
    public Double getCircunCinturaEvolucaoPaciente() {
        return circunCinturaEvolucaoPaciente;
    }

    /**
     * @param circunCinturaEvolucaoPaciente the circunCinturaEvolucaoPaciente to set
     */
    public void setCircunCinturaEvolucaoPaciente(Double circunCinturaEvolucaoPaciente) {
        this.circunCinturaEvolucaoPaciente = circunCinturaEvolucaoPaciente;
    }

    /**
     * @return the circunQuadrilEvolucaoPaciente
     */
    public Double getCircunQuadrilEvolucaoPaciente() {
        return circunQuadrilEvolucaoPaciente;
    }

    /**
     * @param circunQuadrilEvolucaoPaciente the circunQuadrilEvolucaoPaciente to set
     */
    public void setCircunQuadrilEvolucaoPaciente(Double circunQuadrilEvolucaoPaciente) {
        this.circunQuadrilEvolucaoPaciente = circunQuadrilEvolucaoPaciente;
    }

    /**
     * @return the dobrasCutaneasEvolucaoPaciente
     */
    public Double getDobrasCutaneasEvolucaoPaciente() {
        return dobrasCutaneasEvolucaoPaciente;
    }

    /**
     * @param dobrasCutaneasEvolucaoPaciente the dobrasCutaneasEvolucaoPaciente to set
     */
    public void setDobrasCutaneasEvolucaoPaciente(Double dobrasCutaneasEvolucaoPaciente) {
        this.dobrasCutaneasEvolucaoPaciente = dobrasCutaneasEvolucaoPaciente;
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
    
    

   
    
}
