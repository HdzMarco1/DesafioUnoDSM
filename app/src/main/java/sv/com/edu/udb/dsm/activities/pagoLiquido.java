package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import sv.com.udb.dsm.R;

public class pagoLiquido extends AppCompatActivity {

    public static final String EMPTY = "";
    private EditText nombreUno, apellidoUno, cargoUno, horasUno, nombreDos, apellidoDos,
            cargoDos, horasDos, nombreTres, apellidoTres, cargoTres, horasTres;
    double salarioBaseU, salarioBaseD, salarioBaseT, desIssU, desAfpU, desRentaU, desIssD,
            desAfpD, desRentaD, desIssT, desAfpT, desRentaT, desTotalU, desTotalD, desTotalT;

    String format = "0.00";
    NumberFormat formatter = new DecimalFormat(format);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_liquido);
        nombreUno =(EditText)findViewById(R.id.nombreUno);
        apellidoUno =(EditText)findViewById(R.id.apellidoUno);
        cargoUno =(EditText)findViewById(R.id.cargoUno);
        horasUno =(EditText)findViewById(R.id.horasUno);
        nombreDos =(EditText)findViewById(R.id.nombreDos);
        apellidoDos =(EditText)findViewById(R.id.apellidoDos);
        cargoDos =(EditText)findViewById(R.id.cargoDos);
        horasDos =(EditText)findViewById(R.id.horasDos);
        nombreTres =(EditText)findViewById(R.id.nombreTres);
        apellidoTres =(EditText)findViewById(R.id.apellidoTres);
        cargoTres =(EditText)findViewById(R.id.cargoTres);
        horasTres =(EditText)findViewById(R.id.horasTres);
    }

    public void pliquido(View v){
        String nombreU = nombreUno.getText().toString();
        String apellidoU = apellidoUno.getText().toString();
        String cargoU = cargoUno.getText().toString();
        int horasU = Integer.parseInt(horasUno.getText().toString());
        //dos
        String nombreD = nombreDos.getText().toString();
        String apellidoD = apellidoDos.getText().toString();
        String cargoD = cargoDos.getText().toString();
        int horasD = Integer.parseInt(horasDos.getText().toString());
        //tres
        String nombreT = nombreTres.getText().toString();
        String apellidoT = apellidoTres.getText().toString();
        String cargoT = cargoTres.getText().toString();
        int horasT = Integer.parseInt(horasTres.getText().toString());

        if ( EMPTY.equals(nombreU) || EMPTY.equals(apellidoU) || EMPTY.equals(cargoU) || horasU <= 0 || EMPTY.equals(nombreD) || EMPTY.equals(apellidoD)
                || EMPTY.equals(cargoD) || horasD<= 0 || EMPTY.equals(nombreT) || EMPTY.equals(apellidoT) || EMPTY.equals(cargoT) || horasT<= 0){
            Toast.makeText(this,"El campo nombre, apellido, cargo no deben estar vacios y el campo horas laboradas debe ser mayor a 0",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if(horasU <= 160){
            salarioBaseU = (horasU*9.75);
            desIssU = (salarioBaseU*0.0525);
            desAfpU = (salarioBaseU*0.0688);
            desRentaU = (salarioBaseU*0.1);
            desTotalU = (desIssU+desAfpU+desRentaU);
            salarioBaseU = (salarioBaseU-desTotalU);
        }else if(horasU > 160){
            int horasUn = (horasU -160);
            salarioBaseU = ((horasUn * 11.50)+1560);
            desIssU = (salarioBaseU*0.0525);
            desAfpU = (salarioBaseU*0.0688);
            desRentaU = (salarioBaseU*0.1);
            desTotalU = (desIssU+desAfpU+desRentaU);
            salarioBaseU = (salarioBaseU-desTotalU);
        }

        if(horasD <= 160){
            salarioBaseD = (horasD*9.75);
            desIssD = (salarioBaseD*0.0525);
            desAfpD = (salarioBaseD*0.0688);
            desRentaD = (salarioBaseD*0.1);
            desTotalD = (desIssD+desAfpD+desRentaD);
            salarioBaseD = (salarioBaseD-desTotalD);
        }else if(horasD > 160){
            int horasDn = (horasD-160);
            salarioBaseD = ((horasDn * 11.50)+1560);
            desIssD = (salarioBaseD*0.0525);
            desAfpD = (salarioBaseD*0.0688);
            desRentaD = (salarioBaseD*0.1);
            desTotalD = (desIssD+desAfpD+desRentaD);
            salarioBaseD = (salarioBaseD-desTotalD);
        }

        if(horasT <= 160){
            salarioBaseT = (horasT*9.75);
            desIssT = (salarioBaseT*0.0525);
            desAfpT = (salarioBaseT*0.0688);
            desRentaT = (salarioBaseT*0.1);
            desTotalT = (desIssT+desAfpT+desRentaT);
            salarioBaseT = (salarioBaseT-desTotalT);
        }else if(horasT > 160){
            int horasTn = (horasT -160);
            salarioBaseT = ((horasTn * 11.50)+1560);
            desIssT = (salarioBaseT*0.0525);
            desAfpT = (salarioBaseT*0.0688);
            desRentaT = (salarioBaseT*0.1);
            desTotalT = (desIssT+desAfpT+desRentaT);
            salarioBaseT = (salarioBaseT-desTotalT);
        }


        if(cargoU.equals("Gerente") && cargoD.equals("Asistente") && cargoT.equals("Secretaria")){
            Toast.makeText(this, "NO HAY BONO", Toast.LENGTH_SHORT).show();



            String salarioLiquidoU = formatter.format(salarioBaseU);

            //Toast.makeText(this, salarioLiquidoU, Toast.LENGTH_SHORT).show();

            String salarioLiquidoD = formatter.format(salarioBaseD);

            //Toast.makeText(this, salarioLiquidoD, Toast.LENGTH_SHORT).show();

            String salarioLiquidoT = formatter.format(salarioBaseT);

            //Toast.makeText(this, salarioLiquidoT, Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, mostrarPagoLiquidoActivity.class);
            i.putExtra("nombreUno", nombreU);
            i.putExtra("apellidoUno", apellidoU);
            i.putExtra("cargoUno", cargoU);
            i.putExtra("salarioUno", salarioLiquidoU);
            i.putExtra("nombreDos", nombreD);
            i.putExtra("apellidoDos", apellidoD);
            i.putExtra("cargoDos", cargoD);
            i.putExtra("salarioDos", salarioLiquidoD);
            i.putExtra("nombreTres", nombreT);
            i.putExtra("apellidoTres", apellidoT);
            i.putExtra("cargoTres", cargoT);
            i.putExtra("salarioTres", salarioLiquidoT);
            startActivity(i);
        }else{
            if(cargoU.equals("Gerente")){
                salarioBaseU = (salarioBaseU*1.1);
                Toast.makeText(this, "BONO DE 10%", Toast.LENGTH_SHORT).show();
            }else if(cargoU.equals("Asistente")){
                salarioBaseU = (salarioBaseU*1.05);
                Toast.makeText(this, "BONO DE 5%", Toast.LENGTH_SHORT).show();
            }else if(cargoU.equals("Secretaria")){
                salarioBaseU = (salarioBaseU*1.03);
                Toast.makeText(this, "BONO DE 3%", Toast.LENGTH_SHORT).show();
            }else {
                salarioBaseU = (salarioBaseU*1.02);
                Toast.makeText(this, "BONO DE 2%", Toast.LENGTH_SHORT).show();
            }

            if(cargoD.equals("Gerente")){
                salarioBaseD = (salarioBaseD*1.1);
                Toast.makeText(this, "BONO DE 10%", Toast.LENGTH_SHORT).show();
            }else if(cargoD.equals("Asistente")){
                salarioBaseD = (salarioBaseD*1.05);
                Toast.makeText(this, "BONO DE 5%", Toast.LENGTH_SHORT).show();
            }else if(cargoD.equals("Secretaria")){
                salarioBaseD = (salarioBaseD*1.03);
                Toast.makeText(this, "BONO DE 3%", Toast.LENGTH_SHORT).show();
            }else {
                salarioBaseD = (salarioBaseD*1.02);
                Toast.makeText(this, "BONO DE 2%", Toast.LENGTH_SHORT).show();
            }

            if(cargoT.equals("Gerente")){
                salarioBaseT = (salarioBaseT*1.1);
                Toast.makeText(this, "BONO DE 10%", Toast.LENGTH_SHORT).show();
            }else if(cargoT.equals("Asistente")){
                salarioBaseT = (salarioBaseT*1.05);
                Toast.makeText(this, "BONO DE 5%", Toast.LENGTH_SHORT).show();
            }else if(cargoT.equals("Secretaria")){
                salarioBaseT = (salarioBaseT*1.03);
                Toast.makeText(this, "BONO DE 3%", Toast.LENGTH_SHORT).show();
            }else {
                salarioBaseT = (salarioBaseT*1.02);
                Toast.makeText(this, "BONO DE 2%", Toast.LENGTH_SHORT).show();
            }


            String salarioLiquidoU = formatter.format(salarioBaseU);

            //Toast.makeText(this, salarioLiquidoU, Toast.LENGTH_SHORT).show();

            String salarioLiquidoD = formatter.format(salarioBaseD);

            //Toast.makeText(this, salarioLiquidoD, Toast.LENGTH_SHORT).show();

            String salarioLiquidoT = formatter.format(salarioBaseT);

            //Toast.makeText(this, salarioLiquidoT, Toast.LENGTH_SHORT).show();


            Intent i = new Intent(this, mostrarPagoLiquidoActivity.class);
            i.putExtra("nombreUno", nombreU);
            i.putExtra("apellidoUno", apellidoU);
            i.putExtra("cargoUno", cargoU);
            i.putExtra("salarioUno", salarioLiquidoU);
            i.putExtra("nombreDos", nombreD);
            i.putExtra("apellidoDos", apellidoD);
            i.putExtra("cargoDos", cargoD);
            i.putExtra("salarioDos", salarioLiquidoD);
            i.putExtra("nombreTres", nombreT);
            i.putExtra("apellidoTres", apellidoT);
            i.putExtra("cargoTres", cargoT);
            i.putExtra("salarioTres", salarioLiquidoT);
            startActivity(i);

        }


    }

}