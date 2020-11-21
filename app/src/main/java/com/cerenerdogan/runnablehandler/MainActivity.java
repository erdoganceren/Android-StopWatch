package com.cerenerdogan.runnablehandler;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int number;
    Button button;
    //İstediğimiz delayda istediğimiz kadar işlemi arka planda çalıştırabilmek için kullanıyoruz.
    Runnable runnable; //Bir işlemi birden fazla kez belirttiğimiz sayıda veya periyotta yapmamıza olanak sağlayan bir arayüz.
    Handler handler; //Runnable'ı ele aldığımız bir arayüz. Runnable veya message'lerle çalışmamıza olanak sağlayan bir arayüz.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        number = 0;
    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //Burada yazdığım her sey benim belirttiğim periyot içerisinde olacaktır.
                textView.setText("Time: " + number);
                number++;
                textView.setText("Time: " + number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);



    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Time: " + number);
    }

}