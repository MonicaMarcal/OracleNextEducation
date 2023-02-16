
import factory.ConnectionFactory;

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

    public void salvar(Hospede hospede) {
        this.hospedeDao.salvar(hospede);
    }

    public List<Hospede> listar() {
        return this.hospedeDao.buscar();
    }

    public List<Hospede> listarHospedesId(String id) {
        return this.hospedeDao.buscarId(id);
    }
    public void alterar(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer idReserva, Integer id) {
        this.hospedeDao.alterar(nome, sobrenome, dataNascimento, nacionalidade, telefone, idReserva, id);
    }
}