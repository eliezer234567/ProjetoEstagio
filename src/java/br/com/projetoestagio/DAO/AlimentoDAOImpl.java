/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.Alimento;
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
public class AlimentoDAOImpl implements GenericDAO {

    private Connection conn;

    public AlimentoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Alimento alimento = (Alimento) object;
        PreparedStatement stmt = null;
        String sql = "Insert into alimento(nome_tabela_nutricional_alimento, nome_alimento, tipo_alimento,"
                + " especie_alimento, proteina_alimento, lipideo_alimento, carboidrato_alimento, fibra_alimentar_alimento,"
                + "status_alimento, caminho_imagem_alimento )values(?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, alimento.getNomeTabelaNutricionalAlimento());
            stmt.setString(2, alimento.getNomeAlimento());
            stmt.setString(3, alimento.getTipoAlimento());
            stmt.setString(4, alimento.getEspecieAlimento());
            stmt.setDouble(5, alimento.getProteinaAlimento());
            stmt.setDouble(6, alimento.getLipideoAlimento());
            stmt.setDouble(7, alimento.getCarboidratoAlimento());
            stmt.setDouble(8, alimento.getFibraAlimentarAlimento());
            stmt.setString(9, alimento.getStatusAlimento());
            stmt.setString(10, alimento.getCaminhoImagemAlimento());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro no cadastro " + ex.getMessage());
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

    public List<Object> listarPorStatus(String statusAlimento) {

        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        if(statusAlimento.equals("A"))
            sql = "select a.* from alimento a  where status_alimento = 'A' order by a.nome_alimento ";
        else if (statusAlimento.equals("I"))
            sql = "select a.* from alimento a  where status_alimento = 'I' order by a.nome_alimento ";
        else
            sql = "select a.* from alimento a order by a.nome_alimento ";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdAlimento(rs.getInt("id_alimento"));
                alimento.setNomeTabelaNutricionalAlimento(rs.getString("nome_tabela_nutricional_alimento"));
                alimento.setNomeAlimento(rs.getString("nome_alimento"));
                alimento.setTipoAlimento(rs.getString("tipo_alimento"));
                alimento.setEspecieAlimento(rs.getString("especie_alimento"));
                alimento.setProteinaAlimento(rs.getDouble("proteina_alimento"));
                alimento.setLipideoAlimento(rs.getDouble("lipideo_alimento"));
                alimento.setCarboidratoAlimento(rs.getDouble("carboidrato_alimento"));
                alimento.setFibraAlimentarAlimento(rs.getDouble("fibra_alimentar_alimento"));
                alimento.setStatusAlimento(rs.getString("status_alimento"));
                alimento.setCaminhoImagemAlimento(rs.getString("caminho_imagem_alimento"));
                resultado.add(alimento);
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
    public void excluir(int idObject
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alimento alimento = null;
        String sql = "select a.* from alimento a where a.id_alimento=? ;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                alimento = new Alimento();
                alimento.setIdAlimento(rs.getInt("id_alimento"));
                alimento.setNomeTabelaNutricionalAlimento(rs.getString("nome_tabela_nutricional_alimento"));
                alimento.setNomeAlimento(rs.getString("nome_alimento"));
                alimento.setTipoAlimento(rs.getString("tipo_alimento"));
                alimento.setEspecieAlimento(rs.getString("especie_alimento"));
                alimento.setProteinaAlimento(rs.getDouble("proteina_alimento"));
                alimento.setFibraAlimentarAlimento(rs.getDouble("fibra_alimentar_alimento"));
                alimento.setCarboidratoAlimento(rs.getDouble("carboidrato_alimento"));
                alimento.setLipideoAlimento(rs.getDouble("lipideo_alimento"));
                alimento.setStatusAlimento(rs.getString("status_alimento"));
                alimento.setCaminhoImagemAlimento(rs.getString("caminho_imagem_alimenmto"));
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
        return alimento;
    }

    @Override
    public Boolean alterar(Object object) {

        Alimento alimento = (Alimento) object;
        PreparedStatement stmt = null;
        String sql = "update alimento set nome_tabela_nutricional_alimento=?, nome_alimento=?, tipo_alimento=?, "
                + "especie_alimento=?, proteina_alimento=?, lipideo_alimento=?, "
                + "carboidrato_alimento=?, fibra_alimentar_alimento=?, status_alimento=?, caminho_imagem_alimento =? "
                + "where id_alimento=?;";
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, alimento.getNomeTabelaNutricionalAlimento());
            stmt.setString(2, alimento.getNomeAlimento());
            stmt.setString(3, alimento.getTipoAlimento());
            stmt.setString(4, alimento.getEspecieAlimento());
            stmt.setDouble(5, alimento.getProteinaAlimento());
            stmt.setDouble(6, alimento.getLipideoAlimento());
            stmt.setDouble(7, alimento.getCarboidratoAlimento());
            stmt.setDouble(8, alimento.getFibraAlimentarAlimento());
            stmt.setString(9, alimento.getStatusAlimento());
            stmt.setString(10, alimento.getCaminhoImagemAlimento());
            stmt.setInt(11, alimento.getIdAlimento());
            stmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao alterar AlimentoDAOImpl" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão AlimentoDAOImpl" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean inativar(Object object) {

        Alimento alimento = (Alimento) object;
        PreparedStatement stmt = null;
        String sql = "update alimento set status_alimento=? where id_alimento=?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, alimento.getStatusAlimento());
            stmt.setInt(2, alimento.getIdAlimento());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.print("Erro ao inativar AlimentoDAOImpl" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão" + ex.getMessage());
                ex.getStackTrace();
            }
        }
    }

    public List<Alimento> listarAlimento(String nome, String tipo) {
        ArrayList<Alimento> lista = new ArrayList<Alimento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;

        if (nome != null) {
            sql = "select a.id_alimento,a.nome_alimento, a.tipo_alimento from alimento a where a.nome_alimento ilike ?;";

            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome + "%");
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Alimento alimento = new Alimento();
                    alimento.setIdAlimento(rs.getInt("id_alimento"));
                    alimento.setNomeTabelaNutricionalAlimento("nome_tabela_nutricional_alimento");
                    alimento.setNomeAlimento(rs.getString("nome_alimento"));
                    alimento.setTipoAlimento(rs.getString("tipo_alimento"));
                    alimento.setEspecieAlimento(rs.getString("especie_alimento"));
                    alimento.setProteinaAlimento(rs.getDouble("proteina_alimento"));
                    alimento.setLipideoAlimento(rs.getDouble("lipideo_alimento"));
                    alimento.setCarboidratoAlimento(rs.getDouble("carboidrato_alimento"));
                    alimento.setFibraAlimentarAlimento(rs.getDouble("fibra_alimentar_alimento"));
                    alimento.setStatusAlimento(rs.getString("status_alimento"));
                    alimento.setCaminhoImagemAlimento(rs.getString("caminho_imagem_alimento"));
                    lista.add(alimento);

                }

            } catch (SQLException ex) {
                System.out.println("erro ao listar alimento pelo nome" + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, stmt, rs);
                } catch (Exception ex) {
                    System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } else {
            sql = "select*From alimento where tipo_alimento ilike ?;";

            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, tipo + "%");
                rs = stmt.executeQuery();

                while (rs.next()) {
                    Alimento alimento = new Alimento();
                    alimento.setIdAlimento(rs.getInt("id_alimento"));
                    alimento.setNomeTabelaNutricionalAlimento("nome_tabela_nutricional_alimento");
                    alimento.setNomeAlimento(rs.getString("nome_alimento"));
                    alimento.setTipoAlimento(rs.getString("tipo_alimento"));
                    alimento.setEspecieAlimento(rs.getString("especie_alimento"));
                    alimento.setProteinaAlimento(rs.getDouble("proteina_alimento"));
                    alimento.setLipideoAlimento(rs.getDouble("lipideo_alimento"));
                    alimento.setCarboidratoAlimento(rs.getDouble("carboidrato_alimento"));
                    alimento.setFibraAlimentarAlimento(rs.getDouble("fibra_alimentar_alimento"));
                    alimento.setStatusAlimento(rs.getString("status_alimento"));
                    alimento.setCaminhoImagemAlimento(rs.getString("caminho_imagem_alimento"));
                    lista.add(alimento);
                }

            } catch (SQLException ex) {
                System.out.println("erro ao listar alimento pelo nome" + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    ConnectionFactory.closeConnection(conn, stmt, rs);
                } catch (Exception ex) {
                    System.out.println("Erro ao finalizar conexão" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
        return lista;
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select a.* from alimento a  order by a.nome_alimento ";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdAlimento(rs.getInt("id_alimento"));
                alimento.setNomeTabelaNutricionalAlimento(rs.getString("nome_tabela_nutricional_alimento"));
                alimento.setNomeAlimento(rs.getString("nome_alimento"));
                alimento.setTipoAlimento(rs.getString("tipo_alimento"));
                alimento.setEspecieAlimento(rs.getString("especie_alimento"));
                alimento.setProteinaAlimento(rs.getDouble("proteina_alimento"));
                alimento.setLipideoAlimento(rs.getDouble("lipideo_alimento"));
                alimento.setCarboidratoAlimento(rs.getDouble("carboidrato_alimento"));
                alimento.setFibraAlimentarAlimento(rs.getDouble("fibra_alimentar_alimento"));
                alimento.setStatusAlimento(rs.getString("status_alimento"));
                alimento.setCaminhoImagemAlimento(rs.getString("caminho_imagem_alimento"));
                resultado.add(alimento);
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

}
