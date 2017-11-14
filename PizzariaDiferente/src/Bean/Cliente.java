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
public class Cliente {
    public int id;
    public String Nome;
    public String SobreNome;
    public String Telefone;
    public String Endereco;

    public Cliente(){}
    
    public Cliente(int id, String Nome, String SobreNome, String Telefone, String Endereco) {
        this.id = id;
        this.Nome = Nome;
        this.SobreNome = SobreNome;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSobreNome() {
        return SobreNome;
    }

    public void setSobreNome(String SobreNome) {
        this.SobreNome = SobreNome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
}
