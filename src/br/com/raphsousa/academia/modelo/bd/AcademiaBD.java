package br.com.raphsousa.academia.modelo.bd;

import br.com.raphsousa.academia.Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcademiaBD {

    public static void inicializar() {
        String sql;
        Connection con = conectar();

        sql = "Create database if not exists academia";
        execute(sql, true);
        sql = "Use academia";
        execute(sql, true);
        sql = "Drop table if exists treino";
        execute(sql, true);
        sql = "Drop table if exists aluno";
        execute(sql, true);
        sql = "Drop table if exists professor";
        execute(sql, true);

        sql = "Create table if not exists aluno ("
                + "matricula int not null auto_increment primary key,\n"
                + "nome varchar(50) not null,\n"
                + "dataNasc date not null,\n"
                + "genero varchar(20) not null)";
        execute(sql, true);

        sql = "Create table if not exists professor ("
                + "id int not null auto_increment primary key,\n"
                + "nome varchar(50) not null)";
        execute(sql, true);

        sql = "create table if not exists treino ("
                + "id int not null auto_increment primary key,\n"
                + "matriculaAluno int not null,\n"
                + "idProfessor int not null,\n"
                + "titulo varchar(40) not null,\n"
                + "descricao varchar(250) not null,\n"
                + "foreign key (matriculaAluno) references aluno(matricula),\n"
                + "foreign key (idProfessor) references professor(id))";
        execute(sql, true);
    }

    public static void popular() {
        String sql;
        Connection con = conectar();

//        insers aluno
        sql = "insert into aluno(nome, dataNasc, genero)"
                + " values('Raphael Sousa', '2002/01/09', 'Masculino')";
        execute(sql, true);
        sql = "insert into aluno(nome, dataNasc, genero)"
                + " values('Cid andrade', '2000/01/01', 'Masculino')";
        execute(sql, true);
        sql = "insert into aluno(nome, dataNasc, genero)"
                + " values('Fernanda Montenegro', '1960/10/30', 'Feminino')";
        execute(sql, true);
//        inserts professor
        sql = "insert into professor (nome) values ('Alexandre Mattos')";
        execute(sql, true);
        sql = "insert into professor (nome) values ('Thiago Silva')";
        execute(sql, true);
        sql = "insert into professor (nome) values ('Mateus Andrade')";
        execute(sql, true);
//        inserts treino
        sql = "insert into treino(matriculaAluno, idProfessor, titulo, descricao)"
                + " values(1, 1, 'Peito', "
                + "'Supino, Supino com alteres, Crucifixo')";
        execute(sql, true);
        sql = "insert into treino(matriculaAluno, idProfessor, titulo, descricao)"
                + " values(2, 3, 'Costas', "
                + "'Pulley, Remada, Remada Corda')";
        execute(sql, true);
        sql = "insert into treino(matriculaAluno, idProfessor, titulo, descricao)"
                + " values(3, 2, 'Biceps', "
                + "'Rosca Scott, Rosca barra W, Rosca Martelo')";
        execute(sql, true);
    }

    public static boolean execute(String sql, boolean continuaNoErro) {
        Connection con = conectar();
        boolean retorno = false;
        try {
            con.createStatement().executeUpdate(sql);
            retorno = true;
        } catch (SQLException e) {
            Base.mensagemDeErro("Não pode ser executado " + e.getLocalizedMessage());
            if (!continuaNoErro) {
                System.exit(1);
            }
        }
        desconectar(con);
        return retorno;
    }

    public static Connection conectar() {
        Connection con = null;
        final String USUARIO = "root";
        final String SENHA = "";
        final String URL = "jdbc:mysql://localhost/academia";
        try {
            con = DriverManager.getConnection(URL,
                    USUARIO, SENHA);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.exit(1);
        }
        return con;
    }

    public static void desconectar(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
        }
    }
}
