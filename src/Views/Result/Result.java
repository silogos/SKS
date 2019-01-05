/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Result;

import Moduls.Result.*;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import libs.DBConnect;
import libs.Session;


import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;

/**
 *
 * @author ThinkPad
 */
public class Result extends javax.swing.JFrame {
    public ArrayList<DiscModul> dataDiscArray;
    public DefaultTableModel dataDisc, dataJob;
    /**
     * Creates new form Result
     */
    public Result() {
        initComponents();
//        Session.setID(23);
//        Session.setNama("babang");
        this.getDataDisc();
        this.getJobList();
        this.getDescriptionPersonali();
        
        ID.setText(Session.getID().toString());
        Nama.setText(Session.getNama());
        LocalDateTime currentTime = LocalDateTime.now();
        Tanggal.setText(currentTime.getDayOfMonth() +" "+ currentTime.getMonth()+" "+ currentTime.getYear());
    }
    
    public void getDataDisc() {
        dataDiscArray = new ResultController().getDiscList();
        dataDisc = (DefaultTableModel)discTable.getModel();
        dataDisc.getDataVector().removeAllElements();
        dataDisc.fireTableDataChanged();
        this.setWidthColumn(discTable, 1, 25);
        this.setWidthColumn(discTable, 2, 25);
        this.setWidthColumn(discTable, 3, 25);
        this.setWidthColumn(discTable, 4, 25);
        this.setWidthColumn(discTable, 5, 75);
        Object[] row = new Object[6];
        for(DiscModul item: dataDiscArray){
            row[0] = item.getDescription();
            row[1] = item.getDominance();
            row[2] = item.getInfluence();
            row[3] = item.getSteadiness();
            row[4] = item.getCompliance();
            row[5] = item.getTotal_nilai();
            dataDisc.addRow(row);
        }
    }
    
    public void setWidthColumn(JTable table, Integer column, Integer width){
        table.getColumnModel().getColumn(column).setMinWidth(width);
        table.getColumnModel().getColumn(column).setMaxWidth(width);
        table.getColumnModel().getColumn(column).setWidth(width);
    }
    
    public void getJobList() {
        try {
            dataJob = (DefaultTableModel)jobTable.getModel();
            dataJob.getDataVector().removeAllElements();
            dataJob.fireTableDataChanged();
            this.setWidthColumn(jobTable, 0, 35);
            Connection connection = DBConnect.Conn();
            String sql = "SELECT " +
                        "    j.title, " +
                        "    (COUNT(r.job_id) / (SELECT COUNT(1) from rules where job_id=r.job_id) * 100) AS JUMLAH " +
                        "from result res " +
                        "JOIN rules r ON res.characteristic_id = r.characteristic_id " +
                        "JOIN job j ON r.job_id = j.id " +
                        "WHERE res.user_id = " + Session.getID() + " " +
                        "GROUP BY r.job_id";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            Object[] row = new Object[6];
            Integer no = 1;
            while (rs.next()) {
                row[0] = no;
                row[1] = rs.getString("title");
                row[2] = Double.parseDouble(rs.getString("JUMLAH")) + "%";
                dataJob.addRow(row);
                no++;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void getChart(){
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (DiscModul item : dataDiscArray) {
            XYSeries i = new XYSeries(item.getDescription());
            i.add(0, item.getDominance());
            i.add(1, item.getInfluence());
            i.add(2, item.getSteadiness());
            i.add(3, item.getCompliance());
            dataset.addSeries(i);
        }
        
        JFreeChart chart = ChartFactory.createXYLineChart("DISC", "Categories", "Values", dataset, PlotOrientation.VERTICAL,  true, true, true);
        chart.setBackgroundPaint(Color.GREEN);
        
        final XYPlot plot = chart.getXYPlot( );
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesPaint( 3 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );

        ChartFrame frame = new ChartFrame("DISC", chart);
        frame.setVisible(true);
        frame.setSize(new Dimension(500, 300));
        frame.setLocationRelativeTo(null);
    }
    
    public void getDescriptionPersonali() {
        Integer idx = 0;
        for(DiscModul item: dataDiscArray) {
            Integer hasil = item.getDominance();
            Integer type = 1;
            if(hasil < item.getInfluence()) {
                hasil = item.getInfluence();
                type = 2;
            }
            if(hasil < item.getSteadiness()) {
                hasil = item.getSteadiness();
                type = 3;
            }
            if(hasil < item.getCompliance()) {
                hasil = item.getCompliance();
                type = 4;
            }
            if(idx == 0) {
                this.setDescriptionPersonali(kdu, type);
            } else if(idx == 1) {
                this.setDescriptionPersonali(kyt, type);
            } else if(idx == 2) {
                this.setDescriptionPersonali(kst, type);
            }
            idx++;
        }
    }
    
    public void setDescriptionPersonali(JLabel jta, Integer type) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `personality` WHERE id = "+type;
            System.out.println(sql);
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()) {
               jta.setText("<html>"+rs.getString("description")+"</html>");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Nama = new javax.swing.JTextField();
        Tanggal = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        discTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        ResultTab = new javax.swing.JTabbedPane();
        SummaryPanel = new javax.swing.JScrollPane();
        SummaryPanelContent = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        PersonalityPanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kdu = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        kyt = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        kst = new javax.swing.JLabel();
        JobMatchedPanel = new javax.swing.JScrollPane();
        jobTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(672, 461));
        setMinimumSize(new java.awt.Dimension(672, 461));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(33100, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(666, 120));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(225, 164));
        jPanel5.setPreferredSize(new java.awt.Dimension(225, 163));

        jLabel1.setText("NO ID       : ");

        jLabel2.setText("Nama        :");

        jLabel3.setText("Tanggal    :");

        ID.setText("jTextField1");
        ID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ID.setEnabled(false);

        Nama.setText("jTextField1");
        Nama.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Nama.setEnabled(false);

        Tanggal.setText("jTextField1");
        Tanggal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Tanggal.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ID))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nama))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5);

        jPanel6.setMaximumSize(new java.awt.Dimension(450, 164));

        jScrollPane2.setMaximumSize(new java.awt.Dimension(333, 164));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(333, 164));

        discTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "D", "I", "S", "C", "Total Nilai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(discTable);
        if (discTable.getColumnModel().getColumnCount() > 0) {
            discTable.getColumnModel().getColumn(0).setResizable(false);
            discTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            discTable.getColumnModel().getColumn(1).setResizable(false);
            discTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            discTable.getColumnModel().getColumn(2).setResizable(false);
            discTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            discTable.getColumnModel().getColumn(3).setResizable(false);
            discTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            discTable.getColumnModel().getColumn(4).setResizable(false);
            discTable.getColumnModel().getColumn(4).setPreferredWidth(1);
            discTable.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6);

        jPanel1.add(jPanel3);

        jPanel4.setMinimumSize(new java.awt.Dimension(666, 273));

        SummaryPanelContent.setMaximumSize(new java.awt.Dimension(639, 222));

        jButton1.setText("SHOW CHART");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SummaryPanelContentLayout = new javax.swing.GroupLayout(SummaryPanelContent);
        SummaryPanelContent.setLayout(SummaryPanelContentLayout);
        SummaryPanelContentLayout.setHorizontalGroup(
            SummaryPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryPanelContentLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        SummaryPanelContentLayout.setVerticalGroup(
            SummaryPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryPanelContentLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        SummaryPanel.setViewportView(SummaryPanelContent);

        ResultTab.addTab("Summary", SummaryPanel);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Kepribadian dimuka Umum");

        kdu.setText("jLabel7");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(kdu, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kdu, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel8);

        jLabel5.setText("Kepribadian yang Tersembunyi");

        kyt.setText("jLabel7");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(kyt, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kyt, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel9);

        jLabel6.setText("Kepribadian Saat Mendapat Tekanan");

        kst.setText("jLabel7");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(kst, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kst, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel10);

        PersonalityPanel.setViewportView(jPanel2);

        ResultTab.addTab("Personality Description", PersonalityPanel);

        jobTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Job Name", " Percentage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JobMatchedPanel.setViewportView(jobTable);

        ResultTab.addTab("Job Matched", JobMatchedPanel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResultTab)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResultTab, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.getChart();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JScrollPane JobMatchedPanel;
    private javax.swing.JTextField Nama;
    private javax.swing.JScrollPane PersonalityPanel;
    private javax.swing.JTabbedPane ResultTab;
    private javax.swing.JScrollPane SummaryPanel;
    private javax.swing.JPanel SummaryPanelContent;
    private javax.swing.JTextField Tanggal;
    private javax.swing.JTable discTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jobTable;
    private javax.swing.JLabel kdu;
    private javax.swing.JLabel kst;
    private javax.swing.JLabel kyt;
    // End of variables declaration//GEN-END:variables

}
