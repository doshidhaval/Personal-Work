/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Roles.Roles;
import Business.WorkRequest.WorkQueue;


/**
 *
 * @author Dhaval
 */
public class UserAccount {
private String userName;
private String password;
Roles role;
private Employee e;
private String status;
private WorkQueue sendWorkQueue ;

public static final String ADMIN = "Admin";
public static final String EMPLOYEE = "Sales Employee";
public static final String SUPPLIER = "Supplier";
public static final String CUSTOMER = "Customer";

public static final String ACTIVE = "Active";
public static final String SUSPENDED = "Suspended";

    @Override
    public String toString() {
        return userName;
    }


    public UserAccount()
    {
        status = ACTIVE;
        sendWorkQueue = new WorkQueue();
    }

    public WorkQueue getSendWorkQueue() {
        return sendWorkQueue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getE() {
        return e;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }


    public void setE(Employee e) {
        this.e = e;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
