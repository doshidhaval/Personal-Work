/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class WorkQueue {
private ArrayList <WorkRequest> queue;


    public WorkQueue()
    {
        queue = new ArrayList<>();
    }
    public ArrayList<WorkRequest> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<WorkRequest> queue) {
        this.queue = queue;
    }

public WorkRequest newWorkRequest(WorkRequest.type type)
{
    WorkRequest request = null;
    if(type == WorkRequest.type.ReceiveShippmentRequest)
    {
        request = new ReceiveShippmentWorkRequest();
        queue.add(request);

    }
    else if(type == WorkRequest.type.SalesRequest)
    {
        request = new SalesWorkRequest();
        queue.add(request);
    }
    else if(type == WorkRequest.type.ShipWorkRequest)
    {
        request = new ShipWorkRequest();
        queue.add(request);
    }
    else if(type == WorkRequest.type.RequestDrugLicense)
    {
        request = new LicenseDrugWorkRequest();
        queue.add(request);
    }
    else if(type == WorkRequest.type.RequestEnterpriseLicense)
    {
        request = new LicenseEnterpriseWorkRequest();
        queue.add(request);
    }

    return request;
}
public void addWorkRequest (WorkRequest request)
{
    queue.add(request);
}
}
