package com.github.herbidino.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;

    private int firstNumber = -1;
    private int secondNumber = -1;
    private int calculation = -1;

    private static final String[][] BUTTONS = {
            {"C", "+/-", "%", "/"},
            {"1", "2", "3", "x"},
            {"4", "5", "6", "+"},
            {"7", "8", "9", "-"},
            {"0", ",", "="}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initResultText();
        initButtonList();
    }

    private void initResultText() {
        resultText = findViewById(R.id.Text_Result);
        resultText.setText("");
    }

    private void initButtonList() {
        GridLayout buttonList = findViewById(R.id.GridLayout_ButtonList);

        for (String[] buttonRow : BUTTONS)
            for (String button : buttonRow) {
                Button btn = createButton(button);

                switch (button) {
                    case "C":
                    case "+/-":
                    case "%":
                    case ",":
                        break;
                    case "+":
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calculation = 0;
                            }
                        });

                        break;
                    case "-":
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calculation = 1;
                            }
                        });

                        break;
                    case "x":
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calculation = 2;
                            }
                        });

                        break;
                    case "/":
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calculation = 3;
                            }
                        });

                        break;
                    case "=":
                        btn.setOnClickListener(new View.OnClickListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onClick(View v) {
                                if (firstNumber == -1 || secondNumber == -1 || calculation == -1)
                                    return;

                                resultText.setText(Integer.toString(getResult()));
                                firstNumber = secondNumber = calculation = -1;
                            }
                        });

                        break;
                    default:
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (firstNumber == -1) {
                                    firstNumber = Integer.parseInt(button);
                                    resultText.setText(button);
                                }
                                else if (calculation != -1) {
                                    secondNumber = Integer.parseInt(button);
                                    resultText.setText(button);
                                }
                            }
                        });
                }

                buttonList.addView(btn);
            }
    }

    private Button createButton(String text) {
        ContextThemeWrapper context = new ContextThemeWrapper(this, R.style.CalculateButton);
        Button resBtn = new Button(context);

        resBtn.setText(text);

        return resBtn;
    }

    private int getResult() {
        switch (calculation) {
            case 0:
                return firstNumber + secondNumber;
            case 1:
                return firstNumber - secondNumber;
            case 2:
                return firstNumber * secondNumber;
            case 3:
                return firstNumber / secondNumber;
            default:
                return -1;
        }
    }
}