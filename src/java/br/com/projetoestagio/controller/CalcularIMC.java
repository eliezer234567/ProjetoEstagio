/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.model.Imc;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eliez
 */
@WebServlet(name = "CalcularIMC", urlPatterns = {"/CalcularIMC"})
public class CalcularIMC extends HttpServlet {

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
        Double peso = Double.parseDouble(request.getParameter("peso"));
        Double altura = Double.parseDouble(request.getParameter("altura"));
        String sexo = request.getParameter("sexo");
        //Double resultado = Double.parseDouble("resultado");

        Imc imc = new Imc();
        imc.setAltura(altura);
        imc.setPeso(peso);
        
        if(sexo.equals("M")) {
            if (imc.resultado() < 20.7) {
                mensagem = "Você está abaixo do peso ";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() >= 20.7 && imc.resultado() <= 26.4) {
                mensagem = "Você está no peso ideal";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() > 26.4 && imc.resultado() <= 27.8) {
                mensagem = "Você está um pouco acima do peso";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() > 27.8 && imc.resultado() <= 31.1) {
                mensagem = "Você está acima do peso ideal";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() > 31) {
                mensagem = "Você está obeso";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            }
        } else {
            if (imc.resultado() < 19.1) {
                mensagem = "Você está abaixo do peso";
                request.setAttribute("imc", imc);
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() >= 19.1 && imc.resultado() < 25.8) {
                mensagem = "Você está no peso ideal";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() >= 25.8 && imc.resultado() < 27.3) {
                mensagem = "Você está um pouco acima do peso";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() >= 27.3 && imc.resultado() < 32.3) {
                mensagem = "Você está acima do peso ideal";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            } else if (imc.resultado() > 32.3) {
                mensagem = "Você está obeso";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
            }
        }
        
            request.getRequestDispatcher("paciente/resultado.jsp").forward(request, response);
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
