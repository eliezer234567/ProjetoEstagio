/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Alimento;
import br.com.projetoestagio.model.TipoRefeicao;
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
public class TipoRefeicaoDAOImpl implements GenericDAO{

    private Connection conn;

    public TipoRefeicaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        TipoRefeicao tiporefeicao = (TipoRefeicao) object;
        PreparedStatement stmt = null;
        String sql = "Insert into tiporefeicao (tipo_refeicao) values (?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tiporefeicao.getTipoRefeicao());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao Cadastrar  TipoDAOImpl" + ex.getMessage());
            ex.printStackTrace();

            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select tr.* from tiporefeicao tr order by tr.tipo_refeicao;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TipoRefeicao tiporefeicao = new TipoRefeicao();
                tiporefeicao.setIdTipoRefeicao(rs.getInt("id_tipo_refeicao"));
                tiporefeicao.setTipoRefeicao(rs.getString("tipo_refeicao"));
                resultado.add(tiporefeicao);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar TipoDAOImpl" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
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
        TipoRefeicao tipo = null;
        String sql = "select * from tiporefeicao where id_tipo_refeicao=? ;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tipo = new TipoRefeicao();
                tipo.setIdTipoRefeicao(rs.getInt("id_tipo_refeicao"));
                tipo.setTipoRefeicao(rs.getString("tipo_refeicao"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar AlimentoDAOImpl" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão AlimentoDAOImpl" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return tipo;
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean inativar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
