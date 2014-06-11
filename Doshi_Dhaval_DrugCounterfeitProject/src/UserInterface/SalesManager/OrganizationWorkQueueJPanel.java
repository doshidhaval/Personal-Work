/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BusinessAdminWorkAreaJPanel.java
 *
 * Created on Nov 2, 2012, 5:59:07 PM
 */
package UserInterface.SalesManager;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Order;
import Business.Organization.Organization;
import Business.UserAccount;
import Business.WorkRequest.*;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhaval
 */
public class OrganizationWorkQueueJPanel extends javax.swing.JPanel {

    //private Enterprise enterprise;
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;

    /** Creates new form BusinessAdminWorkAreaJPanel */
    public OrganizationWorkQueueJPanel(JPanel upc,  UserAccount ua) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        refreshWorkRequestTable();
    }
    private void refreshWorkRequestTable()
    {
        int r = jTable1.getRowCount();
        DefaultTableModel m = (DefaultTableModel)jTable1.getModel();

        for(int  i = r-1;i>=0;i--)
        {
            m.removeRow(i);
        }
        Organization o = (Organization) Business.getInstance().getNetworkDirectory().searchUser(userAccount, Organization.class.getSimpleName());
        for(WorkRequest w : o.getWorkQueue().getQueue())
        {
            Order order = (Order)w;
            Object row[] = new Object[4];
            row[0]= order;
            row[1]= w.getSender();
            row[2]= w.getReceiver();
            row[3]= w.getStatus().toString();

            m.addRow(row);
        }

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnMyQueue = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnWorkOnIt = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sales Manager Organization Queue");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 440, -1));

        btnMyQueue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMyQueue.setText("Add to my Work Queue");
        btnMyQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyQueueActionPerformed(evt);
            }
        });
        add(btnMyQueue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 230, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order No.", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 570, 95));

        btnWorkOnIt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnWorkOnIt.setText("Work on it");
        btnWorkOnIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkOnItActionPerformed(evt);
            }
        });
        add(btnWorkOnIt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 230, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyQueueActionPerformed
        // TODO add your handling code here:
        int r = jTable1.getSelectedRow();
        if(r<0)
        {
            return;
        }
        Order req = (Order)jTable1.getValueAt(r, 0);
        req.setReceiver(userAccount);
        req.setStatus(WorkRequest.status.ProcessingSalesApproval);
        refreshWorkRequestTable();
        JOptionPane.showMessageDialog(null, "Added to my queue");
    }//GEN-LAST:event_btnMyQueueActionPerformed

    private void btnWorkOnItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkOnItActionPerformed
        // TODO add your handling code here:
        int r = jTable1.getSelectedRow();
        if(r<0)
        {
            return;
        }
        Order req = (Order)jTable1.getValueAt(r, 0);
        if(req.getReceiver()== userAccount )
        {
            JPanel panel = new WorkOnRequestJPanel(userProcessContainer, (Order)req, userAccount);
            userProcessContainer.add("WorkOnRequestJPanel", panel);
            CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnWorkOnItActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnMyQueue;
    private javax.swing.JButton btnWorkOnIt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
