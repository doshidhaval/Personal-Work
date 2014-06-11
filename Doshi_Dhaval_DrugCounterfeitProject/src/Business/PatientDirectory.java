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
public class PatientDirectory {
 ArrayList<Patient> pList;

    public PatientDirectory() {
        pList = new ArrayList<>();
    }

    public Patient newPatient()
    {
        Patient p = new Patient();
        pList.add(p);
        return p;
    }

    public ArrayList<Patient> getpList() {
        return pList;
    }

}
