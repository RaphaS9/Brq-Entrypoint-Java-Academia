package br.com.raphsousa.academia.modelo.entidades;

public class Treino {
    private int id;
    private Aluno aluno;
    private Professor professor;
    private String titulo, descricao;

    public Treino(int id, Aluno aluno, Professor professor, String titulo,
            String descricao) {
        this.id = id;
        this.aluno = aluno;
        this.professor = professor;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Treino(Aluno aluno, Professor professor, String titulo,
            String descricao) {
        this.aluno = aluno;
        this.professor = professor;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
