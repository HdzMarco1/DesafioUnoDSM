package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.com.udb.dsm.R;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUser,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser =(EditText)findViewById(R.id.txtUser);
        txtPassword =(EditText)findViewById(R.id.txtPassword);
    }

    public void onClick(View View){
        LoginSqliteActivity admin = new  LoginSqliteActivity(this, "login", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        if(db!= null){
            String usuarioE = txtUser.getText().toString();
            String contraE = txtPassword.getText().toString();
            Cursor fila = db.rawQuery("select user, contrasenia from Login where user='" + usuarioE + "' AND contrasenia='" + contraE +"';" , null);

            if(fila.moveToFirst()){
                txtUser.setText(fila.getString(0));
                txtPassword.setText(fila.getString(1));
                //Toast.makeText(this, "si puede ingresar", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, HomeActivity.class);
                startActivity(i);
            }else
                Toast.makeText(this, "usuario y contraseña incorrectas",
                        Toast.LENGTH_SHORT).show();
            db.close();
        }else{
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }


    }

//    private void savePreferences(){
//        SharedPreferences preferences = getSharedPreferences(CREDENCIALES, Context.MODE_PRIVATE);
//        String usuario = user.getText().toString();
//        String pass = password.getText().toString();
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(USER, usuario);
//        editor.putString(PASS, pass);
//        editor.commit();
//    }

}
