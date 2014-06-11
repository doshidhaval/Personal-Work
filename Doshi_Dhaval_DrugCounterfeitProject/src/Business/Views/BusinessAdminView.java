/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Views;

import Business.UserAccount;
import UserInterface.BusinessAdmin.BusinessAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class BusinessAdminView extends Views{
private JPanel userProcessContainer;
    private UserAccount userAccount;
    public BusinessAdminView(JPanel userProcessContainer, UserAccount user) {
       this.userAccount = user;
        this.userProcessContainer = userProcessContainer;
    }

    @Override
    public JPanel returnPanel() {
        return new BusinessAdminWorkAreaJPanel( userProcessContainer, userAccount);
    }

}
