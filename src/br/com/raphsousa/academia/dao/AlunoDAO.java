package br.com.raphsousa.academia.dao;

import br.com.raphsousa.academia.Base;
import br.com.raphsousa.academia.enums.Genero;
import br.com.raphsousa.academia.modelo.bd.AcademiaBD;
import br.com.raphsousa.academia.modelo.entidades.Aluno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoDAO {

    private static final String INSERIR_SQL
            = "insert into aluno(nome, dataNasc, genero) values"
            + "('%s', '%s', '%s')";
    private static final String ALTERAR_SQL = "Update aluno "
            + "set nome='%s', dataNasc='%s', genero='%s' where matricula=%d";
    private static final String REMOVER_SQL = "delete from aluno "
            + "where matricula=%d";
    private static final String SELECIONAR_TUDO_SQL = "Select * from aluno";
    private static final String SELECIONAR_POR_ID
            = "Select * from aluno where matricula=%d";

    public static void inserir(Aluno aluno) {
        String sql;
        sql = String.format(INSERIR_SQL,
                aluno.getNome(),
                aluno.getDataNascimentoString(),
                aluno.getGenero());
        if (AcademiaBD.execute(sql, true)) {
            Base.mensagem(aluno.getNome() + " inserido com sucesso");
        }
    }

    public static void alterar(Aluno aluno) {
        String sql = String.format(ALTERAR_SQL,
                aluno.getNome(),
                aluno.getDataNascimentoString(),
                aluno.getGenero(),
                aluno.getId());
        AcademiaBD.execute(sql, true);
        if (AcademiaBD.execute(sql, true)) {
            Base.mensagem("Aluno de matricula " +aluno.getId() + 
                    " alterado com sucesso");
        }
    }

    public static void remover(Aluno aluno) {
        String sql = String.format(REMOVER_SQL,
                aluno.getId());
        if (AcademiaBD.execute(sql, true)) {
            Base.mensagem("Aluno de matricula " +aluno.getId() + 
                    " removido com sucesso");
        }
    }

    private static List<Aluno> selecionar(String sql) {
        List<Aluno> lista = new ArrayList<>();
        Connection con = AcademiaBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                Date dataNasc = rs.getDate("dataNasc");
                String genero = rs.getString("genero");
                lista.add(new Aluno(matricula, nome,
                        dataNasc, Genero.getGenero(genero)));
            }
            AcademiaBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }

    public static List<Aluno> selecionarTodos() {
        return selecionar(SELECIONAR_TUDO_SQL);
    }

    public static List<Aluno> selecionarPorId(int matricula) {
        return selecionar(String.format(
                SELECIONAR_POR_ID, matricula));
    }

}
