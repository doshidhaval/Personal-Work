/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Dhaval
 */
public class InventoryItem {

    private Drug drug;
    private int id;
    private Date manufactureDate;
    private Date expiryDate;
    private int plantID;
    private int batchID;
    private int avail;


    private static int  count =0;

    @Override
    public String toString() {
        return drug.getBrandName();
    }

    public InventoryItem()
    {
        count ++;
        id = count;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        InventoryItem.count = count;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail += avail;
    }

    public int getPlantID() {
        return plantID;
    }

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


}
