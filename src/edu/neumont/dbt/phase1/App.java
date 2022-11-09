package edu.neumont.dbt.phase1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        PrintEmployees("C:\\aNeumont\\Year 2\\Q1\\Databases II\\Simple Persistence\\Assignment 1 - data-1\\people\\simple");
    }
    public static void PrintPeopleDetails(String path) {
        File directory = new File(path);
        File[] employeeListing = directory.listFiles();
        if (employeeListing != null)
        {
            for (File employeeFile : employeeListing)
            {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(employeeFile.toString()));
                    String line;
                    while ((line = br.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        // Open folder
        // Foreach File in Folder
            // Open file
            // Print contents
            // Close file
    }

    public static void PrintEmployees(String path) {
        ArrayList<Employee> employees = new ArrayList<>();
        File directory = new File(path);
        File[] employeeListing = directory.listFiles();
        if (employeeListing != null)
        {
            for (File employeeFile : employeeListing)
            {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(employeeFile.toString()));
                    String line;
                    Field[] employeeFields = Employee.class.getFields();
                    while ((line = br.readLine()) != null)
                    {
                        String[] eStrArr = line.split(",");
                        Employee employee = new Employee();
                        for (int i = 0; i < employeeFields.length && i < eStrArr.length; i++)
                        {
                            employeeFields[i].set(employee, eStrArr[i]);
                        }
                        employees.add(employee);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        for (Employee e : employees) {
            System.out.println(e.toString());
            System.out.println("==========================");
        }
        // Open folder
        // Foreach File in Folder
            // Open file
            // Print Employee Object
            // Close file
    }

    public void AddEmployee(String path, int id, String firstName, String lastName, int hireYear) {
        File directory = new File(path);
        File[] employeeListing = directory.listFiles();
    }

    public void DeleteEmployee(String path, int id) {
        File directory = new File(path);
        File[] employeeListing = directory.listFiles();
    }

    public void UpdateEmployee(String path, int id) {
        File directory = new File(path);
        File[] employeeListing = directory.listFiles();
    }

    public void SerializeAllEmployees(String path) {
        File directory = new File(path);
    }

    public void GetSerializeAllEmployees(String path, int id) {
        File directory = new File(path);
    }
}
