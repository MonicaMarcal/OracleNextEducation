package dao;

import model.Reservas;

import java.sql.*;

public class ReservaDao {
    private Connection connection;

    //criando a conexao com o banco
    public  ReservaDao(Connection connection){
        this.connection = connection;
    }
    //metodo
    public void salvar(Reservas reservas) {
        try {
            String sql = "INSERT INTO reservas (dataEntrada, dataSaida, valor, formaPagamento) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setDate(1, (Date) reservas.getDataEntrada());
                pstm.setDate(2, (Date) reservas.getDataSaida());
                pstm.setString(3, reservas.getValor());
                pstm.setString(4, reservas.getFormaPagamento());
                pstm.executeUpdate();
                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        reservas.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
