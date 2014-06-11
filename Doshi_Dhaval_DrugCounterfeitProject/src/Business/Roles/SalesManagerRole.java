/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.SalesManagerWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class SalesManagerRole extends Roles{

       @Override
    public String toString() {
        return "Sales Manager Role";
       }

    public SalesManagerRole() {
        new SalesManagerWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new SalesManagerWorkArea();
    }
}
