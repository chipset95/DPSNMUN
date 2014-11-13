package chipset.dpsnmun.whsr.applications;

import android.app.Application;

import com.parse.Parse;

import static chipset.dpsnmun.whsr.resources.Constants.APPLICATION_ID;
import static chipset.dpsnmun.whsr.resources.Constants.CLIENT_KEY;

/**
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.applications
 * Project : WHSR
 * Date : 6/11/14
 */
public class WHSRInitApplication extends Application {

    public void onCreate() {
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
    }
}
