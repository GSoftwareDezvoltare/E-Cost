/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainForm;

import Clase.ConnectionDataBase;
import Cumparaturi.AdaugaCumparatura;
import Setari.Setari;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author GSoftware
 */
public class MainForm extends javax.swing.JFrame {
    
    Connection connected = ConnectionDataBase.getDbCon().connect;
    PreparedStatement ps = null;
    ResultSet rs = null;
    BigDecimal buget_cash;
    BigDecimal cost_cash;
    BigDecimal cost_card;
    BigDecimal buget_card;

    public static PreparedStatement StatementOfVersion = null;
    public static ResultSet ResultSetOfVersion = null;
    public static String versiune_aplicatie = null;
    /**
     * Creates new form MainForm
     * @throws java.sql.SQLException
     */
    public MainForm() throws SQLException {
        initComponents();
        PopuleazaTabela();
        VersiuneAplicatie();
        RedimensioneazaTabela();
        BugetCard();
        BugetCash();
    }

    
    
    private void VersiuneAplicatie() throws SQLException{
    String query_versiune = "Select valoare_parametru from parametri where denumire_parametru='versiune_software'";
    StatementOfVersion = connected.prepareStatement(query_versiune);
    ResultSetOfVersion = StatementOfVersion.executeQuery();
     while(ResultSetOfVersion.next()){
                versiune_aplicatie = ResultSetOfVersion.getString("valoare_parametru");
            }
    }
    
    private void BugetCard() throws SQLException{
        String query_buget = "Select COALESCE((Select b.valoare from buget b left join parametri p  ON b.denumire = p.id where p.valoare_parametru = 'card' and data_inceput BETWEEN DATE_ADD(DATE_ADD(LAST_DAY(CURDATE()), INTERVAL 1 DAY), INTERVAL -1 MONTH) AND LAST_DAY(CURDATE()) ), 0)";
        ps = connected.prepareStatement(query_buget);
        rs = ps.executeQuery();
        while(rs.next()){
            buget_card = new BigDecimal(rs.getBigDecimal("COALESCE((Select b.valoare from buget b left join parametri p  ON b.denumire = p.id where p.valoare_parametru = 'card' and data_inceput BETWEEN DATE_ADD(DATE_ADD(LAST_DAY(CURDATE()), INTERVAL 1 DAY), INTERVAL -1 MONTH) AND LAST_DAY(CURDATE()) ), 0)").toString());
        }
        
        String query_cost_card = "Select COALESCE(sum(pret_produs), 0) from produse_cumparate where metoda_plata = 'Card_Personal' or metoda_plata = 'Card_PFA' and data_cumparatura BETWEEN DATE_ADD(DATE_ADD(LAST_DAY(CURDATE()), INTERVAL 1 DAY), INTERVAL -1 MONTH) AND LAST_DAY(CURDATE())";
        ps = connected.prepareStatement(query_cost_card);
        rs = ps.executeQuery();
        while(rs.next()){
            cost_card = new BigDecimal(rs.getBigDecimal("COALESCE(sum(pret_produs), 0)").toString());    
        }
        BigDecimal total_card = buget_card.subtract(cost_card);
        jlCard.setText(total_card.toString());
    }
    
    private void BugetCash() throws SQLException{
        String query_buget = "Select COALESCE((Select b.valoare from buget b left join parametri p  ON b.denumire = p.id where p.valoare_parametru = 'cash' and data_inceput BETWEEN DATE_ADD(DATE_ADD(LAST_DAY(CURDATE()), INTERVAL 1 DAY), INTERVAL -1 MONTH) AND LAST_DAY(CURDATE()) ), 0)";
        ps = connected.prepareStatement(query_buget);
        rs = ps.executeQuery();
        while(rs.next()){
            buget_cash = new BigDecimal(rs.getBigDecimal("COALESCE((Select b.valoare from buget b left join parametri p  ON b.denumire = p.id where p.valoare_parametru = 'cash' and data_inceput BETWEEN DATE_ADD(DATE_ADD(LAST_DAY(CURDATE()), INTERVAL 1 DAY), INTERVAL -1 MONTH) AND LAST_DAY(CURDATE()) ), 0)").toString());
        }
        String query_cost = "Select COALESCE(sum(pret_produs), 0) from produse_cumparate where metoda_plata = 'Numerar' and data_cumparatura BETWEEN DATE_ADD(DATE_ADD(LAST_DAY(CURDATE()), INTERVAL 1 DAY), INTERVAL -1 MONTH) AND LAST_DAY(CURDATE())";
        ps = connected.prepareStatement(query_cost);
        rs = ps.executeQuery();
        while(rs.next()){
            cost_cash = new BigDecimal(rs.getBigDecimal("COALESCE(sum(pret_produs), 0)").toString());    
        }
        BigDecimal total_cash = buget_cash.subtract(cost_cash);
        jlCash.setText(total_cash.toString());
    }
    
    private void PopuleazaTabela() throws SQLException{
        String sql = "Select pc.cumparator AS Cumparator , p.Denumire_produs AS 'Denumire Produs', m.denumire AS 'Denumire Magazin', pc.pret_produs AS 'Pret' , pc.folosit AS 'Folosit', pc.Data_Cumparatura AS 'Data', pc.Categorie AS 'Categorie', pc.metoda_plata AS 'Metoda Plata' from produse_cumparate pc left join produse p  ON pc.produs_cumparat = p.id left join magazine m ON p.magazin = m.id";
        ps = connected.prepareStatement(sql);
        rs = ps.executeQuery();
            jTabelaProduse.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    private void RedimensioneazaTabela(){
        jTabelaProduse.getColumn("Cumparator").setMinWidth(70);
        jTabelaProduse.getColumn("Cumparator").setMaxWidth(70);       
    
        jTabelaProduse.getColumn("Denumire Produs").setMinWidth(170);
        jTabelaProduse.getColumn("Denumire Produs").setMaxWidth(170);
        
        jTabelaProduse.getColumn("Denumire Magazin").setMinWidth(250);
        jTabelaProduse.getColumn("Denumire Magazin").setMaxWidth(250);
    
        jTabelaProduse.getColumn("Pret").setMinWidth(50);
        jTabelaProduse.getColumn("Pret").setMaxWidth(50);
        
        jTabelaProduse.getColumn("Folosit").setMinWidth(50);
        jTabelaProduse.getColumn("Folosit").setMaxWidth(50); 
        
        jTabelaProduse.getColumn("Data").setMinWidth(150);
        jTabelaProduse.getColumn("Data").setMaxWidth(150); 
        
        jTabelaProduse.getColumn("Categorie").setMinWidth(90);
        jTabelaProduse.getColumn("Categorie").setMaxWidth(90); 
        
        jTabelaProduse.getColumn("Metoda Plata").setMinWidth(90);
        jTabelaProduse.getColumn("Metoda Plata").setMaxWidth(90); 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaProduse = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlCard = new javax.swing.JLabel();
        jlCash = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlImbracaminte = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlIncaltaminte = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlMancare = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlUtilitati = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlAbonamente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlAbonamente1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlAbonamente2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jbtnReincarcaTabel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cost Management Easy");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(900, 317));

        jTabelaProduse.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabelaProduse.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabelaProduse.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTabelaProduse.setMinimumSize(new java.awt.Dimension(830, 640));
        jTabelaProduse.setNextFocusableComponent(this);
        jTabelaProduse.setRowSelectionAllowed(false);
        jTabelaProduse.getTableHeader().setReorderingAllowed(false);
        jTabelaProduse.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTabelaProduse);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Bugetul pentru luna in curs");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Card:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Cash:");

        jlCard.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlCard.setForeground(new java.awt.Color(0, 204, 255));
        jlCard.setText("0.0");

        jlCash.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlCash.setForeground(new java.awt.Color(0, 204, 204));
        jlCash.setText("0.0");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Imbracaminte:");

        jlImbracaminte.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlImbracaminte.setForeground(new java.awt.Color(0, 204, 255));
        jlImbracaminte.setText("0.0");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Incaltaminte:");

        jlIncaltaminte.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlIncaltaminte.setForeground(new java.awt.Color(0, 204, 255));
        jlIncaltaminte.setText("0.0");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Mancare:");

        jlMancare.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlMancare.setForeground(new java.awt.Color(0, 204, 255));
        jlMancare.setText("0.0");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Utilitati:");

        jlUtilitati.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlUtilitati.setForeground(new java.awt.Color(0, 204, 255));
        jlUtilitati.setText("0.0");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Abonamente:");

        jlAbonamente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlAbonamente.setForeground(new java.awt.Color(0, 204, 255));
        jlAbonamente.setText("0.0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Venituri pentru luna in curs");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Altele:");

        jlAbonamente1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlAbonamente1.setForeground(new java.awt.Color(0, 204, 255));
        jlAbonamente1.setText("0.0");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Sala:");

        jlAbonamente2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlAbonamente2.setForeground(new java.awt.Color(0, 204, 255));
        jlAbonamente2.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlCard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCash, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlImbracaminte, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlIncaltaminte, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlMancare, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlUtilitati, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAbonamente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAbonamente1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAbonamente2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlCard)
                    .addComponent(jLabel3)
                    .addComponent(jlCash))
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlImbracaminte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlIncaltaminte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlMancare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlUtilitati))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlAbonamente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlAbonamente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jlAbonamente2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        jbtnReincarcaTabel.setText("Reincarca Tabel");
        jbtnReincarcaTabel.setFocusable(false);
        jbtnReincarcaTabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnReincarcaTabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnReincarcaTabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReincarcaTabelActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnReincarcaTabel);

        jMenu1.setText("Suport");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImaginiAplicatie/resize.jpg"))); // NOI18N
        jMenuItem1.setText("Ajutor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Setari");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Rapoarte");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cumparaturi");

        jMenuItem3.setText("Adauga");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("E-Cost - Cost Management Easy");

        getAccessibleContext().setAccessibleName("E-Cost - Cost Management Easy");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        try {
            Setari s = new Setari();
            s.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
       
        try {
            AdaugaCumparatura ap = new AdaugaCumparatura();
            ap.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jbtnReincarcaTabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnReincarcaTabelActionPerformed
         try {
             PopuleazaTabela();
             BugetCard();
             BugetCash();
             RedimensioneazaTabela();
         } catch (SQLException ex) {
             Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jbtnReincarcaTabelActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTabelaProduse;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnReincarcaTabel;
    private javax.swing.JLabel jlAbonamente;
    private javax.swing.JLabel jlAbonamente1;
    private javax.swing.JLabel jlAbonamente2;
    private javax.swing.JLabel jlCard;
    private javax.swing.JLabel jlCash;
    private javax.swing.JLabel jlImbracaminte;
    private javax.swing.JLabel jlIncaltaminte;
    private javax.swing.JLabel jlMancare;
    private javax.swing.JLabel jlUtilitati;
    // End of variables declaration//GEN-END:variables
}
