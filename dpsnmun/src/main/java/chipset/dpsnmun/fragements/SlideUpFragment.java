package chipset.dpsnmun.fragements;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import chipset.dpsnmun.R;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.fragments
 * Project : DPSNMUN'14
 * Date : 22/11/14
 */
public class SlideUpFragment extends Fragment {

    String wic = "<font COLOR=\"#FFFFFF\">Winter</font><font COLOR=\"#1fd571\"> is coming...</font>";
    String wih = "<font COLOR=\"#FFFFFF\">Winter,</font><font COLOR=\"#1fd571\"> is here!</font>";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_slide_up, container,
                false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView winTextView, winhTextView;
        winTextView = (TextView) view.findViewById(R.id.winTextView);
        winhTextView = (TextView) view.findViewById(R.id.countTextView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted())
                    try {
                        Thread.sleep(1000);
                        getActivity().runOnUiThread(new Runnable() // start actions in UI thread
                        {

                            @Override
                            public void run() {
                                Calendar current = Calendar.getInstance();
                                Calendar event = Calendar.getInstance();
                                Log.i("C", current.getTime().toString());
                                event.set(2014, Calendar.DECEMBER, 2, 8, 0, 0);
                                Log.i("E", event.getTime().toString());
                                if (current.before(event)) {
                                    winTextView.setText(Html.fromHtml(wic));
                                    long cur = current.getTimeInMillis();
                                    long eve = event.getTimeInMillis();
                                    long milliseconds = eve - cur;
                                    int seconds = (int) (milliseconds / 1000) % 60;
                                    int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
                                    int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
                                    int days = (int) (milliseconds / (1000 * 60 * 60 * 24));
                                    String day = "<font COLOR=\"#1fd571\">" + days + " </font><font COLOR=\"#FFFFFF\">days</font><br>";
                                    String hour = "<font COLOR=\"#1fd571\">" + hours + " </font><font COLOR=\"#FFFFFF\">hours</font><br>";
                                    String minute = "<font COLOR=\"#1fd571\">" + minutes + " </font><font COLOR=\"#FFFFFF\">minutes</font><br>";
                                    String second = "<font COLOR=\"#1fd571\">" + seconds + " </font><font COLOR=\"#FFFFFF\">seconds</font><br>";
                                    winhTextView.setText(Html.fromHtml(day + hour + minute + second));
                                    winhTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
                                } else {
                                    winTextView.setText(Html.fromHtml(wih));
                                    String date = "<font COLOR=\"#1fd571\">2-3</font><font COLOR=\"#FFFFFF\"> December,</font><font COLOR=\"#1fd571\"> 2014</font>";
                                    winhTextView.setText(Html.fromHtml(date));
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }).start();
    }
}
