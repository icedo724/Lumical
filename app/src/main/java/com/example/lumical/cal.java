package com.example.lumical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class cal extends AppCompatActivity {
    EditText 스공, 뎀퍼, 보공, 방무, 크뎀, 오마나, 상추뎀;
    TextView 한줄뎀, 층수;

    Button dcal;

    String st = "";
    String dmg = "";
    String bper = "";
    String ignor = "";
    String ctd = "";
    String over = "";
    String pldmg = "";

    Double onelinedmg;

    Double index1;
    Double index2;
    Double index3;
    Double index4;
    Double index5;
    Double index6;
    Double index7;

    Double fixedctdmg;
    Double rign;
    Double overload;

    String trueoneline;

    int floor = 0;
    int checkone = 0;
    int checkover = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);

        setTitle("루미너스 무릉 계산기");

        스공 = (EditText)findViewById(R.id.스공);
        보공 = (EditText)findViewById(R.id.보공);
        뎀퍼 = (EditText)findViewById(R.id.뎀퍼);
        방무 = (EditText)findViewById(R.id.방무);
        크뎀 = (EditText)findViewById(R.id.크뎀);
        오마나 = (EditText)findViewById(R.id.오마나);
        상추뎀 = (EditText)findViewById(R.id.상추뎀);

        층수 = (TextView)findViewById(R.id.층수);
        한줄뎀 = (TextView)findViewById(R.id.한줄뎀);

        dcal = findViewById(R.id.계산);
        Button cut = findViewById(R.id.지우기);
        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                스공.setText("");
                뎀퍼.setText("");
                보공.setText("");
                방무.setText("");
                크뎀.setText("");
                층수.setText("");
                한줄뎀.setText("");
                오마나.setText("");
                상추뎀.setText("");
            }
        });
        dcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //무기상수 * ( 인트 * 4 + 부스탯 ) * 총 마력 * 마력 % * {(보공+데미지)*0.01+1} * (1+크뎀*0.01) * (1+최뎀*0.01) * 0.01
                    //무기상수 = 1.2
                    //크뎀 기본값 : 35
                    //기준층 : 60층 : 앱킬 4.1 / 1층
                    //적용 링크 : 카데나 / 크레센도 0
                    //레벨 뻥 : 1.2
                    //코강 : 60
                    //퍼뎀 : 388
                    st = 스공.getText().toString();
                    dmg = 뎀퍼.getText().toString();
                    bper = 보공.getText().toString();
                    ctd = 크뎀.getText().toString();
                    ignor = 방무.getText().toString();
                    over = 오마나.getText().toString();
                    pldmg = 상추뎀.getText().toString();
                    //onelinedmg = 3.88 * 2.2 * 1.2 * index1 * fixedctdmg * (1+(Double.parseDouble(dmg)/100+0.06)+(Double.parseDouble(bper)/100)) * rign * 1.11; 본 계산식

                    checkover = Integer.parseInt(over);

                    if ( checkover >= 1 && checkover <= 9 ){
                        overload = 1.08;
                    }
                    else if ( checkover >= 10 && checkover <= 19) {
                        overload = 1.09;
                    }
                    else if ( checkover >= 20 && checkover <= 29) {
                        overload = 1.1;
                    }
                    else if ( checkover == 30) {
                        overload = 1.11;
                    }
                    else {
                        overload = 1.0;
                    }
                    rign = 1-(1-(1-(1-(Double.parseDouble(ignor)/100))*0.6*0.8))/2;
                    fixedctdmg = (Double.parseDouble(ctd)/100) + 1.35;
                    index1 = Double.parseDouble(st)/(1+(Double.parseDouble(dmg)/100)); // 스공/뎀퍼
                    index2 = index1/1.8416; // 스공/뎀퍼/최뎀
                    index3 = index2*(1+(Double.parseDouble(dmg)/100+0.06)+(Double.parseDouble(bper)/100)+(Double.parseDouble(pldmg)/100)); // 스공/뎀퍼/최뎀 * (보공+뎀퍼)
                    index4 = index3 * rign; // 스공/뎀퍼/최뎀 * (보공+뎀퍼) * 방무
                    index5 = index4 * fixedctdmg; // 스공/뎀퍼/최뎀 * (보공+뎀퍼) * 방무 * 크뎀
                    index6 = index5 * (1.8416 * overload); // 스공/뎀퍼/최뎀 * (보공+뎀퍼) * 방무 * (최뎀+오마나)
                    index7 = index6 * 3.88 * 1.2 * 2.2; // 스공/뎀퍼/최뎀 * (보공+뎀퍼) * 방무 * 퍼뎀 * 레벨뻥 * 코강

                    onelinedmg = index7;

                    trueoneline = String.valueOf(Math.round(onelinedmg/10));
                    한줄뎀.setText(trueoneline + "");
                    //한줄뎀.setText(onelinedmg + "억"); < 소숫점 컷 x
                    checkone = Integer.parseInt(trueoneline);
                    if (checkone >= 900000000){
                        floor = 67;
                        층수.setText(floor + "층 이상(판정 불가)");
                    }
                    else if (checkone <= 899999999 && checkone >= 810000000){
                        floor = 66;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 809999999 && checkone >= 720000000){
                        floor = 65;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 719999999 && checkone >= 640000000){
                        floor = 64;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 639999999 && checkone >= 571500000){
                        floor = 63;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 571499999 && checkone >= 510000000){
                        floor = 62;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 509999999 && checkone >= 450000000){
                        floor = 61;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 449999999 && checkone >= 410000000) {
                        floor = 60;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 409999999 && checkone >= 325000000){
                        floor = 59;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 324999999 && checkone >= 280000000){
                        floor = 58;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 279999999 && checkone >= 245000000){
                        floor = 57;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 244999999 && checkone >= 212000000){
                        floor = 56;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 211999999 && checkone >= 184000000){
                        floor = 55;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 183999999 && checkone >= 160000000){
                        floor = 54;
                        층수.setText(floor + "층");
                    }
                    else if (checkone <= 159999999){
                        floor = 53;
                        층수.setText(floor + "층 이하(판정 불가)");
                    }
                    else {
                        Toast.makeText(cal.this, "오류 발생 : 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(cal.this, "올바른 값을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void fromcaltobuild(View view) {
        Intent intent = new Intent(getApplicationContext(), build.class);
        startActivity(intent);
    }
    public void fromcaltomain(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        finish();
    }
}
