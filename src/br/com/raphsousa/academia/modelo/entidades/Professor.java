package br.com.raphsousa.academia.modelo.entidades;

public class Professor extends Pessoa {

    public Professor(int id, String nome) {
        super(id, nome);
    }

    public Professor(String nome) {
        super(nome);
    }

    public Professor(int id) {
        super(id);
    }

}
