/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Drug;
import Business.Order;
import java.util.Date;

/**
 *
 * @author Dhaval
 */
public class ShipWorkRequest extends WorkRequest{

    private int shipOrderNumber;
    private Order order;
    private int quantity;
    private Drug drug;

    @Override
    public String toString() {
        return "Ship Work Request";
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public ShipWorkRequest() {
        setStatus(status.ShippingRequested);
        setRequestDate(new Date());
        setType(type.ShipWorkRequest);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getShipOrderNumber() {
        return shipOrderNumber;
    }

    public void setShipOrderNumber(int shipOrderNumber) {
        this.shipOrderNumber = shipOrderNumber;
    }


}
