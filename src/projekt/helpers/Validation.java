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
import javax.swing.JTextField;

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
    
    
    public static boolean checkTextField(JTextField textfield){
        
        boolean result = true;
        
        if(textfield.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "En eller flera rutor är tomma!");
            result = false;
        }
        
        return result;
    }
    
    public static boolean checkDate(JTextField textFalt){
        boolean result = true;
        String pattern = "[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]";
        if(!textFalt.getText().matches(pattern)){
            JOptionPane.showMessageDialog(null, "V?nligen ange datum i f?ljande format: yyyy-mm-dd");
            result = false;
        }
        return result;
    }
    public static boolean checkPasswordField(JPasswordField passwordField){
        
        boolean result = true;
        if(passwordField.getText().isEmpty()){            
                JOptionPane.showMessageDialog(null, "Något av fälten är tomt!");
                result = false;
             
        } 
        return result;
    }
    
    public static boolean checkPTextField(JTextField textField){
        
        boolean result = true;
        if(!textField.getText().isEmpty()){
            if(textField.getText().length() > 6){
                JOptionPane.showMessageDialog(null, "L?senordet f?r max vara 6 karakt?rer l?ngt!");
                result = false;
            } 
        } else {
            JOptionPane.showMessageDialog(null, "L?senordsrutan ?r tom!");
            result = false;
        }
        return result;
    }
    
    public static boolean multibleTextFieldEmpty(ArrayList<JTextField> textFalt){
        boolean result = true;
        
        for(JTextField falt : textFalt){
            if(falt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Du har l?mnat n?got f?lt tomt!");
                result = false;
            }
        }
        
        return result;
    }
    
    public static boolean isInt(JTextField textField){
        boolean result = true;
        try{
            String inString = textField.getText();
            Integer.parseInt(inString);
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Var god ange ett giltigt UserID!");
            result = false;
        }
        return result;
    }
    
    public static boolean isStringNull(String text){
        boolean result = true;
        if(text.equals("")){
            JOptionPane.showMessageDialog(null, "Din sökning gav inga träffar.");
            result = false;
        }
        return result;
    }
    
    public static boolean isArrayListStringNull(ArrayList<String> list){
        boolean result = true;
        if(list == null){
            JOptionPane.showMessageDialog(null, "Din s?kning gav inga tr?ffar.");
            result = false;
        }
        return result;
    }
    
    public static boolean checkName(JTextField textField){
        boolean resultat = true;
        if(!textField.getText().isEmpty()){
            if(textField.getText().length() > 20){
                JOptionPane.showMessageDialog(null, "Max 20 tecken!");
                resultat = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte angivit n?got namn.");
            resultat = false;
        }
        return resultat;
    }
    
}

