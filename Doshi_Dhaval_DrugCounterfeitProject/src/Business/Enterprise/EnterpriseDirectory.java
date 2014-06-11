/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> eList;
    public EnterpriseDirectory() {
        eList = new ArrayList<>();
    }

    public Enterprise newEnterprise(String name, String type)
    {
        Enterprise e = null;
        switch (type)
        {

            case Enterprise.MANUFACTURER:
                e = new ManufacturerEnterprise(name);
                break;
            case Enterprise.HOSPITAL:
                e = new Hospital(name);
                break;
            case Enterprise.FDA:
                e = new FDA(name);
                break;
            case Enterprise.LAWENFORCEMENT:
                e = new LawEnforcement(name);
                break;
            case Enterprise.RETAILPHARMACY:
                e =  new RetailPharmacy(name);
                break;
            case Enterprise.STATEREGULATOR:
                e = new StateRegulator(name);
                break;
            case Enterprise.WHOLESALER:
                e = new WholesalerEnterprise(name);
                break;
        }
        if(e!=null)
        {
            eList.add(e);
        }
        return e;
    }

    public ArrayList<Enterprise> geteList() {
        return eList;
    }

    public Enterprise searchUserEnterprise(UserAccount user)
    {
        Enterprise ent = null;
        UserAccount u ;
        mainloop:
        for(Enterprise e : eList)
        {
            ent = e;
            u = e.getUad().search(user);
            for(Organization o : e.getOrganizationDirectory().getOrganizationList())
            {
                if(u!=null){break mainloop;}
                u = o.getUad().search(user);
            }
            if(u!=null){break;}
        }
        return ent;
    }

    public Enterprise searchUserEnterprise(String eName)
    {
        Enterprise ent = null;
        for(Enterprise e : eList)
        {
            if(e.getEnterpriseName().equalsIgnoreCase(eName))
            {
                ent = e;
            }
        }
        return ent;
    }

}
