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
    public double area;

    public Quadrado() {
    }
    
    public Quadrado(double lado ){
        this.lado =lado;
    }
    
    @Override
    public double getArea(){
        return lado * lado;
    }
    @Override
    public double getMedida(){
        //return ((lado * lado)  / 4) * Math.sqrt(3); 
        
        return   Math.sqrt(area);
    }
    
    @Override
    public void setMedida(double lado){
        this.lado = lado;
    }
    
    @Override
    public void setArea(double area){
        this.area = area;
    }
    
}
