package com.example.cobalogin_pert1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    KendaliLogin KL = new KendaliLogin();   //Pemanggilan class KendaliLogin
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username;
                String password;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

//                username = "AlbertusDwiAndhika";
//                password = "akuganteng";

                if (username.trim().equals("")) {
                    etUsername.setError("Username Tidak Boleh Kosong");
                }
                else if (password.trim().equals("")) {
                    etPassword.setError("Password Tidak Boleh Kosong");
                }
                else {
                    if (username.equals("albert") && password.equals("ggwahyu")) {
                        KL.setPref(LoginActivity.this, MainActivity.keySPusername, username);
                        KL.setPref(LoginActivity.this, MainActivity.keySPname, "Albertus Dwi Andhika"); //SP baru

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else if (username.equals("dhika") && password.equals("gggua")) {
                        KL.setPref(LoginActivity.this, MainActivity.keySPusername, username);
                        KL.setPref(LoginActivity.this, MainActivity.keySPname, "Andhika"); //SP baru

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}