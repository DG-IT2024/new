package gui.frames;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;


public class RecordsPage extends javax.swing.JFrame {

    public static DefaultTableModel employeeTableModel;
    
    /**
     * Creates new form RecordsPage
     */
    
    public RecordsPage() {
        initComponents();
        this.setSize(950, 580);
        addSearchKeyListener();
        addEmployeesToJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBody = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanelNavBar = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonLeaveRequests = new javax.swing.JButton();
        jButtonEmployees2 = new javax.swing.JButton();
        jLabelSelect = new javax.swing.JLabel();
        jTextFieldSearchBar = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButtonDeleteRecord = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmployeeList = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jButtonViewRecord = new javax.swing.JButton();
        jButtonUpdateRecord = new javax.swing.JButton();
        jButtonAddRecord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanelBody.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBody.setMaximumSize(new java.awt.Dimension(970, 550));
        jPanelBody.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(179, 203, 179));
        jPanel4.setLayout(null);

        jButton13.setBackground(new java.awt.Color(254, 254, 225));
        jButton13.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jButton13.setText("Back");
        jButton13.setBorderPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13);
        jButton13.setBounds(0, 10, 130, 50);

        jPanelBody.add(jPanel4);
        jPanel4.setBounds(0, 0, 0, 550);

        jPanelNavBar.setBackground(new java.awt.Color(0, 51, 102));
        jPanelNavBar.setLayout(null);

        jButtonExit.setBackground(new java.awt.Color(204, 0, 0));
        jButtonExit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("Exit");
        jButtonExit.setBorderPainted(false);
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanelNavBar.add(jButtonExit);
        jButtonExit.setBounds(10, 130, 150, 50);

        jButtonLeaveRequests.setBackground(new java.awt.Color(4, 18, 52));
        jButtonLeaveRequests.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonLeaveRequests.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLeaveRequests.setText("Leave Requests");
        jButtonLeaveRequests.setBorderPainted(false);
        jButtonLeaveRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeaveRequestsActionPerformed(evt);
            }
        });
        jPanelNavBar.add(jButtonLeaveRequests);
        jButtonLeaveRequests.setBounds(10, 70, 150, 50);

        jButtonEmployees2.setBackground(new java.awt.Color(4, 18, 52));
        jButtonEmployees2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonEmployees2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEmployees2.setText("Records");
        jButtonEmployees2.setBorderPainted(false);
        jButtonEmployees2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmployees2ActionPerformed(evt);
            }
        });
        jPanelNavBar.add(jButtonEmployees2);
        jButtonEmployees2.setBounds(10, 10, 150, 50);

        jPanelBody.add(jPanelNavBar);
        jPanelNavBar.setBounds(0, 0, 170, 550);

        jLabelSelect.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSelect.setText("Select by Employee No.  :");
        jPanelBody.add(jLabelSelect);
        jLabelSelect.setBounds(250, 20, 190, 30);

        jTextFieldSearchBar.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldSearchBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldSearchBar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSearchBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchBarActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldSearchBar);
        jTextFieldSearchBar.setBounds(460, 20, 200, 30);

        jButton15.setBackground(new java.awt.Color(254, 254, 225));
        jButton15.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jButton15.setText("Employees");
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanelBody.add(jButton15);
        jButton15.setBounds(10, 10, 150, 50);

        jButtonDeleteRecord.setBackground(new java.awt.Color(204, 0, 0));
        jButtonDeleteRecord.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButtonDeleteRecord.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDeleteRecord.setText("Delete Record");
        jButtonDeleteRecord.setBorderPainted(false);
        jButtonDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRecordActionPerformed(evt);
            }
        });
        jPanelBody.add(jButtonDeleteRecord);
        jButtonDeleteRecord.setBounds(710, 480, 130, 40);

        jTableEmployeeList.setBackground(new java.awt.Color(255, 255, 204));
        jTableEmployeeList.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTableEmployeeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No.", "Last Name", "First Name", "SSS No.", "PhilHealth No.", "TIN", "Pag-Ibig No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmployeeList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableEmployeeList.setEditingRow(7);
        jTableEmployeeList.setSelectionBackground(new java.awt.Color(0, 51, 102));
        jTableEmployeeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableEmployeeList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableEmployeeList);
        if (jTableEmployeeList.getColumnModel().getColumnCount() > 0) {
            jTableEmployeeList.getColumnModel().getColumn(0).setResizable(false);
            jTableEmployeeList.getColumnModel().getColumn(1).setResizable(false);
            jTableEmployeeList.getColumnModel().getColumn(2).setResizable(false);
            jTableEmployeeList.getColumnModel().getColumn(3).setResizable(false);
            jTableEmployeeList.getColumnModel().getColumn(4).setResizable(false);
            jTableEmployeeList.getColumnModel().getColumn(5).setResizable(false);
            jTableEmployeeList.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanelBody.add(jScrollPane1);
        jScrollPane1.setBounds(200, 70, 700, 340);

        jButtonSearch.setBackground(new java.awt.Color(0, 51, 102));
        jButtonSearch.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.setBorderPainted(false);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanelBody.add(jButtonSearch);
        jButtonSearch.setBounds(700, 20, 130, 27);

        jButtonViewRecord.setBackground(new java.awt.Color(0, 51, 102));
        jButtonViewRecord.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButtonViewRecord.setForeground(new java.awt.Color(255, 255, 255));
        jButtonViewRecord.setText("View Record");
        jButtonViewRecord.setBorderPainted(false);
        jButtonViewRecord.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButtonViewRecordAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jButtonViewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecordActionPerformed(evt);
            }
        });
        jPanelBody.add(jButtonViewRecord);
        jButtonViewRecord.setBounds(250, 430, 130, 40);

        jButtonUpdateRecord.setBackground(new java.awt.Color(0, 51, 102));
        jButtonUpdateRecord.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButtonUpdateRecord.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdateRecord.setText("Update Record");
        jButtonUpdateRecord.setBorderPainted(false);
        jButtonUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateRecordActionPerformed(evt);
            }
        });
        jPanelBody.add(jButtonUpdateRecord);
        jButtonUpdateRecord.setBounds(250, 480, 130, 40);

        jButtonAddRecord.setBackground(new java.awt.Color(0, 51, 102));
        jButtonAddRecord.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButtonAddRecord.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddRecord.setText("Create Record");
        jButtonAddRecord.setBorderPainted(false);
        jButtonAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRecordActionPerformed(evt);
            }
        });
        jPanelBody.add(jButtonAddRecord);
        jButtonAddRecord.setBounds(710, 430, 130, 40);

        getContentPane().add(jPanelBody);
        jPanelBody.setBounds(0, 0, 940, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void addSearchKeyListener() {
        // Add KeyListener to the search text field
        jTextFieldSearchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simulate search button click
                    jButtonSearchActionPerformed(null);
                }
            }
        });
    }
    
    
    private void searchEmployee(int selectedEmployee) {
        // Get the table model from the jTableEmployeeList component
        DefaultTableModel model = (DefaultTableModel) jTableEmployeeList.getModel();
        // Initialize rowCount
        int rowCount = model.getRowCount();

        boolean isFound = false;
        // Loop through each row in the table
        for (int i = 0; i < rowCount; i++) {
            // Get the employee number from the first column of the current row
            int employeeNumber = Integer.parseInt(model.getValueAt(i, 0).toString());

            // Check if the employee number matches the one we're searching for
            if (employeeNumber == selectedEmployee) {
                
                // Select the row in the table
                jTableEmployeeList.setRowSelectionInterval(i, i);
                // Scroll to the selected row to make it visible
                Rectangle rect = jTableEmployeeList.getCellRect(i, 0, true);
                jTableEmployeeList.scrollRectToVisible(rect);
                // Employee found
                isFound = true;
                // Exit the method since we found the employee
                return;
            }
        }
        
        if (!isFound) {
            jTextFieldSearchBar.setText("");
            JOptionPane.showMessageDialog(null, "Employee not found.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void addEmployeesToJTable() {
        String fileName = "src\\csv\\files\\allEmployeeDetails.csv";
        CSVReader reader = null;
        
        try {
            // Create a new CSVReader
            reader = new CSVReader(new FileReader(fileName));
            // Discard the header row
            reader.readNext();
            // Initialize a list to hold rows
            List<String[]> rows = new ArrayList<>();
            // Read all remaining rows
            String[] row;
            while ((row = reader.readNext()) != null) {
                rows.add(row);
            }
            // Get the table model from the jTableEmployeeList component
            DefaultTableModel model = (DefaultTableModel) jTableEmployeeList.getModel();

            // Add rows 0, 1, 2, 10, 11, 12, and 13 to the table
            for (String[] rowData : rows) {
                if (rowData.length > 13) {
                    // Extract the Employee number, Last Name, First Name, SSS number, PhilHealth number, TIN, and Pag-Ibig number columns
                    String[] selectedData = {rowData[0], rowData[1], rowData[2], rowData[10], rowData[11], rowData[12], rowData[13]};
                    model.addRow(selectedData);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButtonDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRecordActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = jTableEmployeeList.getSelectedRow();
            if (selectedRow != -1) {
                // Get the employee number of the selected row
                String employeeNumber = jTableEmployeeList.getValueAt(selectedRow, 0).toString();

                // Show confirmation dialog
                int response = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to delete the record for Employee #" + employeeNumber + "?", 
                        "Confirm Deletion", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE);
                
                if (response == JOptionPane.YES_OPTION) {
                    // Remove the selected row from the table model
                    DefaultTableModel model = (DefaultTableModel) jTableEmployeeList.getModel();
                    model.removeRow(selectedRow);
                    // Delete the corresponding entry from the CSV file
                    deleteEmployeeRecordFromCSV(employeeNumber);
                    JOptionPane.showMessageDialog(null, "Employee record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select an employee to delete their record.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while deleting the employee record.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonDeleteRecordActionPerformed
    
    
    private void deleteEmployeeRecordFromCSV(String employeeNumber) {
        String filePath = "src\\csv\\files\\allEmployeeDetails.csv";
        List<String[]> allRecords = new ArrayList<>();
        String[] nextLine;
        CSVReader reader = null;
        CSVWriter writer = null;

        try {
            // Read the existing CSV file
            reader = new CSVReader(new FileReader(filePath));
            while ((nextLine = reader.readNext()) != null) {
                // Add each line to the list except the one to be deleted
                if (!nextLine[0].equals(employeeNumber)) {
                    allRecords.add(nextLine);
                }
            }
            // Write the updated list back to the CSV file
            writer = new CSVWriter(new FileWriter(filePath));
            writer.writeAll(allRecords);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextFieldSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchBarActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // Get the text from the search bar
        String empNumberStr = jTextFieldSearchBar.getText();
        // Check if the search bar is empty
        if (empNumberStr.isEmpty()) {
            // Show an error message if the search bar is empty
            JOptionPane.showMessageDialog(null, "Please enter an employee number.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Try to convert the input to an integer
                int empNumber = Integer.parseInt(empNumberStr);
                // Call the searchEmployee method with the parsed employee number
                searchEmployee(empNumber);
            } catch (NumberFormatException e) {
                // If an exception occurs, clear the search bar
                jTextFieldSearchBar.setText("");
                // Show an error message indicating invalid input
                JOptionPane.showMessageDialog(null, "Please enter a valid employee number.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonViewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewRecordActionPerformed
        // TODO add your handling code here:
        // Get the selected employee's details
        int selectedRow = jTableEmployeeList.getSelectedRow();
        // Ensure a row is selected
        if (selectedRow != -1) {
            String employeeNumber = jTableEmployeeList.getValueAt(selectedRow, 0).toString();
            // Pass the employee number to DetailsPage
            DetailsPage detailsPage = new DetailsPage(Integer.parseInt(employeeNumber));
            detailsPage.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an employee to view their record.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonViewRecordActionPerformed

    private void jButtonUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateRecordActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableEmployeeList.getSelectedRow();
        // Ensure a row is selected
        if (selectedRow != -1) {
            String employeeNumber = jTableEmployeeList.getValueAt(selectedRow, 0).toString();
            // Pass the employee number to UpdatePage
            UpdatePage updatePage = new UpdatePage(Integer.parseInt(employeeNumber));
            updatePage.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an employee to update their record.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdateRecordActionPerformed

    private void jButtonAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRecordActionPerformed
        // TODO add your handling code here:
        CreatePage createPage = new CreatePage();
        createPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddRecordActionPerformed

    private void jButtonViewRecordAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButtonViewRecordAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewRecordAncestorAdded

    private void jButtonLeaveRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeaveRequestsActionPerformed
        // TODO add your handling code here:
        LeaveRequestsPage leaveRequestsPage = new LeaveRequestsPage();
        leaveRequestsPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonLeaveRequestsActionPerformed

    private void jButtonEmployees2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmployees2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEmployees2ActionPerformed

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
            java.util.logging.Logger.getLogger(RecordsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButtonAddRecord;
    private javax.swing.JButton jButtonDeleteRecord;
    private javax.swing.JButton jButtonEmployees2;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLeaveRequests;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateRecord;
    private javax.swing.JButton jButtonViewRecord;
    private javax.swing.JLabel jLabelSelect;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelNavBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmployeeList;
    private javax.swing.JTextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
