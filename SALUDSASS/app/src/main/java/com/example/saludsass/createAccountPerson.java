package com.example.saludsass;

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

import java.util.ArrayList;
import java.util.List;

public class createAccountPerson extends AppCompatActivity {

    Spinner spinner;
    Button btncrearUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account_person);

        spinner = findViewById(R.id.spinner);
        List<String> opciones = new ArrayList<>();
        opciones.add("Tipo de Documento");
        opciones.add("Cedula");
        opciones.add("Cedula de extranjeria");
        opciones.add("Pasaporte");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setGravity(Gravity.CENTER); // Centrar el texto en el Spinner
                return view;
            }

        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btncrearUsuario = findViewById(R.id.btn_crear_usuario);

        btncrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(createAccountPerson.this, "Cuenta Creada con Exito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(createAccountPerson.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
