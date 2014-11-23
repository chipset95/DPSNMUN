package chipset.dpsnmun.fragements;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import chipset.dpsnmun.R;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.fragments
 * Project : DPSNMUN'14
 * Date : 22/11/14
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_home, container,
                false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView homeTextView = (TextView) view.findViewById(R.id.homeTextView);
        String actualStringToDisplay = "<font COLOR=\"#FFFFFF\">DPSN</font><font COLOR=\"#1fd571\"> MUN<font COLOR=\"#FFFFFF\">\'14";
        homeTextView.setText(Html.fromHtml(actualStringToDisplay));

    }


}
