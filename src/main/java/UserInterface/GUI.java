/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Model.TelephoneList;
import Model.TelephonicContact;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anaoliveira
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        setupTelephonicContactsTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mainPane = new javax.swing.JTabbedPane();
        initialTab = new javax.swing.JPanel();
        telephonicListTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTelephonicContacts = new javax.swing.JTable() {

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTelephone = new javax.swing.JMenu();
        menuItemNewContact = new javax.swing.JMenuItem();
        menuItemDelete = new javax.swing.JMenuItem();
        menuList = new javax.swing.JMenu();
        menuItemImport = new javax.swing.JMenuItem();
        menuItemExport = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        menuOption = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        initialTab.setLayout(null);
        mainPane.addTab("Início", initialTab);

        tableTelephonicContacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { },
            new String [] {
                "Nome", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(tableTelephonicContacts);

        javax.swing.GroupLayout telephonicListTabLayout = new javax.swing.GroupLayout(telephonicListTab);
        telephonicListTab.setLayout(telephonicListTabLayout);
        telephonicListTabLayout.setHorizontalGroup(
            telephonicListTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telephonicListTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        telephonicListTabLayout.setVerticalGroup(
            telephonicListTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        mainPane.addTab("Lista Telefónica", telephonicListTab);

        menuTelephone.setText("Telefone");

        menuItemNewContact.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemNewContact.setText("Novo");
        menuItemNewContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewContactActionPerformed(evt);
            }
        });
        menuTelephone.add(menuItemNewContact);

        menuItemDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemDelete.setText("Eliminar");
        menuTelephone.add(menuItemDelete);

        menuList.setText("Lista");

        menuItemImport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuItemImport.setText("Importar");
        menuItemImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemImportActionPerformed(evt);
            }
        });
        menuList.add(menuItemImport);

        menuItemExport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExport.setText("Exportar");
        menuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportActionPerformed(evt);
            }
        });
        menuList.add(menuItemExport);

        menuTelephone.add(menuList);

        menuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menuItemExit.setText("Sair");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuTelephone.add(menuItemExit);

        jMenuBar1.add(menuTelephone);

        menuOption.setText("Opções");
        jMenuBar1.add(menuOption);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemNewContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewContactActionPerformed
        // TODO add your handling code here:
        NewContactDialog dialog = new NewContactDialog(this, true);
        dialog.setVisible(true);
        TelephonicContact contact = dialog.getCreatedContact();
        DefaultTableModel model = (DefaultTableModel) tableTelephonicContacts.getModel();
        model.addRow(new Object[]{contact.getName(), contact.getNumber()});
    }//GEN-LAST:event_menuItemNewContactActionPerformed

    private void menuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemImportActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            List<TelephonicContact> contacts = TelephoneList.fromFiles(selectedFiles);
            this.refreshTable(contacts);
        }
    }//GEN-LAST:event_menuItemImportActionPerformed

    private void menuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExportActionPerformed
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = directoryChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String filepath = directoryChooser.getCurrentDirectory().toString();
            System.out.println(filepath);
            List<TelephonicContact> contacts = getContacts();
            TelephoneList.toFile(filepath, contacts);
        }
    }//GEN-LAST:event_menuItemExportActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private void setupTelephonicContactsTable() {
        List<TelephonicContact> contacts = new ArrayList<TelephonicContact>();
        contacts.add(new TelephonicContact("Paty", 916151522));
        contacts.add(new TelephonicContact("Tiago", 915026865));
        this.refreshTable(contacts);
    }

    private void refreshTable(List<TelephonicContact> contacts) {
        DefaultTableModel model = (DefaultTableModel) this.tableTelephonicContacts.getModel();
        for (TelephonicContact contact : contacts) {
            model.addRow(new Object[]{contact.getName(), contact.getNumber()});
        }
    }

    private List<TelephonicContact> getContacts() {
        List<TelephonicContact> contacts = new ArrayList();
        DefaultTableModel model = (DefaultTableModel) this.tableTelephonicContacts.getModel();
        model.getDataVector();
        for (int row = 0; row < model.getRowCount(); row++) {
            String name = model.getValueAt(row, 0).toString();
            long number = Long.parseLong(model.getValueAt(row, 1).toString());
            TelephonicContact contact = new TelephonicContact(name, number);
            contacts.add(contact);
        }
        return contacts;
    }
                              
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel initialTab;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane mainPane;
    private javax.swing.JMenuItem menuItemDelete;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemExport;
    private javax.swing.JMenuItem menuItemImport;
    private javax.swing.JMenuItem menuItemNewContact;
    private javax.swing.JMenu menuList;
    private javax.swing.JMenu menuOption;
    private javax.swing.JMenu menuTelephone;
    private javax.swing.JTable tableTelephonicContacts;
    private javax.swing.JPanel telephonicListTab;
    // End of variables declaration//GEN-END:variables
}