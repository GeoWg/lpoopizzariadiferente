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

    public Pizza(Forma forma, List<Sabor> sabores) {
        this.forma = forma;
        this.sabores = sabores;
    }

    public Pizza() {

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

    public void addSabor(Sabor sabor) {
        sabores.add(sabor);
    }

    public void removeSabor(Sabor sabor) {
        sabores.remove(sabores.size() - 1);
    }

    public double getPreco() {
        return forma.getArea() * getPrecoCm();
    }

    public String getStringSabor() {
        String s = "";
        for (int i = 0; i < sabores.size(); i++) {
            if (i == 0) {
                s += sabores.get(i).getNome();
            } else {
                s += " / " + sabores.get(i).getNome();
            }

        }
        return s;
    }

    public double getPrecoCm() {
        double soma = 0;
        for (int i = 0; i < sabores.size(); i++) {
            soma += sabores.get(i).getPreco();
        }
        try {
            return soma / sabores.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
