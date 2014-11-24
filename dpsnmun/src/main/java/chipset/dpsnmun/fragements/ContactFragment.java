package chipset.dpsnmun.fragements;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import chipset.dpsnmun.R;
import chipset.dpsnmun.resources.Functions;

import static chipset.dpsnmun.resources.Constants.PHONE_SANKALP;
import static chipset.dpsnmun.resources.Constants.PHONE_SCHOOL;
import static chipset.dpsnmun.resources.Constants.URL_FB;
import static chipset.dpsnmun.resources.Constants.URL_MAIL;
import static chipset.dpsnmun.resources.Constants.URL_TW;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.fragments
 * Project : DPSNMUN'14
 * Date : 22/11/14
 */
public class ContactFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_contact, container,
                false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton fbImageButton, twImageButton, mailImageButton;
        Button call1Button, call2Button;

        fbImageButton = (ImageButton) view.findViewById(R.id.fbButton);
        twImageButton = (ImageButton) view.findViewById(R.id.twButton);
        mailImageButton = (ImageButton) view.findViewById(R.id.mailButton);
        call1Button = (Button) view.findViewById(R.id.call1Button);
        call2Button = (Button) view.findViewById(R.id.call2Button);

        fbImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.funkit().browserIntent(view.getContext(), URL_FB);
            }
        });
        twImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.funkit().browserIntent(view.getContext(), URL_TW);
            }
        });
        mailImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.funkit().emailIntent(view.getContext(), URL_MAIL, "DPSN MUN'14", "\n\n-Sent from Android App");
            }
        });
        call1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.funkit().callIntent(view.getContext(), PHONE_SCHOOL);
            }
        });
        call2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.funkit().callIntent(view.getContext(), PHONE_SANKALP);
            }
        });

    }


}
