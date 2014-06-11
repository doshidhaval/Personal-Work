/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.WorkAreas.ProductManagerWorkArea;
import Business.WorkAreas.VerificationManagerWorkArea;
import Business.WorkAreas.WorkArea;

/**
 *
 * @author Dhaval
 */
public class ProductManagerRole extends Roles{

    @Override
    public String toString() {
        return "Product Manager Role";
    }

    public ProductManagerRole() {
        new ProductManagerWorkArea();
    }
@Override
    public WorkArea getWorkArea() {
        return new ProductManagerWorkArea();
    }
}
