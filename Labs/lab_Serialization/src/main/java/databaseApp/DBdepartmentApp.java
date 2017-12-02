package databaseApp;

import department.Department;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBdepartmentApp {

    private final String INSERT_NEW_DEPARTMENT="INSERT INTO department VALUES(?)";

    public DBconnector Connect(){
        DBconnector dBconnector=new DBconnector();
        return  dBconnector;
    }

    public void addDepartment(Department department) throws SQLException {
        PreparedStatement preparedStatement=this.Connect().getConnection().prepareStatement(INSERT_NEW_DEPARTMENT);
    }
}
