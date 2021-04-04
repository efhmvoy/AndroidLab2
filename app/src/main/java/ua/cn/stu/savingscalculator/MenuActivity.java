package ua.cn.stu.savingscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Button firstScreenButton = this.findViewById(R.id.firstScreenButton);
        Button exitButton = this.findViewById(R.id.exitButton);
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

