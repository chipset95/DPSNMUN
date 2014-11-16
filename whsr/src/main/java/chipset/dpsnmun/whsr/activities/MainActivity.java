package chipset.dpsnmun.whsr.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nispok.snackbar.Snackbar;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import chipset.dpsnmun.whsr.R;
import chipset.dpsnmun.whsr.adapters.MessagesListViewAdapter;

import static chipset.dpsnmun.whsr.resources.Constants.CLASS_HINTS;
import static chipset.dpsnmun.whsr.resources.Constants.CLASS_MESSAGES;
import static chipset.dpsnmun.whsr.resources.Constants.KEY_HINT;
import static chipset.dpsnmun.whsr.resources.Constants.KEY_MESSAGE;
/*
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.activities
 * Project : WHSR
 * Date : 9/11/14
 */

public class MainActivity extends ActionBarActivity {

    ProgressBar messagesLoadingProgressBar;
    ListView messagesListView;
    String[] messages, hints;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messagesListView = (ListView) findViewById(R.id.messages_list_view);
        messagesLoadingProgressBar = (ProgressBar) findViewById(R.id.messages_loading_progress_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(ParseUser.getCurrentUser().getUsername());
        messagesLoadingProgressBar.setVisibility(View.VISIBLE);
        ParseQuery<ParseObject> queryHints = ParseQuery.getQuery(CLASS_HINTS);
        queryHints.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    hints = new String[parseObjects.size()];
                    for (int i = 0; i < parseObjects.size(); i++) {
                        hints[i] = parseObjects.get(i).getString(KEY_HINT);
                    }
                }
            }
        });
        ParseQuery<ParseObject> queryMessages = ParseQuery.getQuery(CLASS_MESSAGES);
        queryMessages.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                messagesLoadingProgressBar.setVisibility(View.GONE);
                if (e == null) {
                    messages = new String[parseObjects.size()];
                    for (int i = 0; i < parseObjects.size(); i++) {
                        messages[i] = parseObjects.get(i).getString(KEY_MESSAGE);
                        messagesListView.setAdapter(new MessagesListViewAdapter(getApplicationContext(), messages));

                        messagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Snackbar.with(getApplicationContext()).text("MESSAGE WILL SELF DESTRUCT IN 5 SECONDS").show(MainActivity.this);
                                alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                                alertDialog.setMessage(hints[i]);
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
                    }
                } else {
                    messages = new String[1];
                    messages[0] = "Nothing Here";
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        ParseUser.logOut();
        super.onPause();
    }
}
