/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.Roles.BusinessAdminRole;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class Business extends Network{
public static enum type{
        Enterprise {@Override public String toString(){return "Enterprise";}},
        Network {@Override public String toString(){return "Network";}},
        Organization {@Override public String toString(){return "Organization";}}
    }

private NetworkDirectory networkDirectory;
private static Business business;
int orderCount;
int drugCount;

    private Business()
    {
        networkDirectory = new NetworkDirectory();
    }
    public static Business getInstance()
    {

        if(business == null)
        {
            business = new Business();

        }
        Db4o.Db4oUtil.storeObject(business);
        business = (Business)Db4o.Db4oUtil.getBusiness();
        return business;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }
    @Override
    public ArrayList<Roles> getSupportedRoles() {
        roleList.add(new BusinessAdminRole());
        return roleList;
    }
    public void getStaticVariables()
    {
        orderCount = Order.getCount();
        drugCount = Drug.getCount();

    }
    public void setStaticVariables()
    {
        Order.setCount(orderCount);
        Drug.setCount(drugCount);
    }
}
