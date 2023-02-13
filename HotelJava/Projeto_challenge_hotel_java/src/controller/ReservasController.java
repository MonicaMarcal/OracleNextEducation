package controller;

import dao.ReservaDao;
import factory.ConnectionFactory;
import model.Reservas;
import java.sql.Connection;

public class ReservasController {
    private ReservaDao reservaDao;

    //construtor para pegar a conexão
    public ReservasController(){
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDao = new ReservaDao(connection);
    }

    //metodo para salvar
    public void salvar(Reservas reserva){
        this.reservaDao.salvar(reserva);
    }
}