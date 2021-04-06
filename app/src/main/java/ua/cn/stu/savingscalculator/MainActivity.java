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


public class MainActivity extends AppCompatActivity implements TaskListener{
    App app;
    @Override
    protected void onStop() {
        super.onStop();
        app.removeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        app.addListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Button firstScreenButton = this.findViewById(R.id.firstScreenButton);
        Button exitButton = this.findViewById(R.id.exitButton);
            app = (App)getApplicationContext();
            Intent intent = new Intent(this, CalculationsService.class);
            intent.setAction(CalculationsService.DOWNLOAD_SERVICE);
            startService(intent);




        exitButton.setOnClickListener(v->
                {

                    System.exit (0);
                }
        );

        firstScreenButton.setOnClickListener(v->
                {

                    Intent intent1 = new Intent(this, FirstScreenActivity.class);
                    startActivity(intent1);

                }
        );
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onProgressChanged(int percents) {

    }
}
