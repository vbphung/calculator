package com.github.herbidino.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
//    private GridLayout buttonList;

//    private  String[][] buttons = {
//            {"C", "+/-", "%", "/"},
//            {"1", "2", "3", "x"},
//            {"4", "5", "6", "-"},
//            {"0", ",", "="}
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initResultText();
        initButtonList();
    }

    private  void initResultText() {
        resultText = findViewById(R.id.Text_Result);
    }

    private  void initButtonList() {


//        buttonList = findViewById(R.id.GridLayout_ButtonList);

//        for (String[] buttonRow : buttons)
//            for (String button : buttonRow) {
//                Button btn = createButton(button);
//            }
    }

    public void CButton(View view){

    }

//    private Button createButton(String text) {
//        Button resBtn = new Button(this);
//        resBtn.setText(text);
//
//        return resBtn;
//    }
}