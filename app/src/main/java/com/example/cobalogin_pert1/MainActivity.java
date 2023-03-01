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
    private TextView tvName;
    //pemanggilan class KendaliLogin
    KendaliLogin KL = new KendaliLogin();
    public static String keySPusername = "bIAcdYKA35jzwZWga68sqQ==username";
    public static String keySPname = "bIAcdYKA35jzwZWga68sqQ==name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sesi, name;

        if (KL.isLogin(MainActivity.this, keySPusername) ==  true) {
            setContentView(R.layout.activity_main);

            sesi = KL.getPref(MainActivity.this, keySPusername);
            name = KL.getPref(MainActivity.this,keySPname);

            tvSesi = findViewById(R.id.tv_sesi);
            tvSesi.setText(sesi);
            tvName = findViewById(R.id.tv_name);
            tvName.setText(name);

            btnLogout = findViewById(R.id.btn_logout);

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this, keySPusername, null);
                    KL.setPref(MainActivity.this, keySPname, null);

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