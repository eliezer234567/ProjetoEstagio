/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.CardapioDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.Cardapio;
import br.com.projetoestagio.model.Paciente;
import br.com.projetoestagio.util.Conversoes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leticia
 */
@WebServlet(name = "AlterarCardapio", urlPatterns = {"/AlterarCardapio"})
public class AlterarCardapio extends HttpServlet {

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

        Cardapio cardapio = new Cardapio();
        cardapio.setIdCardapio(Integer.parseInt(request.getParameter("idcardapio").toUpperCase().trim()));
        cardapio.setDataInicioCardapio(Conversoes.converterData(request.getParameter("datainiciocardapio").replace("-", "/")));
        cardapio.setDataFinalCardapio(Conversoes.converterData(request.getParameter("datafinalcardapio").replace("-", "/")));
        //cardapio.setDataInicioCardapio( request.getParameter("datainiciocardapio"));
        cardapio.setNomeCardapio(request.getParameter("nomecardapio").toUpperCase().trim());
        cardapio.setObservacaoCardapio(request.getParameter("observacaocardapio").toUpperCase().trim());
        cardapio.setTipoCardapio(request.getParameter("tipocardapio".toUpperCase().trim()));

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(Integer.parseInt(request.getParameter("idpaciente").toUpperCase().trim()));
        cardapio.setPaciente(paciente);

        Boolean statusCardapio = request.getParameter("statuscardapio") != null;

        if (statusCardapio == true) {
            cardapio.setStatusCardapio("A");
        } else {
            cardapio.setStatusCardapio("I");
        }

        try {
            GenericDAO dao = new CardapioDAOImpl();
            if (dao.alterar(cardapio)) {
                mensagem = "Cadastrado com Sucesso";
            } else {
                mensagem = "Erro ao Cadastrar";
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarCardapio").forward(request, response);

        } catch (Exception ex) {
            System.out.println("Erro ao AlterarCardapio" + ex.getMessage());
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
