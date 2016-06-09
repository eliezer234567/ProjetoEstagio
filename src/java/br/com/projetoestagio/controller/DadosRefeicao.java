/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.AlimentoDAOImpl;
import br.com.projetoestagio.DAO.CardapioDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.PacienteDAOImpl;
import br.com.projetoestagio.DAO.TipoRefeicaoDAOImpl;
import br.com.projetoestagio.model.Cardapio;
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
 * @author Leticia
 */
@WebServlet(name = "DadosRefeicao", urlPatterns = {"/DadosRefeicao"})
public class DadosRefeicao extends HttpServlet {

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
        String tipoCardapio = request.getParameter("tipocardapio");
        String nomeCardapio = request.getParameter("nomecardapio");
        Date dataInicioCardapio = Conversoes.converterData(request.getParameter("datainiciocardapio").replace("-", "/"));
        Date dataFinalCardapio = Conversoes.converterData(request.getParameter("datafinalcardapio").replace("-", "/"));
        Integer idPaciente = Integer.parseInt(request.getParameter("idpaciente"));
        String intervaloCardapio = request.getParameter("intervalocardapio");
        String observacaoCardapio = request.getParameter("observacaocardapio");
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);

        mensagem = validacao(tipoCardapio, nomeCardapio, dataInicioCardapio, dataFinalCardapio);

        if (mensagem != null && !mensagem.equals("")) {
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("DadosCardapio").forward(request, response);
        } else {
            Cardapio cardapio = new Cardapio();
            cardapio.setTipoCardapio(tipoCardapio.toUpperCase().trim());
            cardapio.setNomeCardapio(nomeCardapio.toUpperCase().trim());
            cardapio.setDataInicioCardapio(dataInicioCardapio);
            cardapio.setDataFinalCardapio(dataFinalCardapio);
            cardapio.setIntervaloCardapio(intervaloCardapio);
            cardapio.setObservacaoCardapio(observacaoCardapio.toUpperCase().trim());
            cardapio.setStatusCardapio("A");
            cardapio.setPaciente(paciente);

            try {
                if (cardapio.getNomeCardapio() != null) {
                    if (cardapio != null) {
                        PacienteDAOImpl daoPaciente = new PacienteDAOImpl();
                        paciente = (Paciente) daoPaciente.carregarPaciente(cardapio.getPaciente().getIdPaciente());
                        cardapio.setPaciente(paciente);

                        GenericDAO daoalimento = new AlimentoDAOImpl();
                        request.setAttribute("alimentos", daoalimento.listar());
                        GenericDAO daotrefeicao = new TipoRefeicaoDAOImpl();
                        request.setAttribute("trefeicao", daotrefeicao.listar());

                        HttpSession session = request.getSession(true);
                        session.setAttribute("cardapio", cardapio);
                        session.setAttribute("alimentorefeicao", null);
                        session.setAttribute("refeicao", null);

                        //request.setAttribute("cardapio", cardapio);
                        request.getRequestDispatcher("nutricionista/listarcardapioatual.jsp").forward(request, response);
                    }
                } else {
                    mensagem = "Erro ao cadastrar cardapio";
                }

            } catch (Exception ex) {
                System.out.println("Erro na Servlet " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    private String validacao(String tipo, String nome, Date dataInicial, Date dataFinal) {
        String msg = "";
        if (tipo.equals("") || tipo == null) {
            msg = msg + "Tipo não poder ficar em branco";

        }
//        if (!tipo.matches("[a-zA-Z\\s]+")) {
//            msg = msg + "<br>Caracteres inválidos para tipo do cardápio";
//        }
        if (tipo.length() > 30) {
            msg = msg + "<br>Total de caracteres não permitidos para o campo tipo do cardápio";
        }
        if (nome.equals("") || nome == null) {
            msg = msg + "<br>Nome não poder ficar em branco";

        }
//        if (!nome.matches("[a-zA-Z\\s]+")) {
//            msg = msg + "<br>Caracteres inválidos para nome do cardápio";
//        }
        if (nome.length() > 30) {
            msg = msg + "<br>Total de caracteres não permitidos para o campo nome do cardápio";
        }
        if (dataInicial == null) {
            msg = msg + "<br>Data inicial não pode ficar em branco";
        }
        if (dataFinal == null) {
            msg = msg + "<br>Data final não pode ficar em branco";
        }
        if (dataFinal.before(dataInicial)) {
            msg = msg + "<br>Data final não pode ser menor que data inicial";
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
