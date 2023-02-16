package dao;

import model.Reservas;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ReservaDao {
    private Connection connection;

    //criando a conexao com o banco
    public  ReservaDao(Connection connection){
        this.connection = connection;
    }
    //metodo
    public void salvar(Reservas reserva) {
        try {
            String sql = "INSERT INTO reservas (dataEntrada, dataSaida, valor, formaPagamento) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setDate(1, (Date) reserva.getDataEntrada());
                pstm.setDate(2, (Date) reserva.getDataSaida());
                pstm.setString(3, reserva.getValor());
                pstm.setString(4, reserva.getFormaPagamento());
                pstm.executeUpdate();
                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        reserva.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Reservas> buscar() {
        List<Reservas> reservas = new ArrayList<Reservas>();
        try {
            String sql = "SELECT id, dataEntrada, dataSaida, valor, formaPagamento FROM reservas";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                recuperaReservas(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reservas> buscarId(String id) {
        List<Reservas> reservas = new ArrayList<Reservas>();
        try {

            String sql = "SELECT id, dataEntrada, dataSaida, valor, formaPagamento FROM reservas WHERE id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                recuperaReservas(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void alterar(Date dataEntrada, Date dataSaida, String valor, String formaPagamento, Integer id) {
        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE reservas SET dataEntrada = ?, dataSaida = ?, valor = ?, formaPagamento = ? WHERE id = ?")) {
            stm.setDate(1, dataEntrada);
            stm.setDate(2, dataSaida);
            stm.setString(3, valor);
            stm.setString(4, formaPagamento);
            stm.setInt(5, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer id) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void recuperaReservas(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Reservas reserva = new Reservas(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

                reservas.add(reserva);
            }
        }
    }
}
