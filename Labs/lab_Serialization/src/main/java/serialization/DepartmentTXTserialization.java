package serialization;

import department.Department;
import employee.Employee;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;

public class DepartmentTXTserialization implements Serializing<Department> {


    public static void main(String [] args) throws IOException {
        Employee empl1 = Employee.newEmployeeBuilder()
                .setFirstName("Agjf")
                .setSecondName("Jonat")
                .setSalary(5589.0)
                .build();

        Employee empl2 = Employee.newEmployeeBuilder()
                .setSecondName("Drad")
                .build();

        Employee empl3 = Employee.newEmployeeBuilder()
                .setSecondName("Luis")
                .build();

        Employee empl4 = Employee.newEmployeeBuilder()
                .setSecondName("Jordan")
                .build();

        Employee empl5 = Employee.newEmployeeBuilder()
                .setSecondName("Kolas")
                .build();

        Employee empl6 = Employee.newEmployeeBuilder()
                .setSecondName("Molpan")
                .build();

        ArrayList<Employee> employeesArray1 = new ArrayList<Employee>();
        employeesArray1.add(empl1);
        employeesArray1.add(empl2);
        employeesArray1.add(empl3);
        employeesArray1.add(empl4);
        employeesArray1.add(empl5);
        employeesArray1.add(empl6);

        Department department=Department.newDepartmentBuilder()
                .setEmployees(employeesArray1)
                .build();

        Writer file=new FileWriter("department.txt");
        DepartmentTXTserialization o=new DepartmentTXTserialization();
        o.serializingObj(department,file);
    }


    @Override
    public void serializingObj(Department department,Writer file){
        try{
            file.write(department.toString());
            file.flush();
            file.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Input error");
            System.exit(2);
        }
    }

    @Override
    public Department deserializingObj(Reader file) throws IOException, JAXBException {
        return null;
    }
}
