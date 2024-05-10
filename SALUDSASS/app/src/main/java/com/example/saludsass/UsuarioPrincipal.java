package com.example.saludsass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UsuarioPrincipal extends AppCompatActivity {
    AppCompatImageButton btnCitas,btnMedicamento;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuario_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Boton Citas
        btnCitas = findViewById(R.id.btn_cita);
        btnCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCita();
            }
        });
        //fin de boton citas

        btnMedicamento = findViewById(R.id.btn_medicamento);
        btnMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaMeds();
            }
        });
    }
    //Boton para citas
    public void listaCita(){
        Intent intent = new Intent(this, CitaMedica.class);
        startActivity(intent);
    }
//Fin del boton

    //Boton medicamento
    public void listaMeds(){
        Intent intent = new Intent(this, Medicamento.class);
        startActivity(intent);
    }

}