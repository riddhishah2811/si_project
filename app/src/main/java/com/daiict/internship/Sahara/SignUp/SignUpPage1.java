package com.daiict.internship.Sahara.SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpPage1 extends AppCompatActivity {

    TextInputLayout textInputLayout_ngo;
    String get_category;
    String E_mail,password;

    //private FirebaseAuth mAuth;
    TextInputEditText email,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1);
        viewVisibility();

        //mAuth = FirebaseAuth.getInstance();

        email=findViewById(R.id.txtv_signup_first_email);
        pass=findViewById(R.id.txtv_signup_first_pass);



    }

    public void backBtnSignUpF(View view) {
        Intent intent = new Intent(this, LoginSignUpDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    public void loginBtnSignUpF(View view) {
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void nextBtnSignUpF(View view) {

        E_mail=email.getText().toString().trim();
        password=pass.getText().toString().trim();

        if(E_mail.isEmpty())
        {
            email.setError("E-mail is required!");
            email.requestFocus();
            startActivity(getIntent());
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(E_mail).matches())
        {
            email.setError("Please enter a valid email address.");
            email.requestFocus();
            startActivity(getIntent());
            return;
        }

        if(password.isEmpty())
        {
            pass.setError("Password is required!");
            pass.requestFocus();
            startActivity(getIntent());
            return;
        }

        if(password.length()<6)
        {
            pass.setError("Minimum length of password should be 6.");
            pass.requestFocus();
            startActivity(getIntent());
            return;
        }

        Intent intent = new Intent(this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);
        intent.putExtra("Email",E_mail);
        intent.putExtra("Pass",password);

        startActivity(intent);

//        mAuth.createUserWithEmailAndPassword(E_mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//
//                if(task.isSuccessful())
//                {
//                    Toast.makeText(getApplicationContext(),"Go to the next Page",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"Some error occur!",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    private void viewVisibility() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");

        textInputLayout_ngo = findViewById(R.id.txtlayout_signup_first_ngo);


        if (get_category.equalsIgnoreCase("volunteer")) {

        } else if (get_category.equalsIgnoreCase("ngo")) {
            textInputLayout_ngo.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {

        } else {

        }
    }
}