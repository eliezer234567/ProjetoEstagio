/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.AvaliacaoDAOImpl;
import br.com.projetoestagio.model.Avaliacao;
import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.FrequenciaAlimentar;
import static br.com.projetoestagio.util.Conversoes.converterData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grazy
 */
@WebServlet(name = "CadastrarAvaliacao", urlPatterns = {"/CadastrarAvaliacao"})
public class CadastrarAvaliacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        Date dataConsulta = converterData(request.getParameter("data_avaliacao").replace("-", "/"));
        Integer metaavaliacao = Integer.parseInt(request.getParameter("meta_avaliacao"));
        String observacao_importante_avaliacao = request.getParameter("observacao_importante_avaliacao");
        Double peso_desejavel_avaliacao = Double.parseDouble(request.getParameter("peso_desejavel_avaliacao"));
        String objetivo_avaliacao = request.getParameter("objetivo_avaliacao");
        Integer colesterol = Integer.parseInt(request.getParameter("colesterol"));
        Integer triglicerideos = Integer.parseInt(request.getParameter("triglicerideos"));
        Integer diabetes = Integer.parseInt(request.getParameter("diabetes"));
        
        
        Boolean acompan_avaliacao = Boolean.parseBoolean(request.getParameter("acompan_avaliacao"));
        String conduta_adotada_avaliacao = request.getParameter("conduta_adotada_avaliacao");
        Double qtd_agua_avaliacao = Double.parseDouble(request.getParameter("qtd_agua_avaliacao"));
        Boolean fumaavaliacao = Boolean.parseBoolean("fumaavaliacao");
        String func_intestino_avaliacao = request.getParameter("func_intestino_avaliacao");
        String urina_avaliacao = request.getParameter("urina_avaliacao");
        String local_alim_avaliacao = request.getParameter("local_alim_avaliacao");
        
        Integer id_consulta = Integer.parseInt(request.getParameter("id_consulta"));
        Integer id_frequencia_alimentar = Integer.parseInt(request.getParameter("id_frequencia_alimentar"));
        
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(id_consulta);
        
        FrequenciaAlimentar fqAlimentar = new FrequenciaAlimentar();
        fqAlimentar.setIdFrequenciaAlimentar(2);
        
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDataAvaliacao(dataConsulta);
        avaliacao.setMetaAvaliacao(metaavaliacao);
        avaliacao.setObservaoImportanteAvaliacao(observacao_importante_avaliacao);
        avaliacao.setPesoDesejavelAvaliacao(peso_desejavel_avaliacao);
        avaliacao.setObjetivoAvaliacao(objetivo_avaliacao);
        avaliacao.setColesterol(colesterol);
        avaliacao.setTrigliceridios(triglicerideos);
        avaliacao.setDiabetes(diabetes);
        avaliacao.setAcompanAvaliacao(acompan_avaliacao);
        avaliacao.setCondutaAdotadaAvaliacao(conduta_adotada_avaliacao);
        avaliacao.setQtdAguaAvaliacao(qtd_agua_avaliacao);
        avaliacao.setFumaAvaliacao(fumaavaliacao);
        avaliacao.setFuncIntestinoAvaliacao(func_intestino_avaliacao);
        avaliacao.setUrinaAvaliacao(urina_avaliacao);
        avaliacao.setLocalAlimAvaliacao(local_alim_avaliacao);
        avaliacao.setPraticaExercicioAvaliacao(Boolean.FALSE);
        
        avaliacao.setConsulta(consulta);
        avaliacao.setFrequenciaAlimentar(fqAlimentar);
        
        Integer id = null;
        
        AvaliacaoDAOImpl daoAvaliacao = new AvaliacaoDAOImpl();
        try {
            id = daoAvaliacao.cadastrar(avaliacao);
            request.setAttribute("idAvaliacao", id);
            request.getRequestDispatcher("DadosAvaliacao").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar Avalicao. Erro: "+e.getMessage());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
