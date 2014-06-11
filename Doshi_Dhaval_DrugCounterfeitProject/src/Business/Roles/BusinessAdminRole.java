/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.BusinessAdminWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class BusinessAdminRole extends Roles{

      @Override
    public String toString() {
        return "Business Admin Role";
       }
    public BusinessAdminRole() {
        new BusinessAdminWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new BusinessAdminWorkArea();
    }
}
