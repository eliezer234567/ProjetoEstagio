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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;

/**
 *
 * @author eliez
 */
@WebServlet(name = "NutricionistaCadastraPaciente", urlPatterns = {"/NutricionistaCadastraPaciente"})
public class NutricionistaCadastraPaciente extends HttpServlet {

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
            // Create a new file upload handler
            DiskFileUpload upload = new DiskFileUpload();

            // Set upload parameters
            upload.setSizeMax(50 * 1024 * 1024); //50Mb
            upload.setRepositoryPath(this.getServletContext().getRealPath("")+"imagem\\imagem_");


            // Parse the request
            List items = upload.parseRequest(request);

            Iterator it = items.iterator();
            while (it.hasNext()) {
                FileItem fitem = (FileItem) it.next();
                if (!fitem.isFormField()) {

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
                        fitem.write(new File(this.getServletContext().getRealPath("")+"/imagem/imagem_" + (new File(fitem.getName())).getName()));
                    } catch (Exception ex) {
                        System.out.println("Problemas ao pegar o nome do arquivo! Erro:" + ex.getMessage());
                        ex.printStackTrace();
                    }

                    System.out.println(fitem.getName());
                    foto_pessoa = this.getServletContext().getRealPath("")+"imagem\\imagem_" + fitem.getName();
                    System.out.println("O arquivo enviado foi: " + foto_pessoa + "e o seu tamanho é de: " + fitem.getSize() + "bytes!");
                } 
            }
        }
        String nomePessoa = request.getParameter("nomePessoa");
        String senhaPessoa = request.getParameter("senhaPessoa");
        String emailPessoa = request.getParameter("emailPessoa");
        String telefonePessoa = request.getParameter("telefonePessoa");
        String sexoPaciente = request.getParameter("sexoPaciente");
        Integer idadePaciente = Integer.parseInt(request.getParameter("idadePaciente"));
        Date dataNascimentoPaciente = Conversoes.converterData(request.getParameter("dataNascimentoPaciente").replace("-", "/"));
        
        Paciente paciente = new Paciente();
        
        paciente.setNomePessoa(nomePessoa);
        paciente.setSenhaPessoa(senhaPessoa);
        paciente.setEmailPessoa(emailPessoa);
        paciente.setTelefonePessoa(telefonePessoa);
        paciente.setIdadePaciente(idadePaciente);
        paciente.setDataNascimentoPaciente(dataNascimentoPaciente);
        paciente.setStatusPessoa("A");
        paciente.setTipoPessoa("PA");
        if(sexoPaciente.equals("M")){
            paciente.setSexoPaciente("Masculino");
        }else{
            paciente.setSexoPaciente("Feminino");
        }
        paciente.setFotoPessoa(foto_pessoa);
        
         HttpSession session = request.getSession(true);
        Integer id = (Integer) session.getAttribute("id");

        try {
            GenericDAO dao = new PacienteDAOImpl();
            if (dao.cadastrar(paciente)) {
                mensagem = "Cadastro realizado com sucesso!";
                        String script="<script>$('#erroCadastro').modal('show');</script>";
                        request.setAttribute("script", script);
            } else {
                mensagem = "Problemas ao realizar cadastro!";
                        String script="<script>$('#erroCadastro').modal('show');</script>";
                        request.setAttribute("script", script);
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("CarregarDadosNutricionista?idPessoa="+id).forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao cadastrar Paciente!Erro:" + ex.getMessage());
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
