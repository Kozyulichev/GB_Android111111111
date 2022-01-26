package com.example.gb_android;

public class DataAndOperations {

    private float numOne = 0,
            numTwo = 0;


    public float addition(float a, float b) {
        return a + b;
    }

    public float subtraction(float a, float b) {
        return a - b;
    }

    public float multiplication(float a, float b) {
        return a * b;
    }

    public float division(float a, float b) {
        return a / b;
    }

    public float converter(String s) {
        numOne = Float.parseFloat(s + "");
        return numOne;
    }
}
