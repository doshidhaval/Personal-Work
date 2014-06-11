/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.CounterfeitReportingManagerWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class CounterfeitReportingRole extends Roles{

       @Override
    public String toString() {
        return "Counterfeit Reporting Role";
       }

    public CounterfeitReportingRole() {
        new CounterfeitReportingManagerWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new CounterfeitReportingManagerWorkArea();
    }
}
