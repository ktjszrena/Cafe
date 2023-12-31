/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author yuanc
 */
public class managerViewOpenBidsPg extends javax.swing.JFrame {

    /**
     * Creates new form managerViewOpenBidsPg
     */
    public managerViewOpenBidsPg() {
        initComponents();
        setTitle("Manager Open Bids View");
    }
    ArrayList<String> workslots = new ArrayList<>();
    ArrayList<String> staffList = new ArrayList<>();
    private int dayofweek;
    private String dayOfWeekString;
    public void checkDay(String dates)  {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        java.util.Date select = null;
        try {
            select = formatter.parse(dates);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(select);
        dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println("day is " + dayofweek);

        switch (dayofweek)
        {
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
        //System.out.println(dayOfWeekString);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slotComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        staffComboBox = new javax.swing.JComboBox<>();
        searchStaffButton = new javax.swing.JButton();
        //assignButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        searchSlotButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Work Slot Info");

        jLabel2.setText("Available Staff");

        staffComboBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                staffComboBoxComponentHidden(evt);
            }
        });

        searchStaffButton.setText("Search Available Staff");
        searchStaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStaffButtonActionPerformed(evt);
            }
        });

        //assignButton.setText("Assign Staff");
        //assignButton.addActionListener(new java.awt.event.ActionListener() {
        //    public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  assignButtonActionPerformed(evt);
           // }
        //});

        searchSlotButton.setText("Search Work Slots");
        searchSlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSlotButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchStaffButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    //.addComponent(assignButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchSlotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(slotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(searchSlotButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchStaffButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(assignButton)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void staffComboBoxComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_staffComboBoxComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_staffComboBoxComponentHidden

    private void searchSlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSlotButtonActionPerformed
        // TODO add your handling code here:
        //slotComboBox.addItem("test 11 Jun 23 - Kitchen");
        slotComboBox.removeAllItems();
        searchUnbiddedC vwsC = new searchUnbiddedC();
        workslots = vwsC.searchUnbidded(1);
        for (int i=0; i<workslots.size(); i++) {
            System.out.println(workslots.get(i));
            slotComboBox.addItem(workslots.get(i));
        }
    }//GEN-LAST:event_searchSlotButtonActionPerformed

    private void searchStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStaffButtonActionPerformed
        // TODO add your handling code here:
        staffComboBox.removeAllItems();
        String hmm = slotComboBox.getSelectedItem().toString();
        String date = hmm.split(", ")[2];
        String hmmm = slotComboBox.getSelectedItem().toString();
        String role = hmmm.split(", ")[0];
        checkDay(date);
        //System.out.println(role);
        //staffComboBox.addItem("test John Kitchen");
        searchUnbiddedC vsC = new searchUnbiddedC();
        staffList = vsC.searchUnbidded(2);
        for (int i=0; i<staffList.size(); i++) {
            //System.out.println(staffList.get(i));
            if (staffList.get(i).contains(dayOfWeekString) && staffList.get(i).contains(role))
            {
                //System.out.println(dayOfWeekString + " " + staffList.get(i));
                staffComboBox.addItem(staffList.get(i));
            }
            //
        }
    }//GEN-LAST:event_searchStaffButtonActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        // TODO add your handling code here:
        //messageLabel.setText(staffComboBox.getSelectedItem() + " has been assigned to : " + slotComboBox.getSelectedItem());

    }//GEN-LAST:event_assignButtonActionPerformed

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
            java.util.logging.Logger.getLogger(managerViewOpenBidsPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managerViewOpenBidsPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managerViewOpenBidsPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managerViewOpenBidsPg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managerViewOpenBidsPg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    //private javax.swing.JButton assignButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton searchSlotButton;
    private javax.swing.JButton searchStaffButton;
    private javax.swing.JComboBox<String> slotComboBox;
    private javax.swing.JComboBox<String> staffComboBox;
    // End of variables declaration//GEN-END:variables
}
