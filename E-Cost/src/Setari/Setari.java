/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setari;

import Buget.AdaugaBuget;
import Magazine.AdaugaMagazin;
import static MainForm.MainForm.versiune_aplicatie;
import Produse.AdaugaProduse;
import Venituri.AdaugaVenituri;
import com.toedter.calendar.JCalendar;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GSoftware
 */
public class Setari extends javax.swing.JFrame {
    
    Date data_curenta;
    String data;
    String primaZi;
    
    public Setari() throws SQLException {
        initComponents();
        jparamentru_versiune.setText(versiune_aplicatie);
        VerificareData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jparamentru_versiune = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbtnUtilizatori = new javax.swing.JButton();
        jbtnProduse = new javax.swing.JButton();
        jbtnMagazine = new javax.swing.JButton();
        jbtnBuget = new javax.swing.JButton();
        jbtnVenituri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jbtnAdauga = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cost Management Easy - Setari");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jparamentru_versiune.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jparamentru_versiune.setForeground(new java.awt.Color(204, 0, 0));
        jparamentru_versiune.setText("Versiune Aplicatie");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 153, 51)))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(51, 255, 0));

        jbtnUtilizatori.setText("Utilizatori");
        jbtnUtilizatori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUtilizatoriActionPerformed(evt);
            }
        });

        jbtnProduse.setText("Produse");
        jbtnProduse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProduseActionPerformed(evt);
            }
        });

        jbtnMagazine.setText("Magazine");
        jbtnMagazine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMagazineActionPerformed(evt);
            }
        });

        jbtnBuget.setText("Buget");
        jbtnBuget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBugetActionPerformed(evt);
            }
        });

        jbtnVenituri.setText("Venituri");
        jbtnVenituri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVenituriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtnUtilizatori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnProduse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnMagazine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnBuget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbtnVenituri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbtnUtilizatori)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnProduse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnMagazine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnBuget)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnVenituri)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Setari");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jToolBar1.setRollover(true);

        jbtnAdauga.setText("Adauga");
        jbtnAdauga.setFocusable(false);
        jbtnAdauga.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnAdauga.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbtnAdauga);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jparamentru_versiune, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jparamentru_versiune)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnUtilizatoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUtilizatoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnUtilizatoriActionPerformed

    private void VerificareData() throws SQLException{
        JCalendar calendar = new JCalendar();
        data_curenta = calendar.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        data = format.format(data_curenta);
        
        //prima zi din luna
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatare = new SimpleDateFormat("dd MMMM yyyy");
        cal.set(Calendar.DAY_OF_MONTH, 1);
        primaZi = formatare.format(cal.getTime());
 
    }
    
    
    
    private void jbtnProduseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProduseActionPerformed
        // TODO add your handling code here:
        AdaugaProduse adauga_produse;
        try {
            adauga_produse = new AdaugaProduse();
            adauga_produse.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Setari.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtnProduseActionPerformed

    private void jbtnMagazineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMagazineActionPerformed
        // TODO add your handling code here:
        AdaugaMagazin adauga_magazin = new AdaugaMagazin();
        adauga_magazin.setVisible(true);
    }//GEN-LAST:event_jbtnMagazineActionPerformed

    private void jbtnBugetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBugetActionPerformed
        // TODO add your handling code here:
        AdaugaBuget adauga_buget = new AdaugaBuget();
        adauga_buget.setVisible(true);
    }//GEN-LAST:event_jbtnBugetActionPerformed

    private void jbtnVenituriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVenituriActionPerformed
        try {
            // TODO add your handling code here:
            if(primaZi.equals(data)){
                AdaugaVenituri adauga_venituri = new AdaugaVenituri();
                adauga_venituri.setVisible(true);
            }
            else{
                AdaugaVenituri adauga_venituri = new AdaugaVenituri();
                adauga_venituri.setVisible(false);
                JOptionPane.showMessageDialog(null, "Bugetul se adauga in prima zi din luna! " + "Data curenta: " + data);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Setari.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtnVenituriActionPerformed

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
            java.util.logging.Logger.getLogger(Setari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Setari().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Setari.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnAdauga;
    private javax.swing.JButton jbtnBuget;
    private javax.swing.JButton jbtnMagazine;
    private javax.swing.JButton jbtnProduse;
    private javax.swing.JButton jbtnUtilizatori;
    private javax.swing.JButton jbtnVenituri;
    private javax.swing.JLabel jparamentru_versiune;
    // End of variables declaration//GEN-END:variables
}
