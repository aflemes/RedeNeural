/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeneural.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import redeneural.model.Neuronio;
/**
 *
 * @author allan.lemes
 */
public class MatrizConfusao extends javax.swing.JFrame {

    /**
     * Creates new form MatrizConfusao
     */
    private ArrayList<Neuronio> lstResultados;
    
    public MatrizConfusao(ArrayList<Neuronio> lstResultados) {
        this.setLstResultados(lstResultados);
        
        initComponents();
        initResultados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jResultados.setPreferredSize(new java.awt.Dimension(750, 160));
        jScrollPane2.setViewportView(jResultados);
        if (jResultados.getColumnModel().getColumnCount() > 0) {
            jResultados.getColumnModel().getColumn(0).setResizable(false);
            jResultados.getColumnModel().getColumn(1).setResizable(false);
            jResultados.getColumnModel().getColumn(2).setResizable(false);
            jResultados.getColumnModel().getColumn(3).setResizable(false);
            jResultados.getColumnModel().getColumn(4).setResizable(false);
            jResultados.getColumnModel().getColumn(5).setResizable(false);
            jResultados.getColumnModel().getColumn(6).setResizable(false);
            jResultados.getColumnModel().getColumn(7).setResizable(false);
            jResultados.getColumnModel().getColumn(8).setResizable(false);
            jResultados.getColumnModel().getColumn(9).setResizable(false);
            jResultados.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel1.setText("Resultados obtidos");

        jLabel2.setText("Resultados");

        jLabel11.setText("esperados");

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
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
            java.util.logging.Logger.getLogger(MatrizConfusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrizConfusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrizConfusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrizConfusao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrizConfusao(new ArrayList<Neuronio>()).setVisible(true);
            }
        });
    }

    public ArrayList<Neuronio> getLstResultados() {
        return lstResultados;
    }

    public void setLstResultados(ArrayList<Neuronio> lstResultados) {
        this.lstResultados = lstResultados;
    }   
    
    private void initResultados(){
        int[][] matrizConfusao = new int[10][10];
        int indiceX = 0;
        int indiceY = 0;
        final Color[] cores = new Color[10];
        cores[0] = Color.RED;
        String linha;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrizConfusao[i][j] = 0;
            }
        }
        
        if (lstResultados != null){
            for (int i = 0; i < lstResultados.size(); i++) {
                indiceX = lstResultados.get(i).getId();
                indiceY = lstResultados.get(i).getResultadoObtido();
                
                System.out.println(" calculando... ");
                matrizConfusao[indiceX-1][indiceY]++;
            }
        }
        
        DefaultTableModel tabelaModelo = (DefaultTableModel) jResultados.getModel();
        tabelaModelo.setNumRows(0); //limpa a tabela
        for (int i = 0; i < matrizConfusao.length; i++) {
            tabelaModelo.addRow(new String[]{
                                    String.valueOf(i + 1) ,
                                    String.valueOf(matrizConfusao[i][0]),
                                    String.valueOf(matrizConfusao[i][1]),
                                    String.valueOf(matrizConfusao[i][2]),
                                    String.valueOf(matrizConfusao[i][3]),
                                    String.valueOf(matrizConfusao[i][4]),
                                    String.valueOf(matrizConfusao[i][5]),
                                    String.valueOf(matrizConfusao[i][6]),
                                    String.valueOf(matrizConfusao[i][7]),
                                    String.valueOf(matrizConfusao[i][8]),
                                    String.valueOf(matrizConfusao[i][9])}); 
            
        }
        
        Font font = new Font("Verdana", Font.BOLD, 12);
        
        jResultados.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 0){
                    c.setFont(font);
                }
                return c;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jResultados;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
