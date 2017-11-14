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
public class Sabor {
    public int id;
    public String nome;
    public String descricao;
    public TipoSabor tipo;

    public Sabor(int id, String nome, String descricao, TipoSabor sabor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = sabor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoSabor getTipo() {
        return tipo;
    }

    public void setTipo(TipoSabor tipo) {
        this.tipo = tipo;
    }
    
    public double getPreco(){
        return this.tipo.getPreco();
    }
}
