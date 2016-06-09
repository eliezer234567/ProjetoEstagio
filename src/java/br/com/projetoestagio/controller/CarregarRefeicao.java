/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.CardapioDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.RefeicaoDAOImpl;
import br.com.projetoestagio.DAO.TipoRefeicaoDAOImpl;
import br.com.projetoestagio.model.Refeicao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leticia
 */
public class CarregarRefeicao extends HttpServlet {

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

//        int idRefeicao = Integer.parseInt(request.getParameter("idrefeicao"));
//
//        try {
//            GenericDAO dao = new RefeicaoDAOImpl();
//            request.setAttribute("refeicao", dao.carregar(idRefeicao));
//
//
//            GenericDAO daoCardapio= new CardapioDAOImpl();
//            request.setAttribute("cardapios", daoCardapio.listar());
//            
//            GenericDAO daoTipoRefeicao= new TipoRefeicaoDAOImpl();
//            request.setAttribute("trefeicao", daoTipoRefeicao.listar());
//            
//            request.getRequestDispatcher("alterarrefeicao.jsp").forward(request, response);
//
//        } catch (Exception ex) {
//            System.out.println("Erro no Servlet CarregarRefeicao" + ex.getMessage());
//            ex.printStackTrace();
//        }
        

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
