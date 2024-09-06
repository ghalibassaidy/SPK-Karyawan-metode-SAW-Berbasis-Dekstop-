
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
public class F_Perhitungan extends javax.swing.JInternalFrame {
 String id = session.getid();
    Connection con;
    Statement stt;
    DefaultTableModel tb2;
    
DefaultTableModel tb3;

    /**
     * Creates new form Surat_Keluar
     */
    public F_Perhitungan() {
        initComponents();
        tanggalotomatis();
    }
    
     public void tanggalotomatis(){
    Date skrg= new Date();
    SimpleDateFormat format= new SimpleDateFormat("MMMMM");
    SimpleDateFormat format2= new SimpleDateFormat("yyyy");
   
    bln.setText(format.format(skrg));
     thn.setText(format2.format(skrg));
    
}
    
  public void tabelmodelnormalisasi(){
       tb2 =new DefaultTableModel();
       tb2.addColumn("Nama");
       tb2.addColumn("Kreteria 1");
       tb2.addColumn("Kreteria 2");
       tb2.addColumn("Kreteria 3");
       tb2.addColumn("Kreteria 4");
       TNO.setModel(tb2);
       }
public  void normalisasi(){
       LinkedList max=new LinkedList();
       LinkedList mm=new LinkedList();
   try {
           
         Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
         ResultSet res = stt.executeQuery("select max(C1),"+ 
	"max(C2), "+
	"max(C3), "+
	"min(C4)"+
	"from "+
	"tbl_kriteria ");
        while (res.next()){
                    max.add(res.getString(1));
                    max.add(res.getString(2));
                    max.add(res.getString(3));
                    max.add(res.getString(4));
                } 
        ResultSet res2 = stt.executeQuery("select *"+
	"from "+
	"tbl_kriteria ");
        tabelmodelnormalisasi();
        while (res2.next()){
                          tb2.addRow(new Object[]{
                               res2.getString(1),
                              (res2.getFloat(2)/Float.valueOf(max.get(0).toString())),
                              (res2.getFloat(3)/Float.valueOf(max.get(1).toString())),
                              (res2.getFloat(4)/Float.valueOf(max.get(2).toString())),
                              (Float.valueOf(max.get(3).toString())/res2.getFloat(5))});
                          
        }  
       
        JOptionPane.showMessageDialog(this, "Telah di Normalisasi !");
           } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex);
        }   
   
}

   public void tabelmodelPERINGKAT(){
        try {
            tanggalotomatis();
               Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
            tb3 =new DefaultTableModel();
            tb3.addColumn("NAMA");
            tb3.addColumn("NILAI ");
            tb3.addColumn("RANGKING");
            TPER.setModel(tb3);
            tb3.getDataVector().removeAllElements();
            tb3.fireTableDataChanged();
         ResultSet res = stt.executeQuery("select * from tbl_peringkat order by nilai desc");
             while (res.next()){
                         tb3.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)}); 
                     }
        } catch (SQLException ex) {
            Logger.getLogger(F_Perhitungan.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   public void cariperingkat(){
        try {
               Connection con = koneksi.getKoneksi();
      Statement stt = con.createStatement();
       LinkedList mm=new LinkedList();
            ResultSet res3 = stt.executeQuery("select * from tbl_bobot");
               tabelmodelPERINGKAT();
               while (res3.next()){
                           mm.add(res3.getString(1));
                           mm.add(res3.getString(2));
                           mm.add(res3.getString(3));
                           mm.add(res3.getString(4));
               }
            for (int t = 0; t < TNO.getRowCount(); t++) {
              
            String sql = "delete from tbl_peringkat WHERE Nama= Nama";
              stt.executeUpdate(sql);
            }
            for (int x = 0; x < TNO.getRowCount(); x++) {
               double r1;
               double r2;
               double r3;
               double r4;
               double w;
                r1 = (Float.valueOf(TNO.getValueAt(x, 1).toString())*Float.valueOf(mm.get(0).toString()));
            r2=(Float.valueOf(TNO.getValueAt(x, 2).toString())*Float.valueOf(mm.get(1).toString()));
                r3=(Float.valueOf(TNO.getValueAt(x, 3).toString())*Float.valueOf(mm.get(2).toString()));
            r4=(Float.valueOf(TNO.getValueAt(x, 4).toString())*Float.valueOf(mm.get(3).toString()));
            w=r1+r2+r3+r4;
            String sql = "insert into tbl_peringkat (nama,nilai) values"+
             "('"+TNO.getValueAt(x, 0).toString()+"', "+
             "'"+w+"')";
             stt.executeUpdate(sql);
             
             
               ///////////////////DELETED
                  PreparedStatement pw = con.prepareStatement("DELETE FROM tbl_periode WHERE bulan = '"+bln.getText()+"' AND tahun = '"+thn.getText()+"'");
               
                    pw.executeUpdate();
            }
            
             String qu = "select * from tbl_peringkat order by nilai desc";
             
      ResultSet res4  = stt.executeQuery(qu);
      int a =0;
      while(res4.next()){
          
           a=a+1;
           //////////////////UPDATED
      String ra = "UPDATE tbl_peringkat set rank=?  WHERE nama=?";
        
                PreparedStatement pr = con.prepareStatement(ra);
                pr.setInt(1, a);
                pr.setString(2, res4.getString("Nama"));
                pr.executeUpdate();
                
              
         /////////////INSERTED
                String p = "insert into tbl_periode values(?,?,?,?,?)";
        
                PreparedStatement ps = con.prepareStatement(p);
                ps.setString(1, res4.getString("Nama"));
                 ps.setString(2, res4.getString("Nilai"));
                  ps.setInt(3, a);
                  ps.setString(4, bln.getText());
                   ps.setString(5, thn.getText());
                     if(ps.executeUpdate() == 1){
                          
                    }else{
                                
                  JOptionPane.showMessageDialog(this, "Gagal Disimpan !");
                
                     } 
        
      }
            JOptionPane.showMessageDialog(this, "Data Periode : "+bln.getText()+","+thn.getText()+" Diperbarui !");
          
            tabelmodelPERINGKAT();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Kesalahan Cari Peringkat "+ex);
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
        TNO = new javax.swing.JTable();
        L_dis1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPER = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        L_dis2 = new javax.swing.JLabel();
        L_dis3 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        bln = new javax.swing.JLabel();
        thn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();

        setFrameIcon(null);

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        TNO.setModel(new javax.swing.table.DefaultTableModel(
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
        TNO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TNOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TNO);

        L_dis1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 14)); // NOI18N
        L_dis1.setForeground(new java.awt.Color(51, 51, 51));
        L_dis1.setText(" * Lakukan Normalisasi Sebelum Menentukan Peringkat ");
        L_dis1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L_dis1KeyReleased(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton8.setText("Lakukan Normalisasi");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        TPER.setModel(new javax.swing.table.DefaultTableModel(
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
        TPER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPERMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TPER);

        jButton9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton9.setText("Tentukan Peringkat");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        L_dis2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        L_dis2.setForeground(new java.awt.Color(51, 51, 51));
        L_dis2.setText("Table Normalisasi");
        L_dis2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L_dis2KeyReleased(evt);
            }
        });

        L_dis3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        L_dis3.setForeground(new java.awt.Color(51, 51, 51));
        L_dis3.setText("Table Peringkat");
        L_dis3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L_dis3KeyReleased(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton10.setText("Print Cepat");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        bln.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        bln.setForeground(new java.awt.Color(51, 51, 51));
        bln.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bln.setText("Bulan");
        bln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                blnKeyReleased(evt);
            }
        });

        thn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        thn.setForeground(new java.awt.Color(51, 51, 51));
        thn.setText("Tahun");
        thn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                thnKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(L_dis1)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addComponent(bln, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addComponent(L_dis2)
                        .addGap(64, 64, 64)
                        .addComponent(jButton8)
                        .addGap(170, 170, 170)
                        .addComponent(L_dis3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(L_dis2)
                    .addComponent(L_dis3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bln)
                        .addComponent(thn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(L_dis1))
        );

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setPreferredSize(new java.awt.Dimension(881, 50));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Perhitungan");

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
                .addContainerGap(662, Short.MAX_VALUE))
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TNOMouseClicked
        // TODO add your handling code here:
        Form_Normalisasi ba = new Form_Normalisasi();

        int index = TNO.getSelectedRow();
        TableModel tm = TNO.getModel();

           String nm = tm.getValueAt(index, 0).toString();
        String c1 = tm.getValueAt(index, 1).toString();
        String c2 = tm.getValueAt(index, 2).toString();
        String c3 = tm.getValueAt(index, 3).toString();
        String c4 = tm.getValueAt(index, 4).toString();
      
        ba.setVisible(true);
        ba.pack();
        ba.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        ba.txtnm.setText(nm);
        ba.txtc1.setText(c1);
        ba.txtc2.setText(c2);
        ba.txtc3.setText(c3);
        ba.txtc4.setText(c4);
       
    }//GEN-LAST:event_TNOMouseClicked

    private void L_dis1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_dis1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_L_dis1KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        normalisasi();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void TPERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPERMouseClicked
        // TODO add your handling code here:
        Detail_Peringkat ba = new  Detail_Peringkat ();

        int index = TPER.getSelectedRow();
        TableModel tm = TPER.getModel();

           String nm = tm.getValueAt(index, 0).toString();
        String c1 = tm.getValueAt(index, 2).toString();
        String c2 = tm.getValueAt(index, 1).toString();
        
      
        ba.setVisible(true);
        ba.pack();
        ba.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        ba.txtnm.setText(nm);
        ba.txtc1.setText(c1);
        ba.txtc2.setText(c2);
        
    }//GEN-LAST:event_TPERMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
      
            cariperingkat();
       
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void L_dis2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_dis2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_L_dis2KeyReleased

    private void L_dis3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_dis3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_L_dis3KeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
     try{
            String test = "src\\Laporan\\Periode.jasper";
            HashMap has = new  HashMap();
            has.put("bulan", bln.getText());
            has.put("tahun", thn.getText());
            JasperPrint jp = JasperFillManager.fillReport(test, has, koneksi.getKoneksi());
            JasperViewer.viewReport(jp,false);

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"gagal"+e);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void blnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_blnKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_blnKeyReleased

    private void thnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thnKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_thnKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel L_dis1;
    public javax.swing.JLabel L_dis2;
    public javax.swing.JLabel L_dis3;
    private javax.swing.JTable TNO;
    private javax.swing.JTable TPER;
    public javax.swing.JLabel bln;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    public javax.swing.JLabel thn;
    // End of variables declaration//GEN-END:variables
}
