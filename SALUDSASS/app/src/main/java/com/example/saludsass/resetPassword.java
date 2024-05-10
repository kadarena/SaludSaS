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

public class resetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reset_password);

        Spinner spinner;
        Button btnrecuperar;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar el Spinner y la lista de opciones
        spinner = findViewById(R.id.spinner3);
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

        btnrecuperar =  findViewById(R.id.btn_recuperar);
        btnrecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(resetPassword.this);
                builder.setTitle("AVISO");
                builder.setMessage("hemos enviado un enlace a su correo registrado  con las indicaciones  para restablecer su contrasena");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Lógica para enviar la solicitud
                        Toast.makeText(resetPassword.this, "Correo enviado", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(resetPassword.this, MainActivity.class);
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