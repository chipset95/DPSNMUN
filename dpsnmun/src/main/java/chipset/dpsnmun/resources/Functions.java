package chipset.dpsnmun.resources;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    /*
     * Function to start email intent
     */

    public void emailIntent(Context context, String to, String subject, String body) {
        StringBuilder builder = new StringBuilder("mailto:" + Uri.encode(to));
        if (subject != null) {
            builder.append("?subject=" + subject);
            if (body != null) {
                builder.append("&body=" + body);
            }
        }
        String uri = builder.toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
        context.startActivity(intent);
    }

    /*
     * Function to start browser intent
     */
    public void browserIntent(Context context, String url) {
        context.startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /*
     * Function to place a call
     */
    public void callIntent(Context context, String phoneNo) {
        String uri = "tel:" + phoneNo;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(uri));
        context.startActivity(intent);
    }
}
