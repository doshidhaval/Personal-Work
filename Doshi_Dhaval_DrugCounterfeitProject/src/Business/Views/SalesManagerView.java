/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Views;

import Business.UserAccount;
import UserInterface.SalesManager.SalesManagerJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class SalesManagerView extends Views{
private JPanel userProcessContainer;
    private UserAccount userAccount;
    public SalesManagerView(JPanel userProcessContainer,UserAccount user) {
        this.userAccount = user;
        this.userProcessContainer = userProcessContainer;
    }

    @Override
    public JPanel returnPanel() {
        return new SalesManagerJPanel(userProcessContainer, userAccount);
    }

}
