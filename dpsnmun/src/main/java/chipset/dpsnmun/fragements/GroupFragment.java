package chipset.dpsnmun.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chipset.dpsnmun.R;

/**
 * Developer: chipset
 * Package : chipset.dpsnmun.fragements
 * Project : DPSNMUN
 * Date : 27/10/15
 */
public class GroupFragment extends Fragment {

    private int pos;

    private GroupFragment setPos(int pos) {
        this.pos = pos;
        return this;
    }

    public static GroupFragment newInstance(int pos) {
        return new GroupFragment().setPos(pos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (pos == 0)
            view = inflater.inflate(R.layout.fragment_group_one, container, false);
        else
            view = inflater.inflate(R.layout.fragment_group_two, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
