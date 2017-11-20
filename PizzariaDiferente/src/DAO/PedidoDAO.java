/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cliente;
import Bean.Pedido;
import Bean.Pizza;
import Bean.Status;
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

    private final String insertPedido = "INSERT INTO pedido (idCliente, idStatus) VALUES (?,?)";
    private final String update = "UPDATE pedido SET idStatus = ? WHERE idPedido =  ?";
    private final String getById = "SELECT * FROM pedido WHERE idPedido = ?";
    private final String getAll = "SELECT * FROM pedido ORDER BY idPedido DESC";
    private final String getByIdStatus = "SELECT * FROM pedido  WHERE idStatus = ? ORDER BY idPedido DESC";
   
  
    
    public Pedido insertPedido(Pedido pedido) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertPedido, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pedido.getClienteId());
            stmt.setInt(2, 1);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            pedido.setId(rs.getInt(1));
            PizzaDAO pd = new PizzaDAO();
            for(Pizza p : pedido.getPizzas())
            {
                pd.insert(p,pedido.getId());
            }            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
        return pedido;
    }

    public Pedido updateStatus(Pedido pedido, int idStatus) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(update);
            stmt.setInt(1, idStatus);
            stmt.setInt(2, pedido.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
        return pedido;
    }

    public List<Pedido> getAll() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getAll);
            rs = stmt.executeQuery();
            ClienteDAO cd = new ClienteDAO();
            StatusDAO sd = new StatusDAO();
            PizzaDAO pd = new PizzaDAO();
            while (rs.next()) {
                int idPedido = rs.getInt("idPedido");
                double valor = rs.getDouble("valor");
                int idCliente = rs.getInt("idCliente");
                int idStatus = rs.getInt("idStatus");
                Cliente cli = cd.getById(idCliente);
                Status st = sd.getById(idStatus);
                List<Pizza> pizzas = pd.getByIdPedido(idPedido);
                Pedido p = new Pedido();
                p.setCliente(cli);
                p.setPizzas(pizzas);
                p.setStatus(st);
                p.setId(idPedido);
                pedidos.add(p);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
        return pedidos;
    }

    public List<Pedido> getByIdStatus(int statusId) {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getByIdStatus);
            stmt.setInt(1, statusId);
            rs = stmt.executeQuery();
            ClienteDAO cd = new ClienteDAO();
            StatusDAO sd = new StatusDAO();
            PizzaDAO pd = new PizzaDAO();
            while (rs.next()) {
                int idPedido = rs.getInt("idPedido");
                double valor = rs.getDouble("valor");
                int idCliente = rs.getInt("idCliente");
                int idStatus = rs.getInt("idStatus");
                Cliente cli = cd.getById(idCliente);
                Status st = sd.getById(idStatus);
                List<Pizza> pizzas = pd.getByIdPedido(idPedido);
                Pedido p = new Pedido();
                p.setCliente(cli);
                p.setPizzas(pizzas);
                p.setStatus(st);
                p.setId(idPedido);
                pedidos.add(p);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
        return pedidos;
    }

    public void insertPedidoPizza() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertPedido, PreparedStatement.RETURN_GENERATED_KEYS);
            PedidoDAO pedidodao = new PedidoDAO();
            Pedido pedido = (Pedido) pedidodao.getAll();
            stmt.setDouble(1, pedido.getValor());
            stmt.setInt(2, pedido.getStatusId());
            stmt.setInt(3, pedido.getClienteId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            pedido.setId(rs.getInt(1));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
}
