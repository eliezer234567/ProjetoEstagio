/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

import java.util.Date;

/**
 *
 * @author Eliezer.L
 */
public class Consulta {
    private Integer idConsulta;
    private Date dataConsulta;
    private String horaConsulta;
    private String condutaNutricionalConsulta;
    private String obsConsulta;
    private String statusConsulta;
    private Paciente paciente;
    private Nutricionista nutricionista;


    public Consulta() {
    }

    public Consulta(Integer idConsulta, Date dataConsulta, String horaConsulta, String condutaNutricionalConsulta, String obsConsulta,String statusConsulta, Paciente paciente, Nutricionista nutricionista) {
        this.idConsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.condutaNutricionalConsulta = condutaNutricionalConsulta;
        this.obsConsulta = obsConsulta;
        this.statusConsulta = statusConsulta;
        this.paciente = paciente;
        this.nutricionista = nutricionista;
    }

    /**
     * @return the idConsulta
     */
    public Integer getIdConsulta() {
        return idConsulta;
    }

    /**
     * @param idConsulta the idConsulta to set
     */
    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    /**
     * @return the dataConsulta
     */
    public Date getDataConsulta() {
        return dataConsulta;
    }

    /**
     * @param dataConsulta the dataConsulta to set
     */
    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * @return the horaConsulta
     */
    public String getHoraConsulta() {
        return horaConsulta;
    }

    /**
     * @param horaConsulta the horaConsulta to set
     */
    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    /**
     * @return the condutaNutricionalConsulta
     */
    public String getCondutaNutricionalConsulta() {
        return condutaNutricionalConsulta;
    }

    /**
     * @param condutaNutricionalConsulta the condutaNutricionalConsulta to set
     */
    public void setCondutaNutricionalConsulta(String condutaNutricionalConsulta) {
        this.condutaNutricionalConsulta = condutaNutricionalConsulta;
    }

    /**
     * @return the obsConsulta
     */
    public String getObsConsulta() {
        return obsConsulta;
    }

    /**
     * @param obsConsulta the obsConsulta to set
     */
    public void setObsConsulta(String obsConsulta) {
        this.obsConsulta = obsConsulta;
    }

    /**
     * @return the statusConsulta
     */
    public String getStatusConsulta() {
        return statusConsulta;
    }

    /**
     * @param statusConsulta the statusConsulta to set
     */
    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
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

    /**
     * @return the nutricionista
     */
    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    /**
     * @param nutricionista the nutricionista to set
     */
    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    
    
}
