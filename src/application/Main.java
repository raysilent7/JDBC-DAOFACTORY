package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== Seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("===== Seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("===== Seller findAll =====");
        list = sellerDao.findAll();

        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("===== Seller insert =====");
        /*Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());*/

        System.out.println("===== Seller update =====");
        seller = sellerDao.findById(1);
        seller.setEmail("rios.marta@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update complete");

        System.out.println("===== Seller delete =====");
        sellerDao.deleteById(10);
        System.out.println("Row deleted");
    }
}
