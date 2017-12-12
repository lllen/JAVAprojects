package databaseService;

import databaseService.DBconnector;
import department.Department;
import employee.Employee;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBdepartmentService {

    DBconnector dBconnector;
    private final String INSERT_NEW_DEPARTMENT="INSERT INTO department VALUES(?,?)";



    public DBdepartmentService(){
         dBconnector=new DBconnector();
    }

    public void addDepartment(Department department,int id) throws SQLException {
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement(INSERT_NEW_DEPARTMENT);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,department.getDepartmentName());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public Department getDepartment(int id) throws SQLException {
        List<Employee> employees=new ArrayList<Employee>();
        Department department=new Department();
        PreparedStatement preparedStatement1=dBconnector.getConnection().prepareStatement("SELECT * FROM department WHERE id_department='"+id+"';");
        PreparedStatement preparedStatement3=dBconnector.getConnection().prepareStatement("SELECT COUNT(*) FROM employee;");

        ResultSet resultSet1=preparedStatement1.executeQuery();
        while(resultSet1.next()){
            department.setDepartmentName(resultSet1.getString(2));
        }
        int N=0;
        ResultSet resultSet3=preparedStatement3.executeQuery();
        while (resultSet3.next()){
            N=resultSet3.getInt(1);
        }

        DBemployeeService dBemployeeService=new DBemployeeService();
        for(int i=0;i<N;i++) {
            employees.add(dBemployeeService.getEmployee(id));
        }
        department.setEmployees(employees);
        preparedStatement1.close();

        return department;
    }

    public void updateDepartment(Department department, int id) throws SQLException {
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement("UPDATE department SET departmentName ='" + department.getDepartmentName() + "'"+
                "WHERE department.id_department=" + id + ";");
                preparedStatement.execute();
        preparedStatement.close();
    }

    public void deleteDepartment(int id) throws SQLException {
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement("DELETE FROM department WHERE department.id_department=" + id +";");
        preparedStatement.execute();
        preparedStatement.close();
    }



    public ArrayList<Employee> getEmployeesBySalary(double salary) throws SQLException {
        ArrayList<Employee> employees=new ArrayList<Employee>();
        PreparedStatement preparedStatement1=dBconnector.getConnection().prepareStatement("SELECT COUNT(*) FROM employee WHERE employee.salary="+salary+";");
        PreparedStatement preparedStatement2=dBconnector.getConnection().prepareStatement("SELECT * FROM employee, department WHERE employee.id_department=department.id_department AND employee.salary=" + salary + ";" );
        ResultSet resultSet1=preparedStatement1.executeQuery();
        int N=0;
        while(resultSet1.next()){
              N=resultSet1.getInt(1);
        }
        Employee[] employee=new Employee[N];
        ResultSet resultSet2=preparedStatement2.executeQuery();
        for(int i =0;i<N;i++){
            employee[i].setFirstName(resultSet2.getString("firstName"));
            employee[i].setSecondName(resultSet2.getString("secondName"));
            employee[i].setSalary(resultSet2.getDouble("salary"));
            employee[i].setPhoneNumber(resultSet2.getString("phoneNumber"));
            employee[i].setEmailAddress(resultSet2.getString("emailAddress"));
            employee[i].setWorkingPosition(resultSet2.getString("workingPosition"));
            employee[i].setFirstDayAtWork(resultSet2.getDate("firstDayAtWork").toLocalDate());
            employee[i].setDateOfBirth(resultSet2.getDate("dateOfBirth").toLocalDate());
            employees.add(employee[i]);
        }
        return employees;
    }


    public void closeConnector() throws SQLException {
        dBconnector.closeConnection();
    }


}
