/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Avaliacao;
import br.com.projetoestagio.model.Exercicio;
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
public class ExercicioDAOImpl implements GenericDAO {

    private Connection conn;

    public ExercicioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        Exercicio exercicio = (Exercicio) object;
        PreparedStatement stmt = null;
        String sql = "Insert into exercicio (nome_exercicio, tipo_exercicio, frequencia_exercicio, total_horas_exercicio,"
                + " intensidade_exercicio, status_exercicio, sincroniza_exercicio, id_avaliacao)"
                + "values(?, ?, ?, ?, ?, ? , ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exercicio.getNomeExercicio());
            stmt.setString(2, exercicio.getTipoExercicio());
            stmt.setString(3, exercicio.getFrequenciaExercicio());
            stmt.setDouble(4, exercicio.getTotalHorasExercicio());
            stmt.setString(5, exercicio.getIntensidadeExercicio());
            stmt.setString(6, exercicio.getStatusExercicio());
            stmt.setInt(7, exercicio.getSincronizaExercicio());
            stmt.setInt(8, exercicio.getAvaliacao().getIdAvaliacao());
            stmt.execute();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar Exercício  !!!! " + ex.getMessage());
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
    public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select e.*,a.id_avaliacao from exercicio e inner join avaliacao a on e.id_avaliacao = a.id_avaliacao;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                exercicio.setTipoExercicio(rs.getString("tipo_exercicio"));
                exercicio.setFrequenciaExercicio(rs.getString("frequencia_exercicio"));
                exercicio.setTotalHorasExercicio(rs.getDouble("total_horas_exercicio"));
                exercicio.setIntensidadeExercicio(rs.getString("intensidade_exercicio"));
                exercicio.setStatusExercicio(rs.getString("status_exercicio"));
                exercicio.setSincronizaExercicio(rs.getInt("sincroniza_exercicio"));

                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));

                exercicio.setAvaliacao(avaliacao);

                resultado.add(exercicio);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Exercicio " + ex.getMessage());
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
    public Boolean inativar(Object object) {

        Exercicio exercicio = (Exercicio) object;
        PreparedStatement stmt = null;
        String sql = "update exercicio set status_exercicio = ? where id_exercicio = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exercicio.getStatusExercicio());
            stmt.setInt(2, exercicio.getIdExercicio());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Exercicio! Erro: " + ex.getMessage());
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
        Exercicio exercicio = null;
        String sql = "select e.* from exercicio e where e.id_exercicio=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                exercicio = new Exercicio();

                exercicio.setIdExercicio(rs.getInt("id_exercicio"));
                exercicio.setNomeExercicio(rs.getString("nome_exercicio"));
                exercicio.setTipoExercicio(rs.getString("tipo_exercicio"));
                exercicio.setFrequenciaExercicio(rs.getString("frequencia_exercicio"));
                exercicio.setTotalHorasExercicio(rs.getDouble("total_horas_exercicio"));
                exercicio.setIntensidadeExercicio(rs.getString("intensidade_exercicio"));
                exercicio.setStatusExercicio(rs.getString("status_exercicio"));
                exercicio.setSincronizaExercicio(rs.getInt("sincroniza_exercicio"));

                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));

            }

        } catch (Exception ex) {
            System.out.println("Erro ao carregar Exercicio " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return exercicio;

    }

    @Override
    public Boolean alterar(Object object) {

        Exercicio exercicio = (Exercicio) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE exercicio SET nome_exercicio = ?, tipo_exercicio = ?, frequencia_exercicio = ?, "
                + "total_horas_exercicio = ?, intensidade_exercicio = ?, status_exercicio = ?, sincroniza_exercicio = ?, id_avaliacao = ? WHERE id_exercicio = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exercicio.getNomeExercicio());
            stmt.setString(2, exercicio.getTipoExercicio());
            stmt.setString(3, exercicio.getFrequenciaExercicio());
            stmt.setDouble(4, exercicio.getTotalHorasExercicio());
            stmt.setString(5, exercicio.getIntensidadeExercicio());
            stmt.setString(6, exercicio.getStatusExercicio());
            stmt.setInt(7, exercicio.getSincronizaExercicio());
            stmt.setInt(8, exercicio.getAvaliacao().getIdAvaliacao());
            stmt.setInt(9, exercicio.getIdExercicio());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problmas ao alterar Exercício! Erro: " + ex.getMessage());
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
