/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.EvolucaoPaciente;
import br.com.projetoestagio.model.Paciente;
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
public class EvolucaoPacienteDAOImpl implements GenericDAO {

    private Connection conn;

    public EvolucaoPacienteDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {

        EvolucaoPaciente evolucaoPaciente = (EvolucaoPaciente) object;
        PreparedStatement stmt = null;
        String sql = "Insert into evolucaopaciente (peso_evolucao_paciente, altura_evolucao_paciente, "
                + "circun_punho_evolucao_paciente, circun_cintura_evolucao_paciente, circun_quadril_evolucao_paciente, dobras_cutaneas_evolucao_paciente, id_consulta "
                + ") values (?, ?, ?, ?, ?, ?, ? );";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, evolucaoPaciente.getPesoEvolucaoPaciente());
            stmt.setDouble(2, evolucaoPaciente.getAlturaEvolucaoPaciente());
            stmt.setDouble(3, evolucaoPaciente.getCircunPunhoEvolucaoPaciente());
            stmt.setDouble(4, evolucaoPaciente.getCircunCinturaEvolucaoPaciente());
            stmt.setDouble(5, evolucaoPaciente.getCircunQuadrilEvolucaoPaciente());
            stmt.setDouble(6, evolucaoPaciente.getDobrasCutaneasEvolucaoPaciente());
            stmt.setInt(7, evolucaoPaciente.getConsulta().getIdConsulta());
            stmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar Evolução do Paciente" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao finalizar conexão " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select*from evolucaopaciente;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EvolucaoPaciente evolucaoPaciente = new EvolucaoPaciente();
                evolucaoPaciente.setIdEvolucaoPaciente(rs.getInt("id_evolucao_paciente"));
                evolucaoPaciente.setPesoEvolucaoPaciente(rs.getDouble("peso_evolucao_paciente"));
                evolucaoPaciente.setAlturaEvolucaoPaciente(rs.getDouble("altura_evolucao_paciente"));
                evolucaoPaciente.setCircunCinturaEvolucaoPaciente(rs.getDouble("circun_cintura_evolucao_paciente"));
                evolucaoPaciente.setCircunPunhoEvolucaoPaciente(rs.getDouble("circun_punho_evolucao_paciente"));
                evolucaoPaciente.setCircunQuadrilEvolucaoPaciente(rs.getDouble("circun_quadril_evolucao_paciente"));
                evolucaoPaciente.setDobrasCutaneasEvolucaoPaciente(rs.getDouble("dobras_cutaneas_evolucao_paciente"));

                resultado.add(evolucaoPaciente);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Evolução do Paciente" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    public List<Object> listarPorPaciente(Integer idPessoaPaciente) {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.data_consulta, ep.id_evolucao_paciente, ep.peso_evolucao_paciente, ep.altura_evolucao_paciente, ep.circun_punho_evolucao_paciente, "
                + "ep.circun_cintura_evolucao_paciente, ep.circun_quadril_evolucao_paciente, "
                + "ep.dobras_cutaneas_evolucao_paciente from evolucaopaciente ep "
                + "inner join consulta c "
                + "on c.id_consulta = ep.id_consulta "
                + "inner join paciente pa "
                + "on pa.id_paciente = c.id_paciente "
                + "inner join pessoa p "
                + "on p.id_pessoa = pa.id_pessoa "
                + "where p.id_pessoa = ? order by c.data_consulta desc ;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPessoaPaciente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setDataConsulta(rs.getDate("data_consulta"));

                EvolucaoPaciente evolucaoPaciente = new EvolucaoPaciente();
                evolucaoPaciente.setIdEvolucaoPaciente(rs.getInt("id_evolucao_paciente"));
                evolucaoPaciente.setPesoEvolucaoPaciente(rs.getDouble("peso_evolucao_paciente"));
                evolucaoPaciente.setAlturaEvolucaoPaciente(rs.getDouble("altura_evolucao_paciente"));
                evolucaoPaciente.setCircunCinturaEvolucaoPaciente(rs.getDouble("circun_cintura_evolucao_paciente"));
                evolucaoPaciente.setCircunPunhoEvolucaoPaciente(rs.getDouble("circun_punho_evolucao_paciente"));
                evolucaoPaciente.setCircunQuadrilEvolucaoPaciente(rs.getDouble("circun_quadril_evolucao_paciente"));
                evolucaoPaciente.setDobrasCutaneasEvolucaoPaciente(rs.getDouble("dobras_cutaneas_evolucao_paciente"));

                evolucaoPaciente.setConsulta(consulta);
                resultado.add(evolucaoPaciente);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar Evolução do Paciente" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete from evolucaopaciente where id_evolucao_paciente = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problema ao excluir Evolução" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problema ao fechar paramentros de conexão" + ex.getMessage());
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

        EvolucaoPaciente evolucaoPaciente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select*from evolucaopaciente where id_evolucao_paciente=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                evolucaoPaciente = new EvolucaoPaciente();
                evolucaoPaciente.setIdEvolucaoPaciente(rs.getInt("id_evolucao_paciente"));
                evolucaoPaciente.setPesoEvolucaoPaciente(rs.getDouble("peso_evolucao_paciente"));
                evolucaoPaciente.setAlturaEvolucaoPaciente(rs.getDouble("altura_evolucao_paciente"));
                evolucaoPaciente.setCircunCinturaEvolucaoPaciente(rs.getDouble("circun_cintura_evolucao_paciente"));
                evolucaoPaciente.setCircunPunhoEvolucaoPaciente(rs.getDouble("circun_punho_evolucao_paciente"));
                evolucaoPaciente.setCircunQuadrilEvolucaoPaciente(rs.getDouble("circun_quadril_evolucao_paciente"));
                evolucaoPaciente.setDobrasCutaneasEvolucaoPaciente(rs.getDouble("dobras_cutaneas_evolucao_paciente"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar Evolucao do Paciente" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
            return evolucaoPaciente;
        }
    }
    // usado para carregar a barra de evolucao na index do paciente
    public Object carregarDadosEvolucao(int idObject) {

        EvolucaoPaciente evolucaoPaciente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select ev.peso_evolucao_paciente, con.id_paciente from evolucaopaciente ev, consulta con where ev.id_consulta = con.id_consulta and con.id_paciente = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                evolucaoPaciente = new EvolucaoPaciente();
                evolucaoPaciente.setPesoEvolucaoPaciente(rs.getDouble("peso_evolucao_paciente"));
                
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                evolucaoPaciente.setConsulta(consulta);
                
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                consulta.setPaciente(paciente);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao carregar Evolucao do Paciente" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
            return evolucaoPaciente;
        }
    }

    @Override
    public Boolean alterar(Object object) {

        EvolucaoPaciente evolucaoPaciente = (EvolucaoPaciente) object;
        PreparedStatement stmt = null;
        String sql = "update evolucaopaciente set peso_evolucao_paciente=?, "
                + "altura_evolucao_paciente=?, circun_punho_evolucao_paciente=?, "
                + "circun_cintura_evolucao_paciente=?, circun_quadril_evolucao_paciente=?, "
                + "dobras_cutaneas_evolucao_paciente=? where id_evolucao_paciente=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, evolucaoPaciente.getPesoEvolucaoPaciente());
            stmt.setDouble(2, evolucaoPaciente.getAlturaEvolucaoPaciente());
            stmt.setDouble(3, evolucaoPaciente.getCircunPunhoEvolucaoPaciente());
            stmt.setDouble(4, evolucaoPaciente.getCircunCinturaEvolucaoPaciente());
            stmt.setDouble(5, evolucaoPaciente.getCircunQuadrilEvolucaoPaciente());
            stmt.setDouble(6, evolucaoPaciente.getDobrasCutaneasEvolucaoPaciente());
            stmt.setInt(7, evolucaoPaciente.getIdEvolucaoPaciente());
            stmt.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao alterar Evolução do Paciente" + ex.getMessage());
            ex.printStackTrace();

            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }
}
