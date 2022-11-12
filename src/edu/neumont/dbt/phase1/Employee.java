package edu.neumont.dbt.phase1;

import java.io.Serializable;

public class Employee implements Serializable{
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
