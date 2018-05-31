package mx.edu.ittepic.sqlyrecyclerview;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton add,delete,edit,list;
    EditText clave,nombre,salario;

    RecyclerView empleados;
    CardDato adapter;
    List<Datos> empleadosList;

    ConexionDB conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.btnAdd);
        delete=findViewById(R.id.btnDelete);
        edit=findViewById(R.id.btnEdit);
        list=findViewById(R.id.btnList);

        clave=findViewById(R.id.edtClave);
        nombre=findViewById(R.id.edtNombre);
        salario=findViewById(R.id.edtSalario);

        empleados=findViewById(R.id.recyclerEmp);
        empleados.setHasFixedSize(true);
        empleados.setLayoutManager(new LinearLayoutManager(this));

        empleadosList= new ArrayList<>();

        conexion=new ConexionDB(this,"baseRecyclerSQL",null,1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar(clave.getText().toString(),nombre.getText().toString(),salario.getText().toString());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar(clave.getText().toString());
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar(clave.getText().toString(),nombre.getText().toString(),salario.getText().toString());
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consulta();
            }
        });

    }

    private void consulta() {
        try{
            SQLiteDatabase db= conexion.getReadableDatabase();
            String sql="SELECT * FROM EMPLEADO";
            Cursor result=db.rawQuery(sql,null);
            if(result.getCount()<= 0){
                return;
            }
            while(result.moveToNext()){
                empleadosList.add(
                        new Datos(result.getString(0),
                                result.getString(1),
                                result.getString(2))
                );
            }
            db.close();
            adapter = new CardDato(this,empleadosList);
            empleados.setAdapter(adapter);
            empleadosList= new ArrayList<>();
        }catch (SQLException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void editar(String clave,String nombre,String salario) {
        try{
            SQLiteDatabase base=conexion.getWritableDatabase();
            String SQL="UPDATE EMPLEADO SET NOMBRE= '<NOMBRE>', SALARIO=<SALARIO> WHERE CLAVE="+clave;
            SQL=SQL.replace("<NOMBRE>",nombre);
            SQL=SQL.replace("<SALARIO>",salario);

            base.execSQL(SQL);
            base.close();
            Toast.makeText(this,"Se editó correctamente!",Toast.LENGTH_LONG).show();
            inicializar();

        }catch (SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    private void borrar(String clave) {
        try{
            SQLiteDatabase base=conexion.getWritableDatabase();
            String SQL="DELETE FROM EMPLEADO WHERE CLAVE="+clave;
            base.execSQL(SQL);
            base.close();
            Toast.makeText(this,"Se borró correctamente!",Toast.LENGTH_LONG).show();
            inicializar();

        }catch (SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void agregar(String clave,String nombre,String salario) {
        try{
            SQLiteDatabase base=conexion.getWritableDatabase();
            String SQL="INSERT INTO EMPLEADO VALUES('<CLAVE>','<NOMBRE>',<SALARIO>)";
            SQL=SQL.replace("<CLAVE>",clave);
            SQL=SQL.replace("<NOMBRE>",nombre);
            SQL=SQL.replace("<SALARIO>",salario);

            base.execSQL(SQL);

            base.close();

            Toast.makeText(this,"Se guardó correctamente!",Toast.LENGTH_LONG).show();
            inicializar();

        }catch (SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void inicializar() {
        this.clave.setText("");
        this.nombre.setText("");
        this.salario.setText("");
    }
}
