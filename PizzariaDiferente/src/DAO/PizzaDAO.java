/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Forma;
import Bean.FormaEnum;
import Bean.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell-soncini
 */
public class PizzaDAO {
    
    private final String getByIdPedido = "SELECT * FROM pedido WHERE idPedido = ?";
    
      public List<Pizza> getByIdPedido(int idPedido){
        List<Pizza> pedidos = new ArrayList<Pizza>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getByIdPedido);
            stmt.setInt(1, idPedido);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idPedidoPizza");
                int idForma = rs.getInt("idForma");
                Forma forma = null;
                if(idForma == FormaEnum.Circulo.getValue()){
                    
                }
                
                int idStatus = rs.getInt("idStatus");    
                Cliente cli = cd.getById(idCliente);
                Status s = sd.getById(idStatus);
                
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return pedidos;
    }
    
}
