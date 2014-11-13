package chipset.dpsnmun.whsr.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import chipset.dpsnmun.whsr.R;
import chipset.dpsnmun.whsr.adapters.MessagesListViewAdapter;

import static chipset.dpsnmun.whsr.resources.Constants.CLASS_MESSAGES;
import static chipset.dpsnmun.whsr.resources.Constants.KEY_MESSAGE;
/*
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.activities
 * Project : WHSR
 * Date : 9/11/14
 */

public class MainActivity extends ActionBarActivity {

    ListView messagesListView;
    String[] messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messagesListView = (ListView) findViewById(R.id.messages_list_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ParseQuery<ParseObject> query = ParseQuery.getQuery(CLASS_MESSAGES);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    messages = new String[parseObjects.size()];
                    for (int i = 0; i < parseObjects.size(); i++) {
                        messages[i] = parseObjects.get(i).getString(KEY_MESSAGE);

                        messagesListView.setAdapter(new MessagesListViewAdapter(getApplicationContext(), messages));
                        messagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage(messages[i]).setNeutralButton(android.R.string.ok, null).create().show();
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
