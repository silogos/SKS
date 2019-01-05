/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Questioner;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Moduls.Question.*;
import Moduls.Characteristic.*;
import Views.Result.Result;
import java.sql.Array;
import java.util.Arrays;
import javax.swing.JRadioButton;
import libs.Session;

/**
 *
 * @author Kohar
 */
public class Questioner extends javax.swing.JFrame {

    /**
     * Creates new form Start
     */
    
    private final ArrayList<QuestionModul> QuestionList;
    private ArrayList<CharacteristicModul> AnswerMostList;
    private ArrayList<CharacteristicModul> AnsweLeastList;
    private Integer idx, selectedMost, selectedLeast;
    
    public Questioner() {
        initComponents();
        QuestionController qc = new QuestionController();
        QuestionList = qc.getList();
        System.out.println(QuestionList.get(0).getAnswer().toString());
        this.AnswerMostList = new ArrayList<>();
        this.AnsweLeastList = new ArrayList<>();
        this.idx = 0;
        this.selectedMost = -1;
        this.selectedLeast = -1;
        this.setAnswer();
    }
    
    public void setAnswer() {
        QuestionModul qm = QuestionList.get(this.idx);        
        ArrayList<CharacteristicModul> answer_list = qm.getAnswer();
        CharacteristicModul answer1 = answer_list.get(0);
        answerTextA.setText("<html>"+answer1.getText()+"</html>");
        CharacteristicModul answer2 = answer_list.get(1);
        answerTextB.setText("<html>"+answer2.getText()+"</html>");
        CharacteristicModul answer3 = answer_list.get(2);
        answerTextC.setText("<html>"+answer3.getText()+"</html>");
        CharacteristicModul answer4 = answer_list.get(3);
        answerTextD.setText("<html>"+answer4.getText()+"</html>");
    }
    
    public boolean emptyAnswer() {
        return this.selectedMost == -1 || this.selectedLeast == -1;
    }
    
    public void clearAnswer() {
        this.selectedMost = -1;
        this.selectedLeast = -1;
    }
    
    public void answer(Integer type, Integer index) {
        // type 0: AnswerYes; 1: AnswerNo;
        if(type == 0) {
            selectedMost = index;
            setRadioBox(0);
        } else {
            selectedLeast = index;
            setRadioBox(1);
        }
    }
    
    public void resetRadioBox(Integer type) {
        if(type == 0) {
            answerYesA.setSelected(false);
            answerYesB.setSelected(false);
            answerYesC.setSelected(false);
            answerYesD.setSelected(false);
        } else {
            answerNoA.setSelected(false);
            answerNoB.setSelected(false);
            answerNoC.setSelected(false);
            answerNoD.setSelected(false);
        }
    }
    
    public void setRadioBox(Integer type) {
        this.resetRadioBox(type);
        if(type == 0) {    
            if(selectedMost == 0) {
                answerYesA.setSelected(true);
                answerNoA.setSelected(false);
            } else if (selectedMost == 1) {
                answerYesB.setSelected(true);
                answerNoB.setSelected(false);
            } else if (selectedMost == 2) {
                answerYesC.setSelected(true);
                answerNoC.setSelected(false);
            } else if (selectedMost == 3) {
                answerYesD.setSelected(true);
                answerNoD.setSelected(false);
            }
        } else {
            if(selectedLeast == 0) {
                answerYesA.setSelected(false);
                answerNoA.setSelected(true);
            } else if (selectedLeast == 1) {
                answerYesB.setSelected(false);
                answerNoB.setSelected(true);
            } else if (selectedLeast == 2) {
                answerYesC.setSelected(false);
                answerNoC.setSelected(true);
            } else if (selectedLeast == 3) {
                answerYesD.setSelected(false);
                answerNoD.setSelected(true);
            }
        }
    }
    
    public void nextQuestion() {
        System.out.println(this.idx + " < " + this.QuestionList.size());
        if(this.emptyAnswer()){
            JOptionPane.showMessageDialog(rootPane, "Pilih dahulu jawaban");
        } else {
            if(this.idx < this.QuestionList.size() - 1){
                CharacteristicModul mostValue = QuestionList.get(this.idx).getAnswer().get(this.selectedMost);
                CharacteristicModul leastValue = QuestionList.get(this.idx).getAnswer().get(this.selectedLeast);
                System.out.println(mostValue.getText());
                System.out.println(leastValue.getText());
                this.AnswerMostList.add(mostValue);
                this.AnsweLeastList.add(leastValue);
                this.clearAnswer();
                this.resetRadioBox(0);
                this.resetRadioBox(1);
                this.idx = this.idx + 1;
                this.setAnswer(); 
            } else {
                QuestionController qc = new QuestionController();
                qc.insertAnswers(AnswerMostList, AnsweLeastList);
                System.out.println("selesai");
                Result rs = new Result();
                rs.setVisible(true);
                this.dispose();
            }
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        answerTextA = new javax.swing.JLabel();
        answerYesA = new javax.swing.JRadioButton();
        answerNoA = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        answerYesB = new javax.swing.JRadioButton();
        answerNoB = new javax.swing.JRadioButton();
        answerTextB = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        answerYesC = new javax.swing.JRadioButton();
        answerNoC = new javax.swing.JRadioButton();
        answerTextC = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        answerTextD = new javax.swing.JLabel();
        answerNoD = new javax.swing.JRadioButton();
        answerYesD = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel1.setText("MOST");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 90));
        jPanel6.setLayout(new java.awt.GridLayout(4, 1, 10, 3));

        jPanel14.setPreferredSize(new java.awt.Dimension(240, 90));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answerTextA.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerTextA.setText("answerA");
        answerTextA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        answerTextA.setMaximumSize(new java.awt.Dimension(100, 14));
        answerTextA.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel14.add(answerTextA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 60));

        answerYesA.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerYesA.setText("Ya");
        answerYesA.setMaximumSize(new java.awt.Dimension(60, 27));
        answerYesA.setMinimumSize(new java.awt.Dimension(20, 27));
        answerYesA.setPreferredSize(new java.awt.Dimension(20, 20));
        answerYesA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerYesAActionPerformed(evt);
            }
        });
        jPanel14.add(answerYesA, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 70, 60));

        answerNoA.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerNoA.setText("Tidak");
        answerNoA.setPreferredSize(new java.awt.Dimension(100, 27));
        answerNoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerNoAActionPerformed(evt);
            }
        });
        jPanel14.add(answerNoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 0, -1, 60));

        jPanel6.add(jPanel14);

        jPanel15.setPreferredSize(new java.awt.Dimension(240, 90));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answerYesB.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerYesB.setText("Ya");
        answerYesB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerYesBActionPerformed(evt);
            }
        });
        jPanel15.add(answerYesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 60, 60));

        answerNoB.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerNoB.setText("Tidak");
        answerNoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerNoBActionPerformed(evt);
            }
        });
        jPanel15.add(answerNoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 100, 60));

        answerTextB.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerTextB.setText("answerB");
        jPanel15.add(answerTextB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 58));

        jPanel6.add(jPanel15);

        jPanel16.setPreferredSize(new java.awt.Dimension(240, 90));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answerYesC.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerYesC.setText("Ya");
        answerYesC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerYesCActionPerformed(evt);
            }
        });
        jPanel16.add(answerYesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 60, 60));

        answerNoC.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerNoC.setText("Tidak");
        answerNoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerNoCActionPerformed(evt);
            }
        });
        jPanel16.add(answerNoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 100, 60));

        answerTextC.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerTextC.setText("answerC");
        jPanel16.add(answerTextC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 58));

        jPanel6.add(jPanel16);

        jPanel17.setPreferredSize(new java.awt.Dimension(240, 90));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        answerTextD.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerTextD.setText("answerD");
        jPanel17.add(answerTextD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 58));

        answerNoD.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerNoD.setText("TIDAK");
        answerNoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerNoDActionPerformed(evt);
            }
        });
        jPanel17.add(answerNoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 80, 60));

        answerYesD.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerYesD.setText("Ya");
        answerYesD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerYesDActionPerformed(evt);
            }
        });
        jPanel17.add(answerYesD, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 60, 60));

        jPanel6.add(jPanel17);

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel2.setText("<html>Choose one that is most like you,\n<br/>           and one that is least like you</html>");

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel3.setText("least");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        next.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        next.setText("next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(next)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        this.nextQuestion();
    }//GEN-LAST:event_nextActionPerformed

    private void answerYesDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesDActionPerformed
        // TODO add your handling code here:
        this.answer(0,3);
    }//GEN-LAST:event_answerYesDActionPerformed

    private void answerNoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoDActionPerformed
        // TODO add your handling code here:
        this.answer(1,3);
    }//GEN-LAST:event_answerNoDActionPerformed

    private void answerNoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoCActionPerformed
        // TODO add your handling code here:
        this.answer(1,2);
    }//GEN-LAST:event_answerNoCActionPerformed

    private void answerYesCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesCActionPerformed
        // TODO add your handling code here:
        this.answer(0,2);
    }//GEN-LAST:event_answerYesCActionPerformed

    private void answerNoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoBActionPerformed
        // TODO add your handling code here:
        this.answer(1,1);
    }//GEN-LAST:event_answerNoBActionPerformed

    private void answerYesBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesBActionPerformed
        // TODO add your handling code here:
        this.answer(0,1);
    }//GEN-LAST:event_answerYesBActionPerformed

    private void answerNoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoAActionPerformed
        // TODO add your handling code here:
        this.answer(1,0);
    }//GEN-LAST:event_answerNoAActionPerformed

    private void answerYesAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesAActionPerformed
        // TODO add your handling code here:
        this.answer(0,0);
    }//GEN-LAST:event_answerYesAActionPerformed

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
            java.util.logging.Logger.getLogger(Questioner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Questioner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Questioner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Questioner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Questioner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton answerNoA;
    private javax.swing.JRadioButton answerNoB;
    private javax.swing.JRadioButton answerNoC;
    private javax.swing.JRadioButton answerNoD;
    private javax.swing.JLabel answerTextA;
    private javax.swing.JLabel answerTextB;
    private javax.swing.JLabel answerTextC;
    private javax.swing.JLabel answerTextD;
    private javax.swing.JRadioButton answerYesA;
    private javax.swing.JRadioButton answerYesB;
    private javax.swing.JRadioButton answerYesC;
    private javax.swing.JRadioButton answerYesD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables

    private void elseif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
