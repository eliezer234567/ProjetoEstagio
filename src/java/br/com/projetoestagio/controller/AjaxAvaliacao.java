/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.AvaliacaoMedicamentoSuplementoDAOImpl;
import br.com.projetoestagio.DAO.AvaliacaoPatologiaDAOImpl;
import br.com.projetoestagio.DAO.ExercicioDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.MedicamentoSuplementoDAOImpl;
import br.com.projetoestagio.DAO.PatologiaDAOImpl;
import br.com.projetoestagio.model.Avaliacao;
import br.com.projetoestagio.model.AvaliacaoMedicamentoSuplemento;
import br.com.projetoestagio.model.AvaliacaoPatologia;
import br.com.projetoestagio.model.MedicamentoSuplemento;
import br.com.projetoestagio.model.Patologia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Grazy
 */
@WebServlet(name = "AjaxAvaliacao", urlPatterns = {"/AjaxAvaliacao"})
public class AjaxAvaliacao extends HttpServlet {

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
       
        String acao = request.getParameter("acao");
        int idAvaliacao = Integer.parseInt(request.getParameter("idavaliacao"));
        int idMedicamento = Integer.parseInt(request.getParameter("idmedicamento"));
        int idPatologia = Integer.parseInt(request.getParameter("idpatologia"));
        
        String mensagem = "";

        if ("listaravaliacaoexercicio".equals(acao)) {
            try {
                GenericDAO medSup = new MedicamentoSuplementoDAOImpl();
                GenericDAO exerci = new ExercicioDAOImpl();
                GenericDAO patolo = new PatologiaDAOImpl();
                request.setAttribute("listmedicamento", medSup.listar());
                request.setAttribute("listexercicio", exerci.listar());
                request.setAttribute("listpatologia", patolo.listar());
                request.getRequestDispatcher("nutricionista/cadastraravaliacao2.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas ao carregar dados exercicio com Ajax! Erro: " + ex.getMessage());
            }
        } else if ("tabelalistaravaliacaomedicamento".equals(acao)) {
            try {
                AvaliacaoMedicamentoSuplementoDAOImpl tableAvaliacao = new AvaliacaoMedicamentoSuplementoDAOImpl();
                request.setAttribute("medicamentos", tableAvaliacao.tabelaavaliacaomedicamento(idAvaliacao, idMedicamento));
                request.getRequestDispatcher("/nutricionista/ajax/avaliacao/tabelaavaliacaomedicamento.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas ao carregar dados Medicamentos com Ajax! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else if ("listarTabelaAvaliacaoPatologia".equals(acao)) {
            try {
                AvaliacaoPatologiaDAOImpl avaliacaoPatologiaDAOImpl = new AvaliacaoPatologiaDAOImpl();
                request.setAttribute("avaliacaopatologias", avaliacaoPatologiaDAOImpl.tabelaavaliacaopatologia(idAvaliacao));
                request.getRequestDispatcher("/nutricionista/ajax/avaliacao/tabelaavaliacaopatologia.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas ao carregar tabela com Patologias com Ajax! Erro: " + ex.getMessage());
            }
        } else if ("cadastrarMedicamentoAvaliacao".equals(acao)) {
            String dose = request.getParameter("dose");
            String frequencia = request.getParameter("frequencia");

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setIdAvaliacao(idAvaliacao);
            MedicamentoSuplemento medicamentoSuplemento = new MedicamentoSuplemento();
            medicamentoSuplemento.setIdMedicamentoSuplemento(idMedicamento);

            AvaliacaoMedicamentoSuplemento avaliacaoMedicamentoSuplemento = new AvaliacaoMedicamentoSuplemento();
            avaliacaoMedicamentoSuplemento.setDose_avaliacao_medicamento_suplemento(dose);
            avaliacaoMedicamentoSuplemento.setFrequencia_avaliacao_medicamento_suplemento(frequencia);
            avaliacaoMedicamentoSuplemento.setAvaliacao(avaliacao);
            avaliacaoMedicamentoSuplemento.setMedicamentoSuplemento(medicamentoSuplemento);

            try {
                GenericDAO dao = new AvaliacaoMedicamentoSuplementoDAOImpl();
                if (dao.cadastrar(avaliacaoMedicamentoSuplemento)) {
                    mensagem = "Adicionado com sucesso";
                } else {
                    mensagem = "Erro ao cadastrar";
                }

                request.setAttribute("sucesso", mensagem);
                request.getRequestDispatcher("/nutricionista/ajax/avaliacao/listaravaliacaomedicamento.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro na Servlet " + ex.getMessage());
                ex.printStackTrace();
            }

        } else if ("cadastrarPatologiaAvaliacao".equals(acao)) {
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setIdAvaliacao(idAvaliacao);
            
            Patologia patologia = new Patologia();
            patologia.setIdPatologia(idPatologia);
            
            AvaliacaoPatologia avaliacaopatologia = new AvaliacaoPatologia();
            avaliacaopatologia.setAvaliacao(avaliacao);
            avaliacaopatologia.setPatologia(patologia);

            try {
                GenericDAO dao = new AvaliacaoPatologiaDAOImpl();
                if (dao.cadastrar(avaliacaopatologia)) {
                    mensagem = "Adicionado com sucesso";
                } else {
                    mensagem = "Erro ao cadastrar";
                }

                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("/nutricionista/ajax/avaliacao/listaravaliacaopatologia.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Erro na Servlet " + ex.getMessage());
                ex.printStackTrace();
            }
            
        } else if ("excluirItensPatologia".equals(acao)) {
            Integer idAvaliacaoPatologia = Integer.parseInt(request.getParameter("id"));
            try {
                GenericDAO dao = new AvaliacaoPatologiaDAOImpl();
                dao.excluir(idAvaliacaoPatologia);

            } catch (Exception ex) {
                System.out.println("Erro na Servlet " + ex.getMessage());
                ex.printStackTrace();
            }
            
        } else {
            System.out.println("Erro no AJAX: Nenhum parametro acao foi definido");
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
