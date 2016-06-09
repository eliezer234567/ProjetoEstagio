/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.ConsultaDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.NutricionistaDAOImpl;
import br.com.projetoestagio.DAO.PacienteDAOImpl;
import br.com.projetoestagio.DAO.PessoaDAOImpl;
import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.Nutricionista;
import br.com.projetoestagio.model.Paciente;
import br.com.projetoestagio.model.Pessoa;
import br.com.projetoestagio.util.Conversoes;
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
 * @author Eliezer
 */
@WebServlet(name = "LogarUsuario", urlPatterns = {"/LogarUsuario"})
public class LogarUsuario extends HttpServlet {

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
        if (request.getParameter("acao").equals("logar")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            if (!email.equals("") || !senha.equals("")) {
                Pessoa pessoa = null;
//                Nutricionista nutricionista = null;
//                Paciente paciente = null;
                try {
                    PessoaDAOImpl dao = new PessoaDAOImpl();
                    Conversoes conv = new Conversoes();
                    pessoa = dao.verificarUsuario(email, conv.md5(senha));
                    if (pessoa != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("id", pessoa.getIdPessoa());
                        session.setAttribute("nome", pessoa.getNomePessoa());
                        session.setAttribute("email", pessoa.getEmailPessoa());
                        session.setAttribute("senha", pessoa.getSenhaPessoa());
                        session.setAttribute("telefone", pessoa.getTelefonePessoa());
                        session.setAttribute("tipoPessoa", pessoa.getTipoPessoa());
                        session.setAttribute("foto", pessoa.getFotoPessoa());
                        mensagem = "Seja bem-vindo Sr.(a) " + pessoa.getNomePessoa();
                        session.setAttribute("saudacao", mensagem);      
                        if (pessoa.getTipoPessoa().equals("NU")) {
                            
                            request.getRequestDispatcher("ListarConsulta").forward(request, response);
                        } else {
                            Paciente paciente = null;
                            try{
                                paciente = (Paciente) new PacienteDAOImpl().carregar(pessoa.getIdPessoa());
                                session.setAttribute("idPaciente", paciente.getIdPaciente());
                            } catch(Exception ex){
                                System.out.println("Problemas ao carregar Paciente! Erro: " + ex.getMessage());
                                ex.printStackTrace();
                            }
                            
                            request.getRequestDispatcher("paciente/indexpaciente.jsp").forward(request, response);
                        }
                    } else {
                        mensagem = "Usuário/Senha inválidos!";
                        String script="<script>$('#mensagemModal').modal('show');</script>";
                        request.setAttribute("script", script);
                        request.setAttribute("mensagem", mensagem);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    System.out.println("Problemas ao logar! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                mensagem = "Usuário/Senha inválidos!";
                String script="<script>$('#mensagemModal').modal('show');</script>";
                request.setAttribute("script", script);
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (request.getParameter("acao").equals("logout")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("index.jsp");
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
