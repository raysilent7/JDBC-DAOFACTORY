package application;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        List<Department> list = departmentDao.findAll();
        for (Department deps : list) {
            System.out.println(deps);
        }
    }
}
