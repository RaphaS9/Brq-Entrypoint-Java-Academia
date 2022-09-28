package br.com.raphsousa.academia.modelo.entidades;

import br.com.raphsousa.academia.enums.Genero;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Aluno extends Pessoa {

    private Date dataNascimento;
    private Genero genero;
    private byte idade;
    private List<Treino> listaTreinos;

    public Aluno(int id, String nome, Date dataNascimento, Genero genero) {
        super(id, nome);
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public Aluno(int id) {
        super(id);
    }

//    construtor sem a data de nascimento para quando for alterar o Aluno na
//    interface grafica eu possa descobrir a data de nascimento pelo id
    public Aluno(int id, String nome, Genero genero) {
        super(id, nome);
        this.genero = genero;
    }

    public Aluno(String nome, Date dataNascimento, Genero genero) {
        super(nome);
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(this.dataNascimento);
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public byte getIdade() {
//        Pego uma instancia da data atual e pego o ano
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
//        crio outra instancia de calendario e set para data de nascimento,
//        entao pego o ano referente
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(getDataNascimento());
        int anoNascimento = dataNasc.get(Calendar.YEAR);
        idade = (byte) (anoAtual - anoNascimento);
        return idade;
    }

    public List<Treino> getListaTreinos() {
        return listaTreinos;
    }

    public void setListaTreinos(List<Treino> listaTreinos) {
        this.listaTreinos = listaTreinos;
    }

}
