package dao;

import model.Reservas;
import java.sql.*;
import java.sql.Date;


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
}
