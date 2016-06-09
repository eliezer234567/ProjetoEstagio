/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.RefeicaoDAOImpl;
import br.com.projetoestagio.model.Cardapio;
import br.com.projetoestagio.model.Refeicao;
import br.com.projetoestagio.model.TipoRefeicao;
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
public class AlterarRefeicao extends HttpServlet {

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

//        String mensagem = null;
//
//        Refeicao refeicao = new Refeicao();
//        refeicao.setIdRefeicao(Integer.parseInt(request.getParameter("idrefeicao").toUpperCase().trim()));
//        refeicao.setDiaRefeicao(request.getParameter("diarefeicao").toUpperCase().trim());
//        refeicao.setSincronizaRefeicao(1);
//
//        Cardapio cardapio = new Cardapio();
//        cardapio.setIdCardapio(Integer.parseInt(request.getParameter("idcardapio").toUpperCase().trim()));
//        refeicao.setCardapio(cardapio);
//
//        TipoRefeicao tiporefeicao = new TipoRefeicao();
//    
//        tiporefeicao.setIdTipoRefeicao(Integer.parseInt(request.getParameter("idtiporefeicao").toUpperCase().trim()));
//        refeicao.setTipoRefeicao(tiporefeicao);
//
//        Boolean statusRefeicao = request.getParameter("statusrefeicao") != null;
//        if (statusRefeicao == true) {
//            refeicao.setStatusRefeicao("A");
//        } else {
//            refeicao.setStatusRefeicao("I");
//        }
//
//        try {
//            GenericDAO dao = new RefeicaoDAOImpl();
//            if (dao.alterar(refeicao)) {
//                mensagem = "Alterado com Sucesso";
//            } else {
//                mensagem = "Erro ao Alterar";
//            }
//            
//            request.setAttribute("sucesso", mensagem);
//            request.getRequestDispatcher("ListarRefeicao").forward(request, response);
//            
//        } catch (Exception ex) {
//            System.out.println("Erro ao AlterarRefeicao" + ex.getMessage());
//            ex.printStackTrace();
//        }
//
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
