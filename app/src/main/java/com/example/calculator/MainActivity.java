package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.VolumeShaper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Integer> vals = new ArrayList<Integer>();
    Integer val;
    List<String> operation = new ArrayList<String>();
    String v="";

    TextView Txtvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Txtvalue = (TextView)findViewById(R.id.textvalue);
        operation.add("+");
    }

    void afficher(){
        Log.d("last",v);
        Txtvalue.setText(v);

    }

    public void setOperator(View view){
        vals.add(val);
        val=null;
        switch(view.getId()){
            case R.id.buttonplus : {
                operation.add("+");
                break;
            }
            case R.id.buttonMine : {
                operation.add("-");
                break;
            }
            case R.id.buttonMultiply : {
                operation.add("*");
                break;
            }
            case R.id.button1div : {
                operation.add("/");
                break;
            }
        }
        v+=operation.get(operation.size()-1);

        afficher();

    }

    public void ajouterNbr(View view){

        String BtnNumber = ((Button)view).getText().toString();
        v+=BtnNumber.toString();
        String Fullnumber = val!=null ? val + BtnNumber : BtnNumber;
        val=Integer.parseInt(Fullnumber);
        Log.d("entred number", val.toString());

        afficher();

    }

    public void clean(View view){
        Txtvalue.setText("0");
        v="";
        operation.clear();
        operation.add("+");
        vals.clear();
        val=null;

    }

    public void calculer(View view){
        vals.add(val);

        Integer res=0;
        int size = vals.size();
        String operator;
        for (int i=0;i<size;i++){

            operator= operation.get(i);
            Integer temp=(operator=="+" ||  operator=="-") ? 0 : 1;

            switch(operator){
                case "+" :{
                    temp+=vals.get(i);
                    break;
                }
                case "-" :{
                    temp-=vals.get(i);
                    Log.d("-temp",temp.toString());

                    break;
                }
                case "*" :{
                    temp*=vals.get(i);
                    Log.d("res",res.toString());
                    break;
                }
                case "/" :{
                    temp/=vals.get(i);
                    Log.d("res",res.toString());
                    break;
                }
            }
            res=(operator=="+" || operator=="-") ? res+temp : (operator=="*" ? res*temp : res/temp );

        }

        Log.d("vals",vals.toString());
        Log.d("operation",operation.toString());
        Log.d("Resultat",res.toString());

        Txtvalue.setText(res.toString());

    }
}