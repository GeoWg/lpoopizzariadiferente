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
public class Circulo extends Forma{
    
    public double raio;
    
    public Circulo (int raio){
        this.raio = raio;
    }
    
    @Override
    public double getArea(){
        return Math.PI * (raio *raio); 
    }
}
