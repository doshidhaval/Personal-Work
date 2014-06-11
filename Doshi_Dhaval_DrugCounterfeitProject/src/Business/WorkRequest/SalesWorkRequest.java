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
public class SalesWorkRequest extends WorkRequest{

    private int salesOrderNumber;
    private int quantity;
    private Drug drug;


    @Override
    public String toString() {
        return "Sales Work Request";

    }


    public SalesWorkRequest() {
        setStatus(status.Ordered);
        setRequestDate(new Date());
        setType(type.SalesRequest);
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }


    public int getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(int salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
