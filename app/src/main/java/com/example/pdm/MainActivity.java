package com.example.pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CICLO", "onCreate");

        Button btn = (Button) findViewById(R.id.btnButton);
        btn.setOnClickListener(this);

//        edt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("CICLO", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO", "onDestroy");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnButton:
                Log.d("Click", "Click por Switch");

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

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }
}
