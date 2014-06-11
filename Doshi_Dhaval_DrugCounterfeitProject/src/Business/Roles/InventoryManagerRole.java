/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.InventoryManagerWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class InventoryManagerRole extends Roles{

       @Override
    public String toString() {
        return "Inventory Manager Role";
       }

    public InventoryManagerRole() {
        new InventoryManagerWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new InventoryManagerWorkArea();
    }
}
