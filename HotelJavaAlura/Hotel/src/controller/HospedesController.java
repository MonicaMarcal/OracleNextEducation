package controller;

import dao.HospedeDao;
import factory.ConnectionFactory;
import model.Hospedes;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class HospedesController {
    private HospedeDao hospedeDao;

    public HospedesController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.hospedeDao = new HospedeDao(connection);
    }

    public void deletar(Integer id) {
        this.hospedeDao.deletar(id);
    }

    public void salvar(Hospedes hospedes) {
        this.hospedeDao.salvar(hospedes);
    }

    public List<Hospedes> listar() {
        return this.hospedeDao.buscar();
    }

    public List<Hospedes> listarHospedesId(String id) {
        return this.hospedeDao.buscarId(id);
    }
    public void alterar(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer reserva_id, Integer id) {
        this.hospedeDao.alterar(nome, sobrenome, dataNascimento, nacionalidade, telefone, reserva_id, id);
    }
}