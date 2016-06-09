/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

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
 * @author Grazy Martins
 */
public class MedicamentoSuplementoDAOImpl implements GenericDAO{
    
    private Connection conn;

    public MedicamentoSuplementoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

    MedicamentoSuplemento medicamentosuplemento = (MedicamentoSuplemento) object;
        PreparedStatement stmt = null;
        String sql = "Insert into medicamentosuplemento(nome_medicamento_suplemento, tipo_medicamento_suplemento,"
                + "sincroniza_medicamento_suplemento, status_medicamento_suplemento )values(?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, medicamentosuplemento.getNomeMedicamentoSuplemento());
            stmt.setString(2, medicamentosuplemento.getTipoMedicamentoSuplemento());
            stmt.setInt(3, medicamentosuplemento.getSincronizaMedicamentoSuplemento());
            stmt.setString(4, medicamentosuplemento.getStatusMedicamentoSuplemento());
            stmt.execute();
            
            return true;
            
        } catch (Exception ex) {
            System.out.println("Erro no cadastro de Medicamento/Suplemento " + ex.getMessage());
            ex.printStackTrace();
            
            return false;
            
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão Medicamento/Suplemento " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public List<Object> listar() {

    List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select m.* from medicamentosuplemento m order by m.nome_medicamento_suplemento;";
        try{
            stmt = conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                MedicamentoSuplemento medicamentosuplemento = new MedicamentoSuplemento();
                medicamentosuplemento.setIdMedicamentoSuplemento(rs.getInt("id_medicamento_suplemento"));
                medicamentosuplemento.setNomeMedicamentoSuplemento(rs.getString("nome_medicamento_suplemento"));
                medicamentosuplemento.setTipoMedicamentoSuplemento(rs.getString("tipo_medicamento_suplemento"));
                medicamentosuplemento.setSincronizaMedicamentoSuplemento(rs.getInt("sincroniza_medicamento_suplemento"));
                medicamentosuplemento.setStatusMedicamentoSuplemento(rs.getString("status_medicamento_suplemento"));
                
                resultado.add(medicamentosuplemento);
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
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean inativar(Object object) {

    MedicamentoSuplemento medicamentosuplemento = (MedicamentoSuplemento) object;
        PreparedStatement stmt = null;
        String sql = "update medicamentosuplemento set status_medicamento_suplemento = ? where id_medicamento_suplemento = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, medicamentosuplemento.getStatusMedicamentoSuplemento());
            stmt.setInt(2, medicamentosuplemento.getIdMedicamentoSuplemento());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Medicamento/Suplemento! Erro: " + ex.getMessage());
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

    @Override
    public Object carregar(int idObject) {

    PreparedStatement stmt = null;
        ResultSet rs = null;
        MedicamentoSuplemento medicamentosuplemento = null;
        
        String sql = "select m.* from medicamentosuplemento m where m.id_medicamento_suplemento=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                medicamentosuplemento = new MedicamentoSuplemento();

                medicamentosuplemento.setIdMedicamentoSuplemento(rs.getInt("id_medicamento_suplemento"));
                medicamentosuplemento.setNomeMedicamentoSuplemento(rs.getString("nome_medicamento_suplemento"));
                medicamentosuplemento.setTipoMedicamentoSuplemento(rs.getString("tipo_medicamento_suplemento"));
                medicamentosuplemento.setSincronizaMedicamentoSuplemento(rs.getInt("sincroniza_medicamento_suplemento"));
                medicamentosuplemento.setStatusMedicamentoSuplemento(rs.getString("status_medicamento_suplemento"));

            }

        } catch (Exception ex) {
            System.out.println("Erro ao carregar Medicamento/Suplemento " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return medicamentosuplemento;
    }

    @Override
    public Boolean alterar(Object object) {

    MedicamentoSuplemento medicamentosuplemento = (MedicamentoSuplemento) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE medicamentosuplemento SET nome_medicamento_suplemento = ?, tipo_medicamento_suplemento = ?, "
                + "sincroniza_medicamento_suplemento = ?, status_medicamento_suplemento = ? WHERE id_medicamento_suplemento = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, medicamentosuplemento.getNomeMedicamentoSuplemento());
            stmt.setString(2, medicamentosuplemento.getTipoMedicamentoSuplemento());
            stmt.setInt(3, medicamentosuplemento.getSincronizaMedicamentoSuplemento());
            stmt.setString(4, medicamentosuplemento.getStatusMedicamentoSuplemento());
            stmt.setInt(5, medicamentosuplemento.getIdMedicamentoSuplemento());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Problmas ao alterar Medicamento/Suplemento! Erro: " + ex.getMessage());
            ex.printStackTrace();
            
            return false;
            
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexao! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
