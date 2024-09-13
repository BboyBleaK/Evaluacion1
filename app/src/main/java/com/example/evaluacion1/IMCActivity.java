package com.example.evaluacion1;

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

        buttonCalcular.setOnClickListener(v -> {
            String pesoStr = editTextPeso.getText().toString();
            String alturaStr = editTextAltura.getText().toString();

            if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
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
            }
        });
    }
}
