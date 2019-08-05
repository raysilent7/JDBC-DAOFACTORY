package application;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;

public class Main {

    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        Department department = departmentDao.findById(5);
        department.setName("Games");
        departmentDao.update(department);
        System.out.println("Updated row");
    }
}
