package gui.frames;


import classes.Employee;
import classes.EmployeeUtils;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class UpdatePage extends javax.swing.JFrame {
    
    private final int employeeNumber;

    /**
     * Creates new form UpdatePage
     */
    public UpdatePage(int employeeNumber) {
        this.employeeNumber = employeeNumber;
        initComponents();
        populateEmployeeDetails();
        this.setSize(950, 580);
    }
    
    private void populateEmployeeDetails() {
        Employee employee = Employee.getEmployeeByNumber(employeeNumber);
        if (employee != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");      
            jTextFieldEmployeeNo.setText(String.valueOf(employee.getEmployeeNumber()));
            jTextFieldLastName.setText(employee.getLastName());
            jTextFieldFirstName.setText(employee.getFirstName());
            jTextFieldBirthday.setText(employee.getBirthday().format(formatter));
            jTextFieldAddress.setText(employee.getAddress());
            jTextFieldPhoneNo.setText(employee.getPhoneNumber());
            jTextFieldStatus.setText(employee.getStatus());
            jTextFieldDepartment.setText(employee.getDepartment());
            jTextFieldPosition.setText(employee.getPosition());
            jTextFieldSupervisor.setText(employee.getImmediateSupervisor());
            jTextFieldSssNo.setText(employee.getSssNumber());
            jTextFieldPhilHealthNo.setText(employee.getPhilHealthNumber());
            jTextFieldTin.setText(employee.getTinNumber());
            jTextFieldPagIbigNo.setText(employee.getPagIbigNumber());
            jTextFieldBasicSalary.setText(String.format("%.2f", employee.getBasicSalary()));
            jTextFieldRiceSubsidy.setText(String.format("%.2f", employee.getRiceSubsidy()));
            jTextFieldPhoneAllowance.setText(String.format("%.2f", employee.getPhoneAllowance()));
            jTextFieldClothingAllowance.setText(String.format("%.2f", employee.getClothingAllowance()));
            jTextFieldGsmr.setText(String.format("%.2f", employee.getGrossSemiMonthlyRate()));
            jTextFieldHourlyRate.setText(String.format("%.2f", employee.getHourlyRate()));
        }
    }
    
    
    private boolean updateCsv(String[] updatedEmployeeData) {
        String fileName = "src\\csv\\files\\allEmployeeDetails.csv";
        CSVReader reader = null;
        CSVWriter writer = null;
        boolean isFound = false;
        String[] record;

        try {
            reader = new CSVReader(new FileReader(fileName));
            writer = new CSVWriter(new FileWriter(fileName + ".tmp"));

            while ((record = reader.readNext()) != null) {
                if (record[0].equals(String.valueOf(employeeNumber))) {
                    writer.writeNext(updatedEmployeeData);
                    isFound = true;
                } else {
                    writer.writeNext(record);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
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

        if (isFound) {
            new File(fileName).delete();
            new File(fileName + ".tmp").renameTo(new File(fileName));
            return true;
        } else {
            new File(fileName + ".tmp").delete();
            return false;
        }
    }
    
    
    private boolean validateCsvData(int currentEmployeeNumber, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber) {
        String fileName = "src\\csv\\files\\allEmployeeDetails.csv";
        CSVReader reader = null;
        
        try {
            reader = new CSVReader(new FileReader(fileName));
            String[] nextLine;
            reader.readNext(); // Skip header

            while ((nextLine = reader.readNext()) != null) {
                int employeeNumber = Integer.parseInt(nextLine[0]);

                if (employeeNumber != currentEmployeeNumber) {
                    if (nextLine[10].equals(sssNumber)) {
                        jTextFieldSssNo.setText("");
                        JOptionPane.showMessageDialog(null, "SSS Number " + sssNumber + " already exists.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (nextLine[11].equals(philHealthNumber)) {
                        jTextFieldPhilHealthNo.setText("");
                        JOptionPane.showMessageDialog(null, "PhilHealth Number " + philHealthNumber + " already exists.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (nextLine[12].equals(tinNumber)) {
                        jTextFieldTin.setText("");
                        JOptionPane.showMessageDialog(null, "TIN Number " + tinNumber + " already exists.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                    if (nextLine[13].equals(pagIbigNumber)) {
                        jTextFieldPagIbigNo.setText("");
                        JOptionPane.showMessageDialog(null, "Pag-IBIG Number " + pagIbigNumber + " already exists.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error reading CSV file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return true;
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
        jButtonBack = new javax.swing.JButton();
        jLabelEmployeeNo = new javax.swing.JLabel();
        jTextFieldEmployeeNo = new javax.swing.JTextField();
        jLabelLastName = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabelFirstName = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabelBirthday = new javax.swing.JLabel();
        jTextFieldBirthday = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabelPhoneNo = new javax.swing.JLabel();
        jTextFieldPhoneNo = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabelDepartment = new javax.swing.JLabel();
        jTextFieldDepartment = new javax.swing.JTextField();
        jLabelPosition = new javax.swing.JLabel();
        jTextFieldPosition = new javax.swing.JTextField();
        jLabelSupervisor = new javax.swing.JLabel();
        jTextFieldSupervisor = new javax.swing.JTextField();
        jLabelPhilHealthNo = new javax.swing.JLabel();
        jTextFieldPhilHealthNo = new javax.swing.JTextField();
        jLabelSssNo = new javax.swing.JLabel();
        jTextFieldSssNo = new javax.swing.JTextField();
        jLabelTin = new javax.swing.JLabel();
        jTextFieldTin = new javax.swing.JTextField();
        jLabelPagIbigNo = new javax.swing.JLabel();
        jTextFieldPagIbigNo = new javax.swing.JTextField();
        jLabelBasicSalary = new javax.swing.JLabel();
        jTextFieldBasicSalary = new javax.swing.JTextField();
        jLabelRiceSubsidy = new javax.swing.JLabel();
        jTextFieldRiceSubsidy = new javax.swing.JTextField();
        jLabelPhoneAllowance = new javax.swing.JLabel();
        jTextFieldPhoneAllowance = new javax.swing.JTextField();
        jLabelClothingAllowance = new javax.swing.JLabel();
        jTextFieldClothingAllowance = new javax.swing.JTextField();
        jLabelGsmr = new javax.swing.JLabel();
        jTextFieldGsmr = new javax.swing.JTextField();
        jLabelHourlyRate = new javax.swing.JLabel();
        jTextFieldHourlyRate = new javax.swing.JTextField();
        jPanelHeader = new javax.swing.JPanel();
        jLabelEmployeeInfo = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanelBody.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBody.setMaximumSize(new java.awt.Dimension(950, 580));
        jPanelBody.setMinimumSize(new java.awt.Dimension(950, 580));
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

        jButtonBack.setBackground(new java.awt.Color(204, 0, 0));
        jButtonBack.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("Back");
        jButtonBack.setBorderPainted(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanelNavBar.add(jButtonBack);
        jButtonBack.setBounds(10, 10, 150, 50);

        jPanelBody.add(jPanelNavBar);
        jPanelNavBar.setBounds(0, 0, 170, 550);

        jLabelEmployeeNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEmployeeNo.setText("Employee No.  :");
        jPanelBody.add(jLabelEmployeeNo);
        jLabelEmployeeNo.setBounds(190, 130, 90, 30);

        jTextFieldEmployeeNo.setEditable(false);
        jTextFieldEmployeeNo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldEmployeeNo.setDisabledTextColor(new java.awt.Color(38, 38, 38));
        jTextFieldEmployeeNo.setEnabled(false);
        jTextFieldEmployeeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmployeeNoActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldEmployeeNo);
        jTextFieldEmployeeNo.setBounds(300, 130, 210, 30);

        jLabelLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLastName.setText("Last Name       :");
        jPanelBody.add(jLabelLastName);
        jLabelLastName.setBounds(190, 160, 90, 30);

        jTextFieldLastName.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldLastName);
        jTextFieldLastName.setBounds(300, 160, 210, 30);

        jLabelFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFirstName.setText("First Name       :");
        jPanelBody.add(jLabelFirstName);
        jLabelFirstName.setBounds(190, 190, 90, 30);

        jTextFieldFirstName.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldFirstName);
        jTextFieldFirstName.setBounds(300, 190, 210, 30);

        jLabelBirthday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelBirthday.setText("Date of Birth     :");
        jPanelBody.add(jLabelBirthday);
        jLabelBirthday.setBounds(190, 220, 90, 30);

        jTextFieldBirthday.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBirthdayActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldBirthday);
        jTextFieldBirthday.setBounds(300, 220, 210, 30);

        jLabelAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAddress.setText("Address            :");
        jPanelBody.add(jLabelAddress);
        jLabelAddress.setBounds(190, 250, 90, 30);

        jTextFieldAddress.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddressActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldAddress);
        jTextFieldAddress.setBounds(300, 250, 210, 30);

        jLabelPhoneNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPhoneNo.setText("Phone No.        :");
        jPanelBody.add(jLabelPhoneNo);
        jLabelPhoneNo.setBounds(190, 280, 90, 30);

        jTextFieldPhoneNo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPhoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneNoActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldPhoneNo);
        jTextFieldPhoneNo.setBounds(300, 280, 210, 30);

        jLabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelStatus.setText("Status                :");
        jPanelBody.add(jLabelStatus);
        jLabelStatus.setBounds(190, 310, 90, 30);

        jTextFieldStatus.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStatusActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldStatus);
        jTextFieldStatus.setBounds(300, 310, 210, 30);

        jLabelDepartment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDepartment.setText("Department     :");
        jPanelBody.add(jLabelDepartment);
        jLabelDepartment.setBounds(190, 340, 90, 30);

        jTextFieldDepartment.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDepartmentActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldDepartment);
        jTextFieldDepartment.setBounds(300, 340, 210, 30);

        jLabelPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPosition.setText("Position            :");
        jPanelBody.add(jLabelPosition);
        jLabelPosition.setBounds(190, 370, 90, 30);

        jTextFieldPosition.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPositionActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldPosition);
        jTextFieldPosition.setBounds(300, 370, 210, 30);

        jLabelSupervisor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSupervisor.setText("Supervisor        :");
        jPanelBody.add(jLabelSupervisor);
        jLabelSupervisor.setBounds(190, 400, 90, 30);

        jTextFieldSupervisor.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSupervisorActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldSupervisor);
        jTextFieldSupervisor.setBounds(300, 400, 210, 30);

        jLabelPhilHealthNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPhilHealthNo.setText("PhilHealth No.           :");
        jPanelBody.add(jLabelPhilHealthNo);
        jLabelPhilHealthNo.setBounds(550, 160, 120, 30);

        jTextFieldPhilHealthNo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPhilHealthNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhilHealthNoActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldPhilHealthNo);
        jTextFieldPhilHealthNo.setBounds(690, 160, 210, 30);

        jLabelSssNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSssNo.setText("SSS No.                       :");
        jPanelBody.add(jLabelSssNo);
        jLabelSssNo.setBounds(550, 130, 120, 30);

        jTextFieldSssNo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldSssNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSssNoActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldSssNo);
        jTextFieldSssNo.setBounds(690, 130, 210, 30);

        jLabelTin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTin.setText("TIN                               :");
        jPanelBody.add(jLabelTin);
        jLabelTin.setBounds(550, 190, 120, 30);

        jTextFieldTin.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTinActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldTin);
        jTextFieldTin.setBounds(690, 190, 210, 30);

        jLabelPagIbigNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPagIbigNo.setText("Pag-Ibig No.               :");
        jPanelBody.add(jLabelPagIbigNo);
        jLabelPagIbigNo.setBounds(550, 220, 120, 30);

        jTextFieldPagIbigNo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPagIbigNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPagIbigNoActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldPagIbigNo);
        jTextFieldPagIbigNo.setBounds(690, 220, 210, 30);

        jLabelBasicSalary.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelBasicSalary.setText("Basic Salary               :");
        jPanelBody.add(jLabelBasicSalary);
        jLabelBasicSalary.setBounds(550, 250, 120, 30);

        jTextFieldBasicSalary.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBasicSalaryActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldBasicSalary);
        jTextFieldBasicSalary.setBounds(690, 250, 210, 30);

        jLabelRiceSubsidy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRiceSubsidy.setText("Rice Subsidy              :");
        jPanelBody.add(jLabelRiceSubsidy);
        jLabelRiceSubsidy.setBounds(550, 280, 120, 30);

        jTextFieldRiceSubsidy.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldRiceSubsidy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRiceSubsidyActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldRiceSubsidy);
        jTextFieldRiceSubsidy.setBounds(690, 280, 210, 30);

        jLabelPhoneAllowance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPhoneAllowance.setText("Phone Allowance      :");
        jPanelBody.add(jLabelPhoneAllowance);
        jLabelPhoneAllowance.setBounds(550, 310, 120, 30);

        jTextFieldPhoneAllowance.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPhoneAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneAllowanceActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldPhoneAllowance);
        jTextFieldPhoneAllowance.setBounds(690, 310, 210, 30);

        jLabelClothingAllowance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelClothingAllowance.setText("Clothing Allowance   :");
        jPanelBody.add(jLabelClothingAllowance);
        jLabelClothingAllowance.setBounds(550, 340, 120, 30);

        jTextFieldClothingAllowance.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldClothingAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClothingAllowanceActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldClothingAllowance);
        jTextFieldClothingAllowance.setBounds(690, 340, 210, 30);

        jLabelGsmr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGsmr.setText("Gross Semi-Monthly :");
        jPanelBody.add(jLabelGsmr);
        jLabelGsmr.setBounds(550, 370, 120, 30);

        jTextFieldGsmr.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldGsmr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGsmrActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldGsmr);
        jTextFieldGsmr.setBounds(690, 370, 210, 30);

        jLabelHourlyRate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHourlyRate.setText("Hourly Rate                :");
        jPanelBody.add(jLabelHourlyRate);
        jLabelHourlyRate.setBounds(550, 400, 120, 30);

        jTextFieldHourlyRate.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldHourlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHourlyRateActionPerformed(evt);
            }
        });
        jPanelBody.add(jTextFieldHourlyRate);
        jTextFieldHourlyRate.setBounds(690, 400, 210, 30);

        jPanelHeader.setBackground(new java.awt.Color(0, 51, 102));
        jPanelHeader.setLayout(null);

        jLabelEmployeeInfo.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabelEmployeeInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmployeeInfo.setText("Employee Information");
        jPanelHeader.add(jLabelEmployeeInfo);
        jLabelEmployeeInfo.setBounds(250, 10, 220, 20);

        jPanelBody.add(jPanelHeader);
        jPanelHeader.setBounds(200, 20, 700, 40);

        jButtonUpdate.setBackground(new java.awt.Color(0, 51, 102));
        jButtonUpdate.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.setBorderPainted(false);
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanelBody.add(jButtonUpdate);
        jButtonUpdate.setBounds(750, 470, 150, 40);

        getContentPane().add(jPanelBody);
        jPanelBody.setBounds(0, 0, 940, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        try {
            // Validate required fields
            if (!EmployeeUtils.validateRequiredFields(jTextFieldEmployeeNo, jTextFieldLastName, jTextFieldFirstName, jTextFieldBirthday,
                    jTextFieldAddress, jTextFieldPhoneNo, jTextFieldStatus, jTextFieldDepartment,
                    jTextFieldPosition, jTextFieldSupervisor, jTextFieldSssNo, jTextFieldPhilHealthNo,
                    jTextFieldTin, jTextFieldPagIbigNo, jTextFieldBasicSalary, jTextFieldRiceSubsidy,
                    jTextFieldPhoneAllowance, jTextFieldClothingAllowance, jTextFieldGsmr, jTextFieldHourlyRate)) {
                return;
            }

            // Parse and validate individual fields
            int employeeNumber = EmployeeUtils.parseAndValidateEmployeeNumber(jTextFieldEmployeeNo);
            if (employeeNumber == -1) {
                return;
            }

            LocalDate birthday = EmployeeUtils.parseAndValidateBirthday(jTextFieldBirthday);
            if (birthday == null) {
                return;
            }

            String phoneNumber = EmployeeUtils.validatePhoneNumber(jTextFieldPhoneNo);
            if (phoneNumber == null) {
                return;
            }

            String sssNumber = EmployeeUtils.validateSssNumber(jTextFieldSssNo);
            if (sssNumber == null) {
                return;
            }

            String philHealthNumber = EmployeeUtils.validatePhilHealthNumber(jTextFieldPhilHealthNo);
            if (philHealthNumber == null) {
                return;
            }

            String tinNumber = EmployeeUtils.validateTinNumber(jTextFieldTin);
            if (tinNumber == null) {
                return;
            }

            String pagIbigNumber = EmployeeUtils.validatePagIbigNumber(jTextFieldPagIbigNo);
            if (pagIbigNumber == null) {
                return;
            }

            double basicSalary = EmployeeUtils.parseAndValidateDouble(jTextFieldBasicSalary, "Basic Salary");
            if (basicSalary == -1) {
                return;
            }

            double riceSubsidy = EmployeeUtils.parseAndValidateDouble(jTextFieldRiceSubsidy, "Rice Subsidy");
            if (riceSubsidy == -1) {
                return;
            }

            double phoneAllowance = EmployeeUtils.parseAndValidateDouble(jTextFieldPhoneAllowance, "Phone Allowance");
            if (phoneAllowance == -1) {
                return;
            }

            double clothingAllowance = EmployeeUtils.parseAndValidateDouble(jTextFieldClothingAllowance, "Clothing Allowance");
            if (clothingAllowance == -1) {
                return;
            }

            double grossSemiMonthlyRate = EmployeeUtils.parseAndValidateDouble(jTextFieldGsmr, "Gross Semi-Monthly Rate");
            if (grossSemiMonthlyRate == -1) {
                return;
            }

            double hourlyRate = EmployeeUtils.parseAndValidateDouble(jTextFieldHourlyRate, "Hourly Rate");
            if (hourlyRate == -1) {
                return;
            }

            // Read and validate CSV data excluding the current employee
            if (!validateCsvData(employeeNumber, sssNumber, philHealthNumber, tinNumber, pagIbigNumber)) {
                return;
            }

            // Collect updated employee data
            String[] updatedEmployeeData = EmployeeUtils.collectNewEmployeeData(employeeNumber, birthday, phoneNumber, sssNumber, philHealthNumber, tinNumber, pagIbigNumber,
                    basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate,
                    jTextFieldLastName, jTextFieldFirstName, jTextFieldAddress, jTextFieldStatus, jTextFieldDepartment,
                    jTextFieldPosition, jTextFieldSupervisor);

            // Update CSV file
            if (!updateCsv(updatedEmployeeData)) {
                return;
            }

            // Show success message and navigate back
            JOptionPane.showMessageDialog(this, "Employee updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            EmployeeUtils.navigateBack(this);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error updating employee: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jTextFieldEmployeeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmployeeNoActionPerformed

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

    private void jTextFieldBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBirthdayActionPerformed

    private void jTextFieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddressActionPerformed

    private void jTextFieldPhoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneNoActionPerformed

    private void jTextFieldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStatusActionPerformed

    private void jTextFieldDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDepartmentActionPerformed

    private void jTextFieldPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPositionActionPerformed

    private void jTextFieldSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSupervisorActionPerformed

    private void jTextFieldPhilHealthNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhilHealthNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhilHealthNoActionPerformed

    private void jTextFieldSssNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSssNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSssNoActionPerformed

    private void jTextFieldTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTinActionPerformed

    private void jTextFieldPagIbigNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPagIbigNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPagIbigNoActionPerformed

    private void jTextFieldBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBasicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBasicSalaryActionPerformed

    private void jTextFieldRiceSubsidyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRiceSubsidyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRiceSubsidyActionPerformed

    private void jTextFieldPhoneAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneAllowanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneAllowanceActionPerformed

    private void jTextFieldClothingAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClothingAllowanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClothingAllowanceActionPerformed

    private void jTextFieldGsmrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGsmrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGsmrActionPerformed

    private void jTextFieldHourlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHourlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHourlyRateActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        EmployeeUtils.navigateBack(this);
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePage(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelBasicSalary;
    private javax.swing.JLabel jLabelBirthday;
    private javax.swing.JLabel jLabelClothingAllowance;
    private javax.swing.JLabel jLabelDepartment;
    private javax.swing.JLabel jLabelEmployeeInfo;
    private javax.swing.JLabel jLabelEmployeeNo;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelGsmr;
    private javax.swing.JLabel jLabelHourlyRate;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelPagIbigNo;
    private javax.swing.JLabel jLabelPhilHealthNo;
    private javax.swing.JLabel jLabelPhoneAllowance;
    private javax.swing.JLabel jLabelPhoneNo;
    private javax.swing.JLabel jLabelPosition;
    private javax.swing.JLabel jLabelRiceSubsidy;
    private javax.swing.JLabel jLabelSssNo;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSupervisor;
    private javax.swing.JLabel jLabelTin;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelNavBar;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldBasicSalary;
    private javax.swing.JTextField jTextFieldBirthday;
    private javax.swing.JTextField jTextFieldClothingAllowance;
    private javax.swing.JTextField jTextFieldDepartment;
    private javax.swing.JTextField jTextFieldEmployeeNo;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldGsmr;
    private javax.swing.JTextField jTextFieldHourlyRate;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPagIbigNo;
    private javax.swing.JTextField jTextFieldPhilHealthNo;
    private javax.swing.JTextField jTextFieldPhoneAllowance;
    private javax.swing.JTextField jTextFieldPhoneNo;
    private javax.swing.JTextField jTextFieldPosition;
    private javax.swing.JTextField jTextFieldRiceSubsidy;
    private javax.swing.JTextField jTextFieldSssNo;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldSupervisor;
    private javax.swing.JTextField jTextFieldTin;
    // End of variables declaration//GEN-END:variables
}
