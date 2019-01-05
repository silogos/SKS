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
<<<<<<< HEAD
import java.sql.Array;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
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
    
    static String a,b,c;
    ImageIcon imageIcon;
    public Questioner() {
        initComponents();
        imageIcon = new ImageIcon("src/Assets/SKSedit.png");
        setIconImage(imageIcon.getImage());
        QuestionController qc = new QuestionController();
        QuestionList = qc.getList();
        System.out.println(QuestionList.get(0).getAnswer().toString());
        this.AnswerMostList = new ArrayList<>();
        this.AnsweLeastList = new ArrayList<>();
        this.idx = 0;
        this.selectedMost = -1;
        this.selectedLeast = -1;
        this.setAnswer();
        ActionListener acl = new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
               a=jLabel_runningtext.getText();
               b=a.substring(0, 2);
               c=a.substring(2, a.length());
               jLabel_runningtext.setText(c+b);
            }
        };new javax.swing.Timer(100, acl).start();
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
            CharacteristicModul mostValue = QuestionList.get(this.idx).getAnswer().get(this.selectedMost);
            CharacteristicModul leastValue = QuestionList.get(this.idx).getAnswer().get(this.selectedLeast);
            System.out.println(mostValue.getText());
            System.out.println(leastValue.getText());
            this.AnswerMostList.add(mostValue);
            this.AnsweLeastList.add(leastValue);
            this.clearAnswer();
            this.resetRadioBox(0);
            this.resetRadioBox(1);
            if(this.idx < this.QuestionList.size() - 1){
                this.idx = this.idx + 1;
                this.setAnswer(); 
            } else {
                QuestionController qc = new QuestionController();
                qc.insertAnswers(AnswerMostList, AnsweLeastList);
                System.out.println("selesai");
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
<<<<<<< HEAD
=======
        jPanel2 = new javax.swing.JPanel();
        jPanel_close = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
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
<<<<<<< HEAD
        answerNoD = new javax.swing.JRadioButton();
        answerYesD = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
=======
        jPanel_lanjut = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel_runningtext = new javax.swing.JLabel();
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

<<<<<<< HEAD
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel1.setText("MOST");
=======
        jPanel2.setBackground(new java.awt.Color(124, 111, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_closeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel_closeLayout.setVerticalGroup(
            jPanel_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(jPanel_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_closeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 11, -1, -1));

        jPanel11.setBackground(new java.awt.Color(124, 111, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8-personal-trainer-50.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Survey Kepribadian Seseorang");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(8, 8, 8))
        );

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 410, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Anda adalah orang seperti apa ?");
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f

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
<<<<<<< HEAD
        jPanel14.add(answerNoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 0, -1, 60));
=======

        answerTextA.setText("jLabel2");
        answerTextA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answerTextA, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerYesA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerNoA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(answerYesA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answerNoA)
                .addGap(12, 12, 12))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(answerTextA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f

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

<<<<<<< HEAD
        answerTextB.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerTextB.setText("answerB");
        jPanel15.add(answerTextB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 58));
=======
        answerTextB.setText("jLabel2");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answerTextB, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerYesB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerNoB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(answerYesB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answerNoB)
                .addGap(12, 12, 12))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(answerTextB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f

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

<<<<<<< HEAD
        answerTextC.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerTextC.setText("answerC");
        jPanel16.add(answerTextC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 58));
=======
        answerTextC.setText("jLabel2");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answerTextC, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerYesC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerNoC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(answerYesC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answerNoC)
                .addGap(12, 12, 12))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(answerTextC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f

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

<<<<<<< HEAD
        answerYesD.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        answerYesD.setText("Ya");
        answerYesD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerYesDActionPerformed(evt);
=======
        answerTextD.setText("jLabel2");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answerTextD, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerYesD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerNoD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(answerYesD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(answerNoD)
                .addGap(12, 12, 12))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(answerTextD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel6.add(jPanel17);

        jPanel_lanjut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_lanjut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_lanjutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_lanjutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_lanjutMouseExited(evt);
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
            }
        });
        jPanel17.add(answerYesD, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 60, 60));

        jPanel6.add(jPanel17);

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel2.setText("<html>Choose one that is most like you,\n<br/>           and one that is least like you</html>");

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel3.setText("least");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Lanjut");

        javax.swing.GroupLayout jPanel_lanjutLayout = new javax.swing.GroupLayout(jPanel_lanjut);
        jPanel_lanjut.setLayout(jPanel_lanjutLayout);
        jPanel_lanjutLayout.setHorizontalGroup(
            jPanel_lanjutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_lanjutLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel_lanjutLayout.setVerticalGroup(
            jPanel_lanjutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_lanjutLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
<<<<<<< HEAD
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
=======
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_lanjut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
=======
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel_lanjut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(124, 111, 255));

        jLabel_runningtext.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_runningtext.setText("                                                              Pilihlah jawaban yang dirasa benar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_runningtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_runningtext)
                .addContainerGap(19, Short.MAX_VALUE))
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
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
<<<<<<< HEAD
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(next)
                .addContainerGap())
=======
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(10, 10, 10))
=======
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
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
<<<<<<< HEAD
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        this.nextQuestion();
    }//GEN-LAST:event_nextActionPerformed

    private void answerYesDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesDActionPerformed
=======
    private void jPanel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_closeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_closeMouseExited

    private void jPanel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_closeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_closeMouseEntered

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
    
    private void answerYesAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesAActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_answerYesAActionPerformed

    private void answerNoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoAActionPerformed
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
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

    private void jPanel_lanjutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_lanjutMouseClicked
        // TODO add your handling code here:
        this.nextQuestion();
    }//GEN-LAST:event_jPanel_lanjutMouseClicked

    private void jPanel_lanjutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_lanjutMouseEntered
        // TODO add your handling code here:
        SetColour(jPanel_lanjut);
    }//GEN-LAST:event_jPanel_lanjutMouseEntered

    private void jPanel_lanjutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_lanjutMouseExited
        // TODO add your handling code here:
        resetColour(jPanel_lanjut);
    }//GEN-LAST:event_jPanel_lanjutMouseExited

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
<<<<<<< HEAD
=======
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_runningtext;
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
<<<<<<< HEAD
    private javax.swing.JButton next;
=======
    private javax.swing.JPanel jPanel_close;
    private javax.swing.JPanel jPanel_lanjut;
>>>>>>> 8de317d68723c368854c291f60014a26c9c7057f
    // End of variables declaration//GEN-END:variables

    private void elseif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
