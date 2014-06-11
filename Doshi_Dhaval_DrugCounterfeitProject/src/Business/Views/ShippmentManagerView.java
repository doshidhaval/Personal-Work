/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Views;

import Business.UserAccount;
import UserInterface.ShippmentManager.ShippmentManagerJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class ShippmentManagerView extends Views{
private JPanel userProcessContainer;
    private UserAccount userAccount;
    public ShippmentManagerView(JPanel userProcessContainer,UserAccount user) {
        this.userAccount = user;
        this.userProcessContainer = userProcessContainer;
    }

    @Override
    public JPanel returnPanel() {
        return new ShippmentManagerJPanel(userProcessContainer, userAccount);
    }

}
