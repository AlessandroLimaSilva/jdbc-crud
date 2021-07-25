package controller;

import dao.DAOAdicionarProduto;
import dao.DAOConsultarProduto;
import model.Produto;

public class ControllerMain {

    public static void main(String[] args) throws Exception {

        Produto pr = new Produto("playstation 5",10,4999.99);
        DAOAdicionarProduto ad = new DAOAdicionarProduto(pr);
        DAOConsultarProduto ct = new DAOConsultarProduto();
        ct.ConsultarTudoId();
    }
}
