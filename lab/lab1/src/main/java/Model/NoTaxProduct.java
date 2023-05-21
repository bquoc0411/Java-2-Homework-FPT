/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DAO;

/**
 *
 * @author Admin
 */
public class NoTaxProduct extends Product implements DAO {

    public NoTaxProduct() {
    }

    public NoTaxProduct(String name, Double price) {
        super(name, price);
    }

    @Override
    public Double getImportTax() {
        return 0.0;
    }

    @Override
    public void insert() {
        System.out.println("Day la insert tu No Tax");
    }
}
