package Business.WorkRequest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Business.UserAccount;
import java.util.Date;

/**
 *
 * @author Dhaval
 */
public abstract class WorkRequest {
    public static enum status{
        Ordered {@Override public String toString(){return "Ordered";}},
        ProcessingSalesApproval {@Override public String toString(){return "Processing Sales Approval";}},
        ShippingRequested {@Override public String toString(){return "ShippingRequested";}},
        ProcessingShipment {@Override public String toString(){return "ProcessingShipment";}},
        Shipped {@Override public String toString(){return "Shipped";}},
        InTransit {@Override public String toString(){return "In Transit";}},
        GrantedLicense{@Override public String toString() {return "License Granted";}},
        ProcessingLicense{@Override public String toString() {return "Processing License";}},
        RequestedLicense{@Override public String toString() {return "Requested License";}},
        Delivered {@Override public String toString(){return "Delivered";}};


    }
    public static enum type{
        SalesRequest {@Override public String toString(){return "SalesRequest";}},
        ShipWorkRequest {@Override public String toString(){return "ShipWorkRequest";}},
        RequestDrugLicense{@Override public String toString(){return "Request Drug License";}},
        RequestEnterpriseLicense{@Override public String toString(){return "Request Enterprise License";}},
        ReportCounterfeit{@Override public String toString(){return "Report Counterfeit";}},
        ReceiveShippmentRequest {@Override public String toString(){return "ReceiveShippmentRequest";}}

    }


    private String requestDetail;
    private UserAccount sender,receiver;
    //private HashMap <String,Date> date ;
    private Date requestDate, resloveDate;
    private WorkRequest.status status;
    private WorkRequest.type type;

    public WorkRequest()
    {
        requestDate = new Date();
        //date = new HashMap<>();
        //date.put(status.Ordered.toString(),new Date());
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }

    public String getRequestDetail() {
        return requestDetail;
    }

    public void setRequestDetail(String requestDetail) {
        this.requestDetail = requestDetail;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResloveDate() {
        return resloveDate;
    }

    public void setResloveDate(Date resloveDate) {
        this.resloveDate = resloveDate;
    }




}
