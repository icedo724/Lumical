package com.example.lumical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class tip extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip);
        setTitle("루미너스 무릉 계산기");
    }
    public void gobacktip(View v) {
        Intent intent = new Intent(getApplicationContext(), build.class);
        startActivity(intent);
    }
}