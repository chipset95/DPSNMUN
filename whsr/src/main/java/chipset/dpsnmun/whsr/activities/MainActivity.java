package chipset.dpsnmun.whsr.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import chipset.dpsnmun.whsr.R;

import static chipset.dpsnmun.whsr.resources.Constants.KEY_NO_LOGIN;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.activities
 * Project : WHSR
 * Date : 9/11/14
 */

public class MainActivity extends ActionBarActivity {

    AlertDialog alertDialog;
    Button touchHereButton, dontTouchHereButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(ParseUser.getCurrentUser().getUsername());

        touchHereButton = (Button) findViewById(R.id.touch_here_button);
        dontTouchHereButton = (Button) findViewById(R.id.dont_touch_here_button);

        touchHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setMessage(getResources().getString(R.string.touch_here_message));
                alertDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        alertDialog.dismiss();
                        finish();
                    }
                }, 5000);
            }
        });

        dontTouchHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setMessage(getResources().getString(R.string.dont_touch_here_message));
                alertDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final ParseUser user = ParseUser.getCurrentUser();
                        user.put(KEY_NO_LOGIN, true);
                        user.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                Log.d("::TIME::", String.valueOf(user.getUpdatedAt()));
                            }
                        });
                        alertDialog.dismiss();
                        finish();
                    }
                }, 5000);
            }
        });

    }

    @Override
    protected void onPause() {
        ParseUser.logOut();
        super.onPause();
    }
}
