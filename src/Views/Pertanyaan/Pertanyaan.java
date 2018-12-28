/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Pertanyaan;

import Moduls.Pertanyaan.*;
import Views.Admin.Login;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import libs.Session;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Kohar
 */
public class Pertanyaan extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    
    private ControllerPertanyaan cp;
    private ArrayList<ModelJawaban> listJawaban = new ArrayList<>();
    private int index;
    private ImageIcon imageIcon;
    private int jmlPertanyaan;
    
    public Pertanyaan() {
        initComponents();
        imageIcon = new ImageIcon("src/AI/SKSedit.png");
        setIconImage(imageIcon.getImage());
       
        cp = new ControllerPertanyaan();
        cp.getPertanyaan();
        jmlPertanyaan = cp.getTotalPertanyaan();
        this.index = 0;
        this.setPilihan();
    }
    
    public void setPilihan() {
        ModelPertanyaan mp = cp.viewByIndex(this.index);
        ArrayList<ModelPilihan> ampil = mp.getPilihan();
        ModelPilihan pil1 = ampil.get(0);
        pilihan_a.setText(pil1.getJawaban());
        ModelPilihan pil2 = ampil.get(1);
        pilihan_b.setText(pil2.getJawaban());
        ModelPilihan pil3 = ampil.get(2);
        pilihan_c.setText(pil3.getJawaban());
        ModelPilihan pil4 = ampil.get(3);
        pilihan_d.setText(pil4.getJawaban());
    }
    
    public void jawab(int idxPilihan) {
        ModelPertanyaan mp = cp.viewByIndex(this.index);
        ArrayList<ModelPilihan> ampil = mp.getPilihan();
        ModelJawaban mj = new ModelJawaban();
        mj.setUser_id(Session.getID());
        mj.setCharacteristic_id(ampil.get(idxPilihan).getType());
        listJawaban.add(mj);
        nextPertanyaan();
    }
    
    public void nextPertanyaan() {
        System.out.println(this.index + " < " + this.jmlPertanyaan);
        if(this.index < this.jmlPertanyaan - 1){
            this.index = this.index + 1;
            setPilihan(); 
        } else {
            System.out.println("selesai");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel_close = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pilihan_a = new javax.swing.JButton();
        pilihan_b = new javax.swing.JButton();
        pilihan_c = new javax.swing.JButton();
        pilihan_d = new javax.swing.JButton();
        next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(124, 111, 255));

        jPanel_close.setBackground(new java.awt.Color(124, 111, 255));
        jPanel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_closeMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_Multiply_26px_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_closeLayout = new javax.swing.GroupLayout(jPanel_close);
        jPanel_close.setLayout(jPanel_closeLayout);
        jPanel_closeLayout.setHorizontalGroup(
            jPanel_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_closeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel_closeLayout.setVerticalGroup(
            jPanel_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_closeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Survey Kepribadian Seseorang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(151, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(131, 131, 131)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(58, 58, 58)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Anda adalah orang seperti apa ?");

        pilihan_a.setText("A");
        pilihan_a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilihan_aMouseClicked(evt);
            }
        });
        pilihan_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihan_aActionPerformed(evt);
            }
        });

        pilihan_b.setText("B");
        pilihan_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilihan_bMouseClicked(evt);
            }
        });
        pilihan_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihan_bActionPerformed(evt);
            }
        });

        pilihan_c.setText("C");
        pilihan_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilihan_cMouseClicked(evt);
            }
        });
        pilihan_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihan_cActionPerformed(evt);
            }
        });

        pilihan_d.setText("D");
        pilihan_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilihan_dMouseClicked(evt);
            }
        });
        pilihan_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihan_dActionPerformed(evt);
            }
        });

        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pilihan_a)
                    .addComponent(pilihan_c))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pilihan_b)
                    .addComponent(pilihan_d))
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(next)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihan_a)
                    .addComponent(pilihan_b))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(pilihan_c))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(pilihan_d)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }//GEN-LAST:event_jPanel_closeMouseClicked

    private void pilihan_aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pilihan_aMouseClicked
        // TODO add your handling code here:
        jawab(0);
    }//GEN-LAST:event_pilihan_aMouseClicked

    private void pilihan_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihan_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihan_aActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        this.index++;
        this.setPilihan();
    }//GEN-LAST:event_nextActionPerformed

    private void pilihan_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihan_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihan_bActionPerformed

    private void pilihan_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihan_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihan_cActionPerformed

    private void pilihan_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihan_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihan_dActionPerformed

    private void pilihan_bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pilihan_bMouseClicked
        // TODO add your handling code here:
        jawab(1);
    }//GEN-LAST:event_pilihan_bMouseClicked

    private void pilihan_cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pilihan_cMouseClicked
        // TODO add your handling code here:
        jawab(2);
    }//GEN-LAST:event_pilihan_cMouseClicked

    private void pilihan_dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pilihan_dMouseClicked
        // TODO add your handling code here:
        jawab(3);
    }//GEN-LAST:event_pilihan_dMouseClicked

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
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pertanyaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_close;
    private javax.swing.JButton next;
    private javax.swing.JButton pilihan_a;
    private javax.swing.JButton pilihan_b;
    private javax.swing.JButton pilihan_c;
    private javax.swing.JButton pilihan_d;
    // End of variables declaration//GEN-END:variables
}
