package com.example.saludsass;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class createAccountIndependiente extends AppCompatActivity {

    Spinner spinner;
    Button btncrearIndependiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account_independiente);

// Inicializar el Spinner y la lista de opciones
        spinner = findViewById(R.id.spinner);
        List<String> opciones = new ArrayList<>();
        opciones.add("Tipo de Documento");
        opciones.add("Cedula");
        opciones.add("Cedula de extranjeria");
        opciones.add("Pasaporte");

        // Configurar el adaptador del Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setGravity(Gravity.CENTER); // Centrar el texto en el Spinner
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setGravity(Gravity.CENTER); // Centrar el texto en el menú desplegable
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btncrearIndependiente = findViewById(R.id.btn_crear_independiente);
        btncrearIndependiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo de confirmación
                AlertDialog.Builder builder = new AlertDialog.Builder(createAccountIndependiente.this);
                builder.setTitle("Confirmación");
                builder.setMessage("PRONTO NOS PONDREMOS EN CONTACTO CONTIGO PARA VALIDAR TU INFORMACION.");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Lógica para enviar la solicitud
                        Toast.makeText(createAccountIndependiente.this, "Solicitud enviada", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(createAccountIndependiente.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

                // Mostrar el diálogo
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}