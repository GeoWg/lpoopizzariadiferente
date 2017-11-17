/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Felipe Moreno
 */
public class PedidoDAO {
    
    private final String insertStm = "INSERT INTO pedido (valor,idCliente,idStatus,pizza) VALUES (?,?,?,?)";
    private final String updateStm = "UPDATE pedido SET  valor = ?, idStatus = ?, pizza = ? WHERE idPedido =  ?";
    private final String byId = "SELECT * FROM pedido WHERE idPedido = ?";
 
    /*
    public Pedido insert(Pedido pedido){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertStm, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, pedido.getValor());
            stmt.setC(2, pedido.getCliente());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            cliente.setId(rs.getInt(1));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir um livro no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return cliente;
    }
*/
}
