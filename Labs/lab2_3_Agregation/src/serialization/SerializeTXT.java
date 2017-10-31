package serialization;

import employee.Employee;

import java.io.*;
import java.time.LocalDate;

public class SerializeTXT {

    public void serialization(String fileName){

    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
        Employee employee1 = Employee.newEmployeeBuilder()
                .setFirstName("Albert")
                .setSecondName("Folt")
                .setDateOfBirth(LocalDate.of(1998, 05, 10))
                .setSalary(8750)
                .build();
        System.out.println("ob1 : " + employee1);

        objectOutputStream.writeObject(employee1);
    } catch (IOException e) {
        System.out.println("Exception during serialization : " + e);
    }

    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
        Employee ob2 = (Employee) objectInputStream.readObject();
        System.out.println("ob2 : " + ob2);
    } catch (Exception e) {
        System.out.println("Exception during deserialization : " + e);
        System.exit(0);
    }
}
}
