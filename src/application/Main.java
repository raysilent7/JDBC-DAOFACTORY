package application;

import entities.Department;
import entities.Seller;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Department dep = new Department(1, "books");
        System.out.println(dep);

        Seller seller = new Seller(1001, "Rayan", "rgc471@hotmail.com", new Date(), 3000.00, dep);
        System.out.println(seller);
    }
}
