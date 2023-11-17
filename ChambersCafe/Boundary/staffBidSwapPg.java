/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author yuanc
 */
public class staffBidSwapPg extends javax.swing.JFrame {

    /**
     * Creates new form staffBidSwapPg
     */
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public staffBidSwapPg() {
        initComponents();
        setTitle("Staff Bid Swapping");
    }

    public staffBidSwapPg(String id) {
        initComponents();
        setTitle("Staff Bid Swapping");
        setId(id);
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

        approvedComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        viewBidsButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        approvedComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvedComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Your Approved Bids");

        viewBidsButton.setText("View Approved Bids");
        viewBidsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBidsButtonActionPerformed(evt);
            }
        });

        jButton3.setText("Put Bid for Swap");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(viewBidsButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(approvedComboBox,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(56, Short.MAX_VALUE)
                                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(approvedComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewBidsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31,
                                        Short.MAX_VALUE)
                                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(14, 14, 14)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approvedComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_approvedComboBoxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_approvedComboBoxActionPerformed

    private void viewBidsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewBidsButtonActionPerformed
        // TODO add your handling code here:
        approvedComboBox.removeAllItems();
        // approvedComboBox.addItem("Bid 1");
        viewSlotsStatusC vssC = new viewSlotsStatusC();
        ArrayList<String> workSlots = vssC.retrieveSlotsA(Integer.parseInt(id));
        for (int i = 0; i < workSlots.size(); i++) {
            approvedComboBox.addItem(workSlots.get(i));
            // System.out.println(accounts.get(i));
        }
    }// GEN-LAST:event_viewBidsButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String edit = approvedComboBox.getSelectedItem().toString();

        String Pdate = edit.split(": ")[1];
        String date = Pdate.split(" ")[0];
        String Prole = edit.split(": ")[2];
        String role = Prole.split(" ")[0];
        String Pid = edit.split(": ")[3];
        String id = Pid.split(" ")[0];
        // System.out.println(date + " " + role + " " + id);
        swapShiftC ssC = new swapShiftC();
        boolean isSuccessful = ssC.swapShift(Integer.parseInt(id), date);
        displaySwapSuccessMsg(isSuccessful);
    }// GEN-LAST:event_jButton3ActionPerformed

    private void displaySwapSuccessMsg(boolean t) {
        if (t) {
            messageLabel.setText(approvedComboBox.getSelectedItem() + " is put out for swap.");
        } else {
            messageLabel.setText("Failed");
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
            java.util.logging.Logger.getLogger(staffBidSwapPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffBidSwapPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffBidSwapPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffBidSwapPg.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffBidSwapPg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> approvedComboBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton viewBidsButton;
    // End of variables declaration//GEN-END:variables
}
