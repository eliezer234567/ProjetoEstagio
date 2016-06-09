/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.ConsultaDAOImpl;
import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.Paciente;
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
@WebServlet(name = "AlterarStatusConsultaFinalizada", urlPatterns = {"/AlterarStatusConsultaFinalizada"})
public class AlterarStatusConsultaFinalizada extends HttpServlet {

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
        // altera status consulta para realizada
        
        Integer idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
        //String statusConsulta = request.getParameter("statusConsulta");
        
        
        
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);
        consulta.setStatusConsulta("Realizada");
        
         HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");
        
        try{
            ConsultaDAOImpl dao = new ConsultaDAOImpl();
            dao.alterarStatusConsulta(consulta);
            request.getRequestDispatcher("ListarConsulta?idPessoa="+id).forward(request, response);
        }
        catch(Exception ex){
            System.out.println("Erro ao alterar status consulta para realizada" +ex.getMessage());
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
