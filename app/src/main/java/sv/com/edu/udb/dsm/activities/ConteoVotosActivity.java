package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

import sv.com.udb.dsm.R;

public class ConteoVotosActivity extends AppCompatActivity {

    public static final String EMPTY = "";
    private EditText txtVotos;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votos);
        txtVotos = findViewById(R.id.txtVotos);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View view) throws JSONException {
        String votos = txtVotos.getText().toString();
        String resultado = "";

        if ( EMPTY.equals(votos)){
            Toast.makeText(this,"El campo [votos] no debe estar vacio", Toast.LENGTH_LONG).show();
            return;
        }

        String[] soloVotos = votos.replace("(", "").replace(")", "").split(",");
        JSONObject votosJson = new JSONObject();
        for (String soloVoto : soloVotos) {
            int count = 0;
            JSONObject resultJson = new JSONObject();
            for (String v:
                 soloVotos) {
                if (soloVoto.equals(v)){
                    count++;
                }
            }
            String format = "0.00";
            NumberFormat formatter = new DecimalFormat(format);
            String porcentajeFormateado = formatter.format((count * 100.00) / soloVotos.length);
            resultJson.put("votos", count);
            resultJson.put("porcentaje", porcentajeFormateado);
            votosJson.put("candidato " + soloVoto, resultJson);
        }

        Iterator<String> itCandidatos =  votosJson.keys();

        while (itCandidatos.hasNext()) {
            String key = itCandidatos.next();
            resultado += key + " - " +
                    "Votos: " + votosJson.getJSONObject(key).getString("votos") + " - " +
                    "Porcentaje: " + votosJson.getJSONObject(key).getString("porcentaje") + "%\n";
        }

        txtResultado.setText(resultado);

//        Intent i = new Intent(this, ResultActivity.class);
//        i.putExtra("txtNombre", nombre);
//        i.putExtra("txtCodigo", codigo);
//        i.putExtra("txtMes", mes);
//        i.putExtra("txtVentas", ventas);
//        i.putExtra("Comision", comision);
//        i.putExtra("totComision", totalComi);
//        i.putExtra("image",uriImage);
//        startActivity(i);
    }
}