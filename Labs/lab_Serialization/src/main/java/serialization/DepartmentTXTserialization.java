package serialization;

import com.sun.org.apache.regexp.internal.RE;
import department.Department;
import employee.Employee;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentTXTserialization implements Serializing<Department> {

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
        department.fromString(text);
        return department;
    }
}
