/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

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
 * @author usuario
 */
public class PacienteDAOImpl implements GenericDAO {

    private Connection conn;

    public PacienteDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Paciente paciente = (Paciente) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO paciente(data_nascimento_paciente,sexo_paciente,idade_paciente,id_pessoa) "
                + "VALUES (?,?,?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(paciente.getDataNascimentoPaciente().getTime()));
            stmt.setString(2, paciente.getSexoPaciente());
            stmt.setInt(3, paciente.getIdadePaciente());
            try {
                PessoaDAOImpl daoPessoa = new PessoaDAOImpl();
                stmt.setInt(4, daoPessoa.cadastrar(paciente));
            } catch (Exception ex) {
                System.out.println("Problemas ao cadastrar Pessoa! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Paciente! Erro: " + ex.getMessage());
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
        String sql = "select p.*, pa.*from pessoa p, paciente pa where p.id_pessoa = pa.id_pessoa AND status_pessoa = 'A' order by nome_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                paciente.setEmailPessoa(rs.getString("email_pessoa"));
                paciente.setIdadePaciente(rs.getInt("idade_paciente"));
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setSenhaPessoa(rs.getString("senha_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setSexoPaciente(rs.getString("sexo_paciente"));
                paciente.setStatusPessoa(rs.getString("status_pessoa"));
                paciente.setTipoPessoa(rs.getString("tipo_pessoa"));
                paciente.setTelefonePessoa(rs.getString("telefone_pessoa"));
                paciente.setDataNascimentoPaciente(rs.getDate("data_nascimento_paciente"));
                resultado.add(paciente);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Paciente!Erro:" + ex.getMessage());
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
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        String sql = "select p.*,pa.* from pessoa p, paciente pa where p.id_pessoa = pa.id_pessoa and pa.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                paciente.setEmailPessoa(rs.getString("email_pessoa"));
                paciente.setIdadePaciente(rs.getInt("idade_paciente"));
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setSenhaPessoa(rs.getString("senha_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setSexoPaciente(rs.getString("sexo_paciente"));
                paciente.setStatusPessoa(rs.getString("status_pessoa"));
                paciente.setTelefonePessoa(rs.getString("telefone_pessoa"));
                paciente.setDataNascimentoPaciente(rs.getDate("data_nascimento_paciente"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Paciente!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return paciente;
    }
    
    public Object carregarPaciente(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        String sql = "select p.*,pa.* from pessoa p, paciente pa where p.id_pessoa = pa.id_pessoa and pa.id_paciente = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                paciente.setEmailPessoa(rs.getString("email_pessoa"));
                paciente.setIdadePaciente(rs.getInt("idade_paciente"));
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setSenhaPessoa(rs.getString("senha_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setSexoPaciente(rs.getString("sexo_paciente"));
                paciente.setStatusPessoa(rs.getString("status_pessoa"));
                paciente.setTelefonePessoa(rs.getString("telefone_pessoa"));
                paciente.setDataNascimentoPaciente(rs.getDate("data_nascimento_paciente"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Paciente!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return paciente;
    }
    
    public Object carregarDadosPaciente(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        String sql = "select p.*,pa.* from pessoa p, paciente pa where p.id_pessoa = pa.id_pessoa and pa.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                paciente.setEmailPessoa(rs.getString("email_pessoa"));
                paciente.setIdadePaciente(rs.getInt("idade_paciente"));
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setSenhaPessoa(rs.getString("senha_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setSexoPaciente(rs.getString("sexo_paciente"));
                paciente.setStatusPessoa(rs.getString("status_pessoa"));
                paciente.setTelefonePessoa(rs.getString("telefone_pessoa"));
                paciente.setDataNascimentoPaciente(rs.getDate("data_nascimento_paciente"));

            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Paciente!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexao!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Boolean alterar(Object object) {
        Paciente paciente = (Paciente) object;
        PreparedStatement stmt = null;
        String sql = " update paciente set data_nascimento_paciente = ?, sexo_paciente = ?, idade_paciente = ? where id_pessoa=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(paciente.getDataNascimentoPaciente().getTime()));
            stmt.setString(2, paciente.getSexoPaciente());
            stmt.setInt(3, paciente.getIdadePaciente());
            stmt.setInt(4, paciente.getIdPessoa());
            try {
                PessoaDAOImpl dao = new PessoaDAOImpl();
                if (dao.alterar(paciente)) {
                    stmt.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception ex) {
                System.out.println("Problemas ao alterar Pessoa!Erro:" + ex.getMessage());
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Paciente!Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parametros de conexão!Erro:" + ex.getMessage());
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
        Paciente paciente = (Paciente) object;
        PreparedStatement stmt = null;
        String sql = "update pessoa set status_pessoa = ? where id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, paciente.getStatusPessoa());
            stmt.setInt(2, paciente.getIdPessoa());           
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Paciente! Erro: " + ex.getMessage());
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
    //usado na pagina listarpaciente.jsp para listar os pacientes de acordo com o nutricionista
    public Object listarPacienteIndividuais(int idObject) {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select distinct(pe.id_pessoa),pe.*, pa.* from pessoa pe "
                + "inner join paciente pa on pe.id_pessoa= pa.id_pessoa "
                + "left join consulta c on pa.id_paciente = c.id_paciente "
                + "inner join nutricionista nu on c.id_nutricionista = nu.id_nutricionista "
                + "where nu.id_pessoa = ? AND status_pessoa = 'A' order by nome_pessoa;";
                
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                paciente.setEmailPessoa(rs.getString("email_pessoa"));
                paciente.setIdadePaciente(rs.getInt("idade_paciente"));
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setSenhaPessoa(rs.getString("senha_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setSexoPaciente(rs.getString("sexo_paciente"));
                paciente.setStatusPessoa(rs.getString("status_pessoa"));
                paciente.setTipoPessoa(rs.getString("tipo_pessoa"));
                paciente.setTelefonePessoa(rs.getString("telefone_pessoa"));
                paciente.setDataNascimentoPaciente(rs.getDate("data_nascimento_paciente"));
                resultado.add(paciente);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Paciente!Erro:" + ex.getMessage());
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
