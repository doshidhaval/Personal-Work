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
public class ReceiveShippmentWorkRequest extends WorkRequest{

    private int shipOrderNumber;
    private int quantity;
    private Drug drug;
    private ShipWorkRequest shipWorkRequest;

    @Override
    public String toString() {
        return "Receive Shippment Work Request";
    }


    public ReceiveShippmentWorkRequest() {
        setStatus(status.Shipped);
        setType(type.ReceiveShippmentRequest);
        setRequestDate(new Date());
    }

    public int getShipOrderNumber() {
        return shipOrderNumber;
    }

    public void setShipOrderNumber(int shipOrderNumber) {
        this.shipOrderNumber = shipOrderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }



    public ShipWorkRequest getShipWorkRequest() {
        return shipWorkRequest;
    }

    public void setShipWorkRequest(ShipWorkRequest shipWorkRequest) {
        this.shipWorkRequest = shipWorkRequest;
    }





}
