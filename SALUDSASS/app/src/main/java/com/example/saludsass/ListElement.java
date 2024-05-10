package com.example.saludsass;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListElement{
    String color;
    String tipoCita;
    String medicoCita;

    String fechaCita;

    //CONSTRUCTOR

    public ListElement(String color, String tipoCita, String medicoCita, String fechaCita) {
        this.color = color;
        this.tipoCita = tipoCita;
        this.medicoCita = medicoCita;
        this.fechaCita = fechaCita;
    }

    //GETTERS AND SETTER

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getMedicoCita() {
        return medicoCita;
    }

    public void setMedicoCita(String medicoCita) {
        this.medicoCita = medicoCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
}