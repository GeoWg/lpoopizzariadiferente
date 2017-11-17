/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Sabor;
import Bean.TipoSabor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe Moreno
 */
public class SaborDAOTest {
    
    public SaborDAOTest() {
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
        SaborDAO sd = new SaborDAO();
        Sabor s = new Sabor();
        TipoSaborDAO tsd = new TipoSaborDAO();
        TipoSabor t = new TipoSabor();
        t = tsd.getById(2);
        s.setNome("Lombo");
        s.setDescricao("Lombo, queijo, molho de tomate, catupiry, etc");
        s.setTipo(t);
        sd.insert(s);}
}
