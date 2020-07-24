package com.daiict.internship.Sahara.SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpPage3 extends AppCompatActivity {

    String get_category;
    String E_mail,password;
    TextInputLayout inputLayout_ngo_members;
    Switch aSwitch_worksfor;
    LinearLayout linearLayout_volunteer_gender, linearLayout_volunteer_type;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3);
        viewVisibility();
        mAuth = FirebaseAuth.getInstance();

    }

    public void backBtnSignUpT(View view) {
        Intent intent = new Intent(this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    public void nextBtnSignUpT(View view) {

    }

    private void viewVisibility() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");
        E_mail=intent.getStringExtra("Email");
        password=intent.getStringExtra("Pass");

        aSwitch_worksfor = findViewById(R.id.switch_signup_third_works_with);

        linearLayout_volunteer_gender = findViewById(R.id.linearlayout_signup_third_gender);
        linearLayout_volunteer_type = findViewById(R.id.linearlayout_signup_third_volunteer);
        inputLayout_ngo_members = findViewById(R.id.txtlayout_signup_third_ngo);


        if (get_category.equalsIgnoreCase("volunteer")) {
            aSwitch_worksfor.setVisibility(View.VISIBLE);
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
            linearLayout_volunteer_type.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(E_mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(),"Sign-Up Successful.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Some error occur!",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            intent = new Intent(this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        } else if (get_category.equalsIgnoreCase("ngo")) {
            inputLayout_ngo_members.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {

        } else {

        }
    }
}
