package cl.seccion121.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Cliente> losClientes;
    private  int indice;

    private EditText etRut, etCredito;
    private TextInputLayout tilRazon;

    private Button btnGrabar, btnSiguiente, btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indice = 0;
        losClientes = new ArrayList<>();

        referencias();
        eventos();
    }

    public void grabarCliente(){
        String rut, credito, rz;

        rut = etRut.getText().toString();
        credito = etCredito.getText().toString();
        rz = tilRazon.getEditText().getText().toString();

        if(validarDatos(rut, credito, rz)){
            int creditoInt = Integer.parseInt(credito);
            Cliente cli = new Cliente(rut, rz, creditoInt);

            losClientes.add(cli);
            indice = losClientes.size();

            etRut.setText(""); etCredito.setText("");
            tilRazon.getEditText().setText("");
            etRut.requestFocus();
            Toast.makeText(this, "Cliente grabado exitosamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Tiene errores en el formulario", Toast.LENGTH_SHORT).show();
        }

    }
    
    private boolean validarDatos(String rut, String credito, String rz){
        boolean vOK = true;
        tilRazon.setError(null);

        if(rut.isEmpty()){
            vOK = false;
            etRut.setError("Debe ingresar rut");
        }

        if(credito.isEmpty()){
            vOK = false;
            etCredito.setError("Debe ingresar credito");
        }else{
            int creditoInt = Integer.parseInt(credito);
            if(creditoInt < 1 || creditoInt > 100000){
                etCredito.setError("No debe superar los cien mil pesos");
                vOK = false;
            }
        }

        if(rz.isEmpty()){
            vOK = false;
            tilRazon.setError("Debe ingresar razón social");
        }


        return vOK;
    }

    private void mostrarCliente(){
        Cliente cliente = losClientes.get(indice);

        if(cliente != null) {
            etRut.setText(cliente.getRut());
            etCredito.setText(String.valueOf(cliente.getCredito()));
            tilRazon.getEditText().setText(cliente.getRazon());

            Log.d("TAG_", "Rut " + cliente.getRut());
            Log.d("TAG_", "Razon " + cliente.getRazon());
            Log.d("TAG_", "Credito " + cliente.getCredito());
        }else{
            Toast.makeText(MainActivity.this, "No hay más clientes para mostrar", Toast.LENGTH_LONG).show();
        }
    }

    private void avanzar(){
        indice++;
        if(indice < losClientes.size()) {
            mostrarCliente();
            btnAtras.setEnabled(true);
        }else{
            Toast.makeText(this, "Es el último de la lista no puede avanzar", Toast.LENGTH_SHORT).show();
            indice = losClientes.size() - 1;
        }
    }

    private void retroceder(){
        indice--;
        if(indice >= 0) {
            mostrarCliente();
            if(indice == 0)
                btnAtras.setEnabled(false);
        }else{
            indice = 0;
        }
    }

    //region Referencias y Eventos

    private void referencias(){
        etRut = findViewById(R.id.etRut);
        etCredito = findViewById(R.id.etCredito);
        tilRazon = findViewById(R.id.tilRazon);
        btnGrabar = findViewById(R.id.btnGrabar);
        btnAtras = findViewById(R.id.btnAtras);
        btnSiguiente = findViewById(R.id.btnSiguiente);
    }

    private void eventos() {
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grabarCliente();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avanzar();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retroceder();
            }
        });
    }

    //endregion


}