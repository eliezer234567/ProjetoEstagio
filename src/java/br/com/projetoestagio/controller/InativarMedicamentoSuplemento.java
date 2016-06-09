/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.MedicamentoSuplementoDAOImpl;
import br.com.projetoestagio.model.MedicamentoSuplemento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grazy Martins
 */
@WebServlet(name = "InativarMedicamentoSuplemento", urlPatterns = {"/InativarMedicamentoSuplemento"})
public class InativarMedicamentoSuplemento extends HttpServlet {

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
        
         String mensagem = null;
        Integer idMedicamentoSuplemento = Integer.parseInt(request.getParameter("idmedicamentosuplemento"));

        MedicamentoSuplemento medicamentosuplemento = new MedicamentoSuplemento();
        medicamentosuplemento.setIdMedicamentoSuplemento(idMedicamentoSuplemento);
        medicamentosuplemento.setStatusMedicamentoSuplemento("I");
        try {
            MedicamentoSuplementoDAOImpl dao = new MedicamentoSuplementoDAOImpl();
            if (dao.inativar(medicamentosuplemento)) {
                mensagem = "Medicamento/Suplemento inativado com sucesso!";
            } else {
                mensagem = "Problemas ao inativar Medicamento/Suplemento!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarMedicamentoSuplemento").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao inativar Medicamento/Suplemento! Erro: " + ex.getMessage());
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
