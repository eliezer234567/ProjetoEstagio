/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Avaliacao;
import br.com.projetoestagio.model.Consulta;
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
 * @author Grazy
 */
public class AvaliacaoDAOImpl implements GenericDAO{
    
    private Connection conn;

    public AvaliacaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        }
    
    public Integer cadastrar(Avaliacao avaliacao) {
        Integer id = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        String sql = "INSERT INTO avaliacao(data_avaliacao, meta_avaliacao, observacao_importante_avaliacao, peso_desejavel_avaliacao,"
                + "objetivo_avaliacao, colesterol, triglicerideos, diabetes, acompan_avaliacao, conduta_adotada_avaliacao,"
                + "qtd_agua_avaliacao, fumaavaliacao, func_intestino_avaliacao, urina_avaliacao, local_alim_avaliacao,"
                + "pratica_exercicio_avaliacao, id_consulta, id_frequencia_alimentar)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning id_avaliacao;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(avaliacao.getDataAvaliacao().getTime()));
            stmt.setInt(2, avaliacao.getMetaAvaliacao());
            stmt.setString(3, avaliacao.getObservaoImportanteAvaliacao());
            stmt.setDouble(4, avaliacao.getPesoDesejavelAvaliacao());
            stmt.setString(5, avaliacao.getObjetivoAvaliacao());
            stmt.setInt(6, avaliacao.getColesterol());
            stmt.setInt(7, avaliacao.getTrigliceridios());
            stmt.setInt(8, avaliacao.getDiabetes());
            stmt.setBoolean(9, avaliacao.getAcompanAvaliacao());
            stmt.setString(10, avaliacao.getCondutaAdotadaAvaliacao());
            stmt.setDouble(11, avaliacao.getQtdAguaAvaliacao());
            stmt.setBoolean(12, avaliacao.getFumaAvaliacao());
            stmt.setString(13, avaliacao.getFuncIntestinoAvaliacao());
            stmt.setString(14, avaliacao.getUrinaAvaliacao());
            stmt.setString(15, avaliacao.getLocalAlimAvaliacao());
            stmt.setBoolean(16, avaliacao.getPraticaExercicioAvaliacao());
            stmt.setInt(17, avaliacao.getConsulta().getIdConsulta());
            stmt.setInt(18, avaliacao.getFrequenciaAlimentar().getIdFrequenciaAlimentar());
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_avaliacao");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Avaliacao! Erro: " + ex.getMessage());
            ex.printStackTrace();
            id = 0;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return id;
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select pes.nome_pessoa,pes.id_pessoa,con.id_consulta,pac.id_paciente,ava.* from consulta con, paciente pac, pessoa pes, avaliacao ava\n" +
                "where pes.id_pessoa = pac.id_pessoa and pac.id_paciente = con.id_paciente and con.id_consulta = ava.id_consulta order by ava.id_avaliacao";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                Consulta consulta = new Consulta();
                Paciente paciente = new Paciente();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                consulta.setPaciente(paciente);
                avaliacao.setConsulta(consulta);
                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
                avaliacao.setDataAvaliacao(rs.getDate("data_avaliacao"));
                avaliacao.setMetaAvaliacao(rs.getInt("meta_avaliacao"));
                avaliacao.setPesoDesejavelAvaliacao(rs.getDouble("peso_desejavel_avaliacao"));
                avaliacao.setColesterol(rs.getInt("colesterol"));
                avaliacao.setTrigliceridios(rs.getInt("triglicerideos"));
                avaliacao.setDiabetes(rs.getInt("diabetes"));
                avaliacao.setFumaAvaliacao(rs.getBoolean("fumaavaliacao"));
                avaliacao.setObjetivoAvaliacao(rs.getString("objetivo_avaliacao"));
                avaliacao.setAcompanAvaliacao(rs.getBoolean("acompan_avaliacao"));
                avaliacao.setCondutaAdotadaAvaliacao(rs.getString("conduta_adotada_avaliacao"));
                avaliacao.setQtdAguaAvaliacao(rs.getDouble("qtd_agua_avaliacao"));
                avaliacao.setFuncIntestinoAvaliacao(rs.getString("func_intestino_avaliacao"));
                avaliacao.setUrinaAvaliacao(rs.getString("urina_avaliacao"));
                avaliacao.setLocalAlimAvaliacao(rs.getString("local_alim_avaliacao"));
                avaliacao.setPraticaExercicioAvaliacao(rs.getBoolean("pratica_exercicio_avaliacao"));
                avaliacao.setObservaoImportanteAvaliacao(rs.getString("observacao_importante_avaliacao"));
                avaliacao.setStatusAvaliacao(rs.getString("status_avaliacao"));
                
                resultado.add(avaliacao);
            }
        } catch (SQLException ex) {
            System.out.println("Erro DAOImpl listar " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão do listar" + ex.getMessage());
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
        
        Avaliacao avaliacao = (Avaliacao) object;
        PreparedStatement stmt = null;
        String sql = "update avaliacao set status_avaliacao=? where id_avaliacao=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, avaliacao.getStatusAvaliacao());
            stmt.setInt(2, avaliacao.getIdAvaliacao());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao inativar Avaliacao! Erro: " + ex.getMessage());
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
        Avaliacao avaliacao = new Avaliacao();
        Consulta consulta = new Consulta();
        Paciente paciente = new Paciente();
        String sql = "select pes.nome_pessoa,pes.id_pessoa,con.id_consulta,pac.id_paciente,ava.* from consulta con, paciente pac, pessoa pes, avaliacao ava\n" +
                "where pes.id_pessoa = pac.id_pessoa and pac.id_paciente = con.id_paciente and con.id_consulta = ava.id_consulta and ava.id_avaliacao = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {                
                paciente.setNomePessoa(rs.getString("nome_pessoa"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setIdPessoa(rs.getInt("id_pessoa"));
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setPaciente(paciente);
                avaliacao.setConsulta(consulta);
                avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
                avaliacao.setDataAvaliacao(rs.getDate("data_avaliacao"));
                avaliacao.setMetaAvaliacao(rs.getInt("meta_avaliacao"));
                avaliacao.setPesoDesejavelAvaliacao(rs.getDouble("peso_desejavel_avaliacao"));
                avaliacao.setColesterol(rs.getInt("colesterol"));
                avaliacao.setTrigliceridios(rs.getInt("triglicerideos"));
                avaliacao.setDiabetes(rs.getInt("diabetes"));
                avaliacao.setFumaAvaliacao(rs.getBoolean("fumaavaliacao"));
                avaliacao.setObjetivoAvaliacao(rs.getString("objetivo_avaliacao"));
                avaliacao.setAcompanAvaliacao(rs.getBoolean("acompan_avaliacao"));
                avaliacao.setCondutaAdotadaAvaliacao(rs.getString("conduta_adotada_avaliacao"));
                avaliacao.setQtdAguaAvaliacao(rs.getDouble("qtd_agua_avaliacao"));
                avaliacao.setFuncIntestinoAvaliacao(rs.getString("func_intestino_avaliacao"));
                avaliacao.setUrinaAvaliacao(rs.getString("urina_avaliacao"));
                avaliacao.setLocalAlimAvaliacao(rs.getString("local_alim_avaliacao"));
                avaliacao.setPraticaExercicioAvaliacao(rs.getBoolean("pratica_exercicio_avaliacao"));
                avaliacao.setObservaoImportanteAvaliacao(rs.getString("observacao_importante_avaliacao"));

            }

        } catch (Exception ex) {
            System.out.println("Erro ao carregar AvaliacaoDAOImpl " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return avaliacao;
    }

    @Override
    public Boolean alterar(Object object) {
        Avaliacao avaliacao = (Avaliacao) object;
        PreparedStatement stmt = null;
        String sql = "update avaliacao set data_avaliacao=?, meta_avaliacao=?, "
                + "observacao_importante_avaliacao=?, peso_desejavel_avaliacao=?,"
                + "objetivo_avaliacao=?, colesterol=?, triglicerideos=?, diabetes=?,"
                + " acompan_avaliacao=?, conduta_adotada_avaliacao=?,"
                + "qtd_agua_avaliacao=?, fumaavaliacao=?, func_intestino_avaliacao=?,"
                + " urina_avaliacao=?, local_alim_avaliacao=?,"
                + "pratica_exercicio_avaliacao=? where id_avaliacao=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(avaliacao.getDataAvaliacao().getTime()));
            stmt.setInt(2, avaliacao.getMetaAvaliacao());
            stmt.setString(3, avaliacao.getObservaoImportanteAvaliacao());
            stmt.setDouble(4, avaliacao.getPesoDesejavelAvaliacao());
            stmt.setString(5, avaliacao.getObjetivoAvaliacao());
            stmt.setInt(6, avaliacao.getColesterol());
            stmt.setInt(7, avaliacao.getTrigliceridios());
            stmt.setInt(8, avaliacao.getDiabetes());
            stmt.setBoolean(9, avaliacao.getAcompanAvaliacao());
            stmt.setString(10, avaliacao.getCondutaAdotadaAvaliacao());
            stmt.setDouble(11, avaliacao.getQtdAguaAvaliacao());
            stmt.setBoolean(12, avaliacao.getFumaAvaliacao());
            stmt.setString(13, avaliacao.getFuncIntestinoAvaliacao());
            stmt.setString(14, avaliacao.getUrinaAvaliacao());
            stmt.setString(15, avaliacao.getLocalAlimAvaliacao());
            stmt.setBoolean(16, avaliacao.getPraticaExercicioAvaliacao());
            stmt.setInt(17, avaliacao.getIdAvaliacao());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar Avaliacao! Erro: " + ex.getMessage());
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
