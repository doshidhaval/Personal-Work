/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Enterprise.Enterprise;
import Business.Enterprise.FDA;
import Business.Enterprise.Hospital;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.StateRegulator;
import Business.Enterprise.WholesalerEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Roles.BusinessAdminRole;
import Business.Roles.EnterpriseAdminRole;
import Business.Roles.InventoryManagerRole;
import Business.Roles.LicensingRole;
import Business.Roles.NetworkAdminRole;
import Business.Roles.ProductManagerRole;
import Business.Roles.SalesManagerRole;
import Business.Roles.ShippmentManagerRole;
import java.util.Date;
/**
 *
 * @author Dhaval
 */
public class ConfigureBusiness {
    static ManufacturerEnterprise manufacturerIndia;
    static WholesalerEnterprise wholesalerIndia;
    static FDA fdaIndia;
    static ManufacturerEnterprise manufacturerUS;
    static WholesalerEnterprise wholesalerUS;
    static FDA fdaUS;
    static Network IndiaNetwork;
    static Network USNetwork;
    static Organization org;
    static StateRegulator stateRegulator;
    static Hospital hospital;
    static Business b = Business.getInstance();

 public static Business initialize()
    {

        addBusinessAdmin();
        addIndiaNetwork();
        addUSNetwork();
        addEnterpriseManufacturerIndia();
        addEnterpriseWholesalerIndia();
        addEnterpriseManufacturerUS();
        addEnterpriseWholesalerUS();
        addManufacturerInventoryManager();
        addManufacturerSalesManager();
        addManufacturerShippmentManager();
        addProductManager();
        addWholesalerInventoryManager();
        addWholesalerSalesManager();
        addWholesalerShippmentManager();
        addProduct();
        addFDA();
        addFDALicensingManager();
        addStateRegulator();
        addStateRegulatorLicensingManager();
        addHospital();
        addHospitalInventoryManager();
        return b;
    }
    public static void addBusinessAdmin()
    {
        Employee e = Business.getInstance().getEd().newEmployee();
        Person p = Business.getInstance().getPersonDirectory().newPerson();
        p.setfName("Dhaval");
        p.setlName("Doshi");
        e.setPerson(p);

        UserAccount ua = Business.getInstance().getUad().newUserAccount();
        ua.setPassword("admin");
        ua.setUserName("admin");
        ua.setRole(new BusinessAdminRole());
        ua.setE(e);
    }
    public static void addIndiaNetwork()
    {
        IndiaNetwork = b.getNetworkDirectory().newNetwork();
        IndiaNetwork.setNetworkCountry("India");
        IndiaNetwork.setNetworkName("India Network");
        Employee e = IndiaNetwork.getEd().newEmployee();
        Person p = IndiaNetwork.getPersonDirectory().newPerson();
        p.setfName("Karan");
        p.setlName("Somani");
        e.setPerson(p);

        UserAccount ua = IndiaNetwork.getUad().newUserAccount();
        ua.setUserName("india");
        ua.setPassword("india");
        ua.setRole(new NetworkAdminRole());
        ua.setE(e);

    }


    public static void addUSNetwork()
    {
        USNetwork = b.getNetworkDirectory().newNetwork();
        USNetwork.setNetworkCountry("US");
        USNetwork.setNetworkName("US Network");
        Employee e = USNetwork.getEd().newEmployee();
        Person p = USNetwork.getPersonDirectory().newPerson();
        p.setfName("Mirav");
        p.setlName("Gokani");
        e.setPerson(p);

        UserAccount ua = USNetwork.getUad().newUserAccount();
        ua.setUserName("us");
        ua.setPassword("us");
        ua.setRole(new NetworkAdminRole());
        ua.setE(e);
    }
    public static void addEnterpriseManufacturerIndia()
    {
        License license =new License();
        license.setLicense(Boolean.TRUE);
        manufacturerIndia = (ManufacturerEnterprise)IndiaNetwork.getEnterpriseDirectory().newEnterprise("IPCA",Enterprise.MANUFACTURER);
        manufacturerIndia.setLicense(license);
        Employee e = manufacturerIndia.getEd().newEmployee();
        Person p = manufacturerIndia.getPersonDirectory().newPerson();
        p.setfName("Kailash");
        p.setlName("Doshi");
        e.setPerson(p);

        UserAccount ua = manufacturerIndia.getUad().newUserAccount();
        ua.setPassword("inman");
        ua.setUserName("inman");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }

    public static void addFDA()
    {
        fdaIndia = (FDA)IndiaNetwork.getEnterpriseDirectory().newEnterprise("FDA",Enterprise.FDA);

        Employee e = fdaIndia.getEd().newEmployee();
        Person p = fdaIndia.getPersonDirectory().newPerson();
        p.setfName("Priyank");
        p.setlName("Shah");
        e.setPerson(p);

        UserAccount ua = fdaIndia.getUad().newUserAccount();
        ua.setPassword("fdain");
        ua.setUserName("fdain");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }

    public static void addHospital()
    {
        hospital = (Hospital)IndiaNetwork.getEnterpriseDirectory().newEnterprise("HOSPITAL", Enterprise.HOSPITAL);

        Employee e = hospital.getEd().newEmployee();
        Person p = hospital.getPersonDirectory().newPerson();
        p.setfName("Venus");
        p.setlName("Jain");
        e.setPerson(p);

        UserAccount ua = hospital.getUad().newUserAccount();
        ua.setPassword("hosp");
        ua.setUserName("hosp");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }

    public static void addStateRegulator()
    {
        stateRegulator = (StateRegulator)IndiaNetwork.getEnterpriseDirectory().newEnterprise("StateRegulator",Enterprise.STATEREGULATOR);

        Employee e = stateRegulator.getEd().newEmployee();
        Person p = stateRegulator.getPersonDirectory().newPerson();
        p.setfName("Dhaval");
        p.setlName("Shah");
        e.setPerson(p);

        UserAccount ua = stateRegulator.getUad().newUserAccount();
        ua.setPassword("srin");
        ua.setUserName("srin");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }
    public static void addEnterpriseWholesalerIndia()
    {
        wholesalerIndia = (WholesalerEnterprise)IndiaNetwork.getEnterpriseDirectory().newEnterprise("abc",Enterprise.WHOLESALER);

        Employee e = wholesalerIndia.getEd().newEmployee();
        Person p = wholesalerIndia.getPersonDirectory().newPerson();
        p.setfName("Ruchita");
        p.setlName("Jobanputra");
        e.setPerson(p);

        UserAccount ua = wholesalerIndia.getUad().newUserAccount();
        ua.setPassword("inwho");
        ua.setUserName("inwho");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }

    public static void addEnterpriseManufacturerUS()
    {
        manufacturerUS = (ManufacturerEnterprise)USNetwork.getEnterpriseDirectory().newEnterprise("CIPLA",Enterprise.MANUFACTURER);

        Employee e = manufacturerUS.getEd().newEmployee();
        Person p = manufacturerUS.getPersonDirectory().newPerson();
        p.setfName("Rushabh");
        p.setlName("Shah");
        e.setPerson(p);

        UserAccount ua = manufacturerUS.getUad().newUserAccount();
        ua.setPassword("usman");
        ua.setUserName("usman");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }

    public static void addEnterpriseWholesalerUS()
    {
        wholesalerUS = (WholesalerEnterprise)USNetwork.getEnterpriseDirectory().newEnterprise("NOBELCHEMIST",Enterprise.WHOLESALER);

        Employee e = wholesalerUS.getEd().newEmployee();
        Person p = wholesalerUS.getPersonDirectory().newPerson();
        p.setfName("Bhavik");
        p.setlName("Gandhi");
        e.setPerson(p);

        UserAccount ua = wholesalerUS.getUad().newUserAccount();
        ua.setPassword("uswho");
        ua.setUserName("uswho");
        ua.setRole(new EnterpriseAdminRole());
        ua.setE(e);
    }

    public static void addProduct()
    {
        License license = new License();
        license.setLicense(true);
        license.setIssueDate(new Date());
        Drug d = manufacturerIndia.getDrugCatalog().newDrug();
        d.setBrandName("Dispirin");
        d.setGenericName("para");
        d.setActualPrice(20);
        d.setFloorPrice(10);
        d.setCeilingPrice(30);
        d.setLicense(license);
        InventoryItem i =manufacturerIndia.getInventoryCatalog().newInventoryItem();
        i.setDrug(d);
    }

     public static void addProductManager()
    {
        for(Organization o : manufacturerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.PRODUCTMANAGEMENT))
            {
                org = o;
            }
        }
        Employee e = org.getEd().newEmployee();
        Person p = manufacturerIndia.getPersonDirectory().newPerson();
        p.setfName("Shivani");
        p.setlName("Mody");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("p");
        ua.setUserName("p");
        ua.setRole(new ProductManagerRole());
        ua.setE(e);
    }

     public static void addManufacturerInventoryManager()
    {
        for(Organization o : manufacturerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.INVENTORYMANAGEMENT))
            {
                org = o;
                break;
            }
        }
        Employee e = org.getEd().newEmployee();
        Person p = manufacturerIndia.getPersonDirectory().newPerson();
        p.setfName("kinjal");
        p.setlName("oza");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("i");
        ua.setUserName("i");
        ua.setRole(new InventoryManagerRole());
        ua.setE(e);
    }

     public static void addHospitalInventoryManager()
    {
        for(Organization o : hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.INVENTORYMANAGEMENT))
            {
                org = o;
                break;
            }
        }
        Employee e = org.getEd().newEmployee();
        Person p = hospital.getPersonDirectory().newPerson();
        p.setfName("Chirag");
        p.setlName("Thakkar");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("hospim");
        ua.setUserName("hospim");
        ua.setRole(new InventoryManagerRole());
        ua.setE(e);
    }
     public static void addWholesalerInventoryManager()
    {
        for(Organization o : wholesalerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.INVENTORYMANAGEMENT))
            {
                org = o;
                break;
            }
        }

        Employee e = org.getEd().newEmployee();
        Person p = wholesalerIndia.getPersonDirectory().newPerson();
        p.setfName("kinjal");
        p.setlName("oza");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("wi");
        ua.setUserName("wi");
        ua.setRole(new InventoryManagerRole());
        ua.setE(e);
    }

     public static void addFDALicensingManager()
     {
        for(Organization o : fdaIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.DRUGLICENSING))
            {
                org = o;
            }
        }
        Employee employee = org.getEd().newEmployee();
        Person person = fdaIndia.getPersonDirectory().newPerson();
        person.setfName("Venus");
        person.setlName("Jain");
        employee.setPerson(person);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("lmin");
        ua.setUserName("lmin");
        ua.setRole(new LicensingRole());
        ua.setE(employee);
    }

     public static void addStateRegulatorLicensingManager()
     {
        for(Organization o : stateRegulator.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.DRUGLICENSING))
            {
                org = o;
            }
        }
        Employee employee = org.getEd().newEmployee();
        Person person = stateRegulator.getPersonDirectory().newPerson();
        person.setfName("Vipul");
        person.setlName("Jain");
        employee.setPerson(person);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("slmin");
        ua.setUserName("slmin");
        ua.setRole(new LicensingRole());
        ua.setE(employee);
    }
     public static void addWholesalerSalesManager()
    {
        for(Organization o : wholesalerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.SALESMANAGEMENT))
            {
                org = o;
                break;
            }
        }

        Employee e = org.getEd().newEmployee();
        Person p = wholesalerIndia.getPersonDirectory().newPerson();
        p.setfName("krinal");
        p.setlName("tanna");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("wsales");
        ua.setUserName("wsales");
        ua.setRole(new SalesManagerRole());
        ua.setE(e);
    }
     public static void addWholesalerShippmentManager()
    {
        for(Organization o : wholesalerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.SHIPPMENTMANAGEMENT))
            {
                org = o;
                break;
            }
        }

        Employee e = org.getEd().newEmployee();
        Person p = wholesalerIndia.getPersonDirectory().newPerson();
        p.setfName("nidhi");
        p.setlName("naredi");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("wship");
        ua.setUserName("wship");
        ua.setRole(new ShippmentManagerRole());
        ua.setE(e);
    }

     public static void addManufacturerSalesManager()
    {
        for(Organization o : manufacturerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.SALESMANAGEMENT))
            {
                org = o;
                break;
            }
        }

        Employee e = org.getEd().newEmployee();
        Person p = manufacturerIndia.getPersonDirectory().newPerson();
        p.setfName("krinal");
        p.setlName("tanna");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("sales");
        ua.setUserName("sales");
        ua.setRole(new SalesManagerRole());
        ua.setE(e);
    }
     public static void addManufacturerShippmentManager()
    {
        for(Organization o : manufacturerIndia.getOrganizationDirectory().getOrganizationList())
        {
            if(o.getOrganizationName().equals(Organization.SHIPPMENTMANAGEMENT))
            {
                org = o;
                break;
            }
        }

        Employee e = org.getEd().newEmployee();
        Person p = manufacturerIndia.getPersonDirectory().newPerson();
        p.setfName("nidhi");
        p.setlName("naredi");
        e.setPerson(p);

        UserAccount ua = org.getUad().newUserAccount();
        ua.setPassword("ship");
        ua.setUserName("ship");
        ua.setRole(new ShippmentManagerRole());
        ua.setE(e);
    }

}
