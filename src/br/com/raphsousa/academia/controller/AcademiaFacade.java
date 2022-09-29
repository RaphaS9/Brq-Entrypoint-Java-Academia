package br.com.raphsousa.academia.controller;

import br.com.raphsousa.academia.Base;
import br.com.raphsousa.academia.dao.AlunoDAO;
import br.com.raphsousa.academia.dao.ProfessorDAO;
import br.com.raphsousa.academia.dao.TreinoDAO;
import br.com.raphsousa.academia.enums.Genero;
import br.com.raphsousa.academia.modelo.bd.AcademiaBD;
import br.com.raphsousa.academia.modelo.entidades.Aluno;
import br.com.raphsousa.academia.modelo.entidades.Professor;
import br.com.raphsousa.academia.modelo.entidades.Treino;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AcademiaFacade {

    public static void InicializarBD() {
        AcademiaBD.inicializar();
    }

    public static void populaBD() {
        AcademiaBD.popular();
    }

    public static DefaultTableModel modeloDadosAluno(String[] camposAlunos) {
        List<Aluno> alunos = AlunoDAO.selecionarTodos();
        String[][] dadosAlunos;
        dadosAlunos = new String[alunos.size()][camposAlunos.length];
        int posicao = 0;
        for (Aluno al : alunos) {
            String[] umAluno = new String[camposAlunos.length];
            umAluno[0] = String.valueOf(al.getId());
            umAluno[1] = al.getNome();
            umAluno[2] = String.valueOf(al.getIdade());
            umAluno[3] = al.getGenero().getGenero();
            dadosAlunos[posicao++] = umAluno;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosAlunos, camposAlunos);
        return modelo;
    }

    public static DefaultTableModel modeloDadosProfessores(String[] camposProfessor) {
        List<Professor> professores = ProfessorDAO.selecionarTodos();
        String[][] dadosProfessores;
        dadosProfessores = new String[professores.size()][camposProfessor.length];
        int posicao = 0;
        for (Professor prof : professores) {
            String[] umAluno = new String[camposProfessor.length];
            umAluno[0] = String.valueOf(prof.getId());
            umAluno[1] = prof.getNome();
            dadosProfessores[posicao++] = umAluno;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosProfessores, camposProfessor);
        return modelo;
    }

    private static DefaultTableModel modeloDadosTreinos(String[] camposTreino,
            List<Treino> treinos) {
        String[][] dadosTreinos;
        dadosTreinos = new String[treinos.size()][camposTreino.length];
        int posicao = 0;
        for (Treino tr : treinos) {
            String[] umAluno = new String[camposTreino.length];
            umAluno[0] = String.valueOf(tr.getId());
            umAluno[1] = String.valueOf(tr.getAluno().getId());
            umAluno[2] = String.valueOf(tr.getProfessor().getId());
            umAluno[3] = tr.getTitulo();
            umAluno[4] = tr.getDescricao();
            dadosTreinos[posicao++] = umAluno;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosTreinos, camposTreino);
        return modelo;
    }

    public static DefaultTableModel modeloDadosTreinosTodos(String[] camposTreino) {
        List<Treino> treinos = TreinoDAO.selecionarTodos();
        return modeloDadosTreinos(camposTreino, treinos);
    }

    public static DefaultTableModel modeloDadosTreinosPorMatricula(String[] camposTreino, int matricula) {
        List<Treino> treinos = TreinoDAO.selecionarPorMatricula(matricula);
        return modeloDadosTreinos(camposTreino, treinos);
    }

    public static Genero[] getGeneroValues() {
        return Genero.values();
    }

    public static List<Aluno> getListaTodosAlunos() {
        return AlunoDAO.selecionarTodos();
    }

    public static List<Professor> getListaTodosProfessores() {
        return ProfessorDAO.selecionarTodos();
    }

    public static boolean adicionaAluno(String nomeAluno, Date dataNascimentoAluno,
            String generoAlunoString) {
        boolean retorno = false;
        if (!(nomeAluno.isEmpty()) && !generoAlunoString.isEmpty()
                && dataNascimentoAluno != null) {
            Aluno alunoASerAdicionado = new Aluno(nomeAluno, dataNascimentoAluno,
                    Genero.getGenero(generoAlunoString));
            AlunoDAO.inserir(alunoASerAdicionado);
            retorno = true;
        } else {
            Base.mensagemDeErro("Nenhum campo pode ser nulo");
        }
        return retorno;
    }

    public static Aluno retornaAlunoSelecionadoComDataNasc(Object[] dadosAluno) {
        int matricula = (int) dadosAluno[0];
        String nome = (String) dadosAluno[1];
        String generoString = (String) dadosAluno[2];
        Genero genero = Genero.getGenero(generoString);
        Aluno aluno = new Aluno(matricula, nome, genero);
        Date dataNasc = AlunoDAO.selecionarPorId(aluno.getId()).get(0)
                .getDataNascimento();
        aluno.setDataNascimento(dataNasc);
        return aluno;
    }

    public static void alteraAluno(Aluno alunoASerAlterado, String nomeAluno,
            Date dataNascimentoAluno, String generoAlunoString) {
        alunoASerAlterado.setNome(nomeAluno);
        alunoASerAlterado.setDataNascimento(dataNascimentoAluno);
        alunoASerAlterado.setGenero(Genero.getGenero(generoAlunoString));
        AlunoDAO.alterar(alunoASerAlterado);
    }

    public static void removeAluno(Aluno alunoASerRemovido) {
        AlunoDAO.remover(alunoASerRemovido);
    }

    public static boolean adicionaProfessor(String nomeProfessor) {
        boolean retorno = false;
        if (!nomeProfessor.isBlank()) {
            Professor professorASerAdicionado = new Professor(nomeProfessor);
            ProfessorDAO.inserir(professorASerAdicionado);
            retorno = true;
        } else {
            Base.mensagemDeErro("Nenhum campo pode ser nulo");
        }
        return retorno;
    }

    public static Professor retornaProfessorSelecionado(Object[] dadosProfessor) {
        int idProfessor = (int) dadosProfessor[0];
        String nomeProfessor = (String) dadosProfessor[1];

        Professor professor = new Professor(idProfessor, nomeProfessor);

        return professor;
    }

    public static void alteraProfessor(Professor professor, String nome) {
        if (!nome.isEmpty()) {
            professor.setNome(nome);
            ProfessorDAO.alterar(professor);
        } else {
            Base.mensagemDeErro("Nenhum campo pode ser nulo");
        }
    }

    public static void removeProfessor(Professor professor) {
        ProfessorDAO.remover(professor);
    }

    public static boolean adicionaTreino(int matriculaAluno, int idProfessor,
            String titulo, String descricao) {
        boolean retorno = false;
        if (!titulo.isBlank() && !descricao.isBlank()) {
            Aluno aluno = new Aluno(matriculaAluno);
            Professor professor = new Professor(idProfessor);
            Treino treinoASerAdicionado = new Treino(aluno, professor,
                    titulo, descricao);
            TreinoDAO.inserir(treinoASerAdicionado);
            retorno = true;
        } else {
            Base.mensagemDeErro("Nenhum campo pode ser nulo");
        }
        return retorno;
    }

    public static Treino retornaTreinoSelecionado(Object[] dadosTreino) {
        int id = (int) dadosTreino[0];
        int matriculaAluno = (int) dadosTreino[1];
        int idProfessor = (int) dadosTreino[2];
        String titulo = (String) dadosTreino[3];
        String descricao = (String) dadosTreino[4];

        Aluno aluno = new Aluno(matriculaAluno);
        Professor professor = new Professor(idProfessor);
        Treino treino = new Treino(id, aluno, professor, titulo, descricao);

        return treino;
    }

    public static void alteraTreino(Treino treinoASerAlterado,
            int matriculaAluno, int idProfessor, String titulo, String descricao) {
        if (!titulo.isBlank() && !descricao.isBlank()) {
            Aluno aluno = new Aluno(matriculaAluno);
            Professor professor = new Professor(idProfessor);
            treinoASerAlterado.setAluno(aluno);
            treinoASerAlterado.setProfessor(professor);
            treinoASerAlterado.setTitulo(titulo);
            treinoASerAlterado.setDescricao(descricao);
            TreinoDAO.alterar(treinoASerAlterado);
        } else {
            Base.mensagem("Nenhum campo pode ser nulo");
        }
    }
    
    public static void removeTreino(Treino treino) {
         TreinoDAO.remover(treino);
    }
}
