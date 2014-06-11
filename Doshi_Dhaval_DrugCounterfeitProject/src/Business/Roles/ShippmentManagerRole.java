/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.ShippmentManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class ShippmentManagerRole extends Roles{

       @Override
    public String toString() {
        return "Supplier Manager Role";
       }

    public ShippmentManagerRole() {
       new ShippmentManagerWorkArea();
    }

    @Override
    public WorkArea getWorkArea() {
        return new ShippmentManagerWorkArea();
    }

}
