/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Start;

import Moduls.User.UserController;
import Views.Questioner.Questioner;
/**
 *
 * @author ThinkPad
 */
public class StartView extends javax.swing.JFrame {

    /**
     * Creates new form StartView
     */
    public StartView() {
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

        label_nama = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        mulai = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nama.setBackground(new java.awt.Color(255, 255, 255));
        label_nama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_nama.setForeground(new java.awt.Color(255, 255, 255));
        label_nama.setText("Masukan Nama Anda");
        getContentPane().add(label_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 190, 40));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 290, 40));

        mulai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mulai.setText("Mulai");
        mulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulaiActionPerformed(evt);
            }
        });
        getContentPane().add(mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 120, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Choose people who lift you uped.png"))); // NOI18N
        background.setText("jLabel3");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulaiActionPerformed
        UserController cu = new UserController();
        String namas = nama.getText();
        if(cu.create(namas)) {
            Questioner questioner = new Questioner();
            questioner.show();
            this.dispose();
        }
    }//GEN-LAST:event_mulaiActionPerformed

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
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel label_nama;
    private javax.swing.JButton mulai;
    private javax.swing.JTextField nama;
    // End of variables declaration//GEN-END:variables
}
