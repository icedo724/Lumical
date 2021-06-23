package com.example.lumical;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class build extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build);
        setTitle("루미너스 무릉 계산기");
    }
    public void fl52(View v) {
        Intent intent = new Intent(this, bu52.class);
        startActivity(intent);
    }
    public void fl53(View v) {
        Intent intent = new Intent(this, bu53.class);
        startActivity(intent);
    }
    public void fl54(View v) {
        Intent intent = new Intent(this, bu54.class);
        startActivity(intent);
    }
    public void fl55(View v) {
        Intent intent = new Intent(this, bu55.class);
        startActivity(intent);
    }
    public void fl56(View v) {
        Intent intent = new Intent(this, bu56.class);
        startActivity(intent);
    }
    public void fl57(View v) {
        Intent intent = new Intent(this, bu57.class);
        startActivity(intent);
    }
    public void fl58(View v) {
        Intent intent = new Intent(this, bu58.class);
        startActivity(intent);
    }
    public void fl59(View v) {
        Intent intent = new Intent(this, bu59.class);
        startActivity(intent);
    }
    public void fl60(View v) {
        Intent intent = new Intent(this, bu60.class);
        startActivity(intent);
    }
    public void fl61(View v) {
        Intent intent = new Intent(this, bu61.class);
        startActivity(intent);
    }
    public void fl63(View v) {
        Intent intent = new Intent(this, bu63.class);
        startActivity(intent);
    }
    public void fl65(View v) {
        Intent intent = new Intent(this, bu65.class);
        startActivity(intent);
    }
    public void fl66(View v) {
        Intent intent = new Intent(this, bu66.class);
        startActivity(intent);
    }
    public void gomain(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void howtobuild(View v) {
        Intent intent = new Intent(getApplicationContext(), cal.class);
        startActivity(intent);
    }
    public void gtip(View v) {
        Intent intent = new Intent(getApplicationContext(), tip.class);
        startActivity(intent);
    }
}

