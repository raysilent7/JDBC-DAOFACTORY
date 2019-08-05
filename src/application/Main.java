package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn;
        PreparedStatement pst = null;

        try {
            conn = DB.openConnection();

            pst = conn.prepareStatement("INSERT INTO seller "
            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
            + "VALUES "
            + "(?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, "Lívia Flores");
            pst.setString(2, "livia.fofinha@hotmail.com");
            pst.setDate(3, new java.sql.Date(sdf.parse("03/03/1994").getTime()));
            pst.setDouble(4, 5000.00);
            pst.setInt(5, 3);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Update done! Row = " + id);
                }
            }
            else {

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(pst);
            DB.closeConnection();
        }
    }
}
