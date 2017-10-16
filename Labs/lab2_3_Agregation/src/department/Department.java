package department;

import employee.Employee;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    Department (DepartmentBuilder departmentBuilder){
        this.departmentName=departmentBuilder.getDepartmentName();
        this.employees=departmentBuilder.getEmployees();
    }

    //BUILDER
    public static  class DepartmentBuilder{
        private String departmentName;
        private ArrayList<Employee> employees;

        public DepartmentBuilder setEmployees(ArrayList<Employee>employees){
            this.employees=employees;
            return this;
        }
        public DepartmentBuilder setDepartmentName(String departmentName)throws RuntimeException{
            if (checkDepartmentName(departmentName)){
                this.departmentName=departmentName;
                return this;
            }
            throw new RuntimeException("Incorrect Department name !");
        }
        public String getDepartmentName(){
            return departmentName;
        }

        public ArrayList<Employee> getEmployees(){
            return this.employees;
        }

        public boolean checkDepartmentName(String departmentName){
            Pattern pattern=Pattern.compile("(^[A-Z]{1}[a-z]{2,15})($|\\s[A-z]{2,15}$)");
            Matcher matcher=pattern.matcher(departmentName);
            if(matcher.matches())
                return true;
            return false;
        }
        public Department build(){
            return new Department(this);
        }
    }
    // end of BUILDER

    //SET
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    //GET
    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getNumberOfWorkers() {
        return employees.size();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Employee> getSortedEmployees(){
        Collections.sort(employees);
        return employees;
    }

    /*
    * Method getEmployeeBySalary returns list of employees whose salary
    * equals to parameter salary
    * */
    public ArrayList<Employee> getEmployeesBySalary(double salary){
        ArrayList<Employee> empl=new ArrayList<Employee>();
        for(int i=0; i<employees.size();i++) {
         if(   this.employees.get(i).getSalary()==salary)
             empl.add(this.employees.get(i));
        }
        return empl;
    }

    public double getAverageSalary(){
        double averageSalary=0;
        for(int i=0; i<employees.size();i++) {
            averageSalary+=this.employees.get(i).getSalary();
        }
        return averageSalary/this.employees.size();
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
}
