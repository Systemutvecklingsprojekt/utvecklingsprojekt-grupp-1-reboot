/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.helpers;

import com.toedter.calendar.IDateEvaluator;
import java.awt.Color;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anton
 */
public class SpecialDateEvaluator implements IDateEvaluator{

    private final List<Date> specialDates;

    public SpecialDateEvaluator(List<Date> specialDates) {
        this.specialDates = specialDates;
    }

    @Override
    public boolean isSpecial(Date date) {
        for (Date d : specialDates) {
            if (d.equals(date)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Color getSpecialForegroundColor() {
        return Color.black;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return Color.red;
    }

    @Override
    public String getSpecialTooltip() {
        return null;
    }

    @Override
    public boolean isInvalid(Date date) {
        return false;
    }

    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }

    @Override
    public String getInvalidTooltip() {
        return null;
    }
    
}
