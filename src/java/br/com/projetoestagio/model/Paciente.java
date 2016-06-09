/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Leticia
 */
public class Paciente extends Pessoa {
    private Integer idPaciente;
    private Date dataNascimentoPaciente;
    private String sexoPaciente;
    private Integer idadePaciente;

    public Paciente() {
    }

    public Paciente(Integer idPaciente, Date dataNascimentoPaciente, String sexoPaciente, Integer idadePaciente, Integer idPessoa, String nomePessoa, String telefonePessoa, String emailPessoa, String senhaPessoa, String statusPessoa, String tipoPessoa, String fotoPessoa) {
        super(idPessoa, nomePessoa, telefonePessoa, emailPessoa, senhaPessoa, statusPessoa, tipoPessoa, fotoPessoa);
        this.idPaciente = idPaciente;
        this.dataNascimentoPaciente = dataNascimentoPaciente;
        this.sexoPaciente = sexoPaciente;
        this.idadePaciente = idadePaciente;
    }

    /**
     * @return the idPaciente
     */
    public Integer getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the dataNascimentoPaciente
     */
    public Date getDataNascimentoPaciente() {
        return dataNascimentoPaciente;
    }

    /**
     * @param dataNascimentoPaciente the dataNascimentoPaciente to set
     */
    public void setDataNascimentoPaciente(Date dataNascimentoPaciente) {
        this.dataNascimentoPaciente = dataNascimentoPaciente;
    }

    /**
     * @return the sexoPaciente
     */
    public String getSexoPaciente() {
        return sexoPaciente;
    }

    /**
     * @param sexoPaciente the sexoPaciente to set
     */
    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    /**
     * @return the idadePaciente
     */
    public Integer getIdadePaciente() {
        return idadePaciente;
    }

    /**
     * @param idadePaciente the idadePaciente to set
     */
    public void setIdadePaciente(Integer idadePaciente) {
        this.idadePaciente = idadePaciente;
    } 
}
