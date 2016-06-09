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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarPatologia extends HttpServlet{
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
               String mensagem=null;
               Integer IdPatologia=Integer.parseInt(request.getParameter("idpatologia"));
               String NomePatologia=request.getParameter("nomepatologia");
               String DescricaoPatologia=request.getParameter("descricaopatologia");
               String HistoricofamiliaPatologia=request.getParameter("historicofamiliapatologia");
               String StatusPatologia=request.getParameter("statuspatologia"); 
        
                Patologia patologia=new Patologia();
                
                
                patologia.setNomePatologia(NomePatologia.toUpperCase().trim());
                patologia.setDescricaoPatologia(DescricaoPatologia.toUpperCase().trim());
                patologia.setHistoricofamiliaPatologia(HistoricofamiliaPatologia.toUpperCase().trim());
                patologia.setStatusPatologia("A");
      
        try
        {
            GenericDAO dao=new PatologiaDAOImpl();
            if(dao.cadastrar(patologia))
            {
                mensagem = "Patologia cadastrado com sucesso";
            }
            else
            {
                mensagem= "Problema ao cadastrar Patologia ";
            }
            
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("cadastrarPatologia.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println("Problemas no Servlet ao cadastrar Patologia! Erro"+ex.getMessage());
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


