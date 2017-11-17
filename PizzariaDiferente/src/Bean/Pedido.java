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
public class Pedido {
    public int id;
    public Cliente cliente;
    public List<Pizza> pizzas;
    public float valor;
    public Status status;

    public Pedido() {
    }

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, int valor, Status status) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valor = valor;
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

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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
