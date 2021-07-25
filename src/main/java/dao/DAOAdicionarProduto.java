package dao;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//Esta classe tem por objetivo adicionar um produto no banco de dados
//this class aim to add one product in database

public class DAOAdicionarProduto extends ConnectionFactory{

    //Query que sera passada ao banco de dados
    private static String in = "INSERT INTO produto(nome,quantidade,preco) VALUES(?,?,?)";

    public DAOAdicionarProduto(Produto pr) throws Exception {
        try{
            //Abre a conexão com o banco de dados
            Connection conn = getConnection();
            //Realiza a Interface com o banco de dados Passando a query e recebendo de volta a PK
            PreparedStatement preparedStatement =
                    conn.prepareStatement(in, Statement.RETURN_GENERATED_KEYS);
            //Passa a String nome para a query
            preparedStatement.setString(1,pr.getNome());
            //Passa o int quantidade para a query
            preparedStatement.setInt(2,pr.getQuantidade());
            //Passa o double preco para a query
            preparedStatement.setDouble(3,pr.getQuantidade());
            //Executa a operação no banco de dados
            preparedStatement.executeUpdate();
            //Confirma a operação junto o banco de dados
            confirmTransaction();
            //Recupera a chave PK da operação realiazada no banco de dados
            ResultSet rs = preparedStatement.getGeneratedKeys();
            //Posiciona o cursor para retornar a chave PK da operação
            rs.next();
            System.out.println("Produto Adicionado com sucesso id: "+rs.getInt(1));
            rs.close();
            preparedStatement.close();
            closeConnection();
        }catch (Exception e){
            throw new Exception("Falha ocorrida: "+e.getMessage());
        }
    }
}
