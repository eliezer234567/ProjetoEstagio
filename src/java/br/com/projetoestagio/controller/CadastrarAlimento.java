/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.AlimentoDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.Alimento;
import java.io.File;
import java.io.IOException;
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
@WebServlet(name = "CadastrarAlimento", urlPatterns = {"/CadastrarAlimento"})
public class CadastrarAlimento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.apache.commons.fileupload.FileUploadException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException {

        //    private void cadastrarAlimento(FileItem item) throws IOException {
//        String caminho = getServletContext().getRealPath("/logo") + "/";
//
//        File diretorio = new File(caminho);
//        if (!diretorio.exists()) {
//            diretorio.mkdir();
//        }
//
//        String nome = item.getName();
//        String arq[] = nome.split("\\\\");
//        for (int i = 0; i < arq.length; i++) {
//            nome = arq[i];
//
//        }
//        File file = new File(diretorio, nome);
//        FileOutputStream output = new FileOutputStream(file);
//        InputStream is = item.getInputStream();
//        byte[] buffer = new byte[2048];
//        int nLidos;
//        while ((nLidos = is.read(buffer)) >= 0) {
//            output.write(buffer, 0, nLidos);
//        }
//        output.flush();
//        output.close();
//
//    }
        String mensagem = null;
        String nomeTabelaNutricionalAlimento = request.getParameter("nometabelanutricionalalimento");
        String nomeAlimento = request.getParameter("nomealimento");
        String tipoAlimento = request.getParameter("tipoalimento");
        String especieAlimento = request.getParameter("especiealimento");
        Double proteinaAlimento = 0.00; //TODO: falta ajustar campos 
        Double lipideoAlimento = 0.00;
        Double carboidratoAlimento = 0.00;
        Double fibraAlimentarAlimento = 0.00;
        String caminhoImagemAlimento = null;
        if (!request.getParameter("proteinaalimento").isEmpty()) {
            proteinaAlimento = Double.parseDouble(request.getParameter("proteinaalimento"));
        }
        if (!request.getParameter("lipideoalimento").isEmpty()) {
            lipideoAlimento = Double.parseDouble(request.getParameter("lipideoalimento"));
        }
        if (!request.getParameter("carboidratoalimento").isEmpty()) {
            carboidratoAlimento = Double.parseDouble(request.getParameter("carboidratoalimento"));
        }
        if (!request.getParameter("fibraalimentaralimento").isEmpty()) {
            fibraAlimentarAlimento = Double.parseDouble(request.getParameter("fibraalimentaralimento"));
        }

//        mensagem = validacao(nomeTabelaNutricionalAlimento, nomeAlimento, tipoAlimento, especieAlimento, proteinaAlimento, lipideoAlimento, carboidratoAlimento, lipideoAlimento);
//        if (mensagem != null && !mensagem.equals("")) {
//            request.setAttribute("sucesso", mensagem);
//            request.getRequestDispatcher("cadastraralimento.jsp").forward(request, response);
        boolean isMultipart = FileUpload.isMultipartContent(request);
        if (isMultipart) {

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            String data = dateFormat.format(date);
            data = data.replace(":", "");
            data = data.replace(" ", "");
            data = data.replace("/", "");

            DiskFileUpload upload = new DiskFileUpload();
            upload.setSizeMax(50 * 1024 * 1024);
            upload.setRepositoryPath(this.getServletContext().getRealPath("") + "/imagem/");

            List itens = upload.parseRequest(request);
            Iterator it = itens.iterator();
            while (it.hasNext()) {
                FileItem fitem = (FileItem) it.next();
                if (!fitem.isFormField()) {
                    try {
                        fitem.write(new File(this.getServletContext().getRealPath("") + "/imagem/imagem_" + data + ".png"));
                    } catch (Exception ex) {
                        System.out.println("Erro ao pegar o nome do arquivo" + ex.getMessage());
                        ex.printStackTrace();
                    }
                    caminhoImagemAlimento = this.getServletContext().getRealPath("") + "imagem\\imagem_" + data + ".png";
                } else {
                    String dados = fitem.getFieldName();
                    if (dados.equals("nomealimento")) {
                        nomeAlimento = fitem.getString();
                    }
                }
            }

        }

        Alimento alimento = new Alimento();

        alimento.setNomeTabelaNutricionalAlimento(nomeTabelaNutricionalAlimento.toUpperCase().trim());
        alimento.setNomeAlimento(nomeAlimento.toUpperCase().trim());
        alimento.setTipoAlimento(tipoAlimento.toUpperCase().trim());
        alimento.setEspecieAlimento(especieAlimento.toUpperCase().trim());
        alimento.setStatusAlimento("A");
        alimento.setCarboidratoAlimento(carboidratoAlimento);
        alimento.setLipideoAlimento(lipideoAlimento);
        alimento.setProteinaAlimento(proteinaAlimento);
        alimento.setFibraAlimentarAlimento(fibraAlimentarAlimento);
        alimento.setCaminhoImagemAlimento(caminhoImagemAlimento);

        try {
            GenericDAO dao = new AlimentoDAOImpl();
            if (dao.cadastrar(alimento)) {
                mensagem = "Cadastrado com sucesso";
                String script = "<script>$('#erroAlimento').modal('show');</script>";
                request.setAttribute("script", script);
            } else {
                mensagem = "Erro ao cadastrar";
                String script = "<script>$('#erroAlimento').modal('show');</script>";
                request.setAttribute("script", script);
            }

            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("nutricionista\\cadastraralimento.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
            ex.printStackTrace();
        }

    }

//    public String validacao(String nomeTabela, String nomeAlimento, String tipoAlimento, String especieAlimento, Double proteina, Double lipideo, Double carboidrato, Double fibra) {
//        String msg = "";
//        if (nomeTabela.equals("") || nomeTabela == null) {
//            msg = msg + "<br>Nome da tabela não pode ficar em branco";
//        }
////        if (!nomeTabela.matches("[a-zA-Z\\s]+")) {
////            msg = msg + "<br>Caracteres inválidos para nome da tabela ";
////        }
//        if (nomeTabela.length() > 50) {
//            msg = msg + "<br>Total de caracteres não permitidos para o campo nome da tabela ";
//        }
//        if (nomeAlimento.equals("") || nomeAlimento == null) {
//            msg = msg + "<br>Nome do alimento não pode ficar em branco";
//        }
////        if (!nomeAlimento.matches("[a-zA-Z\\s]+")) {
////            msg = msg + "<br>Caracteres inválidos para nome do alimento";
////        }
//        if (nomeAlimento.length() > 100) {
//            msg = msg + "<br>Total de caracteres não permitidos para o campo nome do alimento ";
//        }
//        if (tipoAlimento.equals("") || tipoAlimento == null) {
//            msg = msg + "<br>Tipo alimento não pode ficar em branco";
//        }
//        if (tipoAlimento.length() > 50) {
//            msg = msg + "<br>Total de caracteres não permitidos para o campo tipo do alimento ";
//        }
////        if (!especieAlimento.matches("[a-zA-Z\\s]+")) {
////            msg = msg + "<br>Caracteres inválidos para especie do alimento";
////        }
//        if (especieAlimento.length() > 50) {
//            msg = msg + "<br>Total de caracteres não permitidos para o campo espécie do alimento";
//        }
//        if(proteina == null){
//            msg = msg +"<br>Tipo alimento não pode ficar em branco";
//        }
//
//        return msg;
//    }
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

        //        String mensagem = null;
//        String nomeTabelaNutricionalAlimento = request.getParameter("nometabelanutricionalalimento");
//        String nomeAlimento = request.getParameter("nomealimento");
//        String tipoAlimento = request.getParameter("tipoalimento");
//        String especieAlimento = request.getParameter("especiealimento");
//        Double proteinaAlimento = Double.parseDouble(request.getParameter("proteinaalimento"));
//        Double lipideoAlimento = Double.parseDouble(request.getParameter("lipideoalimento"));
//        Double carboidratoAlimento = Double.parseDouble(request.getParameter("carboidratoalimento"));
//        Double fibraAlimentarAlimento = Double.parseDouble(request.getParameter("fibraalimentaralimento"));
//        String caminhoImagemAlimento = null;
//
//        boolean isMultiPart = FileUpload.isMultipartContent(request);
//        if (isMultiPart) {
//            FileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            String formulario = "";
//
//            try {
//                List items = upload.parseRequest(request);
//                Iterator iter = items.iterator();
//                while (iter.hasNext()) {
//                    FileItem item = (FileItem) iter.next();
//                    if (item.getFieldName().equals("nomealimento")) {
//                        formulario = item.getString();
//                    }
//                    if (!item.isFormField()) {
//                        if (item.getName().length() > 0) {
//                            this.cadastrarAlimento(item);
//                        }
//                    }
//                }
//
//            } catch (FileUploadException ex) {
//                ex.printStackTrace();
//            }
//
//            Alimento alimento = new Alimento();
//
//            alimento.setNomeTabelaNutricionalAlimento(nomeTabelaNutricionalAlimento.toUpperCase().trim());
//            alimento.setNomeAlimento(nomeAlimento.toUpperCase().trim());
//            alimento.setTipoAlimento(tipoAlimento.toUpperCase().trim());
//            alimento.setEspecieAlimento(especieAlimento.toUpperCase().trim());
//            alimento.setStatusAlimento("A");
//            alimento.setCarboidratoAlimento(carboidratoAlimento);
//            alimento.setLipideoAlimento(lipideoAlimento);
//            alimento.setProteinaAlimento(proteinaAlimento);
//            alimento.setFibraAlimentarAlimento(fibraAlimentarAlimento);
//            alimento.setSincronizaAlimento(1);
//            alimento.setCaminhoImagemAlimento(caminhoImagemAlimento);
//
//            try {
//                GenericDAO dao = new AlimentoDAOImpl();
//                if (dao.cadastrar(alimento)) {
//                    mensagem = "Cadastrado com sucesso";
//                } else {
//                    mensagem = "Erro ao cadastrar";
//                }
//
//                request.setAttribute("sucesso", mensagem);
//                request.getRequestDispatcher("cadastraralimento.jsp").forward(request, response);
//            } catch (Exception ex) {
//                System.out.println("Erro " + ex.getMessage());
//                ex.printStackTrace();
//            }
//
//        }
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            System.out.println("Problemas no doPOST" + ex.getMessage());
            ex.printStackTrace();
        }

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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            System.out.println("Problemas no doPOST" + ex.getMessage());
            ex.printStackTrace();
        }
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
