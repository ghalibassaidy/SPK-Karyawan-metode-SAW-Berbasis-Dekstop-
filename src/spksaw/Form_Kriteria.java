/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spksaw;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Form_Kriteria extends javax.swing.JFrame {
String autono = sesiangka.getautono();
    /**
     * Creates new form Petugas
     */
    public Form_Kriteria() {
        initComponents();
        
        this.setLocationRelativeTo(this);
       
        T_nm_kriteria();
        txtnm.requestFocus();
     c();
    }
   
 public void c(){
       txtc1.setEnabled(false);
       txtc2.setEnabled(false);
       txtc3.setEnabled(false);
       txtc4.setEnabled(false);
 }
      public void T_nm_kriteria(){
    
  try{
      Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
      String sql = "select * from tbl_nm_kriteria";
      
      ResultSet rs = stt.executeQuery(sql);
      while(rs.next()){
   
     lk1.setText(rs.getString("kriteria1"));
      lk2.setText(rs.getString("kriteria2"));
       lk3.setText(rs.getString("kriteria3"));
        lk4.setText(rs.getString("kriteria4"));
     
      }
     rs.close();
     stt.close();
  
  }catch(Exception e){
     JOptionPane.showMessageDialog(this, "Warning "+e);
  }
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
        jLabel10 = new javax.swing.JLabel();
        BU = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnm = new javax.swing.JTextField();
        lk2 = new javax.swing.JLabel();
        BH = new javax.swing.JButton();
        lk1 = new javax.swing.JLabel();
        BB1 = new javax.swing.JButton();
        txtc1 = new javax.swing.JTextField();
        txtc2 = new javax.swing.JTextField();
        txtc4 = new javax.swing.JTextField();
        lk4 = new javax.swing.JLabel();
        BU2 = new javax.swing.JButton();
        txtc3 = new javax.swing.JTextField();
        lk3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setPreferredSize(new java.awt.Dimension(511, 50));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Edit Data Karyawan");

        BU.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530428806684.png"))); // NOI18N
        BU.setText("Tambah Data");
        BU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(BU)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BU, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Nama Karyawan :");

        txtnm.setBackground(new java.awt.Color(240, 240, 240));
        txtnm.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtnm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lk2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lk2.setText("Kriteria 2");

        BH.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1531827419677.png"))); // NOI18N
        BH.setText("Hapus");
        BH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHActionPerformed(evt);
            }
        });

        lk1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lk1.setText("Keriteria 1");

        BB1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530429001320.png"))); // NOI18N
        BB1.setText("Tutup");
        BB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BB1ActionPerformed(evt);
            }
        });

        txtc1.setBackground(new java.awt.Color(240, 240, 240));
        txtc1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtc1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtc1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtc2.setBackground(new java.awt.Color(240, 240, 240));
        txtc2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtc2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtc2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtc4.setBackground(new java.awt.Color(240, 240, 240));
        txtc4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtc4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtc4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lk4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lk4.setText("Kriteria 4");

        BU2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BU2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530428938436.png"))); // NOI18N
        BU2.setText("Proses Edit");
        BU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BU2ActionPerformed(evt);
            }
        });

        txtc3.setBackground(new java.awt.Color(240, 240, 240));
        txtc3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtc3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtc3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        lk3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lk3.setText("Kriteria 3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtnm)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtc1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(txtc2))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lk1)
                                        .addComponent(lk2))
                                    .addGap(151, 151, 151))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(BH)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BB1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lk4)
                                .addComponent(lk3)
                                .addComponent(txtc3)
                                .addComponent(txtc4)
                                .addComponent(BU2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lk1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtc1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lk3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtc3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lk2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lk4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtc2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtc4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BB1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BU2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, lk1, lk2});

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUActionPerformed
        // TODO add your handling code here:
        dispose();
       new Newkary().setVisible(true);
    }//GEN-LAST:event_BUActionPerformed
    
    private void BHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHActionPerformed
        // TODO add your handling code here:
      
        String no = txtnm.getText();
       int w;
        w = JOptionPane.showConfirmDialog(this, "Yakin Ingin Dihapus ?","Peringatan", JOptionPane.YES_NO_OPTION);
        if(w== JOptionPane.NO_OPTION){
            
        }
             
       else{
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM tbl_kriteria WHERE R=?";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, no);
               
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(this," Dihapus, Refresh Table !");
               
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,"System Error !"+e);
            } finally {
            }
       }
    }//GEN-LAST:event_BHActionPerformed

    private void BB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BB1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BB1ActionPerformed

    private void BU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BU2ActionPerformed
        // TODO add your handling code here:
        String nm = txtnm.getText();
        String  C1 = txtc1.getText();
        String  C2 = txtc2.getText();
        String  C3 = txtc3.getText();
        String  C4 = txtc4.getText();
        if(txtnm.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
            txtnm.requestFocus();
        }
        else if(txtc1.equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
          txtc1.requestFocus();

        }
       else if(txtc1.equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
         txtc1.requestFocus();

        }
        
       else if(txtc4.equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
         txtc4.requestFocus();

        }
       else if(txtc2.equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
         txtc2.requestFocus();

        }
             
       else{
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE tbl_kriteria set c1=?, c2=?, c3=?, c4=? WHERE R=?";

                PreparedStatement p = c.prepareStatement(sql);
                
                
                p.setString(5, nm);
                p.setString(1, C1);
                p.setString(2, C2);
                p.setString(3, C3);
                p.setString(4, C4);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(this," Terubah, Refresh Table !");
               
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,"System Error !"+e);
            } finally {
            }
       }
    }//GEN-LAST:event_BU2ActionPerformed
      
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Kriteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BB1;
    public javax.swing.JButton BH;
    public javax.swing.JButton BU;
    public javax.swing.JButton BU2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lk1;
    private javax.swing.JLabel lk2;
    private javax.swing.JLabel lk3;
    private javax.swing.JLabel lk4;
    public javax.swing.JTextField txtc1;
    public javax.swing.JTextField txtc2;
    public javax.swing.JTextField txtc3;
    public javax.swing.JTextField txtc4;
    public javax.swing.JTextField txtnm;
    // End of variables declaration//GEN-END:variables
}
