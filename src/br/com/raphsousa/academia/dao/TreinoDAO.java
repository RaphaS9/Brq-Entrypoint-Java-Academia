package br.com.raphsousa.academia.dao;

import br.com.raphsousa.academia.Base;
import br.com.raphsousa.academia.modelo.bd.AcademiaBD;
import br.com.raphsousa.academia.modelo.entidades.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {
    private static final String INSERIR_SQL = 
            "insert into treino(matriculaAluno, idProfessor, titulo, descricao)"
            + " values(%d, %d, '%s', '%s')";
    private static final String ALTERAR_SQL = "Update treino "
            + "set matriculaAluno=%d, idProfessor=%d, titulo='%s',"
            + " descricao='%s' where id=%d";
    private static final String REMOVER_SQL = "delete from treino "
            + "where id=%d";
    private static final String SELECIONAR_TUDO_SQL = "Select * from treino";
    private static final String SELECIONAR_POR_ID =
            "Select * from treino where id=%d";
    private static final String SELECIONAR_POR_MATRICULA =
            "Select * from treino where matriculaAluno=%d";
    
    
    public static void inserir(Treino treino) {
        String sql;
        String desc = treino.getDescricao();
        sql = String.format(INSERIR_SQL,
                treino.getAluno().getId(),
                treino.getProfessor().getId(),
                treino.getTitulo(),
                treino.getDescricao()
        );
        if (AcademiaBD.execute(sql, true)) {
            Base.mensagem("Inserido com sucesso");
        }
    }

    public static void alterar(Treino treino) {
        String sql;
        sql = String.format(ALTERAR_SQL,
                treino.getAluno().getId(),
                treino.getProfessor().getId(),
                treino.getTitulo(),
                treino.getDescricao(),
                treino.getId()
        );
        if (AcademiaBD.execute(sql, true)) {
            Base.mensagem("Alterado com sucesso");
        }
    }

    public static void remover(Treino treino) {
        String sql = String.format(REMOVER_SQL,
                treino.getId());
        if (AcademiaBD.execute(sql, true)) {
            Base.mensagem("Removido com sucesso");
        }
    }

    private static List<Treino> selecionar(String sql) {
        List<Treino> lista = new ArrayList<>();
        Connection con = AcademiaBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int matriculaAluno = rs.getInt("matriculaAluno");
                int idProfessor = rs.getInt("idProfessor");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                lista.add(new Treino(id, 
                        AlunoDAO.selecionarPorId(matriculaAluno).get(0), 
                        ProfessorDAO.selecionarPorId(idProfessor).get(0),
                        titulo, descricao));
            }
            AcademiaBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }


    public static List<Treino> selecionarTodos() {
        return selecionar(SELECIONAR_TUDO_SQL);
    }

    public static List<Treino> selecionarPorId(int id) {
        return selecionar(String.format(
                SELECIONAR_POR_ID, id));
    }
    
    public static List<Treino> selecionarPorMatricula(int matricula) {
        return selecionar(String.format(
                SELECIONAR_POR_MATRICULA, matricula));
    }
    
}

