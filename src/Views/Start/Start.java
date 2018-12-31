/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Start;

import Views.Admin.Login;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Moduls.User.UserController;
import Views.Questioner.Questioner;
/**
 *
 * @author Kohar
 */
public class Start extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    ImageIcon imageIcon;
      public Start() {
        initComponents();
        imageIcon = new ImageIcon("src/AI/SKSedit.png");
        setIconImage(imageIcon.getImage());
       
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Masukan Nama Anda");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 190, 30));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 290, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Mulai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 120, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Choose people who lift you uped.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //   // TODO add your handling code here:
        ControllerUser cu = new ControllerUser();
        String namas = nama.getText();
        if(cu.create(namas)) {;
            Pertanyaan pertanyaan = new Pertanyaan();
            pertanyaan.show();
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void SetColour (JPanel panel){
        panel.setBackground(new java.awt.Color(153,153,255));
    }
    public void resetColour(JPanel panel){
        panel.setBackground(new java.awt.Color(255,255,255));
    }
    
    public void setwarna (JPanel panel){
        panel.setBackground(new java.awt.Color(255,255,255));
    }
    public void resetwarna(JPanel panel){
        panel.setBackground(new java.awt.Color(153,153,255));
    }
    
     public void setwarnaclose (JPanel panel){
         panel.setBackground(new java.awt.Color(153,153,255));
       
    }
    public void resetwarnacolose(JPanel panel){
         panel.setBackground(new java.awt.Color(255,255,255));
    }
   
    
<<<<<<< HEAD
    private void jPanel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_closeMouseEntered
        // TODO add your handling code here:
        resetwarnacolose(jPanel_close);
    }//GEN-LAST:event_jPanel_closeMouseEntered

    private void jPanel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_closeMouseExited
        // TODO add your handling code here:
        setwarnaclose(jPanel_close);
    }//GEN-LAST:event_jPanel_closeMouseExited

    private void jPanel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_closeMouseClicked
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(this,
                "Konfirmasi Keluar Aplikasi",
                "Yakin untuk keluar dari program",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                
          
        if (confirm == JOptionPane.YES_OPTION) 
           System.exit(0);
           ;            
               
       
    }//GEN-LAST:event_jPanel_closeMouseClicked

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void jPanel_mulaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseReleased
        // TODO add your handling code here:
        SetColour(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMouseReleased

    private void jPanel_mulaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMousePressed
        // TODO add your handling code here:
        resetColour(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMousePressed

    private void jPanel_mulaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseExited
        // TODO add your handling code here:
        SetColour(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMouseExited

    private void jPanel_mulaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseEntered
        // TODO add your handling code here:
        resetColour(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMouseEntered

    private void jPanel_mulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseClicked
        // TODO add your handling code here:
        UserController cu = new UserController();
        String namas = nama.getText();
        if(cu.create(namas)) {;
            Questioner pertanyaan = new Questioner();
            pertanyaan.show();
            this.dispose();
        }
    }//GEN-LAST:event_jPanel_mulaiMouseClicked

=======
>>>>>>> a969dcc66720069460476dbb7d8e96ed94858414
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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nama;
    // End of variables declaration//GEN-END:variables
}
