/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import br.com.projetoestagio.model.AlimentoRefeicao;
import br.com.projetoestagio.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Leticia
 */
public class AlimentoRefeicaoDAOImpl implements GenericDAO{
    
      
    private Connection conn;

    public AlimentoRefeicaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }
    
    @Override
    public Boolean cadastrar(Object object) {
    
        AlimentoRefeicao alimentorefeicao = (AlimentoRefeicao) object;
        PreparedStatement stmt = null;
        String sql = "Insert into alimentorefeicao ( quantidade_alimento_refeicao, tipo_medida_alimento_refeicao, "
                + " id_alimento, id_refeicao) "
                + " values (?, ?, ?, ?) ;";
        try {

            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, alimentorefeicao.getQuantidadeAlimentoRefeicao());
            stmt.setString(2, alimentorefeicao.getTipoMedidaAlimentoRefeicao());
            stmt.setInt(3, alimentorefeicao.getAlimento().getIdAlimento());
            stmt.setInt(4, alimentorefeicao.getRefeicao().getIdRefeicao());
            stmt.execute();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao Cadastrar AlimentoRefeicaoDAOImpl()" + ex.getMessage());
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

    @Override
    public List<Object> listar() {
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
    
    
}
