/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.ConsultaDAOImpl;
import br.com.projetoestagio.DAO.EvolucaoPacienteDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.EvolucaoPaciente;
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
 * @author Leticia
 */
@WebServlet(name = "CadastrarEvolucaoPaciente", urlPatterns = {"/CadastrarEvolucaoPaciente"})
public class CadastrarEvolucaoPaciente extends HttpServlet {

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
        Double pesoEvolucaoPaciente = Double.parseDouble(request.getParameter("pesoevolucaopaciente"));
        //Integer idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
        Double alturaEvolucaoPaciente = Double.parseDouble(request.getParameter("alturaevolucaopaciente"));
        Double circunPunhoEvolucaoPaciente = Double.parseDouble(request.getParameter("circunpunhoevolucaopaciente"));
        Double circunCinturaEvolucaoPaciente = Double.parseDouble(request.getParameter("circuncinturaevolucaopaciente"));
        Double circunQuadrilEvolucaoPaciente = Double.parseDouble(request.getParameter("circunquadrilevolucaopaciente"));
        Double dobrasCutaneasEvolucaoPaciente = Double.parseDouble(request.getParameter("dobrascutaneasevolucaopaciente"));

        mensagem = validacao(pesoEvolucaoPaciente, alturaEvolucaoPaciente, pesoEvolucaoPaciente, alturaEvolucaoPaciente, circunQuadrilEvolucaoPaciente, dobrasCutaneasEvolucaoPaciente);

        if (mensagem != null || !mensagem.equals("")) {
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("nutricionista\\cadastrarevolucaopaciente.jsp").forward(request, response);
        }

        // pegando dados da sessão referente a consulta
        Consulta consulta = new Consulta();
        HttpSession session = request.getSession(true);
        consulta = (Consulta) session.getAttribute("consulta");
        consulta.getIdConsulta();
        consulta.getCondutaNutricionalConsulta();
        consulta.getDataConsulta();
        consulta.getHoraConsulta();
        consulta.getNutricionista();
        consulta.getObsConsulta();
        consulta.getPaciente();
        consulta.getStatusConsulta();

        EvolucaoPaciente evolucaoPaciente = new EvolucaoPaciente();
        evolucaoPaciente.setPesoEvolucaoPaciente(pesoEvolucaoPaciente);
        evolucaoPaciente.setAlturaEvolucaoPaciente(alturaEvolucaoPaciente);
        evolucaoPaciente.setCircunPunhoEvolucaoPaciente(circunPunhoEvolucaoPaciente);
        evolucaoPaciente.setCircunCinturaEvolucaoPaciente(circunCinturaEvolucaoPaciente);
        evolucaoPaciente.setCircunQuadrilEvolucaoPaciente(circunQuadrilEvolucaoPaciente);
        evolucaoPaciente.setDobrasCutaneasEvolucaoPaciente(dobrasCutaneasEvolucaoPaciente);
        evolucaoPaciente.setConsulta(consulta);

        try {
            GenericDAO dao = new ConsultaDAOImpl();
            if (dao.alterar(consulta)) {
                try {
                    GenericDAO daoEvolucao = new EvolucaoPacienteDAOImpl();
                    if (daoEvolucao.cadastrar(evolucaoPaciente)) {
                        mensagem = "Cadastrado com sucesso";
                    } else {
                        mensagem = "Erro ";
                    }
                    request.setAttribute("sucesso", mensagem);
                    request.getRequestDispatcher("nutricionista/cadastrarevolucaopaciente.jsp").forward(request, response);

                } catch (Exception ex) {
                    System.out.println("Erro ao cadastrar Evolução do Paciente e Alterar Consulta" + ex.getMessage());
                    ex.printStackTrace();

                }
            } else {
                request.setAttribute("sucesso", mensagem);
                request.getRequestDispatcher("CarregarConsulta");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String validacao(Double pesoEvolucao, Double alturaEvolucao, Double punhoEvolucao, Double cinturaEvolucao, Double quadrilEvolucao, Double dobrasCutaneasEvolucao) {
        String msg = "";
        if (pesoEvolucao == null) {
            msg = msg + "Peso do paciente não poder ficar em branco";
        }
        if (alturaEvolucao == null) {
            msg = msg + "Altura do paciente não poder ficar em branco";
        }
        if (punhoEvolucao == null) {
            msg = msg + "Punho do paciente não poder ficar em branco";
        }
        if (cinturaEvolucao == null) {
            msg = msg + "Cintura do paciente não poder ficar em branco";
        }
        if (quadrilEvolucao == null) {
            msg = msg + "Peso do paciente não poder ficar em branco";
        }
        if (dobrasCutaneasEvolucao == null) {
            msg = msg + "Peso do paciente não poder ficar em branco";
        }

        return msg;
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
