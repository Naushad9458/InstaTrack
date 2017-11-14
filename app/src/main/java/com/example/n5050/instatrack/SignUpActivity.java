package com.example.n5050.instatrack;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText etPhone;
    ProgressDialog dialog;
    String otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button=(Button) findViewById(R.id.btnSignUpOtp);
        etPhone=(EditText)findViewById(R.id.etPhoneSignUp);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String url = Config.baseUrl + "signUpOtp.php";
        if(etPhone.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Please Enter Mobile Number",Toast.LENGTH_LONG).show();
        }else{
            dialog= ProgressDialog.show(SignUpActivity.this,"","Please Wait...",false,false);
            StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                        dialog.dismiss();
                        Intent intentConfirmOTP = new Intent(getApplicationContext(), SignUpOTP.class);
                        startActivity(intentConfirmOTP);
                        finish();
                    } else if (response.equals("fail")) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Some error occured", Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Check Your Internet connection", Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> param=new HashMap<>();
                    param.put("mobile",etPhone.getText().toString().trim());
                    return param;
                }
            };
            
        }




    }
}
