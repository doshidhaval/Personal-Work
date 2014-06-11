/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Dhaval
 */
public class Drug {

    private String brandName;
    private int id;
    private String genericName;
    private int floorPrice;
    private int actualPrice;
    private int ceilingPrice;
    private License license;

    private static int  count =0;

    @Override
    public String toString() {
        return brandName;
    }
    
    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Drug()
    {
        count ++;
        id = count;
    }
    public String getBrandName() {
        return brandName;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Drug.count = count;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(int floorPrice) {
        this.floorPrice = floorPrice;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(int ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }



}
