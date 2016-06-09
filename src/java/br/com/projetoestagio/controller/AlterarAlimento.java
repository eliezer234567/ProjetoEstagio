/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.AlimentoDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.Alimento;
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
@WebServlet(name = "AlterarAlimento", urlPatterns = {"/AlterarAlimento"})
public class AlterarAlimento extends HttpServlet {

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

        Boolean statusAlimento = request.getParameter("statusalimento") != null;

        Alimento alimento = new Alimento();
        alimento.setIdAlimento(Integer.parseInt(request.getParameter("idalimento")));
        alimento.setNomeTabelaNutricionalAlimento(request.getParameter("nometabelanutricionalalimento").toUpperCase().trim());
        alimento.setNomeAlimento(request.getParameter("nomealimento").toUpperCase().trim());
        alimento.setTipoAlimento(request.getParameter("tipoalimento").toUpperCase().trim());
        alimento.setEspecieAlimento(request.getParameter("especiealimento").toUpperCase().trim());
        alimento.setCarboidratoAlimento(Double.parseDouble(request.getParameter("carboidratoalimento").toUpperCase().trim()));
        alimento.setLipideoAlimento(Double.parseDouble(request.getParameter("lipideoalimento").toUpperCase().trim()));
        alimento.setProteinaAlimento(Double.parseDouble(request.getParameter("proteinaalimento").toUpperCase().trim()));
        alimento.setFibraAlimentarAlimento(Double.parseDouble(request.getParameter("fibraalimentaralimento").toUpperCase().trim()));
        alimento.setCaminhoImagemAlimento(request.getParameter("caminhoimagemalimento"));
        
        
        if (statusAlimento == true) {
            alimento.setStatusAlimento("A");
        } else {
            alimento.setStatusAlimento("I");
        }

        try {
            GenericDAO dao = new AlimentoDAOImpl();
            if (dao.alterar(alimento)) {
                mensagem = "Alterado com Sucesso";
            } else {
                mensagem = "Erro ao ser Alterado";
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("/ListarAlimento").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Erro ao alterar Alimento na Servlet" + ex.getMessage());
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
