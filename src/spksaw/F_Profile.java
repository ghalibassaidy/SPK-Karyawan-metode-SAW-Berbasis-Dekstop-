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
/**
 *
 * @author opank
 */
public class F_Profile extends javax.swing.JInternalFrame {
String id = session.getid();
String uname = session.getuname();
String pass = session.getpass();
String akses = session.getakses();
    /**
     * Creates new form F_dPro
     */
    public F_Profile() {
        initComponents();
        
        txtid.setEnabled(false);
        jButton9.setVisible(false);
        txtpass1.setVisible(false);
        
       txtid.setText(id);
       txtuname.setText(uname);
       txtpass.setText(pass);
       lakses.setSelectedItem(akses);
       if(akses.equalsIgnoreCase("User")){
           lakses.setEnabled(false);
           AU.setVisible(false);
           TU.setVisible(false);
         }else{
            System.out.print("admin");
         }
    }
private void autono(){
         try {
            koneksi.getKoneksi();
            String sql ="select * from user order by id_user desc";
            Statement stat = koneksi.getKoneksi().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                int Not = rs.getInt("id_user")+1;
               txtid.setText(Integer.toString(Not));
            } else {
                
              txtid.setText("1");
            }
            
           }catch(Exception e){
           JOptionPane.showMessageDialog(this, "error"+e);
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

        txtuname = new javax.swing.JTextField();
        BU = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpass1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AU = new javax.swing.JButton();
        TU = new javax.swing.JButton();
        lakses = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BU2 = new javax.swing.JButton();

        setFrameIcon(null);
        getContentPane().setLayout(null);

        txtuname.setBackground(new java.awt.Color(240, 240, 240));
        txtuname.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtuname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtuname);
        txtuname.setBounds(450, 200, 386, 29);

        BU.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530428938436.png"))); // NOI18N
        BU.setText(" Simpan Perubahan");
        BU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUActionPerformed(evt);
            }
        });
        getContentPane().add(BU);
        BU.setBounds(578, 330, 260, 44);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 50));
        jPanel1.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Profile");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(15, 11, 200, 21);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1019, 50);

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/personal.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 190, 128, 128);

        txtpass.setBackground(new java.awt.Color(240, 240, 240));
        txtpass.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtpass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtpass);
        txtpass.setBounds(450, 230, 385, 35);

        jButton9.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530429001320.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(790, 280, 48, 29);

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Password");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(350, 230, 88, 29);

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

        getContentPane().add(jPanel16);
        jPanel16.setBounds(0, 433, 1019, 40);

        jButton8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton8.setText("=>");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(450, 280, 47, 29);

        txtid.setBackground(new java.awt.Color(240, 240, 240));
        txtid.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid);
        txtid.setBounds(450, 150, 200, 38);

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Username");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(350, 200, 92, 29);

        txtpass1.setBackground(new java.awt.Color(240, 240, 240));
        txtpass1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtpass1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass1);
        txtpass1.setBounds(510, 280, 276, 29);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("No");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 160, 25, 29);

        AU.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        AU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1530428806684.png"))); // NOI18N
        AU.setText("Add User");
        AU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUActionPerformed(evt);
            }
        });
        getContentPane().add(AU);
        AU.setBounds(140, 120, 150, 40);

        TU.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        TU.setText("Tambah");
        TU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TUActionPerformed(evt);
            }
        });
        getContentPane().add(TU);
        TU.setBounds(450, 330, 113, 44);

        lakses.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lakses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Akses-", "Admin", "User"}));
        getContentPane().add(lakses);
        lakses.setBounds(670, 150, 162, 44);

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 110, 800, 310);

        BU2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        BU2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LOGOUT.jpeg"))); // NOI18N
        BU2.setText("Log Out");
        BU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BU2ActionPerformed(evt);
            }
        });
        getContentPane().add(BU2);
        BU2.setBounds(780, 70, 150, 40);

        setBounds(0, 0, 1035, 503);
    }// </editor-fold>//GEN-END:initComponents

    private void BUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText();
        String pass = txtpass.getText();
        String nama = txtuname.getText();

        if(txtid.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
            txtid.requestFocus();
        }
        else if(txtpass.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
            txtpass.requestFocus();
        }
        else if(txtuname.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
            txtuname.requestFocus();
        }

        else {
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE user SET user=?, pass=? WHERE id_user=?";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, nama);
                p.setString(2, pass);
                p.setString(3, id);

                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(this,"1 User Terubah, Relogin ! !");

                
                session.setuname(txtuname.getText());
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Peroblem System !","OOPS!"+e, JOptionPane.ERROR_MESSAGE);
            } finally {
            }
        }
    }//GEN-LAST:event_BUActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jButton9.setVisible(false);
        jButton8.setVisible(true);
        String a = txtpass1.getText();
        txtpass.setText(a);
        txtpass1.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        txtpass1.setVisible(true);
        

        String a = txtpass.getText();
        txtpass1.setText(a);
        jButton9.setVisible(true);
        jButton8.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpass1ActionPerformed

    private void AUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUActionPerformed
        // TODO add your handling code here:
         txtid.setText("");txtpass.setText("");
         txtuname.setText("");lakses.setSelectedItem("-Akses-");
         autono();
    }//GEN-LAST:event_AUActionPerformed

    private void BU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BU2ActionPerformed
        // TODO add your handling code here:
        int keluar;
        keluar = JOptionPane.showConfirmDialog(this, "Yakin Ingin Keluar","Peringatan", JOptionPane.YES_NO_OPTION);
        if(keluar== JOptionPane.YES_OPTION){
            System.exit(0);
        }else{

        }
    }//GEN-LAST:event_BU2ActionPerformed

    private void TUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TUActionPerformed
        // TODO add your handling code here:
         String id = txtid.getText();
        String u = txtuname.getText();
        String  pa = txtpass.getText();
        String  a = (String)lakses.getSelectedItem();
        
        if(txtuname.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
            txtuname.requestFocus();
        }
        else if(txtpass.equals("")){
            JOptionPane.showMessageDialog(this, "Data belum lengkap");
          txtpass.requestFocus();

        }
       else if(lakses.equals("-Akses-")){
            JOptionPane.showMessageDialog(this, " Harap Masukan Hak Akses !");
         lakses.requestFocus();

        }
             
       else{
            try {   
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO user VALUES (?,?,?,?)";

                PreparedStatement p = c.prepareStatement(sql);
                
                
                
                p.setString(1, id);
                p.setString(2, u);
                p.setString(3, pa);
                p.setString(4, a);
                
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(this," Ditambah, Silahkan Relogin  !");
               
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,"System Error !"+e);
            } finally {
            }
       }
    }//GEN-LAST:event_TUActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AU;
    public javax.swing.JButton BU;
    public javax.swing.JButton BU2;
    public javax.swing.JButton TU;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JComboBox<String> lakses;
    private javax.swing.JLabel lbl;
    public javax.swing.JTextField txtid;
    public javax.swing.JPasswordField txtpass;
    public javax.swing.JTextField txtpass1;
    public javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
