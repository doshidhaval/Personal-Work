/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Drug;
import java.util.Date;

/**
 *
 * @author Dhaval
 */
public class LicenseDrugWorkRequest extends WorkRequest{

    private int quantity;
    private Drug drug;

    @Override
    public String toString() {
        return drug.getBrandName();
    }

    public LicenseDrugWorkRequest() {
        setStatus(status.Ordered);
        setType(type.RequestDrugLicense);
        setRequestDate(new Date());
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
