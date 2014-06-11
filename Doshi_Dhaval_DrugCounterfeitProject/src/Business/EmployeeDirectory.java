/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class EmployeeDirectory {
 ArrayList<Employee> eList;

    public EmployeeDirectory() {
        eList = new ArrayList<>();
    }

    public Employee newEmployee()
    {
        Employee e = new Employee();
        eList.add(e);
        return e;
    }

    public ArrayList<Employee> geteList() {
        return eList;
    }

}
