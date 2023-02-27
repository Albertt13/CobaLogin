package com.example.cobalogin_pert1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        if (KL.isLogin(MainActivity.this, keySPusername) ==  true) {
            setContentView(R.layout.activity_main);

            tvSesi = findViewById(R.id.tv_sesi);
            btnLogout = findViewById(R.id.btn_logout);
        }
        else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}