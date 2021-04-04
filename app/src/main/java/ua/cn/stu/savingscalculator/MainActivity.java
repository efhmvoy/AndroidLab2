package ua.cn.stu.savingscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Button firstScreenButton = this.findViewById(R.id.firstScreenButton);
        Button exitButton = this.findViewById(R.id.exitButton);
        String mLine = "";
        Scanner reader = null;
        String currencyName="zxc" ;
        String cStart;
        String cEnd;
        try {
            reader = new Scanner(
                    new InputStreamReader(getAssets().open("zxc.txt")));
            reader.useDelimiter(",");

            while (reader.hasNext()) {
                currencyName=reader.next();
                cStart=reader.next();
                cEnd=reader.next();
                CalculationsService.getCurrencylist().add(new Currency(currencyName,Double.parseDouble(cStart),Double.parseDouble(cEnd)));
                Log.d("zxc",currencyName);
            }
        } catch (IOException e) {
            //log the exception
        }


        exitButton.setOnClickListener(v->
                {

                    System.exit (0);
                }
        );

        firstScreenButton.setOnClickListener(v->
                {

                    Intent intent = new Intent(this, FirstScreenActivity.class);
                    startActivity(intent);

                }
        );
    }
    }
