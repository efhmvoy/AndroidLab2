package ua.cn.stu.savingscalculator;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public  class CalculationsService  extends IntentService {

        public final String DOWNLOAD = "download";
    private  static List<Currency> currencyList = new ArrayList<>();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CalculationsService(String name) {
        super(name);
    }

    public  CalculationsService()
    {
        super(CalculationsService.class.getSimpleName());
    }


    public static  List<Currency> getCurrencylist()
    {
        return  currencyList;
    }

    public int getSy(int profitPerMonth)  //Гіпотетичний повний річний дохід у гривні (SY) без обміну валюти:
    {
        return profitPerMonth*12;
    }

   public double getSc() //Кількість гривень (Sc), витрачених на обмін валюти:
   {
       return getSy((int) FirstScreenActivity.getProfitPerMonth()) * FirstScreenActivity.getMonthPercentage();
   }

   public double getCi(int i, double Cstart, double Cend) // Інтерпольований курс
   {
        return  Cstart+ (i*((Cend-Cstart)/12));
   }

    public double getW (int currency) // Кількість валюти (W), придбаної за рік:
    {

            Currency currency1 = getCurrencylist().get(currency);
        double sum=0;
        for(int i=1;i<=12;i++)
        {
            sum+= (FirstScreenActivity.getProfitPerMonth()* FirstScreenActivity.getMonthPercentage())/getCi(i,currency1.getcStart(),currency1.getcEnd());
        }
        return  sum;

    }

    public double getSh(int currency)  // Гривнева вартість придбаної валюти (SH) на кінець року:
    {
        Currency currency1 = getCurrencylist().get(currency);
        return  getW(currency)*currency1.getcEnd();
    }

    public double getSl() // ) Гривневий залишок (SL):
    {
        return  getSy((int) FirstScreenActivity.getProfitPerMonth())-getSc();
    }

    public double getH(int currency)
    {

        return getSh(currency) +getSl();
    }


    public void readFile()
    {
        App app = (App) getApplication();
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
                app.publishProgress(100);
                app.publishCompleted();
            }
        } catch (IOException e) {
            //log the exception
        }

    }
    @Override
    public void onCreate() {

        super.onCreate();
        App app= (App)getApplication();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public double getR(int currency)
    {
        return  getH(currency)-getSy((int) FirstScreenActivity.getProfitPerMonth());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        if(action.equals(DOWNLOAD))
        {
            readFile();
        }

    }
}

