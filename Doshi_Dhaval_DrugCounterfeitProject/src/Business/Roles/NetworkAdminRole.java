/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.NetworkAdminWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class NetworkAdminRole extends Roles{

      @Override
    public String toString() {
        return "Network Admin Role";
       }
    public NetworkAdminRole() {
       new NetworkAdminWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new NetworkAdminWorkArea();
    }

}
