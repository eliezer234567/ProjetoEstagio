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
public class Pessoa {
    private Integer idPessoa;
    private String nomePessoa;
    private String telefonePessoa;
    private String emailPessoa;
    private String senhaPessoa;
    private String statusPessoa;
    private String tipoPessoa;
    private String fotoPessoa;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nomePessoa, String telefonePessoa, String emailPessoa, String senhaPessoa, String statusPessoa, String tipoPessoa, String fotoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefonePessoa = telefonePessoa;
        this.emailPessoa = emailPessoa;
        this.senhaPessoa = senhaPessoa;
        this.statusPessoa = statusPessoa;
        this.tipoPessoa = tipoPessoa;
        this.fotoPessoa = fotoPessoa;
    }

    /**
     * @return the idPessoa
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the nomePessoa
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     * @param nomePessoa the nomePessoa to set
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     * @return the telefonePessoa
     */
    public String getTelefonePessoa() {
        return telefonePessoa;
    }

    /**
     * @param telefonePessoa the telefonePessoa to set
     */
    public void setTelefonePessoa(String telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    /**
     * @return the emailPessoa
     */
    public String getEmailPessoa() {
        return emailPessoa;
    }

    /**
     * @param emailPessoa the emailPessoa to set
     */
    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    /**
     * @return the senhaPessoa
     */
    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    /**
     * @param senhaPessoa the senhaPessoa to set
     */
    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }

    /**
     * @return the statusPessoa
     */
    public String getStatusPessoa() {
        return statusPessoa;
    }

    /**
     * @param statusPessoa the statusPessoa to set
     */
    public void setStatusPessoa(String statusPessoa) {
        this.statusPessoa = statusPessoa;
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the fotoPessoa
     */
    public String getFotoPessoa() {
        return fotoPessoa;
    }

    /**
     * @param fotoPessoa the fotoPessoa to set
     */
    public void setFotoPessoa(String fotoPessoa) {
        this.fotoPessoa = fotoPessoa;
    }
    
    

  


    
    

}
