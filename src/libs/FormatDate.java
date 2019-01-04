/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad
 */
public class FormatDate {
    
    public String format(Date dates, String format) {
        if(dates == null) {
            return null;
        }
        String date = null;
        SimpleDateFormat formatDate = new SimpleDateFormat(format);
        date = formatDate.format(dates);
        return date;
    }
    
    public String formatTo(String dates, String fromDate, String toDate) {
        String date = null;
        SimpleDateFormat dateDB = new SimpleDateFormat(fromDate);
        SimpleDateFormat dateFormat= new SimpleDateFormat(toDate);
        try {
            date = dateFormat.format(dateDB.parse(dates));
        } catch (ParseException ex) {
            Logger.getLogger(FormatDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
}
