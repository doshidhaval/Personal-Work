/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class VerificationManagerRole extends Roles{

       @Override
    public String toString() {
        return "Verification Role";
       }

    public VerificationManagerRole() {
        new VerificationManagerWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new VerificationManagerWorkArea();
    }
}
