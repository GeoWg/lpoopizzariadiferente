/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Felipe Moreno
 */
public enum FormaEnum {
   Circulo(1), Quadrado(2), Triangulo(3);
   private int value;
   
   private FormaEnum(int value) {
      this.value = value;
   }
   public int getValue() {
      return value;
   }
}
