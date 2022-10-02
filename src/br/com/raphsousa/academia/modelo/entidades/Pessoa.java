package br.com.raphsousa.academia.modelo.entidades;

/**
 *
 * @author idrap
 */
public abstract class Pessoa {
    private int id;
    private String nome;

//    Construtor que recebe somente id para podermos fazer alterações 
//    em tabelas relacionadas (no caso alterar um treino pegando somente 
//    o id da pessoa)
    public Pessoa(int id) {
        this.id = id;
    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(String nome) {
        this.nome = nome;
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
    
    
}
