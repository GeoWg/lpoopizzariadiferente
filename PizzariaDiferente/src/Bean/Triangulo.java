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
    public double area;
    
    public Triangulo (double lado){
        this.lado = lado;
    } 
    @Override
    public double getArea(){
        return ((lado * lado) / 4) * Math.sqrt(3); 
    }
    @Override
    public double getMedida(){
        //return ((lado * lado)  / 4) * Math.sqrt(3); 
        
        return   Math.sqrt((area * 4) / Math.sqrt(3));
    }
    
}
