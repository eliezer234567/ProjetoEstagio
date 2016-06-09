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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eliezer
 */
@WebServlet(name = "CompletarConsulta", urlPatterns = {"/CompletarConsulta"})
public class CompletarConsulta extends HttpServlet {

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
        int idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
        String horaConsulta = request.getParameter("horaConsulta");
        String condutaNutricionalConsulta = request.getParameter("condutaNutricionalConsulta");
        String obsConsulta = request.getParameter("obsConsulta");
        Date dataConsulta = converterData(request.getParameter("dataConsulta").replace("-", "/"));

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);
        consulta.setDataConsulta(dataConsulta);
        consulta.setCondutaNutricionalConsulta(condutaNutricionalConsulta);
        consulta.setHoraConsulta(horaConsulta);
        consulta.setObsConsulta(obsConsulta);
        consulta.setStatusConsulta("Agendada");

        try {
            if (consulta.getDataConsulta() != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("consulta", consulta);
                
                //Integer id = (Integer) session.getAttribute("id");
                
                request.getRequestDispatcher("nutricionista/cadastrarevolucaopaciente.jsp").forward(request, response);
            }else{
                System.out.println("Erro ao colocar informações consulta na sessão");
            }
        } catch (Exception ex) {
            System.out.println("Erro Servlet AlterarConsulta" + ex.getMessage());
            ex.printStackTrace();
        }

//        try {
//            GenericDAO dao = new ConsultaDAOImpl();
//            if (dao.alterar(consulta)) {
//                mensagem = "Alteração realizada com sucesso!";
//                String script = "<script>$('#erroAlterarConsultaModal').modal('show');</script>";
//                request.setAttribute("script", script);
//            } else {
//                mensagem = "Erro ao realizar alteração!";
//                String script = "<script>$('#erroAlterarConsultaModal').modal('show');</script>";
//                request.setAttribute("script", script);
//            }
//            request.setAttribute("erroAlterarConsulta", mensagem);
//            request.getRequestDispatcher("ListarConsulta?idPessoa=" + id).forward(request, response);
//        } catch (Exception ex) {
//            System.out.println("Problemas no Servlet ao alterar Consulta! Erro: " + ex.getMessage());
//            ex.printStackTrace();
//        }
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
