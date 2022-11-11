package cl.seccion121.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Cliente[] losClientes;
    private  int indice;

    private EditText etRut, etCredito, etRazon;

    private Button btnGrabar, btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indice = 0;
        losClientes = new Cliente[10];
        losClientes[0] = new Cliente("1-9", "Juan", 30000);
        losClientes[1] = new Cliente("2-7", "Maria", 40000);

        //Referencias
        etRut = findViewById(R.id.etRut);
        etCredito = findViewById(R.id.etCredito);
        etRazon = findViewById(R.id.etRazon);
        btnGrabar = findViewById(R.id.btnGrabar);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        //Eventos
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click boton", Toast.LENGTH_LONG).show();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente cliente = losClientes[indice];

                if(cliente != null) {
                    etRut.setText(cliente.getRut());
                    etCredito.setText(String.valueOf(cliente.getCredito()));
                    etRazon.setText(cliente.getRazon());

                    indice++;
                    Log.d("TAG_", "Rut " + cliente.getRut());
                    Log.d("TAG_", "Razon " + cliente.getRazon());
                    Log.d("TAG_", "Credito " + cliente.getCredito());
                }else{
                    Toast.makeText(MainActivity.this, "No hay más clientes para mostrar", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}