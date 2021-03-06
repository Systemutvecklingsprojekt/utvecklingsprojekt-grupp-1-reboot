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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validation {

    /*
    Kollar om textf?lt ?r tom, returnerar true eller false.
     */
    public static boolean checkTextField(JTextField textfield) {

        boolean result = true;

        if (textfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "En eller flera rutor ?r tomma!");
            result = false;
        }

        return result;
    }

    /*
    Kollar om textyta ?r tom, returnerar true eller false.
     */
    public static boolean checkTextArea(JTextArea textArea) {
        boolean result = true;
        if (textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "En eller flera rutor ?r tomma!");
            result = false;
        }
        return result;
    }

    /*
    Kollar om datum i textf?lt ?r korrektt formaterad, returnerar true eller false.
     */
    public static boolean checkDate(JTextField textFalt) {
        boolean result = true;
        String pattern = "[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
        if (!textFalt.getText().matches(pattern)) {
            JOptionPane.showMessageDialog(null, "V?nligen ange datum i f?ljande format: yyyy-mm-dd");
            result = false;
        }
        return result;
    }

    /*
    Kollar om datum i en str?ng ?r korrekt formaterad, returnar true eller false.
     */
    public static boolean checkDate(String string) {
        boolean result = true;
        String pattern = "[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
        if (!string.matches(pattern)) {
            JOptionPane.showMessageDialog(null, "V?nligen ange datum i f?ljande format: yyyy-mm-dd");
            result = false;
        }
        return result;
    }

    /*
    Kollar om l?senordsf?lt ?r tomt, returnerar true eller false.
     */
    public static boolean checkPasswordField(JPasswordField passwordField) {

        boolean result = true;
        if (passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "N?got av f?lten ?r tomt!");
            result = false;

        }
        return result;
    }

    /*
    Kollar om textf?lt ?r tomt eller inte ?r godtagbart, returnar true eller false.
     */
    public static boolean checkPTextField(JTextField textField) {

        boolean result = true;
        if (!textField.getText().isEmpty()) {
            if (textField.getText().length() > 20 || textField.getText().length() < 5) {
                JOptionPane.showMessageDialog(null, "L?senordet f?r max vara 20 karakt?rer l?ngt och minst 5 karakt?rer!");
                result = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "L?senordsrutan ?r tom!");
            result = false;
        }
        return result;
    }

    /*
    Kollar om flera textf?lt ?r tomma, returnar true eller false.
     */
    public static boolean multibleTextFieldEmpty(ArrayList<JTextField> textFalt) {
        boolean result = true;

        for (JTextField falt : textFalt) {
            if (falt.getText().isEmpty()) {
                result = false;
            }
        }
        if (!result) {
            JOptionPane.showMessageDialog(null, "Du har l?mnat n?got f?lt tomt!");
        }
        return result;
    }

    /*
    Kollar om textf?ltet inneh?ller endast siffror, returnerar true eller false.
     */
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

    /*
    Kollar om en str?ng ?r tom, returnerar true eller false.
     */
    public static boolean isStringNull(String text) {
        boolean result = true;
        if (text.equals("")) {
            JOptionPane.showMessageDialog(null, "Din s?kning gav inga tr?ffar.");
            result = false;
        }
        return result;
    }

    /*
    Kollar om en ArrayList ?r tom, returnerar true eller false.
     */
    public static boolean isArrayListStringNull(ArrayList<String> list) {
        boolean result = true;
        if (list == null) {
            JOptionPane.showMessageDialog(null, "Din s?kning gav inga tr?ffar.");
            result = false;
        }
        return result;
    }

    /*
    Kollar om textf?lt ?r tomt, godtagbart och inte inneh?ller siffror, returnerar true eller false. 
     */
    public static boolean checkName(JTextField textField) {
        String messageDialog = "";
        boolean errorflag = true;
        if (textField.getText().isBlank()) {
            messageDialog = messageDialog + "Du har inte angivit n?got namn.\n";
            errorflag = false;
        }
        if (textField.getText().length() > 20 || textField.getText().length() < 2) {
            messageDialog = messageDialog + "Max 20 tecken och minst 2!\n";
            errorflag = false;
        }
        if (containsDigit(textField.getText())) {
            errorflag = false;
            messageDialog = messageDialog + "V?nligen ange inga siffror i namnf?lten!\n";

        }
        if (errorflag == false) {
            JOptionPane.showMessageDialog(null, messageDialog);
        }
        return errorflag;
    }

    /*
    Kollar om en epost-str?ng ?r skriven i r?tt format, returnerar true eller false.
     */
    public static boolean emailVerification(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            JOptionPane.showMessageDialog(null, "V?nligen ange en epostadress i r?tt format!");
            result = false;
        }
        return result;
    }

    /*
    Kollar om ett datum ?r tomt, returnerar true eller false.
     */
    public static boolean dateChooserValid(JDateChooser chooser) {
        boolean resultat = true;
        if (((JTextField) chooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "V?lj ett datum");
            resultat = false;
        }
        return resultat;

    }

    /*
    Kollar om en str?ng ?r tom, returnerar true eller false.
     */
    public static boolean valideraTid(String string) {
        boolean resultat = true;
        if (string.isEmpty()) {
            JOptionPane.showMessageDialog(null, "V?nligen v?lj en starttid");
            resultat = false;
        }
        return resultat;
    }

    /*
    Kollar om tid-str?ng ?r skriven i r?tt format, returnerar true eller false. 
     */
    public static boolean validTid(String string) {
        boolean resultat = true;
        try {
            LocalTime.parse(string);
        } catch (DateTimeParseException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "fel format p? tid, v?nligen v?lj ur listan");
            resultat = false;
        }
        return resultat;
    }

    /*
    Kollar om valt datum kommer efter aktuell dag, returnerar true eller false.
     */
    public static boolean isDateAhead(Date meet) {

        boolean resultat = true;
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date now = new Date();
        if (now.after(meet)) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "V?nligen v?lj ett datum som kommer efter idag");
            return resultat;
        }

        return true;

    }

    /*
    Kollar om fil ?r i r?tt format, returnerar true eller false.
     */
    public static boolean isImageValid(String string) {
        boolean resultat = false;
        if (string.endsWith(".jpg") || string.endsWith(".png")) {
            resultat = true;
            return resultat;
        } else {
            JOptionPane.showMessageDialog(null, "V?nligen v?lj en bild med formatet PNG eller JPG!");
            resultat = false;
        }
        return resultat;
    }

    /*
    Kollar om en str?ng inte inneh?ller siffror, returnerar true eller false.
     */
    private static boolean noInts(String string) {
        boolean isNotInt = false;

        if (string.matches("[a-zA-z]")) {
            isNotInt = true;
        }
        return isNotInt;

    }

    /*
    Kollar om en str?ng inte inneh?ller bokst?ver, returnerar true eller false.
     */
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

    /*
    Kollar om en str?ng inneh?ller siffror, returnerar true eller false.
     */
    public static boolean containsDigit(String string) {
        boolean hasDigits = false;
        for (int i = 0; i < string.length(); i++) {
            if (isDigit(Character.toString(string.charAt(i)))) {
                hasDigits = true;
                break;
            }
        }

        return hasDigits;
    }

    /*
    
     */
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

}
