package com.example.netbus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextEmail, editTextPassword, editTextNumber;
    private Button buttonRegister;

    private TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, HomeNav.class));
            return;
        }
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbarbg));
        }


        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);



        textViewLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        String c_username = editTextUsername.getText().toString();
        String c_password = editTextPassword.getText().toString();
        String c_email = editTextEmail.getText().toString();
        String c_number = editTextNumber.getText().toString();
        if (view == buttonRegister)
            if (c_username.isEmpty()) {
                editTextUsername.setError("Please Enter Username");
                editTextUsername.requestFocus();

            } else if (c_password.isEmpty()) {
                editTextPassword.setError("Please Enter Password");
                editTextPassword.requestFocus();
                return;
            } else if (c_email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(c_email).matches()) {
                editTextEmail.setError("Please Enter Valid Email");
                editTextEmail.requestFocus();
                return;
            } else if (c_number.isEmpty()||c_number.length()<10) {
                editTextNumber.setError("Please Enter Valid Number");
                editTextNumber.requestFocus();
                return;
            } else {


              Intent intent=new Intent(MainActivity.this,VerifyPhoneActivity.class);

                intent.putExtra("username",c_username);
                intent.putExtra("password",c_password);
                intent.putExtra("email",c_email);
                intent.putExtra("number",c_number);


                startActivity(intent);

            }

        if (view == textViewLogin)
            startActivity(new Intent(MainActivity.this, SignUp.class));
    }
}
