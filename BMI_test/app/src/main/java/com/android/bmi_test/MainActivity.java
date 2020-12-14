package com.android.bmi_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //ttt
    // ria test

    int heightGet, weightGet;
    double result;
    LinearLayout firstPage, secondPage, thirdPage, lower, normal, fat;
    EditText name, age, height, weight;
    TextView nameResult, bmiResult;
    ImageView first;
    Button btnStart, btnCalc, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstPage = findViewById(R.id.firstPage);
        secondPage = findViewById(R.id.secondPage);
        thirdPage = findViewById(R.id.thirdPage);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        nameResult = findViewById(R.id.nameResult);
        bmiResult = findViewById(R.id.bmiResult);

        first = findViewById(R.id.firstImage);
        lower = findViewById(R.id.lower);
        normal = findViewById(R.id.normal);
        fat = findViewById(R.id.fat);

        btnStart = findViewById(R.id.btnStart);
        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);

        btnStart.setOnClickListener(mClickListener);
        btnCalc.setOnClickListener(mClickListener);
        btnReset.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Editable edit1 = name.getText();
            Editable edit2 = age.getText();
            Editable edit3 = height.getText();
            Editable edit4 = weight.getText();

            switch (v.getId()){
                case R.id.btnStart:
                    firstPage.setVisibility(v.INVISIBLE);
                    secondPage.setVisibility(v.VISIBLE);
                    thirdPage.setVisibility(v.INVISIBLE);

                    break;

                case R.id.btnCalc:
                    first.setVisibility(v.VISIBLE);
                    if (name.getText().toString().trim().length() == 0) {
                        Toast.makeText(MainActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();

                    } else if (age.getText().toString().trim().length() == 0) {
                        Toast.makeText(MainActivity.this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();

                    } else if (height.getText().toString().trim().length() == 0) {
                        Toast.makeText(MainActivity.this, "키를 입력해주세요.", Toast.LENGTH_SHORT).show();

                    } else if (weight.getText().toString().trim().length() == 0) {
                        Toast.makeText(MainActivity.this, "체중을 입력해주세요.", Toast.LENGTH_SHORT).show();

                    } else{
                        firstPage.setVisibility(v.INVISIBLE);
                        secondPage.setVisibility(v.INVISIBLE);
                        thirdPage.setVisibility(v.VISIBLE);
                        double result = calc();
                        if (result < 18.5) {
                            lower.setVisibility(v.VISIBLE);
                            normal.setVisibility(v.INVISIBLE);
                            fat.setVisibility(v.INVISIBLE);

                        } else if (18.5 <= result && result < 23) {
                            lower.setVisibility(v.INVISIBLE);
                            normal.setVisibility(v.VISIBLE);
                            fat.setVisibility(v.INVISIBLE);

                        } else if (result >= 23) {
                            lower.setVisibility(v.INVISIBLE);
                            normal.setVisibility(v.INVISIBLE);
                            fat.setVisibility(v.VISIBLE);
                        }
                    }

                    break;

                case R.id.btnReset:
                    firstPage.setVisibility(v.INVISIBLE);
                    secondPage.setVisibility(v.VISIBLE);
                    thirdPage.setVisibility(v.INVISIBLE);

                    edit1.clear();
                    edit2.clear();
                    edit3.clear();
                    edit4.clear();
                    break;

            }
        }
    };

    // bmi 계산
    private double calc(){

        heightGet = Integer.parseInt(height.getText().toString().trim());
        weightGet = Integer.parseInt(weight.getText().toString().trim());

        result = weightGet / (heightGet * heightGet * 0.0001);

        nameResult.setText(name.getText().toString());
        bmiResult.setText(Double.toString(result).substring(0, 4));

        return result;
    }


}

//        btnCalc.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//
//                if (name.getText().toString().trim().length() == 0) {
//                    Toast.makeText(MainActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
//
//                } else if (age.getText().toString().trim().length() == 0) {
//                    Toast.makeText(MainActivity.this, "나이를 입력해주세요.", Toast.LENGTH_SHORT).show();
//
//                } else if (height.getText().toString().trim().length() == 0) {
//                    Toast.makeText(MainActivity.this, "키를 입력해주세요.", Toast.LENGTH_SHORT).show();
//
//                } else if (weight.getText().toString().trim().length() == 0) {
//                    Toast.makeText(MainActivity.this, "체중을 입력해주세요.", Toast.LENGTH_SHORT).show();
//
//                } else {
//
//                    heightGet = Integer.parseInt(height.getText().toString().trim());
//                    weightGet = Integer.parseInt(weight.getText().toString().trim());
//
//                    result = weightGet / (heightGet * heightGet * 0.0001);
//
//                    nameResult.setText(name.getText().toString());
//                    bmiResult.setText(Double.toString(result).substring(0, 4));
//
//
//
//                    if (result < 18.5) {
//                        first.setVisibility(v.INVISIBLE);
//                        lower.setVisibility(v.VISIBLE);
//                        normal.setVisibility(v.INVISIBLE);
//                        fat.setVisibility(v.INVISIBLE);
//
//                    } else if (18.5 <= result && result < 23) {
//                        first.setVisibility(v.INVISIBLE);
//                        lower.setVisibility(v.INVISIBLE);
//                        normal.setVisibility(v.VISIBLE);
//                        fat.setVisibility(v.INVISIBLE);
//
//                    } else if (result >= 23) {
//                        first.setVisibility(v.INVISIBLE);
//                        lower.setVisibility(v.INVISIBLE);
//                        normal.setVisibility(v.INVISIBLE);
//                        fat.setVisibility(v.VISIBLE);
//                    }
//
//                }
//            }
//        });