/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.WorkRequest.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class Order extends WorkRequest{
    private int orderNumber;
    private String dateOfPurchase;

    private ArrayList <OrderItem> orderList;
    private static int count=0;

    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
    public Order()
    {
        count++;
        orderNumber= count;
        orderList = new ArrayList<>();
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public ArrayList<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<OrderItem> orderList) {
        this.orderList = orderList;
    }

    public OrderItem newOrderItem(){
        OrderItem item = new OrderItem();
        orderList.add(item);
        return item;
    }

 public OrderItem checkDrug(Drug drug)
    {
        for(OrderItem orderItem: orderList)
        {
            if(orderItem.getDrug() == drug)
            {
                return orderItem;
            }
        }
        return null;
    }
 public int getTotalQuantity()
    {
        int sum=0;
        for (OrderItem orderItem : orderList)
        {
               sum+=(orderItem.getQuantity()*orderItem.getPrice());
        }
        return sum;
   }
}
