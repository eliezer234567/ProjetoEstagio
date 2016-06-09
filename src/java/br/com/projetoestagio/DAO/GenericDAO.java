/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestagio.DAO;

import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author Leticia
 */
public interface GenericDAO {
    
    public Boolean cadastrar(Object object);
    
    public List<Object> listar();
    
    public void excluir(int idObject);
    
    public Boolean inativar(Object object);
    
    public Object carregar(int idObject);
    
    public Boolean alterar(Object object);
    
}
