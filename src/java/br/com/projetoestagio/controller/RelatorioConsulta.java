/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.util.ConnectionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author eliez
 */
public class RelatorioConsulta extends HttpServlet {

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
    ServletOutputStream servletOutputStream = response.getOutputStream();

        String caminho = "/Relatorio/";
        String relatorio = caminho + "RelatorioConsulta.jasper";
        InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(relatorio);
        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");

            List<Object> pessoas = new ArrayList<Object>();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            String sql = "select * from consulta;";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setCondutaNutricionalConsulta(rs.getString("conduta_nutricional_consulta"));
                consulta.setObsConsulta(rs.getString("observacao_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));
                pessoas.add(consulta);
                
            }

            response.setContentType("application/pdf");
            JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(pessoas);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap(), jrBean);

        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao gerar o relatório das Consultas. Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            servletOutputStream.flush();
            servletOutputStream.close();
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
