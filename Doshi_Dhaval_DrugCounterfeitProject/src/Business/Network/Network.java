/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Roles.NetworkAdminRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class Network extends Enterprise
{
    private String networkName;
    private String networkCountry;

private EnterpriseDirectory enterpriseDirectory;


    public Network()
    {
        super(Enterprise.ADMIN);
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkCountry() {
        return networkCountry;
    }

    public void setNetworkCountry(String networkCountry) {
        this.networkCountry = networkCountry;
    }

    @Override
    public String toString() {
        return networkName;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    @Override
    public ArrayList<Roles> getSupportedRoles() {
        roleList.add(new NetworkAdminRole());
        return roleList;
    }
}
