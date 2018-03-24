package pablo.utng.edu.mx.telefonicastrategy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import pablo.utng.edu.mx.telefonicastrategy.patronSingleton.MensajeSingleton;
import pablo.utng.edu.mx.telefonicastrategy.patronstrategy.Contexto;
import pablo.utng.edu.mx.telefonicastrategy.patronstrategy.Movistar;
import pablo.utng.edu.mx.telefonicastrategy.patronstrategy.MyCompany;
import pablo.utng.edu.mx.telefonicastrategy.patronstrategy.Telcel;
import pablo.utng.edu.mx.telefonicastrategy.patronstrategy.Unefon;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    private Button btnCalcular;
    private Button btnMostrarCreditos;
    private Button btnLimpiar;
    private EditText txtMinutosLocal;
    private EditText txtMinutosLD;
    private EditText txtTotal;
    private Spinner cmbOpciones;
    private Contexto contexto;
    private String[] opciones = {"Telcel","Unefon","MyCompany","Movistar"};

    private Button btnMostrarMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reacionar los controles de las vista

        btnCalcular = (Button)findViewById(R.id.btn_calcular);
        btnMostrarCreditos = (Button)findViewById(R.id.btn_mostrar);
        btnLimpiar = (Button)findViewById(R.id.btn_limpiar);
        txtMinutosLocal = (EditText) findViewById(R.id.txt_minutos_local);
        txtMinutosLD = (EditText) findViewById(R.id.txt_minutos_ld);
        txtTotal = (EditText) findViewById(R.id.txt_total);
        cmbOpciones = (Spinner)findViewById(R.id.cmb_opciones);

        btnMostrarMensaje = (Button) findViewById(R.id.btn_mostrar_mensaje);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item, opciones);
        cmbOpciones.setAdapter(adapter);

        cmbOpciones.setOnItemSelectedListener(this);
        btnMostrarCreditos.setOnClickListener(this);
        btnCalcular.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

        btnMostrarMensaje.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int op = 0;
        op = (int)cmbOpciones.getSelectedItemId();
        switch (op){
            case 0: //Telcel
                contexto = new Contexto(new Telcel());
                break;
            case 1: //Unefon
                contexto = new Contexto(new Unefon());
                break;
            case 2: //MyCompany
                contexto = new Contexto(new MyCompany());
                break;
            case 3:
                contexto =  new Contexto(new Movistar());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        int minutosLocal = 0;
        int minutosLD = 0;
        double total = 0.0;
        switch (view.getId()){
            case R.id.btn_calcular:
                minutosLocal = Integer.parseInt(txtMinutosLocal.getText().toString());
                minutosLD = Integer.parseInt(txtMinutosLD.getText().toString());
                total = contexto.calcularTarifaLocal(minutosLocal)+contexto.calcularTarifaLD(minutosLD);
                txtTotal.setText("$"+total);
                break;
            case R.id.btn_limpiar:
                txtMinutosLD.setText("");
                txtMinutosLocal.setText("");
                txtTotal.setText("");
                break;
            case R.id.btn_mostrar:
                Intent i = new Intent(this, CreditosActivity.class);
                startActivity(i);
                break;
            case R.id.btn_mostrar_mensaje:
                String mensaje="";
                mensaje= MensajeSingleton.getInstance().getMensaje();
                Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show();
                break;
        }
    }
}
