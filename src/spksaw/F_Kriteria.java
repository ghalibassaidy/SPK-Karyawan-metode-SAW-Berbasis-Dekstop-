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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Acer
 */
public class F_Kriteria extends javax.swing.JInternalFrame {
    Connection con;
    Statement stt;
    

    /**
     * Creates new form Surat_Keluar
     */
    public F_Kriteria() {
        initComponents();
       
         T_kriteria();

    }
public void T_kriteria(){
    DefaultTableModel tm = new DefaultTableModel();
       tm.addColumn("Nama");
       tm.addColumn("Kreteria 1");
       tm.addColumn("Kreteria 2");
       tm.addColumn("Kreteria 3");
       tm.addColumn("Kreteria 4");
    tm.getDataVector().removeAllElements();
    tm.fireTableDataChanged();
    
  try{
      Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
      String sql = "select * from tbl_kriteria";
      
      ResultSet rs = stt.executeQuery(sql);
      while(rs.next()){
     Object[] o = new Object[5];
      o[0] = rs.getString("R");
      o[1] = rs.getString("C1");
      o[2] = rs.getString("C2");
      o[3] = rs.getString("C3");
      o[4] = rs.getString("C4");
      tm.addRow(o);
      TKR.setModel(tm);
      int b = TKR.getRowCount();
      sesiangka.sets1(Integer.toString(b));
      L_dis.setText("Menampilkan 1 - "+Integer.toString(b)+" dari "+b+" data");
      }
     rs.close();
     stt.close();
  
  }catch(Exception e){
     JOptionPane.showMessageDialog(this, "Warning "+e);
  }
}
    
        
        
      
public void Cari_kriteria(){
    DefaultTableModel tm = new DefaultTableModel();
    tm.addColumn("Nama");
       tm.addColumn("Kreteria 1");
       tm.addColumn("Kreteria 2");
       tm.addColumn("Kreteria 3");
       tm.addColumn("Kreteria 4");
    tm.getDataVector().removeAllElements();
    tm.fireTableDataChanged();
    
  try{
      Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
      String sql = "select * from tbl_kriteria where R = '"+txtpb.getText()+"'";
      
      ResultSet rs = stt.executeQuery(sql);
      while(rs.next()){
     Object[] o = new Object[5];
       o[0] = rs.getString("R");
      o[1] = rs.getString("C1");
      o[2] = rs.getString("C2");
      o[3] = rs.getString("C3");
      o[4] = rs.getString("C4");
      tm.addRow(o);
      TKR.setModel(tm);
      int b = TKR.getRowCount();
      String n = sesiangka.gets1();
      L_dis.setText("Menampilkan 1 - "+Integer.toString(b)+" dari "+n+" data");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TKR = new javax.swing.JTable();
        txtpb = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        L_dis = new javax.swing.JLabel();
        L_dis1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        L_dis2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();

        setFrameIcon(null);

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        TKR.setModel(new javax.swing.table.DefaultTableModel(
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
        TKR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TKRMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TKR);

        txtpb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        jButton6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        L_dis.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        L_dis.setForeground(new java.awt.Color(51, 51, 51));
        L_dis.setText("0");
        L_dis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L_disKeyReleased(evt);
            }
        });

        L_dis1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 14)); // NOI18N
        L_dis1.setForeground(new java.awt.Color(51, 51, 51));
        L_dis1.setText(" * Klik Data Pada Table Untuk Mengedit dan Menghapus Data ");
        L_dis1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L_dis1KeyReleased(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton7.setText("Refresh /Seluruh Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        L_dis2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        L_dis2.setForeground(new java.awt.Color(51, 51, 51));
        L_dis2.setText("Tampilkan :");
        L_dis2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L_dis2KeyReleased(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton8.setText("Tambah Data");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"3","5","10","20","50","70","100"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton11.setText("Print Data Awal");
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
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(L_dis2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpb, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(353, 353, 353)
                                        .addComponent(L_dis1))
                                    .addComponent(L_dis, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1)
                        .addComponent(L_dis2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_dis)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(L_dis1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {L_dis2, jButton6, jButton7, jButton8, txtpb});

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setPreferredSize(new java.awt.Dimension(881, 50));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data Kriteria");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void L_disKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_disKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_L_disKeyReleased

    private void TKRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TKRMouseClicked
        // TODO add your handling code here:
        Form_Kriteria ba = new Form_Kriteria();

        int index = TKR.getSelectedRow();
        TableModel tm = TKR.getModel();

        String nm = tm.getValueAt(index, 0).toString();
        String c1 = tm.getValueAt(index, 1).toString();
        String c2 = tm.getValueAt(index, 2).toString();
        String c3 = tm.getValueAt(index, 3).toString();
        String c4 = tm.getValueAt(index, 4).toString();
      
        ba.setVisible(true);
        ba.pack();
        ba.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        ba.txtnm.setText(nm);
        ba.txtnm.setEnabled(false);
       ba.txtc1.setEnabled(true);
       ba.txtc2.setEnabled(true);
       ba.txtc3.setEnabled(true);
       ba.txtc4.setEnabled(true);
        ba.txtc1.setText(c1);
        ba.txtc2.setText(c2);
        ba.txtc3.setText(c3);
        ba.txtc4.setText(c4);
       
       
    }//GEN-LAST:event_TKRMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Cari_kriteria();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void L_dis1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_dis1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_L_dis1KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
       T_kriteria();
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void L_dis2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_dis2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_L_dis2KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         new Newkary().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
  
    DefaultTableModel tm = new DefaultTableModel();
    tm.addColumn("Nama");
       tm.addColumn("Kreteria 1");
       tm.addColumn("Kreteria 2");
       tm.addColumn("Kreteria 3");
       tm.addColumn("Kreteria 4");
    tm.getDataVector().removeAllElements();
    tm.fireTableDataChanged();
    
  try{
      Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
      String sql = "select * from tbl_kriteria limit "+jComboBox1.getSelectedItem();
      
      ResultSet rs = stt.executeQuery(sql);
      while(rs.next()){
     Object[] o = new Object[5];
       o[0] = rs.getString("R");
      o[1] = rs.getString("C1");
      o[2] = rs.getString("C2");
      o[3] = rs.getString("C3");
      o[4] = rs.getString("C4");
      tm.addRow(o);
      TKR.setModel(tm);
      int b = TKR.getRowCount();
     
      L_dis.setText("Menampilkan 1 - "+Integer.toString(b)+" dari "+sesiangka.gets1()+" data");
      }
     rs.close();
     stt.close();
  
  }catch(Exception e){
     JOptionPane.showMessageDialog(this, "Warning "+e);
  }


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         
    try{
        String test = "src\\Laporan\\Awal.jasper";
        JasperPrint jp = JasperFillManager.fillReport(test, null, koneksi.getKoneksi());
        JasperViewer.viewReport(jp,false);
        
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null,"gagal"+e);
    }

    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel L_dis;
    public javax.swing.JLabel L_dis1;
    public javax.swing.JLabel L_dis2;
    private javax.swing.JTable TKR;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    public javax.swing.JTextField txtpb;
    // End of variables declaration//GEN-END:variables
}
