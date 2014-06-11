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
public class ReportCounterfeitWorkRequest extends WorkRequest{

    private int quantity;
    private Drug drug;

    @Override
    public String toString() {
        return "Report Counterfeit Work Request";
    }

    public ReportCounterfeitWorkRequest() {
        setStatus(status.Ordered);
        setRequestDate(new Date());
        setType(type.ReportCounterfeit);
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
