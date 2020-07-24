package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;

public class SignUpPage2 extends AppCompatActivity {

    String get_category;
    String E_mail,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2);
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");
        E_mail=intent.getStringExtra("Email");
        password=intent.getStringExtra("Pass");
    }

    public void backBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        startActivity(intent);
        finish();
    }

    public void nextBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);
        intent.putExtra("Pass",password);
        intent.putExtra("Email",E_mail);
        startActivity(intent);
    }
}
