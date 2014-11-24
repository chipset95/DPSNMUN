package chipset.dpsnmun.fragements;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import chipset.dpsnmun.R;
import chipset.dpsnmun.resources.Functions;

import static chipset.dpsnmun.resources.Constants.URL_HGA;
import static chipset.dpsnmun.resources.Constants.URL_ICC;
import static chipset.dpsnmun.resources.Constants.URL_IMF;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.fragments
 * Project : DPSNMUN'14
 * Date : 22/11/14
 */
public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_details, container,
                false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView committeeOneImageView, committeeTwoImageView, committeeThreeImageView, committeeFourImageView;
        committeeOneImageView = (ImageView) view.findViewById(R.id.coiv);
        committeeTwoImageView = (ImageView) view.findViewById(R.id.ctwiv);
        committeeThreeImageView = (ImageView) view.findViewById(R.id.cthiv);
        committeeFourImageView = (ImageView) view.findViewById(R.id.cfiv);

        committeeOneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.hga_data));
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.setNegativeButton(R.string.md, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Functions.funkit().browserIntent(view.getContext(), URL_HGA);
                    }
                });
                alertDialog.create();
                alertDialog.show();
            }
        });

        committeeTwoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.imf_data));
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.setNegativeButton(R.string.md, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Functions.funkit().browserIntent(view.getContext(), URL_IMF);
                    }
                });
                alertDialog.create();
                alertDialog.show();
            }
        });

        committeeThreeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.icc_data));
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.setNegativeButton(R.string.md, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Functions.funkit().browserIntent(view.getContext(), URL_ICC);
                    }
                });
                alertDialog.create();
                alertDialog.show();
            }
        });

        committeeFourImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.whsr_data));
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.create();
                alertDialog.show();
            }
        });

    }


}
