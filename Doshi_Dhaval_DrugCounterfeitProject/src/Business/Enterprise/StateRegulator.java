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
public class StateRegulator extends Enterprise{
    DrugLicensingOrganization LicensingOrganization;
     public StateRegulator(String name)
     {
        super(name);
        LicensingOrganization = (DrugLicensingOrganization)getOrganizationDirectory().newOrganization(Organization.DRUGLICENSING);
     }

    public DrugLicensingOrganization getLicensingOrganization() {
        return LicensingOrganization;
    }

    public void setLicensingOrganization(DrugLicensingOrganization LicensingOrganization) {
        this.LicensingOrganization = LicensingOrganization;
    }

    @Override
    public ArrayList<Roles> getSupportedRoles()
    {
        roleList.add(new LicensingRole());
        return roleList;
    }

}
