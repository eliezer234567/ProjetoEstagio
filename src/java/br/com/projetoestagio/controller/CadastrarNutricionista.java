/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.DAO.NutricionistaDAOImpl;
import br.com.projetoestagio.model.Nutricionista;
import br.com.projetoestagio.util.Conversoes;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;


/**
 *
 * @author Leticia
 */
public class CadastrarNutricionista extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException {
        
        String foto_pessoa = null;
        String mensagem = null;

        
        
        boolean isMultipart = FileUpload.isMultipartContent(request);
        if (isMultipart) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            String data = dateFormat.format(date);
            data = data.replace(":", "");
            data = data.replace(" ", "");
            data = data.replace("/", "");
            
            // Create a new file upload handler
            DiskFileUpload upload = new DiskFileUpload();

            // Set upload parameters
            upload.setSizeMax(50 * 1024 * 1024); //50Mb
            upload.setRepositoryPath(this.getServletContext().getRealPath("")+"\\imagem\\");


            // Parse the request
            List items = upload.parseRequest(request);

            Iterator it = items.iterator();
            while (it.hasNext()) {
                FileItem fitem = (FileItem) it.next();
                if (!fitem.isFormField()) {
                    if(fitem.getSize() > 0){

                                /*
                     * Executar este código caso o computador do aluno não
                     * esteja pegando o nome da imagem mas sim o caminho todo
                     *
                    String[] texto = fitem.getName().split("\\\\");
                    for (int i = 0; i < texto.length; i++) {
                        if ((i + 1) == texto.length) {
                            fitem.write(new File("C:/Users/Andre/Documents/NetBeansProjects/ProjetoRevisaoWeb/web/imagens/" + texto[i]));
                            caminho_imagem = "imagens/" + texto[i];
                        }
                    }

                     */

                    try {
                        fitem.write(new File(this.getServletContext().getRealPath("")+"\\imagem\\imagem_" + data + ".png"));
                    } catch (Exception ex) {
                        System.out.println("Problemas ao pegar o nome do arquivo! Erro:" + ex.getMessage());
                        ex.printStackTrace();
                    }

                    System.out.println(fitem.getName());
                    foto_pessoa = "\\imagem\\imagem_" + data + ".png";
                    System.out.println("O arquivo enviado foi: " + foto_pessoa + "e o seu tamanho é de: " + fitem.getSize() + "bytes!");
                } }else foto_pessoa = "";
            }
        }
        
        Conversoes conv = new Conversoes();
        
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setNomePessoa(request.getParameter("nomePessoa"));
        nutricionista.setTelefonePessoa(request.getParameter("telefonePessoa"));
        nutricionista.setEmailPessoa(request.getParameter("emailPessoa"));
        nutricionista.setSenhaPessoa(conv.md5(request.getParameter("senhaPessoa")));
        nutricionista.setCrnNutricionista(Integer.parseInt(request.getParameter("crnNutricionista")));
        nutricionista.setStatusPessoa("A");
        nutricionista.setTipoPessoa("NU");
        nutricionista.setFotoPessoa(foto_pessoa);
        
        try {
            GenericDAO dao = new NutricionistaDAOImpl();
            if (dao.cadastrar(nutricionista)) {
                mensagem = "Cadastro realizado com sucesso!";
                        String script="<script>$('#erroNutricionista').modal('show');</script>";
                        request.setAttribute("script", script);
            } else {
                mensagem = "Problemas ao realizar cadastro!";
                        String script="<script>$('#erroNutricionista').modal('show');</script>";
                        request.setAttribute("script", script);
            }
            request.setAttribute("erroNutricionista",mensagem);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problema no servlet ao cadastrar Nutricionista" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            System.out.println("Problemas no do doGet! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            System.out.println("Problemas no do doPost! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
