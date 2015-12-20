package com.example.mak.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



//    INITIALISE outside onCreate
    private Button cButton;
    private Button fButton ;
    private TextView myTextView ;
    private EditText nameField ;
    DecimalFormat round = new DecimalFormat("0.0");

    public double toCel(double fVal){
        return (fVal-32)*5/9;
    }
    public double toF(double cVal){
        return cVal*9/5+32;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ASSIGN w/ CAST and findViewById(<Resource>), findViewById calls after onCreate
        cButton = (Button)findViewById(R.id.buttonC);
        fButton = (Button)findViewById(R.id.buttonF);
        myTextView = (TextView)findViewById(R.id.textViewAwesome);
        nameField = (EditText)findViewById(R.id.nameField);

        myTextView.setText("Hey you convert your temp!!");

//        final String[] mountains = {"everest","KK"};

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextVal = nameField.getText().toString();
                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No temp given", Toast.LENGTH_SHORT).show();
                } else {
                    myTextView.setText(String.valueOf(toCel(Double.parseDouble(editTextVal))));
                }

//                myTextView.setText("Welcome "+nameField.getText().toString()+" to the World!");

//                Random rand = new Random();
//                int randomNum = rand.nextInt(mountains.length);
//                myTextView.setText(mountains[randomNum]);

//                myTextView.setText("WHOYA!");

//                Toast.makeText(getApplicationContext(), "I was clicked", Toast.LENGTH_SHORT).show();
            }
        });


        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editTextVal = nameField.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "No temp given", Toast.LENGTH_SHORT).show();
                } else {
                    int intval = Integer.parseInt(editTextVal);
                    myTextView.setText(String.valueOf(toF(Double.parseDouble(editTextVal))));
                }
            }
        });
    }


}

