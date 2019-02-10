package com.example.niesyto.carrentingandcarsharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    // Email, password edittext
    EditText txtEmail, txtPassword;

    // Login, register button
    Button btnLogin,btnRegister;

    // Session Manager Class
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        session = new SessionManager(getApplicationContext());

        btnLogin = (Button) findViewById(R.id.logInButton);
        btnRegister = (Button) findViewById(R.id.backButton);
        txtPassword = (EditText) findViewById(R.id.oldPassword);
        txtEmail = (EditText) findViewById(R.id.eMail);



        /**
         * Login button click event
         * */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Get username, password from EditText
                String eMail = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                // Check if username, password is filled
                if(eMail.trim().length() > 0 && password.trim().length() > 0){
                    if(eMail.equals("test") && password.equals("test")){
                        //*************************
                        //TEGO IF'A ZMIENIĆ!!!!
                        //On ma sprawdzać czy takie dane są w bazie
                        //*************************
                        session.createLoginSession(eMail);

                        // Staring MainActivity
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();

                    }else{
                        // username / password doesn't match
                        Toast.makeText(getApplicationContext(), "Hasło lub email są niepoprawne", Toast.LENGTH_LONG).show();
                    }
                }else{
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                    Toast.makeText(getApplicationContext(), "Nie można zalogować, proszę podać dane", Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         * Register button click event
         * */
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
