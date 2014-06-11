/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.InventoryManagementOrganization;
import Business.Organization.Organization;
import Business.PatientDirectory;
import Business.Roles.InventoryManagerRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class Hospital extends Enterprise{
InventoryManagementOrganization inventoryManagementOrganization;
private PatientDirectory patientDirectory;

    public Hospital(String name) {
        super(name);
        patientDirectory = new PatientDirectory();
        inventoryManagementOrganization = inventoryManagementOrganization = (InventoryManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.INVENTORYMANAGEMENT);
    }

    public InventoryManagementOrganization getInventoryManagementOrganization() {
        return inventoryManagementOrganization;
    }

    public void setInventoryManagementOrganization(InventoryManagementOrganization inventoryManagementOrganization) {
        this.inventoryManagementOrganization = inventoryManagementOrganization;
    }

    @Override
    public ArrayList<Roles> getSupportedRoles() {
        roleList.add(new InventoryManagerRole());
        return roleList;
    }

}
