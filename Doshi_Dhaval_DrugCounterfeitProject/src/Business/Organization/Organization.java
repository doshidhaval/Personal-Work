/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.EmployeeDirectory;
import Business.Roles.EnterpriseAdminRole;
import Business.Roles.Roles;
import Business.UserAccountDirectory;
import Business.WorkRequest.WorkQueue;

/**
 *
 * @author Dhaval
 */
public abstract class Organization {
   private String organizationName;
   private EmployeeDirectory ed ;
   private UserAccountDirectory uad;
   Roles role;

   public static final String PRODUCTMANAGEMENT = "PRODUCTMANAGEMENT";
   public static final String INVENTORYMANAGEMENT = "INVENTORYMANAGEMENT";
   public static final String SALESMANAGEMENT = "SALESMANAGEMENT";
   public static final String SHIPPMENTMANAGEMENT = "SHIPPMENTMANAGEMENT";
   public static final String DRUGLICENSING  = "DRUGLICENSING";
   public static final String COUNTERFEITREPORTING = "COUNTERFEITREPORTING";

   public static final String ADMIN = "Admin";
   private WorkQueue workQueue ;


    @Override
    public String toString() {
        return organizationName;
    }

    public Organization(String orgName) {
        organizationName = orgName;
        workQueue = new WorkQueue();
        ed = new EmployeeDirectory();
        uad = new UserAccountDirectory();
        if(organizationName.equals(ADMIN))
        {
            role =  new EnterpriseAdminRole();
        }
    }

    public Roles getRole() {
        return role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public EmployeeDirectory getEd() {
        return ed;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public UserAccountDirectory getUad() {
        return uad;
    }

}
