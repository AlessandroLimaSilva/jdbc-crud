package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarTabela extends ConnectionFactory{

    private final String tudoId = "SELECT * FROM produto ORDER BY id";

    public ConsultarTabela() throws Exception {
    }

    public void ConsultarTudoId() throws SQLException {
        Connection conn = getConnection();
        Statement stm = conn.createStatement();
    }
}
