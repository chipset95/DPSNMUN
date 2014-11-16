package chipset.dpsnmun.whsr.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nispok.snackbar.Snackbar;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import chipset.dpsnmun.whsr.R;
import chipset.dpsnmun.whsr.resources.Functions;

import static chipset.dpsnmun.whsr.resources.Constants.KEY_ADMIN;
import static chipset.dpsnmun.whsr.resources.Constants.KEY_LOGIN_COUNT;
/*
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.activities
 * Project : WHSR
 * Date : 6/11/14
 */

public class LoginActivity extends ActionBarActivity {

    EditText loginUsernameEditText, loginPasswordEditText;
    Button loginButton, adviceButton;
    ProgressDialog progressDialog;
    int loginCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_login));
        loginUsernameEditText = (EditText) findViewById(R.id.login_username_edit_text);
        loginPasswordEditText = (EditText) findViewById(R.id.login_password_edit_text);
        loginButton = (Button) findViewById(R.id.login_button);
        adviceButton = (Button) findViewById(R.id.advice_button);
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(true);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Functions.funkit().hideKeyboard(getApplicationContext(), getCurrentFocus());
                progressDialog.show();
                if (!loginUsernameEditText.getText().toString().isEmpty() && !loginPasswordEditText.getText().toString().isEmpty()) {
                    ParseUser.logInInBackground(loginUsernameEditText.getText().toString(), loginPasswordEditText.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (e == null) {
                                if (user.getBoolean(KEY_ADMIN)) {
                                    loginCount = 0;
                                } else {
                                    loginCount = user.getInt(KEY_LOGIN_COUNT);
                                }
                                if (loginCount >= 0 && loginCount < 5) {
                                    loginCount++;
                                    user.put(KEY_LOGIN_COUNT, loginCount);
                                    user.saveInBackground();
                                    progressDialog.dismiss();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    progressDialog.dismiss();
                                    Snackbar.with(getApplicationContext()).text("Cannot exceed 5 logins").show(LoginActivity.this);
                                }
                            } else {
                                progressDialog.dismiss();
                                Snackbar.with(getApplicationContext()).text(e.getMessage()).show(LoginActivity.this);
                            }
                        }
                    });
                } else {
                    progressDialog.dismiss();
                    loginPasswordEditText.setError("Required");
                    loginUsernameEditText.setError("Required");
                }

            }

        });

        adviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage(getResources().getString(R.string.a_word_of_advice));
                builder.setNeutralButton(android.R.string.ok, null);
                builder.create();
                builder.show();
            }
        });
    }
}