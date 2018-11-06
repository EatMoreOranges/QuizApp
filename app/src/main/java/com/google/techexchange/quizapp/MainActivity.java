package com.google.techexchange.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    CheckBox missChecked ,idoChecked,florChecked,washChecked;
    RadioButton noneRad,trueRad ;
    Button sub;

    // all questions are initialized to not answered
    int statesQuestionResults = 0; //ans = 2
    int alphaQuestionResults = 0; // ans = 1
    int triangleQuestionResults = 0; // ans = 1
    int myleftQuestionResults = 0; // ans = 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        missChecked = (CheckBox) findViewById(R.id.mississippiCheckbox);
        idoChecked = (CheckBox) findViewById(R.id.idahoCheckbox);
        florChecked = (CheckBox) findViewById(R.id.floridaCheckbox);
        washChecked = (CheckBox) findViewById(R.id.washingtonCheckbox);



        noneRad = (RadioButton) findViewById(R.id.noneRadioButton);
        
        trueRad = (RadioButton) findViewById(R.id.trueRadioButton);
    }


    //question 1
    public void southernSatesQuestion() {

        // Check which checkbox was clicked

        if (missChecked.isChecked()) {
            statesQuestionResults += 1; //(right answer)
        }
        if (idoChecked.isChecked()){
            statesQuestionResults = -1;}

        if (florChecked.isChecked()) {
            statesQuestionResults += 1;//  (right answer)
        }
        if (washChecked.isChecked()){
            statesQuestionResults = -1;}

//        Log.v("MainActivity","LLLLLLLLLLLL");

    }

    //Question 2
    public void alphaQuestion() {
        // Is the view now checked?

        EditText answText = (EditText)findViewById(R.id.alphabetBox); //get whats in the text box
        String answerText = answText.getText().toString();            //convert it to a string
        //Log.d("MainActivity","JESUS JESUS");


        if (answerText.equalsIgnoreCase("abc")){
        //if (answerText.equals("")){
            alphaQuestionResults +=  1;
//            Toast.makeText(MainActivity.this,"1111",Toast.LENGTH_LONG).show();
        }

    }


    //Question 3
    public void numberOfSquaresQuestion() {

        if (noneRad.isChecked()){
            System.out.println("Radio button checked!");

            triangleQuestionResults = 1 ;

        }


    }


    //question 4
    public void myLeftQuestion() {

        if (trueRad.isChecked()) {
            myleftQuestionResults = myleftQuestionResults + 1; //(right answer)
//            Toast.makeText(MainActivity.this,String.valueOf(myleftQuestionResults)+"a",Toast.LENGTH_LONG).show();
        }
    }


    public void submitQuiz(View view) {
        statesQuestionResults = 0; //ans = 2
        alphaQuestionResults = 0; // ans = 1
        triangleQuestionResults = 0; // ans = 1
        myleftQuestionResults = 0; // ans = 1

        southernSatesQuestion();
        alphaQuestion();
        numberOfSquaresQuestion();
        myLeftQuestion();


        if (statesQuestionResults == 2){
            //Toast.makeText(MainActivity.this,String.valueOf(statesQuestionResults)+"a",Toast.LENGTH_LONG).show();

            if (alphaQuestionResults == 1){

                if (triangleQuestionResults == 1){

                    if (myleftQuestionResults == 1) {
                        Toast.makeText(MainActivity.this," got them all right!",Toast.LENGTH_SHORT).show(); }

                    else { Toast.makeText(MainActivity.this, "No(4) is wrong. ", Toast.LENGTH_LONG).show();}
                }
                else{ Toast.makeText(MainActivity.this,"No(3) is wrong. ",Toast.LENGTH_LONG).show();}

            } else{ Toast.makeText(MainActivity.this,"No(2) is wrong. ",Toast.LENGTH_LONG).show();}

        } else{ Toast.makeText(MainActivity.this,"No(1) is wrong. ",Toast.LENGTH_LONG).show();}



   }
}