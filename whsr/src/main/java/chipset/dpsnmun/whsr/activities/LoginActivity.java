package chipset.dpsnmun.whsr.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;

import chipset.dpsnmun.whsr.R;

/*
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.activities
 * Project : WHSR
 * Date : 6/11/14
 */

public class LoginActivity extends ActionBarActivity {

    EditText loginUsernameEditText, loginPasswordEditText;
    Button loginButton, adviceButton;
    ParseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsernameEditText = (EditText) findViewById(R.id.login_username_edit_text);
        loginPasswordEditText = (EditText) findViewById(R.id.login_password_edit_text);
        loginButton = (Button) findViewById(R.id.login_button);
        adviceButton = (Button) findViewById(R.id.advice_button);
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(true);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                if (!loginUsernameEditText.getText().toString().isEmpty() && !loginPasswordEditText.getText().toString().isEmpty()) {
                    try {
                        user = ParseUser.logIn(loginUsernameEditText.getText().toString(), loginPasswordEditText.getText().toString());
                    } catch (ParseException e) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    } finally {
                        if (user != null) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), user.getUsername(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }
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
