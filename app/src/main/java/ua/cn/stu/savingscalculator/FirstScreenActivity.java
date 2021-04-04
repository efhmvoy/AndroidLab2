package ua.cn.stu.savingscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FirstScreenActivity extends AppCompatActivity {

    private  static long  profitPerMonth;
    private static double monthPercentage;

    public static long  getProfitPerMonth() {
        return profitPerMonth;
    }

    public static double getMonthPercentage() {
        return monthPercentage;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstscreen_layout);

        EditText textView1 = this.findViewById(R.id.profitPerMonth);
        EditText textView2 = this.findViewById(R.id.monthPercentage);

        Button secondScreenButton = this.findViewById(R.id.secondScreenButton);

        secondScreenButton.setOnClickListener(v ->
        {
            if(textView1.getText().toString().isEmpty())
            {
                Toast.makeText(this,"Введіть дохід за місяць",Toast.LENGTH_SHORT).show();
            }
            else if (textView2.getText().toString().isEmpty())
            {
                Toast.makeText(this,"Введіть відсоток доходу",Toast.LENGTH_SHORT).show();
            }
            else if(Long.parseLong(textView1.getText().toString())>Integer.MAX_VALUE)
            {
                Toast.makeText(this,"Значення не може перевищувати "+String.valueOf(Integer.MAX_VALUE),Toast.LENGTH_SHORT).show();
            }
            else if(Double.parseDouble(textView2.getText().toString())>1)
            {
                Toast.makeText(this,"Відсоток доходу не може бути > 1",Toast.LENGTH_SHORT).show();
            }
            else
            {
                profitPerMonth =Integer.parseInt(textView1.getText().toString());

                monthPercentage = Double.parseDouble(textView2.getText().toString());
//zxc
                Intent intent = new Intent(this, SecondScreenActivity.class);
                startActivity(intent);
            }
        });
    }



}
