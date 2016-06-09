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
public class TipoRefeicao {

    private Integer idTipoRefeicao;
    private String tipoRefeicao;

    public TipoRefeicao() {
    }

    public TipoRefeicao(Integer idTipoRefeicao, String tipoRefeicao) {
        this.idTipoRefeicao = idTipoRefeicao;
        this.tipoRefeicao = tipoRefeicao;
    }

    /**
     * @return the idTipoRefeicao
     */
    public Integer getIdTipoRefeicao() {
        return idTipoRefeicao;
    }

    /**
     * @param idTipoRefeicao the idTipoRefeicao to set
     */
    public void setIdTipoRefeicao(Integer idTipoRefeicao) {
        this.idTipoRefeicao = idTipoRefeicao;
    }

    /**
     * @return the tipoRefeicao
     */
    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    /**
     * @param tipoRefeicao the tipoRefeicao to set
     */
    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }
    
    

}
