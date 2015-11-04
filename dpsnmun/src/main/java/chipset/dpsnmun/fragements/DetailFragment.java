package chipset.dpsnmun.fragements;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import chipset.dpsnmun.R;
import chipset.potato.Potato;

import static chipset.dpsnmun.resources.Constants.URL_GA;
import static chipset.dpsnmun.resources.Constants.URL_GS;
import static chipset.dpsnmun.resources.Constants.URL_HRC;
import static chipset.dpsnmun.resources.Constants.URL_NPT;
import static chipset.dpsnmun.resources.Constants.URL_WHRC;
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

        ImageView gaImageView, whsrImageView, gsImageView, mptImageView, hrcImageView;
        gaImageView = (ImageView) view.findViewById(R.id.ga);
        whsrImageView = (ImageView) view.findViewById(R.id.whsr);
        gsImageView = (ImageView) view.findViewById(R.id.gs);
        mptImageView = (ImageView) view.findViewById(R.id.npt);
        hrcImageView = (ImageView) view.findViewById(R.id.hrc);

        gaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.ga_data));
                alertDialog.setNegativeButton("Background Guide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Potato.potate().Intents().browserIntent(getContext(), URL_GA);
                    }
                });
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.create();
                alertDialog.show();
            }
        });

        whsrImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.whsr_data));
                alertDialog.setNegativeButton("Background Guide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Potato.potate().Intents().browserIntent(getContext(), URL_WHRC);
                    }
                });
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.create();
                alertDialog.show();
            }
        });

        gsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.gs_data));
                alertDialog.setNegativeButton("Background Guide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Potato.potate().Intents().browserIntent(getContext(), URL_GS);
                    }
                });
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.create();
                alertDialog.show();
            }
        });

        mptImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.npt_data));
                alertDialog.setNegativeButton("Background Guide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Potato.potate().Intents().browserIntent(getContext(), URL_NPT);
                    }
                });
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.create();
                alertDialog.show();
            }
        });

        hrcImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setMessage(view.getContext().getResources().getString(R.string.hrc_data));
                alertDialog.setNegativeButton("Background Guide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Potato.potate().Intents().browserIntent(getContext(), URL_HRC);
                    }
                });
                alertDialog.setPositiveButton(android.R.string.ok, null);
                alertDialog.create();
                alertDialog.show();
            }
        });

    }


}
