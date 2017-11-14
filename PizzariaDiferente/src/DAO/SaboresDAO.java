/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Sabor;
import Bean.TipoSabor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell-soncini
 */
public class SaboresDAO {
    private String selectAll = "SELECT s.idSabor as id, s.nome as nome, s.descricao as descricao, st.idTipoSabor as idTipo, st.nome as tipoNome, st.preco as preco FROM sabor s INNER JOIN tiposabor st ON s.idtiposabor = st.idtiposabor";
    
    public List<Sabor> getAll(){
        List<Sabor> sabores = new ArrayList<Sabor>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(selectAll);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                int idtipo = rs.getInt("idTipo");
                double preco = rs.getDouble("preco");
                String tipoNome = rs.getString("tipoNome");
                Sabor sabor = new Sabor(id, nome, descricao, new TipoSabor(idtipo,tipoNome,preco));
                sabores.add(sabor);
            }
        } catch (SQLException ex) {
           
            throw new RuntimeException("Erro ao inserir um livro no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return sabores;
    }
}
