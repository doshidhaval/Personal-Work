/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.Roles;
import java.util.ArrayList;

/**
 *
 * @author Dhaval
 */
public class LawEnforcement extends Enterprise{

    public LawEnforcement(String name) {
        super(name);
    }

    @Override
    public ArrayList<Roles> getSupportedRoles() {
        
        return roleList;
    }

}
