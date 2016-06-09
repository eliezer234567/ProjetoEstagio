/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.AlimentoRefeicaoDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.RefeicaoDAOImpl;
import br.com.projetoestagio.model.Alimento;
import br.com.projetoestagio.model.AlimentoRefeicao;
import br.com.projetoestagio.model.Cardapio;
import br.com.projetoestagio.model.Refeicao;
import br.com.projetoestagio.model.TipoRefeicao;
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
@WebServlet(name = "CadastrarAlimentoRefeicao", urlPatterns = {"/CadastrarAlimentoRefeicao"})
public class CadastrarAlimentoRefeicao extends HttpServlet {

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
        //String diaRefeicao = request.getParameter("diarefeicao");
        Integer idCardapio = Integer.parseInt(request.getParameter("idcardapio"));
        //Integer idTipoRefeicao = Integer.parseInt(request.getParameter("idtiporefeicao"));

        String diasRefeicao[] = request.getParameterValues("diarefeicao");
        String tiposRefeicao = request.getParameter("idtiporefeicao");
        String horaRefeicao = request.getParameter("horarefeicao");
        Cardapio cardapio = new Cardapio();
        cardapio.setIdCardapio(idCardapio);

        String alimentos[] = request.getParameterValues("idalimento");
        String quantidades[] = request.getParameterValues("quantidadealimentorefeicao");
        String medidaalimento[] = request.getParameterValues("tipomedidaalimentorefeicao");

        Integer idRefeicao = null;

        try {
            for (int ii = 0; ii < diasRefeicao.length; ii++) {
                TipoRefeicao tipoRefeicao = new TipoRefeicao();
                tipoRefeicao.setIdTipoRefeicao(Integer.parseInt(tiposRefeicao));

                Refeicao refeicao = new Refeicao();
                refeicao.setDiaRefeicao(diasRefeicao[ii].toUpperCase().trim());
                refeicao.setStatusRefeicao("A");
                refeicao.setTipoRefeicao(tipoRefeicao);
                refeicao.setCardapio(cardapio);
                refeicao.setHoraRefeicao(horaRefeicao);

                RefeicaoDAOImpl daorefeicao = new RefeicaoDAOImpl();
                idRefeicao = daorefeicao.cadastrar(refeicao);
                
                
                if (idRefeicao != null) {
                    refeicao.setIdRefeicao(idRefeicao);
                    for (int i = 0; i < alimentos.length; i++) {
                        AlimentoRefeicao alimentoRefeicao = new AlimentoRefeicao();
                        Alimento alimento = new Alimento();
                        alimento.setIdAlimento(Integer.parseInt(alimentos[i])); 
                        
                        alimentoRefeicao.setAlimento(alimento);
                        alimentoRefeicao.setRefeicao(refeicao);
                        alimentoRefeicao.setTipoMedidaAlimentoRefeicao(medidaalimento[i]);
                        alimentoRefeicao.setQuantidadeAlimentoRefeicao(Double.parseDouble(quantidades[i]));
              

                        try {
                            GenericDAO dao = new AlimentoRefeicaoDAOImpl();

                            if (dao.cadastrar(alimentoRefeicao)) {
                                //mensagem = "Cadastrado com sucessso ";
//                                HttpSession session = request.getSession(true);
//                                session.setAttribute("idcardapio", idCardapio);
               
                                request.getRequestDispatcher("DadosRefeicao").forward(request, response);
                                
                            } else {
                                mensagem = "Erro ao cadastrar itens da refeição";
                            }
                        } catch (Exception ex) {
                            System.out.println("Erro ao cadastrar itens da refeição" + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar refeicao" + ex.getMessage());
            ex.printStackTrace();
        }
    }

//                    System.out.println("dia" + refeicao.getDiaRefeicao());
//                    System.out.println("tipo" + refeicao.getTipoRefeicao().getIdTipoRefeicao());
//
//                    System.out.println("id cardapio" + refeicao.getCardapio().getIdCardapio());
//                    System.out.println("Id refeicao" + refeicao.getIdRefeicao());
//                    System.out.println("id alimento" + alimento.getIdAlimento());
//                    System.out.println("tipo medida" + alimentoRefeicao.getTipoMedidaAlimentoRefeicao());
//                    System.out.println("quantidade" + alimentoRefeicao.getQuantidadeAlimentoRefeicao());
//                    System.out.println("Refeicao " + alimentoRefeicao.getRefeicao().getIdRefeicao());
        
        
        
        
        
    

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
