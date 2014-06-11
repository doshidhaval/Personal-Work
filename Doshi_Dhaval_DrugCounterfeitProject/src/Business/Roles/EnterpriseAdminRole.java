/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.EnterpriseAdminWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class EnterpriseAdminRole extends Roles{

       @Override
    public String toString() {
        return "Enterprise Admin Role";
       }

    public EnterpriseAdminRole() {
        new EnterpriseAdminWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new EnterpriseAdminWorkArea();
    }
}
