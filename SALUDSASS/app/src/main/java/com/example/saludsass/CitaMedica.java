package com.example.saludsass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CitaMedica extends AppCompatActivity {
    ImageView citaAdd;
    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cita_medica);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        citaAdd = findViewById(R.id.img_add);

        citaAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citaAdd();
            }
        });
    }
    public void init(){

        elements =  new ArrayList<>();
        elements.add(new ListElement("#F4F4F4","Odontología","Pedro Suarez","16/08/24"));
        elements.add(new ListElement("#FFFFFF","Odontología","Pedro Suarez","16/08/24"));
        elements.add(new ListElement("#F4F4F4","Odontología","Pedro Suarez","16/08/24"));


        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void citaAdd (){
        Intent intent = new Intent(this,AddCita.class);
        startActivity(intent);
    }


}