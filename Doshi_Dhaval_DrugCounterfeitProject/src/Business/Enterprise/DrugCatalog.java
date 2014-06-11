/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Drug;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class DrugCatalog {
    ArrayList<Drug> drugList;
    

    public DrugCatalog()
    {
        drugList = new ArrayList<>();
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public Drug newDrug ()
    {
        Drug d =new Drug();
        drugList.add(d);
        return d;
    }
    public void deleteDrug(Drug drug)
    {
        drugList.remove(drug);
    }
    public Drug search(int search)
    {
        for(Drug d : drugList)
        {
            if(search == d.getId())
            {
                return d;
            }
        }
        return null;
    }
}
