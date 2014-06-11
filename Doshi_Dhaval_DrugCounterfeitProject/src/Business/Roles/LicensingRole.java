/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.LicensingManagerWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class LicensingRole extends Roles{

       @Override
    public String toString() {
        return "Licensing Role";
       }

    public LicensingRole() {
        new LicensingManagerWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new LicensingManagerWorkArea();
    }
}
