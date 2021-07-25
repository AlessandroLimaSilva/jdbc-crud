package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;
    private static String link = "jdbc:mysql://localhost:3306/one";
    private static String user = "root";
    private static String password = "ale";

    //O Construtor verifica se existe uma conexão com o banco de dados
    //Se não existir uma, ele fara uma.
    //This constructor verify if exist one connection open on database
    //if not exits, he create a new connection on database
    public ConnectionFactory() throws Exception{
        try{
            if (!isOn()){
                //Carrega o Driver do banco de dados
                //Loads the Driver to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Instancia de uma nova conexão com o banco de dados
                //Instance a new connection on database
                connection = DriverManager.getConnection(link,user,password);
                //Desabilita o modo de auto confirmação da conexão
                //Disables auto commit mode of connection
                connection.setAutoCommit(false);
                //Define o nivel de isolação da transação
                //set the isolation level of transaction
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                System.out.println("Sucesso");
            }

        }catch(ClassNotFoundException e){
            throw new Exception("Driver não encontrado !");
        }catch (SQLException sql){
            throw new Exception("Falha ocorrida: "+sql.getMessage());
        }
    }


    public Connection getConnection(){
        return connection;
    }


    //Este metodo fecha a conexao com o banco de dados
    //Ele verifica se a conexão esta fechada e se não estiver ele tenta fechar a conexão
    //this method checks if connection on database is open,
    // if connection is open it will try to closed connection on database
    //
    public void closeConnection() throws Exception{
        try{
            if (isOn() && !connection.isClosed()) {
                connection.isClosed();
            }
        }catch (SQLException sql){
            throw new Exception("Falha ocorrida: "+sql.getMessage());
        }


    }

    //Este metodo confirma a transação efetuada no banco de dados
    //Este metodo existe pois o autocommit esta setado em falso
    //this method confirm a transaction on database, remember autocommit set is false
    public void confirmTransaction() throws Exception{
        try{
            if (!isOn() || connection.isClosed()){
                return;
            }else{ connection.commit();}

        }catch (SQLException sql){
            throw new Exception("Falha ocorrida: "+sql.getMessage());
        }
    }

    //Este metodo desfaz uma transação
    //this method undoes a transaction
    public void cancelTransaction() throws Exception{
        try{
            if (!isOn() || connection.isClosed()){
                return;
            }else{
                connection.rollback();
            }
        }catch (SQLException sql){
            throw new Exception("Falha ocorrida: "+sql.getMessage());
        }
    }

    //Este Metodo verifica se a copnexao com o banco de dados esta aberta
    //This method verify if connection on database is open
    public boolean isOn() throws Exception {
       try{
           return connection != null && !connection.isClosed();
       }catch (SQLException sql){
           throw new Exception("Falha ocorrida: "+sql.getMessage());
       }
    }
}
