package com.example.saludsass;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AddCita extends AppCompatActivity {
    private TextView textShow, textShowHora;
    private Button btnAgregarFecha, btnAgregarHora;

    private Button btnCancelarAdd,btnConfirmarAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_cita);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Seleccion multiple

        Spinner spinner = findViewById(R.id.sp_tipo_cita);
        List<String> opciones = new ArrayList<>();
        opciones.add("Odontología");
        opciones.add("Medicina general");
        opciones.add("Optometría");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        //Acaba la selección multiple

        //Llama al calendario y la hora

        textShow = findViewById(R.id.ShowText);
        btnAgregarFecha = findViewById(R.id.btn_agregar_fecha);

        btnAgregarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        textShowHora = findViewById(R.id.ShowTextHora);
        btnAgregarHora = findViewById(R.id.btn_agregar_hora);

        btnAgregarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogHora();
            }
        });

        //Acaba llamada de calendario y hora

        //Se cancela el añadir cita
        btnCancelarAdd = findViewById(R.id.btn_cancelar_add);
        btnCancelarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelarAdd();
            }
        });
        //Acaba cancela añadir cita
    }

    //Crea el calendario y la hora

    private void openDialog(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                textShow.setText(String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));
            }
        }, 2024, 0, 15);

        dialog.show();

    }

    private void openDialogHora(){
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textShowHora.setText(String.valueOf(hourOfDay)+":"+String.valueOf(minute));
            }
        }, 15, 00, true);

        dialog.show();

    }

    //Acaba el calendario y la hora

    //Se cancela añadir cita
    public void cancelarAdd(){
        Intent intent = new Intent(this,CitaMedica.class);
        startActivity(intent);
    }
    //fin de cancelar añadir cita

}