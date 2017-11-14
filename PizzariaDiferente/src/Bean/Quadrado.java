/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author dell-soncini
 */
public class Quadrado extends Forma{
    public double lado;
    
    public Quadrado(double lado ){
        this.lado =lado;
    }
    
    @Override
    public double getArea(){
        return lado * lado;
    }
}
