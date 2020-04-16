package com.example.pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversor de Temperatura");

        Intent intent = getIntent();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
            default: break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnButton:
                EditText edt = (EditText) findViewById(R.id.editText);
                TextView txtView = (TextView) findViewById(R.id.txtView);
                String input;
                input = edt.getText().toString();
                if (input == "" || input.isEmpty()) {

                } else {
                    double inputDouble = Double.parseDouble(input);
                    double result = (((inputDouble * 9) / 5) + 32);
                    if (txtView.getText().toString().length() < 11){
                        txtView.setText(txtView.getText().toString() + " " + result);
                    } else {
                        txtView.setText("Resultado: " + result);
                    }
                }
        }
    }
}
