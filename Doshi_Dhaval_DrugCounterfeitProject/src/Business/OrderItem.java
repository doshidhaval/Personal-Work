/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Dhaval
 */
public class OrderItem {
    private Drug drug;
    private int quantity;
    private int price ;

    @Override
    public String toString() {
        return drug.getBrandName();
    }

    public OrderItem()
    {
        drug = new Drug();
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
        this.quantity += quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
