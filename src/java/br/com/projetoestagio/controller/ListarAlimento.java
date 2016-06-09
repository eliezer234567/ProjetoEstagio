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
import static java.lang.System.out;
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
@WebServlet(name = "ListarAlimento", urlPatterns = {"/ListarAlimento"})
public class ListarAlimento extends HttpServlet {

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

//        String nome = request.getParameter("campo-pesquisa");
//        String opcao = request.getParameter("opcao");
//
//      
//
//        try {
//            AlimentoDAOImpl dao = new AlimentoDAOImpl();
//            if (opcao.equals("nome")) {
//                List<Alimento> alimentos = dao.listarAlimento(nome, null);
//           
//
//
//            } else if (opcao.equals("tipo")) {
//                request.setAttribute("alimentos", dao.listarAlimento(null, nome));
//            }
//
//            request.getRequestDispatcher("listaralimento.jsp").forward(request, response);
//
//        } catch (Exception ex) {
//            System.out.println("Problemas no ListarAlimento ! " + ex.getMessage());
//        }



        try {
            GenericDAO dao = new AlimentoDAOImpl();
            request.setAttribute("alimentos", dao.listar());
            request.getRequestDispatcher("nutricionista/listaralimento.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Erro ao Listar Alimento Servlet" + ex.getMessage());
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
