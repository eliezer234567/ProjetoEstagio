package br.com.projetoestagio.controller;

import br.com.projetoestagio.DAO.FrequenciaAlimentarDAOImpl;
import br.com.projetoestagio.DAO.GenericDAO;
import br.com.projetoestagio.model.FrequenciaAlimentar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarFrequenciaAlimentar", urlPatterns = {"/AlterarFrequenciaAlimentar"})
public class AlterarFrequenciaAlimentar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensagem=null;
        
        Integer idFrequenciaAlimentar = Integer.parseInt(request.getParameter("idFrequenciaAlimentar"));
        String frutaFrequenciaAlimentar = request.getParameter("frutaFrequenciaAlimentar");
        String verdurasFrequenciaAlimentar = request.getParameter("verdurasFrequenciaAlimentar");
        String legumesFrequenciaAlimentar = request.getParameter("legumesFrequenciaAlimentar");
        String carnevermelhaFrequenciaAlimentar = request.getParameter("carnevermelhaFrequenciaAlimentar");
        String carnebrancaFrequenciaAlimentar = request.getParameter("carnebrancaFrequenciaAlimentar");
        String leitederivadosFrequenciaAlimentar = request.getParameter("leitederivadosFrequenciaAlimentar");
        String ovosFrequenciaAlimentar = request.getParameter("ovosFrequenciaAlimentar");
        String cereaisFrequenciaAlimentar = request.getParameter("cereaisFrequenciaAlimentar");
        String massasFrequenciaAlimentar = request.getParameter("massasFrequenciaAlimentar");
        String leguminosasFrequenciaAlimentar = request.getParameter("leguminosasFrequenciaAlimentar");
        String paesFrequenciaAlimentar = request.getParameter("paesFrequenciaAlimentar");
        String docesFrequenciaAlimentar = request.getParameter("docesFrequenciaAlimentar");
        String refrigeranteFrequenciaAlimentar = request.getParameter("refrigeranteFrequenciaAlimentar");
        String alcoolFrequenciaAlimentar = request.getParameter("alcoolFrequenciaAlimentar");
        String gordurososFrequenciaAlimentar = request.getParameter("gordurososFrequenciaAlimentar");
        
        
                FrequenciaAlimentar frequenciaalimentar = new FrequenciaAlimentar();   
               frequenciaalimentar.setIdFrequenciaAlimentar(idFrequenciaAlimentar);
               if(frutaFrequenciaAlimentar.equals("DF")){
                    frequenciaalimentar.setFrutaFrequenciaAlimentar("Diariamente");
                }else if(frutaFrequenciaAlimentar.equals("VF")){
                 frequenciaalimentar.setFrutaFrequenciaAlimentar("3 vezes por semana");
                }else if(frutaFrequenciaAlimentar.equals("FF")){
                frequenciaalimentar.setFrutaFrequenciaAlimentar("Final de semana");
                 }else if(frutaFrequenciaAlimentar.equals("RF")){
                frequenciaalimentar.setFrutaFrequenciaAlimentar("Raramente");
                }
                if(verdurasFrequenciaAlimentar.equals("DV")){
                    frequenciaalimentar.setVerdurasFrequenciaAlimentar("Diariamente");
                }else if(verdurasFrequenciaAlimentar.equals("VV")){
                 frequenciaalimentar.setVerdurasFrequenciaAlimentar("3 vezes por semana");
                }else if(verdurasFrequenciaAlimentar.equals("FV")){
                frequenciaalimentar.setVerdurasFrequenciaAlimentar("Final de semana");
                }else if(verdurasFrequenciaAlimentar.equals("RV")){
                frequenciaalimentar.setVerdurasFrequenciaAlimentar("Raramente");
                }
                if(legumesFrequenciaAlimentar.equals("DL")){
                    frequenciaalimentar.setLegumesFrequenciaAlimentar("Diariamente");
                }else if(legumesFrequenciaAlimentar.equals("VL")){
                 frequenciaalimentar.setLegumesFrequenciaAlimentar("3 vezes por semana");
                }else if(legumesFrequenciaAlimentar.equals("FL")){
                frequenciaalimentar.setLegumesFrequenciaAlimentar("Final de semana");
                }else if(legumesFrequenciaAlimentar.equals("RL")){
                frequenciaalimentar.setLegumesFrequenciaAlimentar("Raramente");
                }
                if(carnevermelhaFrequenciaAlimentar.equals("DCV")){
                    frequenciaalimentar.setCarnevermelhaFrequenciaAlimentar("Diariamente");
                }else if(carnevermelhaFrequenciaAlimentar.equals("VCV")){
                 frequenciaalimentar.setCarnevermelhaFrequenciaAlimentar("3 vezes por semana");
                }else if(carnevermelhaFrequenciaAlimentar.equals("FCV")){
                frequenciaalimentar.setCarnevermelhaFrequenciaAlimentar("Final de semana");
                 }else if(carnevermelhaFrequenciaAlimentar.equals("RCV")){
                frequenciaalimentar.setCarnevermelhaFrequenciaAlimentar("Raramente");
                }
                 if(carnebrancaFrequenciaAlimentar.equals("DCB")){
                    frequenciaalimentar.setCarnebrancaFrequenciaAlimentar("Diariamente");
                }else if(carnebrancaFrequenciaAlimentar.equals("VCB")){
                 frequenciaalimentar.setCarnebrancaFrequenciaAlimentar("3 vezes por semana");
                }else if(carnebrancaFrequenciaAlimentar.equals("FCB")){
                frequenciaalimentar.setCarnebrancaFrequenciaAlimentar("Final de semana");
                 }else if(carnebrancaFrequenciaAlimentar.equals("RCB")){
                frequenciaalimentar.setCarnebrancaFrequenciaAlimentar("Raramente");
                }
                 if(leitederivadosFrequenciaAlimentar.equals("DLE")){
                    frequenciaalimentar.setLeitederivadosFrequenciaAlimentar("Diariamente");
                }else if(leitederivadosFrequenciaAlimentar.equals("VLE")){
                 frequenciaalimentar.setLeitederivadosFrequenciaAlimentar("3 vezes por semana");
                }else if(leitederivadosFrequenciaAlimentar.equals("FLE")){
                frequenciaalimentar.setLeitederivadosFrequenciaAlimentar("Final de semana");
                }else if(leitederivadosFrequenciaAlimentar.equals("RLE")){
                frequenciaalimentar.setLeitederivadosFrequenciaAlimentar("Raramente");
                }
                if(ovosFrequenciaAlimentar.equals("DO")){
                    frequenciaalimentar.setOvosFrequenciaAlimentar("Diariamente");
                }else if(ovosFrequenciaAlimentar.equals("VO")){
                 frequenciaalimentar.setOvosFrequenciaAlimentar("3 vezes por semana");
                }else if(ovosFrequenciaAlimentar.equals("FO")){
                frequenciaalimentar.setOvosFrequenciaAlimentar("Final de semana");
                 }else if(ovosFrequenciaAlimentar.equals("RO")){
                frequenciaalimentar.setOvosFrequenciaAlimentar("Raramente");
                }
                 if(cereaisFrequenciaAlimentar.equals("DC")){
                    frequenciaalimentar.setCereaisFrequenciaAlimentar("Diariamente");
                }else if(cereaisFrequenciaAlimentar.equals("VC")){
                 frequenciaalimentar.setCereaisFrequenciaAlimentar("3 vezes por semana");
               }else if(cereaisFrequenciaAlimentar.equals("FC")){
                frequenciaalimentar.setCereaisFrequenciaAlimentar("Final de semana");
                 }else if(cereaisFrequenciaAlimentar.equals("RC")){
                frequenciaalimentar.setCereaisFrequenciaAlimentar("Raramente");
                }
                 if(massasFrequenciaAlimentar.equals("DM")){
                    frequenciaalimentar.setMassasFrequenciaAlimentar("Diariamente");
                }else if(massasFrequenciaAlimentar.equals("VM")){
                 frequenciaalimentar.setMassasFrequenciaAlimentar("3 vezes por semana");
                }else if(massasFrequenciaAlimentar.equals("FM")){
                frequenciaalimentar.setMassasFrequenciaAlimentar("Final de semana");
                 }else if(massasFrequenciaAlimentar.equals("RM")){
                frequenciaalimentar.setMassasFrequenciaAlimentar("Raramente");
                }
                 if(leguminosasFrequenciaAlimentar.equals("DLEG")){
                    frequenciaalimentar.setLeguminosasFrequenciaAlimentar("Diariamente");
                }else if(leguminosasFrequenciaAlimentar.equals("VLEG")){
                 frequenciaalimentar.setLeguminosasFrequenciaAlimentar("3 vezes por semana");
                }else if(leguminosasFrequenciaAlimentar.equals("FLEG")){
                frequenciaalimentar.setLeguminosasFrequenciaAlimentar("Final de semana");
                 }else if(leguminosasFrequenciaAlimentar.equals("RLEG")){
                frequenciaalimentar.setLeguminosasFrequenciaAlimentar("Raramente");
                }
                if(paesFrequenciaAlimentar.equals("DP")){
                    frequenciaalimentar.setPaesFrequenciaAlimentar("Diariamente");
                }else if(paesFrequenciaAlimentar.equals("VP")){
                 frequenciaalimentar.setPaesFrequenciaAlimentar("3 vezes por semana");
                }else if(paesFrequenciaAlimentar.equals("FP")){
                frequenciaalimentar.setPaesFrequenciaAlimentar("Final de semana");
                 }else if(paesFrequenciaAlimentar.equals("RP")){
                frequenciaalimentar.setPaesFrequenciaAlimentar("Raramente");
                }
                 if(docesFrequenciaAlimentar.equals("DD")){
                    frequenciaalimentar.setDocesFrequenciaAlimentar("Diariamente");
                }else if(docesFrequenciaAlimentar.equals("VD")){
                 frequenciaalimentar.setDocesFrequenciaAlimentar("3 vezes por semana");
               }else if(docesFrequenciaAlimentar.equals("FD")){
                frequenciaalimentar.setDocesFrequenciaAlimentar("Final de semana");
                }else if(docesFrequenciaAlimentar.equals("RD")){
                frequenciaalimentar.setDocesFrequenciaAlimentar("Raramente");
                }
                  if(refrigeranteFrequenciaAlimentar.equals("DR")){
                    frequenciaalimentar.setRefrigeranteFrequenciaAlimentar("Diariamente");
                }else if(refrigeranteFrequenciaAlimentar.equals("VR")){
                 frequenciaalimentar.setRefrigeranteFrequenciaAlimentar("3 vezes por semana");
                }else if(refrigeranteFrequenciaAlimentar.equals("FR")){
                frequenciaalimentar.setRefrigeranteFrequenciaAlimentar("Final de semana");
                 }else if(refrigeranteFrequenciaAlimentar.equals("RR")){
                frequenciaalimentar.setRefrigeranteFrequenciaAlimentar("Raramente");
                }
                 if(alcoolFrequenciaAlimentar.equals("DA")){
                    frequenciaalimentar.setAlcoolFrequenciaAlimentar("Diariamente");
                }else if(alcoolFrequenciaAlimentar.equals("VA")){
                 frequenciaalimentar.setAlcoolFrequenciaAlimentar("3 vezes por semana");
                }else if(alcoolFrequenciaAlimentar.equals("FA")){
                frequenciaalimentar.setAlcoolFrequenciaAlimentar("Final de semana");
                 }else if(alcoolFrequenciaAlimentar.equals("RA")){
                frequenciaalimentar.setAlcoolFrequenciaAlimentar("Raramente");
                }
                  if(gordurososFrequenciaAlimentar.equals("DG")){
                    frequenciaalimentar.setGordurososFrequenciaAlimentar("Diariamente");
                }else if(gordurososFrequenciaAlimentar.equals("VG")){
                 frequenciaalimentar.setGordurososFrequenciaAlimentar("3 vezes por semana");
                }else if(gordurososFrequenciaAlimentar.equals("FG")){
                frequenciaalimentar.setGordurososFrequenciaAlimentar("Final de semana");
                 }else if(gordurososFrequenciaAlimentar.equals("RG")){
                frequenciaalimentar.setGordurososFrequenciaAlimentar("Raramente");
                 }
        try {
            GenericDAO dao = new FrequenciaAlimentarDAOImpl();
            if (dao.alterar(frequenciaalimentar)) {
                mensagem = "Alterado Com Sucesso!";
            } else {
                mensagem = "Erro Ao Alterar!";
            }
            request.setAttribute("sucesso", mensagem);
            request.getRequestDispatcher("ListarFrequenciaAlimentar").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Erro ao alterar FrequenciaAlimentar na Servlet" + ex.getMessage());
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
