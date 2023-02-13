package model;

import java.time.LocalDate;

public class Hospedes {
    private int id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String telefone;
    private int reserva_id;

    //construtores
    public Hospedes(int id, String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade, String telefone, int reserva_id) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.reserva_id = reserva_id;
    }

    public Hospedes(String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
    }

    public Hospedes(String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade, String telefone, int reserva_id) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.reserva_id = reserva_id;
    }


    //getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getReserva_id() {
        return reserva_id;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }
}
