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
public class Refeicao {

    private Integer idRefeicao;
    private String diaRefeicao;
    private String statusRefeicao;
    private String horaRefeicao;
    private TipoRefeicao tipoRefeicao;
    private Cardapio cardapio;

    public Refeicao() {
    }

    public Refeicao(Integer idRefeicao, String diaRefeicao, String statusRefeicao, String horaRefeicao, TipoRefeicao tipoRefeicao, Cardapio cardapio) {
        this.idRefeicao = idRefeicao;
        this.diaRefeicao = diaRefeicao;
        this.statusRefeicao = statusRefeicao;
        this.horaRefeicao = horaRefeicao;
        this.tipoRefeicao = tipoRefeicao;
        this.cardapio = cardapio;
    }

    /**
     * @return the idRefeicao
     */
    public Integer getIdRefeicao() {
        return idRefeicao;
    }

    /**
     * @param idRefeicao the idRefeicao to set
     */
    public void setIdRefeicao(Integer idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    /**
     * @return the diaRefeicao
     */
    public String getDiaRefeicao() {
        return diaRefeicao;
    }

    /**
     * @param diaRefeicao the diaRefeicao to set
     */
    public void setDiaRefeicao(String diaRefeicao) {
        this.diaRefeicao = diaRefeicao;
    }

    /**
     * @return the statusRefeicao
     */
    public String getStatusRefeicao() {
        return statusRefeicao;
    }

    /**
     * @param statusRefeicao the statusRefeicao to set
     */
    public void setStatusRefeicao(String statusRefeicao) {
        this.statusRefeicao = statusRefeicao;
    }

    /**
     * @return the horaRefeicao
     */
    public String getHoraRefeicao() {
        return horaRefeicao;
    }

    /**
     * @param horaRefeicao the horaRefeicao to set
     */
    public void setHoraRefeicao(String horaRefeicao) {
        this.horaRefeicao = horaRefeicao;
    }

    /**
     * @return the tipoRefeicao
     */
    public TipoRefeicao getTipoRefeicao() {
        return tipoRefeicao;
    }

    /**
     * @param tipoRefeicao the tipoRefeicao to set
     */
    public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    /**
     * @return the cardapio
     */
    public Cardapio getCardapio() {
        return cardapio;
    }

    /**
     * @param cardapio the cardapio to set
     */
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
    
    

}
