/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.Automjeti;
import BL.KategoriaAutomjetit;
import BL.LlojiAutomjetit;
import BL.LlojiNgjyres;
import BL.NgjyraAutomjetit;
import BL.TipiAutomjetit;
import DAL.AutomjetiException;
import DAL.AutomjetiRepository;
import DAL.KategoriaAutomjetitRepository;
import DAL.LlojiAutomjetitRepository;
import DAL.NgjyraAutomjetitRepository;
import DAL.LlojiNgjyresRepository;
import DAL.TipiAutomjetitException;
import DAL.TipiAutomjetitRepository;
import Model.AutomjetiTableModel;
import Model.KategoriaAutomjetitComboBoxModel;
import Model.LlojiAutomjetitComboBoxModel;
import Model.LlojiNgjyresComboBoxModel;
import Model.NgjyraAutomjetitComboBoxModel;
import Model.TipiAutomjetitComboBoxModel;
import RegEx.NumriTargesValidator;
import java.awt.Dimension;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Lumi
 */
public class AutomjetiForm extends javax.swing.JInternalFrame {
    
    AutomjetiRepository automjetiRepository = new AutomjetiRepository();
    AutomjetiTableModel automjetiTableModel = new AutomjetiTableModel();
    LlojiAutomjetitRepository llojiAutomjetitRepository = new LlojiAutomjetitRepository();
    NgjyraAutomjetitRepository ngjyraAutomjetitRepository = new NgjyraAutomjetitRepository();
    KategoriaAutomjetitRepository kategoriaAutomjetitRepository = new KategoriaAutomjetitRepository();
    TipiAutomjetitRepository tipiAutomjetitRepository = new TipiAutomjetitRepository();
    LlojiNgjyresRepository ngjyraDetajetRepository = new LlojiNgjyresRepository();

    
    LlojiAutomjetitComboBoxModel llojiAutomjetitComboBoxModel;
    NgjyraAutomjetitComboBoxModel ngjyraAutomjetitComboBoxModel;
    KategoriaAutomjetitComboBoxModel kategoriaAutomjetitComboBoxModel;
    TipiAutomjetitComboBoxModel tipiAutomjetitComboBoxModel;
    LlojiNgjyresComboBoxModel llojiNgjyresComboBoxModel;

    /**
     * Creates new form AutomjetiForm
     */
    public AutomjetiForm() {
        initComponents();
        tabelaLoad();
        comboBoxLoad();
        this.setTitle("Automjeti Form");
    }
    public void emptyObject() {
        jTable1.clearSelection();
        txtNrTarges.setText("");
        cmbLlojiAutomjetit.setSelectedIndex(-1);
        cmbLlojiAutomjetit.repaint();
        cmbTipiAutomjetit.setSelectedIndex(-1);
        cmbTipiAutomjetit.repaint();
        cmbNgjyraAutomjetit.setSelectedIndex(-1);
        cmbNgjyraAutomjetit.repaint();
        cmbLlojiNgjyres.setSelectedIndex(-1);
        cmbLlojiNgjyres.repaint();
        cmbKategoriaAutomjetit.setSelectedIndex(-1);
        cmbKategoriaAutomjetit.repaint();
        
       
        
    }
    public void populateTipiAutomjetit(List<TipiAutomjetit> l) {
        tipiAutomjetitComboBoxModel = new TipiAutomjetitComboBoxModel(l);
        cmbTipiAutomjetit.setModel(tipiAutomjetitComboBoxModel);
    }
    private void comboBoxLoad(){
	List<LlojiAutomjetit> llojiAutomjetitId = llojiAutomjetitRepository.findAll();
        llojiAutomjetitComboBoxModel= new LlojiAutomjetitComboBoxModel(llojiAutomjetitId);
        this.cmbLlojiAutomjetit.setModel(llojiAutomjetitComboBoxModel);
        
        List<TipiAutomjetit> tipiAutomjetitId = tipiAutomjetitRepository.findAll();
        tipiAutomjetitComboBoxModel= new TipiAutomjetitComboBoxModel(tipiAutomjetitId);
        this.cmbTipiAutomjetit.setModel(tipiAutomjetitComboBoxModel);
        
        List<NgjyraAutomjetit> ngjyraAutomjetitId = ngjyraAutomjetitRepository.findAll();
        ngjyraAutomjetitComboBoxModel= new NgjyraAutomjetitComboBoxModel(ngjyraAutomjetitId);
        this.cmbNgjyraAutomjetit.setModel(ngjyraAutomjetitComboBoxModel);
       
        List<LlojiNgjyres> ngjyraDetajetId = ngjyraDetajetRepository.findAll();
        llojiNgjyresComboBoxModel= new LlojiNgjyresComboBoxModel(ngjyraDetajetId);
        this.cmbLlojiNgjyres.setModel(llojiNgjyresComboBoxModel);
        
        List<KategoriaAutomjetit> kategoriaAutomjetitId = kategoriaAutomjetitRepository.findAll();
        kategoriaAutomjetitComboBoxModel= new KategoriaAutomjetitComboBoxModel(kategoriaAutomjetitId);
        this.cmbKategoriaAutomjetit.setModel(kategoriaAutomjetitComboBoxModel);
    }
    private void tabelaLoad() {
        List<Automjeti> lista = automjetiRepository.findAll();
        automjetiTableModel.add(lista);
        jTable1.setModel(automjetiTableModel);
        automjetiTableModel.fireTableDataChanged();
        tabelaSelectedIndexChange();

    }
    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = jTable1.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Automjeti automjeti = automjetiTableModel.getAutomjeti(selectedIndex);

                    txtNrTarges.setText(automjeti.getNrTarges());
                    cmbLlojiAutomjetit.setSelectedItem(automjeti.getTipiAutomjetitID().getLlojiAutomjetitID());
                    cmbTipiAutomjetit.setSelectedItem(automjeti.getTipiAutomjetitID());
                    cmbNgjyraAutomjetit.setSelectedItem(automjeti.getNgjyraAutomjetitID());
                    cmbLlojiNgjyres.setSelectedItem(automjeti.getLlojiNgjyresID());
                    cmbKategoriaAutomjetit.setSelectedItem(automjeti.getKategoriaAutomjetitID());
                    cmbLlojiAutomjetit.repaint();
                    cmbTipiAutomjetit.repaint();
                    cmbNgjyraAutomjetit.repaint();
                    cmbLlojiNgjyres.repaint();
                    cmbKategoriaAutomjetit.repaint();
                    targaGabim.setVisible(false);
                    
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNrTarges = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbNgjyraAutomjetit = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbKategoriaAutomjetit = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbLlojiNgjyres = new javax.swing.JComboBox();
        targaGabim = new javax.swing.JLabel();
        cmbTipiAutomjetit = new javax.swing.JComboBox();
        cmbLlojiAutomjetit = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        raportiMenu = new javax.swing.JMenu();
        raportiMenuItem = new javax.swing.JMenuItem();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nr. i Targes:");

        jLabel3.setText("Lloji i Automjetit:");

        txtNrTarges.setPreferredSize(new java.awt.Dimension(6, 30));
        txtNrTarges.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNrTargesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNrTargesFocusLost(evt);
            }
        });
        txtNrTarges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNrTargesActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1495665232_floppy.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(57, 30));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1495728739_update.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(61, 30));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1495666218_delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(63, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngjyra e Automjetit:");

        cmbNgjyraAutomjetit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNgjyraAutomjetit.setPreferredSize(new java.awt.Dimension(56, 30));
        cmbNgjyraAutomjetit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNgjyraAutomjetitActionPerformed(evt);
            }
        });

        jLabel5.setText("Kategoria e Automjetit:");

        cmbKategoriaAutomjetit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKategoriaAutomjetit.setPreferredSize(new java.awt.Dimension(56, 30));

        jLabel2.setText("Tipi i Automjetit:");

        jLabel6.setText("Lloji i Ngjyrës:");

        cmbLlojiNgjyres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLlojiNgjyres.setPreferredSize(new java.awt.Dimension(56, 30));
        cmbLlojiNgjyres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLlojiNgjyresActionPerformed(evt);
            }
        });

        targaGabim.setForeground(new java.awt.Color(255, 0, 0));
        targaGabim.setText("Numri i targes është gabim !");

        cmbTipiAutomjetit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipiAutomjetit.setPreferredSize(new java.awt.Dimension(56, 30));

        cmbLlojiAutomjetit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLlojiAutomjetit.setPreferredSize(new java.awt.Dimension(56, 30));
        cmbLlojiAutomjetit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLlojiAutomjetitItemStateChanged(evt);
            }
        });

        raportiMenu.setText("Raporti");
        raportiMenu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                raportiMenuFocusGained(evt);
            }
        });
        raportiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raportiMenuActionPerformed(evt);
            }
        });

        raportiMenuItem.setText("Raporti i automjeteve");
        raportiMenuItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                raportiMenuItemFocusGained(evt);
            }
        });
        raportiMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raportiMenuItemActionPerformed(evt);
            }
        });
        raportiMenu.add(raportiMenuItem);

        jMenuBar1.add(raportiMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(targaGabim)
                                    .addComponent(txtNrTarges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLlojiAutomjetit, 0, 148, Short.MAX_VALUE)
                                    .addComponent(cmbTipiAutomjetit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbNgjyraAutomjetit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbLlojiNgjyres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbKategoriaAutomjetit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNrTarges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategoriaAutomjetit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(targaGabim, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbNgjyraAutomjetit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbLlojiAutomjetit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbLlojiNgjyres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTipiAutomjetit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        emptyObject();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int row = jTable1.getSelectedRow();
            
            if (txtNrTarges.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ju lutem shkruani numrin e targes.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(cmbTipiAutomjetit.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(this, "Ju lutem zgjedhni tipin e automjetit.", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else 
            {
                LlojiAutomjetit llojiAutomjetit = new LlojiAutomjetit();
                
                if (row == -1) {
                    Automjeti automjeti = new Automjeti();
                    
                    automjeti.setNrTarges(txtNrTarges.getText());
                    automjeti.getTipiAutomjetitID().setLlojiAutomjetitID(llojiAutomjetitComboBoxModel.getElementAt(cmbLlojiAutomjetit.getSelectedIndex()));
                    automjeti.setTipiAutomjetitID(tipiAutomjetitComboBoxModel.getElementAt(cmbTipiAutomjetit.getSelectedIndex()));
                    automjeti.setNgjyraAutomjetitID(ngjyraAutomjetitComboBoxModel.getElementAt(cmbNgjyraAutomjetit.getSelectedIndex()));
                    automjeti.setLlojiNgjyresID(llojiNgjyresComboBoxModel.getElementAt(cmbLlojiNgjyres.getSelectedIndex()));                    
                    automjeti.setKategoriaAutomjetitID(kategoriaAutomjetitComboBoxModel.getElementAt(cmbKategoriaAutomjetit.getSelectedIndex()));

                    automjetiRepository.create(automjeti);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {
                    Automjeti automjeti = this.automjetiTableModel.getAutomjeti(row);

                    automjeti.setNrTarges(txtNrTarges.getText());
                    automjeti.getTipiAutomjetitID().setLlojiAutomjetitID(llojiAutomjetitComboBoxModel.getElementAt(cmbLlojiAutomjetit.getSelectedIndex()));
                    automjeti.setTipiAutomjetitID(tipiAutomjetitComboBoxModel.getElementAt(cmbTipiAutomjetit.getSelectedIndex()));
                    automjeti.setNgjyraAutomjetitID(ngjyraAutomjetitComboBoxModel.getElementAt(cmbNgjyraAutomjetit.getSelectedIndex()));
                    automjeti.setLlojiNgjyresID(llojiNgjyresComboBoxModel.getElementAt(cmbLlojiNgjyres.getSelectedIndex()));                    
                    automjeti.setKategoriaAutomjetitID(kategoriaAutomjetitComboBoxModel.getElementAt(cmbKategoriaAutomjetit.getSelectedIndex()));
                    automjetiRepository.edit(automjeti);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tabelaLoad();
            }

        } catch (AutomjetiException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            int row = jTable1.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Automjeti automjeti = this.automjetiTableModel.getAutomjeti(row);
                    automjetiRepository.remove(automjeti);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(AutomjetiException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNrTargesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNrTargesActionPerformed
        
    }//GEN-LAST:event_txtNrTargesActionPerformed

    private void cmbLlojiNgjyresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLlojiNgjyresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLlojiNgjyresActionPerformed

    private void cmbNgjyraAutomjetitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNgjyraAutomjetitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNgjyraAutomjetitActionPerformed

    private void txtNrTargesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNrTargesFocusLost
        NumriTargesValidator v = new NumriTargesValidator();
        if(!v.validate(txtNrTarges.getText().trim())){
            targaGabim.setVisible(true);
        }
    }//GEN-LAST:event_txtNrTargesFocusLost

    private void txtNrTargesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNrTargesFocusGained
        targaGabim.setVisible(false);
    }//GEN-LAST:event_txtNrTargesFocusGained

        //Metoda e cila kthen listen me tipet e nje lloji te automjetit
        //     
    private void cmbLlojiAutomjetitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLlojiAutomjetitItemStateChanged
        LlojiAutomjetit l = (LlojiAutomjetit)cmbLlojiAutomjetit.getSelectedItem();
        List <TipiAutomjetit> lista = null;
        
        {    
            try {      
                    lista = tipiAutomjetitRepository.findByLlojiAutomjetitId(l.getLlojiAutomjetitID());
                    if(lista == null){
            JOptionPane.showMessageDialog(this, "n", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    
            } catch (TipiAutomjetitException ex) {
                Logger.getLogger(AutomjetiForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        populateTipiAutomjetit(lista);
        }
    }//GEN-LAST:event_cmbLlojiAutomjetitItemStateChanged

    private void raportiMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raportiMenuItemActionPerformed
        try{
            JFileChooser fch = new JFileChooser();
            fch.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fch.setPreferredSize(new Dimension(700,500));
            fch.setDialogTitle("Ruaj raportin");
            int returnVal = fch.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION){
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Parking;user=sa;password=Gasolina123");

            String report="C:\\Users\\Lumi\\Documents\\NetBeansProjects\\ParkingSystem\\src\\Automjeti.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(report);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con);
       
            JasperExportManager.exportReportToPdfFile(jp,fch.getSelectedFile().getAbsolutePath()+ ".pdf");
            }  
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_raportiMenuItemActionPerformed

    private void raportiMenuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_raportiMenuFocusGained
      
    }//GEN-LAST:event_raportiMenuFocusGained

    private void raportiMenuItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_raportiMenuItemFocusGained
        targaGabim.setVisible(false);
    }//GEN-LAST:event_raportiMenuItemFocusGained

    private void raportiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raportiMenuActionPerformed
   
    }//GEN-LAST:event_raportiMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbKategoriaAutomjetit;
    private javax.swing.JComboBox cmbLlojiAutomjetit;
    private javax.swing.JComboBox cmbLlojiNgjyres;
    private javax.swing.JComboBox cmbNgjyraAutomjetit;
    private javax.swing.JComboBox cmbTipiAutomjetit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu raportiMenu;
    private javax.swing.JMenuItem raportiMenuItem;
    private javax.swing.JLabel targaGabim;
    private javax.swing.JTextField txtNrTarges;
    // End of variables declaration//GEN-END:variables
}