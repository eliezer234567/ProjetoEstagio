/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;


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
 * @author princesinha
 */
public class PatologiaDAOImpl implements GenericDAO{

    private Connection conn;

    public PatologiaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso !");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
       Patologia patologia=(Patologia) object;
        PreparedStatement stmt = null;
        String sql = "Insert into patologia(nome_patologia, descricao_patologia, historico_familia_patologia, status_patologia)values(?,?,?,? );";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,patologia.getNomePatologia());
            stmt.setString(2,patologia.getDescricaoPatologia());
            stmt.setString(3,patologia.getHistoricofamiliaPatologia());
            stmt.setString(4,patologia.getStatusPatologia());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Patologia! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão ! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    @Override
 public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from patologia";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Patologia patologia= new Patologia();
                patologia.setIdPatologia(rs.getInt("id_patologia"));
                patologia.setNomePatologia(rs.getString("nome_patologia"));
                patologia.setDescricaoPatologia(rs.getString("descricao_patologia"));
                patologia.setHistoricofamiliaPatologia(rs.getString("historico_familia_patologia"));
                patologia.setStatusPatologia(rs.getString("status_patologia"));            
                resultado.add(patologia);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar patologia! Erro" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }
 
 @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Patologia patologia = null;
        String sql = "select p.* from patologia p where id_patologia=? ;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                patologia= new Patologia();
                patologia.setIdPatologia(rs.getInt("id_patologia"));
                patologia.setNomePatologia(rs.getString("nome_patologia"));
                patologia.setDescricaoPatologia(rs.getString("descricao_patologia"));
                patologia.setHistoricofamiliaPatologia(rs.getString("historico_familia_patologia"));
                patologia.setStatusPatologia(rs.getString("status_patologia"));            
            }
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Patologia! Erro" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return patologia;
    }

    @Override
    public Boolean alterar(Object object) {

        Patologia patologia = (Patologia) object;
        PreparedStatement stmt = null;
        String sql = "Update patologia set nome_patologia=?, descricao_patologia=?, historico_familia_patologia=? where id_patologia=?;";
        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, patologia.getNomePatologia());
            stmt.setString(2, patologia.getDescricaoPatologia());
            stmt.setString(3, patologia.getHistoricofamiliaPatologia());
            stmt.setInt(4, patologia.getIdPatologia());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar patologia! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão ! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean inativar(Object object) {
        
        Patologia patologia = (Patologia) object;
        PreparedStatement stmt = null;
        String sql = "update patologia set status_patologia =? where id_patologia=?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, patologia.getStatusPatologia());
            stmt.setInt(2, patologia.getIdPatologia());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Patologia! Erro: " + ex.getMessage());
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
}
   