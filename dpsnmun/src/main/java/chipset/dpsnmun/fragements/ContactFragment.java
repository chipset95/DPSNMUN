package chipset.dpsnmun.fragements;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import chipset.dpsnmun.R;
import chipset.dpsnmun.resources.Constants;
import chipset.potato.Potato;

import static chipset.dpsnmun.resources.Constants.PHONE_AK;
import static chipset.dpsnmun.resources.Constants.PHONE_MA;
import static chipset.dpsnmun.resources.Constants.PHONE_SA;
import static chipset.dpsnmun.resources.Constants.PHONE_SCHOOL;
import static chipset.dpsnmun.resources.Constants.PHONE_TJ;
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

    private final int CALL_PERMISSIONS_REQUEST = 1;
    private Button call1Button, callMAButton, callSAButton, callAKButton, callTJButton;
    private View theView;
    private Snackbar snackbar;

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
        theView = view;

        ImageButton fbImageButton, twImageButton, mailImageButton;

        fbImageButton = (ImageButton) view.findViewById(R.id.fbButton);
        twImageButton = (ImageButton) view.findViewById(R.id.twButton);
        mailImageButton = (ImageButton) view.findViewById(R.id.mailButton);

        permissionRequest();

        fbImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Potato.potate().Intents().browserIntent(getContext(), URL_FB);
            }
        });

        twImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Potato.potate().Intents().browserIntent(getContext(), URL_TW);
            }
        });

        mailImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Potato.potate().Intents().emailIntent(getContext(), URL_MAIL, "DPSNMUN'15", "\n\n-Sent from Android App\n\nGet it now: " + Constants.URL_APP);
            }
        });

    }

    protected void permissionRequest() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            setupClickListeners();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.CALL_PHONE)) {
                snackbar = Snackbar.make(theView, "Calling permission is required for added functionality",
                        Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Request the permission
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.CALL_PHONE},
                                CALL_PERMISSIONS_REQUEST);
                    }
                });
                snackbar.show();

            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE},
                        CALL_PERMISSIONS_REQUEST);
            }
        }

    }

    private void setupClickListeners() {
        snackbar = Snackbar.make(theView, "Tap a name to place a call!", Snackbar.LENGTH_INDEFINITE)
                .setAction(android.R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
        snackbar.show();

        call1Button = (Button) theView.findViewById(R.id.call1Button);
        callMAButton = (Button) theView.findViewById(R.id.callMAButton);
        callSAButton = (Button) theView.findViewById(R.id.callSAButton);
        callAKButton = (Button) theView.findViewById(R.id.callAKButton);
        callTJButton = (Button) theView.findViewById(R.id.callTJButton);

        call1Button.setOnClickListener(new View.OnClickListener()

                                       {
                                           @Override
                                           public void onClick(View view) {
                                               new AlertDialog.Builder(getActivity())
                                                       .setMessage("Call DPS Noida?")
                                                       .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                           @Override
                                                           public void onClick(DialogInterface dialog, int which) {
                                                               Potato.potate().Intents().callIntent(getContext(), PHONE_SCHOOL);
                                                           }
                                                       })
                                                       .setNegativeButton(android.R.string.no, null)
                                                       .create().show();

                                           }
                                       }

        );

        callMAButton.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View view) {
                                                new AlertDialog.Builder(getActivity())
                                                        .setMessage("Call Millind?")
                                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Potato.potate().Intents().callIntent(getContext(), PHONE_MA);
                                                            }
                                                        })
                                                        .setNegativeButton(android.R.string.no, null)
                                                        .create().show();
                                            }
                                        }

        );

        callSAButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                new AlertDialog.Builder(getActivity())
                                                        .setMessage("Call Sahil?")
                                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Potato.potate().Intents().callIntent(getContext(), PHONE_SA);
                                                            }
                                                        })
                                                        .setNegativeButton(android.R.string.no, null)
                                                        .create().show();
                                            }
                                        }

        );

        callAKButton.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View view) {
                                                new AlertDialog.Builder(getActivity())
                                                        .setMessage("Call Abhinav?")
                                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Potato.potate().Intents().callIntent(getContext(), PHONE_AK);
                                                            }
                                                        })
                                                        .setNegativeButton(android.R.string.no, null)
                                                        .create().show();
                                            }
                                        }

        );

        callTJButton.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View view) {
                                                new AlertDialog.Builder(getActivity())
                                                        .setMessage("Call Ms. Tejinder?")
                                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Potato.potate().Intents().callIntent(getContext(), PHONE_TJ);
                                                            }
                                                        })
                                                        .setNegativeButton(android.R.string.no, null)
                                                        .create().show();
                                            }
                                        }

        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == CALL_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupClickListeners();
            } else {
                Snackbar.make(theView, "Call permission request was denied",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (snackbar.isShown())
            snackbar.dismiss();
    }
}
