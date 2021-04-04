package ua.cn.stu.savingscalculator;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ThirdScreenActivity extends AppCompatActivity {
    private  CalculationsService calculationsService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdscreen_layout);
        TextView Sy = this.findViewById(R.id.Sy);
        TextView Sc = this.findViewById(R.id.Sc);
        TextView W = this.findViewById(R.id.W);
        TextView Sh = this.findViewById(R.id.Sh);
        TextView Sl = this.findViewById(R.id.Sl);
        TextView H = this.findViewById(R.id.H);
        TextView r = this.findViewById(R.id.R);

        CalculationsService calculations = new CalculationsService("zxc");
        Intent intent = new Intent(this,CalculationsService.class);


        Sy.setText(String.valueOf(Math.round(calculations.getSy((int) FirstScreenActivity.getProfitPerMonth()))));
        Sc.setText(String.valueOf(Math.round(calculations.getSc())));
        W.setText(String.valueOf(Math.round(calculations.getW(SecondScreenActivity.getSelectedCurrency()))));
        Sh.setText(String.valueOf((Math.round(calculations.getSh(SecondScreenActivity.getSelectedCurrency())))));
        Sl.setText(String.valueOf(Math.round(calculations.getSl())));
        H.setText(String.valueOf(Math.round(calculations.getH(SecondScreenActivity.getSelectedCurrency()))));
        r.setText(String.valueOf(Math.round(calculations.getR(SecondScreenActivity.getSelectedCurrency()))));
        Button OKButton = this.findViewById(R.id.OKButton);
        OKButton.setOnClickListener(v ->
                {
                    Intent intent1 = new Intent(this, MenuActivity.class);
                    startActivity(intent1);
                }
        );
    }
}

