package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaración de componentes
    private EditText txtNumero1, txtNumero2;
    private TextView lblResultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculación de elementos con la vista XML
        txtNumero1 = findViewById(R.id.txtNumero1);
        txtNumero2 = findViewById(R.id.txtNumero2);
        lblResultado = findViewById(R.id.lblResultado);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        // Listener para la Suma
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    double n1 = Double.parseDouble(txtNumero1.getText().toString());
                    double n2 = Double.parseDouble(txtNumero2.getText().toString());
                    double resultado = n1 + n2;
                    lblResultado.setText("Resultado (Suma): " + resultado);
                }
            }
        });

        // Listener para la Resta
        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    double n1 = Double.parseDouble(txtNumero1.getText().toString());
                    double n2 = Double.parseDouble(txtNumero2.getText().toString());
                    double resultado = n1 - n2;
                    lblResultado.setText("Resultado (Resta): " + resultado);
                }
            }
        });

        // Listener para la Multiplicación
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    double n1 = Double.parseDouble(txtNumero1.getText().toString());
                    double n2 = Double.parseDouble(txtNumero2.getText().toString());
                    double resultado = n1 * n2;
                    lblResultado.setText("Resultado (Multiplicación): " + resultado);
                }
            }
        });

        // Listener para la División
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    double n1 = Double.parseDouble(txtNumero1.getText().toString());
                    double n2 = Double.parseDouble(txtNumero2.getText().toString());

                    if (n2 == 0) {
                        Toast.makeText(getApplicationContext(), "Error: No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                    } else {
                        double resultado = n1 / n2;
                        lblResultado.setText("Resultado (División): " + resultado);
                    }
                }
            }
        });
    }

    // Método auxiliar para validar que los campos no estén vacíos
    private boolean validarCampos() {
        if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}