package mx.edu.ittepic.ejemplo1sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar clase DBAdapter
        DBAdapter db = new DBAdapter(this);
        //---Añadir datos
        db.open();
        long id = db.insertContact("Naty", "naty@ejemplo.com");
        id = db.insertContact("Rito Reyes", "ritor@mail.com");
        id = db.insertContact("Carlita Godinez", "carlag@mail.com");
        id = db.insertContact("Julio Cesar", "jvalencia@mail.com");
        id = db.insertContact("David Samaniego", "david@mail.com");
        id = db.insertContact("Samuel Sanchez", "samuels@mail.com");
        id = db.insertContact("Ramiro Ramirez", "rramirez@mail.com");
        id = db.insertContact("Hola", "hhola@mail.com");
        id = db.insertContact("Nuevo Nombre", "nuevo@mail.com");
        id = db.insertContact("Oscar Lopez", "olopez@mail.com");
        db.close();
        db.open();
        // Explorar el cursos
        Cursor c = db.getAllContacts();
        if (c.moveToFirst()) {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }
    // Desplegar el contenido vía Toast
    public void DisplayContact(Cursor c) {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2),
                Toast.LENGTH_LONG).show();
    }
}
