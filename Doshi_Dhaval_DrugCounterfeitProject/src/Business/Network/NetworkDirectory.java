/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class NetworkDirectory {
    private ArrayList<Network> networkList;


    public NetworkDirectory() {
        networkList = new ArrayList<>();
    }

    public Network newNetwork()
    {
        Network n = new Network();
        networkList.add(n);
        return n;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

public Object searchUser(UserAccount user, String returnType)
    {
        Network network = null;
        Enterprise enterprise = null;
        Organization organization = null;
        UserAccount u ;

        mainloop:
        for(Network n : networkList)
        {
            u = n.getUad().search(user);
            network = n;
            if(u!=null) {
                break;
            }
        for(Enterprise e : n.getEnterpriseDirectory().geteList())
        {
            enterprise = e;
            u = e.getUad().search(user);
            if(u!=null){break mainloop;}

            for(Organization o : e.getOrganizationDirectory().getOrganizationList())
            {
                organization =o;
                u = o.getUad().search(user);
                if(u!=null){break mainloop;}
            }
        }
    }
        switch (returnType)
        {
            case "Network":
                return network;
            case "Enterprise":
                return enterprise;
            case "Organization":
                return organization;
            default:
                return null;

        }

    }


    public Network searchUserNetwork(String eName)
    {
        Network ent = null;
        for(Network e : networkList)
        {
            if(e.getNetworkName().equalsIgnoreCase(eName))
            {
                ent = e;
            }
        }
        return ent;
    }

}
