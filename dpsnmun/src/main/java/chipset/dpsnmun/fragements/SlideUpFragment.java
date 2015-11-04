package chipset.dpsnmun.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
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

    String cri = "<font COLOR=\"#FFFFFF\">Commitment Redefined</font><font COLOR=\"#1fd571\"> in...</font>";
    String cr = "<font COLOR=\"#FFFFFF\">Commitment</font><font COLOR=\"#1fd571\"> Redefined</font>";

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
        winTextView.setText(Html.fromHtml(cri));

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
                                event.set(2015, Calendar.OCTOBER, 30, 7, 15, 0);
                                if (current.before(event)) {
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
                                    winTextView.setText(Html.fromHtml(cr));
                                    String date = "<font COLOR=\"#1fd571\">30th - 31st</font><font COLOR=\"#FFFFFF\"> October,</font><font COLOR=\"#1fd571\"> 2015</font>";
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
