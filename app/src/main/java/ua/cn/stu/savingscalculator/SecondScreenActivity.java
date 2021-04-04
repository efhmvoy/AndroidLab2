package ua.cn.stu.savingscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SecondScreenActivity extends AppCompatActivity {

    public static int getSelectedCurrency() {
        return selectedCurrency;
    }

    private static int selectedCurrency;
    private final List<String> currencyList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen_layout);
        currencyList.add("USD");
        currencyList.add("EUR");
        Spinner currencySpinner = this.findViewById(R.id.currencySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(currencyList));
        currencySpinner.setAdapter(adapter);
        Button thirdScreenButton = this.findViewById(R.id.thirdScreenButton);
        thirdScreenButton.setOnClickListener(v->
                {
                    selectedCurrency = currencySpinner.getSelectedItemPosition();
                    Intent intent = new Intent(this, ThirdScreenActivity.class);
                    startActivity(intent);

                }
        );
    }


}
