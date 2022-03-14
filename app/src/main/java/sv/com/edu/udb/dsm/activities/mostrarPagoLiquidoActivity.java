package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import sv.com.udb.dsm.R;

public class mostrarPagoLiquidoActivity extends AppCompatActivity {

    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pago_liquido);
        txtResultado = findViewById(R.id.txtResultado);

        Bundle bundle = getIntent().getExtras();
        String nombreU = bundle.getString("nombreUno");
        String apellidoU = bundle.getString("apellidoUno");
        String cargoU = bundle.getString("cargoUno");
        String salarioU = bundle.getString("salarioUno");
        String nombreD = bundle.getString("nombreDos");
        String apellidoD = bundle.getString("apellidoDos");
        String cargoD = bundle.getString("cargoDos");
        String salarioD = bundle.getString("salarioDos");
        String nombreT = bundle.getString("nombreTres");
        String apellidoT = bundle.getString("apellidoTres");
        String cargoT = bundle.getString("cargoTres");
        String salarioT = bundle.getString("salarioTres");

        String Resultados = "Empleado Uno\n"+
                "Nombre: " + nombreU + "\n" +
                "Apellido: " + apellidoU + "\n"+
                "Cargo: " + cargoU + "\n"+
                "Salario Liquido: " + salarioU  + "\n\n\n"+
                "Empleado Dos\n"+
                "Nombre: " + nombreD + "\n"+
                "Apellido: " + apellidoD + "\n"+
                "Cargo: " + cargoD + "\n"+
                "Salario Liquido: " + salarioD + "\n\n\n"+
                "Empleado Tres\n"+
                "Nombre: " + nombreT + "\n"+
                "Apellido: " + apellidoT + "\n"+
                "Cargo: " + cargoT + "\n"+
                "Salario Liquido: " + salarioT + "\n";

        txtResultado.setText(Resultados);
    }
}