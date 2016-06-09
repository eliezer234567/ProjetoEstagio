/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Exame;
import br.com.projetoestagio.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eliezer
 */
public class ExameDAOImpl implements GenericDAO{
    
    private Connection conn;
    public ExameDAOImpl() throws Exception{
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Exame exame = (Exame) object;
        PreparedStatement stmt = null;
        String sql = " INSERT INTO exmae (id_consulta,nome_exame,imagem_exame, data_exame, sincroniza_exame, staus_exame)"
                + "VALUES(?,?,?,?,?,?);";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, exame.getConsulta().getIdConsulta());
            stmt.setString(2, exame.getNomeExame());
            stmt.setString(3, exame.getImagemExame());
            stmt.setDate(4, new java.sql.Date(exame.getDataExame().getTime()));
            stmt.setString(5, exame.getSincronizaExame());
            stmt.setString(6, exame.getStatusExame());
            stmt.execute();
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas ao cadastrar exame!Erro:" +ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conexão!Erro:" +ex.getMessage());
                ex.printStackTrace();
            }
        }
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
