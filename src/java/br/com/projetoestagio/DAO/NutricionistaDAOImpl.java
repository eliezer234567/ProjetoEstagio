/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Nutricionista;
import br.com.projetoestagio.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leticia
 */
public class NutricionistaDAOImpl implements GenericDAO {

    private Connection conn;

    public NutricionistaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Nutricionista nutricionista = (Nutricionista) object;
        PreparedStatement stmt = null;
        String sql = "Insert into nutricionista(crn_nutricionista, id_pessoa)values(?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, nutricionista.getCrnNutricionista());
            try {
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(2, daoPessoa.cadastrar(nutricionista));
            } catch (Exception ex) {
                System.out.println("Erro ao cadastrar pessoa!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
            stmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar nutricionista!Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, n.*from pessoa p, nutricionista n where p.id_pessoa = n.id_pessoa order by nome_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Nutricionista nutricionista = new Nutricionista();
                nutricionista.setIdPessoa(rs.getInt("id_pessoa"));
                nutricionista.setNomePessoa(rs.getString("nome_pessoa"));
                nutricionista.setSenhaPessoa(rs.getString("senha_pessoa"));
                nutricionista.setStatusPessoa(rs.getString("status_pessoa"));
                nutricionista.setTelefonePessoa(rs.getString("telefone_pessoa"));
                nutricionista.setEmailPessoa(rs.getString("email_pessoa"));
                nutricionista.setIdNutricionista(rs.getInt("id_nutricionista"));
                nutricionista.setCrnNutricionista(rs.getInt("crn_nutricionista"));
                nutricionista.setTipoPessoa(rs.getString("tipo_pessoa"));
                resultado.add(nutricionista);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Nutricionista!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexão!Erro:" + ex.getMessage());
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
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nutricionista nutricionista = null;
        String sql = "select p.*,n.* from pessoa p, nutricionista n where p.id_pessoa = n.id_pessoa and p.id_pessoa = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while(rs.next()){
                nutricionista = new Nutricionista();
                nutricionista.setIdPessoa(rs.getInt("id_pessoa"));
                nutricionista.setNomePessoa(rs.getString("nome_pessoa"));
                nutricionista.setSenhaPessoa(rs.getString("senha_pessoa"));
                nutricionista.setStatusPessoa(rs.getString("status_pessoa"));
                nutricionista.setTelefonePessoa(rs.getString("telefone_pessoa"));
                nutricionista.setEmailPessoa(rs.getString("email_pessoa"));
                nutricionista.setIdNutricionista(rs.getInt("id_nutricionista"));
                nutricionista.setCrnNutricionista(rs.getInt("crn_nutricionista"));
                nutricionista.setTipoPessoa(rs.getString("tipo_pessoa"));
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao carregar Nutricionista!Erro:" + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return nutricionista;
    }
    
    //carregar idNutricionista no cadastrar paciente
    public Object carregarIdNutricionistaCadastrarConsulta(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nutricionista nutricionista = null;
        String sql = "select p.*,n.* from pessoa p, nutricionista n where p.id_pessoa = n.id_pessoa and p.id_pessoa = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while(rs.next()){
                nutricionista = new Nutricionista();
                nutricionista.setIdPessoa(rs.getInt("id_pessoa"));
                nutricionista.setNomePessoa(rs.getString("nome_pessoa"));
                nutricionista.setSenhaPessoa(rs.getString("senha_pessoa"));
                nutricionista.setStatusPessoa(rs.getString("status_pessoa"));
                nutricionista.setTelefonePessoa(rs.getString("telefone_pessoa"));
                nutricionista.setEmailPessoa(rs.getString("email_pessoa"));
                nutricionista.setIdNutricionista(rs.getInt("id_nutricionista"));
                nutricionista.setCrnNutricionista(rs.getInt("crn_nutricionista"));
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao carregar Nutricionista!Erro:" + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return nutricionista;
    }

    @Override
    public Boolean alterar(Object object) {
        Nutricionista nutricionista = (Nutricionista) object;
        PreparedStatement stmt = null;
        String sql = "update nutricionista set crn_nutricionista = ? where id_pessoa = ?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,nutricionista.getCrnNutricionista());
            stmt.setInt(2,nutricionista.getIdPessoa());
            try{
                PessoaDAOImpl dao = new PessoaDAOImpl();
                if(dao.alterar(nutricionista)){
                    stmt.executeUpdate();
                    return true;
                }else{
                    return false;
                }
            }catch(Exception ex){
                System.out.println("Problemas ao alterar Pessoa!Erro:" + ex.getMessage());
                ex.printStackTrace();
                return false;
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao alterar Nutricionista!Erro:" +ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean inativar(Object object) {
        Nutricionista nutricionista = (Nutricionista) object;
        PreparedStatement stmt = null;
        //INATIVAR AS 2 CLASSES DA HERANÇA
        String sql = "update pessoa set status_pessoa = ? where id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nutricionista.getStatusPessoa());
            stmt.setInt(2, nutricionista.getIdPessoa());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Nutricionista! Erro: " + ex.getMessage());
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
