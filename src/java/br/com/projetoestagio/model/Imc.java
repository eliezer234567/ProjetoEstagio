/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

/**
 *
 * @author eliez
 */
public class Imc {
    private Double altura;
    private Double peso;
    private String sexo;
    private Double resultado;

    public Imc() {
    }

    public Imc(Double altura, Double peso, String sexo, Double resultado) {
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.resultado = resultado;
    }

    /**
     * @return the altura
     */
    public Double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the resultado
     */
    public Double getResultado() {
        return resultado;
    }
    /**
     * @param resultado the resultado to set
     */
    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    //metodoo para calcular o resultado
    public Double resultado(){
        resultado = peso/(altura*altura);
        return resultado;
    }
    
    
    
}
