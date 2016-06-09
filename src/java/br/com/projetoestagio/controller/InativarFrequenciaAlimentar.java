/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.FrequenciaAlimentarDAOImpl;
import br.com.projetoestagio.model.FrequenciaAlimentar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna Nobre
 */
@WebServlet(name = "InativarFrequenciaAlimentar", urlPatterns = {"/InativarFrequenciaAlimentar"})
public class InativarFrequenciaAlimentar extends HttpServlet {

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
            throws ServletException, IOException {
        
        Integer idFrequenciaAlimentar = Integer.parseInt(request.getParameter("idFrequenciaAlimentar"));
        String statusFrequenciaAlimentar = request.getParameter("status");

        FrequenciaAlimentar frequenciaalimentar = new FrequenciaAlimentar();
        frequenciaalimentar.setIdFrequenciaAlimentar(idFrequenciaAlimentar);
        frequenciaalimentar.setStatusFrequenciaAlimentar(statusFrequenciaAlimentar);
        
        try {
            FrequenciaAlimentarDAOImpl dao = new FrequenciaAlimentarDAOImpl();
            dao.inativar(frequenciaalimentar);
            request.getRequestDispatcher("ListarFrequenciaAlimentar").forward(request, response);
        }
        catch (Exception ex) 
        {
            System.out.println("Problemas no Servlet ao Inativar FrequenciaAlimentar! Erro: " + ex.getMessage());
            ex.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
