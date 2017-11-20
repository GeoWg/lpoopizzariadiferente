/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell-soncini
 */
public class Pedido {
    public int id;
    public Cliente cliente;
    public List<Pizza> pizzas;
    public Status status;

    public Pedido() {
        pizzas = new ArrayList<Pizza>();
    }

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, Status status) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public int getClienteId(){
        return cliente.id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }
    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }
    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public double getValor() {
        double valor = 0;
        for(Pizza p : pizzas){
            valor += p.getPreco();
        }
        return valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public int getStatusId(){
        return status.id;
    }
}
