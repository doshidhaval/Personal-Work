/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.License;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.PersonDirectory;
import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public abstract class Enterprise extends Organization{
private String enterpriseName;
private OrganizationDirectory organizationDirectory;
private PersonDirectory personDirectory;
private License license;
InventoryCatalog inventoryCatalog;

public ArrayList<Roles> roleList;
public static final String WHOLESALER = "WHOLESALER";
public static final String MANUFACTURER = "MANUFACTURER";
public static final String RETAILPHARMACY = "RETAILPHARMACY";
public static final String HOSPITAL = "HOSPITAL";
public static final String FDA = "FDA";
public static final String STATEREGULATOR = "STATEREGULATOR";
public static final String LAWENFORCEMENT = "LAWENFORCEMENT";
public static final String NETWORK = "NETWORK";

    @Override
    public String toString() {
        return enterpriseName;
    }

    public Enterprise(String name) {
        super(Organization.ADMIN);
        this.enterpriseName = name;
        organizationDirectory = new OrganizationDirectory();
        personDirectory = new PersonDirectory();
        inventoryCatalog = new InventoryCatalog();
        roleList =  new ArrayList<>();

    }

    public InventoryCatalog getInventoryCatalog() {
        return inventoryCatalog;
    }

    public void setInventoryCatalog(InventoryCatalog inventoryCatalog) {
        this.inventoryCatalog = inventoryCatalog;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public License getLicense()
    {
        return license;
    }

    public void setLicense(License license)
    {
        this.license = license;
    }



    /**
     *
     * @return
     */
    public abstract ArrayList<Roles> getSupportedRoles();
}
