/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Alimento;
import br.com.projetoestagio.model.AlimentoRefeicao;
import br.com.projetoestagio.model.Cardapio;
import br.com.projetoestagio.model.Refeicao;
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
public class RefeicaoDAOImpl implements GenericDAO {

    private Connection conn;

    public RefeicaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Refeicao refeicao) {
        Integer idRefeicao = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String sql = "insert into refeicao (dia_refeicao, status_refeicao, "
                + "hora_refeicao, id_tipo_refeicao, id_cardapio) values "
                + "(?,?,?,?,?) returning id_refeicao;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, refeicao.getDiaRefeicao());
            stmt.setString(2, refeicao.getStatusRefeicao());
            stmt.setString(3, refeicao.getHoraRefeicao());
            stmt.setInt(4, refeicao.getTipoRefeicao().getIdTipoRefeicao());
            stmt.setInt(5, refeicao.getCardapio().getIdCardapio());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idRefeicao = rs.getInt("id_refeicao");
            }

        } catch (SQLException ex) {
            System.out.println("Erro na RefeicaoDAOImpl ao cadastrar Refeicao  " + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idRefeicao;
    }

    public List<AlimentoRefeicao> listarRefeicaoPorCardapio(Integer idCardapio) {
        List<AlimentoRefeicao> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select r.dia_refeicao, r.hora_refeicao, tr.tipo_refeicao, a.nome_alimento, r.id_cardapio, ar.quantidade_alimento_refeicao, ar.tipo_medida_alimento_refeicao "
                + "from refeicao r "
                + "inner join alimentorefeicao ar "
                + "on r.id_refeicao = ar.id_refeicao "
                + "inner join alimento a "
                + "on ar.id_alimento = a.id_alimento "
                + "inner join tiporefeicao tr "
                + "on r.id_tipo_refeicao = tr.id_tipo_refeicao "
                + "inner join cardapio c "
                + "on r.id_cardapio = c.id_cardapio "
                + "where c.id_cardapio= ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCardapio);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Refeicao refeicao = new Refeicao();
                refeicao.setDiaRefeicao(rs.getString("dia_refeicao"));
                refeicao.setHoraRefeicao(rs.getString("hora_refeicao"));

                TipoRefeicao tipoRefeicao = new TipoRefeicao();
                tipoRefeicao.setTipoRefeicao(rs.getString("tipo_refeicao"));
                refeicao.setTipoRefeicao(tipoRefeicao);

                Alimento alimento = new Alimento();
                alimento.setNomeAlimento(rs.getString("nome_alimento"));

                Cardapio cardapio = new Cardapio();
                cardapio.setIdCardapio(rs.getInt("id_cardapio"));
                refeicao.setCardapio(cardapio);
                AlimentoRefeicao alimentoRefeicao = new AlimentoRefeicao();
                alimentoRefeicao.setQuantidadeAlimentoRefeicao(rs.getDouble("quantidade_alimento_refeicao"));
                alimentoRefeicao.setTipoMedidaAlimentoRefeicao(rs.getString("tipo_medida_alimento_refeicao"));
                alimentoRefeicao.setAlimento(alimento);
                alimentoRefeicao.setRefeicao(refeicao);

                resultado.add(alimentoRefeicao);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar RefeicaoDAOImpl " + ex.getMessage());
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
//
//    @Override
//    public void excluir(int idObject) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Object carregar(int idObject) {
//        PreparedStatement stmt = null;
//        Refeicao refeicao = null;
//        ResultSet rs = null;
//        String sql = "select*from refeicao where id_refeicao=?;";
//        try {
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, idObject);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                refeicao = new Refeicao();
//                refeicao.setDiaRefeicao(rs.getString("dia_refeicao"));
//                refeicao.setIdRefeicao(rs.getInt("id_refeicao"));
//                refeicao.setSincronizaRefeicao(rs.getInt("sincroniza_refeicao"));
//                refeicao.setStatusRefeicao(rs.getString("status_refeicao"));
//
//                Cardapio cardapio = new Cardapio();
//                cardapio.setIdCardapio(rs.getInt("id_cardapio"));
//                refeicao.setCardapio(cardapio);
//
//                TipoRefeicao tiporefeicao = new TipoRefeicao();
//                tiporefeicao.setIdTipoRefeicao(rs.getInt("id_tipo_refeicao"));
//                refeicao.setTipoRefeicao(tiporefeicao);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao carregar RefeicaoDAOImpl" + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, stmt, rs);
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão" + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//        return refeicao;
//    }
//
//    @Override
//    public Boolean alterar(Object object) {
//        Refeicao refeicao = (Refeicao) object;
//        PreparedStatement stmt = null;
//        String sql = "update refeicao set dia_refeicao = ?, status_refeicao = ?, sincroniza_refeicao = ?, id_tipo_refeicao = ? , id_cardapio = ? where id_refeicao = ? ;";
//        try {
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, refeicao.getDiaRefeicao());
//            stmt.setString(2, refeicao.getStatusRefeicao());
//            stmt.setInt(3, refeicao.getSincronizaRefeicao());
//            stmt.setInt(4, refeicao.getTipoRefeicao().getIdTipoRefeicao());
//            stmt.setInt(5, refeicao.getCardapio().getIdCardapio());
//            stmt.setInt(6, refeicao.getIdRefeicao());
//            stmt.executeUpdate();
//
//            return true;
//        } catch (SQLException ex) {
//            System.out.println("Erro ao alterar RefeicaoDAOImpl() " + ex.getMessage());
//            ex.printStackTrace();
//
//            return false;
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, stmt);
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão " + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public Boolean inativar(Object object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//            System.out.println("Erro na RefeicaoDAOImpl ao cadastrar Refeicao  " + ex.getMessage());
//            ex.printStackTrace();
//
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, stmt);
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão" + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//        return idRefeicao;
//    }
//    @Override
//    public List<Object> listar() {
//        List<Object> resultado = new ArrayList<>();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        String sql = "select r.*, c.nome_cardapio, tr.tipo_refeicao from refeicao r\n"
//                + "inner join cardapio c on c.id_cardapio= r.id_cardapio\n"
//                + "inner join tiporefeicao tr on tr.id_tipo_refeicao= r.id_tipo_refeicao";
//        try {
//            stmt = conn.prepareStatement(sql);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Refeicao refeicao = new Refeicao();
//                refeicao.setIdRefeicao(rs.getInt("id_refeicao"));
//                refeicao.setDiaRefeicao(rs.getString("dia_refeicao"));
//                refeicao.setSincronizaRefeicao(rs.getInt("sincroniza_refeicao"));
//                refeicao.setStatusRefeicao(rs.getString("status_refeicao"));
//
//                Cardapio cardapio = new Cardapio();
//                cardapio.setNomeCardapio(rs.getString("nome_cardapio"));
//                refeicao.setCardapio(cardapio);
//
//                TipoRefeicao tiporefeicao = new TipoRefeicao();
//                tiporefeicao.setTipoRefeicao(rs.getString("tipo_refeicao"));
//                refeicao.setTipoRefeicao(tiporefeicao);
//                resultado.add(refeicao);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao listar RefeicaoDAOImpl " + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            try {
//
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão" + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//        return resultado;
//    }
//
//    @Override
//    public void excluir(int idObject) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Object carregar(int idObject) {
//        PreparedStatement stmt = null;
//        Refeicao refeicao = null;
//        ResultSet rs = null;
//        String sql = "select*from refeicao where id_refeicao=?;";
//        try {
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, idObject);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                refeicao = new Refeicao();
//                refeicao.setDiaRefeicao(rs.getString("dia_refeicao"));
//                refeicao.setIdRefeicao(rs.getInt("id_refeicao"));
//                refeicao.setSincronizaRefeicao(rs.getInt("sincroniza_refeicao"));
//                refeicao.setStatusRefeicao(rs.getString("status_refeicao"));
//
//                Cardapio cardapio = new Cardapio();
//                cardapio.setIdCardapio(rs.getInt("id_cardapio"));
//                refeicao.setCardapio(cardapio);
//
//                TipoRefeicao tiporefeicao = new TipoRefeicao();
//                tiporefeicao.setIdTipoRefeicao(rs.getInt("id_tipo_refeicao"));
//                refeicao.setTipoRefeicao(tiporefeicao);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Erro ao carregar RefeicaoDAOImpl" + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, stmt, rs);
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão" + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//        return refeicao;
//    }
//
//    @Override
//    public Boolean alterar(Object object) {
//        Refeicao refeicao = (Refeicao) object;
//        PreparedStatement stmt = null;
//        String sql = "update refeicao set dia_refeicao = ?, status_refeicao = ?, sincroniza_refeicao = ?, id_tipo_refeicao = ? , id_cardapio = ? where id_refeicao = ? ;";
//        try {
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, refeicao.getDiaRefeicao());
//            stmt.setString(2, refeicao.getStatusRefeicao());
//            stmt.setInt(3, refeicao.getSincronizaRefeicao());
//            stmt.setInt(4, refeicao.getTipoRefeicao().getIdTipoRefeicao());
//            stmt.setInt(5, refeicao.getCardapio().getIdCardapio());
//            stmt.setInt(6, refeicao.getIdRefeicao());
//            stmt.executeUpdate();
//
//            return true;
//        } catch (SQLException ex) {
//            System.out.println("Erro ao alterar RefeicaoDAOImpl() " + ex.getMessage());
//            ex.printStackTrace();
//
//            return false;
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(conn, stmt);
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão " + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public Boolean inativar(Object object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Boolean cadastrar(Object object) {
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

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
