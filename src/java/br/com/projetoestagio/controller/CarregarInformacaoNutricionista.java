/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.NutricionistaDAOImpl;
import br.com.projetoestagio.DAO.PacienteDAOImpl;
import br.com.projetoestagio.model.Nutricionista;
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
@WebServlet(name = "CarregarInformacaoNutricionista", urlPatterns = {"/CarregarInformacaoNutricionista"})
public class CarregarInformacaoNutricionista extends HttpServlet {

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
        //int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        
        HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");
        
        try{
            //carrega os dados nutricionista
            GenericDAO dao = new NutricionistaDAOImpl();
            Nutricionista nutricionista = new Nutricionista();
            nutricionista = (Nutricionista) dao.carregar(id);
            request.setAttribute("nutricionista", nutricionista);
            request.getRequestDispatcher("nutricionista/perfilnutricionista.jsp").forward(request, response);
    } catch (Exception ex) {
            System.out.println("Problemas ao carregar dados Nutricionista! Erro: " + ex.getMessage());
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
