package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnAnmeldenClick;
    private boolean loginSuccessful;
    private int benutzer_type;              //1 = Admin; 2 = Veranstalter; 3 = Benutzer
    private Intent intent;
    public static ArrayList<Veranstaltung> al_Veranstaltungen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initVariables();
        //initButtonClick();
        initArrayListVeranstaltungen();
        setContentView(R.layout.activity_main);
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    private void initArrayListVeranstaltungen() {
        al_Veranstaltungen = new ArrayList<>();

        List<Teilnehmer> teilnehmerList = new ArrayList<>();
        teilnehmerList.add(new Teilnehmer("Oliver", "Dieplinger", "12.02.1999", "M", "Königsdorf 27", "St. Agatha", "Österreich", "olivero.dieplinger@gmail.com", "069918338186"));
        teilnehmerList.add(new Teilnehmer("Stefan", "Hammerschmied", "12.02.1999", "M", "Königsdorf 27", "St. Agatha", "Österreich", "olivero.dieplinger@gmail.com", "069918338186"));
        teilnehmerList.add(new Teilnehmer("Flavius", "Stoianov", "12.02.1999", "M", "Königsdorf 27", "St. Agatha", "Österreich", "olivero.dieplinger@gmail.com", "069918338186"));
        teilnehmerList.add(new Teilnehmer("Bruce", "Lang", "12.02.1999", "M", "Königsdorf 27", "St. Agatha", "Österreich", "olivero.dieplinger@gmail.com", "069918338186"));
        teilnehmerList.add(new Teilnehmer("Max", "Haslehner", "12.02.1999", "M", "Königsdorf 27", "St. Agatha", "Österreich", "olivero.dieplinger@gmail.com", "069918338186"));

        al_Veranstaltungen.add(new Veranstaltung("Neujahrs Ausflug", "Teststraße 10", "Grieskirchen", "Österreich", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Oster Ausflug", "Teststraße 14", "Walding", "Österreich", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Sommer Ausflug", "Wildstraße 8", "München", "Deutschland", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Winter Ausflug", "Wildstraße 8", "München", "Deutschland", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Senioren Ausflug", "Wildstraße 8", "München", "Deutschland", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Abend Ausflug", "Wildstraße 8", "München", "Österreich", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Frühlings Ausflug", "Wildstraße 8", "Wien", "Österreich", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));
        al_Veranstaltungen.add(new Veranstaltung("Herbst Ausflug", "Wildstraße 8", "München", "Deutschland", "069912556485", "stefan@gmail.com", teilnehmerList, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Wandertag", "Es wird ein schöner Tag", "Fritz Peter", true));

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

    public EditText getEditTextEmail() {
        return editTextEmail;
    }

    public void setEditTextEmail(EditText editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public EditText getEditTextPassword() {
        return editTextPassword;
    }

    public void setEditTextPassword(EditText editTextPassword) {
        this.editTextPassword = editTextPassword;
    }

    public Button getBtnAnmeldenClick() {
        return btnAnmeldenClick;
    }

    public void setBtnAnmeldenClick(Button btnAnmeldenClick) {
        this.btnAnmeldenClick = btnAnmeldenClick;
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        this.loginSuccessful = loginSuccessful;
    }

    public int getBenutzer_type() {
        return benutzer_type;
    }

    public void setBenutzer_type(int benutzer_type) {
        this.benutzer_type = benutzer_type;
    }

    @Override
    public Intent getIntent() {
        return intent;
    }

    @Override
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public static ArrayList<Veranstaltung> getAl_Veranstaltungen() {
        return al_Veranstaltungen;
    }

    public static void setAl_Veranstaltungen(ArrayList<Veranstaltung> al_Veranstaltungen) {
        MainActivity.al_Veranstaltungen = al_Veranstaltungen;
    }
}
