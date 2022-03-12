package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.com.udb.dsm.R;

public class LoginActivity extends AppCompatActivity {

    public static final String CREDENCIALES = "credenciales";
    public static final String USER = "user";
    public static final String PASS = "pass";
    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.txtUser);
        password =  findViewById(R.id.txtPassword);
    }

    public void onClick(View View){
        savePreferences();
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    private void savePreferences(){
        SharedPreferences preferences = getSharedPreferences(CREDENCIALES, Context.MODE_PRIVATE);
        String usuario = user.getText().toString();
        String pass = password.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER, usuario);
        editor.putString(PASS, pass);
        editor.commit();
    }

}
