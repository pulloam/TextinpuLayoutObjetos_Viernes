package cl.seccion121.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoClientesActivity extends AppCompatActivity {
    private TextView tvDatos;
    private ListView lstClientes;
    private Spinner spnClientes;
    private Switch swtClientes;

    private ArrayList<Cliente> losClientes;
    private ArrayAdapter<Cliente> miAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes);


        referencias();
        eventos();
        obtenerDatos();

        miAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, losClientes);

        lstClientes.setAdapter(miAdaptador);
        spnClientes.setAdapter(miAdaptador);

    }

    private void referencias() {
        tvDatos = findViewById(R.id.tvDatos);
        lstClientes= findViewById(R.id.lstClientes);
        spnClientes= findViewById(R.id.spnClientes);
        swtClientes = findViewById(R.id.swtClientes);
    }

    private void eventos(){

        lstClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int indice, long id) {
                Cliente cli = losClientes.get(indice);
                Toast.makeText(ListadoClientesActivity.this, "Crédito " + cli.getCredito() , Toast.LENGTH_SHORT).show();
            }
        });

        lstClientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListadoClientesActivity.this, "Desea eliminar", Toast.LENGTH_SHORT).show();
                //losClientes.remove(position);
                return true;
            }
        });

        spnClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListadoClientesActivity.this, "Crédito " + losClientes.get(position).getCredito() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        swtClientes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    lstClientes.setVisibility(View.VISIBLE);
                else
                    lstClientes.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void obtenerDatos(){
        Cliente cliente = (Cliente) getIntent().getExtras().getSerializable("el_cliente");
        losClientes = new ArrayList<Cliente>();

        Log.d("TAG_", "Rut " + cliente.getRut());
        Log.d("TAG_", "Credito " + cliente.getCredito());
        Log.d("TAG_", "Sucursal " + cliente.getSucursal().getDireccion());

        tvDatos.setText(cliente.getRazon());

        //Supuesto ir a base de datos y obtener todos los clientes
        losClientes.add(new Cliente("1-9", "Juanito", 12000));
        losClientes.add(new Cliente("2-9", "Emilia", 12000));
        losClientes.add(new Cliente("3-9", "Valentina", 12000));
        losClientes.add(new Cliente("4-9", "Catalina", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));
        losClientes.add(new Cliente("5-9", "Nicolas", 12000));

    }
}