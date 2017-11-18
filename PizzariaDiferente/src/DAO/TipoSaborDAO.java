/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.TipoSabor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Moreno
 */
public class TipoSaborDAO {
    
    private final String getById = "SELECT * FROM tiposabor WHERE idTipoSabor = ?";
    private final String getAll = "SELECT * FROM tiposabor";
     private final String updateStm = "UPDATE tiposabor SET  preco = ? WHERE idTipoSabor =  ?";
    
    public List<TipoSabor> getAll(){
       List<TipoSabor> tipos = new ArrayList<TipoSabor>();
       Connection con = null;
       PreparedStatement stmt = null;
       ResultSet rs = null;
       try {
           con = ConnectionFactory.getConnection();
           stmt = con.prepareStatement(getAll);
           rs = stmt.executeQuery();
           while(rs.next()){
               int id = rs.getInt("idTipoSabor");
               String nome = rs.getString("nome");
               int preco = rs.getInt("preco");
               TipoSabor ts = new TipoSabor(id, nome, preco);
               tipos.add(ts);
           }
       } catch (Exception ex) {
           throw new RuntimeException("Erro. Origem="+ex.getMessage());
       } finally{
           try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
           try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
       }
       return tipos;
   }
     
    public TipoSabor getById(int id){
       TipoSabor tiposabor;
       Connection con = null;
       PreparedStatement stmt = null;
       ResultSet rs = null;
       try {
           con = ConnectionFactory.getConnection();
           stmt = con.prepareStatement(getById);
           stmt.setInt(1, id);
           rs = stmt.executeQuery();
           if(rs.next()){
                tiposabor = new TipoSabor();
                tiposabor.setId(rs.getInt("idTipoSabor"));
                tiposabor.setNome(rs.getString("nome"));
                tiposabor.setPreco(rs.getInt("preco"));
            }else{
                throw new RuntimeException("Não existe com este id. Id="+id);
            }
       } catch (Exception ex) {
           throw new RuntimeException("Erro. Origem="+ex.getMessage());
       } finally{
           try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
           try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
       }
       return tiposabor;
   }
    public void update(TipoSabor tiposabor){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(updateStm);
            
            stmt.setDouble(1, tiposabor.getPreco());
            stmt.setInt(2, tiposabor.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }    
    
}
