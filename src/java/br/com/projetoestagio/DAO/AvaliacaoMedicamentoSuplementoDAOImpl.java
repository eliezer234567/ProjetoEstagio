/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Avaliacao;
import br.com.projetoestagio.model.AvaliacaoMedicamentoSuplemento;
import br.com.projetoestagio.model.MedicamentoSuplemento;
import br.com.projetoestagio.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grazy
 */
public class AvaliacaoMedicamentoSuplementoDAOImpl implements GenericDAO{
    
    private Connection conn;

    public AvaliacaoMedicamentoSuplementoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    

    @Override
    public Boolean cadastrar(Object object) {
        
        AvaliacaoMedicamentoSuplemento avaliacaoMedicamentoSuplemento =(AvaliacaoMedicamentoSuplemento) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        String sql = "INSERT INTO avaliacaomedicamentosuplemento (dose_avaliacao_medicamento_suplemento,"
                + "frequencia_avaliacao_medicamento_suplemento,"
                + "id_medicamento_suplemento, id_avaliacao) VALUES (?,?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, avaliacaoMedicamentoSuplemento.getDose_avaliacao_medicamento_suplemento());
            stmt.setString(2, avaliacaoMedicamentoSuplemento.getFrequencia_avaliacao_medicamento_suplemento());
            stmt.setInt(3, avaliacaoMedicamentoSuplemento.getMedicamentoSuplemento().getIdMedicamentoSuplemento());
            stmt.setInt(4, avaliacaoMedicamentoSuplemento.getAvaliacao().getIdAvaliacao());
            stmt.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar AvaliacaoMedicamentoSuplemento! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
    }
    
    //parametros via ajax
    public List<Avaliacao> tabelaavaliacaomedicamento(int idAvaliacao, int idMedicamento) {

    List<Avaliacao> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT m.*,a.id_avaliacao FROM medicamentosuplemento m, avaliacao a, avaliacaomedicamentosuplemento ams "
                + "WHERE a.id_avaliacao = ams.id_avaliacao and ams.id_medicamento_suplemento = m.id_medicamento_suplemento "
                + "AND a.id_avaliacao = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAvaliacao);
            rs=stmt.executeQuery();
            while(rs.next()){
                Avaliacao avaliacao = new Avaliacao();
                MedicamentoSuplemento medicamento = new MedicamentoSuplemento();
                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
                medicamento.setIdMedicamentoSuplemento(rs.getInt("id_medicamento_suplemento"));
                medicamento.setNomeMedicamentoSuplemento(rs.getString("nome_medicamento_suplemento"));
                medicamento.setTipoMedicamentoSuplemento(rs.getString("tipo_medicamento_suplemento"));
                avaliacao.setMedicamentoSuplemento(medicamento);
                
                resultado.add(avaliacao);
            }
        }
        catch(SQLException ex){
            System.out.println("Problemas ao listar medicamento/suplemento! Ero: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean inativar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
