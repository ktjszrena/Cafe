/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author yuanc
 */
public class createAccountFrame extends javax.swing.JFrame {

    /**
     * Creates new form createAccountFrame
     */
    private class UserProfile
    {
        viewUserProfilesC vup = new viewUserProfilesC();
        private String name;
        private String desc;
        private String perms;
        private String search;
        ArrayList<String> profiles = new ArrayList<>();

        ArrayList<String> namelist = new ArrayList<>();

        public UserProfile(String search)
        {
            this.search = search;
            //System.out.println("Name is " + getName());
            profiles = vup.viewUserProfile();
            getNamelist();
        }

        public String getName()
        {
            return name;
        }

        public String getDesc()
        {
            return desc;
        }

        public String getPerms()
        {
            return perms;
        }
        public String getSearch()
        {
            return search;
        }

        public void setName()
        {
            this.name = name;
        }

        public void setPerms()
        {
            this.perms = perms;
        }

        public void setDesc()
        {
            this.desc = desc;
        }
        public void setSearch()
        {
            this.search = search;
        }

        private String returnList(String search)
        {

            return "something";
        }
        //public ArrayList<String> getUserProfiles() //Should be getting from the SQL, not here
        //{
        //    profiles.add("System Admin, Manage all user accounts, sysadm");
        //    profiles.add("Cafe Manager, Handles bids for slots, manager");
        //    profiles.add("Cafe Owner, Manage work slots, owner");
        //    profiles.add("Cafe Staff, Bids for work slots, staff");
        //    return profiles;
        //}
        public ArrayList<String> getNamelist() //Should be getting from the SQL, not here
        {
            for (String profile : profiles)
            {
                String firstele = profile.split(",")[0];
                System.out.println(firstele);
            }
            return namelist;
        }
    }
    public createAccountFrame() {
        initComponents();
        setTitle("ACCOUNT CREATION");
        UserProfile a = new UserProfile("name here");

    }
    
    public String createAccountController(){
        String account;
        account = newUsernameTF.getText() + ", " + newPasswordTF.getText() + ", " +
                userIDTF.getText() + ", " + dobTF.getText() + ", " + 
                addressTF.getText() + ", " + employeeTypeCB.getSelectedItem().toString() + 
                ", " + positionCB.getSelectedItem().toString();
        return account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newUsernameLabel = new javax.swing.JLabel();
        newUsernameTF = new javax.swing.JTextField();
        newPasswordLabel = new javax.swing.JLabel();
        newPasswordTF = new javax.swing.JTextField();
        createAccountButton = new javax.swing.JButton();
        userIDLabel = new javax.swing.JLabel();
        userIDTF = new javax.swing.JTextField();
        dobLabel = new javax.swing.JLabel();
        dobTF = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        positionLabel = new javax.swing.JLabel();
        positionCB = new javax.swing.JComboBox<>();
        employeeTypeCB = new javax.swing.JComboBox<>();
        employeeTypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newUsernameLabel.setText("New Username:");

        newUsernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUsernameTFActionPerformed(evt);
            }
        });

        newPasswordLabel.setText("New Password:");

        newPasswordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordTFActionPerformed(evt);
            }
        });

        createAccountButton.setText("Create Account");
        createAccountButton.setToolTipText("");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        userIDLabel.setText("User ID:");

        userIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDTFActionPerformed(evt);
            }
        });

        dobLabel.setText("Date of Birth:");

        dobTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobTFActionPerformed(evt);
            }
        });

        addressLabel.setText("Address:");

        addressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTFActionPerformed(evt);
            }
        });

        positionLabel.setText("Position");

        positionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Waiter", "Cashier", "Kitchen" }));

        employeeTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Manager", "Owner" }));
        employeeTypeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeTypeCBActionPerformed(evt);
            }
        });

        employeeTypeLabel.setText("Employee Type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(positionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(employeeTypeLabel)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeTypeCB, 0, 100, Short.MAX_VALUE)
                    .addComponent(positionCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionLabel)
                    .addComponent(positionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(newUsernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(userIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dobLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(dobTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createAccountButton)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUsernameLabel)
                    .addComponent(newUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel)
                    .addComponent(newPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIDLabel)
                    .addComponent(userIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobLabel)
                    .addComponent(dobTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createAccountButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newUsernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUsernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newUsernameTFActionPerformed

    private void newPasswordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordTFActionPerformed

    private void employeeTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeTypeCBActionPerformed
        String selectedValue = employeeTypeCB.getSelectedItem().toString();
        if (selectedValue.contains("Owner")){
            positionCB.setEnabled(false);
            positionCB.addItem("Owner");
            positionCB.setSelectedItem("Owner");
        }
        else if (selectedValue.contains("Manager")){
            positionCB.setEnabled(false);
            positionCB.addItem("Manager");
            positionCB.setSelectedItem("Manager");
        }
        else if (selectedValue.contains("Staff")){
            positionCB.removeAllItems();
            positionCB.addItem("Waiter");
            positionCB.addItem("Cashier");
            positionCB.addItem("Kitchen");
            positionCB.setEnabled(true);
        }
    }//GEN-LAST:event_employeeTypeCBActionPerformed

    private void userIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDTFActionPerformed

    private void dobTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobTFActionPerformed

    private void addressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTFActionPerformed

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        // TODO add your handling code here:
        String msg = createAccountController();
        new testFrame(msg).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_createAccountButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String x;
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(createAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAccountFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTF;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField dobTF;
    private javax.swing.JComboBox<String> employeeTypeCB;
    private javax.swing.JLabel employeeTypeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JTextField newPasswordTF;
    private javax.swing.JLabel newUsernameLabel;
    private javax.swing.JTextField newUsernameTF;
    private javax.swing.JComboBox<String> positionCB;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel userIDLabel;
    private javax.swing.JTextField userIDTF;
    // End of variables declaration//GEN-END:variables
}

