/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Pessoa;
import br.com.projetoestagio.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leticia
 */
public class PessoaDAOImpl {

    private Connection conn;

    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Pessoa pessoa) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idPessoa = null;
        String sql = "Insert into pessoa(nome_pessoa, telefone_pessoa, email_pessoa, senha_pessoa, status_pessoa, tipo_pessoa, foto_pessoa)"
                + "values(?, ?, ?, ?, ?, ?, ?) returning id_pessoa;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            stmt.setString(3, pessoa.getEmailPessoa());
            stmt.setString(4, pessoa.getSenhaPessoa());
            stmt.setString(5, pessoa.getStatusPessoa());
            stmt.setString(6, pessoa.getTipoPessoa());
            stmt.setString(7, pessoa.getFotoPessoa());
            rs = stmt.executeQuery();
            if (rs.next()) {
                idPessoa = rs.getInt("id_pessoa");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar pessoa" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar a conexão" + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return idPessoa;
    }

    
    public Pessoa logar(String emailPessoa, String senhaPessoa){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        String sql = "select p.id_pessoa, p.nome_pessoa, p.tipo_pessoa from pessoa p where p.email_pessoa = ? and p.senha_pessoa = ?;";
        try{
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,emailPessoa);
            stmt.setString(2,senhaPessoa);
            rs = stmt.executeQuery();   
            while(rs.next()){
              pessoa = new Pessoa();
              pessoa.setIdPessoa(rs.getInt("id_pessoa"));
              pessoa.setNomePessoa(rs.getString("nome_pessoa"));
              pessoa.setEmailPessoa(rs.getString("email_pessoa"));
              pessoa.setSenhaPessoa(rs.getString("senha_pessoa"));
              pessoa.setTipoPessoa(rs.getString("tipo_pessoa"));
              
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao logar!Erro:" + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar paramentros de conexão!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return pessoa;
    }
    
    public Boolean alterar(Pessoa pessoa) {
        PreparedStatement stmt = null;
        String sql = "update pessoa set nome_pessoa = ?, email_pessoa = ?, senha_pessoa = ?, telefone_pessoa = ?, tipo_pessoa = ? where id_pessoa = ?;";
                                                        
        try {                                                                                                                    
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEmailPessoa());
            stmt.setString(3, pessoa.getSenhaPessoa());
            stmt.setString(4, pessoa.getTelefonePessoa());
            stmt.setString(5, pessoa.getTipoPessoa());
            stmt.setInt(6, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Pessoa!Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar paramentros de conexão!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


    public Pessoa verificarUsuario(String email, String senha) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        String sql = "select p.* from pessoa p where p.email_pessoa = ? and p.senha_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setNomePessoa(rs.getString("nome_pessoa"));
                pessoa.setEmailPessoa(rs.getString("email_pessoa"));
                pessoa.setSenhaPessoa(rs.getString("senha_pessoa"));
                pessoa.setTipoPessoa(rs.getString("tipo_pessoa"));
                pessoa.setFotoPessoa(rs.getString("foto_pessoa"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao logar! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return pessoa;
    }

}
