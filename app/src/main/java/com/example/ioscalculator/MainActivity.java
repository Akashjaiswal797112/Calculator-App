package com.example.ioscalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity { //open bracket for main activity
    private Button buttonAC;
    private Button buttonTop2;
    private Button buttonBracket;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonSub;
    private Button buttonAdd;
    private Button buttonEqual;
    private Button buttonPoint;
    private Button button9;
    private Button button8;
    private Button button7;
    private Button button6;
    private Button button5;
    private Button button4;
    private Button button3;
    private Button button2;
    private Button button1;
    private Button button0;
    private EditText display2;
    private EditText display;
    private ConstraintLayout layout;
    private String data;
    private int count=2,c=0;
    private int counting=2;
    private String secondText;
    private Switch Switch;
    private String manipulation;




    @Override
    protected void onCreate(Bundle savedInstanceState) { //open bracket for onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.constraintLayout);
        buttonAC=findViewById(R.id.buttonAC);
        buttonTop2=findViewById(R.id.buttonTop2);
        buttonBracket=findViewById(R.id.buttonBracket);
        buttonDivide=findViewById(R.id.buttonDivide);
        buttonMultiply=findViewById(R.id.buttonMultiply);
        buttonSub=findViewById(R.id.buttonSub);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonEqual=findViewById(R.id.buttonEqual);
        buttonPoint=findViewById(R.id.buttonPoint);
        button9=findViewById(R.id.button9);
        button8=findViewById(R.id.button8);
        button7=findViewById(R.id.button7);
        button6=findViewById(R.id.button6);
        button5=findViewById(R.id.button5);
        button4=findViewById(R.id.button4);
        button3=findViewById(R.id.button3);
        button2=findViewById(R.id.button2);
        button1=findViewById(R.id.button1);
        button0=findViewById(R.id.button0);
        display=findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        display2=findViewById(R.id.display2);
        display2.setShowSoftInputOnFocus(false);
        Switch=findViewById(R.id.Switch);


        //Used for the dark mode Concept
        Switch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {

                            display.setTextColor(Color.parseColor("#000000"));
                            display2.setTextColor(Color.parseColor("#000000"));
                            layout.setBackgroundColor(Color.parseColor("#ffffff"));//white
                            Switch.setText("Light Mode");
                            Switch.setTextColor(Color.parseColor("#000000"));
                            button0.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button0.setTextColor(Color.parseColor("#1C1C1C"));
                            button1.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button1.setTextColor(Color.parseColor("#1C1C1C"));
                            button2.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button2.setTextColor(Color.parseColor("#1C1C1C"));
                            button3.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button3.setTextColor(Color.parseColor("#1C1C1C"));
                            button4.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button4.setTextColor(Color.parseColor("#1C1C1C"));
                            button5.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button5.setTextColor(Color.parseColor("#1C1C1C"));
                            button6.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button6.setTextColor(Color.parseColor("#1C1C1C"));
                            button7.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button7.setTextColor(Color.parseColor("#1C1C1C"));
                            button8.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button8.setTextColor(Color.parseColor("#1C1C1C"));
                            button9.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            button9.setTextColor(Color.parseColor("#1C1C1C"));
                            buttonPoint.setBackgroundColor(Color.parseColor("#F8F8F8"));
                            buttonPoint.setTextColor(Color.parseColor("#1C1C1C"));


                        } else {


                            display.setTextColor(Color.parseColor("#ffffff"));
                            display2.setTextColor(Color.parseColor("#ffffff"));
                            layout.setBackgroundColor(Color.parseColor("#1C1C1C"));//black
                            Switch.setText("Light Mode");
                            Switch.setTextColor(Color.parseColor("#ffffff"));
                            buttonPoint.setBackgroundColor(Color.parseColor("#505050"));
                            buttonPoint.setTextColor(Color.parseColor("#ffffff"));
                            button1.setBackgroundColor(Color.parseColor("#505050"));
                            button1.setTextColor(Color.parseColor("#ffffff"));
                            button2.setBackgroundColor(Color.parseColor("#505050"));
                            button2.setTextColor(Color.parseColor("#ffffff"));
                            button3.setBackgroundColor(Color.parseColor("#505050"));
                            button3.setTextColor(Color.parseColor("#ffffff"));
                            button4.setBackgroundColor(Color.parseColor("#505050"));
                            button4.setTextColor(Color.parseColor("#ffffff"));
                            button5.setBackgroundColor(Color.parseColor("#505050"));
                            button5.setTextColor(Color.parseColor("#ffffff"));
                            button6.setBackgroundColor(Color.parseColor("#505050"));
                            button6.setTextColor(Color.parseColor("#ffffff"));
                            button7.setBackgroundColor(Color.parseColor("#505050"));
                            button7.setTextColor(Color.parseColor("#ffffff"));
                            button8.setBackgroundColor(Color.parseColor("#505050"));
                            button8.setTextColor(Color.parseColor("#ffffff"));
                            button9.setBackgroundColor(Color.parseColor("#505050"));
                            button9.setTextColor(Color.parseColor("#ffffff"));
                            button0.setBackgroundColor(Color.parseColor("#505050"));
                            button0.setTextColor(Color.parseColor("#ffffff"));

                        }
                    }
                });


        //ButtonEqual code
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                String userExpression = display.getText().toString();
                secondText = userExpression;
                userExpression = userExpression.replaceAll("×", "*");
                userExpression = userExpression.replaceAll("÷", "/");
                Expression exp = new Expression(userExpression);
                String result = String.valueOf(exp.calculate());

                if(result=="NaN")
               {
                   display.setText("Error");

               }
               else
               {
                   if(result.contains(".0"))
                   {
                       result=result.replace(".0","");
                       display.setText(result);
                       display.setSelection(result.length());
                       display2.setText(secondText);

                   }
                   else
                   {
                       display.setText(result);
                       display.setSelection(result.length());
                       display2.setText(secondText);
                   }
               }

            }
        });


        //Button '()' code
        buttonBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(count%2==0)
                {
                    send("(");
                    buttonAC.setText("C");
                }
                else
                {
                    send(")");
                    buttonAC.setText("C");
                }
                count++;
            }
        });


        //Button Clear On Long Press code
        buttonAC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //return false;
                display.setText("");
                display2.setText("");
                c=0;
                if(buttonAC.getText().toString()=="C")

                    buttonAC.setText("AC");

                return false;
            }
        });


        //ButtonBack code
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str=display.getText().toString();


                    if (str.length() >1 ) {
                        str = str.substring(0, str.length() - 1);
                        display.setText(str);
                    }
                    else if (str.length() <=1 ) {
                        display.setText("");
                    }



            }
        });


        //Button power code
        buttonTop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data = display.getText().toString();
                if(data.isEmpty())
                {
                    display.setText("");

                }
                else
                {
                    if(manipulation.endsWith("^"))
                    {
                        send("");
                        buttonAC.setText("C");
                    }
                    else
                    {
                        send("^");
                        buttonAC.setText("C");
                    }
                }



            }
        });


        //Button '0' code
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("0");
                buttonAC.setText("C");

            }
        });


        //Button '1' code
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("1");
                buttonAC.setText("C");

            }
        });


        //Button '2' code
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("2");
                buttonAC.setText("C");

            }
        });


        //Button '3' code
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("3");
                buttonAC.setText("C");

            }
        });


        //Button '4' code
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("4");
                buttonAC.setText("C");

            }
        });


        //Button '5' code
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("5");
                buttonAC.setText("C");

            }
        });


        //Button '6' code
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("6");
                buttonAC.setText("C");

            }
        });


        //Button '7' code
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("7");
                buttonAC.setText("C");

            }
        });


        //Button '8' code
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                send("8");
                buttonAC.setText("C");

            }
        });


        //Button '9' code
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send("9");
                buttonAC.setText("C");

            }
        });


        //Button '+' code
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data = display.getText().toString();
                if(data.isEmpty())
                {
                    display.setText("");

                }
                else
                {
                    if(manipulation.endsWith("+"))
                    {
                        send("");
                        buttonAC.setText("C");
                    }
                    else
                    {
                        send("+");
                        buttonAC.setText("C");
                    }
                }


            }
        });


        //Button '-' code
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = display.getText().toString();

                if(data.isEmpty())
                {
                    send("-");
                    buttonAC.setText("C");
                }

               else if(manipulation.endsWith("-"))
                {
                    send("");
                    buttonAC.setText("C");
                }
                else
                {
                    send("-");
                    buttonAC.setText("C");
                }

            }
        });


        //Button '*' code
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data = display.getText().toString();
                if(data.isEmpty())
                {
                    display.setText("");

                }

                else
                {
                    if(manipulation.endsWith("×"))
                    {
                        send("");
                        buttonAC.setText("C");
                    }
                    else
                    {
                        send("×");
                        buttonAC.setText("C");
                    }
                }


            }
        });


        //Button '/' code
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = display.getText().toString();
                if(data.isEmpty())
                {
                    display.setText("");

                }
                else
                {
                    if(manipulation.endsWith("÷"))
                    {
                        send("");
                        buttonAC.setText("C");
                    }
                    else
                    {
                        send("÷");
                        buttonAC.setText("C");
                    }
                }




            }
        });


        //Button '.' code
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c==0) {
                    send(".");
                    buttonAC.setText("C");
                }

                else
                {
                    if (!manipulation.endsWith(".")) {
                        send(".");
                        buttonAC.setText("C");
                    } else if (manipulation.endsWith(".")) {
                        send("");
                        buttonAC.setText("C");
                    } else {
                        send("@");
                        buttonAC.setText("C");
                    }
                }
                c++;

            }
        });

    }//close bracket for oncreate


    //Function That is used to call after every click
    private void send(String str)
    {

        data = display.getText().toString(); //before the element goes to display

        display.setText(data + str);
        manipulation = display.getText().toString();//after the element goes to display
    }
}//close bracket for main activity