package com.example.cobalogin_pert1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvSesi;
    private Button btnLogout;
    //pemanggilan class KendaliLogin
    KendaliLogin KL = new KendaliLogin();
    public static String keySPusername = "bIAcdYKA35jzwZWga68sqQ==username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sesi;

        if (KL.isLogin(MainActivity.this, keySPusername) ==  true) {
            setContentView(R.layout.activity_main);

            sesi = KL.getPref(MainActivity.this, keySPusername);
            tvSesi = findViewById(R.id.tv_sesi);
            tvSesi.setText(sesi);
            btnLogout = findViewById(R.id.btn_logout);

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySPusername, null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });

        }
        else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}