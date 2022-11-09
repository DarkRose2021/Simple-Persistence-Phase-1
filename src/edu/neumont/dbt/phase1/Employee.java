package edu.neumont.dbt.phase1;

public class Employee  {
    public String id;
    public String firstName;
    public String lastName;
    public String hireYear;

    @Override
    public String toString()
    {
        /* Output 
         * ID: Int
         * F: First Name
         * L: Last Name
         * Year: hireYear
        */
        String output = String.format("ID: %s\nF: %s\nL: %s\nYear: %s", id, firstName, lastName, hireYear);
        return output;
    }
}
