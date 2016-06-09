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
public class AlimentoRefeicao {

    private Integer idAlimentoRefeicao;
    private Double quantidadeAlimentoRefeicao;
    private String tipoMedidaAlimentoRefeicao;
    private Alimento alimento;
    private Refeicao refeicao;

    public AlimentoRefeicao() {
    }

    public AlimentoRefeicao(Integer idAlimentoRefeicao, Double quantidadeAlimentoRefeicao, String tipoMedidaAlimentoRefeicao, Alimento alimento, Refeicao refeicao) {
        this.idAlimentoRefeicao = idAlimentoRefeicao;
        this.quantidadeAlimentoRefeicao = quantidadeAlimentoRefeicao;
        this.tipoMedidaAlimentoRefeicao = tipoMedidaAlimentoRefeicao;
        this.alimento = alimento;
        this.refeicao = refeicao;
    }

    /**
     * @return the idAlimentoRefeicao
     */
    public Integer getIdAlimentoRefeicao() {
        return idAlimentoRefeicao;
    }

    /**
     * @param idAlimentoRefeicao the idAlimentoRefeicao to set
     */
    public void setIdAlimentoRefeicao(Integer idAlimentoRefeicao) {
        this.idAlimentoRefeicao = idAlimentoRefeicao;
    }

    /**
     * @return the quantidadeAlimentoRefeicao
     */
    public Double getQuantidadeAlimentoRefeicao() {
        return quantidadeAlimentoRefeicao;
    }

    /**
     * @param quantidadeAlimentoRefeicao the quantidadeAlimentoRefeicao to set
     */
    public void setQuantidadeAlimentoRefeicao(Double quantidadeAlimentoRefeicao) {
        this.quantidadeAlimentoRefeicao = quantidadeAlimentoRefeicao;
    }

    /**
     * @return the tipoMedidaAlimentoRefeicao
     */
    public String getTipoMedidaAlimentoRefeicao() {
        return tipoMedidaAlimentoRefeicao;
    }

    /**
     * @param tipoMedidaAlimentoRefeicao the tipoMedidaAlimentoRefeicao to set
     */
    public void setTipoMedidaAlimentoRefeicao(String tipoMedidaAlimentoRefeicao) {
        this.tipoMedidaAlimentoRefeicao = tipoMedidaAlimentoRefeicao;
    }

    /**
     * @return the alimento
     */
    public Alimento getAlimento() {
        return alimento;
    }

    /**
     * @param alimento the alimento to set
     */
    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    /**
     * @return the refeicao
     */
    public Refeicao getRefeicao() {
        return refeicao;
    }

    /**
     * @param refeicao the refeicao to set
     */
    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }
    
    

}
