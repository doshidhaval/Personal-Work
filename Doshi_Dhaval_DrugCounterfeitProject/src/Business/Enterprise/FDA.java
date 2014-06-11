/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.DrugLicensingOrganization;
import Business.Organization.Organization;
import Business.Roles.LicensingRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class FDA extends Enterprise{
DrugLicensingOrganization licensingOrganization;
    public FDA(String name) {
        super(name);
        licensingOrganization = (DrugLicensingOrganization)getOrganizationDirectory().newOrganization(Organization.DRUGLICENSING);
    }

    public DrugLicensingOrganization getLicensingOrganization() {
        return licensingOrganization;
    }

    public void setLicensingOrganization(DrugLicensingOrganization licensingOrganization) {
        this.licensingOrganization = licensingOrganization;
    }
    


    @Override
    public ArrayList<Roles> getSupportedRoles() {
        roleList.add (new LicensingRole());
        return roleList;
    }

}
