/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.EvolucaoPacienteDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.EvolucaoPaciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Leticia
 */
@WebServlet(name = "AlterarEvolucaoPaciente", urlPatterns = {"/AlterarEvolucaoPaciente"})
public class AlterarEvolucaoPaciente extends HttpServlet {

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
        
        HttpSession session = request.getSession(true);
        Integer idPessoaPaciente = Integer.parseInt(session.getAttribute("idpessoapa").toString());
        
        String mensagem = null;
        Double pesoEvolucaoPaciente = Double.parseDouble(request.getParameter("pesoevolucaopaciente"));
        Double alturaEvolucaoPaciente = Double.parseDouble(request.getParameter("alturaevolucaopaciente"));
        Double circunPunhoEvolucaoPaciente = Double.parseDouble(request.getParameter("circunpunhoevolucaopaciente"));
        Double circunCinturaEvolucaoPaciente = Double.parseDouble(request.getParameter("circuncinturaevolucaopaciente"));
        Double circunQuadrilEvolucaoPaciente = Double.parseDouble(request.getParameter("circunquadrilevolucaopaciente"));
        Double dobrasCutaneasEvolucaoPaciente = Double.parseDouble(request.getParameter("dobrascutaneasevolucaopaciente"));
        Integer idEvolucaoPaciente = Integer.parseInt(request.getParameter("idevolucaopaciente"));
        
        EvolucaoPaciente evolucaoPaciente = new EvolucaoPaciente();
        evolucaoPaciente.setPesoEvolucaoPaciente(pesoEvolucaoPaciente);
        evolucaoPaciente.setAlturaEvolucaoPaciente(alturaEvolucaoPaciente);
        evolucaoPaciente.setCircunPunhoEvolucaoPaciente(circunPunhoEvolucaoPaciente);
        evolucaoPaciente.setCircunCinturaEvolucaoPaciente(circunCinturaEvolucaoPaciente);
        evolucaoPaciente.setCircunQuadrilEvolucaoPaciente(circunQuadrilEvolucaoPaciente);
        evolucaoPaciente.setDobrasCutaneasEvolucaoPaciente(dobrasCutaneasEvolucaoPaciente);
        evolucaoPaciente.setIdEvolucaoPaciente(idEvolucaoPaciente);

        try {
            GenericDAO dao = new EvolucaoPacienteDAOImpl();
            if (dao.alterar(evolucaoPaciente)) {
                mensagem = "Alterado com sucesso";

            } else {
                mensagem = "Erro ";
            }

            request.setAttribute("sucesso", mensagem);

            request.getRequestDispatcher("ListarEvolucaoPorPaciente?idpessoapaciente="+idPessoaPaciente).forward(request, response);

        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar Evolução do Paciente" + ex.getMessage());
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
