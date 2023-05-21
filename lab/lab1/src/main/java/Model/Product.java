/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DAO;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Product implements DAO {

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getImportTax() {
        return this.price * 0.1;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", tax=" + getImportTax() + '}';
    }

    public void show() {
        System.out.println(this);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten san pham: ");
        name = sc.nextLine();
        System.out.print("Nhap gia san pham: ");
        price = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void insert() {
        System.out.println("Them moi thanh cong");
    }

    @Override
    public void update() {
        System.out.println("Cap nhat thanh cong");
    }

    @Override
    public void delete() {
        System.out.println("Xoa thanh cong");
    }

    @Override
    public void select() {
        System.out.println("Chon thanh cong");
    }

}
