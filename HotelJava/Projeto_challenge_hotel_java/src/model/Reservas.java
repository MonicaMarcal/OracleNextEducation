package model;

import java.util.Date;

public class Reservas {
    //public static final double VALOR_RESERVA_X_DIA = 150;
    private Integer id;
    private Date dataEntrada;
    private Date dataSaida;
    private String valor;
    private String formaPagamento;

//construtor sem id
    public Reservas(Date dataEntrada, Date dataSaida, String valor, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }
//construtor com id
    public Reservas(Integer id, Date dataEntrada, Date dataSaida, String valor, String formaPagamento) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    //getters
    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public String getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
