package controller;

import dao.AdicionarProduto;
import dao.ConnectionFactory;
import dao.ConsultarTabela;
import model.Produto;

public class ControllerMain {

    public static void main(String[] args) throws Exception {

        Produto pr = new Produto("playstation 5",10,4999.99);
        AdicionarProduto ad = new AdicionarProduto(pr);
        ConsultarTabela ct = new ConsultarTabela();
        ct.ConsultarTudoId();
    }
}
