
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateChooser;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author yuanc
 */
public class assignStaffPg extends javax.swing.JFrame {

    private DateChooser chDate = new DateChooser();
    private int dayofweek;
    private String dayOfWeekString;
    private String roleCheck;
    private int idCheck;

    /**
     * Creates new form assignStaffPg
     */
    public assignStaffPg() {
        initComponents();
        setTitle("Assign Staff");
        chDate.setTextField(txtDate);
    }

    public void checkDay() {
        java.util.Date select = chDate.getSelectedDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(select);
        dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        // System.out.println("day is " + dayofweek);

        switch (dayofweek) {
            case Calendar.SUNDAY:
                dayOfWeekString = "SUN";
                break;
            case Calendar.MONDAY:
                dayOfWeekString = "MON";
                break;
            case Calendar.TUESDAY:
                dayOfWeekString = "TUE";
                break;
            case Calendar.WEDNESDAY:
                dayOfWeekString = "WED";
                break;
            case Calendar.THURSDAY:
                dayOfWeekString = "THU";
                break;
            case Calendar.FRIDAY:
                dayOfWeekString = "FRI";
                break;
            case Calendar.SATURDAY:
                dayOfWeekString = "SAT";
                break;
            default:
                dayOfWeekString = "Invalid day";
                break;
        }
        // System.out.println(dayOfWeekString);
    }

    public void updateSlots() {
        slotsComboBox.removeAllItems();
        System.out.println("Something");
        viewWorkSlotsC vwsC = new viewWorkSlotsC();
        ArrayList<String> workSlots = vwsC.retrieveWorkSlot();
        checkDay();
        for (int i = 0; i < workSlots.size(); i++) {
            // System.out.println(workSlots.get(i));
            String hmm = workSlots.get(i);
            // System.out.println(hmm);
            String role = hmm.split(", ")[0];
            String slots = hmm.split(", ")[1];
            String date = hmm.split(", ")[2];
            String day = date.split("-")[2];
            String month = date.split("-")[1];
            String year = date.split("-")[0];
            System.out.println(day + month + year);
            String convert = day + "-" + month + "-" + year;
            if (convert.equals(txtDate.getText())) {
                slotsComboBox.addItem(role + " " + slots + " slots");
            }
        }
        checkStaff();
    }

    public void checkStaff() {
        staffComboBox.removeAllItems();
        viewStaffController vsC = new viewStaffController();
        ArrayList<String> staffDetails = vsC.viewStaffS();
        for (int i = 0; i < staffDetails.size(); i++) {
            System.out.println(staffDetails.get(i));
            String hmm = staffDetails.get(i);
            if (hmm.contains(dayOfWeekString)) {
                String id = hmm.split(" ")[0];
                String role = hmm.split(" ")[1];
                staffComboBox.addItem("ID: " + id + " " + role);
            }
            // System.out.println(accounts.get(i));
        }
    }

    public void organize() {
        String sCheck = staffComboBox.getSelectedItem().toString();
        roleCheck = sCheck.split(" ")[2];
        String idcheck1 = sCheck.split(" ")[1];
        idCheck = Integer.parseInt(idcheck1);
        // System.out.println(roleCheck + " " + idCheck);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        slotsComboBox = new javax.swing.JComboBox<>();
        checkButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        staffComboBox = new javax.swing.JComboBox<>();
        assignButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Date:");

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        jLabel2.setText("Slots:");

        checkButton.setText("Check Slots");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Staff:");

        assignButton.setText("Assign Staff");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtDate)
                                                        .addComponent(slotsComboBox, 0, 100, Short.MAX_VALUE)
                                                        .addComponent(staffComboBox, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addComponent(checkButton)))
                                .addContainerGap(62, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(assignButton)
                                .addGap(132, 132, 132)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(slotsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(staffComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(assignButton)
                                .addGap(26, 26, 26)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtDateActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkButtonActionPerformed
        // TODO add your handling code here:
        updateSlots();
    }// GEN-LAST:event_checkButtonActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_assignButtonActionPerformed
        // TODO add your handling code here:
        // System.out.println("yo");
        organize();
        assignCafeStaffC acsC = new assignCafeStaffC();
        int result = acsC.assignCafeStaff(txtDate.getText(), roleCheck, idCheck);
        displaycheck(result);

    }// GEN-LAST:event_assignButtonActionPerformed

    private void displaycheck(int x) {
        if (x == 1) {
            new displayMessage("Success! Staff assigned.").setVisible(true);
        } else {
            new displayMessage("Fail! staff not assigned").setVisible(true);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {

            java.util.logging.Logger.getLogger(assignStaffPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(assignStaffPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(assignStaffPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(assignStaffPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assignStaffPg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JComboBox<String> slotsComboBox;
    private javax.swing.JComboBox<String> staffComboBox;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
