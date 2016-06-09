/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Avaliacao;
import br.com.projetoestagio.model.AvaliacaoPatologia;
import br.com.projetoestagio.model.Patologia;
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
public class AvaliacaoPatologiaDAOImpl implements GenericDAO{
    
    private Connection conn;

    public AvaliacaoPatologiaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        
        AvaliacaoPatologia avaliacaoPatologia =(AvaliacaoPatologia) object;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        String sql = "INSERT INTO avaliacaopatologia (id_patologia, id_avaliacao) VALUES (?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, avaliacaoPatologia.getPatologia().getIdPatologia());
            stmt.setInt(2, avaliacaoPatologia.getAvaliacao().getIdAvaliacao());
            stmt.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar AvaliacaoPatologia! Erro: " + ex.getMessage());
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
    public List<AvaliacaoPatologia> tabelaavaliacaopatologia(int idAvaliacaoPatologia) {
        
        List<AvaliacaoPatologia> resultado = new ArrayList<>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT ap.*,p.*,a.id_avaliacao FROM patologia p, avaliacao a, avaliacaopatologia ap "
                + "WHERE a.id_avaliacao = ap.id_avaliacao and ap.id_patologia = p.id_patologia "
                + "AND a.id_avaliacao = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAvaliacaoPatologia);
            rs=stmt.executeQuery();
            while(rs.next()){
                AvaliacaoPatologia avaliacaopatologia = new AvaliacaoPatologia();
                Avaliacao avaliacao = new Avaliacao();
                Patologia patologia = new Patologia();                
                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
                patologia.setIdPatologia(rs.getInt("id_patologia"));
                patologia.setNomePatologia(rs.getString("nome_patologia"));
                patologia.setDescricaoPatologia(rs.getString("descricao_patologia"));
                avaliacaopatologia.setId_avaliacao_patologia(rs.getInt("id_avaliacao_patologia"));
                avaliacaopatologia.setAvaliacao(avaliacao);
                avaliacaopatologia.setPatologia(patologia);
                
                resultado.add(avaliacaopatologia);
            }
        }
        catch(SQLException ex){
            System.out.println("Problemas ao listar patologia! Ero: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: "+ ex.getMessage());
                ex.printStackTrace();
            }
        }
        System.out.println("Criado tabela com sucesso");
        return resultado;
    }
    
    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM avaliacaopatologia WHERE id_avaliacao_patologia = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.execute();
            System.out.println("excluido");
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir AvaliacaoPatologia! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
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
