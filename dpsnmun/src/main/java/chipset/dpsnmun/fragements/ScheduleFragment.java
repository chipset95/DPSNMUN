package chipset.dpsnmun.fragements;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chipset.dpsnmun.R;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.fragments
 * Project : DPSNMUN'14
 * Date : 24/11/14
 */
public class ScheduleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_schedule, container,
                false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
