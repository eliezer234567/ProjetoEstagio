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
import br.com.projetoestagio.DAO.RefeicaoDAOImpl;
import br.com.projetoestagio.DAO.TipoRefeicaoDAOImpl;
import br.com.projetoestagio.model.Alimento;
import br.com.projetoestagio.model.AlimentoRefeicao;
import br.com.projetoestagio.model.Cardapio;
import br.com.projetoestagio.model.Paciente;
import br.com.projetoestagio.model.Refeicao;
import br.com.projetoestagio.model.TipoRefeicao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListarCardapioAtual", urlPatterns = {"/ListarCardapioAtual"})
public class ListarCardapioAtual extends HttpServlet {

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
        String diasRefeicao[] = request.getParameterValues("diarefeicao");
        String tiposRefeicao = request.getParameter("idtiporefeicao");
        String horaRefeicao = request.getParameter("horarefeicao");

        String alimentos[] = request.getParameterValues("idalimento");
        String quantidades[] = request.getParameterValues("quantidadealimentorefeicao");
        String medidaalimento[] = request.getParameterValues("tipomedidaalimentorefeicao");
        
        HttpSession session = request.getSession(true);
        
        ArrayList<AlimentoRefeicao> alimentoRefeicoes;
        alimentoRefeicoes = (ArrayList<AlimentoRefeicao>) session.getAttribute("alimentorefeicao");
        
        ArrayList<Refeicao> refeicoes;
        refeicoes = (ArrayList<Refeicao>) session.getAttribute("refeicao");      
        
        if(alimentoRefeicoes == null){
            alimentoRefeicoes = new ArrayList<>();
        }
        
        if(refeicoes == null){
            refeicoes = new ArrayList<>();
        }

        try {
            int id = refeicoes.size();
            for (int i = 0; i < diasRefeicao.length; i++) {
                id++;
                TipoRefeicaoDAOImpl daoTipo = new TipoRefeicaoDAOImpl();
                TipoRefeicao tipoRefeicao = new TipoRefeicao();
                tipoRefeicao = (TipoRefeicao) daoTipo.carregar(Integer.parseInt(tiposRefeicao));

                Refeicao refeicao = new Refeicao();
                refeicao.setIdRefeicao(id);
                refeicao.setDiaRefeicao(diasRefeicao[i].toUpperCase().trim());
                refeicao.setStatusRefeicao("A");
                refeicao.setTipoRefeicao(tipoRefeicao);
                refeicao.setHoraRefeicao(horaRefeicao);
                
                refeicoes.add(refeicao);
                
                for (int ii = 0; ii < alimentos.length; ii++) {
                    AlimentoRefeicao alimentoRefeicao = new AlimentoRefeicao();
                    AlimentoDAOImpl daoAlimento = new AlimentoDAOImpl();
                    Alimento alimento = new Alimento();
                    alimento = (Alimento) daoAlimento.carregar(Integer.parseInt(alimentos[ii]));

                    alimentoRefeicao.setIdAlimentoRefeicao(id);
                    alimentoRefeicao.setAlimento(alimento);
                    alimentoRefeicao.setRefeicao(refeicao);
                    alimentoRefeicao.setTipoMedidaAlimentoRefeicao(medidaalimento[ii]);
                    alimentoRefeicao.setQuantidadeAlimentoRefeicao(Double.parseDouble(quantidades[ii]));
                                    
                    alimentoRefeicoes.add(alimentoRefeicao);
                }
            }
            GenericDAO daoalimento = new AlimentoDAOImpl();
            request.setAttribute("alimentos", daoalimento.listar());
            GenericDAO daotrefeicao = new TipoRefeicaoDAOImpl();
            request.setAttribute("trefeicao", daotrefeicao.listar());
            
            
           
            session.setAttribute("alimentorefeicao", alimentoRefeicoes);
            session.setAttribute("refeicao", refeicoes);
           
            request.getRequestDispatcher("nutricionista\\listarcardapioatual.jsp").forward(request, response);

        } catch (Exception ex) {
            System.out.println("Erro ao listar cardápio atual !!!" + ex.getMessage());
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
