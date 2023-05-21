/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NoTaxProduct;
import Model.Product;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ManagementProduct {
    
    ArrayList<Product> productList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void inputProductList() {
//        for (int i = 0; i < 5; i++) {
//            Product sp = new Product();
//            sp.nhap();
//            productList.add(sp);
//        }

        for (int i = 0; i < 3; i++) {
            if (i != 0) {
                Product sp = new Product();
                sp.nhap();
                productList.add(sp);
            } else {
                NoTaxProduct sp = new NoTaxProduct();
                sp.nhap();
                productList.add(sp);
            }
        }
    }
    
    public void outputProductList() {
        for (Product item : productList) {
            item.show();
//            item.insert();
//            item.update();
//            item.select();
//            item.delete();
        }
    }
    
    public void test() {
        Product product1 = new Product("San pham co thue 1", 129.999);
        productList.add(product1);
        Product product2 = new Product("San pham co thue 1", 129.999);
        productList.add(product2);
        NoTaxProduct noTaxItem = new NoTaxProduct("San pham van hoa", (double) 3000);
        productList.add(noTaxItem);
        
    }
    
    public int findByName(String name) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (name.equalsIgnoreCase(productList.get(i).getName())) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public void insert() {
        System.out.println("Ban da chon chuc nang them moi cho danh sach san pham");
        while (true) {
            System.out.print("Nhap vao ten san pham: ");
            String name = sc.nextLine();
            System.out.print("\nNhap vao gia san pham: ");
            Double price = Double.parseDouble(sc.nextLine());
            while (true) {
                System.out.print("\nDay la loai san pham nao?\nThue => Nhap (1)\nKhong thue => (2)\n");
                String type = sc.nextLine();
                if (type.equalsIgnoreCase("1")) {
                    Product item = new Product(name, price);
                    productList.add(item);
                    System.out.println("San pham da duoc tao thanh cong");
                    break;
                } else if (type.equalsIgnoreCase("2")) {
                    Product item = new NoTaxProduct(name, price);
                    productList.add(item);
                    System.out.println("San pham da duoc tao thanh cong");
                    break;
                } else {
                    System.out.println("Khong hop le, vui long nhap lai!!!");
                }
            }
            System.out.print("Ban co muon them nua khong?(y/n): ");
            String nextInput = sc.nextLine();
            if (nextInput.equalsIgnoreCase("n")) {
                System.out.println("Da hoan thanh chuc nang them moi");
                break;
            }
        }
    }
    
    public void delete() {
        System.out.println("Ban da chon chuc nang xoa phan tu duoc chon trong danh sach san pham");
        while (true) {
            System.out.print("Nhap vao ten san pham ban muon xoa: ");
            String deleteName = sc.nextLine();
            boolean isInclude = false;
            
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equalsIgnoreCase(deleteName)) {
                    isInclude = true;
                    System.out.printf("Ban co that su muon xoa san pham co ten (%s) khong?\n(y/n): ", deleteName);
                    String choosen = sc.nextLine();
                    if (choosen.equalsIgnoreCase("y")) {
                        productList.remove(i);
                        System.out.println("Xoa san pham thanh cong");
                    }
                    break;
                }
            }
            
            if (isInclude == false) {
                System.out.println("Khong tim thay san pham nao co ten nhu vay");
            }
            System.out.print("Ban co muon tiep tuc xoa (y/n): ");
            String choosen = sc.nextLine();
            if (choosen.equalsIgnoreCase("n")) {
                System.out.println("Chuc nang xoa da ket thuc");
                break;
            }
        }
    }
    
    public void update() {
        System.out.println("Ban da chon chuc nang cap nhat phan tu duoc chon trong danh sach san pham");
        while (true) {
            System.out.print("Nhap vao ten san pham ban muon cap nhat: ");
            String updateName = sc.nextLine();
            boolean isInclude = false;
            
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equalsIgnoreCase(updateName)) {
                    isInclude = true;
                    System.out.print("Nhap vao ten moi: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhap vao gia moi: ");
                    Double newPrice = Double.parseDouble(sc.nextLine());
                    productList.get(i).setName(newName);
                    productList.get(i).setPrice(newPrice);
                    System.out.println("Cap nhat thanh cong");
                    break;
                }
            }
            
            if (isInclude == false) {
                System.out.println("Khong tim thay san pham nao co ten nhu vay");
            }
            System.out.print("Ban co muon tiep tuc cap nhat (y/n): ");
            String choosen = sc.nextLine();
            if (choosen.equalsIgnoreCase("n")) {
                System.out.println("Chuc nang cap nhat da ket thuc");
                break;
            }
        }
    }
    
    public void menu() {
        int stop = 1;
        do {
            System.out.println("\n\n___________Lab 1 - Java 2___________");
            System.out.println("1, Tao 5 san pham khong thue nhap vao tu ban phim va xuat ra man hinh");
            System.out.println("2, Tao 3 san pham trong do 1 san pham khong thue");
            System.out.println("3, Hien thi danh sach san pham");
            System.out.println("4, Chinh sua thong tin tung san pham trong danh sach san pham");
            System.out.println("5, Them moi san pham");
            System.out.println("6, Xoa san pham theo ten duoc nhap tu ban phim");
            System.out.println("7, Tim index theo ten");
            
            System.out.println("0, Thoat");
            System.out.println("_________________________________________");
            System.out.print("Hay chon mot chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    inputProductList();
                    outputProductList();
                    System.out.println("5 san pham nay se duoc xoa de phuc vu cho tien ich phan II");
                    for (int i = 0; i < productList.size(); i++) {
                        productList.removeAll(productList);
                    }
                }
                case 2 ->
                    test();
                case 3 ->
                    outputProductList();
                case 4 ->
                    update();
                case 5 ->
                    insert();
                case 6 ->
                    delete();
                case 7 -> {
                    System.out.println("Nhap vao ten muon tim index: ");
                    String name = sc.nextLine();
                    System.out.printf("index cua san pham do la: %d", findByName(name));
                }
                case 0 -> {
                    System.out.println("Ban da chon thoat khoi chuong trinh");
                    stop = 0;
                }
                default -> {
                    System.out.println("Ban da chon khong hop le vui long chi chon tu 0-5");
                }
            }
            
        } while (stop != 0);
    }
    
}
