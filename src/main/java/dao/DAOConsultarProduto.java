package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOConsultarTabela extends ConnectionFactory{

    private final String tudoId = "SELECT * FROM produto ORDER BY id";

    public DAOConsultarTabela() throws Exception {
    }

    public void ConsultarTudoId() throws SQLException {
        Connection conn = getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(tudoId);
        while (rs.next()){
            System.out.println("Id: "+rs.getInt(1)+" Nome: "+rs.getString(2)
                    +" Quantidade: "+rs.getInt(3)+" Preço R$"+rs.getDouble(4));
        }
        rs.close();
        stm.close();
    }
}
