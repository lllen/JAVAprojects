package department;

import com.fasterxml.jackson.annotation.JsonIgnore;
import employee.Employee;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Department implements Serializable {
    private String departmentName;
    private ArrayList<Employee> employees;
    private static final String DEPARTMENT_NAME_PATTERN ="^[A-z]{2,15}($|\\s[A-z]{2,15})($|\\s[A-z]{2,15}$)"; // three words allowed


    public static DepartmentBuilder newDepartmentBuilder(){
        return new Department().new DepartmentBuilder();
    }
    //BUILDER inner class
    public class DepartmentBuilder{
        public DepartmentBuilder setEmployees(ArrayList<Employee>employees){
            Department.this.employees=employees;
            return this;
        }
        public DepartmentBuilder setDepartmentName(String departmentName)throws RuntimeException{
            if (checkDepartmentName(departmentName)){
                Department.this.departmentName=departmentName;
                return this;
            }
            throw new RuntimeException("Incorrect Department name !");
        }
        public String getDepartmentName(){
            return departmentName;
        }

        public ArrayList<Employee> getEmployees(){
            return Department.this.employees;
        }

        public Department build(){
            return Department.this;
        }
    }
    // end of BUILDER

    //SET
    public void setDepartmentName(String departmentName) throws RuntimeException{
        if(checkDepartmentName(departmentName)) {
            this.departmentName = departmentName;
        }
        else throw new RuntimeException("Incorrect department name !");
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    //GET
    public String getDepartmentName() {
        return departmentName;
    }

    @JsonIgnore
    public Integer getNumberOfWorkers() {
        return employees.size();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void sortEmployees(){
        Collections.sort(employees);
        //return employees;
    }

    /*
    * Method getEmployeeBySalary returns list of employees whose salary
    * equals to parameter salary
    * */
    @JsonIgnore
    public ArrayList<Employee> getEmployeesBySalary(double salary){
        ArrayList<Employee> empl=new ArrayList<Employee>();
        for(int i=0; i<employees.size();i++) {
            if(   this.employees.get(i).getSalary()==salary)
                empl.add(this.employees.get(i));
        }
        return empl;
    }

    @JsonIgnore
    public double getAverageSalary(){
        double averageSalary=0;
        for(int i=0; i<employees.size();i++) {
            averageSalary+=this.employees.get(i).getSalary();
        }
        return averageSalary/this.employees.size();
    }

    public boolean checkDepartmentName(String departmentName){
        Pattern pattern=Pattern.compile(DEPARTMENT_NAME_PATTERN);
        Matcher matcher=pattern.matcher(departmentName);
        if(matcher.matches())
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, employees);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
