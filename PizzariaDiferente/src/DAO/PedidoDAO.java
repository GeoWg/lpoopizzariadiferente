/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cliente;
import Bean.Pedido;
import Bean.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Moreno
 */
public class PedidoDAO {
    
    private final String insertPedido = "INSERT INTO pedido (valor,idCliente,idStatus) VALUES (?,?,?)";
    private final String insertPizza = "INSERT INTO pedidoPizza (idPedido, idForma, tamanho, idSabor1, idSabor2, valor) VALUES (?,?,?,?,?,?)";
    private final String updateStm = "UPDATE pedido SET  valor = ?, idStatus = ?, pizza = ? WHERE idPedido =  ?";
    private final String byId = "SELECT * FROM pedido WHERE idPedido = ?";
 
    public Pedido insertPedido(Pedido pedido){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertPedido, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setFloat(1, pedido.getValor());
            stmt.setInt(2, pedido.getClienteId());
            stmt.setInt(3, pedido.getStatusId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            pedido.setId(rs.getInt(1));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return pedido;
    }
    /*
    public List<Pizza> insertPizza(Pizza pizza){
        List<Pizza> pizzas = new ArrayList<Pizza>();
        Connection con = null;
        PreparedStatement stmt = null, stmt2 = null;
        ResultSet rs = null, rs2 = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertPizza);
            stmt = con.prepareStatement(insertPedido, PreparedStatement.RETURN_GENERATED_KEYS);
            rs2 = stmt2.getGeneratedKeys();
            for(int i = 0; i<pizza.size; i++){
                stmt.setInt(1,rs2.getInt(1));
                stmt.setInt(2, pizza);
                stmt.setInt(2, pedido.getClienteId());
                stmt.setInt(3, pedido.getStatusId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                pedido.setId(rs.getInt(1));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return clientes;
    }*/
}
