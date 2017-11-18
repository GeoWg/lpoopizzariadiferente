/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dell-soncini
 */
public class StatusDAO {
      private final String getById = "SELECT * FROM pedido WHERE idPedido = ?";
      
      public Status getById(int id){
        Status s = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                s = new Status(rs.getInt("idStatus"),rs.getString("descricao"));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return s;
    }
}
