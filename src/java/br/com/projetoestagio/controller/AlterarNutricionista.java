/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.NutricionistaDAOImpl;
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
 * @author usuario
 */
@WebServlet(name = "AlterarNutricionista", urlPatterns = {"/AlterarNutricionista"})
public class AlterarNutricionista extends HttpServlet {

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
        
        String mensagem =  null;
        
        
        
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setIdPessoa(Integer.parseInt(request.getParameter("idPessoa")));
        nutricionista.setNomePessoa(request.getParameter("nomePessoa"));
        nutricionista.setTelefonePessoa(request.getParameter("telefonePessoa"));
        nutricionista.setEmailPessoa(request.getParameter("emailPessoa"));
        nutricionista.setSenhaPessoa(request.getParameter("senhaPessoa"));
        nutricionista.setCrnNutricionista(Integer.parseInt(request.getParameter("crnNutricionista")));
        nutricionista.setStatusPessoa(request.getParameter("statusPessoa"));
        nutricionista.setTipoPessoa(request.getParameter("tipoPessoa"));
        
        HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");
        
       
        
        try{
            GenericDAO dao  = new NutricionistaDAOImpl();
            if(dao.alterar(nutricionista)){
                mensagem = "Alteração realizada com sucesso!";
                        String script="<script>$('#erroAlterarNutricionista').modal('show');</script>";
                        request.setAttribute("script", script);
            }else{
                mensagem = "Problemas ao realizar alteração!";
                        String script="<script>$('#erroAlterarNutricionista').modal('show');</script>";
                        request.setAttribute("script", script);
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("CarregarInformacaoNutricionista").forward(request, response);
        }catch(Exception ex){
            System.out.println("Problemas no servlet ao alterar Nutricionista!Erro:" +ex.getMessage());
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
