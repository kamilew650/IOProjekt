package com.example.niesyto.carrentingandcarsharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button btnBack, btnRegister;
    EditText txtEmail, txtPassword, txtConfirm;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBack = (Button) findViewById(R.id.backButton);
        btnRegister= (Button) findViewById(R.id.createAccountButton);
        txtEmail =(EditText) findViewById(R.id.eMail);
        txtPassword =(EditText) findViewById(R.id.oldPassword);
        txtConfirm=(EditText) findViewById(R.id.passwordConfirm);

        session = new SessionManager(getApplicationContext());

        /**
         * Registen button click event
         * */
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Get username, password from EditText
                String eMail = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                String confirm = txtPassword.getText().toString();




                /*
                Dołożyć:
                -Taki email jest just w bazie
                -Hasła nie są takie same
                 */

                // Check if username, password is filled
                if(eMail.trim().length() > 0 && password.trim().length() > 0 && confirm.trim().length() > 0){
                    if(eMail.equals(confirm)) {
                        if (eMail.equals("test") && password.equals("test")) {
                            //*************************
                            //TEGO IF'A ZMIENIĆ!!!!
                            //On ma sprawdzać czy takie dane są w bazie
                            //*************************


                            //Creating session after registration
                            session.createLoginSession(eMail);

                            // Staring MainActivity
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // username / password doesn't match
                            Toast.makeText(getApplicationContext(), "Hasło lub email są niepoprawne", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        // Passwords doesn't match
                        Toast.makeText(getApplicationContext(), "Hasła nie są takie same", Toast.LENGTH_LONG).show();
                    }
                }else{
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                    Toast.makeText(getApplicationContext(), "Nie można zarejestrować, proszę podać dane", Toast.LENGTH_LONG).show();
                }
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
