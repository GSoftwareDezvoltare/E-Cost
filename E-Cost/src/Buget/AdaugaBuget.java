/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buget;

import Clase.Buget;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author GSoftware
 */
public class AdaugaBuget extends javax.swing.JFrame {

    Buget bugetNou = new Buget();
    /**
     * Creates new form AdaugaBuget
     */
    public AdaugaBuget() {
        initComponents();
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
        jbtnAdaugaBuget = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfMancare = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfImbracaminte = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfIncaltaminte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfUtilitati = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfAbonamente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfAltele = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfSala = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cost Management Easy - Adauga Buget");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adauga Buget", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jbtnAdaugaBuget.setText("Adauga");
        jbtnAdaugaBuget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAdaugaBugetActionPerformed(evt);
            }
        });

        jLabel3.setText("Mancare:");

        jLabel4.setText("Imbracaminte:");

        jLabel5.setText("Incaltaminte:");

        jLabel6.setText("Utilitati:");

        jLabel7.setText("Abonamente:");

        jLabel8.setText("Altele:");

        jLabel9.setText("Sala:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAdaugaBuget))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSala)
                            .addComponent(jtfAltele)
                            .addComponent(jtfAbonamente, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jtfUtilitati)
                            .addComponent(jtfIncaltaminte)
                            .addComponent(jtfMancare)
                            .addComponent(jtfImbracaminte))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMancare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfImbracaminte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfIncaltaminte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfUtilitati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfAbonamente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfAltele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jbtnAdaugaBuget)
                .addContainerGap())
        );

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

    private void jbtnAdaugaBugetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAdaugaBugetActionPerformed
        // TODO add your handling code here:
        ValidareCampuri();
    }//GEN-LAST:event_jbtnAdaugaBugetActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void ValidareCampuri(){
        if(jtfMancare.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru mancare!");
        }
        else
            if(jtfImbracaminte.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru imbracaminte!");
            }
            else
                if(jtfIncaltaminte.getText().isEmpty()){
                     JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru incaltaminte!");
                }
                else
                    if(jtfUtilitati.getText().isEmpty()){
                         JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru utilitati!");
                    }
                    else
                        if(jtfAbonamente.getText().isEmpty()){
                             JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru abonamente!");
                        }
                        else
                            if(jtfAltele.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru altele!");
                            }
                            else
                                if(jtfSala.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Completati campul bugetului pentru sala!");
                                }
                                else
                                {
                                    ExtragereDate();
                                }
                           
    }
    
//    private void InserareBuget() throws SQLException{
//    String sql = "Insert into produse_cumparate(cumparator, produs_cumparat, pret_produs, folosit, data_cumparatura , categorie) "
//                    + "VALUES (?, ?, ?, ?,?, ?)";
//                ps = connected.prepareStatement(sql);
//                ps.setString(1, ProdusNou.getCumparator());
//                ps.setInt(2, ProdusNou.getProdus_cumparat());
//                ps.setBigDecimal(3, ProdusNou.getPret_produs());
//                ps.setString(4, ProdusNou.getPersoana_folosit());
//                ps.setString(5, ProdusNou.getData_cumparare());
//                ps.setString(6, ProdusNou.getCategorie());
//                ps.executeUpdate();
//    }
    
    
    private void ExtragereDate(){
        
        BigDecimal buget_mancare = new BigDecimal(jtfMancare.getText());
        bugetNou.setMancare(buget_mancare);
        
        BigDecimal buget_imbracaminte = new BigDecimal(jtfImbracaminte.getText());
        bugetNou.setImbracaminte(buget_imbracaminte);
        
        BigDecimal buget_incaltaminte = new BigDecimal(jtfIncaltaminte.getText());
        bugetNou.setIncaltaminte(buget_incaltaminte);
        
        BigDecimal buget_utilitati = new BigDecimal(jtfUtilitati.getText());
        bugetNou.setIncaltaminte(buget_utilitati);
        
        BigDecimal buget_abonamente = new BigDecimal(jtfAbonamente.getText());
        bugetNou.setIncaltaminte(buget_abonamente);
        
        BigDecimal buget_altele = new BigDecimal(jtfAltele.getText());
        bugetNou.setAltele(buget_altele);
        
        BigDecimal buget_sala = new BigDecimal(jtfSala.getText());
        bugetNou.setSala(buget_sala);
        
    }
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(AdaugaBuget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdaugaBuget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdaugaBuget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdaugaBuget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdaugaBuget().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnAdaugaBuget;
    private javax.swing.JTextField jtfAbonamente;
    private javax.swing.JTextField jtfAltele;
    private javax.swing.JTextField jtfImbracaminte;
    private javax.swing.JTextField jtfIncaltaminte;
    private javax.swing.JTextField jtfMancare;
    private javax.swing.JTextField jtfSala;
    private javax.swing.JTextField jtfUtilitati;
    // End of variables declaration//GEN-END:variables
}
