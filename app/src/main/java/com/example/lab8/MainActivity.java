package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button   mButton;
    EditText mEdit1;
    EditText mEdit2;
    float firstNumber;
    float secondNumber;
    float result;
    int i = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mEdit1 = findViewById(R.id.editText3);
        mEdit2 = findViewById(R.id.editText4);


        mButton.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    try {
                        //The number collection happens here
                        Log.v("EditText", mEdit1.getText().toString());
                        firstNumber = Float.parseFloat(mEdit1.getText().toString());
                        Log.v("EditNumber", "" + firstNumber );

                        Log.v("EditText", mEdit2.getText().toString());
                        secondNumber = Float.parseFloat(mEdit2.getText().toString());
                        Log.v("EditNumber", "" + secondNumber );

                        try {
                            if(secondNumber == 0) {
                                Log.e("Null", "division by zero exception");
                                throw new ArithmeticException("Division by 0");
                            }

                            if(result == 13 || secondNumber == 13 || firstNumber == 13){
                                Log.i("UnluckyException", "you're unlucky");
                                throw new UnluckyException("Unlucky exception");
                            }

                            result = firstNumber/secondNumber;
                            Log.v("DivisionResult", "" + result );

                            Toast toast = Toast.makeText(getApplicationContext(),"Result: " + result ,Toast.LENGTH_SHORT);
                            toast.setMargin(50,50);
                            toast.show();

                        }
                        catch (Exception e){
                            if(secondNumber == 0) {
                                Toast toast = Toast.makeText(getApplicationContext(), "division by zero exception", Toast.LENGTH_SHORT);
                                toast.setMargin(50, 50);
                                toast.show();
                            }

                            if(secondNumber == 13 || firstNumber == 13 || result == 13) {
                                Toast toast2 = Toast.makeText(getApplicationContext(), "Unlucky Exception, you have " + --i + " more warning(s)", Toast.LENGTH_SHORT);
                                toast2.setMargin(50, 50);
                                toast2.show();
                            }
                        }

                    }
                    catch (Exception e){
                        Log.e("MissingNumber", "both boxes should have a value");

                        Toast toast = Toast.makeText(getApplicationContext(),"Both boxes should have a value" ,Toast.LENGTH_SHORT);
                        toast.setMargin(50,50);
                        toast.show();
                    }

                    if(i == 0){
                        throw new ArithmeticException("Boo-hoo");
                    }

                }
            });
    }
}
