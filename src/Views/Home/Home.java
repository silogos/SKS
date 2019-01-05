/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Home;

import Views.Start.Starts;
import Views.Admin.Login;
import Views.Petunjuk.Petunjuk;
import Views.Tentang.Tentang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Kohar
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    ImageIcon imageIcon;
      public Home() {
        initComponents();
         imageIcon = new ImageIcon("src/Assets/SKSedit.png");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_close = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel_mulai = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpanel_petunjuk = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel_tentang = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel_logout = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(124, 111, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Utama");

        jPanel_close.setBackground(new java.awt.Color(124, 111, 255));
        jPanel_close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_mulai.setBackground(new java.awt.Color(124, 111, 255));
        jPanel_mulai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_mulai.setPreferredSize(new java.awt.Dimension(180, 70));
        jPanel_mulai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_mulaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_mulaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_mulaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel_mulaiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel_mulaiMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mulai");

        javax.swing.GroupLayout jPanel_mulaiLayout = new javax.swing.GroupLayout(jPanel_mulai);
        jPanel_mulai.setLayout(jPanel_mulaiLayout);
        jPanel_mulaiLayout.setHorizontalGroup(
            jPanel_mulaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_mulaiLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel_mulaiLayout.setVerticalGroup(
            jPanel_mulaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_mulaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanel_petunjuk.setBackground(new java.awt.Color(124, 111, 255));
        jpanel_petunjuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpanel_petunjuk.setPreferredSize(new java.awt.Dimension(180, 70));
        jpanel_petunjuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanel_petunjukMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpanel_petunjukMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpanel_petunjukMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpanel_petunjukMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jpanel_petunjukMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Petunjuk");

        javax.swing.GroupLayout jpanel_petunjukLayout = new javax.swing.GroupLayout(jpanel_petunjuk);
        jpanel_petunjuk.setLayout(jpanel_petunjukLayout);
        jpanel_petunjukLayout.setHorizontalGroup(
            jpanel_petunjukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_petunjukLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(51, 51, 51))
        );
        jpanel_petunjukLayout.setVerticalGroup(
            jpanel_petunjukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_petunjukLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_tentang.setBackground(new java.awt.Color(124, 111, 255));
        jPanel_tentang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_tentang.setPreferredSize(new java.awt.Dimension(180, 70));
        jPanel_tentang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_tentangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_tentangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_tentangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel_tentangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel_tentangMouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tentang");

        javax.swing.GroupLayout jPanel_tentangLayout = new javax.swing.GroupLayout(jPanel_tentang);
        jPanel_tentang.setLayout(jPanel_tentangLayout);
        jPanel_tentangLayout.setHorizontalGroup(
            jPanel_tentangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_tentangLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(54, 54, 54))
        );
        jPanel_tentangLayout.setVerticalGroup(
            jPanel_tentangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tentangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/yuk-kenali-tipe-kepribadian-kamu-lewat-sensing-1503194 300.png"))); // NOI18N

        jPanel_logout.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_logoutMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_Male_User_26px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_logoutLayout = new javax.swing.GroupLayout(jPanel_logout);
        jPanel_logout.setLayout(jPanel_logoutLayout);
        jPanel_logoutLayout.setHorizontalGroup(
            jPanel_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_logoutLayout.setVerticalGroup(
            jPanel_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_tentang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpanel_petunjuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_petunjuk, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_tentang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGap(5, 5, 5)
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
    public void SetColourmulai (JPanel panel){
        panel.setBackground(new java.awt.Color(153,153,255));
    }
    public void resetColourmulai(JPanel panel){
        panel.setBackground(new java.awt.Color(255,102,102));
    }
    public void SetColourpetunjuk (JPanel panel){
        panel.setBackground(new java.awt.Color(153,153,255));
    }
    public void resetColourpetunjuk(JPanel panel){
        panel.setBackground(new java.awt.Color(255,255,0));
    }
     public void SetColourtentang (JPanel panel){
        panel.setBackground(new java.awt.Color(153,153,255));
    }
    public void resetColourtentang(JPanel panel){
        panel.setBackground(new java.awt.Color(0,255,51));
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
   
    
    private void jPanel_mulaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseEntered
        // TODO add your handling code here:
         resetColourmulai(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMouseEntered

    private void jPanel_mulaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseExited
        // TODO add your handling code here:
        SetColourmulai(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMouseExited

    private void jpanel_petunjukMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel_petunjukMouseEntered
        // TODO add your handling code here:
        resetColourpetunjuk(jpanel_petunjuk);
    }//GEN-LAST:event_jpanel_petunjukMouseEntered

    private void jpanel_petunjukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel_petunjukMouseExited
        // TODO add your handling code here:
        SetColourpetunjuk(jpanel_petunjuk);
    }//GEN-LAST:event_jpanel_petunjukMouseExited

    private void jPanel_tentangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_tentangMouseEntered
        // TODO add your handling code here:
        resetColourtentang(jPanel_tentang);
    }//GEN-LAST:event_jPanel_tentangMouseEntered

    private void jPanel_tentangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_tentangMouseExited
        // TODO add your handling code here:
        SetColourtentang(jPanel_tentang);
    }//GEN-LAST:event_jPanel_tentangMouseExited

    private void jPanel_mulaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMousePressed
        // TODO add your handling code here:
        resetColourtentang(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMousePressed

    private void jPanel_mulaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseReleased
        // TODO add your handling code here:
        SetColour(jPanel_mulai);
    }//GEN-LAST:event_jPanel_mulaiMouseReleased

    private void jpanel_petunjukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel_petunjukMousePressed
        // TODO add your handling code here:
        resetColourpetunjuk(jpanel_petunjuk);
    }//GEN-LAST:event_jpanel_petunjukMousePressed

    private void jpanel_petunjukMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel_petunjukMouseReleased
        // TODO add your handling code here:
        SetColourpetunjuk(jpanel_petunjuk);
    }//GEN-LAST:event_jpanel_petunjukMouseReleased

    private void jPanel_tentangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_tentangMousePressed
        // TODO add your handling code here:
        resetColourtentang(jPanel_tentang);
    }//GEN-LAST:event_jPanel_tentangMousePressed

    private void jPanel_tentangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_tentangMouseReleased
        // TODO add your handling code here:
        SetColourtentang(jPanel_tentang);
    }//GEN-LAST:event_jPanel_tentangMouseReleased

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

    private void jPanel_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_logoutMouseEntered
        // TODO add your handling code here:
         resetwarna(jPanel_logout);
    }//GEN-LAST:event_jPanel_logoutMouseEntered

    private void jPanel_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_logoutMouseExited
        // TODO add your handling code here:
          setwarna(jPanel_logout);
    }//GEN-LAST:event_jPanel_logoutMouseExited

    private void jPanel_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_logoutMouseClicked
        // TODO add your handling code here:
          int confirm = JOptionPane.showConfirmDialog(this,
               "Apakah anda ingin memiliki akses Admin ?",
               "Warning",
                
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                
          
        if (confirm == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
          this.dispose();
          
        }else
            new Login().setVisible(false);
       
       
           
         ;
           
    }//GEN-LAST:event_jPanel_logoutMouseClicked

    private void jPanel_mulaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_mulaiMouseClicked
        // TODO add your handling code here:
        Starts start = new Starts();
        start.show();
        this.dispose();
    }//GEN-LAST:event_jPanel_mulaiMouseClicked

    private void jPanel_tentangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_tentangMouseClicked
        Tentang tentang = new Tentang();
        tentang.show();
        this.dispose();
    }//GEN-LAST:event_jPanel_tentangMouseClicked

    private void jpanel_petunjukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel_petunjukMouseClicked
        // TODO add your handling code here:
        Petunjuk petunjuk = new Petunjuk();
        petunjuk.show();
        this.dispose();
    }//GEN-LAST:event_jpanel_petunjukMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_close;
    private javax.swing.JPanel jPanel_logout;
    private javax.swing.JPanel jPanel_mulai;
    private javax.swing.JPanel jPanel_tentang;
    private javax.swing.JPanel jpanel_petunjuk;
    // End of variables declaration//GEN-END:variables
}
