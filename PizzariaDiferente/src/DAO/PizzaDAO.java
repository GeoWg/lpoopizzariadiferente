/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Circulo;
import Bean.Forma;
import Bean.FormaEnum;
import Bean.Pizza;
import Bean.Quadrado;
import Bean.Sabor;
import Bean.Triangulo;
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

    private final String getByIdPedido = "SELECT * FROM pedidopizza WHERE idPedido = ?";
    private final String insertPizzaSabor = "INSERT INTO pizzasabor (idpedidopizza, idsabor) VALUES (?,?)";
    private final String insertPedidoPizza = "INSERT INTO pedidopizza (idpedido, idforma, medida) VALUES (?,?,?)";
    private final String insertPedidoPizzaSabor = "INSERT INTO pizzasabor (idpedidopizza, idsabor) VALUES (?,?)";
    
    public void insertSabor(Sabor sabor, int idPedidoPizza){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertPedidoPizzaSabor, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idPedidoPizza);
            stmt.setInt(2, sabor.getId());            
            stmt.executeUpdate();
        }catch (Exception ex) {
            throw new RuntimeException("Erro. Origem=" + ex.getMessage());
        } finally {
            try {stmt.close();} catch (Exception ex) {System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());};
            try {con.close();} catch (Exception ex) {System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());};
        }
    }
    public Pizza insert(Pizza pizza, int idPedido){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertPedidoPizza, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idPedido);
            stmt.setInt(2, pizza.getForma().getId());
            stmt.setDouble(3, pizza.getForma().getMedida());
            rs = stmt.getGeneratedKeys();
            rs.next();
            int idPedidoPizza = rs.getInt(1);
            for(Sabor s : pizza.getSabores())
            {
                insertSabor(s,idPedidoPizza);
            }
            stmt.executeUpdate();
        }catch (Exception ex) {
            throw new RuntimeException("Erro. Origem=" + ex.getMessage());
        } finally {
            try {stmt.close();} catch (Exception ex) {System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());};
            try {con.close();} catch (Exception ex) {System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());};
        }
        return pizza;
    }
    
    public List<Pizza> getByIdPedido(int idPedido) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getByIdPedido);
            stmt.setInt(1, idPedido);
            rs = stmt.executeQuery();
            SaborDAO sd = new SaborDAO();
            while (rs.next()) {
                int id = rs.getInt("idPedidoPizza");
                int idForma = rs.getInt("idForma");
                Forma forma = null;
                if (idForma == FormaEnum.Quadrado.getValue()) {
                    forma = new Quadrado();

                } else if (idForma == FormaEnum.Circulo.getValue()) {
                    forma = new Triangulo();
                } else {
                    forma = new Circulo();
                }
                forma.setMedida(rs.getDouble("medida"));
                List<Sabor> sabores = sd.getByIdPizza(id);
                Pizza p = new Pizza(forma, sabores);
                pizzas.add(p);
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
        return pizzas;
    }

    public void insertPizzaSabor(int idPedidoPizza) {
        
    }
}
