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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Acer
 */
public class F_Bobot extends javax.swing.JInternalFrame {
    Connection con;
    Statement stt;
    

    /**
     * Creates new form Surat_Keluar
     */
    public F_Bobot() {
        initComponents();
       
        T_bobot();
        T_nm_kriteria();
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
    
public void T_bobot(){
    
  try{
      Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
      String sql = "select * from tbl_bobot";
      
      ResultSet rs = stt.executeQuery(sql);
      while(rs.next()){
   
     txtc1.setText(rs.getString("b1"));
      txtc2.setText(rs.getString("b2"));
       txtc3.setText(rs.getString("b3"));
        txtc4.setText(rs.getString("b4"));
     
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

        jPanel12 = new javax.swing.JPanel();
        lk1 = new javax.swing.JLabel();
        BB1 = new javax.swing.JButton();
        txtc1 = new javax.swing.JTextField();
        txtc2 = new javax.swing.JTextField();
        txtc4 = new javax.swing.JTextField();
        lk4 = new javax.swing.JLabel();
        BU2 = new javax.swing.JButton();
        txtc3 = new javax.swing.JTextField();
        lk3 = new javax.swing.JLabel();
        lk2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();

        setFrameIcon(null);

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lk1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lk1.setText("Absensi");

        BB1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530429001320.png"))); // NOI18N
        BB1.setText("Ubah ke Default");
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
        lk4.setText("Rekomendasi");

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
        lk3.setText("Inisiatif");

        lk2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lk2.setText("Kerjasama");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Nilai Bobot pada :");

        jButton10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton10.setText("Refresh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton11.setText("Edit Nama Kriteria");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtc2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lk1)
                                        .addComponent(lk2))
                                    .addGap(187, 187, 187))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(txtc1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(73, 73, 73)))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lk4)
                                .addComponent(lk3)
                                .addComponent(txtc3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtc4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                            .addComponent(BB1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BU2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1)))
                .addGap(52, 52, 52))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(lk1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtc1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(lk3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtc3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lk2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lk4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtc2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtc4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BB1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BU2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setPreferredSize(new java.awt.Dimension(881, 50));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data Nilai Bobot");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));

        lbl.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(51, 51, 51));
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl.setText("Youtube Channel => Irfan Setiawan");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(661, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BB1ActionPerformed
        // TODO add your handling code here:
        T_bobot();
    }//GEN-LAST:event_BB1ActionPerformed

    private void BU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BU2ActionPerformed
        // TODO add your handling code here:
        
        String  C1 = txtc1.getText();
        String  C2 = txtc2.getText();
        String  C3 = txtc3.getText();
        String  C4 = txtc4.getText();
       if(txtc1.equals("")){
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
                int a = 0;
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE tbl_bobot set b1=?, b2=?, b3=?, b4=? WHERE no=?";

                PreparedStatement p = c.prepareStatement(sql);

                p.setInt(5, a);
                p.setString(1, C1);
                p.setString(2, C2);
                p.setString(3, C3);
                p.setString(4, C4);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(this," Terubah!");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,"System Error !"+e);
            } finally {
            }
        }
    }//GEN-LAST:event_BU2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
       T_nm_kriteria();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        new Form_Nm_Kriteria().setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BB1;
    public javax.swing.JButton BU2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lk1;
    private javax.swing.JLabel lk2;
    private javax.swing.JLabel lk3;
    private javax.swing.JLabel lk4;
    public javax.swing.JTextField txtc1;
    public javax.swing.JTextField txtc2;
    public javax.swing.JTextField txtc3;
    public javax.swing.JTextField txtc4;
    // End of variables declaration//GEN-END:variables
}
