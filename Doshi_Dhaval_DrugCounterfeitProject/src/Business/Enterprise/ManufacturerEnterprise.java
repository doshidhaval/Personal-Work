/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.CounterfeitReportingOrganization;
import Business.Organization.InventoryManagementOrganization;
import Business.Organization.Organization;
import Business.Organization.ProductManagementOrganization;
import Business.Organization.SalesManagementOrganization;
import Business.Organization.ShippmentManagementOrganization;
import Business.Roles.InventoryManagerRole;
import Business.Roles.ProductManagerRole;
import Business.Roles.Roles;
import Business.Roles.SalesManagerRole;
import Business.Roles.ShippmentManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class ManufacturerEnterprise extends Enterprise{
ProductManagementOrganization productManagementOrganization;
SalesManagementOrganization salesManagementOrganization;
ShippmentManagementOrganization shippmentManagementOrganization;
InventoryManagementOrganization inventoryManagementOrganization;
CounterfeitReportingOrganization counterfeitReportingOrganization;
DrugCatalog drugCatalog ;



    public ManufacturerEnterprise(String name) {
        super(name);

        inventoryManagementOrganization = (InventoryManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.INVENTORYMANAGEMENT);
        productManagementOrganization = (ProductManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.PRODUCTMANAGEMENT);
        salesManagementOrganization = (SalesManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.SALESMANAGEMENT);
        shippmentManagementOrganization = (ShippmentManagementOrganization)super.getOrganizationDirectory().newOrganization(Organization.SHIPPMENTMANAGEMENT);
        counterfeitReportingOrganization = (CounterfeitReportingOrganization)super.getOrganizationDirectory().newOrganization(Organization.COUNTERFEITREPORTING);
        drugCatalog = new DrugCatalog();

    }

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public InventoryManagementOrganization getInventoryManagementOrganization() {
        return inventoryManagementOrganization;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }

    public ProductManagementOrganization getProductManagementOrganization() {
        return productManagementOrganization;
    }

    public SalesManagementOrganization getSalesManagementOrganization() {
        return salesManagementOrganization;
    }

    public ShippmentManagementOrganization getShippmentManagementOrganization() {
        return shippmentManagementOrganization;
    }


    @Override
    public ArrayList<Roles> getSupportedRoles() {
        roleList.add(new ProductManagerRole());
        roleList.add(new InventoryManagerRole());
        roleList.add(new SalesManagerRole());
        roleList.add(new ShippmentManagerRole());
        return roleList;
    }
}
