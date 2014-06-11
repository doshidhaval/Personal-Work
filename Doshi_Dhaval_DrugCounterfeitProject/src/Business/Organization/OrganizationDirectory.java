/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class OrganizationDirectory {
private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization newOrganization(String organizationName)
    {
        Organization organization;
        organization = null;
        switch (organizationName)
        {
            case Organization.PRODUCTMANAGEMENT:
                organization = new ProductManagementOrganization();
                break;
            case Organization.INVENTORYMANAGEMENT:
                organization = new InventoryManagementOrganization();
                break;
            case Organization.SALESMANAGEMENT:
                organization = new SalesManagementOrganization();
                break;
            case Organization.SHIPPMENTMANAGEMENT:
                organization = new ShippmentManagementOrganization();
                break;
            case Organization.COUNTERFEITREPORTING:
                organization = new CounterfeitReportingOrganization();
                break;
            case Organization.DRUGLICENSING:
                organization = new DrugLicensingOrganization();
                break;

        }
        if(organization!=null)
        {
            organizationList.add(organization);
        }
        return organization;
    }
    public Organization searchUserOrganization(UserAccount user)
    {
        Organization org = null;
        UserAccount u ;
        mainloop:
        for(Organization o : organizationList)
        {
            org = o;
            u = o.getUad().search(user);
            if(u!=null){break;}
        }
        return org;
    }
}
