package com.example.gb_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textInputAndResult, textOperation;
    private Button buttonAllClean, buttonPercent, buttonDivision, buttonSeven, buttonEight,
            buttonNine, buttonMultiplication, buttonFour, buttonFive, buttonSix, buttonSubtraction,
            buttonOne, buttonTwo, buttonThree, buttonAddition, buttonDot, buttonZero, buttonEqual;
    private MaterialButton buttonClean;

    private Boolean addition = false,
            subtraction = false,
            multiplication = false,
            division = false;

    private static final String ARG_NUMBERS = "ARG_NUMBERS";
    private static final String ARG_TEXT_INPUT = "ARG_TEXT_INPUT";
    private static final String ARG_TEXT_OP = "ARG_TEXT_OP";

    private DataAndOperations dataAndOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if (savedInstanceState == null) {
            dataAndOperations = new DataAndOperations();
        } else {
            dataAndOperations = savedInstanceState.getParcelable(ARG_NUMBERS);
            textOperation.setText(savedInstanceState.getString(ARG_TEXT_OP));
            textInputAndResult.setText(savedInstanceState.getString(ARG_TEXT_INPUT));
        }

        buttonDot.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText().toString() + ".");
            textOperation.setText(textOperation.getText() + ".");
        });

        buttonZero.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "0");
            textOperation.setText(textOperation.getText() + "0");
        });

        buttonOne.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "1");
            textOperation.setText(textOperation.getText() + "1");
        });

        buttonTwo.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "2");
            textOperation.setText(textOperation.getText() + "2");
        });

        buttonThree.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "3");
            textOperation.setText(textOperation.getText() + "3");
        });

        buttonFour.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "4");
            textOperation.setText(textOperation.getText() + "4");
        });

        buttonFive.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "5");
            textOperation.setText(textOperation.getText() + "5");
        });

        buttonSix.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "6");
            textOperation.setText(textOperation.getText() + "6");
        });

        buttonSeven.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "7");
            textOperation.setText(textOperation.getText() + "7");
        });

        buttonEight.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "8");
            textOperation.setText(textOperation.getText() + "8");
        });

        buttonNine.setOnClickListener(view -> {
            textInputAndResult.setText(textInputAndResult.getText() + "9");
            textOperation.setText(textOperation.getText() + "9");
        });

        buttonAddition.setOnClickListener(view -> {
            if (textInputAndResult.getText().toString().equals("")) {
                return;
            }
            dataAndOperations.setNumOne(Float.parseFloat(textInputAndResult.getText().toString()));
            dataAndOperations.setOperation("+");
            textOperation.setText(dataAndOperations.getNumOne() + dataAndOperations.getOperation());
            textInputAndResult.setText("");
            addition = true;
        });

        buttonSubtraction.setOnClickListener(view -> {
            if (textInputAndResult.getText().toString().equals("")) {
                return;
            }
            dataAndOperations.setNumOne(Float.parseFloat(textInputAndResult.getText().toString()));
            dataAndOperations.setOperation("-");
            textOperation.setText(dataAndOperations.getNumOne() + dataAndOperations.getOperation());
            textInputAndResult.setText("");
            subtraction = true;
        });

        buttonMultiplication.setOnClickListener(view -> {
            if (textInputAndResult.getText().toString().equals("")) {
                return;
            }
            dataAndOperations.setNumOne(Float.parseFloat(textInputAndResult.getText().toString()));
            dataAndOperations.setOperation("*");
            textOperation.setText(dataAndOperations.getNumOne() + dataAndOperations.getOperation());
            textInputAndResult.setText("");
            multiplication = true;
        });

        buttonDivision.setOnClickListener(view -> {
            if (textInputAndResult.getText().toString().equals("")) {
                return;
            }
            dataAndOperations.setNumOne(Float.parseFloat(textInputAndResult.getText().toString()));
            dataAndOperations.setOperation("/");
            textOperation.setText(dataAndOperations.getNumOne() + dataAndOperations.getOperation());
            textInputAndResult.setText("");
            division = true;
        });

        buttonEqual.setOnClickListener(view -> {
            if (textInputAndResult.getText().toString().equals("")) {
                return;
            }
            dataAndOperations.setNumTwo(Float.parseFloat(textInputAndResult.getText().toString()));
            if (addition) {
                textInputAndResult.setText(String.valueOf(dataAndOperations.addition()));
                addition = false;
            }
            if (subtraction) {
                textInputAndResult.setText(String.valueOf(dataAndOperations.subtraction()));
                subtraction = false;
            }
            if (multiplication) {
                textInputAndResult.setText(String.valueOf(dataAndOperations.multiplication()));
                multiplication = false;
            }
            if (division) {
                textInputAndResult.setText(String.valueOf(dataAndOperations.division()));
                division = false;
            }
        });

        buttonAllClean.setOnClickListener(view -> {
            textInputAndResult.setText("");
            textOperation.setText("");
        });

        buttonClean.setOnClickListener(view -> {
            if (textInputAndResult.getText().toString().equals("")) {
                return;
            }
            String text = textInputAndResult.getText().toString();
            textInputAndResult.setText(text.substring(0, text.length() - 1));
            textOperation.setText(text.substring(0, text.length() - 1));
        });

        buttonPercent.setOnClickListener(view -> {
            if (addition || subtraction || multiplication || division) {
                dataAndOperations.setNumTwo(Float.parseFloat(textInputAndResult.getText().toString()));
                textInputAndResult.setText("");
                textInputAndResult.setText(String.valueOf(dataAndOperations.percent()));
                textOperation.setText(textOperation.getText().toString() + "%");
            }
        });

    }

    public void init() {
        textInputAndResult = findViewById(R.id.text_input_and_result);
        textOperation = findViewById(R.id.text_operation);
        buttonAllClean = findViewById(R.id.button_all_clean);
        buttonClean = findViewById(R.id.button_clean);
        buttonPercent = findViewById(R.id.button_percent);
        buttonDivision = findViewById(R.id.button_division);
        buttonSeven = findViewById(R.id.button_seven);
        buttonEight = findViewById(R.id.button_eight);
        buttonNine = findViewById(R.id.button_nine);
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonFour = findViewById(R.id.button_four);
        buttonFive = findViewById(R.id.button_five);
        buttonSix = findViewById(R.id.button_six);
        buttonSubtraction = findViewById(R.id.button_subtraction);
        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonAddition = findViewById(R.id.button_addition);
        buttonDot = findViewById(R.id.button_dot);
        buttonZero = findViewById(R.id.button_zero);
        buttonEqual = findViewById(R.id.button_equal);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(ARG_NUMBERS, dataAndOperations);
        outState.putString(ARG_TEXT_OP, textOperation.getText().toString());
        outState.putString(ARG_TEXT_INPUT, textInputAndResult.getText().toString());
    }
}