/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venituri;

import Clase.ConnectionDataBase;
import Clase.ItemsOfComboBox;
import Clase.Venituri;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GSoftware
 */
public class AdaugaVenituri extends javax.swing.JFrame {
    Venituri VenitNou = new Venituri();
    Connection connected = ConnectionDataBase.getDbCon().connect;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DateFormat df = DateFormat.getDateInstance();
    
    Object item;
    int value;
    /**
     * Creates new form AdaugaVenituri
     * @throws java.sql.SQLException
     */
    public AdaugaVenituri() throws SQLException {
        initComponents();
        TipVenituri();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbxVenituri = new javax.swing.JComboBox();
        jtfVenit = new javax.swing.JTextField();
        jbtnAdaugaVenituri = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDataInceput = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDataSfarsit = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jtfDetaliiBuget = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cost Management Easy - Adauga Venituri");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adauga Venituri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel1.setText("Selecteaza categoria pentru care doresti sa adaugi venituri:");

        jcbxVenituri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alege categoria pentru care doresti venituri" }));
        jcbxVenituri.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbxVenituriPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jbtnAdaugaVenituri.setText("Adauga");
        jbtnAdaugaVenituri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAdaugaVenituriActionPerformed(evt);
            }
        });

        jLabel2.setText("Venit:");

        jLabel3.setText("Data Inceput:");

        jLabel4.setText("Data Sfarsit:");

        jLabel6.setText("Detalii Buget:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnAdaugaVenituri)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbxVenituri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfVenit)
                                    .addComponent(jDataInceput, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataSfarsit, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jtfDetaliiBuget))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbxVenituri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfVenit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataInceput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDataSfarsit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfDetaliiBuget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jbtnAdaugaVenituri)
                .addContainerGap())
        );

        jtfVenit.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAdaugaVenituriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAdaugaVenituriActionPerformed
        try {
            // TODO add your handling code here:
            InsertBuget();
            JOptionPane.showMessageDialog(null, "Venitul a fost introdus cu succes!");
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdaugaVenituri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnAdaugaVenituriActionPerformed

    private void jcbxVenituriPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbxVenituriPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxVenituriPopupMenuWillBecomeInvisible

    private void ExtragereDate(){
        item = jcbxVenituri.getSelectedItem();
        value = ((ItemsOfComboBox)item).getId();
        VenitNou.setTip(value);
        
        BigDecimal venit = new BigDecimal(jtfVenit.getText());
        VenitNou.setValoare(venit);
        
        Date data_inceput = jDataInceput.getDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String date_inceput = format.format(data_inceput);
        VenitNou.setData_inceput(date_inceput);
        
        Date data_sfarsit = jDataSfarsit.getDate();
        SimpleDateFormat formatSf = new SimpleDateFormat("yyyy/MM/dd");
        String date_sfarsit = formatSf.format(data_sfarsit);
        VenitNou.setData_sfarsit(date_sfarsit);
        
        VenitNou.setDetalii(jtfDetaliiBuget.getText());
    }
    private void InsertBuget() throws SQLException{
        ExtragereDate();
        String insertOfBuget = "Insert into buget (denumire, valoare, data_inceput, data_sfarsit, detalii_buget)"
                + "value (?,?,?,?,?)";
                ps = connected.prepareStatement(insertOfBuget);
                ps.setInt(1, VenitNou.getTip());
                ps.setBigDecimal(2, VenitNou.getValoare());
                ps.setString(3, VenitNou.getData_inceput());
                ps.setString(4, VenitNou.getData_sfarsit());
                ps.setString(5, VenitNou.getDetalii());    
                ps.executeUpdate();
    }
    
    private void TipVenituri() throws SQLException{
        String cumparatorOfComboBox = "Select id, valoare_parametru from parametri where denumire_parametru = 'venituri'";
            ps = connected.prepareStatement(cumparatorOfComboBox);
            rs = ps.executeQuery();
             while(rs.next()){
                int id = rs.getInt("id");
                String tip =rs.getString("valoare_parametru");
                jcbxVenituri.addItem(new ItemsOfComboBox(tip, id));
            }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(AdaugaVenituri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdaugaVenituri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdaugaVenituri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdaugaVenituri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new AdaugaVenituri().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdaugaVenituri.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDataInceput;
    private com.toedter.calendar.JDateChooser jDataSfarsit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnAdaugaVenituri;
    private javax.swing.JComboBox jcbxVenituri;
    private javax.swing.JTextField jtfDetaliiBuget;
    private javax.swing.JTextField jtfVenit;
    // End of variables declaration//GEN-END:variables
}