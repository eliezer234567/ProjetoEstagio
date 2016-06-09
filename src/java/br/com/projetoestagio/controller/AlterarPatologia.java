/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.PatologiaDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.Patologia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarPatologia", urlPatterns = {"/AlterarPatologia"})
public class AlterarPatologia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensagem = null;

        Integer idPatologia = Integer.parseInt(request.getParameter("idPatologia"));
        String  nomePatologia=request.getParameter("nomePatologia");
        String  descricaoPatologia=request.getParameter("descricaoPatologia");
        String  historicofamiliaPatologia=request.getParameter("historicofamiliaPatologia");
        
        Patologia patologia=new Patologia();
        patologia.setIdPatologia(idPatologia);
         patologia.setNomePatologia(nomePatologia);
         patologia.setDescricaoPatologia(descricaoPatologia);
         patologia.setHistoricofamiliaPatologia(historicofamiliaPatologia);
         
        try {
            GenericDAO dao = new PatologiaDAOImpl();
            if (dao.alterar(patologia)) {
                mensagem = "Alterado com Sucesso";
            } else {
                mensagem = "Erro ao ser Alterado";
            }       
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarPatologia").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Erro ao alterar Patologia no Servlet" + ex.getMessage());
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
