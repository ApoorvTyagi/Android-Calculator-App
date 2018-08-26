package com.example.tyagi.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private int flag=0;
    private String expression="";
    private String text="",text1="",newText="";
    private Double result=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.num0:
                if(e2.getText().toString().equals("0"))
                    e2.setText("0");
                else
                    e2.setText(e2.getText()+"0");
                break;

            case R.id.num1:
                if(e2.getText().toString().equals("0"))
                    e2.setText("1");
                else
                    e2.setText(e2.getText()+"1");
                break;

            case R.id.num2:
                if(e2.getText().toString().equals("0"))
                    e2.setText("2");
                else
                e2.setText(e2.getText()+"2");
                break;

            case R.id.num3:
                if(e2.getText().toString().equals("0"))
                    e2.setText("3");
                else
                    e2.setText(e2.getText()+"3");
                break;

            case R.id.num4:
                if(e2.getText().toString().equals("0"))
                    e2.setText("4");
                else
                    e2.setText(e2.getText()+"4");
                break;

            case R.id.num5:
                if(e2.getText().toString().equals("0"))
                    e2.setText("5");
                else
                    e2.setText(e2.getText()+"5");
                break;

            case R.id.num6:
                if(e2.getText().toString().equals("0"))
                    e2.setText("6");
                else
                    e2.setText(e2.getText()+"6");
                break;

            case R.id.num7:
                if(e2.getText().toString().equals("0"))
                    e2.setText("7");
                else
                    e2.setText(e2.getText()+"7");
                break;

            case R.id.num8:
                if(e2.getText().toString().equals("0"))
                    e2.setText("8");
                else
                    e2.setText(e2.getText()+"8");
                break;

            case R.id.num9:
                if(e2.getText().toString().equals("0"))
                    e2.setText("9");
                else
                    e2.setText(e2.getText()+"9");
                break;

            case R.id.dot:
                if(!e2.getText().toString().contains("."))
                {
                    e2.setText(e2.getText()+".");
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("0");
                expression="";
                break;

            case R.id.backSpace:
                text=e2.getText().toString();
                if(text.length()>0) {
                    if (text.endsWith(".")) {
                    }
                    String newText = text.substring(0, text.length() - 1);


                    if (newText.endsWith("sqrt")) {
                        newText = "0";
                    } else if (newText.endsWith("^"))
                        newText = newText.substring(0, newText.length() - 1);

                    if (newText.equals(""))
                        e2.setText("0");

                    e2.setText(newText);
                }
                text=e2.getText().toString();
                if(text.length()==0)
                    e2.setText("0");
                break;

            case R.id.plus:
                flag=1;
                operationClicked("+");
                break;

            case R.id.minus:
                flag=1;
                operationClicked("-");
                break;

            case R.id.divide:
                flag=1;
                operationClicked("/");
                break;

            case R.id.multiply:
                flag=1;
                operationClicked("*");
                break;

            case R.id.per:
                flag=2;
                operationClicked("%");
                break;

            case R.id.sqrt:
                if(e2.length()!=0)
                {
                    flag=1;
                    text=e2.getText().toString();
                    e1.setText("sqrt(" + text + ")");
                    Double res,num1;
                    num1=Double.parseDouble(text);
                    res=Math.sqrt(num1);
                    String s=Double.toString(res);
                    e2.setText(s);
                }
                break;

            case R.id.square:
                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    e1.setText("("+text+")^2");
                    Double res,num1;
                    num1=Double.parseDouble(text);
                    res=num1*num1;
                    String s=Double.toString(res);
                    e2.setText(s);
                }
                break;

            case R.id.posneg:
                if(e2.length()!=0)
                {
                    String s=e2.getText().toString();
                    char arr[]=s.toCharArray();
                    if(arr[0]=='-')
                        e2.setText(s.substring(1,s.length()));
                    else
                        e2.setText("-"+s);
                }
                break;

            case R.id.ce:
                e2.setText("0");
                break;

            case R.id.equal:
               if(flag==1)
               {
                   if (e2.length() != 0) {
                       text = e2.getText().toString();
                       expression = e1.getText().toString() + text;
                   }
                   e1.setText(expression);
                   if (expression.length() == 0)
                       expression = "0.0";
                   DoubleEvaluator evaluator = new DoubleEvaluator();
                   try {

                       result = new calcy().evaluate(expression);
                       if (!expression.equals("0.0"))

                           e2.setText(result + "");
                   } catch (Exception e) {
                       e2.setText("Invalid Expression");
                       e1.setText("");
                       expression = "";
                       e.printStackTrace();
                   }
               }
               else if(flag==2)
               {
                   if (e2.length() != 0) {
                       text = e2.getText().toString();
                       text1 =e1.getText().toString();
                       expression = text1 + text;
                       newText=text1.substring(0,text1.length()-1);
                   }
                   e1.setText(expression);

                   Double res,num1,num2;
                   num1=Double.parseDouble(text);
                   num2=Double.parseDouble(newText);
                   res=(num1*num2)/100;

                   String s=Double.toString(res);

                   e2.setText(s);
               }
               else
               {
                   e1.setText(e2.getText().toString());
               }

               flag=0;
                break;
        }
    }

    private void operationClicked(String op)
    {
            if (e2.length() != 0) {
                String text = e2.getText().toString();
                e1.setText(text + op);
                e2.setText("0");
            }
    }
}