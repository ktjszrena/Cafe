/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author yuanc
 */
public class staffBidsMenuPg extends javax.swing.JFrame {

    /**
     * Creates new form staffBidsPg
     */
    private String role;
    private String id;
    public void setId(String id)
    {
        this.id = id;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public staffBidsMenuPg() {
        initComponents();
        setTitle("Staff Bidding Menu");
    }
    public staffBidsMenuPg(String id, String role) {
        initComponents();
        setTitle("Staff Bidding Menu");
        setId(id);
        setRole(role);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bidButton = new javax.swing.JButton();
        pendingButton = new javax.swing.JButton();
        swapButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bidButton.setText("Bid Slot");
        bidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidButtonActionPerformed(evt);
            }
        });

        pendingButton.setText("Pending Bids");
        pendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingButtonActionPerformed(evt);
            }
        });

        swapButton.setText("Swap Bids");
        swapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pendingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bidButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(swapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(bidButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendingButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(swapButton)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidButtonActionPerformed
        // TODO add your handling code here:
        staffBidSlotPg bidSlot = new staffBidSlotPg(id, role);
        bidSlot.setVisible(true);
    }//GEN-LAST:event_bidButtonActionPerformed

    private void pendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingButtonActionPerformed
        // TODO add your handling code here:
        staffBidPendingPg pending = new staffBidPendingPg(id);
        pending.setVisible(true);
    }//GEN-LAST:event_pendingButtonActionPerformed

    private void swapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapButtonActionPerformed
        // TODO add your handling code here:
        staffBidSwapPg swap = new staffBidSwapPg(id);
        swap.setVisible(true);
    }//GEN-LAST:event_swapButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(staffBidsMenuPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffBidsMenuPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffBidsMenuPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffBidsMenuPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffBidsMenuPg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bidButton;
    private javax.swing.JButton pendingButton;
    private javax.swing.JButton swapButton;
    // End of variables declaration//GEN-END:variables
}
