/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import gui.frames.RecordsPage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFrame;

/**
 *
 * @author CJ
 */
public class EmployeeUtils {
    
    public static boolean validateRequiredFields(JTextField jTextFieldEmployeeNo, JTextField jTextFieldLastName, JTextField jTextFieldFirstName, JTextField jTextFieldBirthday,
                                                 JTextField jTextFieldAddress, JTextField jTextFieldPhoneNo, JTextField jTextFieldStatus, JTextField jTextFieldDepartment,
                                                 JTextField jTextFieldPosition, JTextField jTextFieldSupervisor, JTextField jTextFieldSssNo, JTextField jTextFieldPhilHealthNo,
                                                 JTextField jTextFieldTin, JTextField jTextFieldPagIbigNo, JTextField jTextFieldBasicSalary, JTextField jTextFieldRiceSubsidy,
                                                 JTextField jTextFieldPhoneAllowance, JTextField jTextFieldClothingAllowance, JTextField jTextFieldGsmr, JTextField jTextFieldHourlyRate) {
        if (jTextFieldEmployeeNo.getText().isEmpty() || jTextFieldLastName.getText().isEmpty()
                || jTextFieldFirstName.getText().isEmpty() || jTextFieldBirthday.getText().isEmpty()
                || jTextFieldAddress.getText().isEmpty() || jTextFieldPhoneNo.getText().isEmpty()
                || jTextFieldStatus.getText().isEmpty() || jTextFieldDepartment.getText().isEmpty()
                || jTextFieldPosition.getText().isEmpty() || jTextFieldSupervisor.getText().isEmpty()
                || jTextFieldSssNo.getText().isEmpty() || jTextFieldPhilHealthNo.getText().isEmpty()
                || jTextFieldTin.getText().isEmpty() || jTextFieldPagIbigNo.getText().isEmpty()
                || jTextFieldBasicSalary.getText().isEmpty() || jTextFieldRiceSubsidy.getText().isEmpty()
                || jTextFieldPhoneAllowance.getText().isEmpty() || jTextFieldClothingAllowance.getText().isEmpty()
                || jTextFieldGsmr.getText().isEmpty() || jTextFieldHourlyRate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static int parseAndValidateEmployeeNumber(JTextField jTextFieldEmployeeNo) {
        try {
            return Integer.parseInt(jTextFieldEmployeeNo.getText());
        } catch (NumberFormatException e) {
            jTextFieldEmployeeNo.setText("");
            JOptionPane.showMessageDialog(null, "Invalid number format for Employee Number.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static LocalDate parseAndValidateBirthday(JTextField jTextFieldBirthday) {
        try {
            return LocalDate.parse(jTextFieldBirthday.getText(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (DateTimeParseException e) {
            jTextFieldBirthday.setText("");
            JOptionPane.showMessageDialog(null, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static String validatePhoneNumber(JTextField jTextFieldPhoneNo) {
        String phoneNumber = jTextFieldPhoneNo.getText();
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{3}")) {
            jTextFieldPhoneNo.setText("");
            JOptionPane.showMessageDialog(null, "Invalid Phone Number format. It should be like 977-543-893.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return phoneNumber;
    }

    public static String validateSssNumber(JTextField jTextFieldSssNo) {
        String sssNumber = jTextFieldSssNo.getText();
        if (!sssNumber.matches("\\d{2}-\\d{7}-\\d")) {
            jTextFieldSssNo.setText("");
            JOptionPane.showMessageDialog(null, "Invalid SSS number format. It should be like 44-3784927-2.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return sssNumber;
    }

    public static String validatePhilHealthNumber(JTextField jTextFieldPhilHealthNo) {
        String philHealthNumber = jTextFieldPhilHealthNo.getText();
        if (!philHealthNumber.matches("\\d{12}")) {
            jTextFieldPhilHealthNo.setText("");
            JOptionPane.showMessageDialog(null, "Invalid PhilHealth number format. It should be like 783647839201.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return philHealthNumber;
    }

    public static String validateTinNumber(JTextField jTextFieldTin) {
        String tinNumber = jTextFieldTin.getText();
        if (!tinNumber.matches("\\d{3}-\\d{3}-\\d{3}-\\d{3}")) {
            jTextFieldTin.setText("");
            JOptionPane.showMessageDialog(null, "Invalid TIN format. It should be like 443-507-478-000.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tinNumber;
    }

    public static String validatePagIbigNumber(JTextField jTextFieldPagIbigNo) {
        String pagIbigNumber = jTextFieldPagIbigNo.getText();
        if (!pagIbigNumber.matches("\\d{12}")) {
            jTextFieldPagIbigNo.setText("");
            JOptionPane.showMessageDialog(null, "Invalid Pag-ibig number format. It should be like 698367498910.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return pagIbigNumber;
    }

    public static double parseAndValidateDouble(javax.swing.JTextField textField, String jTextFieldName) {
        try {
            return Double.parseDouble(textField.getText());
        } catch (NumberFormatException e) {
            textField.setText("");
            JOptionPane.showMessageDialog(null, "Invalid number format for " + jTextFieldName + ".", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public static boolean validateCsvData(int employeeNumber, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber,
                                          JTextField jTextFieldEmployeeNo, JTextField jTextFieldSssNo, JTextField jTextFieldPhilHealthNo,
                                          JTextField jTextFieldTin, JTextField jTextFieldPagIbigNo) {
        String fileName = "src\\csv\\files\\allEmployeeDetails.csv";
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(fileName));
            String[] column;
            reader.readNext(); // Skip header

            while ((column = reader.readNext()) != null) {
                if (column[0].equals(String.valueOf(employeeNumber))) {
                    jTextFieldEmployeeNo.setText("");
                    JOptionPane.showMessageDialog(null, "Employee number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (column[10].equals(sssNumber)) {
                    jTextFieldSssNo.setText("");
                    JOptionPane.showMessageDialog(null, "SSS number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (column[11].equals(philHealthNumber)) {
                    jTextFieldPhilHealthNo.setText("");
                    JOptionPane.showMessageDialog(null, "PhilHealth number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (column[12].equals(tinNumber)) {
                    jTextFieldTin.setText("");
                    JOptionPane.showMessageDialog(null, "TIN already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (column[13].equals(pagIbigNumber)) {
                    jTextFieldPagIbigNo.setText("");
                    JOptionPane.showMessageDialog(null, "Pag-Ibig number already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
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
        }
        return true;
    }

    public static String[] collectNewEmployeeData(int employeeNumber, LocalDate birthday, String phoneNumber, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber, 
                                                  double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate,
                                                  JTextField jTextFieldLastName, JTextField jTextFieldFirstName, JTextField jTextFieldAddress, JTextField jTextFieldStatus, JTextField jTextFieldDepartment,
                                                  JTextField jTextFieldPosition, JTextField jTextFieldSupervisor) {
        return new String[]{
            String.valueOf(employeeNumber), jTextFieldLastName.getText(), jTextFieldFirstName.getText(), birthday.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
            jTextFieldAddress.getText(), phoneNumber, jTextFieldStatus.getText(), jTextFieldDepartment.getText(), jTextFieldPosition.getText(), jTextFieldSupervisor.getText(),
            sssNumber, philHealthNumber, tinNumber, pagIbigNumber,
            String.format("%.2f", basicSalary), String.format("%.2f", riceSubsidy),
            String.format("%.2f", phoneAllowance), String.format("%.2f", clothingAllowance),
            String.format("%.2f", grossSemiMonthlyRate), String.format("%.2f", hourlyRate)
        };
    }

    public static boolean writeToCsv(String[] newEmployeeData) {
        String fileName = "src\\csv\\files\\allEmployeeDetails.csv";
        CSVWriter writer = null;

        try {
            writer = new CSVWriter(new FileWriter(fileName, true));
            writer.writeNext(newEmployeeData);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    
    public static void navigateBack(JFrame currentFrame) {
        RecordsPage recordsPage = new RecordsPage();
        recordsPage.setVisible(true);
        currentFrame.setVisible(false);
    }
}
   