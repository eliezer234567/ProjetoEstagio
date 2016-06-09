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
public class Nutricionista extends Pessoa {
    private Integer idNutricionista;
    private Integer crnNutricionista;

    public Nutricionista() {
    }

    public Nutricionista(Integer idNutricionista, Integer crnNutricionista, Integer idPessoa, String nomePessoa, String telefonePessoa, String emailPessoa, String senhaPessoa, String statusPessoa, String tipoPessoa, String fotoPessoa) {
        super(idPessoa, nomePessoa, telefonePessoa, emailPessoa, senhaPessoa, statusPessoa, tipoPessoa, fotoPessoa);
        this.idNutricionista = idNutricionista;
        this.crnNutricionista = crnNutricionista;
    }

    

    /**
     * @return the idNutricionista
     */
    public Integer getIdNutricionista() {
        return idNutricionista;
    }

    /**
     * @param idNutricionista the idNutricionista to set
     */
    public void setIdNutricionista(Integer idNutricionista) {
        this.idNutricionista = idNutricionista;
    }

    /**
     * @return the crnNutricionista
     */
    public Integer getCrnNutricionista() {
        return crnNutricionista;
    }

    /**
     * @param crnNutricionista the crnNutricionista to set
     */
    public void setCrnNutricionista(Integer crnNutricionista) {
        this.crnNutricionista = crnNutricionista;
    }
    
    
    
    
    
    
}
