/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Drug;
import Business.Enterprise.Enterprise;
import java.util.Date;

/**
 *
 * @author Dhaval
 */
public class LicenseEnterpriseWorkRequest extends WorkRequest{

    private int quantity;
    private Enterprise enterprise;

    @Override
    public String toString() {
        return enterprise.getEnterpriseName();
    }

    public LicenseEnterpriseWorkRequest() {
        setStatus(status.Ordered);
        setType(type.RequestEnterpriseLicense);
        setRequestDate(new Date());
    }

    public Enterprise getEnterprise()
    {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise)
    {
        this.enterprise = enterprise;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
