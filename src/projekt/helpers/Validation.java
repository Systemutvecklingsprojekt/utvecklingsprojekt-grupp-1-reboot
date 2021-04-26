/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.helpers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
            if (textField.getText().length() > 20 || textField.getText().length() < 5) {
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
        String messageDialog ="";
        boolean errorflag = true;
        if (textField.getText().isBlank()) {
            messageDialog = messageDialog +"Du har inte angivit något namn.\n";
            errorflag = false;
        }
        if (textField.getText().length() > 20 && textField.getText().length() < 2) {
            messageDialog = messageDialog +"Max 20 tecken och minst 2!\n";
            errorflag = false;
        }
        if (containsDigit(textField.getText())) {
            errorflag = false;
            messageDialog = messageDialog +"Vänligen ange inga siffror i namnfälten!\n";

        }
        if(errorflag==false){
            JOptionPane.showMessageDialog(null, messageDialog);
            //System.out.println("projekt.helpers.Validation.checkName()");
        }
        
        return errorflag;
    }

    public static boolean emailVerification(JTextField textField) {
        boolean result = true;

        if (!textField.getText().matches("[a-zA-Z@.]*")) {
            JOptionPane.showMessageDialog(null, "Fel format på inskriven email");
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

    public static boolean isImageValid(String string) {
        boolean resultat = false;
        if (string.endsWith(".jpg") || string.endsWith(".png")) {
            resultat = true;
            return resultat;
        } else {
            JOptionPane.showMessageDialog(null, "Vänligen välj en bild med formatet PNG eller JPG!");
            resultat = false;
        }
        return resultat;
    }

    private static boolean noInts(String string) {
        boolean isNotInt = false;

        if (string.matches("[a-zA-z]")) {
            isNotInt = true;
        }
        return isNotInt;

    }

    private static boolean isDigit(String string) {
        try {
            int d = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean containsDigit(String string) {
        boolean hasDigits = false;
        for (int i = 0; i < string.length(); i++) {
            if (isDigit(Character.toString(string.charAt(i)))) {
                hasDigits = true;
                break;
            }
            //Process char
        }

        return hasDigits;
    }

    private static void containsDigitTest(String[] expectedTrue, String[] expectedFalse) {
        for (int i = 0; i < expectedTrue.length; i++) {
            if (!containsDigit(expectedTrue[i])) {
                System.out.println("projekt.helpers.Validation.containsDigitTest():\n"
                        + "isDigit(" + expectedTrue[i] + ")->False\nExpected True");
            }
        }
        for (int i = 0; i < expectedFalse.length; i++) {
            if (containsDigit(expectedFalse[i])) {
                System.out.println("projekt.helpers.Validation.containsDigitTest():\n"
                        + "isDigit(" + expectedFalse[i] + ")->True\nExpected False");
            }
        }

    }

    public static void main(String[] args) {
        String[] expectedFalseNoDigits = {"i", "okej", "Okokasxbaxnksjnuasvv", "qwertyu"}, expectedTrueSomeDigits = {"1", "ok1ej", "Okokasxba8xnksjnuasvv", "qw9ertyu", "1", "99991234567890234567"};
        containsDigitTest(expectedTrueSomeDigits, expectedFalseNoDigits);

    }
}
