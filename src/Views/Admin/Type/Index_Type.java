/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin.Type;

import javax.swing.table.DefaultTableModel;
import libs.DBKoneksi;

/**
 *
 * @author Ari Nuryadi
 */
public class Index_Type extends javax.swing.JInternalFrame {

    /**
     * Creates new form Index_Karakteristik
     */
    public Index_Type() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_type = new javax.swing.JTable();
        txt_cari_type = new javax.swing.JTextField();
        txt_cari = new javax.swing.JButton();
        txt_tambah = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tabel_type.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Type", "Deskripsi"
            }
        ));
        jScrollPane1.setViewportView(tabel_type);

        txt_cari.setText("Pencarian");
        txt_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_cariMouseClicked(evt);
            }
        });

        txt_tambah.setText("Tambah");
        txt_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_tambahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txt_cari_type, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txt_cari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_tambah)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_cari_type)
                    .addComponent(txt_cari, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(txt_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tambahMouseClicked
        Create_Type create_Type = new Create_Type();
        create_Type.show();
    }//GEN-LAST:event_txt_tambahMouseClicked
    DBKoneksi db = new DBKoneksi();
    public void tampilTabel(){
        try {
//            Index_Type it = new Index_Type();
            DefaultTableModel model = (DefaultTableModel) tabel_type.getModel();
            model.setRowCount(0);
            db.bahasasql = "SELECT * FROM personality order by id asc";
            db.ambilData();
            db.hasilSet.beforeFirst();
            while (db.hasilSet.next()) {
                String a,b,c;
                a = db.hasilSet.getString("id");
                b = db.hasilSet.getString("title");
                c = db.hasilSet.getString("description");
                model.addRow(new Object[]{a,b,c});
            }
        } catch (Exception e) {
        }
    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        tampilTabel();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txt_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cariMouseClicked

    }//GEN-LAST:event_txt_cariMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabel_type;
    private javax.swing.JButton txt_cari;
    public javax.swing.JTextField txt_cari_type;
    private javax.swing.JButton txt_tambah;
    // End of variables declaration//GEN-END:variables
}
