/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Views;

import Business.UserAccount;
import UserInterface.PatientRole.PatientWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class PatientView extends Views{
private JPanel userProcessContainer;
    private UserAccount userAccount;
    public PatientView(JPanel userProcessContainer, UserAccount user) {
       this.userAccount = user;
        this.userProcessContainer = userProcessContainer;
    }

    @Override
    public JPanel returnPanel() {
        return new PatientWorkAreaJPanel(userProcessContainer, userAccount);
    }

}
