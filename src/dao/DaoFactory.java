package dao;

import dao.impl.SellerDaoJdbc;
import db.DB;

public class DaoFactory {

    public static SellerDao createSellerDao () {
        return new SellerDaoJdbc (DB.openConnection());
    }
}
