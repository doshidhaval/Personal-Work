/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DrugManager;

import Business.*;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class DrugManagerJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
    UserAccount userAccount;
    ManufacturerEnterprise manufacturer;
    /**
     * Creates new form DrugManagerJPanel
     */
    public DrugManagerJPanel(JPanel userProcessContainer, UserAccount user) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = user;
        manufacturer =(ManufacturerEnterprise) Business.getInstance().getNetworkDirectory().searchUser(user, Enterprise.class.getSimpleName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddJButton = new javax.swing.JButton();
        ManageJButton = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddJButton.setText("Add Drug");
        AddJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddJButtonActionPerformed(evt);
            }
        });
        add(AddJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 139, -1));

        ManageJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ManageJButton.setText("Manage Drug");
        ManageJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageJButtonActionPerformed(evt);
            }
        });
        add(ManageJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("DRUG MANAGER WORK AREA");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void AddJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddJButtonActionPerformed
        // TODO add your handling code here:
        AddDrugsJPanel addDrugsJPanel = new AddDrugsJPanel(userProcessContainer, manufacturer);
        userProcessContainer.add("AddDrugs",addDrugsJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_AddJButtonActionPerformed

    private void ManageJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageJButtonActionPerformed
        // TODO add your handling code here:
        ManageDrugsJPanel manageDrugsJPanel = new ManageDrugsJPanel(userProcessContainer, manufacturer,userAccount);
        userProcessContainer.add("ManageDrugs",manageDrugsJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_ManageJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddJButton;
    private javax.swing.JButton ManageJButton;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
