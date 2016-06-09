/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.FrequenciaAlimentar;
import br.com.projetoestagio.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FrequenciaAlimentarDAOImpl implements GenericDAO {

    private Connection conn;

    public FrequenciaAlimentarDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso !");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        FrequenciaAlimentar frequenciaalimentar = (FrequenciaAlimentar) object;
        PreparedStatement stmt = null;
        String sql = "Insert into frequenciaalimentar(fruta_frequencia_alimentar, verduras_frequencia_alimentar,"
                + "legumes_frequencia_alimentar, carne_vermelha_frequencia_alimentar, carne_branca_frequencia_alimentar,"
                + "leite_derivados_frequencia_alimentar, ovos_frequencia_alimentar, cereais_frequencia_alimentar,"
                + "massas_frequencia_alimentar, leguminosas_frequencia_alimentar, paes_frequencia_alimentar,"
                + "doces_frequencia_alimentar, refrigerante_frequencia_alimentar, alcool_frequencia_alimentar,"
                + "gordurosos_frequencia_alimentar, status_frequencia_alimentar )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? );";
        try {
            stmt = conn.prepareStatement(sql);
             stmt.setString(1, frequenciaalimentar.getFrutaFrequenciaAlimentar());
            stmt.setString(2, frequenciaalimentar.getVerdurasFrequenciaAlimentar());
            stmt.setString(3, frequenciaalimentar.getLegumesFrequenciaAlimentar());
            stmt.setString(4, frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar());
            stmt.setString(5, frequenciaalimentar.getCarnebrancaFrequenciaAlimentar());
            stmt.setString(6, frequenciaalimentar.getLeitederivadosFrequenciaAlimentar());
            stmt.setString(7, frequenciaalimentar.getOvosFrequenciaAlimentar());
            stmt.setString(8, frequenciaalimentar.getCereaisFrequenciaAlimentar());
            stmt.setString(9, frequenciaalimentar.getMassasFrequenciaAlimentar());
            stmt.setString(10, frequenciaalimentar.getLeguminosasFrequenciaAlimentar());
            stmt.setString(11, frequenciaalimentar.getPaesFrequenciaAlimentar());
            stmt.setString(12, frequenciaalimentar.getDocesFrequenciaAlimentar());
            stmt.setString(13, frequenciaalimentar.getRefrigeranteFrequenciaAlimentar());
            stmt.setString(14, frequenciaalimentar.getAlcoolFrequenciaAlimentar());
            stmt.setString(15, frequenciaalimentar.getGordurososFrequenciaAlimentar());
            stmt.setString(16, frequenciaalimentar.getStatusFrequenciaAlimentar());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Frequencia Alimentar! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão ! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from frequenciaalimentar";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FrequenciaAlimentar frequenciaalimentar = new FrequenciaAlimentar();
                frequenciaalimentar.setIdFrequenciaAlimentar(rs.getInt("id_frequencia_alimentar"));
                frequenciaalimentar.setFrutaFrequenciaAlimentar(rs.getString("fruta_frequencia_alimentar"));
                frequenciaalimentar.setVerdurasFrequenciaAlimentar(rs.getString("verduras_frequencia_alimentar"));
                frequenciaalimentar.setLegumesFrequenciaAlimentar(rs.getString("legumes_frequencia_alimentar"));
                frequenciaalimentar.setCarnevermelhaFrequenciaAlimentar(rs.getString("carne_vermelha_frequencia_alimentar"));
                frequenciaalimentar.setCarnebrancaFrequenciaAlimentar(rs.getString("carne_branca_frequencia_alimentar"));
                frequenciaalimentar.setLeitederivadosFrequenciaAlimentar(rs.getString("leite_derivados_frequencia_alimentar"));
                frequenciaalimentar.setOvosFrequenciaAlimentar(rs.getString("ovos_frequencia_alimentar"));
                frequenciaalimentar.setCereaisFrequenciaAlimentar(rs.getString("cereais_frequencia_alimentar"));
                frequenciaalimentar.setMassasFrequenciaAlimentar(rs.getString("massas_frequencia_alimentar"));
                frequenciaalimentar.setLeguminosasFrequenciaAlimentar(rs.getString("leguminosas_frequencia_alimentar"));
                frequenciaalimentar.setPaesFrequenciaAlimentar(rs.getString("paes_frequencia_alimentar"));
                frequenciaalimentar.setDocesFrequenciaAlimentar(rs.getString("doces_frequencia_alimentar"));
                frequenciaalimentar.setRefrigeranteFrequenciaAlimentar(rs.getString("refrigerante_frequencia_alimentar"));
                frequenciaalimentar.setAlcoolFrequenciaAlimentar(rs.getString("alcool_frequencia_alimentar"));
                frequenciaalimentar.setGordurososFrequenciaAlimentar(rs.getString("gordurosos_frequencia_alimentar"));;
                frequenciaalimentar.setStatusFrequenciaAlimentar(rs.getString("status_frequencia_alimentar"));
                resultado.add(frequenciaalimentar);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar frequenciaalimentar! Erro" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FrequenciaAlimentar frequenciaalimentar = null;
        String sql = "select f.* from frequenciaalimentar f where f.id_frequencia_alimentar=? ;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                frequenciaalimentar = new FrequenciaAlimentar();
                frequenciaalimentar.setIdFrequenciaAlimentar(rs.getInt("id_frequencia_alimentar"));
                frequenciaalimentar.setFrutaFrequenciaAlimentar(rs.getString("fruta_frequencia_alimentar"));
                frequenciaalimentar.setVerdurasFrequenciaAlimentar(rs.getString("verduras_frequencia_alimentar"));
                frequenciaalimentar.setLegumesFrequenciaAlimentar(rs.getString("legumes_frequencia_alimentar"));
                frequenciaalimentar.setCarnevermelhaFrequenciaAlimentar(rs.getString("carne_vermelha_frequencia_alimentar"));
                frequenciaalimentar.setCarnebrancaFrequenciaAlimentar(rs.getString("carne_branca_frequencia_alimentar"));
                frequenciaalimentar.setLeitederivadosFrequenciaAlimentar(rs.getString("leite_derivados_frequencia_alimentar"));
                frequenciaalimentar.setOvosFrequenciaAlimentar(rs.getString("ovos_frequencia_alimentar"));
                frequenciaalimentar.setCereaisFrequenciaAlimentar(rs.getString("cereais_frequencia_alimentar"));
                frequenciaalimentar.setMassasFrequenciaAlimentar(rs.getString("massas_frequencia_alimentar"));
                frequenciaalimentar.setLeguminosasFrequenciaAlimentar(rs.getString("leguminosas_frequencia_alimentar"));
                frequenciaalimentar.setPaesFrequenciaAlimentar(rs.getString("paes_frequencia_alimentar"));
                frequenciaalimentar.setDocesFrequenciaAlimentar(rs.getString("doces_frequencia_alimentar"));
                frequenciaalimentar.setRefrigeranteFrequenciaAlimentar(rs.getString("refrigerante_frequencia_alimentar"));
                frequenciaalimentar.setAlcoolFrequenciaAlimentar(rs.getString("alcool_frequencia_alimentar"));
                frequenciaalimentar.setGordurososFrequenciaAlimentar(rs.getString("gordurosos_frequencia_alimentar"));
                frequenciaalimentar.setStatusFrequenciaAlimentar(rs.getString("status_frequencia_alimentar"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar frequenciaalimentar! Erro" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return frequenciaalimentar;
    }

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {

        FrequenciaAlimentar frequenciaalimentar = (FrequenciaAlimentar) object;
        PreparedStatement stmt = null;
        String sql = "Update frequenciaalimentar set fruta_frequencia_alimentar =?, verduras_frequencia_alimentar=?,"
                + "legumes_frequencia_alimentar=?, carne_vermelha_frequencia_alimentar=?,"
                + "carne_branca_frequencia_alimentar=?, leite_derivados_frequencia_alimentar=?,"
                + "ovos_frequencia_alimentar=?, cereais_frequencia_alimentar=?, massas_frequencia_alimentar=?,"
                + "leguminosas_frequencia_alimentar=?, paes_frequencia_alimentar=?, doces_frequencia_alimentar=?,"
                + "refrigerante_frequencia_alimentar=?, alcool_frequencia_alimentar=?, gordurosos_frequencia_alimentar=? "
                + "where id_frequencia_alimentar=?;";
        try {
            stmt = conn.prepareStatement(sql);   
            
            stmt.setString(1, frequenciaalimentar.getFrutaFrequenciaAlimentar());
            stmt.setString(2, frequenciaalimentar.getVerdurasFrequenciaAlimentar());
            stmt.setString(3, frequenciaalimentar.getLegumesFrequenciaAlimentar());
            stmt.setString(4, frequenciaalimentar.getCarnevermelhaFrequenciaAlimentar());
            stmt.setString(5, frequenciaalimentar.getCarnebrancaFrequenciaAlimentar());
            stmt.setString(6, frequenciaalimentar.getLeitederivadosFrequenciaAlimentar());
            stmt.setString(7, frequenciaalimentar.getOvosFrequenciaAlimentar());
            stmt.setString(8, frequenciaalimentar.getCereaisFrequenciaAlimentar());
            stmt.setString(9, frequenciaalimentar.getMassasFrequenciaAlimentar());
            stmt.setString(10, frequenciaalimentar.getLeguminosasFrequenciaAlimentar());
            stmt.setString(11, frequenciaalimentar.getPaesFrequenciaAlimentar());
            stmt.setString(12, frequenciaalimentar.getDocesFrequenciaAlimentar());
            stmt.setString(13, frequenciaalimentar.getRefrigeranteFrequenciaAlimentar());
            stmt.setString(14, frequenciaalimentar.getAlcoolFrequenciaAlimentar());
            stmt.setString(15, frequenciaalimentar.getGordurososFrequenciaAlimentar());
            stmt.setInt(16, frequenciaalimentar.getIdFrequenciaAlimentar());
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar frequenciaalimentar! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parametros de conexão ! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean inativar(Object object) {
        
        FrequenciaAlimentar frequenciaalimentar = (FrequenciaAlimentar) object;
        PreparedStatement stmt = null;
        String sql = "update frequenciaalimentar set status_frequencia_alimentar=? where id_frequencia_alimentar=?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, frequenciaalimentar.getStatusFrequenciaAlimentar());
            stmt.setInt(2, frequenciaalimentar.getIdFrequenciaAlimentar());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao inativar Frequencia Alimentar! Erro: " + ex.getMessage());
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
