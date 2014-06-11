/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Views;

import Business.UserAccount;
import UserInterface.NetworkAdmin.NetworkAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class NetworkAdminView extends Views{
private JPanel userProcessContainer;
    private UserAccount userAccount;
    public NetworkAdminView(JPanel userProcessContainer, UserAccount user) {
        this.userAccount = user;
        this.userProcessContainer = userProcessContainer;

    }

    @Override
    public JPanel returnPanel() {
        return new NetworkAdminWorkAreaJPanel( userProcessContainer, userAccount);
    }

}
