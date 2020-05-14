package com.example.pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CICLO", "onCreate");

        Button btn = (Button) findViewById(R.id.btnButton);

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
    public void onContentChanged() {
        super.onContentChanged();
    }

    public void navigateToConvertTemp(View view) { startActivity(new Intent(this, ResultActivity.class)); }

    public void aula4Click(View view) { startActivity(new Intent(this, Aula4Activity.class)); }

    public void aula7Click(View view) { startActivity(new Intent(this, Aula7Activity.class)); }
}
