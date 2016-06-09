/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.PacienteDAOImpl;
import br.com.projetoestagio.model.Paciente;
import br.com.projetoestagio.util.Conversoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "AlterarPaciente", urlPatterns = {"/AlterarPaciente"})
public class AlterarPaciente extends HttpServlet {

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
        
   

        
        Integer idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        String nomePessoa = request.getParameter("nomePessoa");
        String senhaPessoa = request.getParameter("senhaPessoa");
        String emailPessoa = request.getParameter("emailPessoa");
        String telefonePessoa = request.getParameter("telefonePessoa");
        String sexoPaciente = request.getParameter("sexoPaciente");
        Integer idadePaciente = Integer.parseInt(request.getParameter("idadePaciente"));
        Date dataNascimentoPaciente = Conversoes.converterData(request.getParameter("dataNascimentoPaciente").replace("-", "/"));

        Paciente paciente = new Paciente();
        paciente.setIdPessoa(idPessoa);
        paciente.setNomePessoa(nomePessoa);
        paciente.setSenhaPessoa(senhaPessoa);
        paciente.setEmailPessoa(emailPessoa);
        paciente.setTipoPessoa("PA");
        paciente.setTelefonePessoa(telefonePessoa);
        paciente.setIdadePaciente(idadePaciente);
        paciente.setDataNascimentoPaciente(dataNascimentoPaciente);
        if (sexoPaciente.equals("Masculino")) {
            paciente.setSexoPaciente("Masculino");
        } else {
            paciente.setSexoPaciente("Feminino");
        }
        
        HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");

        try {
            GenericDAO dao = new PacienteDAOImpl();
            if (dao.alterar(paciente)) {
                mensagem = "Alteração realizada com sucesso!";
                        String script="<script>$('#erroAlterarPacienteModal').modal('show');</script>";
                        request.setAttribute("script", script);
            } else {
                mensagem = "Erro ao realizar alteração!";
                        String script="<script>$('#erroAlterarPacienteModal').modal('show');</script>";
                        request.setAttribute("script", script);
            }
            request.setAttribute("erroAlterarPaciente", mensagem);
            request.getRequestDispatcher("ListarPaciente?idPessoa="+id).forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao alterar Paciente!Erro:" + ex.getMessage());
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
