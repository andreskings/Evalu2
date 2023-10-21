package com.example.evalu2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class paginaprincipal extends AppCompatActivity {
    private EditText etLatitud1, etLatitud2, etLatitud3;
    private Button ingresarButton;
    private Button btnLimpiar;
    private TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginaprincipal);

        etLatitud1 = findViewById(R.id.latitud1);
        etLatitud2 = findViewById(R.id.latitud2);
        etLatitud3 = findViewById(R.id.latitud3);

        ingresarButton = findViewById(R.id.btningresar);
        btnLimpiar = findViewById(R.id.btnlimpiar);


        ingresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat1 = etLatitud1.getText().toString();
                String lat2 = etLatitud2.getText().toString();
                String lat3 = etLatitud3.getText().toString();

                // Dividir cada cadena en latitud y longitud utilizando la coma como delimitador
                String[] parts1 = lat1.split(",");
                String[] parts2 = lat2.split(",");
                String[] parts3 = lat3.split(",");

                if (parts1.length >= 2 && parts2.length >= 2 && parts3.length >= 2) {
                    String latitud1 = parts1[0].trim();
                    String longitud1 = parts1[1].trim();

                    String latitud2 = parts2[0].trim();
                    String longitud2 = parts2[1].trim();

                    String latitud3 = parts3[0].trim();
                    String longitud3 = parts3[1].trim();

                    // Enviar las coordenadas a MapsActivity
                    Intent intent = new Intent(paginaprincipal.this, MapsActivity.class);
                    intent.putExtra("latitud1", Double.parseDouble(latitud1));
                    intent.putExtra("longitud1", Double.parseDouble(longitud1));
                    intent.putExtra("latitud2", Double.parseDouble(latitud2));
                    intent.putExtra("longitud2", Double.parseDouble(longitud2));
                    intent.putExtra("latitud3", Double.parseDouble(latitud3));
                    intent.putExtra("longitud3", Double.parseDouble(longitud3));
                    startActivity(intent);
                } else {
                    txt2.setText("No se proporcionaron valores válidos de latitud y longitud en al menos uno de los campos.");
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etLatitud1.setText("");
                etLatitud2.setText("");
                etLatitud3.setText("");
                
            }
        });
    }
}


