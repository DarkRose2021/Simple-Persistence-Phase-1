package edu.neumont.dbt.phase1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // PrintEmployees("C:\\aNeumont\\Year 2\\Q1\\Databases II\\Simple Persistence\\Assignment 1 - data-1\\people\\long");
        // try {
        //     AddEmployee("C:\\aNeumont\\Year 2\\Q1\\Databases II\\Simple Persistence\\Assignment 1 - data-1\\people\\long", 10001, "first", "last", 1995);
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        //}
        // DeleteEmployee("C:\\aNeumont\\Year 2\\Q1\\Databases II\\Simple Persistence\\Assignment 1 - data-1\\people\\long", 23);
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

    public static void AddEmployee(String path, int id, String firstName, String lastName, int hireYear) throws IOException {
        File directory = new File(path);
        directory.mkdir();
        String hash = String.valueOf(id);
        String fileName = hash+ ".txt";
        File newEmployee;
        newEmployee = new File(directory, fileName);
        newEmployee.createNewFile();

        PrintWriter writer = new PrintWriter(newEmployee, "UTF-8");
        writer.print(id+", "+firstName+", "+lastName+", "+hireYear);
        writer.close();
    }
    
    public static void DeleteEmployee(String path, int id) {
        File file = new File(path, id+".txt");
        if(file.delete()){
            System.out.println(file.getName()+ " deleted");
        }else{
            System.out.println("File not found");
        }
    }

    public static void UpdateEmployee(String path, int id, String firstName, String lastName, String hireDate) throws IOException {
        File file = new File(path, id+".txt");
        if(file.exists() && !file.isDirectory()) { 
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.print(id+", "+firstName+", "+lastName+", "+hireDate);
            writer.close();
        }
    }

    public static void SerializeAllEmployees(String path) {
        File directory = new File(path);
    }

    public static void GetSerializeAllEmployees(String path, int id) {
        File directory = new File(path);
    }
}
