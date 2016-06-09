/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.EvolucaoPacienteDAOImpl;
import br.com.projetoestagio.model.EvolucaoPaciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eliez
 */
@WebServlet(name = "CarregarDadosEvolucaoPaciente", urlPatterns = {"/CarregarDadosEvolucaoPaciente"})
public class CarregarDadosEvolucaoPaciente extends HttpServlet {

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
        Integer idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        
        try{
            EvolucaoPacienteDAOImpl dao = new EvolucaoPacienteDAOImpl(); 
            EvolucaoPaciente evolucaoPaciente = new EvolucaoPaciente();
            evolucaoPaciente = (EvolucaoPaciente) dao.carregarDadosEvolucao(idPaciente);
            request.setAttribute("evolucaoPaciente", evolucaoPaciente);
            request.getRequestDispatcher("paciente/indexpaciente.jsp").forward(request, response);
        } catch(Exception ex) {
            System.out.println("Problemas ao carregar dados EvolucoaPaciente! Erro: " + ex.getMessage());
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
