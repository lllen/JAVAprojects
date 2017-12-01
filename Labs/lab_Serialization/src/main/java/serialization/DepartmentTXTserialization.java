package serialization;

import com.sun.org.apache.regexp.internal.RE;
import department.Department;
import employee.Employee;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentTXTserialization implements Serializing<Department> {

    String DEPARTMENT_NAME = "(departmentName\\=\')([A-z]{2,15}(|\\s[A-z]{2,15})(|\\s[A-z]{2,15}))(\')";

    public Department fromString(List<String> text, Department department) {


        EmployeeTXTserialization employeeTXTserialization=new EmployeeTXTserialization();
        Pattern pattern_departmentName = Pattern.compile(DEPARTMENT_NAME);
        Matcher matcher;

        int n=(text.size()-2)/8;
        Employee[] employee=new Employee[n];
        for(int i=0;i<n;i++){
            employee[i]=new Employee();
        }


        List<Employee> employees = new ArrayList<Employee>();
        String [] strForEmployeeobj=new String[8];

        matcher = pattern_departmentName.matcher(text.get(0).toString());
        if (matcher.matches()) {
            department.setDepartmentName(matcher.group(2));
        }
        int i=2;
        int k=0;
        while(i!=text.size()){
            for(int j=0;j<8;j++) {
                strForEmployeeobj[j]= text.get(i);
                i++;
            }
            employee[k]=employeeTXTserialization.fromString(strForEmployeeobj,employee[k]);
            employees.add(employee[k]);
            k++;

        }
        department.setEmployees(employees);

        return department;
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
        BufferedReader bf = new BufferedReader(file);
        List<String> text = new ArrayList<>();
        int i = 0;
        String line;
        while((line = bf.readLine()) != null) {
            text.add(line);
        }

        Department department=new Department();
        department = fromString(text, department);
        return department;
    }
}
