package chipset.dpsnmun.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import chipset.dpsnmun.R;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.activities
 * Project : WHSR
 * Date : 9/11/14
 */

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    protected void onPause() {
//        ParseUser.logOut();
//        super.onPause();
//    }
}
