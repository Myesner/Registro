package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etGasto,etFecha;
    private Button btnA;
    private ListView ListV;
    private TextView Total;
    private ArrayList<String> listaD;
    private ArrayAdapter<String> adapter;
    private double totalmonto = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGasto = findViewById(R.id.etGasto);
        etFecha = findViewById(R.id.etFecha);
        btnA = findViewById(R.id.btnagregar);
        ListV = findViewById(R.id.ListVDatos);
        Total = findViewById(R.id.TvTotal);

        listaD = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaD);
        ListV.setAdapter(adapter);

        btnA.setOnClickListener(view -> addExpense());

    }


    private void addExpense() {
        String monto = etGasto.getText().toString().trim();
        String fecha = etFecha.getText().toString().trim();
        if (!monto.isEmpty() || !fecha.isEmpty()) {
            double Monto = Double.parseDouble(monto);
            totalmonto += Monto ;
            listaD.add(fecha + "\n" + "$" +Monto);
            adapter.notifyDataSetChanged();
            etFecha.requestFocus();
            etFecha.setText("");
            etGasto.setText("");
            updateTotalExpense();

        }
    }
        private void updateTotalExpense () {
            Total.setText("Total mensual gastado: $" + totalmonto);
        }


}




