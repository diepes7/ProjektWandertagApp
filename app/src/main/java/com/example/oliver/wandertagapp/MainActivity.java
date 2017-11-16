package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnAnmeldenClick;
    private boolean loginSuccessful;
    private int benutzer_type;              //1 = Admin; 2 = Veranstalter; 3 = Benutzer
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initVariables();
        //initButtonClick();
        setContentView(R.layout.activity_login);
    }
    /*
    private void initVariables() {
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        btnAnmeldenClick = (Button) findViewById(R.id.email_sign_in_button);

    }

    private void initButtonClick() {
        btnAnmeldenClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLoginData();
            }
        });
    }

    private void checkLoginData() {
        if (loginSuccessful && benutzer_type == 1){
            intent = new Intent(getApplicationContext(), AdminPage.class);
            startActivity(intent);
        }
        if (loginSuccessful && benutzer_type == 2){
            intent = new Intent(getApplicationContext(), VerwaltungPage.class);
            startActivity(intent);
        }
        if (loginSuccessful && benutzer_type == 3){
            intent = new Intent(getApplicationContext(), BenutzerPage.class);
            startActivity(intent);
        }
    }
*/




}
