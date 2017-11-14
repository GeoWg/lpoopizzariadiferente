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
public class Triangulo extends Forma{
    public double lado;
    
    public Triangulo (double lado){
        this.lado = lado;
    } 
    
    public double getArea(){
        return ((lado * lado) / 4) * Math.sqrt(3); 
    }
}

