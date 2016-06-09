/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.model;

import java.util.Date;

/**
 *
 * @author Grazy Martins
 */
public class Avaliacao {
    
    private Integer idAvaliacao;
    private Double pesoPaciente;
    private Double alturaPaciente;
    private Double circunPunhoAvaliacao;
    private Double circunCinturaAvaliacao;
    private Double circunQuadrilAvaliacao;
    private Date dataAvaliacao;
    private Integer metaAvaliacao;
    private String observaoImportanteAvaliacao;
    private Double pesoDesejavelAvaliacao;
    private String objetivoAvaliacao;
    private Integer colesterol;
    private Integer trigliceridios;
    private Integer diabetes;
    private Boolean acompanAvaliacao;
    private String condutaAdotadaAvaliacao;
    private Double qtdAguaAvaliacao;
    private Boolean fumaAvaliacao;
    private String funcIntestinoAvaliacao;
    private String urinaAvaliacao;
    private String localAlimAvaliacao;
    private Boolean praticaExercicioAvaliacao;
    private Integer sincronizaAvaliacao;
    private String statusAvaliacao;
    private Consulta consulta;
    private FrequenciaAlimentar frequenciaAlimentar;
    private MedicamentoSuplemento medicamentoSuplemento;
    private Patologia patologia;

    public Avaliacao() {
    }
    
    /**
     * @return the idAvaliacao
     */
    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    /**
     * @param idAvaliacao the idAvaliacao to set
     */
    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    /**
     * @return the pesoPaciente
     */
    public Double getPesoPaciente() {
        return pesoPaciente;
    }

    /**
     * @param pesoPaciente the pesoPaciente to set
     */
    public void setPesoPaciente(Double pesoPaciente) {
        this.pesoPaciente = pesoPaciente;
    }

    /**
     * @return the alturaPaciente
     */
    public Double getAlturaPaciente() {
        return alturaPaciente;
    }

    /**
     * @param alturaPaciente the alturaPaciente to set
     */
    public void setAlturaPaciente(Double alturaPaciente) {
        this.alturaPaciente = alturaPaciente;
    }

    /**
     * @return the circunPunhoAvaliacao
     */
    public Double getCircunPunhoAvaliacao() {
        return circunPunhoAvaliacao;
    }

    /**
     * @param circunPunhoAvaliacao the circunPunhoAvaliacao to set
     */
    public void setCircunPunhoAvaliacao(Double circunPunhoAvaliacao) {
        this.circunPunhoAvaliacao = circunPunhoAvaliacao;
    }

    /**
     * @return the circunCinturaAvaliacao
     */
    public Double getCircunCinturaAvaliacao() {
        return circunCinturaAvaliacao;
    }

    /**
     * @param circunCinturaAvaliacao the circunCinturaAvaliacao to set
     */
    public void setCircunCinturaAvaliacao(Double circunCinturaAvaliacao) {
        this.circunCinturaAvaliacao = circunCinturaAvaliacao;
    }

    /**
     * @return the circunQuadrilAvaliacao
     */
    public Double getCircunQuadrilAvaliacao() {
        return circunQuadrilAvaliacao;
    }

    /**
     * @param circunQuadrilAvaliacao the circunQuadrilAvaliacao to set
     */
    public void setCircunQuadrilAvaliacao(Double circunQuadrilAvaliacao) {
        this.circunQuadrilAvaliacao = circunQuadrilAvaliacao;
    }

    /**
     * @return the dataAvaliacao
     */
    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    /**
     * @param dataAvaliacao the dataAvaliacao to set
     */
    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    /**
     * @return the metaAvaliacao
     */
    public Integer getMetaAvaliacao() {
        return metaAvaliacao;
    }

    /**
     * @param metaAvaliacao the metaAvaliacao to set
     */
    public void setMetaAvaliacao(Integer metaAvaliacao) {
        this.metaAvaliacao = metaAvaliacao;
    }

    /**
     * @return the observaoImportanteAvaliacao
     */
    public String getObservaoImportanteAvaliacao() {
        return observaoImportanteAvaliacao;
    }

    /**
     * @param observaoImportanteAvaliacao the observaoImportanteAvaliacao to set
     */
    public void setObservaoImportanteAvaliacao(String observaoImportanteAvaliacao) {
        this.observaoImportanteAvaliacao = observaoImportanteAvaliacao;
    }

    /**
     * @return the pesoDesejavelAvaliacao
     */
    public Double getPesoDesejavelAvaliacao() {
        return pesoDesejavelAvaliacao;
    }

    /**
     * @param pesoDesejavelAvaliacao the pesoDesejavelAvaliacao to set
     */
    public void setPesoDesejavelAvaliacao(Double pesoDesejavelAvaliacao) {
        this.pesoDesejavelAvaliacao = pesoDesejavelAvaliacao;
    }

    /**
     * @return the objetivoAvaliacao
     */
    public String getObjetivoAvaliacao() {
        return objetivoAvaliacao;
    }

    /**
     * @param objetivoAvaliacao the objetivoAvaliacao to set
     */
    public void setObjetivoAvaliacao(String objetivoAvaliacao) {
        this.objetivoAvaliacao = objetivoAvaliacao;
    }

    /**
     * @return the colesterol
     */
    public Integer getColesterol() {
        return colesterol;
    }

    /**
     * @param colesterol the colesterol to set
     */
    public void setColesterol(Integer colesterol) {
        this.colesterol = colesterol;
    }

    /**
     * @return the trigliceridios
     */
    public Integer getTrigliceridios() {
        return trigliceridios;
    }

    /**
     * @param trigliceridios the trigliceridios to set
     */
    public void setTrigliceridios(Integer trigliceridios) {
        this.trigliceridios = trigliceridios;
    }

    /**
     * @return the diabetes
     */
    public Integer getDiabetes() {
        return diabetes;
    }

    /**
     * @param diabetes the diabetes to set
     */
    public void setDiabetes(Integer diabetes) {
        this.diabetes = diabetes;
    }

    /**
     * @return the acompanAvaliacao
     */
    public Boolean getAcompanAvaliacao() {
        return acompanAvaliacao;
    }

    /**
     * @param acompanAvaliacao the acompanAvaliacao to set
     */
    public void setAcompanAvaliacao(Boolean acompanAvaliacao) {
        this.acompanAvaliacao = acompanAvaliacao;
    }

    /**
     * @return the condutaAdotadaAvaliacao
     */
    public String getCondutaAdotadaAvaliacao() {
        return condutaAdotadaAvaliacao;
    }

    /**
     * @param condutaAdotadaAvaliacao the condutaAdotadaAvaliacao to set
     */
    public void setCondutaAdotadaAvaliacao(String condutaAdotadaAvaliacao) {
        this.condutaAdotadaAvaliacao = condutaAdotadaAvaliacao;
    }

    /**
     * @return the qtdAguaAvaliacao
     */
    public Double getQtdAguaAvaliacao() {
        return qtdAguaAvaliacao;
    }

    /**
     * @param qtdAguaAvaliacao the qtdAguaAvaliacao to set
     */
    public void setQtdAguaAvaliacao(Double qtdAguaAvaliacao) {
        this.qtdAguaAvaliacao = qtdAguaAvaliacao;
    }

    /**
     * @return the fumaAvaliacao
     */
    public Boolean getFumaAvaliacao() {
        return fumaAvaliacao;
    }

    /**
     * @param fumaAvaliacao the fumaAvaliacao to set
     */
    public void setFumaAvaliacao(Boolean fumaAvaliacao) {
        this.fumaAvaliacao = fumaAvaliacao;
    }

    /**
     * @return the funcIntestinoAvaliacao
     */
    public String getFuncIntestinoAvaliacao() {
        return funcIntestinoAvaliacao;
    }

    /**
     * @param funcIntestinoAvaliacao the funcIntestinoAvaliacao to set
     */
    public void setFuncIntestinoAvaliacao(String funcIntestinoAvaliacao) {
        this.funcIntestinoAvaliacao = funcIntestinoAvaliacao;
    }

    /**
     * @return the urinaAvaliacao
     */
    public String getUrinaAvaliacao() {
        return urinaAvaliacao;
    }

    /**
     * @param urinaAvaliacao the urinaAvaliacao to set
     */
    public void setUrinaAvaliacao(String urinaAvaliacao) {
        this.urinaAvaliacao = urinaAvaliacao;
    }

    /**
     * @return the localAlimAvaliacao
     */
    public String getLocalAlimAvaliacao() {
        return localAlimAvaliacao;
    }

    /**
     * @param localAlimAvaliacao the localAlimAvaliacao to set
     */
    public void setLocalAlimAvaliacao(String localAlimAvaliacao) {
        this.localAlimAvaliacao = localAlimAvaliacao;
    }

    /**
     * @return the praticaExercicioAvaliacao
     */
    public Boolean getPraticaExercicioAvaliacao() {
        return praticaExercicioAvaliacao;
    }

    /**
     * @param praticaExercicioAvaliacao the praticaExercicioAvaliacao to set
     */
    public void setPraticaExercicioAvaliacao(Boolean praticaExercicioAvaliacao) {
        this.praticaExercicioAvaliacao = praticaExercicioAvaliacao;
    }

    /**
     * @return the sincronizaAvaliacao
     */
    public Integer getSincronizaAvaliacao() {
        return sincronizaAvaliacao;
    }

    /**
     * @param sincronizaAvaliacao the sincronizaAvaliacao to set
     */
    public void setSincronizaAvaliacao(Integer sincronizaAvaliacao) {
        this.sincronizaAvaliacao = sincronizaAvaliacao;
    }

    /**
     * @return the statusAvaliacao
     */
    public String getStatusAvaliacao() {
        return statusAvaliacao;
    }

    /**
     * @param statusAvaliacao the statusAvaliacao to set
     */
    public void setStatusAvaliacao(String statusAvaliacao) {
        this.statusAvaliacao = statusAvaliacao;
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

    /**
     * @return the frequenciaAlimentar
     */
    public FrequenciaAlimentar getFrequenciaAlimentar() {
        return frequenciaAlimentar;
    }

    /**
     * @param frequenciaAlimentar the frequenciaAlimentar to set
     */
    public void setFrequenciaAlimentar(FrequenciaAlimentar frequenciaAlimentar) {
        this.frequenciaAlimentar = frequenciaAlimentar;
    }

    /**
     * @return the medicamentoSuplemento
     */
    public MedicamentoSuplemento getMedicamentoSuplemento() {
        return medicamentoSuplemento;
    }

    /**
     * @param medicamentoSuplemento the medicamentoSuplemento to set
     */
    public void setMedicamentoSuplemento(MedicamentoSuplemento medicamentoSuplemento) {
        this.medicamentoSuplemento = medicamentoSuplemento;
    }

    /**
     * @return the patologia
     */
    public Patologia getPatologia() {
        return patologia;
    }

    /**
     * @param patologia the patologia to set
     */
    public void setPatologia(Patologia patologia) {
        this.patologia = patologia;
    }
    
    
}
