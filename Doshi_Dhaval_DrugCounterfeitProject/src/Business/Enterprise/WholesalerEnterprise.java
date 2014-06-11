/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.InventoryManagementOrganization;
import Business.Organization.Organization;
import Business.Organization.SalesManagementOrganization;
import Business.Organization.ShippmentManagementOrganization;
import Business.Roles.InventoryManagerRole;
import Business.Roles.Roles;
import Business.Roles.SalesManagerRole;
import Business.Roles.ShippmentManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class WholesalerEnterprise extends Enterprise{
InventoryManagementOrganization inventoryManagementOrganization;
SalesManagementOrganization salesManagementOrganization;
ShippmentManagementOrganization shippmentManagementOrganization;


    public WholesalerEnterprise(String name) {
        super(name);

        inventoryManagementOrganization = (InventoryManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.INVENTORYMANAGEMENT);
        salesManagementOrganization = (SalesManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.SALESMANAGEMENT);
        shippmentManagementOrganization = (ShippmentManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.SHIPPMENTMANAGEMENT);
    }


    public InventoryManagementOrganization getInventoryManagementOrganization() {
        return inventoryManagementOrganization;
    }

    public SalesManagementOrganization getSalesManagementOrganization() {
        return salesManagementOrganization;
    }

    public ShippmentManagementOrganization getShippmentManagementOrganization() {
        return shippmentManagementOrganization;
    }

    @Override
    public ArrayList<Roles> getSupportedRoles() {
        roleList.add(new InventoryManagerRole());
        roleList.add(new InventoryManagerRole());
        roleList.add(new SalesManagerRole());
        roleList.add(new ShippmentManagerRole());
        return roleList;
    }

}
