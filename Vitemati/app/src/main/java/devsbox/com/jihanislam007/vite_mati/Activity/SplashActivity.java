package devsbox.com.jihanislam007.vite_mati.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import devsbox.com.jihanislam007.vite_mati.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_splash);
        setContentView(R.layout.custom_listview);

        /*Thread thread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(200);
                    Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };thread.start();*/

    }
}
