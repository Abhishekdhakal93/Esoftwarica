package com.abhi.esoftwarica.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abhi.esoftwarica.R;
import com.abhi.esoftwarica.controller.ControllerClass;
import com.abhi.esoftwarica.model.UserData;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText etname, etpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btnlogin);
        etname = findViewById(R.id.etName);
        etpassword = findViewById(R.id.etPW);


           /* @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_name_img.setImageResource(R.drawable.ic_check_box);
                } else if(start==0) {
                    log_name_img.setImageResource(R.drawable.ic_wrong_access);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        log_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_pass_img.setImageResource(R.drawable.ic_check_box);
                } else if(start==0) {
                    log_pass_img.setImageResource(R.drawable.ic_wrong_access);


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData dataSet = new UserData();
                if (!TextUtils.isEmpty(etname.getText().toString())) {
                    dataSet.setName(etname.getText().toString());
                    if (!TextUtils.isEmpty(etpassword.getText().toString())) {
                        dataSet.setPassword(etpassword.getText().toString());
                        boolean result = new ControllerClass().CheckUser(dataSet);
                        if (result) {
                            Intent intent = new Intent(MainActivity.this, MainWindow.class);
                            startActivity(intent);
                            etname.setText("");
                            etpassword.setText("");
                        } else {
                            Toast.makeText(MainActivity.this, "user name or password mistake", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        etpassword.setError("please enter password");

                    }
                } else {
                    etname.setError("please enter user name");

                }
            }
        });
    }
}
