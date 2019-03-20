/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Toolkit;

/**
 *
 * @author Lumi
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        this.setTitle("Parking System Managment"); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        automjetiMenu = new javax.swing.JMenu();
        shtoAutomjetinMenuItem = new javax.swing.JMenuItem();
        shoferiMenu = new javax.swing.JMenu();
        shtoShoferinMenuItem = new javax.swing.JMenuItem();
        perdoruesiMenu = new javax.swing.JMenu();
        shtoPerdoruesinMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        shtypFaturenMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        automjetiMenu.setMnemonic('f');
        automjetiMenu.setText("Automjeti");
        automjetiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automjetiMenuActionPerformed(evt);
            }
        });

        shtoAutomjetinMenuItem.setMnemonic('o');
        shtoAutomjetinMenuItem.setText("Shto automjetin...");
        shtoAutomjetinMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoAutomjetinMenuItemActionPerformed(evt);
            }
        });
        automjetiMenu.add(shtoAutomjetinMenuItem);

        menuBar.add(automjetiMenu);

        shoferiMenu.setText("Shoferi");

        shtoShoferinMenuItem.setText("Shto shoferin...");
        shtoShoferinMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoShoferinMenuItemActionPerformed(evt);
            }
        });
        shoferiMenu.add(shtoShoferinMenuItem);

        menuBar.add(shoferiMenu);

        perdoruesiMenu.setText("Perdoruesi");

        shtoPerdoruesinMenuItem.setText("Shto perdoruesin...");
        shtoPerdoruesinMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoPerdoruesinMenuItemActionPerformed(evt);
            }
        });
        perdoruesiMenu.add(shtoPerdoruesinMenuItem);

        menuBar.add(perdoruesiMenu);

        jMenu1.setText("Fatura");

        shtypFaturenMenuItem.setText("Shtyp faturen...");
        shtypFaturenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtypFaturenMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(shtypFaturenMenuItem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void automjetiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automjetiMenuActionPerformed
      
    }//GEN-LAST:event_automjetiMenuActionPerformed

    private void shtoAutomjetinMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoAutomjetinMenuItemActionPerformed
        AutomjetiForm af = new AutomjetiForm();
        jDesktopPane1.add(af);
        af.show();
    }//GEN-LAST:event_shtoAutomjetinMenuItemActionPerformed

    private void shtoShoferinMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoShoferinMenuItemActionPerformed
        ShoferiForm sf = new ShoferiForm();
        jDesktopPane1.add(sf);
        sf.show();

    }//GEN-LAST:event_shtoShoferinMenuItemActionPerformed

    private void shtoPerdoruesinMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoPerdoruesinMenuItemActionPerformed
        PerdoruesiForm pf = new PerdoruesiForm();
        jDesktopPane1.add(pf);
        pf.show();
    }//GEN-LAST:event_shtoPerdoruesinMenuItemActionPerformed

    private void shtypFaturenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtypFaturenMenuItemActionPerformed
        FaturaForm ff = new FaturaForm();
        jDesktopPane1.add(ff);
        ff.show();
    }//GEN-LAST:event_shtypFaturenMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu automjetiMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    public javax.swing.JMenu perdoruesiMenu;
    public javax.swing.JMenu shoferiMenu;
    private javax.swing.JMenuItem shtoAutomjetinMenuItem;
    private javax.swing.JMenuItem shtoPerdoruesinMenuItem;
    private javax.swing.JMenuItem shtoShoferinMenuItem;
    private javax.swing.JMenuItem shtypFaturenMenuItem;
    // End of variables declaration//GEN-END:variables

}