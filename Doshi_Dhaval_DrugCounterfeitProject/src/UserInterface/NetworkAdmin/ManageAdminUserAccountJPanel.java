/*
 * ManageNetworkJPanel.java
 *
 * Created on September 24, 2008, 2:40 PM
 */
package UserInterface.NetworkAdmin;

import Business.Business;
import Business.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dhaval
 */
public class ManageAdminUserAccountJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount userAccount;
    Network network;

    /** Creates new form ManageNetworkJPanel */
    public ManageAdminUserAccountJPanel(JPanel userProcessContainer,UserAccount user) {
        initComponents();
        this.userProcessContainer =userProcessContainer;
        this.userAccount = user;
        network = (Network)Business.getInstance().getNetworkDirectory().searchUser(user, Network.class.getSimpleName());
        Refresh();
    }
        private void Refresh()
        {
        int rowCount = tableUserAccount.getRowCount();
        for(int i = rowCount-1; i >= 0; i--)
        {
            ((DefaultTableModel)tableUserAccount.getModel()).removeRow(i);
        }

        for (Enterprise enterprise : network.getEnterpriseDirectory().geteList())
        {

            Object row [] = new Object[3];
            row[0]=enterprise;
            if(!enterprise.getEd().geteList().isEmpty())
            {
                row[1]= enterprise.getEd().geteList().get(0);
            }
            if(!enterprise.getUad().getuList().isEmpty())
            {
                row[2] = enterprise.getUad().getuList().get(0).getUserName();
            }
            ((DefaultTableModel)tableUserAccount.getModel()).addRow(row);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUserAccount = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Manage Admin User Account");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        tableUserAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Admin name", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUserAccount);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 500, 90));

        btnView.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnView.setText("View User Account >>");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 240, -1));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("Add User Account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 110, -1));

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 120, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableUserAccount.getSelectedRow();
        if(selectedRow < 0 || selectedRow > tableUserAccount.getRowCount() )
        {
        JOptionPane.showMessageDialog(null,"Select a Row");
            return;}
        Enterprise enterprise = (Enterprise)tableUserAccount.getValueAt(selectedRow, 0);
        ViewUserAccountJPanel vuajp = new ViewUserAccountJPanel(userProcessContainer ,enterprise);
        userProcessContainer.add("View user account",vuajp);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int selectedRow = tableUserAccount.getSelectedRow();
        if(selectedRow < 0 || selectedRow > tableUserAccount.getRowCount() )
        {
        JOptionPane.showMessageDialog(null,"Select a Row");
            return;}
        Enterprise enterprise = (Enterprise)tableUserAccount.getValueAt(selectedRow, 0);
        Employee employee = (Employee)tableUserAccount.getValueAt(selectedRow, 1);
        AddUserAccountJPanel auajp  = new AddUserAccountJPanel(userProcessContainer,enterprise,employee);
        userProcessContainer.add("Add user account",auajp);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        Refresh();
}//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tableUserAccount;
    // End of variables declaration//GEN-END:variables
}