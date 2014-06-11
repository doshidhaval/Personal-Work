/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.PatientWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class PatientRole extends Roles{

      @Override
    public String toString() {
        return "Patient Role";
       }
    public PatientRole() {
        new PatientWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new PatientWorkArea();
    }
}
