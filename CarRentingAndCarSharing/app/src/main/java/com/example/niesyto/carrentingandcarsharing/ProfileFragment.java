package com.example.niesyto.carrentingandcarsharing;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private static final String TAG ="Profil";
    SessionManager session;
    TextView txtUserName;
    Button btnLogout, btnChangePassword;
    EditText txtNewPassword, txtOldPassword, txtConfirmNewPassword;
    DialogInterface.OnClickListener dialogClickListener;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        session=new SessionManager(getContext().getApplicationContext());

        txtUserName=(TextView) view.findViewById(R.id.name);
        btnLogout=(Button) view.findViewById(R.id.logoutButton);
        btnChangePassword=(Button) view.findViewById(R.id.changePasswordButton);
        txtNewPassword=(EditText) view.findViewById(R.id.newPassword);
        txtOldPassword=(EditText) view.findViewById(R.id.oldPassword);
        txtConfirmNewPassword=(EditText) view.findViewById(R.id.newPasswordConfirm);

        txtUserName.setText(session.getUserEmail());

        /**
         * Logout button click event
         * */
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                session.logoutUser();
            }
        });


        /**
         * Change password button click event
         * */
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Get passwords from EditText
                String passwordNew = txtNewPassword.getText().toString();
                String passwordNewConfirm = txtConfirmNewPassword.getText().toString();
                String passwordOld = txtOldPassword.getText().toString();




                //*************************
                //NAJPIERW SPRAWDZAENIE CZY passwordOld jest poprawne!!!
                //*************************


                // Check if all fields are filled
                if(passwordNew.trim().length() > 0 && passwordNewConfirm.trim().length() > 0 && passwordOld.trim().length() > 0){
                    if(passwordNew.equals(passwordNewConfirm)){
                        if(passwordNew.equals(passwordOld)) {
                            // new and old passwords are the same
                            Toast.makeText(getContext().getApplicationContext(), "Nowe hasło nie może być takie samo jak stare", Toast.LENGTH_LONG).show();
                        }
                        else{
                            //Change password
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setMessage("Czy na pewno chcesz zmienić hasło?").setPositiveButton("Tak", dialogClickListener)
                                    .setNegativeButton("Nie", dialogClickListener).show();
                            dialogClickListener = new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which){
                                        case DialogInterface.BUTTON_POSITIVE:
                                            //Yes button clicked

                                            /*

                                            *****************************
                                            * tu wrzucić zmianę hasła

                                             */

                                            break;

                                        case DialogInterface.BUTTON_NEGATIVE:
                                            //No button clicked
                                            //Nothing happens
                                            break;
                                    }
                                }
                            };

                        }
                    }else{
                        // password doesn't match
                        Toast.makeText(getContext().getApplicationContext(), "Wpisane hasła nie są takie same", Toast.LENGTH_LONG).show();
                    }
                }else{
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                    Toast.makeText(getContext().getApplicationContext(), "Proszę podac wszystkie dane", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }


}
