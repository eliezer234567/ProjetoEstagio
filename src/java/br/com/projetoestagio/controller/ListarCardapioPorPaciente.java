/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.CardapioDAOImpl;
import br.com.projetoestagio.DAO.RefeicaoDAOImpl;
import br.com.projetoestagio.model.AlimentoRefeicao;
import br.com.projetoestagio.model.Cardapio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leticia
 */
@WebServlet(name = "ListarCardapioPorPaciente", urlPatterns = {"/ListarCardapioPorPaciente"})
public class ListarCardapioPorPaciente extends HttpServlet {

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

        Integer idPessoa = Integer.parseInt(request.getParameter("idpessoa"));

        try {
            CardapioDAOImpl daoCardapio = new CardapioDAOImpl();
            List<Cardapio> cardapios = daoCardapio.listarCardapioPorPaciente(idPessoa);
            List<AlimentoRefeicao> refeicoes = new ArrayList<>();

            for (int i = 0; cardapios.size() > i; i++) {
                RefeicaoDAOImpl daoRefeicao = new RefeicaoDAOImpl();
                
                Cardapio cardapio;
                cardapio = cardapios.get(i);
                
                List<AlimentoRefeicao> refeicoesAux = daoRefeicao.listarRefeicaoPorCardapio(cardapio.getIdCardapio());
                
                for (int c = 0; refeicoesAux.size() > c; c++) {
                    AlimentoRefeicao alimentoRefeicao;
                    alimentoRefeicao = refeicoesAux.get(c);
                    refeicoes.add(alimentoRefeicao);
                }
            }
            request.setAttribute("cardapios", cardapios);
            request.setAttribute("refeicoes", refeicoes);

            request.getRequestDispatcher("nutricionista\\listarcardapioporpaciente.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println("ListarCardapioPorPaciente, Erro ao listar Cardápio: " + ex.getMessage());
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
