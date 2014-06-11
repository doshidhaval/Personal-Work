/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkAreas;

import Business.UserAccount;
import Business.Views.Views;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public abstract class WorkArea {
    /**
     *
     * @param userProcessContainer
     * @param business
     * @param user
     * @return
     */
    public abstract Views createView(JPanel userProcessContainer,UserAccount user);

}
