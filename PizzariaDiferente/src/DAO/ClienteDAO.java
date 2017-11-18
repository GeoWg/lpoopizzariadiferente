/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell-soncini
 */
public class ClienteDAO {
    
    private final String insertStm = "INSERT INTO cliente (nome,sobrenome,telefone,endereco) VALUES (?,?,?,?)";
    private final String updateStm = "UPDATE cliente SET  nome = ? ,sobrenome = ? ,telefone = ? ,endereco = ? WHERE idCliente =  ?";
    private final String deleteStm = "DELETE FROM cliente WHERE idCliente = ?";
    private final String getAll = "SELECT * FROM cliente ORDER BY idCliente DESC";
    private final String getByFilter = "SELECT * FROM cliente WHERE telefone like ? AND sobrenome like ? ORDER BY idCliente DESC";
    private final String getByTelefone = "SELECT * FROM cliente WHERE telefone = ?";
    private final String getById = "SELECT * FROM cliente WHERE idCliente = ?";
    
    public Cliente insert(Cliente cliente){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertStm, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobreNome());
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
    
    public void update(Cliente cliente){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(updateStm);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobreNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setInt(5, cliente.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public void delete(Cliente cliente){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(deleteStm);
            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();
            //TODO deletear pedidos do cliente
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public List<Cliente> getAll(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getAll);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String sobre = rs.getString("sobrenome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                Cliente cli = new Cliente(id, nome, sobre,telefone, endereco);
                clientes.add(cli);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return clientes;
    }
    
     public List<Cliente> getByFilters(String Telefone,String sobrenome){
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getByFilter);
            stmt.setString(1, "%"+Telefone+"%");
            stmt.setString(2, "%"+sobrenome+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String sobre = rs.getString("sobrenome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                Cliente cli = new Cliente(id, nome, sobre,telefone, endereco);
                clientes.add(cli);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return clientes;
    }
    
    public Cliente getByTelefone(String fone){
        Cliente c = new Cliente();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getByTelefone);
            stmt.setString(1, fone);
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setSobreNome(rs.getString("sobrenome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return c;
    }
    
    public Cliente getById(int id){
        Cliente c = new Cliente();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setSobreNome(rs.getString("sobrenome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return c;
    }
}
