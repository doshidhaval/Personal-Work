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
public class PersonDirectory {
 ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public Person newPerson()
    {
        Person p = new Person();
        personList.add(p);
        return p;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

}
