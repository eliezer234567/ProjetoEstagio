/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Consulta;
import br.com.projetoestagio.model.Nutricionista;
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
 * @author Eliezer.L
 */
public class ConsultaDAOImpl implements GenericDAO {

    private Connection conn;

    public ConsultaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Consulta consulta = (Consulta) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO consulta(id_paciente, id_nutricionista, data_consulta,hora_consulta, conduta_nutricional_consulta, observacao_consulta, status_consulta) "
                + "VALUES (?,?,?,?,?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, consulta.getPaciente().getIdPaciente());
            stmt.setInt(2, consulta.getNutricionista().getIdNutricionista());
            stmt.setDate(3, new java.sql.Date(consulta.getDataConsulta().getTime()));
            stmt.setString(4, consulta.getHoraConsulta());
            stmt.setString(5, consulta.getCondutaNutricionalConsulta());
            stmt.setString(6, consulta.getObsConsulta());
            stmt.setString(7, consulta.getStatusConsulta());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Consulta! Erro: " + ex.getMessage());
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();
        String sql = "select *from consulta where id_nutricionista = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setCondutaNutricionalConsulta(rs.getString("conduta_nutricional_consulta"));
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setObsConsulta(rs.getString("observacao_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));
                resultado.add(consulta);
                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                consulta.setPaciente(paciente);

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Consulta!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

   

    public Boolean alterarStatusConsulta(Object object) {
        Consulta consulta = (Consulta) object;
        PreparedStatement stmt = null;
        String sql = "update consulta set status_consulta = ? where id_consulta = ?;"; 
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, consulta.getStatusConsulta());
            stmt.setInt(2, consulta.getIdConsulta());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar status da Consulta! Erro: " + ex.getMessage());
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
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean inativar(Object object) {
        Consulta consulta = (Consulta) object;
        PreparedStatement stmt = null;
        String sql = "update consulta set status_consulta = ? where id_consulta = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, consulta.getStatusConsulta());
            stmt.setInt(2, consulta.getIdConsulta());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Consulta! Erro: " + ex.getMessage());
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
        Consulta consulta = null;
        String sql = "select con.*, pa.id_paciente, pa.id_pessoa, p.nome_pessoa,p.id_pessoa from consulta con, paciente pa, pessoa p  where con.id_paciente = pa.id_paciente and p.id_pessoa = pa.id_pessoa and pa.id_pessoa = ?;";
        try {
            

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setCondutaNutricionalConsulta(rs.getString("conduta_nutricional_consulta"));
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setObsConsulta(rs.getString("obs_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));

                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                consulta.setPaciente(paciente);
                Nutricionista nutricionista = new Nutricionista();
                nutricionista.setNomePessoa(rs.getString("nome_pessoa"));
                nutricionista.setIdNutricionista(rs.getInt("id_nutricionista"));
                consulta.setNutricionista(nutricionista);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Consulta!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return consulta;
    }

    @Override
    public Boolean alterar(Object object) {
        Consulta consulta = (Consulta) object;
        PreparedStatement stmt = null;
        String sql = "update consulta set data_consulta = ?, hora_consulta = ?, conduta_nutricional_consulta = ?, observacao_consulta = ?, status_consulta = ? where id_consulta = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(consulta.getDataConsulta().getTime()));
            stmt.setString(2, consulta.getHoraConsulta());
            stmt.setString(3, consulta.getCondutaNutricionalConsulta());
            stmt.setString(4, consulta.getObsConsulta());
            stmt.setString(5, consulta.getStatusConsulta());
            stmt.setInt(6, consulta.getIdConsulta());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Consulta!Erro:" + ex.getMessage());
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
//inicio do listar consultas do nutricionista
    public Object listarConsultasIndividuais(int idObject) {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.nome_pessoa,p.id_pessoa,c.data_consulta, c.hora_consulta,c.id_consulta,c.status_consulta from consulta c "
                + "inner join paciente pa "
                + "on c.id_paciente = pa.id_paciente "
                + "inner join pessoa p "
                + "on pa.id_pessoa = p.id_pessoa "
                + "inner join nutricionista nu "
                + "on c.id_nutricionista = nu.id_nutricionista "
                + "where nu.id_pessoa = ? AND status_consulta = 'Agendada' order by nome_pessoa ;";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));
                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                consulta.setPaciente(paciente);
                
                resultado.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Consulta!Erro:" + ex.getMessage());
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
    //fim do listar consultas do nutricionista
    
    // *******Inicio do listar consultas do paciente**************
    public Object listarConsultasIndividuaisPaciente(int idObject) {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.nome_pessoa,p.id_pessoa,c.data_consulta, c.hora_consulta,c.id_consulta,c.status_consulta from consulta c "
                + "inner join nutricionista nu "
                + "on c.id_nutricionista = nu.id_nutricionista "
                + "inner join pessoa p "
                + "on nu.id_pessoa = p.id_pessoa "
                + "inner join paciente pa "
                + "on c.id_paciente = pa.id_paciente "
                + "where pa.id_pessoa = ? AND status_consulta = 'Agendada' order by nome_pessoa ;";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));
                Nutricionista nutricionista = new Nutricionista();
                nutricionista.setNomePessoa(rs.getString("nome_pessoa"));
                nutricionista.setIdPessoa(rs.getInt("id_pessoa"));
                consulta.setNutricionista(nutricionista);
                
                resultado.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Consulta Do Paciente!Erro:" + ex.getMessage());
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
    
    //inativar consultas quando inativa o paciente
    public Boolean inativarConsulta(Object object) {
        Consulta consulta = (Consulta) object;
        PreparedStatement stmt = null;
        String sql = "update consulta set status_consulta = ? where id_paciente = (select pa.id_paciente from paciente pa, pessoa p "
                + "where p.id_pessoa = pa.id_pessoa and p.id_pessoa = ?);";                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, consulta.getStatusConsulta());
            stmt.setInt(2, consulta.getPaciente().getIdPessoa());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar status da consulta! Erro: " + ex.getMessage());
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
    
    //carregar hora e data da consulta
    public Object carregarDataHoraConsulta(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Consulta consulta = null;
        String sql = "select con.*, p.nome_pessoa,p.telefone_pessoa,p.id_pessoa from consulta con, paciente pa, pessoa p  where con.id_paciente = pa.id_paciente and p.id_pessoa = pa.id_pessoa and con.id_consulta = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setCondutaNutricionalConsulta(rs.getString("conduta_nutricional_consulta"));
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setObsConsulta(rs.getString("observacao_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));
                

                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setTelefonePessoa(rs.getString("telefone_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                consulta.setPaciente(paciente);
                Nutricionista nutricionista = new Nutricionista();
                nutricionista.setNomePessoa(rs.getString("nome_pessoa"));
                nutricionista.setIdNutricionista(rs.getInt("id_nutricionista"));
                consulta.setNutricionista(nutricionista);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Consulta!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return consulta;
    }
    //lista de consultas que ja estão realizadas
    public Object listarConsultasIndividuaisRealizadas(int idObject) {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.nome_pessoa,p.id_pessoa,c.data_consulta, c.hora_consulta,c.id_consulta,c.status_consulta from consulta c "
                + "inner join paciente pa "
                + "on c.id_paciente = pa.id_paciente "
                + "inner join pessoa p "
                + "on pa.id_pessoa = p.id_pessoa "
                + "inner join nutricionista nu "
                + "on c.id_nutricionista = nu.id_nutricionista "
                + "where nu.id_pessoa = ? AND status_consulta = 'Realizada' order by nome_pessoa ;";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setDataConsulta(rs.getDate("data_consulta"));
                consulta.setHoraConsulta(rs.getString("hora_consulta"));
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setStatusConsulta(rs.getString("status_consulta"));
                Paciente paciente = new Paciente();
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                consulta.setPaciente(paciente);
                
                resultado.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Consulta!Erro:" + ex.getMessage());
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
    

}
