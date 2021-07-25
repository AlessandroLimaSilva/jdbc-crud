package controller;

import dao.DAOAdicionarProduto;
import dao.DAOConsultarProduto;
import model.Produto;

public class ControllerMain {

    public static void main(String[] args) throws Exception {

        Produto pr1 = new Produto("playstation 5",10,4999.99);
        Produto pr2 = new Produto("playstation 4",123,1999.99);
        Produto pr3 = new Produto("playstation 3",102,999.99);
        Produto pr4 = new Produto("playstation 2",120,599.99);
        Produto pr5 = new Produto("playstation 1",140,299.99);
        new DAOAdicionarProduto(pr1);
        new DAOAdicionarProduto(pr2);
        new DAOAdicionarProduto(pr3);
        new DAOAdicionarProduto(pr4);
        new DAOAdicionarProduto(pr5);
        DAOConsultarProduto ct = new DAOConsultarProduto();
        ct.ConsultarTudoId();
        System.out.println("Consultar preço maior que R$1000.00");
        ct.ConsultarPreco(1000.00);
    }
}
