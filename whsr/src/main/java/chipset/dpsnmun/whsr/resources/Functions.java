package chipset.dpsnmun.whsr.resources;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.resources
 * Project : WHSR
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

}
