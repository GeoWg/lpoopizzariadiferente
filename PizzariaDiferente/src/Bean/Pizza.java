/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;

/**
 *
 * @author dell-soncini
 */
public class Pizza {
    
    private Forma forma;
    private List<Sabor> sabores;
    
    public Pizza(Forma forma, List<Sabor> sabores)
    {
        this.forma = forma;
        this.sabores = sabores;
    }

    public Forma getForma() {
        return forma;
    }
        
    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }
    
    public double getPreco(){
        return forma.getArea() * getPrecoCm();
    }
    
    public double getPrecoCm(){
        int soma = 0;
        for(int i = 0; i < sabores.size(); i ++){
            soma += sabores.get(i).getPreco();
        }
        return soma/ sabores.size();
    }
}
