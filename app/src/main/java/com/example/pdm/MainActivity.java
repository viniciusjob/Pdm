package com.example.pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CICLO", "onCreate");

        Button btn = (Button) findViewById(R.id.btnButton);
        btn.setOnClickListener(this);
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

    public void clickButton(View view) {
        i++;
        Log.d("Click", "Você Clicou " + i + " vezes");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnButton:
                Log.d("Click", "Click por Switch");
        }
    }
}
