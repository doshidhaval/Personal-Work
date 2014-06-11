/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NetworkAdmin;

import Business.Address;
import Business.Employee;
import Business.Enterprise.Enterprise;
import Business.Person;
import Business.UserAccount;
import UserInterface.Validate;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class AddAdminJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
Enterprise enterprise;
Employee employee;
UserAccount ua;
    /**
     * Creates new form AddAdminJPanel
     */
    public AddAdminJPanel(JPanel userProcessContainer,UserAccount ua, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ua = ua;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnAddUserAccount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtAge = new javax.swing.JTextField();
        lblSSN = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtSSN = new javax.swing.JTextField();
        lblEMailId = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtNationality = new javax.swing.JTextField();
        lblContactNumber = new javax.swing.JLabel();
        lblQualification = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        lblDateOfBirth = new javax.swing.JLabel();
        txtQualification = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblLine1 = new javax.swing.JLabel();
        lblLine2 = new javax.swing.JLabel();
        lblZip = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        txtLine1 = new javax.swing.JTextField();
        txtLine2 = new javax.swing.JTextField();
        txtZip = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Add Admin ");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 19, 161, 30));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("Add Admin");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 464, 160, -1));

        btnAddUserAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddUserAccount.setText("Add Admin User Account");
        btnAddUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserAccountActionPerformed(evt);
            }
        });
        add(btnAddUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 464, -1, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 513, 117, -1));

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 208, 220, -1));

        lblSSN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSSN.setText("Social Security Number");
        add(lblSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 171, -1, 28));

        lblTitle2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle2.setText("Address Details");
        add(lblTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 309, -1, -1));

        lblNationality.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNationality.setText("Nationality");
        add(lblNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 217, 183, 28));

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 67, 220, -1));

        txtEmailId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 162, 220, -1));

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAge.setText("Age");
        add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 208, 84, 28));

        txtSSN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtSSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 171, 220, -1));

        lblEMailId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEMailId.setText("E - Mail ID");
        add(lblEMailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 162, 112, 28));

        lblLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLastName.setText("Last Name");
        add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 67, 112, 28));

        txtNationality.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtNationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 217, 220, -1));

        lblContactNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblContactNumber.setText("Contact Number");
        add(lblContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 115, -1, 28));

        lblQualification.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQualification.setText("Qualification");
        add(lblQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 263, 183, 28));

        txtContactNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 115, 220, -1));

        lblDateOfBirth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDateOfBirth.setText("Date of Birth");
        add(lblDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 115, 183, 28));

        txtQualification.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 263, 220, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 69, 220, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("First Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 69, 183, 28));

        lblLine1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLine1.setText("Line 1");
        add(lblLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 367, -1, -1));

        lblLine2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLine2.setText("Line 2");
        add(lblLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 415, -1, -1));

        lblZip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblZip.setText("Zip");
        add(lblZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 367, -1, -1));

        lblState.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblState.setText("State");
        add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 415, -1, -1));

        txtLine1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 364, 102, -1));

        txtLine2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 412, 102, -1));

        txtZip.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 364, 87, -1));

        txtState.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 412, 87, -1));
        add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 118, 220, 28));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:


        if(!Validate.validateTextField(txtName, lblName,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtLastName, lblLastName,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtSSN, lblSSN,1))
        {
            return;
        }
        if(!Validate.validateTextField(txtNationality, lblNationality,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtQualification, lblQualification,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtAge, lblAge,1 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtContactNumber, lblContactNumber,1 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtEmailId, lblEMailId,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtLine1, lblLine1,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtLine2, lblLine2,0 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtZip, lblZip,1 ))
        {
            return;
        }
        if(!Validate.validateTextField(txtState, lblState,0 ))
        {
            return;
        }
        if(jXDatePicker1.getDate() == null)
        {
            JOptionPane.showMessageDialog(null, "Select Date");
            return;
        }

        Person person = enterprise.getPersonDirectory().newPerson();
        Address address = person.getAddress();
        employee = enterprise.getEd().newEmployee();
        person.setfName(txtName.getText());
        person.setlName(txtLastName.getText());
        person.setAge((Integer.parseInt(txtAge.getText())));
        person.setContactNumber(Integer.parseInt(txtContactNumber.getText()));
        person.setDob(jXDatePicker1.getDate());
        person.setEmailID(txtEmailId.getText());
        person.setNationality(txtNationality.getText());
        person.setQualification(txtQualification.getText());
        person.setSsn(Integer.parseInt(txtSSN.getText()));
        address.setLine1(txtLine1.getText());
        address.setLine2(txtLine2.getText());
        address.setZip(Integer.parseInt(txtZip.getText()));
        address.setState(txtState.getText());
        employee.setPerson(person);

        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Manager Added "
            + "\n Do you want to add admin user account?",null,JOptionPane.YES_NO_OPTION );
        if(showConfirmDialog == JOptionPane.YES_OPTION )
        {
            txtName.setText("");
            txtAge.setText("");
            txtContactNumber.setText("");
            txtEmailId.setText("");
            txtLastName.setText("");
            txtLine1.setText("");
            txtLine2.setText("");
            txtNationality.setText("");
            txtQualification.setText("");
            txtSSN.setText("");
            txtState.setText("");
            txtZip.setText("");
            jXDatePicker1.setDate(null);

            AddUserAccountJPanel auajp  = new AddUserAccountJPanel(userProcessContainer,enterprise,employee);
            userProcessContainer.add("Add user account",auajp);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);

        }
        else
        {
            userProcessContainer.remove(this);
            CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
            cardLayout.previous(userProcessContainer);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserAccountActionPerformed
        // TODO add your handling code here:
        AddUserAccountJPanel auajp  = new AddUserAccountJPanel(userProcessContainer,enterprise,employee);
        userProcessContainer.add("Add user account",auajp);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);

    }//GEN-LAST:event_btnAddUserAccountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddUserAccount;
    private javax.swing.JButton btnBack;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblEMailId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLine1;
    private javax.swing.JLabel lblLine2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblQualification;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblZip;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLine1;
    private javax.swing.JTextField txtLine2;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
