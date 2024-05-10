package com.example.saludsass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textViewCrearCuenta;
    TextView linkrecuperarContrasena;

    Button btniniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar el Spinner
        spinner = findViewById(R.id.sp_documento);
        List<String> opciones = new ArrayList<>();
        opciones.add("Tipo de Documento");
        opciones.add("Cedula");
        opciones.add("Cedula de extranjeria");
        opciones.add("Pasaporte");

        // Configurar el adaptador del Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Configurar el listener del Spinner para mostrar el elemento seleccionado
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                if (!selectedItem.equals("Seleccione tipo de Documento")) {
                    // Acción que deseas realizar cuando se selecciona un elemento del Spinner
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Acción por defecto si no se selecciona ningún elemento
            }
        });
        textViewCrearCuenta = findViewById(R.id.link_crear_cuenta);
        textViewCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, createAccount.class);
                startActivity(intent);
            }
        });

        linkrecuperarContrasena = findViewById(R.id.link_recuperar_contrasena);
        linkrecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, resetPassword.class);
                startActivity(intent);
            }
        });

        Button btnIniciar = findViewById(R.id.btn_iniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UsuarioPrincipal.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
