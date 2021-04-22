/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.helpers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.github.lgooddatepicker.components.TimePicker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author albin
 */
public class Validation {

    public static boolean checkTextField(JTextField textfield) {

        boolean result = true;

        if (textfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "En eller flera rutor är tomma!");
            result = false;
        }

        return result;
    }

    public static boolean checkTextArea(JTextArea textArea) {
        boolean result = true;
        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "En eller flera rutor är tomma!");
            result = false;
        }
        return result;
    }

    public static boolean checkDate(JTextField textFalt) {
        boolean result = true;
        String pattern = "[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
        if (!textFalt.getText().matches(pattern)) {
            JOptionPane.showMessageDialog(null, "V?nligen ange datum i f?ljande format: yyyy-mm-dd");
            result = false;
        }
        return result;
    }

    public static boolean checkDate(String string) {
        boolean result = true;
        String pattern = "[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
        if (!string.matches(pattern)) {
            JOptionPane.showMessageDialog(null, "V?nligen ange datum i f?ljande format: yyyy-mm-dd");
            result = false;
        }
        return result;
    }

    public static boolean checkPasswordField(JPasswordField passwordField) {

        boolean result = true;
        if (passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Något av fälten är tomt!");
            result = false;

        }
        return result;
    }

    public static boolean checkPTextField(JTextField textField) {

        boolean result = true;
        if (!textField.getText().isEmpty()) {
            if (textField.getText().length() > 20 && textField.getText().length() < 5) {
                JOptionPane.showMessageDialog(null, "L?senordet får max vara 20 karaktärer långt och minst 5 karaktärer!");
                result = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "L?senordsrutan ?r tom!");
            result = false;
        }
        return result;
    }

    public static boolean multibleTextFieldEmpty(ArrayList<JTextField> textFalt) {
        boolean result = true;

        for (JTextField falt : textFalt) {
            if (falt.getText().isEmpty()) {
                result = false;
            }
        }
        if (!result) {
            JOptionPane.showMessageDialog(null, "Du har lämnat något fält tomt!");
        }
        return result;
    }

    public static boolean isInt(JTextField textField) {
        boolean result = true;
        try {
            String inString = textField.getText();
            Integer.parseInt(inString);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Var god ange ett giltigt UserID!");
            result = false;
        }
        return result;
    }

    public static boolean isStringNull(String text) {
        boolean result = true;
        if (text.equals("")) {
            JOptionPane.showMessageDialog(null, "Din sökning gav inga träffar.");
            result = false;
        }
        return result;
    }

    public static boolean isArrayListStringNull(ArrayList<String> list) {
        boolean result = true;
        if (list == null) {
            JOptionPane.showMessageDialog(null, "Din sökning gav inga träffar.");
            result = false;
        }
        return result;
    }

    public static boolean checkName(JTextField textField) {
        boolean resultat = true;
        if (!textField.getText().isEmpty()) {
            if (textField.getText().length() > 20 && noInts(textField)) {
                JOptionPane.showMessageDialog(null, "Max 20 tecken!");
                resultat = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angivit n?got namn.");
            resultat = false;
        }
        return resultat;
    }

    public static boolean emailVerification(JTextField textField) {
        boolean result = true;

        if (!textField.getText().matches("[a-zA-Z@.]*")) {
            result = false;
        }
        return result;
    }

    public static boolean dateChooserValid(JDateChooser chooser) {
        boolean resultat = true;
        if (((JTextField) chooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Välj ett datum");
            resultat = false;
        }
        return resultat;

    }

    public static boolean valideraTid(String string) {
        boolean resultat = true;
        if (string.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vänligen välj en starttid");
            resultat = false;
        }
        return resultat;
    }

    public static boolean validTid(String string) {
        boolean resultat = true;
        try {
            LocalTime.parse(string);
        } catch (DateTimeParseException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "fel format på tid, vänligen välj ur listan");
            resultat = false;
        }
        return resultat;
    }

    public static boolean isDateAhead(Date meet) {

        boolean resultat = true;
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date now = new Date();
        if (now.after(meet)) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Vänligen välj ett datum som kommer efter idag");
            return resultat;
        }

        return true;

    }
    
    public static boolean isImageValid(String string){
        boolean resultat = false;
        if(string.endsWith(".jpg")|| string.endsWith(".png")){
            resultat = true;
            return resultat;
        }
        else{
            JOptionPane.showMessageDialog(null, "Vänligen välj en bild med formatet PNG eller JPG!");
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean noInts(JTextField field) {
        boolean resultat = false;
        String name = field.toString();
        if(name.matches("[a-zA-Z]+")) {
        resultat = true;
        return resultat;
        }
        else {
        resultat = false;
        JOptionPane.showMessageDialog(null, "Använd endast tecken i namnfälten");
        }
        
        return resultat;
    
}

}
