/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.ConsultaDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.Nutricionista;
import br.com.projetoestagio.model.Paciente;
import static br.com.projetoestagio.util.Conversoes.converterData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eliezer.L
 */
@WebServlet(name = "CadastrarConsulta", urlPatterns = {"/CadastrarConsulta"})
public class CadastrarConsulta extends HttpServlet {

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
        Date dataConsulta = converterData(request.getParameter("dataConsulta").replace("-", "/"));
        //Time horaConsulta = converterTime(request.getParameter("horaConsulta").replace(":", ":"));
        String horaConsulta = request.getParameter("horaConsulta");
        Integer idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        Integer idNutricionista = Integer.parseInt(request.getParameter("idNutricionista"));

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);
        
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setIdNutricionista(idNutricionista);
        
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(dataConsulta);
        consulta.setCondutaNutricionalConsulta("");
        consulta.setHoraConsulta(horaConsulta);
        consulta.setObsConsulta("");
        consulta.setStatusConsulta("Agendada");
        consulta.setPaciente(paciente);
        consulta.setNutricionista(nutricionista);    

        HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");
        
        try {
            GenericDAO dao = new ConsultaDAOImpl();
            if (dao.cadastrar(consulta)) {
                mensagem = "Cadastro realizado com sucesso!";
                String script="<script>$('#erroCadastro').modal('show');</script>";
                request.setAttribute("script", script);
            } else {
                mensagem = "Problemas ao cadastrar Consulta!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarConsulta?idPessoa="+id).forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Consulta! Erro: " + ex.getMessage());
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
