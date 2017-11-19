package serialization;

import com.thoughtworks.xstream.XStream;
import department.Department;
import employee.Employee;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class DepartmentXMLserialization implements Serializing<Department>{

    @Override
    public void serializingObj(Department department, Writer file) throws IOException {
        XStream xs = new XStream();
        xs.toXML(department,file);
    }

    @Override
    public Department deserializingObj(Reader file) throws IOException, JAXBException {
        XStream xs = new XStream();
        Department department = new Department();
        xs.fromXML(file, department);
        return department;
    }




}
