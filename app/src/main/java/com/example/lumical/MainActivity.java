package com.example.lumical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("루미너스 무릉 계산기");
    }
    public void gocal(View v) {
        Intent intent = new Intent(getApplicationContext(), cal.class);
        startActivity(intent);
    }
    public void seebuild(View v) {
        Intent intent = new Intent(getApplicationContext(), build.class);
        startActivity(intent);
    }
    public void openchat(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri =  Uri.parse("https://open.kakao.com/o/sni0Y2cb");
        intent.setData(uri);
        startActivity(intent);
    }
    public void gorecal(View v){
        Intent intent = new Intent(getApplicationContext(), recal.class);
        startActivity(intent);
    }
}