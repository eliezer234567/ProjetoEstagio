/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.ConsultaDAOImpl;
import br.com.projetoestagio.model.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eliez
 */
@WebServlet(name = "CarregarConsultaRealizada", urlPatterns = {"/CarregarConsultaRealizada"})
public class CarregarConsultaRealizada extends HttpServlet {

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
        
        int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
//        int idNutricionista = Integer.parseInt(request.getParameter("idNutricionista"));
        
            HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");
        try {
            
          
            //carrega os dados da consulta que foi realizada e redireciona para o servlet ListarConsultasRealizadas
            //lista pelo idPessoa através da sessão
            ConsultaDAOImpl dao = new ConsultaDAOImpl();
            Consulta consulta = new Consulta();
            consulta = (Consulta) dao.carregarDataHoraConsulta(idConsulta);
            request.setAttribute("consulta", consulta);
            String script="<script>$('#ModalCarregarConsulta').modal('show');</script>";
            request.setAttribute("script", script);
            request.getRequestDispatcher("ListarConsultasRealizadas?idPessoa="+id).forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar dados para a consulta realizada! Erro: " + ex.getMessage());
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
