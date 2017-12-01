package department;

import com.fasterxml.jackson.annotation.JsonIgnore;
import employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentService {

    public void sortEmployees(Department department){
        List<Employee> sortedList=department.getEmployees().stream().sorted().collect(Collectors.toList());
        department.setEmployees(sortedList);
    }

    public List<Employee> getEmployeesBySalary(double salary,Department department){
        List<Employee> empl=new ArrayList<>();
        empl=department.getEmployees().stream().filter((p)-> p.getSalary()==salary).collect(Collectors.toList());
        return empl;
    }

    public double getAverageSalary(Department department){
         return department.getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

    }

    @JsonIgnore
    public double getAverageAge(Department department){
        return department.getEmployees().stream().mapToDouble(Employee::getAge).average().getAsDouble();
    }

}
