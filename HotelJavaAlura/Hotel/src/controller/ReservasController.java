package controller;

import dao.ReservaDao;
import factory.ConnectionFactory;
import model.Reservas;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class ReservasController {
    private ReservaDao reservaDao;

    //construtor para pegar a conexão
    public ReservasController(){
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDao = new ReservaDao(connection);
    }
    //metodo para salvar
    public void salvar(Reservas reservas){
        this.reservaDao.salvar(reservas);
    }
    public List<Reservas> buscar() {
        return this.reservaDao.buscar();
    }

    public List<Reservas> buscarId(String id) {
        return this.reservaDao.buscarId(id);
    }

    public void atualizar(Date dataEntrada, Date dataSaida, String valor, String formaPagamento, Integer id) {
        this.reservaDao.alterar(dataEntrada, dataSaida, valor, formaPagamento, id);
    }

    public void deletar(Integer id) {
        this.reservaDao.deletar(id);
    }
}
