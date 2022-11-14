package edu.neumont.dbt.phase1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    //Phase 1
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

    //Phase 2
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
        try
        {
            File directory = new File(path);
            File[] employeeListing = directory.listFiles();

            Employee e = null;
            for (File file : employeeListing) {
                BufferedReader br = new BufferedReader(new FileReader(file.toString()));
                String line;
                Field[] employeeFields = Employee.class.getFields();
                while ((line = br.readLine()) != null)
                {
                    String[] eStrArr = line.split(",");
                    e = new Employee();
                    for (int i = 0; i < employeeFields.length && i < eStrArr.length; i++)
                    {
                        employeeFields[i].set(e, eStrArr[i]);
                    }
                }
                FileOutputStream fOut = new FileOutputStream(file.getName() + ".ser");
                ObjectOutputStream objOut = new ObjectOutputStream(fOut);
                
                objOut.writeObject(e);
    
                objOut.close();
                fOut.close();
            }


        }catch(Exception e)
        {

        }
        
    }

    public static Employee GetSerializedEmployee(String path, int id) {
        try
        {
            File directory = new File(path);
            File[] employeeListing = directory.listFiles();

            Employee e = null;
            for (File file : employeeListing) {
                if (file.getName() == Integer.toString(id))
                {
                    FileInputStream fIn = new FileInputStream(file);
                    ObjectInputStream objIn = new ObjectInputStream(fIn);

                    e = (Employee) objIn.readObject();

                    return e;
                }
            }


        }catch(Exception e)
        {

        }
        return null;
    }

    //Phase 3
    public static Employee FindEmployeeById(String path, int id) {
        Employee e = null;

        return e;
    }

    public static Employee FindEmployeeByLastName(String path, String lastName) {
        Employee e = null;

        return e;
    }

    public static List<Employee> FindAllEmployeesByLastName(String path, String lastName) {
        List<Employee> e = null;

        return e;
    }

    public static void PrintSerializedDetails(String path){

    }

    public static HashMap<Integer, Employee> GetAllEmployees(String path){
        HashMap<Integer, Employee> e = null;

        return e;
    }

    public static void PrintAllEmployees(String path) {
        
    }
}
