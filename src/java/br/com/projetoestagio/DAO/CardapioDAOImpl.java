/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Cardapio;
import br.com.projetoestagio.model.Paciente;
import br.com.projetoestagio.model.Pessoa;
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
public class CardapioDAOImpl implements GenericDAO {

    private Connection conn;

    public CardapioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Cardapio cardapio) {

        Integer idCardapio = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Insert into cardapio (tipo_cardapio, nome_cardapio, data_inicio_cardapio, data_final_cardapio,intervalo_cardapio, "
                + " observacao_cardapio, status_cardapio, id_paciente) "
                + "values(?, ?, ?, ?, ?, ?, ? , ?) returning id_cardapio";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cardapio.getTipoCardapio());
            stmt.setString(2, cardapio.getNomeCardapio());
            stmt.setDate(3, new java.sql.Date(cardapio.getDataInicioCardapio().getTime()));
            stmt.setDate(4, new java.sql.Date(cardapio.getDataFinalCardapio().getTime()));
            stmt.setString(5, cardapio.getIntervaloCardapio());
            stmt.setString(6, cardapio.getObservacaoCardapio());
            stmt.setString(7, cardapio.getStatusCardapio());
            stmt.setInt(8, cardapio.getPaciente().getIdPaciente());
            rs = stmt.executeQuery();
            if (rs.next()) {
                idCardapio = rs.getInt("id_cardapio");
            }

        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar Cardápio  !!!! " + ex.getMessage());
            ex.printStackTrace();
            idCardapio = -1;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return idCardapio;
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.*,pe.nome_pessoa from cardapio c inner join paciente pa \n"
                + "on c.id_paciente = pa.id_paciente\n"
                + "inner join pessoa pe\n"
                + "on pa.id_pessoa=pe.id_pessoa;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cardapio cardapio = new Cardapio();
                cardapio.setIdCardapio(rs.getInt("id_cardapio"));
                cardapio.setTipoCardapio(rs.getString("tipo_cardapio"));
                cardapio.setNomeCardapio(rs.getString("nome_cardapio"));
                cardapio.setDataInicioCardapio(rs.getDate("data_inicio_cardapio"));
                cardapio.setDataFinalCardapio(rs.getDate("data_final_cardapio"));
                cardapio.setObservacaoCardapio(rs.getString("observacao_cardapio"));
                cardapio.setStatusCardapio(rs.getString("status_cardapio"));

                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));

                cardapio.setPaciente(paciente);

                resultado.add(cardapio);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar o CardapioDAOImpl " + ex.getMessage());
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

    public List<Cardapio> listarCardapioPorPaciente(Integer idPessoa) {
        List<Cardapio> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.*, p.nome_pessoa, pa.id_paciente from cardapio c "
                + "inner join paciente pa "
                + "on pa.id_paciente = c.id_paciente "
                + "inner join pessoa p "
                + "on  p.id_pessoa = pa.id_pessoa "
                + "where p.id_pessoa = ? order by c.data_final_cardapio desc ;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cardapio cardapio = new Cardapio();

                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));

                cardapio.setIdCardapio(rs.getInt("id_cardapio"));
                cardapio.setTipoCardapio(rs.getString("tipo_cardapio"));
                cardapio.setNomeCardapio(rs.getString("nome_cardapio"));
                cardapio.setDataInicioCardapio(rs.getDate("data_inicio_cardapio"));
                cardapio.setDataFinalCardapio(rs.getDate("data_final_cardapio"));
                cardapio.setObservacaoCardapio(rs.getString("observacao_cardapio"));
                
                

                cardapio.setPaciente(paciente);

                resultado.add(cardapio);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar o CardapioDAOImpl " + ex.getMessage());
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

    public List<Cardapio> listarAtual(Integer idCardapio) {
        List<Cardapio> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select p.nome_pessoa, c.tipo_cardapio, c.nome_cardapio, c.data_inicio_cardapio, c.data_final_cardapio,"
                + "c.observacao_cardapio from cardapio c inner join paciente pa "
                + "on pa.id_paciente = c.id_paciente inner join pessoa p "
                + "on p.id_pessoa = pa.id_pessoa where id_cardapio = ? ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCardapio);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cardapio cardapio = new Cardapio();

                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));

                cardapio.setTipoCardapio(rs.getString("tipo_cardapio"));
                cardapio.setNomeCardapio(rs.getString("nome_cardapio"));
                cardapio.setDataInicioCardapio(rs.getDate("data_inicio_cardapio"));
                cardapio.setDataFinalCardapio(rs.getDate("data_final_cardapio"));
                cardapio.setObservacaoCardapio(rs.getString("observacao_cardapio"));

                cardapio.setPaciente(paciente);

                resultado.add(cardapio);

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar o CardapioDAOImpl " + ex.getMessage());
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
        Cardapio cardapio = null;
        String sql = "select c.* from cardapio c where c.id_cardapio=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cardapio = new Cardapio();
                cardapio.setIdCardapio(rs.getInt("id_cardapio"));
                cardapio.setTipoCardapio(rs.getString("tipo_cardapio"));
                cardapio.setNomeCardapio(rs.getString("nome_cardapio"));
                cardapio.setDataInicioCardapio(rs.getDate("data_inicio_cardapio"));
                cardapio.setDataFinalCardapio(rs.getDate("data_final_cardapio"));
                cardapio.setObservacaoCardapio(rs.getString("observacao_cardapio"));
                cardapio.setStatusCardapio(rs.getString("status_cardapio"));

                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                cardapio.setPaciente(paciente);

            }

        } catch (Exception ex) {
            System.out.println("Erro ao carregar CardapioDAOImpl " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return cardapio;
    }

    @Override
    public Boolean alterar(Object object) {
        Cardapio cardapio = (Cardapio) object;
        PreparedStatement stmt = null;
        String sql = "update cardapio set tipo_cardapio=?, nome_cardapio=?, data_inicio_cardapio=?,"
                + " data_final_cardapio=?, observacao_cardapio=?, status_cardapio=?, "
                + " id_paciente=? where id_cardapio= ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cardapio.getTipoCardapio());
            stmt.setString(2, cardapio.getNomeCardapio());
            stmt.setDate(3, new java.sql.Date(cardapio.getDataInicioCardapio().getTime()));
            stmt.setDate(4, new java.sql.Date(cardapio.getDataFinalCardapio().getTime()));
            stmt.setString(5, cardapio.getObservacaoCardapio());
            stmt.setString(6, cardapio.getStatusCardapio());
            stmt.setInt(7, cardapio.getPaciente().getIdPaciente());
            stmt.setInt(8, cardapio.getIdCardapio());

            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao fechar conexão" + ex.getMessage());
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
    public Boolean inativar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
