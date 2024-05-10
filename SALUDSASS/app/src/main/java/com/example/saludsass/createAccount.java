package com.example.saludsass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class createAccount extends AppCompatActivity {

    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);

        linearLayout2 = findViewById(R.id.linearLayout2);

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createAccount.this, createAccountPerson.class);
                startActivity(intent);
            }
        });
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createAccount.this, createAccountEmpleador.class);
                startActivity(intent);
            }
        });

        linearLayout4 = findViewById(R.id.linearLayout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createAccount.this, createAccountIndependiente.class);
                startActivity(intent);
            }
        });

    }
}
