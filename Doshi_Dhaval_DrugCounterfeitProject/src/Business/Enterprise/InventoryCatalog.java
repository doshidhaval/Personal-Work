/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Drug;
import Business.InventoryItem;
import Business.Order;
import Business.OrderItem;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class InventoryCatalog {
    ArrayList<InventoryItem> inventoryItemList;


    public InventoryCatalog()
    {
        inventoryItemList = new ArrayList<>();
    }
     public InventoryItem findItem (Drug d)
    {
        for(InventoryItem item : inventoryItemList)
        {
            if(d == item.getDrug())
            {
                return item;
            }
        }
        return null;
    }
    public Boolean checkAvailibility(Order order)
    {
        for(InventoryItem item : inventoryItemList)
        {
            for(OrderItem orderItem : order.getOrderList())
            {
                if(item.getDrug()== orderItem.getDrug() &&item.getAvail()<orderItem.getQuantity()){
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<InventoryItem> getInventoryItemList() {
        return inventoryItemList;
    }

    public InventoryItem newInventoryItem ()
    {
        InventoryItem d =new InventoryItem();
        inventoryItemList.add(d);
        return d;
    }
    public void deleteInventoryItem(InventoryItem inventoryItem)
    {
        inventoryItemList.remove(inventoryItem);
    }
    public InventoryItem search(int search)
    {
        for(InventoryItem d : inventoryItemList)
        {
            if(search == d.getId())
            {
                return d;
            }
        }
        return null;
    }
    public InventoryItem search(Drug drug)
    {
        for(InventoryItem d : inventoryItemList)
        {
            if(drug == d.getDrug())
            {
                return d;
            }
        }
        return null;
    }
}
