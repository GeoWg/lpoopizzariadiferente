/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell-soncini
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void insertTest() {
        ClienteDAO cd = new ClienteDAO();
        Cliente c = new Cliente();
        c.setNome("Felipe");
        c.setSobreNome("Moreno Wong");
        c.setTelefone("4196229192");
        c.setEndereco("Ruca Casa dele n 5555 Ap3");
        cd.insert(c);
    }
    ///@Test
    public void updateTest() {
        ClienteDAO cd = new ClienteDAO();
        Cliente c = new Cliente();
        c.setId(1);
        c.setNome("Felipe");
        c.setSobreNome("Moreno Wong3");
        c.setTelefone("4196229192");
        c.setEndereco("Ruca Casa dele n 5555 Ap3");
        cd.update(c);
    }
    //@Test
    public void DeleteTest() {
        ClienteDAO cd = new ClienteDAO();
        Cliente c = new Cliente();
        c.setId(1);
        c.setNome("Felipe");
        c.setSobreNome("Moreno Wong2");
        c.setTelefone("419989454");
        c.setEndereco("Ruca Casa dele n 5555 Ap3");
        cd.delete(c);
    }
    @Test
    public void slectTest() {
        ClienteDAO cd = new ClienteDAO();
        List<Cliente> lc = cd.getAll();
        System.out.println("babaca");
    }
    
    @Test
    public void slectTestTelefone() {
        ClienteDAO cd = new ClienteDAO();
        List<Cliente> lc = cd.getByTelefone("4196229192");
        System.out.println("Teste do telefone funcionou");
    }
}
