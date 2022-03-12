package sv.com.edu.udb.dsm.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginSqliteActivity extends SQLiteOpenHelper {
    public LoginSqliteActivity(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Login(user text not null,contrasenia text not null)");
        db.execSQL("INSERT INTO Login (user, contrasenia) VALUES ('Marko', '123456')");
        db.execSQL("INSERT INTO Login (user, contrasenia) VALUES ('Denys', '654321')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
