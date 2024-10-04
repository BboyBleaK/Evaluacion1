package com.example.evaluacion1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);

        EditText editTextPeso = findViewById(R.id.editTextPeso);
        EditText editTextAltura = findViewById(R.id.editTextAltura);
        Button buttonCalcular = findViewById(R.id.button_calcular);
        TextView textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonVolver = findViewById(R.id.buttonVolver);

        buttonCalcular.setOnClickListener(v -> {
            String pesoStr = editTextPeso.getText().toString();
            String alturaStr = editTextAltura.getText().toString();


            if (!pesoStr.isEmpty() && !alturaStr.isEmpty() && alturaStr.contains(".")) {
                try {
                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);
                    double imc = peso / (altura * altura);

                    String clasificacion;
                    if (imc < 18.5) {
                        clasificacion = "Bajo peso";
                    } else if (imc >= 18.5 && imc < 24.9) {
                        clasificacion = "Normal";
                    } else {
                        clasificacion = "Sobrepeso";
                    }

                    textViewResultado.setText(String.format("IMC: %.2f - %s", imc, clasificacion));
                } catch (NumberFormatException e) {
                    textViewResultado.setText("Formato incorrecto en el valor de altura.");
                }
            } else {
                textViewResultado.setText("La altura debe contener un punto decimal (ej. 1.80)");
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(IMCActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
