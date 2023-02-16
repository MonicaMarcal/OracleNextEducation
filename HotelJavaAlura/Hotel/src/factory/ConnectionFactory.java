package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public DataSource dataSource;

    //construtor de conexão que permite que mais usuarios se conectem ao mesmo tempo(ComboPooledDataSource )
    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotelalura?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root"); // usuario mysql
        comboPooledDataSource.setPassword("7M&Jk0131"); //senha mysql

        this.dataSource = comboPooledDataSource;

    }
    public Connection recuperarConexao(){
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
