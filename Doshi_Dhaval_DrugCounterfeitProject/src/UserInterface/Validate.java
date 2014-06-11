/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dhaval
 */
public class Validate  {

    public static boolean validateTextField(JTextField field,JLabel label,int i)
    {
        if(field.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(field,"Enter value in "+ label.getText() +" Field" );
            field.requestFocusInWindow();
            return false;
        }
        if(i == 1)
        {
            try
            {
                Integer.parseInt(field.getText());
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(field, "Enter numeric value in "+ label.getText() +" Field" );
                field.setText("");
                field.requestFocusInWindow();
                return false;
            }
        }
        field.nextFocus();
            return true;
    }
}
