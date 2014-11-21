package chipset.dpsnmun.resources;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Calendar;
import java.util.Date;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.resources
 * Project : DPSNMUN'14
 * Date : 16/11/14
 */
public class Functions {

    public static Functions funkit() {
        return new Functions();
    }

    /*
     * Function to hide keyboard
     */
    public void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public Date addDays(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
    }
}
